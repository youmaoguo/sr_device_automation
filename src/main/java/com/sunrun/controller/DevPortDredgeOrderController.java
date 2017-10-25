package com.sunrun.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.axis.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sunrun.entity.DevPortDredgeOrder;
import com.sunrun.interfaces.GetPortVlan;
import com.sunrun.interfaces.PortDredgeConfig;
import com.sunrun.service.DevPortDredgeOrderService;
import com.sunrun.task.PortDredgeExecuteInfo;
import com.sunrun.util.Base64Util;
import com.sunrun.util.Json;
import com.sunrun.util.StringUtil;

/**
 * 端口开通controller
 * @author ymg
 *
 */
@RestController
public class DevPortDredgeOrderController extends BaseController{

	private static final Logger logger = LoggerFactory.getLogger(DevPortDredgeOrderController.class);
	
	@Resource
	private DevPortDredgeOrderService devPortDredgeOrderService;  
	@Resource
	private GetPortVlan getPortVlan;
	@Resource
	private PortDredgeConfig portDredgeConfig;
	
	/**
	 * 查询列表
	 * @param request
	 * @param response
	 * @param like			模糊搜索值
	 * @param exact			精准搜索值
	 * @param sortBy		排序值（根据哪个属性排序）
	 * @param order			降序或者升序(desc/asc)
	 * @param currentPage	当前页数（从1开始）
	 * @param pageSize		每页显示数目
	 */
	@RequestMapping(value = "/portManager/v1/portDredgeTask", method = RequestMethod.GET, produces="application/json")
	public void portDredgeTask(HttpServletRequest request, HttpServletResponse response,
							@RequestParam(value = "like", required = false) String like, 
							@RequestParam(value = "sortBy", required = false) String sortBy, 
							@RequestParam(value = "order", required = false) String order, 
							@RequestParam(value = "currentPage", required = false, defaultValue = "0") Integer currentPage,
							@RequestParam(value = "pageSize", required = false, defaultValue = "0") Integer pageSize){
		Json json = new Json();
		List<Object> data = new ArrayList<Object>();
		JSONObject obj = new JSONObject();
		logger.info("查询端口开通列表入参是："+request.getQueryString());
		try{
			List<DevPortDredgeOrder> list = devPortDredgeOrderService.findPortDredgeOrder(null, like, sortBy, order, page(currentPage, pageSize));
			Integer total = devPortDredgeOrderService.countPortDredgeOrder(null, like, sortBy, order);
			obj.put("pageSize", setPageSize(currentPage, pageSize, total));
			obj.put("total", total);
			obj.put("currentPage", currentPage);
			obj.put("data", list);
			data.add(obj);
			json.setData(data);
			json.setRet_info("查询成功");
			json.setRet_code(200);
			json.setSuccess(true);
		}catch(Exception e){
			e.printStackTrace();
			logger.error("查询端口开通错误");
			json.setCollect(null);
			json.setData(null);
			json.setRet_info("查询失败");
			json.setRet_code(500);
			json.setSuccess(false);
		}
		//返回数据
		response2(json, response, request);
	}
	
