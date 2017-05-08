package com.sunrun.task;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sunrun.entity.DevExclusiveSwitchboardConn;
import com.sunrun.entity.DevOnlineTask;
import com.sunrun.entity.DevTaskExecute;
import com.sunrun.service.AddSwitchDeviceService;
import com.sunrun.service.DeviceAutomationService;
import com.sunrun.util.Json;
import com.sunrun.util.StringUtil;

/**
 * 添加交换机任务（1.从看板申请ip和vlan；2.看网络是否通；3.ip地址回填；4.判断汇聚交换机端口上是否有配置及端口状态是否为down；5.生成汇聚交换机配置 并记录）
 * @author ymg
 *
 */
public class AddSwitchDevice implements Runnable {

	private static final Logger logger = LoggerFactory.getLogger(AddSwitchDevice.class);
	
	private DeviceAutomationService deviceAutomationService;
	private AddSwitchDeviceService addSwitchDeviceService;
	private String thirdPartUrl;	//第三方接口请求路径
	private String auth;			//Authorization权限
	private DevOnlineTask task;		//任务
	private String userName;		//登录的用户名
	private Integer executeStep;	//任务执行到第几步骤
	private DevExclusiveSwitchboardConn conn;
	
	public AddSwitchDevice(){
		super();
	}
	
	public AddSwitchDevice(DeviceAutomationService deviceAutomationService, AddSwitchDeviceService addSwitchDeviceService, String thirdPartUrl, String auth, DevOnlineTask task, String userName){
		this.deviceAutomationService = deviceAutomationService;
		this.addSwitchDeviceService = addSwitchDeviceService;
		this.thirdPartUrl = thirdPartUrl;
		this.auth = auth;
		this.userName = userName;
		this.task = task;
	}
	
	public AddSwitchDevice(DeviceAutomationService deviceAutomationService, AddSwitchDeviceService addSwitchDeviceService, String thirdPartUrl, String auth, DevOnlineTask task, String userName, Integer executeStep, DevExclusiveSwitchboardConn conn){
		this.deviceAutomationService = deviceAutomationService;
		this.addSwitchDeviceService = addSwitchDeviceService;
		this.thirdPartUrl = thirdPartUrl;
		this.auth = auth;
		this.userName = userName;
		this.task = task;
		this.executeStep = executeStep;
		this.conn = conn;
	}
	
	@Override
	public void run() {
		if(executeStep!=null && executeStep<10){
			executeStep2();
		}else if(executeStep!=null && executeStep>=12){
			executeStep3();
		}else{
			executeTask();
		}
		
	}

