package com.sunrun.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sunrun.entity.DevExclusiveSwitchboardInfo;
import com.sunrun.entity.DevOnlineTask;
import com.sunrun.entity.DevTaskExecute;
import com.sunrun.entity.UserBean;
import com.sunrun.entity.view.DevOnlineBatchTaskView;
import com.sunrun.service.AddSwitchDeviceService;
import com.sunrun.service.DeviceAutomationService;
import com.sunrun.task.AddSwitchDevice;
import com.sunrun.util.Json;
import com.sunrun.util.StringUtil;

/**
 * 交换机自动化控制器层
 * @author ymg
 *
 */
@RestController
public class DeviceAutomatinoController extends BaseController{
	private static final Logger logger = LoggerFactory.getLogger(DeviceAutomatinoController.class);
	
	@Resource
	private DeviceAutomationService deviceAutomationService;
	@Resource
	private AddSwitchDeviceService addSwitchDeviceService;
	
	@Value("${sr_public.thirdPartUrl}")
	private String thirdPartUrl;
	
	@Value("${itil.wsURL}")
	private String itil;
	
	@Value("${sr_public.sendEmail}")
	private String sendEmail;
	
	
	/**
	 * 添加上线交换机设备
	 * @param jsonStr	json格式的请求参数字符串
	 * @param auth		Authorization认证参数
	 * @param response	response响应对象
	 * @param request	request请求对象
	 * @return			返回json格式的字符串
	 */
	@RequestMapping(value = "/deviceAutomation/v1/addSwitchDevice", method = RequestMethod.POST, produces="application/json", consumes="application/json")
	public void addSwitchDevice(HttpServletRequest request, HttpServletResponse response,
								@RequestBody String jsonStr, @RequestHeader("Authorization") String auth){
		Json json = new Json();
		String info = "添加交换机设备成功";
		Integer code = 201;	//201:用户新建或修改数据成功
		Boolean success = true;
		logger.info("添加上线交换机设备addSwitchDevice接口入参是："+jsonStr);
		
		try{
			JSONObject obj = JSONObject.parseObject(jsonStr);
			String userName = obj.getString("userName");
			String updateUser = obj.getString("updateUser");
			String usercode = obj.getString("usercode");
			String brandName = obj.getString("brandName");
			String modelName = obj.getString("modelName");
			String areaName = obj.getString("areaName");
			String areaDescribe = obj.getString("areaDescribe");
			String devOnlineRack = obj.getString("devOnlineRack");
			String hostName = obj.getString("hostName");
			String mainSwitchboardIp = obj.getString("mainSwitchboardIp");
			String backupSwitchboardIp = obj.getString("backupSwitchboardIp");
			DevOnlineTask task = new DevOnlineTask();
			task.setBrandName(brandName);
			task.setModelName(modelName);
			task.setAreaName(areaName);
			task.setAreaDescribe(areaDescribe);
			task.setDevOnlineRack(devOnlineRack);
			task.setHostName(hostName);
			task.setMainSwitchboardIp(mainSwitchboardIp);
			task.setBackupSwitchboardIp(backupSwitchboardIp);
			task.setSwitchState(1);
			task.setState(1);
			task.setCreate_user(userName);
			task.setUserName(userName);
			task.setUsercode(usercode);
			task.setTaskState(2);
			String uuid = StringUtil.getUuid();
			task.setId(uuid);
			json = addSwitchDeviceService.saveDeviceBaseInfo(task, userName);
			code = json.getRet_code();
			info = json.getRet_info();
			success = json.getSuccess();
			
			if(success){
				//先保存这条数据的基本信息，然后分线程去执行剩下的步骤
				AddSwitchDevice addSwitchDevice = new AddSwitchDevice(deviceAutomationService, addSwitchDeviceService, thirdPartUrl, auth, task, userName, usercode);
				Thread t = new Thread(addSwitchDevice);
		        t.start();
			}
			
		}catch(Exception e){
			e.printStackTrace();
			info = "添加交换机设备出错了";
			code = 500;
			success = false;
			logger.error(info);
		}finally{
			json.setRet_code(code);
			json.setRet_info(info);
			json.setSuccess(success);
			//返回数据
			response(json, response, request);
		}
		
	} 
	
	
	
