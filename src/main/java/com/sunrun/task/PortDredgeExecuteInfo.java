package com.sunrun.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
	
	public PortDredgeExecuteInfo(){
		super();
	}
	public PortDredgeExecuteInfo(DevPortDredgeOrderService devPortDredgeOrderService,String id, String switchboardIp, String portModeVlan,String switchboardUser,String switchboardPass){
		this.devPortDredgeOrderService = devPortDredgeOrderService;
		this.id = id;
		this.switchboardIp = switchboardIp;
		this.portModeVlan = portModeVlan;
		this.switchboardUser = switchboardUser;
		this.switchboardPass = switchboardPass;
	}
	
	@Override
	public void run() {
		logger.info("正在跑执行端口开通线程--------start-------");
		Json json = devPortDredgeOrderService.executeCommand(id, switchboardIp, portModeVlan, switchboardUser, switchboardPass);
		//根据最终结果来更改整个工单的状态
		DevPortDredgeOrder port = new DevPortDredgeOrder();
		port.setId(id);
		port.setState(1);
		port.setExecuteState(json.getSuccess()==true?3:4);
		devPortDredgeOrderService.editPortDredgeOrder(port);
		logger.info("正在跑执行端口开通线程--------end-------执行结果："+json.getSuccess());
	}

}
