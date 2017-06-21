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

	private static boolean t = false;
	
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
		t = true;
		//2.从看板申请ip和vlan
		Json json = new Json();
		String sb = "";
		Map<String, String> map = new HashMap<String, String>();
		map = step2_appIpAndVlan();
		
		//3.看网络是否通
		json = null;
		json = addSwitchDeviceService.pingFun(thirdPartUrl, auth, task, map, userName);
		int code = json.getRet_code();//200:表示网络ping不通，本系统可用；505，表示网络ping通，被占了，本系统不可用; 500，服务器操作交换机时出错
		if(!json.getSuccess() && code!=200){
			if(code==505){
				//网络ping通，被占了，回填不可用状态
				addSwitchDeviceService.adminRequestIP(thirdPartUrl, auth, task, map, userName, -1, usercode);
				//重新申请ip,vlan
				json = addSwitchDeviceService.appIpAndVlan(thirdPartUrl, auth, task, userName, 1);
				//map = (Map<String, String>) json.getData();	//map中存放了ip和vlanId
				sb = json.getData().toString();	//map中存放了ip和vlanId
				try {
					org.json.JSONObject obj1 = new org.json.JSONObject(sb);
					String ip = obj1.getString("ip");
					String vlanId = obj1.getString("vlanId");
					map.put("ip", ip);
					map.put("vlanId", vlanId);
				} catch (JSONException e) {
					e.printStackTrace();
				}
				json = addSwitchDeviceService.pingFun(thirdPartUrl, auth, task, map, userName);
				if(json.getRet_code()!=200){
					if(json.getRet_code()==505){
						addSwitchDeviceService.adminRequestIP(thirdPartUrl, auth, task, map, userName, -1, usercode);
					}
					task.setSwitchState(3);
					task.setTaskState(5);
					deviceAutomationService.updateTask2(task, null, null, userName);
					return;
				}
			}
		}

		testService.callback(map.get("ip"), 1);
		
	}
	
	public synchronized Map<String, String> step2_appIpAndVlan(){
		if(t){
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
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
