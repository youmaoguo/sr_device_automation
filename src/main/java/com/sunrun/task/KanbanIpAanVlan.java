package com.sunrun.task;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RestController;

import com.sunrun.entity.DevOnlineTask;
import com.sunrun.entity.DevTaskExecute;
import com.sunrun.service.AddSwitchDeviceService;
import com.sunrun.service.DeviceAutomationService;
import com.sunrun.util.Json;
import com.sunrun.util.StringUtil;
 

@Controller
public class KanbanIpAanVlan  {
	 //注意，这里没有final      
    private static KanbanIpAanVlan single=null;  
    //静态工厂方法   
    public synchronized  static KanbanIpAanVlan getInstance() {  
          if (single == null) {    
              single = new KanbanIpAanVlan();  
          }    
         return single;  
    }  
      
    
	//标识方法是否在调用中 true为调用中，false标识调用完毕  
    private static boolean Flag=true;  
    public static boolean getFlag() {  
        return Flag;  
    }  
  
  
    public static   void setFlag(boolean flag) {  
        Flag = flag;  
    }  
 
	private static final Logger logger = LoggerFactory.getLogger(KanbanIpAanVlan.class);
	 
	/**
	 * 同步锁 - 去除重复从看板上申请到的ip
	 * @return
	 * @throws InterruptedException 
	 * @throws NumberFormatException 
	 */
	public  synchronized  Map<String, String> step2_appIpAndVlan(DeviceAutomationService deviceAutomationService,AddSwitchDeviceService addSwitchDeviceService,String thirdPartUrl, String auth,DevOnlineTask  task, String userName, Integer j1) throws NumberFormatException, InterruptedException{
		Double a = Math.random() * 100;
		System.out.println("my start is:" + a);
		 
		//2.从看板申请ip和vlan
		Json json = new Json();
		Map<String, String> map = new HashMap<String, String>();
		 

		json.setRet_code(200);
		json.setRet_info("");
		json.setSuccess(true);
		
		//json = addSwitchDeviceService.appIpAndVlan(thirdPartUrl, auth, task, userName, 1);
		//String sb = json.getData().toString();	//map中存放了ip和vlanId
		String sb="{\"ip\":\"10.3.135.245,10.3.135.244\",\"vlanId\":\"2135\"}";
		json.setData(sb); 
		try {
			org.json.JSONObject obj1 = new org.json.JSONObject(sb);
			String ip = obj1.getString("ip");
			String vlanId = obj1.getString("vlanId");
			
			//点击“继续添加设备后”防止申请到重复的ip
			boolean tag = true;
			DevOnlineTask t = new DevOnlineTask();
			t.setManagerIp(ip);
			List<DevOnlineTask> li = deviceAutomationService.findTask(t);
			if(li!=null && li.size()>1){
				tag = false;
			}
			if(!tag){
				json = addSwitchDeviceService.appIpAndVlan(thirdPartUrl, auth, task, userName, 2);
				sb = json.getData().toString();
				obj1 = new org.json.JSONObject(sb);
				ip = obj1.getString("ip");
				vlanId = obj1.getString("vlanId");
			}
			map.put("ip", ip);
			map.put("vlanId", vlanId);
		} catch (JSONException e) {
			 
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		java.util.Random random = new java.util.Random();// 定义随机类
		int result = random.nextInt(10); 
		TimeUnit.SECONDS.sleep(Long.parseLong(result + ""));
		System.out.println("my is end:" + a);
		
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
