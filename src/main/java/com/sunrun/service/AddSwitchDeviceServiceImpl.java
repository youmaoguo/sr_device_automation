package com.sunrun.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sunrun.entity.DevAreaSwitchboardIp;
import com.sunrun.entity.DevExclusiveSwitchboardConn;
import com.sunrun.entity.DevExclusiveSwitchboardInfo;
import com.sunrun.entity.DevIosVersions;
import com.sunrun.entity.DevOnlineTask;
import com.sunrun.entity.DevScriptConfig;
import com.sunrun.entity.DevTaskExecute;
import com.sunrun.entity.view.DevOnlineBatchTaskView;
import com.sunrun.mapper.DevExclusiveSwitchboardConnMapper;
import com.sunrun.mapper.DevIosVersionsMapper;
import com.sunrun.mapper.DevScriptConfigMapper;
import com.sunrun.util.Json;
import com.sunrun.util.RestfulRequestUtil;
import com.sunrun.util.StringUtil;

@Service("addSwitchDeviceService")
public class AddSwitchDeviceServiceImpl implements AddSwitchDeviceService {
	private static final Logger logger = LoggerFactory.getLogger(AddSwitchDeviceServiceImpl.class);
	
	@Resource
	private DeviceAutomationService deviceAutomationService;
	@Resource
	private DevScriptConfigMapper devScriptConfigMapper;
	@Resource
	private DevExclusiveSwitchboardConnMapper devExclusiveSwitchboardConnMapper;
	@Resource
	private DevIosVersionsMapper devIosVersionsMapper;
	
	@Value("${device.serverIp}")
	private String serverIp;
	
	
	@SuppressWarnings("finally")
	@Override
	public Json saveDeviceBaseInfo(DevOnlineTask task, String userName) {
		Json json = new Json();
		String info = "添加交换机设备品牌、型号、主机名等基本信息成功";
		Integer code = 201;	//201:用户新建或修改数据成功
		Boolean success = true;
		try{
			success = deviceAutomationService.saveDevice(task, 1,  userName);
			if(!success){
				code = 500;
				info = "添加交换机设备品牌、型号、主机名等基本信息失败";
			}
				
		}catch(Exception e){
			e.printStackTrace();
			logger.error("添加交换机设备品牌、型号、主机名等基本信息失败");
			info = "添加交换机设备品牌、型号、主机名等基本信息失败";
			code = 500;
			success = false;
			throw new RuntimeException(e);
		}finally{
			if(success){
				//记录任务执行步骤
				task.setUpdate_user(userName);
				writeProcess(task, 1, info, success, userName, null);
			}
			
			json.setRet_code(code);
			json.setRet_info(info);
			json.setSuccess(success);
			return json;
		}
	}

