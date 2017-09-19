package com.sunrun.interfaces;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

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
	
	/**
	 * 获取交换机配置信息
	 * @param switchboardIp
	 * @param port
	 * @param vlan
	 * @return
	 */
	public Json portDredgeConfig(String switchboardIp, String port, String vlan){
		Json json = new Json();
		try{
			String url="";
			logger.info("调用Python接口获取交换机配置信息接口url是："+url+"，get请求 ，头部验证是:"+StringUtil.basic64Encord("", ""));
			String sb = RestfulRequestUtil.getResponse(url, null, "get", StringUtil.basic64Encord("", ""));
			logger.info("调用Python接口获取交换机配置信息接口返回："+sb);
			if(!StringUtils.isEmpty(sb)){
				
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
