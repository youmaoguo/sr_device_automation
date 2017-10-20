package com.sunrun.interfaces;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sunrun.util.Json;
import com.sunrun.util.RestfulRequestUtil;
import com.sunrun.util.StringUtil;

/**
 * 执行指令
 * @author ymg
 *
 */
@Component
public class ExecutePortDredge {
	private Logger logger = Logger.getLogger(ExecutePortDredge.class);
	
	@Value("${port.execute}")
	private String url_properties;
	
	@Value("${device.Authorization.username}")
	private String username;	
	
	@Value("${device.Authorization.password}")
	private String pwd;
	
	/**
	 * 执行指令
	 * @param switchboardIp
	 * @param portModeVlan
	 * @param method			指令对应的方法，传递这个方法过去它就知道应该执行哪些指令
	 * @param switchboardUser
	 * @param switchboardPass
	 * @return
	 */
	public Json executePortDredge(String switchboardIp, String portModeVlan, String method, String switchboardUser, String switchboardPass, String portDescribe){
		Json json = new Json();
		String url=url_properties;
		try{
			JSONObject param = new JSONObject();
			param.put("switchboardIP", switchboardIp);
			param.put("portModeVlan", portModeVlan);
			param.put("methodName", method);
			param.put("portDescribe", portDescribe);
			param.put("switchboardUser", switchboardUser);
			param.put("switchboardPass", switchboardPass);
			logger.info("调用Python执行指令接口url是："+url+"，post请求 ,参数是："+param.toString()+"，头部验证是:"+StringUtil.basic64Encord(username, pwd));
			String sb = RestfulRequestUtil.getResponse(url, param, "post", StringUtil.basic64Encord(username, pwd));
			logger.info("调用Python执行指令接口返回："+sb);
			if(!StringUtils.isEmpty(sb)){
				json = JSONObject.parseObject(sb, Json.class);
				if(json.getRet_code()==200 || json.getRet_code()==201)
					json.setSuccess(true);
				else{
					JSONArray array = (JSONArray) json.getData();
					JSONObject obj = (JSONObject) array.get(0);
					json.setSuccess(false);
					json.setRet_code(500);
					json.setRet_info(obj.getString("execute_info"));
				}
			}else{
				json.setSuccess(false);
				json.setRet_code(500);
				json.setRet_info("调用Python执行指令接口返回空信息");
			}
		}catch(Exception e){
			e.printStackTrace();
			logger.error("调用Python执行指令接口出错 ");
			json.setSuccess(false);
			json.setRet_code(500);
			json.setRet_info("调用Python执行指令接口出错 ");
		}
		return json;
	}
	
}