	/**
	 * 添加记录并且执行(1.先添加；2.再执行指令)
	 * @param jsonStr 
	 * @param auth
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/portManager/v1/executePortDredge", method = RequestMethod.POST, produces="application/json", consumes="application/json")
	public void executePortDredge(@RequestBody String jsonStr, @RequestHeader("Authorization") String auth,
									HttpServletRequest request, HttpServletResponse response){
		Json json = new Json();
		logger.info("添加并且执行工单入参是："+jsonStr);
		JSONObject obj = JSONObject.parseObject(jsonStr);
		String userId = obj.getString("userId");
		String handlerName = obj.getString("userName");
		String switchboardIp = obj.getString("switchboardIP");
		String portModeVlan = obj.getString("portModeVlan");
		String portDescribe = obj.getString("portDescribe");
		String vlanDescribe = obj.getString("vlanDescribe");
		portModeVlan = portModeVlan.replace("[", "");
		portModeVlan = portModeVlan.replace("]", "");
		portModeVlan = portModeVlan.replace("\"", "");
		portModeVlan = portModeVlan.replace(",", ";");
		
		String switchboardUser = obj.getString("switchboardUser");//登陆交换机 高权账号
		String switchboardPass = obj.getString("switchboardPass");//高权账号密码
		if(StringUtils.isEmpty(handlerName) || StringUtils.isEmpty(switchboardIp) || StringUtils.isEmpty(portModeVlan)
				|| StringUtils.isEmpty(switchboardUser) || StringUtils.isEmpty(switchboardPass)){
			json.setSuccess(false);
			json.setRet_code(401);
			json.setRet_info("缺少请求参数");
			response(json, response, request);
			return;
		}
		try{
			switchboardPass = new String(Base64Util.base64Decode(switchboardPass));
			String id = StringUtil.getUuid();
			json = devPortDredgeOrderService.savePortDredgeOrder(id, userId, handlerName, switchboardIp, portModeVlan, switchboardUser, switchboardPass, portDescribe, vlanDescribe);
			if(json.getSuccess()){
				List<Object> data = new ArrayList<Object>();
				JSONObject o = new JSONObject();
				o.put("taskId", id);
				data.add(o);
				json.setData(data);
				//将此工单锁定，更改状态是正在执行中
				DevPortDredgeOrder port = new DevPortDredgeOrder();
				port.setId(id);
				port.setExecuteState(2);
				port.setState(1);
				devPortDredgeOrderService.editPortDredgeOrder(port);
				
				//调用 执行
				PortDredgeExecuteInfo p = new PortDredgeExecuteInfo(devPortDredgeOrderService, id, switchboardIp, portModeVlan, switchboardUser, switchboardPass, portDescribe);
				Thread t = new Thread(p);
		        t.start();
			}
			
		}catch(Exception e){
			e.printStackTrace();
			logger.error("保存并执行端口开通工单错误");
			json.setCollect(null);
			json.setData(null);
			json.setRet_info("执行失败");
			json.setRet_code(500);
			json.setSuccess(false);
		}
		response(json, response, request);
	}
	
	
	/**
	 * 根据交换机ip获取端口和VLAN
	 * @param switchboardIp
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/portManager/v1/{switchboardIp}/portVlan", method = RequestMethod.GET, produces="application/json")
	public void portAndVlan(@PathVariable String switchboardIp, HttpServletRequest request, HttpServletResponse response){
		Json json = new Json();
		logger.info("根据交换机ip获取端口和VLAN的入参ip："+switchboardIp);
		if(StringUtils.isEmpty(switchboardIp)){
			json.setRet_code(401);
			json.setRet_info("缺少请求参数");
			json.setSuccess(false);
			response(json, response, request); 
			return;
		}
		try{
			//调用Python接口获取
			json = getPortVlan.portVlan(switchboardIp);
			
		}catch(Exception e){
			e.printStackTrace();
			logger.error("获取端口和vlan出错");
			json.setRet_info("获取端口和vlan失败");
			json.setRet_code(500);
			json.setSuccess(false);
		}
		
		response(json, response, request);
	}
	
	/**
	 * 获取交换机配置信息
	 * @param switchboardIp 
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/portManager/v1/portDredgeConfig", method = RequestMethod.POST, produces="application/json")
	public void portDredgeConfig(@RequestBody String jsonStr,@RequestHeader("Authorization") String auth,
								HttpServletRequest request, HttpServletResponse response){
		Json json = new Json();
		List<Object> data = new ArrayList<Object>();
		JSONObject obj = new JSONObject();
		//switchboardIp=switchboardIp.replace("-", "."); 
		logger.info("获取交换机配置信息入参 ："+jsonStr);
		JSONObject param = JSONObject.parseObject(jsonStr);
		String switchboardIp = param.getString("switchboardIp");
		String portModeVlan = param.getString("portModeVlan");
		String portDescribe = param.getString("portDescribe");
		String vlanDescribe = param.getString("vlanDescribe");
		if(StringUtils.isEmpty(switchboardIp) || StringUtils.isEmpty(portModeVlan)){
			json.setRet_code(401);
			json.setRet_info("缺少请求参数");
			json.setSuccess(false);
			response(json, response, request); 
			return;
		}
		try{
			//调用Python接口获取
			Json j = portDredgeConfig.portDredgeConfig(switchboardIp, portModeVlan, portDescribe, vlanDescribe);
			if(j.getSuccess()){
				List<String> config = new ArrayList<String>();
				JSONArray array = (JSONArray) j.getData();
				JSONObject o = (JSONObject) array.get(0);
				Set<String> keys = o.keySet();
				for(Iterator<String> it = keys.iterator(); it.hasNext();){
					String key = it.next();
					List<String> ss = (List<String>) o.get(key);
					config.addAll(ss);
				}
				obj.put("config", config);
			}
			data.add(obj);
			json.setData(data);
			json.setRet_code(j.getRet_code());
			json.setRet_info(j.getRet_info());
		}catch(Exception e){
			e.printStackTrace();
			logger.error("获取交换机配置信息出错");
			json.setRet_info("获取交换机配置信息失败");
			json.setRet_code(500);
			json.setSuccess(false);
		}
		
		response(json, response, request);
	}
	
	
	/**
	 * 查看交换机全部指令执行情况
	 * @param switchboardIp
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/portManager/v1/portDredgeBackInfo", method = RequestMethod.GET, produces="application/json")
	public void portDredgeBackInfo(@RequestParam(value = "taskId", required = false) String taskId,
									HttpServletRequest request, HttpServletResponse response){
		Json json = new Json();
		logger.info("查看交换机全部指令执行情况入参is："+request.getQueryString());
		if(StringUtils.isEmpty(taskId)){
			json.setRet_code(401);
			json.setRet_info("缺少请求参数");
			json.setSuccess(false);
			response(json, response, request); 
			return;
		}
		try{
			json = devPortDredgeOrderService.findExecuteDetail(taskId);
		}catch(Exception e){
			e.printStackTrace();
			logger.error("查看交换机全部指令执行情况出错");
			json.setRet_info("查看交换机全部指令执行情况失败");
			json.setRet_code(500);
			json.setSuccess(false);
		}
		
		response(json, response, request);
	}
	
}