	/**
	 * 执行添加设备的1-5步骤
	 */
	public void executeTask(){
		//2.从看板申请ip和vlan
		Json json = new Json();
		Map<String, String> map = new HashMap<String, String>();
		json = addSwitchDeviceService.appIpAndVlan(thirdPartUrl, auth, task, userName);
		String sb = json.getData().toString();	//map中存放了ip和vlanId
		try {
			org.json.JSONObject obj1 = new org.json.JSONObject(sb);
			String ip = obj1.getString("ips");
			String vlanId = obj1.getString("vlanId");
			map.put("ip", ip);
			map.put("vlanId", vlanId);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		//Map<String, String> map = (Map<String, String>) json.getData();	//map中存放了ip和vlanId
		if(!json.getSuccess())
			return;
		
		//3.看网络是否通
		json = null;
		json = addSwitchDeviceService.pingFun(thirdPartUrl, auth, task.getId(), map, userName);
		int code = json.getRet_code();//200:表示网络ping不通，本系统可用；505，表示网络ping通，被占了，本系统不可用; 500，服务器操作交换机时出错
		if(!json.getSuccess() && code!=200){
			if(code==505){
				//网络ping通，被占了，回填不可用状态
				addSwitchDeviceService.adminRequestIP(thirdPartUrl, auth, task, map, userName, -1);
				//重新申请ip,vlan
				json = addSwitchDeviceService.appIpAndVlan(thirdPartUrl, auth, task, userName);
				//map = (Map<String, String>) json.getData();	//map中存放了ip和vlanId
				sb = json.getData().toString();	//map中存放了ip和vlanId
				try {
					org.json.JSONObject obj1 = new org.json.JSONObject(sb);
					String ip = obj1.getString("ips");
					String vlanId = obj1.getString("vlanId");
					map.put("ip", ip);
					map.put("vlanId", vlanId);
				} catch (JSONException e) {
					e.printStackTrace();
				}
				json = addSwitchDeviceService.pingFun(thirdPartUrl, auth, task.getId(), map, userName);
				if(json.getRet_code()!=200){
					if(json.getRet_code()==505){
						addSwitchDeviceService.adminRequestIP(thirdPartUrl, auth, task, map, userName, -1);
					}
					return;
				}
			}
		}
		
		//4.ip地址回填
		json = null;
		json = addSwitchDeviceService.adminRequestIP(thirdPartUrl, auth, task, map, userName, 1);
		if(!json.getSuccess())
			return;
		
		//5.判断汇聚交换机端口上是否有配置及端口状态是否为down；
		json = null;
		json = addSwitchDeviceService.portCheck(thirdPartUrl, auth, task, userName);
		if(!json.getSuccess())
			return;
		//ip地址回填 ，状态是3实分配
		addSwitchDeviceService.adminRequestIP(thirdPartUrl, auth, task, map, userName, 3);
		
		/*//6.生成汇聚交换机配置 并记录
		json = null;
		task = deviceAutomationService.findPort(task.getId()).get(0);
		json = addSwitchDeviceService.CreatConverPage(thirdPartUrl, auth, task, map, userName);
		//ip地址回填 ，状态是3实分配
		addSwitchDeviceService.adminRequestIP(thirdPartUrl, auth, task, map, userName, 1);
		if(!json.getSuccess())
			return;
		
		//7.生成接入交换机配置 并记录（待定）
		json = null;
		json = addSwitchDeviceService.CreatAccessPage(thirdPartUrl, auth, task, map, userName);
		if(!json.getSuccess())
			return;*/
		
	}
	
	/**
	 * 从错误步骤开始执行，并且执行 保存带外交换机端口与接入交换机的连接、 写入接入交换机配置管理口ip、更新ios版本、写入接入交换机配置信息
	 */
	public void executeStep2(){
		Json json = new Json();
		Map<String, String> map = new HashMap<String, String>();
		List<DevOnlineTask> li = deviceAutomationService.findPort(task.getId());
		if(li!=null && li.size()>0){
			task = li.get(0);
			map.put("vlanId", task.getVlan());
			map.put("ip", task.getManagerIp());
		}
		//2.从看板申请ip和vlan
		if(executeStep!=null && executeStep==2){
			json = addSwitchDeviceService.appIpAndVlan(thirdPartUrl, auth, task, userName);
			String sb = json.getData().toString();	//map中存放了ip和vlanId
			try {
				org.json.JSONObject obj1 = new org.json.JSONObject(sb);
				String ip = obj1.getString("ips");
				String vlanId = obj1.getString("vlanId");
				map.put("ip", ip);
				map.put("vlanId", vlanId);
			} catch (JSONException e) {
				e.printStackTrace();
			}
			if(!json.getSuccess())
				return;
		}
		
		//3.看网络是否通
		if(executeStep!=null && executeStep<=3){
			json = null;
			json = addSwitchDeviceService.pingFun(thirdPartUrl, auth, task.getId(), map, userName);
			int code = json.getRet_code();//200:表示网络ping不通，本系统可用；505:表示网络ping通，被占了，本系统不可用; 500，服务器操作交换机时出错
			if(!json.getSuccess() && code!=200){
				if(code==505){
					//网络ping通，被占了，回填不可用状态
					addSwitchDeviceService.adminRequestIP(thirdPartUrl, auth, task, map, userName, -1);
					//重新申请ip,vlan
					json = addSwitchDeviceService.appIpAndVlan(thirdPartUrl, auth, task, userName);
					//map = (Map<String, String>) json.getData();	//map中存放了ip和vlanId
					String sb = json.getData().toString();	//map中存放了ip和vlanId
					try {
						org.json.JSONObject obj1 = new org.json.JSONObject(sb);
						String ip = obj1.getString("ips");
						String vlanId = obj1.getString("vlanId");
						map.put("ip", ip);
						map.put("vlanId", vlanId);
					} catch (JSONException e) {
						e.printStackTrace();
					}
					json = addSwitchDeviceService.pingFun(thirdPartUrl, auth, task.getId(), map, userName);
					if(json.getRet_code()!=200){
						if(json.getRet_code()==505){
							addSwitchDeviceService.adminRequestIP(thirdPartUrl, auth, task, map, userName, -1);
						}
						return;
					}
				}
				//return;
			}
			
		}
		
		//4.ip地址回填
		if(executeStep!=null && executeStep<=4){
			json = null;
			json = addSwitchDeviceService.adminRequestIP(thirdPartUrl, auth, task, map, userName, 1);
			if(!json.getSuccess())
				return;
		}
		
		//5.判断汇聚交换机端口上是否有配置及端口状态是否为down；
		if(executeStep!=null && executeStep<=5){
			json = null;
			json = addSwitchDeviceService.portCheck(thirdPartUrl, auth, task, userName);
			if(!json.getSuccess())
				return;
		}
		//ip地址回填 ，状态是3实分配
		addSwitchDeviceService.adminRequestIP(thirdPartUrl, auth, task, map, userName, 3);
		
		/*//6.生成汇聚交换机配置 并记录
		if(executeStep!=null && executeStep<=6){
			json = null;
			json = addSwitchDeviceService.CreatConverPage(thirdPartUrl, auth, task, map, userName);
			//ip地址回填 ，状态是3实分配
			addSwitchDeviceService.adminRequestIP(thirdPartUrl, auth, task, map, userName, 1);
			if(!json.getSuccess())
				return;
		}
		
		//7.生成接入交换机配置 并记录（待定）
		if(executeStep!=null && executeStep<=7){
			json = null;
			json = addSwitchDeviceService.CreatAccessPage(thirdPartUrl, auth, task, map, userName);
			if(!json.getSuccess())
				return;
		}*/
		
		//6.第八步保存带外交换机端口与接入交换机的连接在进入这个方法前的控制器层已经调用方法执行了,此处不要重复执行了,只要记录任务执行详情
		if(executeStep!=null && executeStep<=6){
			DevTaskExecute execute = new DevTaskExecute();
			execute.setId(StringUtil.getUuid());
			execute.setTaskId(task.getId());
			execute.setExecuteStep(6);
			execute.setTaskOrder(6);
			execute.setTaskDescribe("保存带外交换机端口与接入交换机的连接信息"); 
			execute.setTaskExecuteState(3);
			execute.setCreate_user(userName);
			execute.setTaskExecuteNote(null);
			deviceAutomationService.updateTask2(task, execute, executeStep, userName);
		}
		/*
		json = null;
		json = addSwitchDeviceService.exclusiveSwitchboardConn(conn, task, userName);
		if(!json.getSuccess())
			return;*/
		
		//7.写入接入交换机配置管理口IP
		json = null;
		json = addSwitchDeviceService.managementPort(thirdPartUrl, auth, task.getId(), userName);
		if(!json.getSuccess())
			return;
		
		//8. 查看ios版本是否最新，不是最新需要升级ios版本
		json = null;
		json = addSwitchDeviceService.checkIosVersion(thirdPartUrl, auth, task, userName);
		if(!json.getSuccess())
			return;
		
		//9. 写入接入交换机配置
		json = null;
		json = addSwitchDeviceService.writeNewAccessConfig(thirdPartUrl, auth, task, userName);
		if(!json.getSuccess())
			return;
		if(json.getSuccess()){
			task.setSwitchState(2);
			deviceAutomationService.updateTask2(task, null, 11, userName);
		}
		
	}
	
	/**
	 * 在汇聚设备tab下点击执行的
	 */
	public void executeStep3(){
		Json json = new Json();
		List<DevOnlineTask> li = deviceAutomationService.findPort(task.getId());
		if(li!=null && li.size()>0){
			task = li.get(0);
			//12.写入汇聚接入交换机配置
			json = addSwitchDeviceService.writeNewGatherConfig(thirdPartUrl, auth, task, userName);
			if(!json.getSuccess())
				return;
			
			//13.在汇聚交换机和接入交换机写入配置后，对现网的情况进行检验排错
			json = null;
			json = addSwitchDeviceService.checkConfig(thirdPartUrl, auth, task.getId(), userName);
			if(!json.getSuccess())
				return;
			
			if(json.getSuccess()){
				task.setSwitchState(4);
			}else{
				task.setSwitchState(3);
			}
			deviceAutomationService.updateTask2(task, null, 15, userName);
			
		}
	}
	
	
}
