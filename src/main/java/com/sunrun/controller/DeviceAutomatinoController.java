package com.sunrun.controller;

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
import com.sunrun.entity.DevExclusiveSwitchboardConn;
import com.sunrun.entity.DevExclusiveSwitchboardInfo;
import com.sunrun.entity.DevOnlineTask;
import com.sunrun.entity.DevTaskExecute;
import com.sunrun.entity.SysSendEmailBean;
import com.sunrun.entity.SysSendEmailBean.MailConsignee;
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
	
	@Value("${itil.url}")
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
		try{
			JSONObject obj = JSONObject.parseObject(jsonStr);
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
			String uuid = StringUtil.getUuid();
			task.setId(uuid);
			json = addSwitchDeviceService.saveDeviceBaseInfo(task, "");
			code = json.getRet_code();
			info = json.getRet_info();
			success = json.getSuccess();
			
			//先保存这条数据的基本信息，然后分线程去执行剩下的步骤
			AddSwitchDevice addSwitchDevice = new AddSwitchDevice(deviceAutomationService, addSwitchDeviceService, thirdPartUrl, auth, task, "");
			Thread t = new Thread(addSwitchDevice);
	        t.start();
			
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
		System.out.println("========"+ request.getQueryString());
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
				list = deviceAutomationService.findDevBatchTask(batchView, like, sortBy, order, page(currentPage, pageSize));
			}else{	//查询任务具体信息
				if(taskId!=null && !"".equals(taskId) && executeStep!=null && executeStep!=0){
					batchView.setId(taskId);
					batchView.setExecuteStep(executeStep); 
				}
				DevOnlineBatchTaskView view = deviceAutomationService.findTaskById(batchView);
				list.add(view);
			}
			Map<Object, Object> collect = new HashMap<Object, Object>();
			collect.put("total", (list!=null && list.size()>0) ? list.size() : 0);
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
		try{
			JSONObject obj = JSONObject.parseObject(jsonStr);
			String updateUser = obj.getString("updateUser");
			String taskId = obj.getString("taskId");		//任务Id
			
			//删除任务
			if(!StringUtils.isEmpty(taskId)){
				
				//回填从看板申请回来的ip状态，state=2：回收，第三方系统放弃使用该ip，IP状态由“预占用”改为“未分配”
				List<DevOnlineTask> l = deviceAutomationService.findPort(taskId);
				if(l!=null && l.size()>0){
					 Map<String, String> map = new HashMap<String, String>();
					 map.put("ip", l.get(0).getManagerIp());
					addSwitchDeviceService.adminRequestIP(thirdPartUrl, auth, l.get(0), map, updateUser, 2);
				}
				
				success = deviceAutomationService.deleteTask(taskId);
				if(!success){
					code = 500;
					info = "删除出错";
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
		String info = "执行上线交换机成功";
		Integer code = 201;	//201:用户新建或修改数据成功
		Boolean success = true;
		try{
			JSONObject obj = JSONObject.parseObject(jsonStr);
			int switchState = obj.getIntValue("switchState");
			String vlan = obj.getString("vlan");
			String taskId = obj.getString("taskId");
			String exclusiveSwitchboardIp = obj.getString("exclusiveSwitchboardIp");
			String exclusiveSwitchboardPort = obj.getString("exclusiveSwitchboardPort");
			String exclusiveSwitchboardOrder = obj.getString("exclusiveSwitchboardOrder");
			String brandName = obj.getString("brandName");
			String modelName = obj.getString("modelName");
			String currentIosVersion = obj.getString("currentIosVersion");
			String updateUser = obj.getString("updateUser");
			String exclusiveSwitchboardInfo = "第"+exclusiveSwitchboardOrder+"口-"+brandName+"-"+modelName;
			
			DevOnlineTask task = new DevOnlineTask();
			task.setSwitchState(switchState);
			task.setVlan(vlan);
			task.setId(taskId);
			task.setExclusiveSwitchboardIp(exclusiveSwitchboardIp);
			task.setExclusiveSwitchboardPort(exclusiveSwitchboardPort);
			task.setExclusiveSwitchboardInfo(exclusiveSwitchboardInfo);
			task.setBrandName(brandName);
			task.setModelName(modelName);
			task.setCurrentIosVersion(currentIosVersion);
			task.setUpdate_user(updateUser);
			DevExclusiveSwitchboardConn conn = new DevExclusiveSwitchboardConn();
			conn.setBrandName(brandName);
			conn.setCreate_user(updateUser);
			conn.setCurrentIosVersion(currentIosVersion);
			conn.setExclusiveSwitchboardInfo(exclusiveSwitchboardInfo);
			conn.setExclusiveSwitchboardIp(exclusiveSwitchboardIp);
			conn.setExclusiveSwitchboardPort(exclusiveSwitchboardPort);
			conn.setId(StringUtil.getUuid());
			conn.setModelName(modelName);
			addSwitchDeviceService.exclusiveSwitchboardConn(conn, task, updateUser);
			
			//查询出该任务执行到第几步骤 然后分多线程继续执行之后的步骤（写入接入交换机配置管理口ip、更新ios版本、写入接入交换机配置信息）
			Integer executeStep = null;
			if(switchState==1){
				List<DevTaskExecute> li = deviceAutomationService.findTaskExecute(taskId, "execute_step");
				if(li!=null && li.size()>0){
					executeStep = li.get(0).getExecuteStep();
					Integer executeState = li.get(0).getTaskExecuteState();
					if(executeState==3){	//3:成功，就要从下一步开始
						executeStep += 1;
					}
				}
			}else if(switchState==2){
				executeStep = 14;
			}
			AddSwitchDevice addTask = new AddSwitchDevice(deviceAutomationService, addSwitchDeviceService, thirdPartUrl, auth, task, "", executeStep); 
			Thread t = new Thread(addTask);
			t.start();
			
			
		}catch(Exception e){
			code = 500;
			success = false;
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
		try{
			JSONObject obj = JSONObject.parseObject(jsonStr);
			String itilPlannedEnd = obj.getString("itilPlannedEnd");
			String updateUser = obj.getString("updateUser");
			JSONArray j = obj.getJSONArray("taskId");
			List<String> l = com.alibaba.fastjson.JSONArray.parseArray(j.toString(), String.class);
			String[] a = new String[l.size()];
			String[] taskId = l.toArray(a);
			
			json = addSwitchDeviceService.switchDeviceITIL(itil, itilPlannedEnd, taskId, updateUser);
			
		}catch(Exception e){
			logger.error("接口程序出错");
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
		try{
			JSONObject obj = JSONObject.parseObject(jsonStr);
			JSONArray arr = obj.getJSONArray("taskId");
			List<String> l = com.alibaba.fastjson.JSONArray.parseArray(arr.toString(), String.class);
			String[] a = new String[l.size()];
			String[] taskId = l.toArray(a);
			String title = obj.getString("mailTitle");
			String content = obj.getString("mailContxt");
			JSONArray array = obj.getJSONArray("mailConsignee");
			String emails = "";//收件人邮箱
			String names = "";
			for(int i=0;i<array.size();i++){
				JSONObject j = (JSONObject) array.get(i);
				String name = j.getString("mailConsigneeName");
				String email = j.getString("mailConsigneeEmail");
				emails += email;
				names += name;
			}
			
			//调用sr_public工程发送邮件通过接口方法
			Json j = addSwitchDeviceService.SendEmailswitchDevice(sendEmail, auth, taskId, emails, names, title, content, "");
			code = j.getRet_code();
			info = j.getRet_info();
			success = j.getSuccess();
			
		}catch(Exception e){
			code = 500;
			success = false;
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
	public void addEmailswitchDeviceEmail(@RequestParam(value = "taskId", required = false) String taskId, 
											HttpServletRequest request,HttpServletResponse response/*, @RequestHeader("Authorization") String auth*/){
		Json json = new Json();
		String info = "上线交换机生成邮件内容成功";
		Integer code = 200;	//200
		Boolean success = true;
		ArrayList data = new ArrayList();
		
		if(StringUtils.isEmpty(taskId)){
			json.setRet_code(400);
			json.setRet_info("缺少参数");
			json.setSuccess(false);
			json.setData(null);
			//返回数据
			response(json, response, request);
			return;
		} ;

		SysSendEmailBean sysSendEmailBean=new SysSendEmailBean();
		
		try{
			if(!StringUtils.isEmpty(taskId)){
				String content = StringUtil.emailHeadStr();
				String[] ids = taskId.split(",");	//多个taskId用英文逗号隔开
				for(int i=0;i<ids.length;i++){
					List<DevOnlineTask> view = deviceAutomationService.findPort(taskId);
					if(view!=null && view.size()>0){
						DevOnlineTask task = view.get(0);
						content += "<tr height=\"80\" style=\"mso-height-source:userset;height:60.0pt\">";
						content += "<td height=\"80\" class=\"xl66\" width=\"85\" style=\"height:60.0pt;border-top:none;width:64pt\">"+task.getBrandName()+"</td>";
						content += "<td class=\"xl66\" width=\"72\" style=\"border-top:none;border-left:none;width:54pt\">"+task.getModelName()+"</td>";
						content += "<td class=\"xl66\" width=\"125\" style=\"border-top:none;border-left:none;width:94pt\">"+task.getAreaName()+"</td>";
						content += "<td class=\"xl69\" width=\"165\" style=\"border-top:none;border-left:none;width:124pt\">"+task.getMainSwitchboardIp()+"<font class=\"font7\">/"+task.getMainSwitchboardPort()+"</font></td>";
						content += "<td class=\"xl67\" width=\"165\" style=\"border-top:none;border-left:none;width:124pt\">"+task.getBackupSwitchboardIp()+"<font class=\"font7\">/"+task.getBackupSwitchboardPort()+"</font></td>";
						content += "<td class=\"xl68\" width=\"165\" style=\"border-top:none;border-left:none;width:124pt\"><font class=\"font6\">"+task.getDevOnlineRack()+"</font></td>";
						content += "<td class=\"xl66\" width=\"244\" style=\"border-top:none;border-left:none;width:183pt\">"+task.getHostName()+"</td>";
						content += "<td class=\"xl66\" width=\"165\" style=\"border-top:none;border-left:none;width:124pt\">"+task.getManagerIp()+"</td>";
						content += "<td class=\"xl66\" width=\"238\" style=\"border-top:none;border-left:none;width:179pt\">"+task.getExclusiveSwitchboardInfo()+"</td></tr>";
					}
				}
				content += "</tbody></table></div><div><includetail><!--<![endif]--></includetail></div>";
				sysSendEmailBean.setMailContxt(content);
				sysSendEmailBean.setMailTitle( new Date()+"接入设备连接信息");
				 
				  
			//	data.put("mailConsignee", "");	//收件者的邮箱信息 暂时待定？？？
				SysSendEmailBean.MailConsignee mailConsignee=  sysSendEmailBean.new MailConsignee();
				mailConsignee.setMailConsigneeEmail("123@12.com");
				mailConsignee.setMailConsigneeName("张三");
				mailConsignee.setMailConsigneeSelected(1);
				sysSendEmailBean.mailConsignee.add(mailConsignee);
				
			}
			
		}catch(Exception e){
			code = 500;
			success = false;
			logger.error("上线交换机生成邮件内容出错");
			e.printStackTrace();
		}
		data.add(sysSendEmailBean);
		
		json.setRet_code(code);
		json.setRet_info(info);
		json.setSuccess(success);
		json.setData(sysSendEmailBean);
		//返回数据
		response(json, response, request); 
	}
	
	
	/**
	 * kvm接口所对应的设备型号信息接口
	 * @param request
	 * @param response
	 * @param exclusiveSwitchboardIp
	 * @param exclusiveSwitchboardPort
	 */
	@RequestMapping(value = "/v1/thirdparty/kvmInfo", method = RequestMethod.GET, produces="application/json")
	public void kvmInfo(HttpServletRequest request, HttpServletResponse response,  @RequestHeader("Authorization") String auth,
						@RequestParam(value = "exclusiveSwitchboardIp", required = false) String exclusiveSwitchboardIp,
						@RequestParam(value = "exclusiveSwitchboardPort", required = false) String exclusiveSwitchboardPort){
		Json json = new Json();
		try{
			DevExclusiveSwitchboardInfo bean = new DevExclusiveSwitchboardInfo();
			bean.setExclusiveSwitchboardIp(exclusiveSwitchboardIp);
			bean.setExclusiveSwitchboardPort(exclusiveSwitchboardPort);
			json = deviceAutomationService.findKvmInfo(bean, thirdPartUrl, auth);
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
	
	

}
