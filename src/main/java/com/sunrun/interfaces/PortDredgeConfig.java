package com.sunrun.interfaces;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.sunrun.util.Json;
import com.sunrun.util.RestfulRequestUtil;
import com.sunrun.util.StringUtil;

/**
 * 获取交换机配置信息
 * @author ymg
 *
 */
@Component
public class PortDredgeConfig {
	private Logger logger = Logger.getLogger(PortDredgeConfig.class);
	
	@Value("${port.portDredgeConfig}")
	private String url_properties;
	
	@Value("${device.Authorization.username}")
	private String username;	
	
	@Value("${device.Authorization.password}")
	private String pwd;
	
	/**
	 * 获取交换机配置信息
	 * @param switchboardIp
	 * @param portModeVlan
	 * @return
	 */
	public Json portDredgeConfig(String switchboardIp, String portModeVlan, String portDescribe){
		Json json = new Json();
		String url=url_properties;
		try{
			JSONObject param = new JSONObject();
			param.put("portModeVlan", portModeVlan);
			param.put("portDescribe", portDescribe);
			param.put("switchboardIp", switchboardIp);
			logger.info("调用Python接口获取交换机配置信息接口url是："+url+"，post请求 ，参数是："+param.toString()+", 头部验证是:"+StringUtil.basic64Encord(username, pwd));
			String sb = RestfulRequestUtil.getResponse(url, param, "post", StringUtil.basic64Encord(username, pwd));
			logger.info("调用Python接口获取交换机配置信息接口返回："+sb);
			if(!StringUtils.isEmpty(sb)){
				json = JSONObject.parseObject(sb, Json.class);
				if(json.getRet_code()==200 || json.getRet_code()==201)
					json.setSuccess(true);
				else
					json.setSuccess(false);
			}else{
				json.setSuccess(false);
				json.setRet_code(500);
				json.setRet_info("调用Python接口获取交换机配置信息返回空信息");
			}
		}catch(Exception e){
			e.printStackTrace();
			logger.error("调用Python接口获取交换机配置信息接口出错 ");
			json.setSuccess(false);
			json.setRet_code(500);
			json.setRet_info("调用Python接口获取交换机配置信息接口出错 ");
		}
		return json;
	}
	
}
