package com.sunrun.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sunrun.entity.DevPortCommandInfo;
import com.sunrun.entity.DevPortDredgeOrder;
import com.sunrun.interfaces.ExecutePortDredge;
import com.sunrun.interfaces.GetPortVlan;
import com.sunrun.interfaces.OpenVlan;
import com.sunrun.interfaces.PortDredgeConfig;
import com.sunrun.mapper.DevPortCommandInfoMapper;
import com.sunrun.mapper.DevPortDredgeOrderMapper;
import com.sunrun.util.Json;
import com.sunrun.util.StringUtil;

@Service("devPortDredgeOrderService")
public class DevPortDredgeOrderServiceImpl implements DevPortDredgeOrderService {
	private static final Logger logger = LoggerFactory.getLogger(DevPortDredgeOrderServiceImpl.class);
	
	@Resource
	private DevPortDredgeOrderMapper devPortDredgeOrderMapper;
	@Resource
	private DevPortCommandInfoMapper devPortCommandInfoMapper;
	@Resource
	private ExecutePortDredge executePortDredge;
	@Resource
	private PortDredgeConfig portDredgeConfig;
	@Resource 
	private GetPortVlan getPortVlan;
	@Resource 
	private OpenVlan openVlan;
	
	@Transactional
	@Override
	public synchronized Json savePortDredgeOrder(String id,String userId ,String handlerName, String switchboardIp, String portModeVlan,String switchboardUser,String switchboardPass) {
		Json json = new Json();
		try{
			//这个if判断是验证该ip下是否有重复的端口和VLAN
			if(!StringUtils.isEmpty(portModeVlan)){
				String[] portVlans = portModeVlan.split(";");
				for(int i=0;i<portVlans.length;i++){
					String portVlan = portVlans[i];
					String[] s = portVlan.split("-");
					String port = "", vlan = "";
					if(s.length==3){
						port = s[0];
						vlan = s[2];
						Integer count = devPortDredgeOrderMapper.distinctCountPortVlan(switchboardIp, port, vlan);
						if(count!=null && count>0){
							json.setSuccess(false);
							json.setRet_code(401);
							json.setRet_info("该ip下存在添加重复的端口或VLAN，请检验");
							break;
						}
					}
				}
			}
			
			DevPortDredgeOrder port = new DevPortDredgeOrder();
			port.setId(id);
			port.setExecuteState(1);
			port.setPortModeVlan(portModeVlan);
			port.setSwitchboardIp(switchboardIp);
			port.setHandlerName(handlerName);
			port.setCreate_user(userId);
			devPortDredgeOrderMapper.savePortDredgeOrder(port);
			//根据ip获取vlan，看页面的vlan是否手写的，是则要开通VLAN
			json = getPortVlan.portVlan(switchboardIp);
			//解析vlan 装在集合里 
			JSONArray data = (JSONArray) json.getData();
			JSONObject obj = (JSONObject) data.get(0);
			JSONArray vlans = obj.getJSONArray("vlan");
			//查询并且保存工单记录指令详情
			String[] portVlans = portModeVlan.split(";");
			for(int i=0;i<portVlans.length;i++){
				String portVlan = portVlans[i];
				String[] s = portVlan.split("-");
				if(s.length==3 && !vlans.contains(s[2])){
					//判断集合里面是否含有此vlan,没有则调用开通vlan接口
					json = openVlan.openVlan(switchboardIp, s[2], switchboardUser, switchboardPass);
					if(!json.getSuccess()){
						json.setRet_code(500);
						json.setRet_info("开通手动指定的VLAN号失败");
						json.setSuccess(false);
						return json;
					}
				}
				//根据交换机获取指令
				json = portDredgeConfig.portDredgeConfig(switchboardIp, portVlans[i]);
				if(!json.getSuccess()){
					json.setRet_info("添加工单下的执行指令异常");
					json.setRet_code(500);
					json.setSuccess(false);
					return json;
				}
				JSONArray array = (JSONArray) json.getData();
				JSONObject o = (JSONObject) array.get(0);
				Set<String> keys = o.keySet();
				for(Iterator<String> it = keys.iterator(); it.hasNext();){
					String key = it.next();
					List<String> ss = (List<String>) o.get(key);
					for(String str : ss){
						DevPortCommandInfo d = new DevPortCommandInfo();
						d.setCommand(str);
						d.setMethod(key);
						d.setExecuteState(1);
						d.setId(StringUtil.getUuid());
						d.setHandlerName(handlerName);
						d.setPortModeVlan(s[0]);
						d.setSwitchboardIp(switchboardIp);
						d.setTaskId(id);
						d.setCreate_user(userId);
						devPortCommandInfoMapper.savePortCommandInfo(d);
					}
				}
			}
			json.setRet_info("添加记录成功");
			json.setRet_code(200);
			json.setSuccess(true);
		}catch(Exception e){
			e.printStackTrace();
			logger.error("保存端口开通记录出错了");
			json.setRet_info("添加记录失败");
			json.setRet_code(500);
			json.setSuccess(false);
		}
		return json;
	}

	@Override
	public void editPortDredgeOrder(DevPortDredgeOrder port) {
		try{
			devPortDredgeOrderMapper.editPortDredgeOrder(port);
		}catch(Exception e){
			e.printStackTrace();
			logger.error("修改端口开通记录出错了");
		}
	}

