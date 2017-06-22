package com.sunrun.task;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.sunrun.entity.DevOnlineTask;
import com.sunrun.entity.DevTaskExecute;
import com.sunrun.service.AddSwitchDeviceService;
import com.sunrun.service.DeviceAutomationService;
import com.sunrun.util.Json;
import com.sunrun.util.StringUtil;
 
 

@Controller
public class ManagerIpAanVlan  {

	private static final Logger logger = LoggerFactory.getLogger(ManagerIpAanVlan.class);
	KanbanIpAanVlan kanbanIpAanVlan;  
    public  ManagerIpAanVlan() {  
    	kanbanIpAanVlan=KanbanIpAanVlan.getInstance();   
    }  
	/**
	 * 同步锁 - 去除重复从看板上申请到的ip
	 * @return
	 */
	public   Map<String, String> step2_appIpAndVlan(DeviceAutomationService deviceAutomationService,AddSwitchDeviceService addSwitchDeviceService,String thirdPartUrl, String auth,DevOnlineTask  task, String userName, Integer j1){
		 Map<String, String>  returnMap=new  HashMap<String, String>();
		

		 try{
		    while (true) {  
	            if (kanbanIpAanVlan.getFlag()) {    
          	kanbanIpAanVlan.setFlag(false);
	            	 returnMap=kanbanIpAanVlan.step2_appIpAndVlan(deviceAutomationService,addSwitchDeviceService,thirdPartUrl, auth, task, userName, j1);
	            	 kanbanIpAanVlan.setFlag(true);
	                break;//执行完毕退出循环  
	            }else {  
	                  
	                    Thread.sleep(1000);  
	                    //logger.info("kanbanIpAanVlan sleep");
	                   
	            }  
	              
	        } }catch( Exception e){
	        	logger.error(e.toString());
	        	 kanbanIpAanVlan.setFlag(true);
	        }
		    
			 return returnMap;
	}
	
	
}
