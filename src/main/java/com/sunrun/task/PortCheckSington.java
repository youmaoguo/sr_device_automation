package com.sunrun.task;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.sunrun.entity.DevOnlineTask;
import com.sunrun.service.AddSwitchDeviceService;
import com.sunrun.service.DeviceAutomationService;
import com.sunrun.util.Json;

@Component
public class PortCheckSington {

	private static final Logger logger = LoggerFactory.getLogger(PortCheckSington.class);
	PortCheck portCheck;  
    public  PortCheckSington() {  
    	portCheck = PortCheck.getInstance();   
    }  
	/**
	 * 同步锁 - 去除重复从看板上申请到的ip
	 * @return
	 */
	public Json portCheck(DeviceAutomationService deviceAutomationService, AddSwitchDeviceService addSwitchDeviceService, String thirdPartUrl, String auth, DevOnlineTask task, String userName, int tag){
		 Json json = new Json();
		 try{
		    while (true) { 
	            if (portCheck.getFlag()) {  
	            	portCheck.setFlag(false);
	            	 json = portCheck.portCheck(deviceAutomationService, addSwitchDeviceService, thirdPartUrl, auth, task, userName, tag);
	            	 portCheck.setFlag(true);
	                break;//执行完毕退出循环  
	            }else {  
	                Thread.sleep(1000);  
	            }  
	              
	        }
		}catch( Exception e){
        	logger.error(e.toString());
        	portCheck.setFlag(true);
        	json.setSuccess(false);
        	return json;
        }
		return json;
	}
	
}