	@Override
	public List<DevPortDredgeOrder> findPortDredgeOrder(DevPortDredgeOrder port, String like, String sortBy,
			String order, String limit) {
		List<DevPortDredgeOrder> list = new ArrayList<DevPortDredgeOrder>();
		try{
			list = devPortDredgeOrderMapper.findPortDredgeOrder(port, like, sortBy, order, limit);
		}catch(Exception e){
			e.printStackTrace();
			logger.error("修改端口开通记录出错了");
		}
		return list;
	}

	@Override
	public Integer countPortDredgeOrder(DevPortDredgeOrder port, String like, String sortBy, String order) {
		Integer count = 0;
		try{
			count = devPortDredgeOrderMapper.countPortDredgeOrder(port, like, sortBy, order);
		}catch(Exception e){
			e.printStackTrace();
			logger.error("修改端口开通记录出错了");
		}
		return count;
	}
	
	@Override
	public Json executeCommand(String id, String switchboardIp, String portModeVlan,String switchboardUser,String switchboardPass){
		Json json = new Json();
		boolean tag = true;
		try{
			//执行之前再去调用获取端口和vlan接口，看返回的是否可用
			json = getPortVlan.portVlan(switchboardIp);
			//解析vlan,port装在集合里 
			JSONArray data = (JSONArray) json.getData();
			JSONObject obj = (JSONObject) data.get(0);
			JSONArray vlans = obj.getJSONArray("vlan");
			JSONArray ps = obj.getJSONArray("port");
			List<String> ports = new ArrayList<String>();
			for(int i=0; i<ps.size(); i++){
				JSONObject o = (JSONObject) ps.get(i);
				int state = o.getInteger("state");
				if(state==0)
					ports.add(o.getString("name"));
			}
			String[] portVlans = portModeVlan.split(";");
			for(int i=0;i<portVlans.length;i++){
				//同一个ip下的逐个端口一条条命令调用
				String[] pv = portVlans[i].split("-");
				String port = pv[0];
				if(!ports.contains(port)){
					json.setRet_code(500);
					json.setRet_info("端口验证不通过");
					json.setSuccess(false);
					return json;
				}
				if(pv.length==3 && !vlans.contains(pv[2])){
					json.setRet_code(500);
					json.setRet_info("vlan验证不通过");
					json.setSuccess(false);
					return json;
				}
				DevPortCommandInfo o = new DevPortCommandInfo();
				o.setTaskId(id);
				o.setSwitchboardIp(switchboardIp);
				o.setPortModeVlan(port);
				List<DevPortCommandInfo> li = devPortCommandInfoMapper.findPortDredgeOrder(o);
				if(li==null || li.size()==0){
					tag = false;
					break;
				}
				for(DevPortCommandInfo f : li){
					//调用python接口一条一条执行命令执行命令
					json = executePortDredge.executePortDredge(switchboardIp, portVlans[i], f.getMethod(), switchboardUser, switchboardPass);
					//执行完一条命令后重新修改下该条命令的状态
					f.setExecuteInfo(json.getSuccess()==true?"执行成功":json.getRet_info());
					f.setExecuteState(json.getSuccess()==true?3:4);
					devPortCommandInfoMapper.editPortCommand(f);
				}
			}
			if(tag){
				json.setRet_code(200);
				json.setRet_info("执行命令成功");
				json.setSuccess(true);
			}else{
				json.setRet_code(500);
				json.setRet_info("执行指令未获取全");
				json.setSuccess(false);
			}
		}catch(Exception e){
			e.printStackTrace();
			logger.error("执行命令异常");
			json.setRet_code(500);
			json.setRet_info("执行命令异常");
			json.setSuccess(false);
		}
		return json;
	}

	@Override
	public Json findExecuteDetail(String taskId) {
		Json json = new Json();
		List<Object> data = new ArrayList<Object>();
		JSONObject obj = new JSONObject();
		try{
			List<DevPortCommandInfo> ports = devPortCommandInfoMapper.findIpAndPortByTaskId(taskId);
			for(int i=0;i<ports.size();i++){
				List<Object> infos = new ArrayList<Object>();
				DevPortCommandInfo port = ports.get(i);
				List<DevPortCommandInfo> li = devPortCommandInfoMapper.findExecuteDetail(port);
				for(int j=0;j<li.size();j++){
					DevPortCommandInfo d = li.get(j);
					List<Object> info = new ArrayList<Object>();
					info.add(d.getCommand());
					info.add(d.getExecuteState());
					info.add(StringUtils.isEmpty(d.getExecuteInfo())?"":d.getExecuteInfo());
					infos.add(info);
				}
				obj.put(port.getSwitchboardIp()+"---"+port.getPortModeVlan(), infos);
			}
			data.add(obj);
			json.setData(data);
			json.setRet_code(200);
			json.setRet_info("查询成功");
			json.setSuccess(true);
		}catch(Exception e){
			e.printStackTrace();
			json.setRet_info("查询指令执行详情异常");
			json.setRet_code(500);
			json.setSuccess(false);
		}
		return json;
	}

	

}
