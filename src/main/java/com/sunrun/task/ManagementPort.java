package com.sunrun.task;

import org.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.sunrun.entity.DevOnlineTask;
import com.sunrun.entity.DevTaskExecute;
import com.sunrun.service.DeviceAutomationService;
import com.sunrun.util.RestfulRequestUtil;
import com.sunrun.util.StringUtil;

/**
 * 写入交换机管理口任务
 * @author ymg
 *
 */
public class ManagementPort implements Runnable{
	private static final Logger logger = LoggerFactory.getLogger(ManagementPort.class);
	
	private String url;
	private JSONObject param;
	private String method;
	private String authorization;
	private DeviceAutomationService deviceAutomationService;
	
	public ManagementPort(){
		super();
	}
	
	public ManagementPort(String url, JSONObject param, String method, String authorization, DeviceAutomationService deviceAutomationService){
		this.url = url;
		this.param = param;
		this.method = method;
		this.authorization = authorization;
		this.deviceAutomationService = deviceAutomationService;
		
		logger.info("url:"+url+";param:"+param+";method:"+method+";authorization:"+authorization+";deviceAutomationService:"+deviceAutomationService);
	}
	
	@Override
	public void run() {
		try{
			String sb = RestfulRequestUtil.getResponse(url, param, method, authorization);
			String info = "写入接入交换机配置管理口IP成功";
			boolean success = true;
			if(StringUtils.isEmpty(sb)){
				info = "写入接入交换机配置管理口IP返回空信息";
				success = false;
				logger.error(info);
			}else{
				org.json.JSONObject obj1 = new org.json.JSONObject(sb);
				if(obj1.getInt("ret_code")!=200){
					info = "写入接入交换机配置管理口IP失败";
					success = false;
					if(obj1.getInt("ret_code")==505){
						JSONArray array = obj1.getJSONArray("data");
						String data = array.toString();
						info = "某些命令执行不成功:"+data.toString();
					}
				}
			}
			DevOnlineTask task = new DevOnlineTask();
			task.setManagerIpWrite(success==true ? 1 : 2);
			task.setId(param.getString("taskId"));
			
			//保存每一步步骤执行情况
			DevTaskExecute execute = new DevTaskExecute();
			execute.setId(StringUtil.getUuid());
			execute.setTaskId(task.getId());
			execute.setExecuteStep(7);
			execute.setTaskExecuteState(success==true ? 1 : 2);
			execute.setTaskDescribe(info);
			deviceAutomationService.updateTask2(task, execute, 7, "");
		}catch(Exception e){
			e.printStackTrace();
			logger.error("写入接入交换机配置管理口IP失败,程序出错");
		}
	}

}