	/**
	 * 查询批次任务
	 * @param request		
	 * @param batchId		批次ID(可选参数，暂时没用到)
	 * @param batchState	批次状态（1或者2：未完成；3：已经完成。可选参数，不传递就是查询所有状态的，传递了就是查询具体状态的）
	 * @param switchState	设备添加状态 1：设备准备；2：汇聚设备配制；3：异常工单;4:成功工单 
	 * @param taskId		任务id,(参数可选)
	 * @param executeStep	任务步骤（参数可选.如要查询itil任务列表，则必须传入此参数值为：0）
	 * 
	 * 类似下面几个参数基本上用不到了（现在和前端默认是不带分页，把所有数据返回）
	 * @param like			模糊查询值/搜索值
	 * @param sortBy		排序值（根据哪个属性排序）
	 * @param order			排序方式（desc,asc）
	 * @param currentPage	当前第几页
	 * @param pageSize		每页记录数
	 * @return				返回json字符串
	 */
	@RequestMapping(value = "/deviceAutomation/v1/findSwitchDevice", method = RequestMethod.GET, produces="application/json")
	public void findSwitchDevice(HttpServletRequest request, HttpServletResponse response,
								@RequestParam(value = "taskId", required = false) String taskId,
								@RequestParam(value = "execute_step", required = false) Integer executeStep,
								@RequestParam(value = "switchState", required = false) Integer switchState,
								@RequestParam(value = "batchState", required = false) Integer batchState,
								@RequestParam(value = "batchId", required = false) String batchId,
								@RequestParam(value = "like", required = false) String like, 
								@RequestParam(value = "sortBy", required = false) String sortBy, 
								@RequestParam(value = "order", required = false) String order, 
								@RequestParam(value = "currentPage", required = false, defaultValue = "0") Integer currentPage,
								@RequestParam(value = "pageSize", required = false, defaultValue = "0") Integer pageSize){
		Json json = new Json();
		String info = "查询批次任务交换机设备成功";
		Integer code = 200;	//200:用户查询数据成功
		Boolean success = true;
		logger.info("查询task任务findSwitchDevice接口入参是:"+ request.getQueryString());
		try{
			List<DevOnlineBatchTaskView> list = new ArrayList<DevOnlineBatchTaskView>();
			DevOnlineBatchTaskView batchView = new DevOnlineBatchTaskView();
			if(executeStep==null || executeStep==0){	//查询ITIL任务列表
				if(batchState!=null){
					batchView.setBatchState(batchState); 
				}
				if(switchState!=null){	//设备添加状态 1：设备准备；2：汇聚设备配制；3：异常工单;4:成功工单 
					batchView.setSwitchState(switchState); 
				}
				
			}else{	//查询任务具体信息
				if(taskId!=null && !"".equals(taskId) && executeStep!=null && executeStep!=0){
					batchView.setId(taskId);
					batchView.setExecuteStep(executeStep); 
				}
			}
			list = deviceAutomationService.findDevBatchTask(batchView, like, sortBy, order, page(currentPage, pageSize));
			Integer total = deviceAutomationService.countDevBatchTask(batchView, like, sortBy, order);
			Map<Object, Object> collect = new HashMap<Object, Object>();
			collect.put("total", total);
			collect.put("pagesize", setPageSize(currentPage, pageSize, list));
			json.setCollect(collect);
			json.setData(list);
			
		}catch(Exception e){
			e.printStackTrace();
			info = "查询批次任务交换机设备出错";
			code = 500;
			success = false;
			logger.error(info);
		}
		json.setRet_code(code);
		json.setRet_info(info);
		json.setSuccess(success);
		//返回数据
		response(json, response, request);
	}
	
	
	/**
	 * 删除交换机设备
	 * @param jsonStr	json格式的请求参数字符串
	 * @param auth		Authorization认证参数
	 * @param request	request请求对象
	 * @return			返回json格式的字符串
	 */
	@RequestMapping(value = "/deviceAutomation/v1/deleteSwitchDevice", method = {RequestMethod.POST, RequestMethod.DELETE}, produces="application/json", consumes="application/json")
	public void deleteSwitchDevice(@RequestBody String jsonStr, @RequestHeader("Authorization") String auth, HttpServletRequest request,HttpServletResponse response){
		Json json = new Json();
		String info = "删除成功";
		Integer code = 201;	//201:用户新建或修改数据成功
		Boolean success = true;
		logger.info("删除交换机设备deleteSwitchDevice接口入参是："+jsonStr);
		JSONObject obj = JSONObject.parseObject(jsonStr);
		String updateUser = obj.getString("updateUser");
		String usercode = obj.getString("usercode");
		String taskId = obj.getString("taskId");		//任务Id
		List<DevOnlineTask> l = deviceAutomationService.findPort(taskId);
		if(l!=null && l.size()>0 && l.get(0).getTaskState()==2){
			json.setRet_code(401);
			json.setRet_info("后台正在执行，请勿删除");
			json.setSuccess(false);
			response(json, response, request);
			return;
		}
		try{
			//删除任务
			if(!StringUtils.isEmpty(taskId)){
				//回填从看板申请回来的ip状态，state=2：回收，第三方系统放弃使用该ip，IP状态由“预占用”改为“未分配”
				if(l!=null && l.size()>0){
					 Map<String, String> map = new HashMap<String, String>();
					 map.put("ip", l.get(0).getManagerIp());
					addSwitchDeviceService.adminRequestIP(thirdPartUrl, auth, l.get(0), map, updateUser, 2, usercode);
					
					if(!StringUtils.isEmpty(l.get(0).getExclusiveSwitchboardIp()) && !StringUtils.isEmpty(l.get(0).getExclusiveSwitchboardPort())){
						//将kvm端口释放
						DevExclusiveSwitchboardInfo in = new DevExclusiveSwitchboardInfo();
						in.setExclusiveSwitchboardIp(l.get(0).getExclusiveSwitchboardIp());
						in.setExclusiveSwitchboardPort(l.get(0).getExclusiveSwitchboardPort());
						in.setExclusiveSwitchboardPortState(0);
						deviceAutomationService.updateDevExclusiveSwitchboardInfo(in);
					}
				}
				success = deviceAutomationService.deleteTask(taskId);
				if(!success){
					code = 500;
					info = "删除出错";
					success = false;
				}
			}else{
				json.setRet_code(400);
				json.setRet_info("缺少参数");
				json.setSuccess(false);
				json.setData(null);
				//返回数据
				response(json, response, request);
				return;
			}
			
		}catch(Exception e){
			code = 500;
			info = "删除出错";
			success = false;
			logger.error("删除出错");
			e.printStackTrace();
		}
		json.setRet_code(code);
		json.setRet_info(info);
		json.setSuccess(success);
		//返回数据
		response(json, response, request); 
	}
	
