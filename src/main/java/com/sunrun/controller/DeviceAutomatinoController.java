package com.sunrun.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
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
import com.sunrun.entity.DevOnlineTask;
import com.sunrun.entity.view.DevOnlineBatchTaskView;
import com.sunrun.service.DeviceAutomationService;
import com.sunrun.task.ManagementPort;
import com.sunrun.task.UpdateIos;
import com.sunrun.task.WriteAccessConfig;
import com.sunrun.task.WriteGatherConfig;
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
	
	@Value("${sr_public.thirdPartUrl}")
	private String thirdPartUrl;
	
	/**
	 * 查询批次任务
	 * @param request		
	 * @param batchId		批次ID(可选参数，暂时没用到)
	 * @param batchState	批次状态（1或者2：未完成；3：已经完成。可选参数，不传递就是查询所有状态的，传递了就是查询具体状态的）
	 * @param id			任务id,(参数可选)
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
	@RequestMapping(value = "/deviceAutomation/v1/findDevBatchTask", method = RequestMethod.GET, produces="application/json")
	public void findDevBatchTask(HttpServletRequest request, HttpServletResponse response,
								@RequestParam(value = "id", required = false) String taskId,
								@RequestParam(value = "execute_step", required = false) Integer executeStep,
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
			DevOnlineBatchTaskView batchView = new DevOnlineBatchTaskView();
			if(executeStep==null || executeStep==0){	//查询ITIL任务列表
				if(batchId!=null && !"".equals(batchId)){
					batchView.setId(batchId);
				}
				if(batchState!=null){
					batchView.setBatchState(batchState); 
				}
			}else{	//查询任务具体信息
				if(taskId!=null && !"".equals(taskId) && executeStep!=null && executeStep!=0){
					batchView.setTaskId(taskId);
					batchView.setExecuteStep(executeStep); 
				}
			}
			List<DevOnlineBatchTaskView> list = deviceAutomationService.findDevBatchTask(batchView, like, sortBy, order, page(currentPage, pageSize));
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
	 * 添加交换机设备(页面每个‘下一步’调用的方法)
	 * @param jsonStr	json格式的请求参数字符串
	 * @param auth		Authorization认证参数
	 * @param request	request请求对象
	 * @return			返回json格式的字符串
	 */
	@RequestMapping(value = "/deviceAutomation/v1/editDevice", method = RequestMethod.POST, produces="application/json", consumes="application/json", headers={"Authorization=sys/sysPwd/user/userPwd"})
	public void editDevice(@RequestBody String jsonStr, @RequestHeader("Authorization") String auth, HttpServletRequest request, HttpServletResponse response){
		Json json = new Json();
		String info = "编辑交换机设备成功";
		Integer code = 201;	//201:用户新建或修改数据成功
		Boolean success = true;
		try{
			JSONObject obj = JSONObject.parseObject(jsonStr);
			String id = obj.getString("id");	//taskId 任务id
			Integer executeStep = obj.getIntValue("execute_step");//任务步骤
			
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
			task.setDevOnlineRack(devOnlineRack);
			task.setHostName(hostName);
			task.setAreaDescribe(areaDescribe); 
			task.setBackupSwitchboardIp(backupSwitchboardIp);
			task.setMainSwitchboardIp(mainSwitchboardIp);
			
			String managerIp = obj.getString("managerIp");
			String vlan = obj.getString("vlan");
			task.setManagerIp(managerIp);
			task.setVlan(vlan); 
			
			String mainSwitchboardPort = obj.getString("mainSwitchboardPort");
			String backupSwitchboardPort = obj.getString("backupSwitchboardPort");
			task.setMainSwitchboardPort(mainSwitchboardPort);
			task.setBackupSwitchboardPort(backupSwitchboardPort);
			
			String exclusiveSwitchboardIp = obj.getString("exclusiveSwitchboardIp");
			String exclusiveSwitchboardPort = obj.getString("exclusiveSwitchboardPort");
			task.setExclusiveSwitchboardIp(exclusiveSwitchboardIp);
			task.setExclusiveSwitchboardPort(exclusiveSwitchboardPort);
			
			String d = null;
			if(StringUtils.isEmpty(id)){
				String uuid = StringUtil.getUuid();
				d = uuid;
				task.setId(uuid);
				deviceAutomationService.saveDevice(task, executeStep); 
			}else{
				Object object = null;
				//第五步.保存接入交换机配置信息
				if(executeStep==5){
					Object data = obj.get("data");
					List<String> l = com.alibaba.fastjson.JSONArray.parseArray(data.toString(), String.class);
					object = l;
				}
				//第六步，保存带外交换机信息; || 第七步，写交换机入管理口ip
				if(executeStep==6 || executeStep==7){
					Object data = obj.get("data");
					List<DevOnlineTask> l = com.alibaba.fastjson.JSONArray.parseArray(data.toString(), DevOnlineTask.class);
					object = l;
				}
				d = id;
				task.setId(id);
				deviceAutomationService.updateTask(task, executeStep, object);
			}
			
			//编辑完之后还要把这条信息返回给前端
			//DevOnlineTask data = deviceAutomationService.findTaskById(d);
			json.setData(d);
			
		}catch(Exception e){
			e.printStackTrace();
			info = "编辑批次任务交换机设备出错了";
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
	@RequestMapping(value = "/deviceAutomation/v1/deleteDevice", method = {RequestMethod.POST, RequestMethod.DELETE}, produces="application/json", consumes="application/json", headers={"Authorization=sys/sysPwd/user/userPwd"})
	public void deleteDevice(@RequestBody String jsonStr, @RequestHeader("Authorization") String auth, HttpServletRequest request,HttpServletResponse response){
		Json json = new Json();
		String info = "删除成功";
		Integer code = 201;	//201:用户新建或修改数据成功
		Boolean success = true;
		try{
			JSONObject obj = new JSONObject();
			String itilNumber = obj.getString("itilNumber");//itil批次Id
			String taskId = obj.getString("taskId");		//任务Id
			String executeId = obj.getString("executeId");	//执行情况Id
			
			//删除itil批次
			if(!StringUtils.isEmpty(itilNumber) && !StringUtils.isEmpty(taskId))
				deviceAutomationService.deleteTaskItil(itilNumber, taskId);
			
			//删除任务
			if(!StringUtils.isEmpty(taskId) && StringUtils.isEmpty(itilNumber) && StringUtils.isEmpty(executeId))
				deviceAutomationService.deleteTask(taskId);
			
			//删除执行情况
			if(!StringUtils.isEmpty(executeId) && StringUtils.isEmpty(taskId) && StringUtils.isEmpty(itilNumber))
				deviceAutomationService.deleteExecute(executeId);
				
			
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
	
	@RequestMapping(value = "/deviceAutomation/v1/deleteDevice", method = {RequestMethod.POST}, produces="application/json", consumes="application/json", headers={"Authorization=sys/sysPwd/user/userPwd"})
	public void ThirdParty(@RequestBody String jsonStr, @RequestHeader("Authorization") String auth, HttpServletRequest request,HttpServletResponse response){
		Json json = new Json();
		String info = "接口调用成功";
		Integer code = 201;	//201:用户新建或修改数据成功
		Boolean success = true;
		try{
			JSONObject obj = JSONObject.parseObject(jsonStr);
			String methodName = obj.getString("method_name");				//请求第三方接口方法名字
			if(methodName.equals("/interchanger/v1/managementPort")){		//请求写入接入交换机配置管理口IP
				managementPort(obj, auth);
			}else if(methodName.equals("/interchanger/v1/updateIos")){		//更新IOS版本
				updateIos(obj, auth);
			}else if(methodName.equals("/interchanger/v1/writeAccessConfig")){	//请求写入接入交换机配置
				writeAccessConfig(obj, auth);
			}else if(methodName.equals("/interchanger/v1/writeGatherConfig")){	//请求写入汇聚接入交换机配置
				writeGatherConfig(obj, auth);
			}
			
		}catch(Exception e){
			code = 500;
			success = false;
			logger.error("接口程序出错");
			e.printStackTrace();
		}
		json.setRet_code(code);
		json.setRet_info(info);
		json.setSuccess(success);
		//返回数据
		response(json, response, request); 
	}
	
	private void  writeGatherConfig(JSONObject obj, String auth) {
		JSONArray array = (JSONArray) obj.get("data");
		for(int i=0;i<array.size();i++){
			JSONObject o = (com.alibaba.fastjson.JSONObject) array.get(i);	//获取对象
			String host = obj.getString("host");//交换机的telnet登录IP地址
			String port = obj.getString("port");//交换机的telnet登录端口号
			String user = obj.getString("user");//交换机的telnet登录账号
			String password = obj.getString("password");//交换机的telnet登录密码
			String type = obj.getString("type");//交换机的类型，分别为4948E和5548
			String[] commands = (String[]) obj.get("commands");//需要写入接入交换机的命令列表集合
			String taskId = o.getString("taskId");//任务id
			
			if(!StringUtils.isEmpty(host) && !StringUtils.isEmpty(port) && !StringUtils.isEmpty(user) && !StringUtils.isEmpty(password)
				&& !StringUtils.isEmpty(type) && !StringUtils.isEmpty(taskId) && !StringUtils.isEmpty(commands)){
				
				o.put("method_name", obj.getString("method_name"));
				WriteGatherConfig mp = new WriteGatherConfig(thirdPartUrl, o, "post", auth, deviceAutomationService);
				Thread t = new Thread(mp);
		        t.start();
		        
			}
		}
	}

	private void writeAccessConfig(JSONObject obj, String auth) {
		JSONArray array = (JSONArray) obj.get("data");
		for(int i=0;i<array.size();i++){
			JSONObject o = (com.alibaba.fastjson.JSONObject) array.get(i);	//获取对象
			String host = obj.getString("host");//交换机的telnet登录IP地址
			String port = obj.getString("port");//交换机的telnet登录端口号
			String user = obj.getString("user");//交换机的telnet登录账号
			String password = obj.getString("password");//交换机的telnet登录密码
			String type = obj.getString("type");//交换机的类型，分别为4948E和5548
			String[] commands = (String[]) obj.get("commands");//需要写入接入交换机的命令列表集合
			String taskId = o.getString("taskId");//任务id
			
			if(!StringUtils.isEmpty(host) && !StringUtils.isEmpty(port) && !StringUtils.isEmpty(user) && !StringUtils.isEmpty(password)
				&& !StringUtils.isEmpty(type) && !StringUtils.isEmpty(taskId) && !StringUtils.isEmpty(commands)){
				
				o.put("method_name", obj.getString("method_name"));
				WriteAccessConfig mp = new WriteAccessConfig(thirdPartUrl, o, "post", auth, deviceAutomationService);
				Thread t = new Thread(mp);
		        t.start();
		        
			}
		}
	}

	private void updateIos(JSONObject obj, String auth) throws JSONException {
		JSONArray array = (JSONArray) obj.get("data");
		for(int i=0;i<array.size();i++){
			JSONObject o = (com.alibaba.fastjson.JSONObject) array.get(i);	//获取对象
			String host = o.getString("host");//交换机的telnet登录IP地址
			String port = o.getString("port");//交换机的telnet登录端口号
			String user = o.getString("user");//交换机的telnet登录账号
			String password = o.getString("password");//交换机的telnet登录密码
			String type = o.getString("type");//交换机的类型，分别为4948E和5548
			String serverIp = obj.getString("serverIp");//更新源服务器的IP
			String sourceFileName = obj.getString("sourceFileName");//源文件名
			String desFileName = obj.getString("desFileName");//目的文件名
			String iosName = obj.getString("iosName");//IOS名称
			String updateId = obj.getString("updateId");//请求需用回调的ID updateId 
			String taskId = o.getString("taskId");//任务id
			
			if(!StringUtils.isEmpty(host) && !StringUtils.isEmpty(port) && !StringUtils.isEmpty(user) && !StringUtils.isEmpty(password)
				&& !StringUtils.isEmpty(type) && !StringUtils.isEmpty(serverIp) && !StringUtils.isEmpty(sourceFileName) 
				&& !StringUtils.isEmpty(desFileName) && !StringUtils.isEmpty(iosName) && !StringUtils.isEmpty(taskId)){
				
				o.put("method_name", obj.getString("method_name"));
				UpdateIos mp = new UpdateIos(thirdPartUrl, o, "post", auth, deviceAutomationService);
				Thread t = new Thread(mp);
		        t.start();
		        
			}
		}
	}

	/**
	 * 请求写入接入交换机配置管理口IP
	 * @param obj
	 * @param auth
	 * @throws JSONException
	 */
	public void managementPort(JSONObject obj, String auth) throws JSONException{ 
		JSONArray array = (JSONArray) obj.get("data");
		for(int i=0;i<array.size();i++){
			JSONObject o =  (com.alibaba.fastjson.JSONObject)array.get(i);	//获取对象
			String host = o.getString("host");//交换机的telnet登录IP地址
			String port = o.getString("port");//交换机的telnet登录端口号
			String user = o.getString("user");//交换机的telnet登录账号
			String password = o.getString("password");//交换机的telnet登录密码
			String taskId = o.getString("taskId");//交换机的telnet登录密码
			String type = o.getString("type");//交换机的类型，分别为4948E和5548
			if(!StringUtils.isEmpty(host) && !StringUtils.isEmpty(port) && !StringUtils.isEmpty(user) && !StringUtils.isEmpty(password) 
					&& !StringUtils.isEmpty(taskId) && !StringUtils.isEmpty(type)){
				
				o.put("method_name", obj.getString("method_name"));
				ManagementPort mp = new ManagementPort(thirdPartUrl, o, "post", auth, deviceAutomationService);
				Thread t = new Thread(mp);
		        t.start();
		        
			}
		}
	}
	

}
