package com.sunrun.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.sunrun.entity.DevOnlineTask;
import com.sunrun.service.AddSwitchDeviceService;
import com.sunrun.service.DeviceAutomationService;
import com.sunrun.service.TestService;
import com.sunrun.task.TestDevice;
import com.sunrun.util.Json;
import com.sunrun.util.StringUtil;

@RestController
public class TestDeviceController extends BaseController {
private static final Logger logger = LoggerFactory.getLogger(DeviceAutomatinoController.class);
	
	@Resource
	private DeviceAutomationService deviceAutomationService;
	@Resource
	private AddSwitchDeviceService addSwitchDeviceService;
	@Resource
	private TestService testService;
	
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
	@RequestMapping(value = "/deviceAutomation/v1/addSwitchDeviceTest", method = RequestMethod.POST, produces="application/json", consumes="application/json")
	public void addSwitchDeviceTest(HttpServletRequest request, HttpServletResponse response,
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
			
			//先保存这条数据的基本信息，然后分线程去执行剩下的步骤
			TestDevice device = new TestDevice(deviceAutomationService, addSwitchDeviceService, testService, thirdPartUrl, auth, task, userName, usercode);
			Thread t = new Thread(device);
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
	
}