	/**
	 * 执行上线交换机
	 * @param jsonStr
	 * @param auth
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/deviceAutomation/v1/executeSwitchDevice", method = {RequestMethod.POST}, produces="application/json", consumes="application/json")
	public void executeSwitchDevice(@RequestBody String jsonStr, @RequestHeader("Authorization") String auth, 
									HttpServletRequest request,HttpServletResponse response){
		Json json = new Json();
		String info = "将进入后台执行";
		Integer code = 201;	//201:用户新建或修改数据成功
		Boolean success = true;
		logger.info("执行上线交换机executeSwitchDevice接口入参是："+jsonStr);
		try{
			JSONObject obj = JSONObject.parseObject(jsonStr);
			DevOnlineTask task = new DevOnlineTask();
			int switchState = obj.getIntValue("switchState");
			String taskId = obj.getString("taskId");
			String usercode = obj.getString("usercode");//用户编号：如 ：01091231
			String updateUser = obj.getString("updateUser");
			String userName = obj.getString("userName");

			//查询出该任务执行到第几步骤 然后分多线程继续执行之后的步骤（写入接入交换机配置管理口ip、更新ios版本、写入接入交换机配置信息）
			Integer executeStep = null;
			List<DevOnlineTask> l = deviceAutomationService.findPort(taskId);
			if(l!=null && l.size()>0){
				task = l.get(0);
			}
			List<DevTaskExecute> li = deviceAutomationService.findTaskExecute(taskId, "execute_step");
			if(li!=null && li.size()>0){
				executeStep = li.get(0).getExecuteStep();
				Integer executeState = li.get(0).getTaskExecuteState();
				if(executeState==3){	//3:成功，就要从下一步开始
					executeStep += 1;
				}
			}
			if(task.getTaskState()==2){
				json.setRet_code(200);
				json.setRet_info("后台正在执行...");
				json.setSuccess(false);
				//返回数据
				response(json, response, request); 
				return;
			}
			if(switchState==1 || switchState==3){
				String vlan = obj.getString("vlan");
				String exclusiveSwitchboardIp = obj.getString("exclusiveSwitchboardIp");
				String exclusiveSwitchboardPort = obj.getString("exclusiveSwitchboardPort");
				String exclusiveSwitchboardOrder = obj.getString("exclusiveSwitchboardOrder");
				String brandName = obj.getString("brandName");
				String modelName = obj.getString("modelName");
				String currentIosVersion = obj.getString("currentIosVersion");
				String exclusiveSwitchboardInfo = "";
				if(!StringUtils.isEmpty(exclusiveSwitchboardOrder) && !StringUtils.isEmpty(brandName) && !StringUtils.isEmpty(modelName))
					exclusiveSwitchboardInfo = "第"+exclusiveSwitchboardOrder+"口-"+brandName+"-"+modelName;
				
				task.setSwitchState(switchState);
				if(!StringUtils.isEmpty(vlan))
					task.setVlan(vlan);
				if(!StringUtils.isEmpty(taskId))
					task.setId(taskId);
				if(!StringUtils.isEmpty(exclusiveSwitchboardIp))
					task.setExclusiveSwitchboardIp(exclusiveSwitchboardIp);
				if(!StringUtils.isEmpty(exclusiveSwitchboardPort))
					task.setExclusiveSwitchboardPort(exclusiveSwitchboardPort);
				if(!StringUtils.isEmpty(exclusiveSwitchboardOrder) && !StringUtils.isEmpty(brandName) && !StringUtils.isEmpty(modelName))
					task.setExclusiveSwitchboardInfo(exclusiveSwitchboardInfo);
				if(!StringUtils.isEmpty(currentIosVersion))
					task.setCurrentIosVersion(currentIosVersion);
				task.setUpdate_user(updateUser);
				
				AddSwitchDevice addTask = new AddSwitchDevice(deviceAutomationService, addSwitchDeviceService, thirdPartUrl, auth, task, updateUser, executeStep, usercode); 
				Thread t = new Thread(addTask);
				t.start();
				
			}else if(switchState==2){
				//当点击执行（写入汇聚配置）时候，必要要求工单状态是‘实施’；且当前时间大于等于工单计划开始时间,且在晚上19:00后；
				DevOnlineBatchTaskView batchView = new DevOnlineBatchTaskView();
				batchView.setId(task.getId());
				long i = System.currentTimeMillis();
				List<DevOnlineBatchTaskView> views = deviceAutomationService.findDevBatchTask(batchView, null, null, null, null);
				DevOnlineBatchTaskView view = views.get(0);
				//SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
				SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm");
				Date d = null;
				if(view!=null && !view.getItilPlannedStart().equals("") && view.getItilPlannedStart()!=null){
					d = fmt.parse(view.getItilPlannedStart());
				}
				
				if(view==null || StringUtils.isEmpty(view.getItilNumber()) || !view.getItilStatus().trim().contains("已批准") ){
					code = 500;
					info = "itil工单未审批";
					success = false;
				}else if(d.getTime()<i || d.getHours()<19){
					code = 500;
					success = false;
					info = "未到时候执行，请在"+view.getItilPlannedStart()+"后执行";
				}else if(StringUtils.isEmpty(view.getEmailId())){
					code = 500;
					info = "请发送下邮件通知再执行";
					success = false;
				}else{
					AddSwitchDevice addTask = new AddSwitchDevice(deviceAutomationService, addSwitchDeviceService, thirdPartUrl, auth, task, updateUser, executeStep, usercode); 
					Thread t = new Thread(addTask);
					t.start();
				}
			}
		}catch(Exception e){
			code = 500;
			success = false;
			info = "执行上线交换机出错";
			logger.error("执行上线交换机出错");
			e.printStackTrace();
		}
		json.setRet_code(code);
		json.setRet_info(info);
		json.setSuccess(success);
		//返回数据
		response(json, response, request);
	}
	
	/**
	 * 上线交换机ITIL工单
	 * @param jsonStr
	 * @param auth
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/deviceAutomation/v1/switchDeviceITIL", method = {RequestMethod.POST}, produces="application/json", consumes="application/json")
	public void switchDeviceITIL(@RequestBody String jsonStr, @RequestHeader("Authorization") String auth, HttpServletRequest request,HttpServletResponse response){
		Json json = new Json();
		logger.info("上线交换机ITIL工单switchDeviceITIL接口入参是："+jsonStr);
		try{
			JSONObject obj = JSONObject.parseObject(jsonStr);
			String itilPlannedEnd = obj.getString("itilPlannedEnd");
			String itilPlannedStart = obj.getString("itilPlannedStart");
			String updateUser = obj.getString("updateUser");
			String userName = obj.getString("userName");
			String usercode = obj.getString("usercode");	
			JSONArray j = obj.getJSONArray("taskId");
			List<String> l = com.alibaba.fastjson.JSONArray.parseArray(j.toString(), String.class);
			String[] a = new String[l.size()];
			String[] taskId = l.toArray(a);
			
			json = addSwitchDeviceService.switchDeviceITIL(itil, itilPlannedEnd, itilPlannedStart, taskId, userName, usercode);
			
		}catch(Exception e){
			logger.error("接口程序出错");
			json.setRet_code(500);
			json.setRet_info("申请工单出现异常");
			json.setSuccess(false);
			e.printStackTrace();
		}
		//返回数据
		response(json, response, request); 
	}
	
	/**
	 * 上线交换机邮件发送接口
	 * @param jsonStr
	 * @param auth
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/deviceAutomation/v1/sendEmailswitchDevice", method = {RequestMethod.POST}, produces="application/json", consumes="application/json")
	public void sendEmailswitchDevice(@RequestBody String jsonStr, @RequestHeader("Authorization") String auth, HttpServletRequest request,HttpServletResponse response){
		Json json = new Json();
		String info = "上线交换机邮件发送成功";
		Integer code = 200;	//200
		Boolean success = true;
		Map<String, Object> data = new HashMap<String, Object>();
		logger.info("上线交换机邮件发送sendEmailswitchDevice接口入参是："+jsonStr);
		try{
			JSONObject obj = JSONObject.parseObject(jsonStr);
			JSONArray arr = obj.getJSONArray("taskId");
			List<String> l = com.alibaba.fastjson.JSONArray.parseArray(arr.toString(), String.class);
			String[] a = new String[l.size()];
			String[] taskId = l.toArray(a);
			String title = obj.getString("mailTitle");
			String content = obj.getString("mailContxt");
			JSONArray array = obj.getJSONArray("mailConsignee");
			String userName = obj.getString("email");
			String emails = "";//收件人邮箱
			String names = "";
			for(int i=0;i<array.size();i++){
				JSONObject j = (JSONObject) array.get(i);
				String name = j.getString("mailConsigneeName");
				String email = j.getString("mailConsigneeEmail");
				emails += email+",";
				//names += name+",";
				names += email.substring(0, email.indexOf("@")) + ",";
			}
			
			//调用sr_public工程发送邮件通过接口方法
			Json j = addSwitchDeviceService.SendEmailswitchDevice(sendEmail, auth, taskId, emails.substring(0, emails.length()-1), names.substring(0, names.length()-1), title, content, userName);
			code = j.getRet_code();
			info = j.getRet_info();
			success = j.getSuccess();
			
		}catch(Exception e){
			code = 500;
			success = false;
			info = "上线交换机邮件发送出错";
			logger.error("上线交换机邮件发送出错");
			e.printStackTrace();
		}
		json.setRet_code(code);
		json.setRet_info(info);
		json.setSuccess(success);
		json.setData(data);
		//返回数据
		response(json, response, request); 
	}
	
	/**
	 * 上线交换机生成邮件内容接口
	 * @param jsonStr
	 * @param auth
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/deviceAutomation/v1/addEmailswitchDeviceEmail", method = {RequestMethod.GET}, produces="application/json")
	public void addEmailswitchDeviceEmail(@RequestParam(value = "taskId", required = false) String taskId, HttpServletRequest request,HttpServletResponse response){
		logger.info("上线交换机生成邮件内容接口入参是："+taskId);
		Json json = new Json();
		String info = "上线交换机生成邮件内容成功";
		Integer code = 200;	//200
		Boolean success = true;
		Map<String, Object> data = new HashMap<String, Object>();
		if(StringUtils.isEmpty(taskId)){
			json.setRet_code(400);
			json.setRet_info("缺少参数");
			json.setSuccess(false);
			json.setData(null);
			//返回数据
			response(json, response, request);
			return;
		}
		try{
			if(!StringUtils.isEmpty(taskId)){
				String[] ids = taskId.split(",");	//多个taskId用英文逗号隔开
				String content = deviceAutomationService.concatDeviceInfo(ids);
				SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				data.put("mailTitle","设备自动化上线连接信息-"+fmt.format(new Date()));
				data.put("mailContxt", content.replace("null", ""));
				
				List<Object> l = new ArrayList<Object>();
				UserBean user = new UserBean();
				user.setSendEmail(1);
				List<UserBean> users = deviceAutomationService.findUser(user);
				for(int i=0;i<users.size();i++){
					JSONObject o = new JSONObject();
					o.put("mailConsigneeName", users.get(i).getUserName());
					o.put("mailConsigneeEmail", users.get(i).getEmail());
					o.put("mailConsigneeSelected", users.get(i).getSendEmail());
					l.add(o);
				}
				/*JSONObject o = new JSONObject();
				o.put("mailConsigneeName", "xubocmb");
				o.put("mailConsigneeEmail", "xubocmb@cmbchina.com");
				o.put("mailConsigneeSelected", 1);
				l.add(o);*/
				data.put("mailConsignee", l);	//收件者的邮箱信息 暂时待定？？？
			}
			
		}catch(Exception e){
			code = 500;
			success = false;
			info = "上线交换机生成邮件内容出错";
			logger.error("上线交换机生成邮件内容出错");
			e.printStackTrace();
		}
		List<Object> li = new ArrayList<Object>();
		li.add(data);
		json.setRet_code(code);
		json.setRet_info(info);
		json.setSuccess(success);
		json.setData(li);
		//返回数据
		response(json, response, request); 
	}
	
	
	/**
	 * kvm接口所对应的设备型号信息接口
	 * @param request
	 * @param response
	 * @param exclusiveSwitchboardIp	带外交换机IP
	 * @param exclusiveSwitchboardPort 带外交换机端口
	 * @param model	设备型号
	 */
	@RequestMapping(value = "/v1/thirdparty/kvmInfo", method = RequestMethod.GET, produces="application/json")
	public void kvmInfo(HttpServletRequest request, HttpServletResponse response,  @RequestHeader("Authorization") String auth,
						@RequestParam(value = "exclusiveSwitchboardIp", required = false) String exclusiveSwitchboardIp,
						@RequestParam(value = "exclusiveSwitchboardPort", required = false) String exclusiveSwitchboardPort,
						@RequestParam(value = "model", required = false) String model,
						@RequestParam(value = "brandName", required = false) String brandName){
		Json json = new Json();
		logger.info("kvm接口所对应的设备型号信息kvmInfo接口入参是："+request.getQueryString());
		if(StringUtils.isEmpty(model)){
			json.setRet_code(400);
			json.setRet_info("缺少请求参数");
			json.setSuccess(false);
			response(json, response, request);
			return;
		}
		try{
			DevExclusiveSwitchboardInfo bean = new DevExclusiveSwitchboardInfo();
			bean.setExclusiveSwitchboardIp(exclusiveSwitchboardIp);
			bean.setExclusiveSwitchboardPort(exclusiveSwitchboardPort);
			json = deviceAutomationService.findKvmInfo2(bean, model, thirdPartUrl, auth);
		}catch(Exception e){
			e.printStackTrace();
			logger.error(json.getRet_info());
			json.setRet_code(500);
			json.setRet_info("获取kvm接口所对应的设备型号信息出错了");
			json.setSuccess(false);
		}
		//返回数据
		response(json, response, request);
	}
	
	/**
	 * ios版本回调
	 * @param request
	 * @param response
	 * @param jsonStr
	 * @param auth
	 */
	@RequestMapping(value = "/deviceAutomation/v1/callbackIosInfo", method = RequestMethod.POST, consumes="application/json", produces="application/json")
	public void callbackIosinfo(HttpServletRequest request, HttpServletResponse response,@RequestBody String jsonStr, @RequestHeader("Authorization") String auth){
		Json json = new Json();
		logger.info("ios版本回调callbackIosInfo接口入参是："+jsonStr);
		try{
			JSONObject obj = JSONObject.parseObject(jsonStr);
			Integer code = obj.getIntValue("ret_code");
			String info = obj.getString("ret_info");
			String taskId = obj.getString("taskId");
			logger.info("ios版本回调入参事："+jsonStr.toString());
			
			DevOnlineTask task = new DevOnlineTask();
			task.setId(taskId);
			task.setAccessVersionWrite(code==201 ? 1 : 2);
			
			DevTaskExecute execute = new DevTaskExecute();
			execute.setId(StringUtil.getUuid());
			execute.setTaskId(task.getId());
			execute.setExecuteStep(8);
			execute.setTaskOrder(8);
			execute.setTaskDescribe(code==201 ? "ios版本回调成功,升级完成" : "ios版本回调失败,升级失败"); 
			execute.setTaskExecuteState(code==201 ? 3 : 4);
			execute.setCreate_user("");
			execute.setTaskExecuteNote(null);
			deviceAutomationService.updateTask2(task, execute, 8, "");
			
			json.setRet_code(201);
			json.setRet_info("ios版本回调成功");
			
			//回调后写入接入交换机配置
			List<DevOnlineTask> li = deviceAutomationService.findPort(task.getId());
			task = null;
			task = li.get(0);
			AddSwitchDevice addTask = new AddSwitchDevice(deviceAutomationService, addSwitchDeviceService, thirdPartUrl, auth, task, task.getUpdate_user(), 9, task.getUsercode()); 
			Thread t = new Thread(addTask);
			t.start();
			
		}catch(Exception e){
			e.printStackTrace();
			logger.error(json.getRet_info());
			json.setRet_code(500);
			json.setRet_info("ios版本回调出错了");
			json.setSuccess(false);
		}
		//返回数据
		response(json, response, request);
		
	}
	
	/**
	 * 编辑上线交换机设备
	 * @param jsonStr	json格式的请求参数字符串
	 * @param auth		Authorization认证参数
	 * @param response	response响应对象
	 * @param request	request请求对象
	 * @return			返回json格式的字符串
	 */
	@RequestMapping(value = "/deviceAutomation/v1/updateSwitchDevice", method = RequestMethod.POST, produces="application/json", consumes="application/json")
	public void updateSwitchDevice(HttpServletRequest request, HttpServletResponse response,
								@RequestBody String jsonStr, @RequestHeader("Authorization") String auth){
		Json json = new Json();
		String info = "编辑成功";
		Integer code = 201;	//201:用户新建或修改数据成功
		Boolean success = true;
		logger.info("编辑上线交换机设备updateSwitchDevice接口入参是："+jsonStr);
		
		JSONObject obj = JSONObject.parseObject(jsonStr);
		Integer switchState = obj.getInteger("switchState");
		String taskId = obj.getString("taskId");
		if(StringUtils.isEmpty(taskId) || StringUtils.isEmpty(switchState)){
			json.setRet_code(400);
			json.setRet_info("缺少请求参数");
			json.setSuccess(false);
			//返回数据
			response(json, response, request);
			return;
		}
		
		try{
			String updateUser = obj.getString("updateUser");
			String exclusiveSwitchboardIp = obj.getString("exclusiveSwitchboardIp");
			String exclusiveSwitchboardPort = obj.getString("exclusiveSwitchboardPort");
			String exclusiveSwitchboardOrder = obj.getString("exclusiveSwitchboardOrder");
			String brandName = obj.getString("brandName");
			String modelName = obj.getString("modelName");
			String currentIosVersion = obj.getString("currentIosVersion");
			String exclusiveSwitchboardInfo = obj.getString("exclusiveSwitchboardInfo");
			
			DevOnlineTask task = new DevOnlineTask();
			task.setSwitchState(switchState);
			if(!StringUtils.isEmpty(taskId))
				task.setId(taskId);
			if(!StringUtils.isEmpty(exclusiveSwitchboardIp))
				task.setExclusiveSwitchboardIp(exclusiveSwitchboardIp);
			if(!StringUtils.isEmpty(exclusiveSwitchboardPort))
				task.setExclusiveSwitchboardPort(exclusiveSwitchboardPort);
			if(!StringUtils.isEmpty(exclusiveSwitchboardInfo))
				task.setExclusiveSwitchboardInfo(exclusiveSwitchboardInfo);
			
			if(!StringUtils.isEmpty(currentIosVersion))
				task.setCurrentIosVersion(currentIosVersion);
			if(!StringUtils.isEmpty(updateUser))
				task.setUpdate_user(updateUser);
			
			addSwitchDeviceService.exclusiveSwitchboardConn(null, task, updateUser);
			//将kvm端口实占掉
			DevExclusiveSwitchboardInfo in = new DevExclusiveSwitchboardInfo();
			in.setExclusiveSwitchboardIp(exclusiveSwitchboardIp);
			in.setExclusiveSwitchboardPort(exclusiveSwitchboardPort);
			in.setExclusiveSwitchboardPortState(1);
			deviceAutomationService.updateDevExclusiveSwitchboardInfo(in);
			
		}catch(Exception e){
			e.printStackTrace();
			info = "编辑交换机设备出错了";
			code = 500;
			success = false;
			logger.error(info);
		}finally{
			json.setRet_code(code);
			json.setRet_info(info);
			json.setSuccess(success);
			//返回数据
			response(json, response, request);
		}
	} 
	
	
	/**
	 * 强制停止执行上线交换机设备（即默认接下来的步骤执行成功）
	 * @param jsonStr	json格式的请求参数字符串
	 * @param auth		Authorization认证参数
	 * @param response	response响应对象
	 * @param request	request请求对象
	 * @return			返回json格式的字符串
	 */
	@RequestMapping(value = "/deviceAutomation/v1/forceStopExecute", method = RequestMethod.POST, produces="application/json", consumes="application/json")
	public void forceStopExecute(HttpServletRequest request, HttpServletResponse response,
								@RequestBody String jsonStr, @RequestHeader("Authorization") String auth){
		logger.info("强制停止执行上线交换机设备forceStopExecute接口入参是："+jsonStr);
		Json json = new Json();
		JSONObject obj = JSONObject.parseObject(jsonStr);
		String ids = obj.getString("taskId");
		if(StringUtils.isEmpty(ids)){
			json.setRet_code(400);
			json.setRet_info("缺少请求参数");
			json.setSuccess(false);
			response(json, response, request);
			return;
		}
		try{
			String[] s = ids.split(",");
			//1.把设备状态改成“成功工单”；2.ip地址回填成实占
			Map<String, String> map = new HashMap<String, String>();
			for(int i=0;i<s.length;i++){
				//ip地址回填 ，状态是3实分配
				List<DevOnlineTask> list = deviceAutomationService.findPort(s[i]);
				if(list!=null && list.size()>0){
					DevOnlineTask task = list.get(0);
					map.put("ip", task.getManagerIp());
					addSwitchDeviceService.adminRequestIP(thirdPartUrl, auth, list.get(0), map, task.getUserName(), 3, task.getUsercode());
					
					//将kvm端口释放
					DevExclusiveSwitchboardInfo in = new DevExclusiveSwitchboardInfo();
					in.setExclusiveSwitchboardIp(task.getExclusiveSwitchboardIp());
					in.setExclusiveSwitchboardPort(task.getExclusiveSwitchboardPort());
					in.setExclusiveSwitchboardPortState(0);
					deviceAutomationService.updateDevExclusiveSwitchboardInfo(in);
					
					//把设备状态改成“成功工单”
					DevOnlineTask t = new DevOnlineTask();
					t.setId(task.getId());
					t.setSwitchState(4);
					t.setTaskState(6);
					deviceAutomationService.updateTask2(t, null, null, task.getUserName());
					
					//标记为强制执行
					List<DevTaskExecute> li = deviceAutomationService.findTaskExecute(task.getId(), "execute_step");
					if(li!=null && li.size()>0){
						DevTaskExecute execute = new DevTaskExecute();
						execute.setId(li.get(0).getId());
						execute.setTaskExecuteNote("剩下步骤均强制执行完成了");
						deviceAutomationService.updateExecute(execute);
					}
					
				}
			}
			json.setRet_code(201);
			json.setRet_info("操作成功");
			json.setSuccess(true);
			response(json, response, request);
		}catch(Exception e){
			e.printStackTrace();
			logger.error("强制停止执行上线交换机设备出现异常");
			json.setRet_code(201);
			json.setRet_info("操作失败");
			json.setSuccess(true);
			response(json, response, request);
		}
	}
	
	
	/**
	 * 查看汇聚配置信息
	 * @param taskId	taskId
	 * @param auth		Authorization认证参数
	 * @param response	response响应对象
	 * @param request	request请求对象
	 * @return			返回json格式的字符串
	 */
	@RequestMapping(value = "/deviceAutomation/v1/findConverPageInfo", method = RequestMethod.GET, produces="application/json")
	public void findConverPageInfo(HttpServletRequest request, HttpServletResponse response, 
									@RequestHeader("Authorization") String auth,
									@RequestParam(value = "taskId", required = false) String taskId){
		
		logger.info("查看汇聚配置信息接口入参是："+request.getQueryString());
		Json json = new Json();
		if(StringUtils.isEmpty(taskId)){
			json.setRet_code(400);
			json.setRet_info("缺少请求参数");
			json.setSuccess(false);
			response(json, response, request);
			return;
		}
		try{
			List<DevOnlineTask> l = deviceAutomationService.findPort(taskId);
			if(l!=null && l.size()>0){
				json = addSwitchDeviceService.CreatConverPage(thirdPartUrl, auth, l.get(0), null, null);
				response(json, response, request);
			}else{
				json.setRet_code(500);
				json.setRet_info("系统内部异常");
				json.setSuccess(false);
				response(json, response, request);
			}
			
		}catch(Exception e){
			e.printStackTrace();
			logger.error("查看汇聚配置信息出现异常");
			json.setRet_code(201);
			json.setRet_info("查看汇聚配置信息失败");
			json.setSuccess(true);
			response(json, response, request);
		}
	}
	

}