	@SuppressWarnings("finally")
	@Override
	public Json appIpAndVlan(String thirdPartUrl, String auth, DevOnlineTask task, String userName) {
		Json json = new Json();
		String info = "从看板申请ip和vlan成功";
		Integer code = 200;	
		Boolean success = true;
		Map<String, String> data = new HashMap<String, String>();
		String vlanId = "", ips = "";
		try{
			DevAreaSwitchboardIp area = new DevAreaSwitchboardIp();
			area.setAreaName(task.getAreaName());
			List<DevAreaSwitchboardIp> li = deviceAutomationService.findAreaIp(area);
			
			JSONObject param = new JSONObject();
			param.put("method_name", "/Kanban/v1/apply_ip");
			param.put("subnet", li.get(0).getSubnet());	//本系统申请ip的网段(根据区域名称查询表'dev_area_switchboard_ip'中subnet)
			param.put("mount", "1");		//申请数量1
			String sb = RestfulRequestUtil.getResponse(thirdPartUrl, param, "POST", auth);
			Json j = (Json) JSONObject.parseObject(sb, Json.class);
			if(j.getRet_code()!=200){
				code = j.getRet_code();
				info = j.getRet_info();
				success = j.getSuccess();
			}else{
				org.json.JSONObject obj = new org.json.JSONObject(j.getData().toString());
				ips = obj.getString("ips");	//多个ip用英文逗号隔开,(主要作用于生成汇聚和接入接入交换机配置信息)
				vlanId = obj.getString("vlanId");
				data.put("ip", ips);
				data.put("vlanId", vlanId);
				if(StringUtils.isEmpty(vlanId)){
					code = 500;
					success = false;
					info = "从看板上获取vlan为空";
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			logger.error("从看板申请ip和vlan出错");
			info = "从看板申请ip和vlan失败";
			code = 500;
			success = false;
			throw new RuntimeException(e);
		}finally{
			//记录任务执行步骤
			DevOnlineTask t = new DevOnlineTask();
			t.setId(task.getId());
			t.setVlan(vlanId);
			t.setManagerIp(ips);
			t.setUpdate_user(userName);
			writeProcess(t, 2, info, success, userName, null);
			
			json.setRet_code(code);
			json.setRet_info(info);
			json.setSuccess(success);
			json.setData(data); 
			return json;
		}
	}

	
	@SuppressWarnings("finally")
	@Override
	public Json pingFun(String thirdPartUrl, String auth, DevOnlineTask task, Map<String, String> map, String userName) {
		Json json = new Json();
		String info = "ip地址ping不通，可用";
		Integer code = 200;	
		Boolean success = true;
		try{
			DevAreaSwitchboardIp area = new DevAreaSwitchboardIp();
			area.setAreaName(task.getAreaName());
			List<DevAreaSwitchboardIp> li = deviceAutomationService.findAreaIp(area);
			JSONObject param = new JSONObject();
			param.put("method_name", "/interchanger/v1/pingFun");
			param.put("host", task.getMainSwitchboardIp());//主汇聚ip
			param.put("port", li.get(0).getTelnetPort());
			param.put("user", li.get(0).getTelnetUser());
			param.put("password", li.get(0).getTelnetPwd());
			param.put("type", li.get(0).getDevType());//dev_type
			
			String ips = map.get("ip");
			String[] ip = ips.split(",");
			for(int i=0;i<ip.length;i++){
				param.put("ip", ip[i]);
				String sb = RestfulRequestUtil.getResponse(thirdPartUrl, param, "POST", auth);
				Json j = (Json) JSONObject.parseObject(sb, Json.class);
				if(j.getRet_code()!=200){
					code = j.getRet_code();
					info = j.getRet_info();
					success = j.getSuccess();
					break;
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
			logger.error("ip地址ping的通，不可用");
			info = "ip地址ping的通，不可用";
			code = 500;
			success = false;
			throw new RuntimeException(e);
		}finally{
			//记录任务执行步骤
			DevOnlineTask t = new DevOnlineTask();
			t.setId(task.getId());
			t.setUpdate_user(userName);
			writeProcess(t, 3, info, success, userName, null);
			
			json.setRet_code(code);
			json.setRet_info(info);
			json.setSuccess(success);
			return json;
		}
	}

	@SuppressWarnings("finally")
	@Override
	public Json adminRequestIP(String thirdPartUrl, String auth, DevOnlineTask task, Map<String, String> map, String userName, int state, String usercode) {
		Json json = new Json();
		String info = "ip地址回填成功";
		Integer code = 200;	
		Boolean success = true;
		try{
			DevAreaSwitchboardIp area = new DevAreaSwitchboardIp();
			area.setAreaName(task.getAreaName());
			List<DevAreaSwitchboardIp> li = deviceAutomationService.findAreaIp(area);
			
			JSONObject param = new JSONObject();
			param.put("method_name", "/Kanban/v1/adminRequestIP");
			param.put("ips", map.get("ip"));//其实就是task的管理口ip
			param.put("subnet", li.get(0).getSubnet());	//本系统申请ip的网段(根据区域名称查询表'dev_area_switchboard_ip'中subnet)
			param.put("state", state);
			param.put("assignerId", usercode);//申请人工号
			param.put("assignerName", usercode);//申请人姓名
			param.put("contactId", usercode);//contactId
			param.put("contactName", userName);//使用人姓名
			param.put("bizsysName", "门户portal");//业务系统
			param.put("bizsysId", "portal");//业务系统ID
			param.put("description", "门户portal项目交换机模块回填ip");
			String sb = RestfulRequestUtil.getResponse(thirdPartUrl, param, "POST", auth);
			Json j = (Json) JSONObject.parseObject(sb, Json.class);
			if(j.getRet_code()!=200){
				code = j.getRet_code();
				info = j.getRet_info();
				success = j.getSuccess();
			}
			
		}catch(Exception e){
			e.printStackTrace();
			logger.error("ip地址回填失败");
			info = "ip地址回填失败";
			code = 500;
			success = false;
			throw new RuntimeException(e);
		}finally{
			//记录任务执行步骤
			if(state==1){
				DevOnlineTask t = new DevOnlineTask();
				t.setId(task.getId());
				t.setUpdate_user(userName);
				writeProcess(t, 4, info, success, userName, null);
			}
			
			json.setRet_code(code);
			json.setRet_info(info);
			json.setSuccess(success);
			return json;
		}
	}

	@SuppressWarnings("finally")
	@Override
	public Json portCheck(String thirdPartUrl, String auth, DevOnlineTask task, String userName) {
		Json json = new Json();
		String info = " 判断汇聚交换机端口上是否有配置及端口状态是否为down,结果正常";
		Integer code = 200;	
		Boolean success = true;
		String mp = "", bp = "";
		try{
			DevAreaSwitchboardIp area = new DevAreaSwitchboardIp();
			area.setAreaName(task.getAreaName());
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
					for(int jj=0;jj<backp.size();jj++){
						if(!backp.contains(bpc)){
							g = true;
							break;
						}
					}
					if(g){
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
			writeProcess(t, 5, info, success, userName, null);
			
			json.setRet_code(code);
			json.setRet_info(info);
			json.setSuccess(success);
			return json;
		}
	}

	@SuppressWarnings("finally")
	@Override
	public Json CreatConverPage(String thirdPartUrl, String auth, DevOnlineTask task, Map<String, String> map, String userName) {
		/*Json json = new Json();
		String info = "生成汇聚交换机配置 正常";
		Integer code = 200;	
		Boolean success = true;
		try{
			JSONObject param = new JSONObject();
			param.put("method_name", "/interchanger/v1/CreatConverPage");
			param.put("ipPortNameUserPass1", task.getMainSwitchboardIp() main_ip6);//主汇聚交换机ip
			param.put("ipPortNameUserPass2", task.getBackupSwitchboardIp() back_ip6);//备汇聚交换机ip
			param.put("mainSwitchboardPort", task.getMainSwitchboardPort() main_port6);//主汇聚交换机端口
			param.put("backupSwitchboardPort", task.getBackupSwitchboardPort() back_port6);//备汇聚交换机端口
			param.put("main_host6", back_host6);
			param.put("back_host6", back_host6);
			param.put("main_user6", main_user6);
			param.put("back_user6", back_user6);
			param.put("main_pwd6", main_pwd6);
			param.put("back_pwd6", back_pwd6);
			param.put("accHostnmae", task.getHostName());	//接入设备对应的host名称
			param.put("newip", map.get("ip"));			//在看板系统上申请的IP地址
			param.put("Type", type6);			//接入交换机的设备类型，分别为4948E和5548
			String sb = RestfulRequestUtil.getResponse(thirdPartUrl, param, "POST", auth);
			Json j = (Json) JSONObject.parseObject(sb, Json.class);
			if(j.getRet_code()!=200){
				code = j.getRet_code();
				info = j.getRet_info();
				success = j.getSuccess();
			}else{
				org.json.JSONObject obj1 = new org.json.JSONObject(j.getData().toString());
				org.json.JSONArray ip1 = obj1.getJSONArray(param.get("ipPortNameUserPass1").toString());
				org.json.JSONArray ip2 = obj1.getJSONArray(param.get("ipPortNameUserPass1").toString());
				List<String> l1 = JSONArray.parseArray(ip1.toString(), String.class);	//主汇聚交换机配置信息
				List<String> l2 = JSONArray.parseArray(ip2.toString(), String.class);	//备汇聚交换机配置信息
				
				//接下来要保存相关的汇聚交换机配置信息	
				for(int i=0;i<l1.size();i++){
					DevScriptConfig config = new DevScriptConfig();
					config.setId(StringUtil.getUuid());
					config.setDevType(2); //'设备类型：1、接入交换机； 2 、主汇聚交换机； 3 、备汇聚交换机',
					config.setObjectId(task.getId());
					config.setScriptInfo(l1.get(i));
					config.setScriptOrder(i+1);
					config.setScriptType(1); 
					devScriptConfigMapper.saveDevScriptConfig(config);
				}
				for(int i=0;i<l2.size();i++){
					DevScriptConfig config = new DevScriptConfig();
					config.setId(StringUtil.getUuid());
					config.setDevType(3); //'设备类型：1、接入交换机； 2 、主汇聚交换机； 3 、备汇聚交换机',
					config.setObjectId(task.getId());
					config.setScriptInfo(l1.get(i));
					config.setScriptOrder(i+1);
					config.setScriptType(1); 
					devScriptConfigMapper.saveDevScriptConfig(config);
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
			logger.error("生成汇聚交换机配置 结果不正常");
			info = "生成汇聚交换机配置 结果不正常";
			code = 500;
			success = false;
			throw new RuntimeException(e);
		}finally{
			//记录任务执行步骤
			DevOnlineTask t = new DevOnlineTask();
			t.setId(task.getId());
			t.setUpdate_user(userName);
			writeProcess(t, 6, info, success, userName, null);
			
			json.setRet_code(code);
			json.setRet_info(info);
			json.setSuccess(success);
			return json;
		}*/
		return null;
	}

	@SuppressWarnings("finally")
	@Override
	public Json CreatAccessPage(String thirdPartUrl, String auth, DevOnlineTask task, Map<String, String> map, String userName) {
		/*Json json = new Json();
		String info = "生成接入交换机配置正常";
		Integer code = 200;	
		Boolean success = true;
		try{
			JSONObject param = new JSONObject();
			param.put("method_name", "/interchanger/v1/CreatAccessPage");
			param.put("ipPortName1", task.getMainSwitchboardIp() main_ip7);//主ip	???
			param.put("ipPortName2", task.getBackupSwitchboardIp() back_ip7);//备ip	???
			param.put("mainSwitchboardPort", task.getMainSwitchboardPort() main_port7);//主端口	???
			param.put("backupSwitchboardPort", task.getBackupSwitchboardPort() back_port7);//备端口	???
			param.put("main_user7", main_host7);
			param.put("back_user7", back_host7);
			param.put("accHostName", task.getHostName());//接入设备对应的host名称
			param.put("vlanNu", map.get("vlanId"));//接入设备的管理Vlan号
			param.put("description", "");//接入设备的描述配置信息
			param.put("newip", map.get("ip"));//在看板系统上申请的IP地址
			param.put("Type", type7);//接入交换机的设备类型，分别为4948E和5548
			String sb = RestfulRequestUtil.getResponse(thirdPartUrl, param, "POST", auth);
			Json j = (Json) JSONObject.parseObject(sb, Json.class);
			if(j.getRet_code()!=200){
				code = j.getRet_code();
				info = j.getRet_info();
				success = j.getSuccess();
			}else{
				List<String> l = JSONArray.parseArray(j.getData().toString(), String.class);
				//接下来要保存相关的接入交换机配置信息  	
				for(int i=0;i<l.size();i++){
					DevScriptConfig config = new DevScriptConfig();
					config.setId(StringUtil.getUuid());
					config.setDevType(1); //'设备类型：1、接入交换机； 2 、主汇聚交换机； 3 、备汇聚交换机',
					config.setObjectId(task.getId());
					config.setScriptInfo(l.get(i));
					config.setScriptOrder(i+1);
					config.setScriptType(1); 
					devScriptConfigMapper.saveDevScriptConfig(config);
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
			logger.error("生成接入交换机配置结果不正常");
			info = "生成接入交换机配置 结果不正常";
			code = 500;
			success = false;
			throw new RuntimeException(e);
		}finally{
			json.setRet_code(code);
			json.setRet_info(info);
			json.setSuccess(success);
			//记录任务执行步骤
			DevOnlineTask t = new DevOnlineTask();
			t.setId(task.getId());
			t.setUpdate_user(userName);
			writeProcess(t, 7, info, success, userName, null);
			return json;
		}*/
		return null;
	}

	@SuppressWarnings("finally")
	@Transactional
	@Override
	public Json exclusiveSwitchboardConn(DevExclusiveSwitchboardConn conn, DevOnlineTask task, String userName) {
		Json json = new Json();
		String info = "保存带外交换机端口与接入交换机的连接信息成功";
		Integer code = 200;	
		Boolean success = true;
		try{
			deviceAutomationService.updateTask2(task, null, null, userName);
		}catch(Exception e){
			e.printStackTrace();
			logger.error("保存带外交换机端口与接入交换机的连接信息失败");
			info = "保存带外交换机端口与接入交换机的连接信息失败";
			code = 500;
			success = false;
			throw new RuntimeException(e);
		}finally{
			//记录任务执行步骤
			//writeProcess(task, 8, info, success, userName, null);
			
			json.setRet_code(code);
			json.setRet_info(info);
			json.setSuccess(success);
			return json;
		}
		
	}

	@SuppressWarnings("finally")
	@Override
	public Json managementPort(String thirdPartUrl, String auth, DevOnlineTask task, String userName) {
		Json json = new Json();
		String info = "请求写入接入交换机配置管理口IP正常";
		Integer code = 200;	
		Boolean success = true;
		Object data = null;
		try{
			/*DevAreaSwitchboardIp area = new DevAreaSwitchboardIp();
			area.setAreaName(task.getAreaName());
			List<DevAreaSwitchboardIp> li = deviceAutomationService.findAreaIp(area);*/
			
			DevExclusiveSwitchboardInfo dev = new DevExclusiveSwitchboardInfo();
			dev.setExclusiveSwitchboardIp(task.getExclusiveSwitchboardIp());
			dev.setExclusiveSwitchboardPort(task.getExclusiveSwitchboardPort());
			DevExclusiveSwitchboardInfo d = deviceAutomationService.findDevExclusiveSwitchboardInfo(dev).get(0);
			
			JSONObject param = new JSONObject();
			param.put("method_name", "/interchanger/v1/managementPort");
			param.put("host", d.getExclusiveSwitchboardIp());		//交换机的telnet登录IP地址
			param.put("port", d.getExclusiveSwitchboardPort());		//交换机的telnet登录端口号
			param.put("type", task.getModelName());		//交换机的类型，分别为4948E和5548
			
			//通过带外交换机的ip和端口查询
			/*DevExclusiveSwitchboardInfo dev = new DevExclusiveSwitchboardInfo();
			dev.setExclusiveSwitchboardIp(task.getExclusiveSwitchboardIp());
			dev.setExclusiveSwitchboardPort(task.getExclusiveSwitchboardPort());
			DevExclusiveSwitchboardInfo d = deviceAutomationService.findDevExclusiveSwitchboardInfo(dev).get(0);*/
			param.put("user", d.getTelnetUser());		//交换机的telnet登录账号 没有
			param.put("password", d.getTelnetPwd());	//交换机的telnet登录密码 没有
			
			String sb = RestfulRequestUtil.getResponse(thirdPartUrl, param, "POST", auth);
			Json j = (Json) JSONObject.parseObject(sb, Json.class);
			if(j.getRet_code()!=200){
				code = j.getRet_code();
				info = j.getRet_info();
				success = j.getSuccess();
				if(j.getRet_code()==505){
					List<String> l = JSONArray.parseArray(j.getData().toString(), String.class);
					data = l;
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
			logger.error("请求写入接入交换机配置管理口IP不正常");
			info = "请求写入接入交换机配置管理口IP不正常";
			code = 500;
			success = false;
			throw new RuntimeException(e);
		}finally{
			//记录任务执行步骤
			DevOnlineTask t = new DevOnlineTask();
			t.setId(task.getId());
			t.setUpdate_user(userName);
			writeProcess(t, 7, info, success, userName, data!=null ? data.toString() : null);
			
			json.setRet_code(code);
			json.setRet_info(info);
			json.setSuccess(success);
			json.setData(data);
			return json;
		}
		
	}

	@SuppressWarnings("finally")
	@Override
	public Json findDeviceIosVersion(String thirdPartUrl, String auth, DevOnlineTask task, String userName){
		Json json = new Json();
		try{
			DevExclusiveSwitchboardInfo dev = new DevExclusiveSwitchboardInfo();
			dev.setExclusiveSwitchboardIp(task.getExclusiveSwitchboardIp());
			dev.setExclusiveSwitchboardPort(task.getExclusiveSwitchboardPort());
			DevExclusiveSwitchboardInfo d = deviceAutomationService.findDevExclusiveSwitchboardInfo(dev).get(0);
			
			JSONObject param = new JSONObject();
			param.put("method_name", "/interchanger/v1/checkIos");
			param.put("host", d.getExclusiveSwitchboardIp());		//交换机的telnet登录IP地址
			param.put("port", Integer.parseInt(d.getExclusiveSwitchboardPort()));//交换机的telnet登录端口号
			param.put("user", d.getTelnetUser()!=null ? d.getTelnetUser() : "");		//交换机的telnet登录账号
			param.put("password", d.getTelnetPwd()!=null ? d.getTelnetPwd() : "");	//交换机的telnet登录密码
			param.put("type", d.getExclusiveSwitchboardType());		//交换机的类型，分别为4948E和5548
			
			String sb = RestfulRequestUtil.getResponse(thirdPartUrl, param, "POST", auth);
			json = (Json) JSONObject.parseObject(sb, Json.class);
			if(json.getRet_code()==200){
				List<String> l = JSONArray.parseArray(json.getData().toString(), String.class);
				json.setData(l);
			}
			
		}catch(Exception e){
			e.printStackTrace();
			logger.error("查询交换机实际版本有问题");
		}
		return json;
	}
	
	@SuppressWarnings("finally")
	@Override
	public Json checkIosVersion(String thirdPartUrl, String auth, DevOnlineTask task, String userName) {
		Json json = new Json();
		String info = "确认接入交换机ios版本正常";
		Integer code = 200;	
		Boolean success = true;
		Object data = null;
		try{
			DevExclusiveSwitchboardInfo dev = new DevExclusiveSwitchboardInfo();
			dev.setExclusiveSwitchboardIp(task.getExclusiveSwitchboardIp());
			dev.setExclusiveSwitchboardPort(task.getExclusiveSwitchboardPort());
			DevExclusiveSwitchboardInfo d = deviceAutomationService.findDevExclusiveSwitchboardInfo(dev).get(0);
			
			//根据交换机品牌型号去查出最新的ios版本
			DevIosVersions version = new DevIosVersions();
			version.setBrandName(task.getBrandName());
			version.setModelName(task.getModelName());
			List<DevIosVersions> li = devIosVersionsMapper.findIosVersion(version);
			
			//查询交换机的版本 与最新版本作比较  ???
			/*Json jj = findDeviceIosVersion(thirdPartUrl, auth, task, userName);
			if(jj.getRet_code()==200){
				List<String> l = (List<String>) jj.getData();
				
			}*/
			String[] currentIosVersion = task.getCurrentIosVersion().split(",");
			String sourceFileName = "", iosName = "";
			for(int i=0;i<currentIosVersion.length;i++){
				if(currentIosVersion[i].contains("kickstart")){
					sourceFileName = currentIosVersion[i];
				}
				if(!currentIosVersion[i].contains("kickstart")){
					iosName = currentIosVersion[i];
				}
			}
			if(li!=null && li.size()>0){
				String newVersion = li.get(0).getIosVersion();
				//如果当前版本和最新版本不一致 则更新当前版本
				if(!task.getCurrentIosVersion().contains(newVersion)){
					JSONObject param = new JSONObject();
					param.put("method_name", "/interchanger/v1/updateIos");
					param.put("host", d.getExclusiveSwitchboardIp());		//交换机的telnet登录IP地址
					param.put("port", Integer.parseInt(d.getExclusiveSwitchboardPort()));//交换机的telnet登录端口号
					param.put("user", d.getTelnetUser()!=null ? d.getTelnetUser() : "");		//交换机的telnet登录账号
					param.put("password", d.getTelnetPwd()!=null ? d.getTelnetPwd() : "");	//交换机的telnet登录密码
					param.put("type", d.getExclusiveSwitchboardType());		//交换机的类型，分别为4948E和5548
					param.put("serverIp", serverIp);		//更新源服务器的IP 配置文件静态获得
					
					if(d.getExclusiveSwitchboardType().equals("5548")){
						param.put("desFileName", iosName);	//目的文件名 
						param.put("sourceFileName", sourceFileName);//源文件名 
						param.put("iosName", iosName);		//IOS名称
					}else if(d.getExclusiveSwitchboardType().equals("4948E")){
						param.put("desFileName", newVersion);	//目的文件名 						
						param.put("sourceFileName", newVersion);//源文件名 
						param.put("iosName", newVersion);		//IOS名称
					}
					param.put("updateId", task.getId());	//请求需用回调的ID updateId 
					String sb = RestfulRequestUtil.getResponse(thirdPartUrl, param, "POST", auth);
					Json j = (Json) JSONObject.parseObject(sb, Json.class);
					if(j.getRet_code()!=200){
						code = j.getRet_code();
						info = j.getRet_info();
						success = j.getSuccess();
					}
				}
				
			}
			
		}catch(Exception e){
			e.printStackTrace();
			logger.error("确认接入交换机ios版本程序出现异常");
			info = "确认接入交换机ios版本程序出现异常";
			code = 500;
			success = false;
			throw new RuntimeException(e);
		}finally{
			//记录任务执行步骤
			DevOnlineTask t = new DevOnlineTask();
			t.setId(task.getId());
			t.setUpdate_user(userName);
			writeProcess(t, 8, info, success, userName, null);
			
			json.setRet_code(code);
			json.setRet_info(info);
			json.setSuccess(success);
			json.setData(data);
			return json;
		}
		
	}

	@SuppressWarnings("finally")
	@Override
	public Json writeAccessConfig(String thirdPartUrl, String auth, String taskId, String userName) {
		/*Json json = new Json();
		String info = "写入接入交换机配置正常";
		Integer code = 200;	
		Boolean success = true;
		Object data = null;
		try{
			//查询出接入接入交换机配置信息
			DevScriptConfig config = new DevScriptConfig();
			config.setDevType(1);
			config.setObjectId(taskId);
			config.setScriptOrder(1);
			List<DevScriptConfig> li = devScriptConfigMapper.findDevScriptConfig(config);
			List<String> configs = null;
			for(int i=0;i<li.size();i++){
				configs = new ArrayList<String>();
				configs.add(li.get(i).getScriptInfo());
			}
			JSONObject param = new JSONObject();
			param.put("method_name", "/interchanger/v1/writeAccessConfig");
			param.put("host", host11);		//交换机的telnet登录IP地址
			param.put("port", port11);		//交换机的telnet登录端口号
			param.put("user", user11);		//交换机的telnet登录账号
			param.put("password", pwd11);	//交换机的telnet登录密码
			param.put("type", type11);		//交换机的类型，分别为4948E和5548
			param.put("commands", configs);	//需要写入接入交换机的命令列表集合
			String sb = RestfulRequestUtil.getResponse(thirdPartUrl, param, "POST", auth);
			Json j = (Json) JSONObject.parseObject(sb, Json.class);
			if(j.getRet_code()!=200){
				code = j.getRet_code();
				info = j.getRet_info();
				success = j.getSuccess();
				if(j.getRet_code()==505){
					List<String> l = JSONArray.parseArray(j.getData().toString(), String.class);
					data = l;
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
			logger.error("写入接入交换机配置不正常");
			info = "写入接入交换机配置不正常";
			code = 500;
			success = false;
			throw new RuntimeException(e);
		}finally{
			//记录任务执行步骤
			DevOnlineTask t = new DevOnlineTask();
			t.setId(taskId);
			t.setUpdate_user(userName);
			writeProcess(t, 9, info, success, userName, data.toString());
			
			json.setRet_code(code);
			json.setRet_info(info);
			json.setSuccess(success);
			json.setData(data);
			return json;
		}*/
		return null;
		
	}

	@SuppressWarnings("finally")
	@Override
	public Json SendEmailswitchDevice(String thirdPartUrl, String auth, String[] taskId, String emails, String names, String title, String content, String userName) {
		Json json = new Json();
		String info = "上线交换机邮件发送通知正常";
		Integer code = 200;	
		Boolean success = true;
		String id = StringUtil.getUuid();
		try{
			JSONObject param = new JSONObject();
			param.put("id", id);
			param.put("userName", userName);
			param.put("sendName", userName);
			param.put("mailType", 2);
			param.put("receiveName", names);
			param.put("mailConsigneeEmail", emails);
			param.put("title", title);
			param.put("log", content);
			
			String sb = RestfulRequestUtil.getResponse(thirdPartUrl, param, "POST", auth);
			Json j = (Json) JSONObject.parseObject(sb, Json.class);
			code = j.getRet_code();
			info = j.getRet_info();
			success = j.getSuccess();
			
		}catch(Exception e){
			e.printStackTrace();
			logger.error("上线交换机邮件发送通知程序不正常");
			info = "上线交换机邮件发送通知程序不正常";
			code = 500;
			success = false;
			throw new RuntimeException(e);
		}finally{
			//记录任务执行步骤
			for(int i=0;i<taskId.length;i++){
				DevOnlineTask t = new DevOnlineTask();
				t.setId(taskId[i]);
				t.setUpdate_user(userName);
				t.setEmailId(id);
				writeProcess(t, 10, info, success, userName, null);
			}
			
			json.setRet_code(code);
			json.setRet_info(info);
			json.setSuccess(success);
			return json;
		}
	}

	@SuppressWarnings("finally")
	@Override
	public Json switchDeviceITIL(String thirdPartUrl, String itilPlannedEnd, String[] taskId, String userName, String usercode) {
		Json json = new Json();
		String info = "上线交换机ITIL工单申请正常";
		Integer code = 201;	
		Boolean success = true;
		try{
			//每个task任务不能重复申请itil
			for(int i=0;i<taskId.length;i++){
				DevOnlineBatchTaskView batchView = new DevOnlineBatchTaskView();
				batchView.setId(taskId[i]);
				DevOnlineBatchTaskView view = deviceAutomationService.findTaskById(batchView);
				if(view!=null && !StringUtils.isEmpty(view.getItilNumber())){
					success = false;
					break;
				}
			}
			if(!success){
				json.setRet_code(500);
				json.setRet_info("已有工单号的task任务不能重复申请ITIL");
				json.setSuccess(false);
				return json;
			}
			
			boolean b = deviceAutomationService.switchDeviceITIL(thirdPartUrl, itilPlannedEnd, userName, taskId, usercode);
			if(!b){
				info = "上线交换机ITIL工单申请程序不正常";
				code = 500;
				success = false;
			}
		}catch(Exception e){
			e.printStackTrace();
			logger.error("上线交换机ITIL工单申请程序不正常");
			info = "上线交换机ITIL工单申请程序不正常";
			code = 500;
			success = false;
			throw new RuntimeException(e);
		}finally{
			//记录任务执行步骤
			for(int i=0;i<taskId.length;i++){
				DevOnlineTask t = new DevOnlineTask();
				t.setId(taskId[i]);
				t.setUpdate_user(userName);
				writeProcess(t, 11, info, success, userName, null);
			}
			
			json.setRet_code(code);
			json.setRet_info(info);
			json.setSuccess(success);
			return json;
		}
	}

	@SuppressWarnings("finally")
	@Override
	public Json writeGatherConfig(String thirdPartUrl, String auth, String taskId, String userName) {
		/*Json json = new Json();
		String info = "写入汇聚交换机配置正常";
		Integer code = 200;	
		Boolean success = true;
		Object data = null;
		try{
			//查询出汇聚交换机配置信息
			DevScriptConfig config = new DevScriptConfig();
			config.setDevType(2);
			config.setObjectId(taskId);
			config.setScriptOrder(1);
			List<DevScriptConfig> li = devScriptConfigMapper.findDevScriptConfig(config);
			List<String> configs = null;
			for(int i=0;i<li.size();i++){
				configs = new ArrayList<String>();
				configs.add(li.get(i).getScriptInfo());
			}
			
			JSONObject param = new JSONObject();
			param.put("method_name", "/interchanger/v1/writeGatherConfig");
			param.put("host", host14);		//交换机的telnet登录IP地址
			param.put("port", port14);		//交换机的telnet登录端口号
			param.put("user", user14);		//交换机的telnet登录账号
			param.put("password", pwd14);	//交换机的telnet登录密码
			param.put("type", type14);		//交换机的类型，分别为4948E和5548
			param.put("commands", configs);	//需要写入接入交换机的命令列表集合
			String sb = RestfulRequestUtil.getResponse(thirdPartUrl, param, "POST", auth);
			Json j = (Json) JSONObject.parseObject(sb, Json.class);
			if(j.getRet_code()!=200){
				code = j.getRet_code();
				info = j.getRet_info();
				success = j.getSuccess();
				if(j.getRet_code()==505){
					List<String> l = JSONArray.parseArray(j.getData().toString(), String.class);
					data = l;
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
			logger.error("写入汇聚交换机配置不正常");
			info = "写入汇聚交换机配置不正常";
			code = 500;
			success = false;
			throw new RuntimeException(e);
		}finally{
			//记录任务执行步骤
			DevOnlineTask t = new DevOnlineTask();
			t.setId(taskId);
			t.setUpdate_user(userName);
			writeProcess(t, 14, info, success, userName, data.toString());
			
			json.setRet_code(code);
			json.setRet_info(info);
			json.setSuccess(success);
			json.setData(data);
			return json;
		}*/
		return null;
	}

	@SuppressWarnings("finally")
	@Override
	public Json checkConfig(String thirdPartUrl, String auth, DevOnlineTask task, String userName) {
		Json json = new Json();
		String info = "校验配置正常";
		Integer code = 200;	
		Boolean success = true;
		Object data = null;
		try{
			DevExclusiveSwitchboardInfo dev = new DevExclusiveSwitchboardInfo();
			dev.setExclusiveSwitchboardIp(task.getExclusiveSwitchboardIp());
			dev.setExclusiveSwitchboardPort(task.getExclusiveSwitchboardPort());
			DevExclusiveSwitchboardInfo d = deviceAutomationService.findDevExclusiveSwitchboardInfo(dev).get(0);
			
			DevAreaSwitchboardIp area = new DevAreaSwitchboardIp();
			area.setAreaName(task.getAreaName());
			List<DevAreaSwitchboardIp> li = deviceAutomationService.findAreaIp(area);
			
			/*DevAreaSwitchboardIp area = new DevAreaSwitchboardIp();
			area.setAreaName(task.getAreaName());
			List<DevAreaSwitchboardIp> ds = deviceAutomationService.findAreaIp(area);*/
			
			JSONObject param = new JSONObject();
			param.put("method_name", "/interchanger/v1/checkConfig");
			/*param.put("host", task.getMainSwitchboardIp());		//交换机的telnet登录IP地址	
			param.put("port", ds.get(0).getTelnetPort());		//交换机的telnet登录端口号	
			param.put("user", ds.get(0).getTelnetUser());		//交换机的telnet登录账号	
			param.put("password", ds.get(0).getTelnetPwd());	//交换机的telnet登录密码	
			param.put("type", ds.get(0).getDevType());		//交换机的类型，分别为4948E和5548	
			param.put("commands", "");					//需要写入接入交换机的命令列表集合
*/			
			param.put("deviceBrand", task.getBrandName());	//品牌型号，列如cisco,huawei,h3c等
			param.put("ip", task.getManagerIp());	//交换机的telnet登录IP地址	
			param.put("ipPortNameUserPass1", task.getMainSwitchboardIp());//主ip	
			param.put("ipPortNameUserPass2", task.getBackupSwitchboardIp());//备ip	
			param.put("mainSwitchboardPort", task.getMainSwitchboardPort());//主端口	
			param.put("backupSwitchboardPort", task.getBackupSwitchboardPort());//备端口	
			param.put("main_user", li.get(0).getTelnetUser());
			param.put("back_user", li.get(0).getBackupTelnetUser());
			param.put("main_pwd", li.get(0).getTelnetPwd());
			param.put("back_pwd", li.get(0).getBackupTelnetPwd());
			param.put("telnet_port", li.get(0).getTelnetPort());
			param.put("backup_telnet_port", li.get(0).getBackupTelnetPort());
			param.put("backup_type", li.get(0).getBackupDevType());
			param.put("type", li.get(0).getDevType());	//汇聚交换机的类型，分别为N7KA、N7KB、65A、65B，四种类型  
			
			
			String sb = RestfulRequestUtil.getResponse(thirdPartUrl, param, "POST", auth);
			Json j = (Json) JSONObject.parseObject(sb, Json.class);
			if(j.getRet_code()!=200){
				code = j.getRet_code();
				info = j.getRet_info();
				success = j.getSuccess();
				if(j.getRet_code()==507){
					List<String> l = JSONArray.parseArray(j.getData().toString(), String.class);
					data = l;
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
			logger.error("校验配置不正常");
			info = "校验配置不正常";
			code = 500;
			success = false;
			throw new RuntimeException(e);
		}finally{
			//记录任务执行步骤
			DevOnlineTask t = new DevOnlineTask();
			t.setId(task.getId());
			t.setUpdate_user(userName);
			writeProcess(t, 13, info, success, userName, data!=null ? data.toString() : null);
			
			json.setRet_code(code);
			json.setRet_info(info);
			json.setSuccess(success);
			json.setData(data);
			return json;
		}
	}
	
	@SuppressWarnings("finally")
	@Override
	public Json checkNewConfig(String thirdPartUrl, String auth, DevOnlineTask task, String userName) {
		Json json = new Json();
		String info = "校验配置正常";
		Integer code = 200;	
		Boolean success = true;
		try{
			JSONObject param = new JSONObject();
			param.put("method_name", "/interchanger/v1/checkNewConfig");
			param.put("device_manuf", task.getBrandName());//设备品牌
			param.put("device_type", task.getModelName());//设备类型
			param.put("device_area", task.getAreaName());//设备区域
			param.put("master_switch", task.getMainSwitchboardIp());//主汇聚交换机
			param.put("slave_switch", task.getBackupSwitchboardIp());//备汇集交换机
			param.put("device_location", task.getDevOnlineRack());//上线机架位置
			param.put("name", task.getHostName());//设备名称
			param.put("ipaddr", task.getManagerIp());//设置IP
			param.put("info", task.getExclusiveSwitchboardInfo());//带交换机信息
			
			String sb = RestfulRequestUtil.getResponse(thirdPartUrl, param, "POST", auth);
			//测试环境： http://10.1.251.234/neteagle3/services/newdevice/newdevice.action
			//生产环境： http://10.1.251.238/neteagle3/services/newdevice/newdevice.action
			json = (Json) JSONObject.parseObject(sb, Json.class);
			code = json.getRet_code();
			success = json.getSuccess();
			
		}catch(Exception e){
			e.printStackTrace();
			logger.error("校验配置不正常");
			info = "校验配置不正常";
			code = 500;
			success = false;
			throw new RuntimeException(e);
		}finally{
			//记录任务执行步骤
			DevOnlineTask t = new DevOnlineTask();
			t.setId(task.getId());
			t.setUpdate_user(userName);
			writeProcess(t, 13, info, success, userName, null);
			
			json.setRet_code(code);
			json.setRet_info(info);
			json.setSuccess(success);
			return json;
		}
	}

	/**
	 * 记录任务执行步骤
	 */
	public void writeProcess(DevOnlineTask t,  Integer executeStep, String info, boolean success, String userName, String taskExecuteNote){
		DevTaskExecute execute = new DevTaskExecute();
		execute.setId(StringUtil.getUuid());
		execute.setTaskId(t.getId());
		execute.setExecuteStep(executeStep);
		execute.setTaskOrder(executeStep);
		execute.setTaskDescribe(info); 
		execute.setTaskExecuteState(success==true ? 3 : 4);
		execute.setCreate_user(userName);
		execute.setTaskExecuteNote(taskExecuteNote);
		deviceAutomationService.updateTask2(t, execute, executeStep, userName);
	}

	@SuppressWarnings("finally")
	@Override
	public Json writeNewAccessConfig(String thirdPartUrl, String auth, DevOnlineTask task, String userName) {
		Json json = new Json();
		String info = "写入接入交换机配置正常";
		Integer code = 200;	
		Boolean success = true;
		Object data = null;
		try{
			DevAreaSwitchboardIp area = new DevAreaSwitchboardIp();
			area.setAreaName(task.getAreaName());
			List<DevAreaSwitchboardIp> li = deviceAutomationService.findAreaIp(area);
			
			DevExclusiveSwitchboardInfo dev = new DevExclusiveSwitchboardInfo();
			dev.setExclusiveSwitchboardIp(task.getExclusiveSwitchboardIp());
			dev.setExclusiveSwitchboardPort(task.getExclusiveSwitchboardPort());
			DevExclusiveSwitchboardInfo d = deviceAutomationService.findDevExclusiveSwitchboardInfo(dev).get(0);
			
			JSONObject param = new JSONObject();
			param.put("method_name", "/interchanger/v1/writeNewAccessConfig");
			param.put("deviceBrand", task.getBrandName());	//品牌型号，列如cisco,huawei,h3c等
			param.put("host", d.getExclusiveSwitchboardIp());	//交换机的telnet登录IP地址
			param.put("port", d.getExclusiveSwitchboardPort());//交换机的telnet登录port
			param.put("type", d.getExclusiveSwitchboardType());	//交换机的类型，分别为4948E和5548
			param.put("ipPortName1", task.getMainSwitchboardIp());//主ip 
			param.put("ipPortName2", task.getBackupSwitchboardIp());//备ip 
			param.put("mainSwitchboardPort", task.getMainSwitchboardPort());//主端口 
			param.put("backupSwitchboardPort", task.getBackupSwitchboardPort());//备端口 
			param.put("main_host", li.get(0).getDevName());
			param.put("back_host", li.get(0).getBackupDevName());
			param.put("accHostName", task.getHostName());//接入设备对应的host名称
			param.put("vlanNu", task.getVlan());//接入设备的管理Vlan号
			param.put("description", "网络室门户系统交换机模块请求写入接入交换机配置");//接入设备的描述配置信息
			param.put("newIp", task.getManagerIp());//在看板系统上申请的IP地址
			String sb = RestfulRequestUtil.getResponse(thirdPartUrl, param, "POST", auth);
			Json j = (Json) JSONObject.parseObject(sb, Json.class);
			if(j.getRet_code()!=200){
				code = j.getRet_code();
				info = j.getRet_info();
				success = j.getSuccess();
				if(j.getRet_code()==505){
					List<String> l = JSONArray.parseArray(j.getData().toString(), String.class);
					data = l;
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
			logger.error("写入接入交换机配置不正常");
			info = "写入接入交换机配置不正常";
			code = 500;
			success = false;
			throw new RuntimeException(e);
		}finally{
			//记录任务执行步骤
			DevOnlineTask t = new DevOnlineTask();
			t.setId(task.getId());
			t.setUpdate_user(userName);
			writeProcess(t, 9, info, success, userName, data!=null ? data.toString() : null);
			
			json.setRet_code(code);
			json.setRet_info(info);
			json.setSuccess(success);
			json.setData(data);
			return json;
		}
	}

	@SuppressWarnings("finally")
	@Override
	public Json writeNewGatherConfig(String thirdPartUrl, String auth, DevOnlineTask task, String userName) {
		Json json = new Json();
		String info = "写入汇聚交换机配置正常";
		Integer code = 200;	
		Boolean success = true;
		Object data = null;
		try{
			DevExclusiveSwitchboardInfo dev = new DevExclusiveSwitchboardInfo();
			dev.setExclusiveSwitchboardIp(task.getExclusiveSwitchboardIp());
			dev.setExclusiveSwitchboardPort(task.getExclusiveSwitchboardPort());
			DevExclusiveSwitchboardInfo d = deviceAutomationService.findDevExclusiveSwitchboardInfo(dev).get(0);
			
			DevAreaSwitchboardIp area = new DevAreaSwitchboardIp();
			area.setAreaName(task.getAreaName());
			List<DevAreaSwitchboardIp> li = deviceAutomationService.findAreaIp(area);
			
			JSONObject param = new JSONObject();
			param.put("method_name", "/interchanger/v1/writeNewGatherConfig");
			param.put("deviceBrand", task.getBrandName());	//品牌型号，列如cisco,huawei,h3c等
			param.put("host", task.getMainSwitchboardIp());	//交换机的telnet登录IP地址	
			param.put("type", li.get(0).getDevType());	//汇聚交换机的类型，分别为N7KA、N7KB、65A、65B，四种类型  
			param.put("ipPortNameUserPass1", task.getMainSwitchboardIp());//主ip	
			param.put("ipPortNameUserPass2", task.getBackupSwitchboardIp());//备ip	
			param.put("mainSwitchboardPort", task.getMainSwitchboardPort());//主端口	
			param.put("backupSwitchboardPort", task.getBackupSwitchboardPort());//备端口	
			param.put("main_user", li.get(0).getTelnetUser());
			param.put("back_user", li.get(0).getBackupTelnetUser());
			param.put("main_host", li.get(0).getDevName());
			param.put("back_host", li.get(0).getBackupDevName());
			param.put("main_pwd", li.get(0).getTelnetPwd());
			param.put("back_pwd", li.get(0).getBackupTelnetPwd());
			param.put("telnet_port", li.get(0).getTelnetPort());
			param.put("backup_telnet_port", li.get(0).getBackupTelnetPort());
			param.put("accHostname", task.getHostName());//接入设备对应的host名称
			param.put("NewType", task.getModelName());//接入交换机的设备类型，分别为4948E和5548
			param.put("newip", task.getManagerIp());//在看板系统上申请的IP地址
			param.put("vlanNu", task.getVlan());
			param.put("accHostName", task.getHostName());
			String sb = RestfulRequestUtil.getResponse(thirdPartUrl, param, "POST", auth);
			Json j = (Json) JSONObject.parseObject(sb, Json.class);
			if(j.getRet_code()!=200){
				code = j.getRet_code();
				info = j.getRet_info();
				success = j.getSuccess();
				if(j.getRet_code()==505){
					List<String> l = JSONArray.parseArray(j.getData().toString(), String.class);
					data = l;
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
			logger.error("写入汇聚交换机配置不正常");
			info = "写入汇聚交换机配置不正常";
			code = 500;
			success = false;
			throw new RuntimeException(e);
		}finally{
			//记录任务执行步骤
			DevOnlineTask t = new DevOnlineTask();
			t.setId(task.getId());
			t.setUpdate_user(userName);
			writeProcess(t, 12, info, success, userName, data!=null ? data.toString() : null);
			
			json.setRet_code(code);
			json.setRet_info(info);
			json.setSuccess(success);
			json.setData(data);
			return json;
		}
	}

	
	
}
