package com.sunrun.interfaces;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import com.alibaba.fastjson.JSONObject;
import com.sunrun.util.Json;
import com.sunrun.util.RestfulRequestUtil;
import com.sunrun.util.StringUtil;

@Component
public class GetPortVlan {

	private Logger logger = Logger.getLogger(GetPortVlan.class);
	
	@Value("${port.portVlan}")
	private String url_properties;
	
	/**
	 * 根据交换机ip获取端口和VLAN
	 * @param switchboardIp
	 * @return
	 */
	public Json portVlan(String switchboardIp){
		Json json = new Json();
		String url=url_properties;
		try{
			url = url.replace("{switchboardIp}", switchboardIp);
			logger.info("调用Python接口获取端口和vlan接口url是："+url+"，get请求 ，头部验证是:"+StringUtil.basic64Encord("", ""));
			String sb = RestfulRequestUtil.getResponse(url, null, "get", StringUtil.basic64Encord("", ""));
			logger.info("调用Python接口获取端口和vlan接口返回："+sb);
			if(StringUtils.isEmpty(sb)){
				json.setSuccess(false);
				json.setRet_code(500);
				json.setRet_info("调用Python接口获取端口和vlan接口返回空信息 ");
			}else{
				json = JSONObject.parseObject(sb, Json.class);
				json.setSuccess(true);
			}
		}catch(Exception e){
			e.printStackTrace();
			logger.error("调用Python接口获取端口和vlan接口出错 ");
			json.setSuccess(false);
			json.setRet_code(500);
			json.setRet_info("调用Python接口获取端口和vlan接口出错 ");
		}
		return json;
	}
	
}
