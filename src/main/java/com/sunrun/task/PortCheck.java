package com.sunrun.task;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.sunrun.entity.DevAreaSwitchboardIp;
import com.sunrun.entity.DevOnlineTask;
import com.sunrun.service.AddSwitchDeviceService;
import com.sunrun.service.DeviceAutomationService;
import com.sunrun.util.Json;
import com.sunrun.util.RestfulRequestUtil;

@Component
public class PortCheck {

	private static final Logger logger = LoggerFactory.getLogger(PortCheck.class);
	 //注意，这里没有final      
	   private static PortCheck single = null;  
	   //静态工厂方法   
	   public synchronized  static PortCheck getInstance() {  
	         if (single == null) {    
	             single = new PortCheck();  
	         }    
	        return single;  
	   }  
	     
	   
		//标识方法是否在调用中 true为调用中，false标识调用完毕  
	   private static boolean Flag=true;  
	   
	   public static boolean getFlag() {  
	       return Flag;  
	   }  
	   public static void setFlag(boolean flag) {  
	       Flag = flag;  
	   }  
	   
	   
	   @SuppressWarnings("finally")
	   public synchronized Json portCheck(DeviceAutomationService deviceAutomationService, AddSwitchDeviceService addSwitchDeviceService, String thirdPartUrl, String auth, DevOnlineTask task, String userName){
		   Json json = new Json();
			String info = " 判断汇聚交换机端口上是否有配置及端口状态是否为down,结果正常";
			Integer code = 200;	
			Boolean success = true;
			String mp = "", bp = "";
			try{
				DevAreaSwitchboardIp area = new DevAreaSwitchboardIp();
				//area.setAreaName(task.getAreaName());
				area.setAreaDescribe(task.getAreaName());
				List<DevAreaSwitchboardIp> li = deviceAutomationService.findAreaIp(area);
				
				JSONObject param = new JSONObject();
				param.put("method_name", "/interchanger/v1/portCheck");
				param.put("main_switchboard_ip", task.getMainSwitchboardIp());
				param.put("backup_switchboard_ip", task.getBackupSwitchboardIp());
				param.put("main_host", li.get(0).getDevName());
				param.put("main_user", li.get(0).getTelnetUser());
				param.put("main_pwd", li.get(0).getTelnetPwd());
				param.put("back_host", li.get(0).getBackupDevName());
				param.put("back_user", li.get(0).getBackupTelnetUser());
				param.put("back_pwd", li.get(0).getBackupTelnetPwd());
				String sb = RestfulRequestUtil.getResponse(thirdPartUrl, param, "POST", auth);
				Json j = (Json) JSONObject.parseObject(sb, Json.class);
				if(j.getRet_code()!=200){
					code = j.getRet_code();
					info = j.getRet_info();
					success = j.getSuccess();
				}else{
					//解析出取到的所有主备ip对应的端口
					//JSONObject result = (JSONObject) j.getData();
					org.json.JSONObject result = new org.json.JSONObject(j.getData().toString());
					Object main = result.getJSONArray(task.getMainSwitchboardIp());
					List<String> mainlist = com.alibaba.fastjson.JSONArray.parseArray(main.toString(), String.class);	//从接口中获取所有主汇聚端口
					
					Object backup = result.getJSONArray(task.getBackupSwitchboardIp());
					List<String> backuplist = null;
					if(backup!=null){
						backuplist = com.alibaba.fastjson.JSONArray.parseArray(backup.toString(), String.class);//从接口中获取所有备汇聚端口
					}
					
					List<String> mainp = new ArrayList<String>();	//保存数据库中所有使用了的主汇聚端口
					List<String> backp = new ArrayList<String>();	//保存数据库中所有使用了的备汇聚端口
					//从数据库查出所有未使用完（即switchState!=4）的主备端口，然后分配未使用的端口，
					List<DevOnlineTask> ports = deviceAutomationService.findPort(null);
					List<DevOnlineTask> pc = ports;
					for(int i=0;i<pc.size();i++){
						if(pc.get(i).getSwitchState()==4){
							ports.remove(i);
						}
					}
					
					for(int i=0;i<ports.size();i++){
						mainp.add(ports.get(i).getMainSwitchboardPort());
						backp.add(ports.get(i).getBackupSwitchboardPort());
					}
					int index = 0;
					for(int i=0;i<mainlist.size();i++){
						if(!mainp.contains(mainlist.get(i))){
							index = i;
							break;
						}
					}
					mp = mainlist.size()>=index ? mainlist.get(index) : ""; //选定好了主端口
					
					//理论上最好备端口跟主端口一样
					String bpc = "";
					for(int i=0;i<backuplist.size();i++){
						if(backuplist.get(i).equals(mp)){
							bpc = mp;
							break;
						}
					}
					if(!bpc.equals("")){
						boolean g = false;
						//假设找到了跟主端口一样的备端口，则再次比较下从数据库里已经使用的备端口
						//for(int jj=0;jj<backp.size();jj++){
							if(!backp.contains(bpc)){
								g = true;
								//break;
							}
						//}
						if(!g){
							int index2 = 0;
							for(int i=0;i<backuplist.size();i++){
								if(!backp.contains(backuplist.get(i))){
									index2 = i;
									break;
								}
							}
							bp = backuplist.size()>=index2 ? backuplist.get(index2) : "";
						}else{
							bp = bpc;
						}
						
					}else{
						int index2 = 0;
						for(int i=0;i<backuplist.size();i++){
							if(!backp.contains(backuplist.get(i))){
								index2 = i;
								break;
							}
						}
						bp = backuplist.size()>=index2 ? backuplist.get(index2) : "";
					}
					
				}
				
			}catch(Exception e){
				e.printStackTrace();
				logger.error(" 判断汇聚交换机端口上是否有配置及端口状态是否为down，结果不正常");
				info = " 判断汇聚交换机端口上是否有配置及端口状态是否为down，结果不正常";
				code = 500;
				success = false;
				throw new RuntimeException(e);
			}finally{
				//记录任务执行步骤
				DevOnlineTask t = new DevOnlineTask();
				t.setMainSwitchboardPort(mp);
				t.setBackupSwitchboardPort(bp);
				t.setId(task.getId());
				t.setUpdate_user(userName);
				addSwitchDeviceService.writeProcess(t, 5, "判断汇聚交换机端口上是否有配置及端口状态是否为down", success, userName, success!=true?info:"");
				
				json.setRet_code(code);
				json.setRet_info(info);
				json.setSuccess(success);
				return json;
			}
	   }
	
}
