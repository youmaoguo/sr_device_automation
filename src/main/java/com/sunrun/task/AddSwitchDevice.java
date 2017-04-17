package com.sunrun.task;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.sunrun.entity.DevOnlineTask;
import com.sunrun.service.AddSwitchDeviceService;
import com.sunrun.service.DeviceAutomationService;
import com.sunrun.util.Json;

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
	
	public AddSwitchDevice(DeviceAutomationService deviceAutomationService, AddSwitchDeviceService addSwitchDeviceService, String thirdPartUrl, String auth, DevOnlineTask task, String userName, Integer executeStep){
		this.deviceAutomationService = deviceAutomationService;
		this.addSwitchDeviceService = addSwitchDeviceService;
		this.thirdPartUrl = thirdPartUrl;
		this.auth = auth;
		this.userName = userName;
		this.task = task;
		this.executeStep = executeStep;
	}
	
	@Override
	public void run() {
		if(executeStep!=null){
			executeStep2();
		}else{
			executeTask();
		}
		
	}

	/**
	 * 执行添加设备的1-6步骤
	 */
	public void executeTask(){
		//2.从看板申请ip和vlan
		Json json = new Json();
		json = addSwitchDeviceService.appIpAndVlan(thirdPartUrl, auth, task, userName);
		Map<String, String> map = (Map<String, String>) json.getData();	//map中存放了ip和vlanId
		if(!json.getSuccess())
			return;
		
		//3.看网络是否通
		json = null;
		json = addSwitchDeviceService.pingFun(thirdPartUrl, auth, task.getId(), map, userName);
		if(!json.getSuccess())
			return;
		
		//4.ip地址回填
		json = null;
		json = addSwitchDeviceService.adminRequestIP(thirdPartUrl, auth, task, map, userName);
		if(!json.getSuccess())
			return;
		
		//5.判断汇聚交换机端口上是否有配置及端口状态是否为down；
		json = null;
		json = addSwitchDeviceService.portCheck(thirdPartUrl, auth, task, userName);
		if(!json.getSuccess())
			return;
		
		//6.生成汇聚交换机配置 并记录
		json = null;
		task = deviceAutomationService.findPort(task.getId()).get(0);
		json = addSwitchDeviceService.CreatConverPage(thirdPartUrl, auth, task, map, userName);
		if(!json.getSuccess())
			return;
		
		//7.生成接入交换机配置 并记录（待定）
		
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
			map = (Map<String, String>) json.getData();	//map中存放了ip和vlanId
			if(!json.getSuccess())
				return;
		}
		
		//3.看网络是否通
		if(executeStep!=null && executeStep<=3){
			json = null;
			json = addSwitchDeviceService.pingFun(thirdPartUrl, auth, task.getId(), map, userName);
			if(!json.getSuccess())
				return;
		}
		
		//4.ip地址回填
		if(executeStep!=null && executeStep<=4){
			json = null;
			json = addSwitchDeviceService.adminRequestIP(thirdPartUrl, auth, task, map, userName);
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
		
		//6.生成汇聚交换机配置 并记录
		if(executeStep!=null && executeStep<=6){
			json = null;
			json = addSwitchDeviceService.CreatConverPage(thirdPartUrl, auth, task, map, userName);
			if(!json.getSuccess())
				return;
		}
		
		//7.生成接入交换机配置 并记录（待定）
		if(executeStep!=null && executeStep<=7){
			json = null;
			json = addSwitchDeviceService.CreatAccessPage(thirdPartUrl, auth, task, map, userName);
			if(!json.getSuccess())
				return;
		}
		
		//8.第八步保存带外交换机端口与接入交换机的连接在进入这个方法前的控制器层已经调用方法执行了,此处不要重复执行了
		
		//9.写入接入交换机配置管理口IP
		json = null;
		json = addSwitchDeviceService.managementPort(thirdPartUrl, auth, task.getId(), userName);
		if(!json.getSuccess())
			return;
		
		//10. 查看ios版本是否最新，不是最新需要升级ios版本
		json = null;
		json = addSwitchDeviceService.checkIosVersion(thirdPartUrl, auth, task, userName);
		if(!json.getSuccess())
			return;
		
		//11. 写入接入交换机配置
		addSwitchDeviceService.writeAccessConfig(thirdPartUrl, auth, task.getId(), userName);
		
		
		
	}
	
	
	
}
