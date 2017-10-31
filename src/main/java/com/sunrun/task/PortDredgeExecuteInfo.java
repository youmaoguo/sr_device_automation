package com.sunrun.task;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sunrun.entity.DevPortCommandInfo;
import com.sunrun.entity.DevPortDredgeOrder;
import com.sunrun.service.DevPortDredgeOrderService;
import com.sunrun.util.Json;

/**
 * 端口开通执行线程
 * @author Administrator
 *
 */
public class PortDredgeExecuteInfo implements Runnable {
	
	private static final Logger logger = LoggerFactory.getLogger(PortDredgeExecuteInfo.class);
	
	private DevPortDredgeOrderService devPortDredgeOrderService;
	private String id;
	private String switchboardIp;
	private String portModeVlan;
	private String switchboardUser;
	private String switchboardPass;
	private String[] portDescribe;
	
	public PortDredgeExecuteInfo(){
		super();
	}
	public PortDredgeExecuteInfo(DevPortDredgeOrderService devPortDredgeOrderService,String id, String switchboardIp, String portModeVlan,String switchboardUser,String switchboardPass, String[] portDescribe){
		this.devPortDredgeOrderService = devPortDredgeOrderService;
		this.id = id;
		this.switchboardIp = switchboardIp;
		this.portModeVlan = portModeVlan;
		this.switchboardUser = switchboardUser;
		this.switchboardPass = switchboardPass;
		this.portDescribe = portDescribe;
	}
	
	@Override
	public void run() {
		logger.info("正在跑执行端口开通线程--------start-------");
		Json json = devPortDredgeOrderService.executeCommand(id, switchboardIp, portModeVlan, switchboardUser, switchboardPass, portDescribe);
		//根据最终结果来更改整个工单的状态
		List<DevPortCommandInfo> l = devPortDredgeOrderService.findCommandInfo(id);
		boolean b = false;
		for(DevPortCommandInfo f : l){
			if(f.getExecuteState()!=3){
				b = true;
				break;
			}
		}
		
		DevPortDredgeOrder port = new DevPortDredgeOrder();
		port.setId(id);
		port.setState(1);
		port.setExecuteState(json.getSuccess()==true && !b?3:4);
		devPortDredgeOrderService.editPortDredgeOrder(port);
		logger.info("正在跑执行端口开通线程--------end-------执行结果："+json.getSuccess());
	}

}
