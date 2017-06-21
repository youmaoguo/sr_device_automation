package com.sunrun.task;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONException;

import com.sunrun.entity.DevOnlineTask;
import com.sunrun.service.AddSwitchDeviceService;
import com.sunrun.service.DeviceAutomationService;
import com.sunrun.service.TestService;
import com.sunrun.util.Json;

public class TestDevice  implements Runnable {

	private DeviceAutomationService deviceAutomationService;
	private AddSwitchDeviceService addSwitchDeviceService;
	private TestService testService;
	private String thirdPartUrl;	//第三方接口请求路径
	private String auth;			//Authorization权限
	private DevOnlineTask task;		//任务
	private String userName;		//登录的用户名
	private String usercode;		//用户编号 如：01091231
	
	public TestDevice(DeviceAutomationService deviceAutomationService, AddSwitchDeviceService addSwitchDeviceService, TestService testService, String thirdPartUrl, String auth, DevOnlineTask task, String userName, String usercode){
		this.deviceAutomationService = deviceAutomationService;
		this.addSwitchDeviceService = addSwitchDeviceService;
		this.testService = testService;
		this.thirdPartUrl = thirdPartUrl;
		this.auth = auth;
		this.userName = userName;
		this.task = task;
		this.usercode = usercode;
	}

	@Override
	public void run() {
		//2.从看板申请ip和vlan
		Json json = new Json();
		String sb = "";
		Map<String, String> map = new HashMap<String, String>();
		map = step2_appIpAndVlan();
		
	}
	
	public synchronized Map<String, String> step2_appIpAndVlan(){
		//2.从看板申请ip和vlan
			Json json = new Json();
			json.setSuccess(true);
			Map<String, String> map = new HashMap<String, String>();
			String s = testService.applyIp(1,task);
			try {
				String ip = s;
				
				//点击“继续添加设备后”防止申请到重复的ip
				boolean tag = true;
				DevOnlineTask t = new DevOnlineTask();
				t.setManagerIp(ip);
				List<DevOnlineTask> li = deviceAutomationService.findTask(t);
				if(li!=null && li.size()>1){
					tag = false;
				}
				if(!tag){
					s = testService.applyIp(1, task);
					ip = s;
				}
				map.put("ip", ip);
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
			if(!json.getSuccess()){
				task.setSwitchState(3);
				task.setTaskState(5);
				deviceAutomationService.updateTask2(task, null, null, userName);
				return map;
			}else{
				task.setTaskState(2);
				deviceAutomationService.updateTask2(task, null, null, userName);
			}
			List<DevOnlineTask> li = deviceAutomationService.findPort(task.getId());
			if(li!=null && li.size()>0){
				task = li.get(0);
				map.put("vlanId", task.getVlan());
				map.put("ip", task.getManagerIp());
			}
			return map;
	}
	
}
