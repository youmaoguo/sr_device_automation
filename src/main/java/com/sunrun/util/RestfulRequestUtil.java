package com.sunrun.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;

/**
 * restful请求封装工具
 * @author ymg
 *
 */
public final class RestfulRequestUtil {
	private static final Logger logger = Logger.getLogger(RestfulRequestUtil.class);
	
	/**
	 * 请求 restful接口 并且返回自己封装的Json对象
	 * @param requestUrl	请求接口路径
	 * @param paramterObj	请求参数对象
	 * @param requestMethod	请求方式（post/get）
	 * @return
	 */
	public static Json getJSON(String requestUrl, Object paramterObj, String requestMethod, String authorization){
		String sb = getResponse(requestUrl, paramterObj, requestMethod, authorization);
		return JSON.parseObject(sb, Json.class);
	}
	

	/**
	 * 请求 restful接口 并且返回JSONObject对象
	 * @param requestUrl	请求接口路径
	 * @param paramterObj	请求参数对象
	 * @param requestMethod	请求方式（post/get）
	 * @return
	 */
	public static JSONObject getJSONObject(String requestUrl, Object paramterObj, String requestMethod, String authorization){
		String sb = getResponse(requestUrl, paramterObj, requestMethod, authorization);
		return parseStringToJSONObject(sb);
	}
	
	/**
	 * 使用httpURLConnect请求restful接口获取返回流,
	 * 请求参数封装成json格式的实体对象
	 * @param requestUrl	路径
	 * @param paramterObj	参数对象
	 * @param requestMethod	请求方式
	 * @param authorization	头部验证
	 * @return
	 */
	public static String getResponse(String requestUrl, Object paramterObj, String requestMethod, String authorization){
		StringBuffer sb = new StringBuffer();
		HttpURLConnection conn = null;
		try{
			Object obj = new Object();
			URL url = null;
			if(requestMethod.equalsIgnoreCase("get") && !StringUtils.isEmpty(paramterObj)){
				url = new URL(requestUrl+"?"+paramterObj);
			}else{
				url = new URL(requestUrl);
			}
			conn = (HttpURLConnection) url.openConnection();
	        if(requestMethod==null || "".equals(requestMethod) || requestMethod.equalsIgnoreCase("get")){
	        	conn.setRequestMethod("GET");// 提交模式POST GET PUT DELETE
	        }else if(requestMethod.equalsIgnoreCase("post")){
	        	conn.setRequestMethod("POST");// 提交模式POST GET PUT DELETE
	        }
	        conn.setDoOutput(true);// 是否输入参数
	        conn.setRequestProperty("Content-Type","application/json;charset=UTF-8");
	        conn.setRequestProperty("Accept","application/json");
	        if(authorization!=null && !"".equals(authorization))
	        	conn.setRequestProperty("Authorization", authorization);
	        if(requestMethod.equalsIgnoreCase("post")){
	        	if(paramterObj!=null){
		        	if(paramterObj instanceof JSONObject || paramterObj instanceof com.alibaba.fastjson.JSONObject ){
			        	System.out.println("请求参数：" + paramterObj.toString() + "\n");
			        	conn.getOutputStream().write(paramterObj.toString().getBytes());
		        	}else{
		        		obj = JSON.toJSON(paramterObj);
		        		System.out.println("请求参数：" + obj.toString() + "\n");
		        		conn.getOutputStream().write(obj.toString().getBytes());
		        	}
		        }
	        }
	        conn.setConnectTimeout(10000);//连接超时 单位毫秒
	        conn.setReadTimeout(30000);//读取超时 单位毫秒
	        int code = conn.getResponseCode();
	        if(code==200){
	        	//读取请求返回值
	        	InputStream inStream = conn.getInputStream();
	        	BufferedReader input = new BufferedReader(new InputStreamReader(inStream));
	        	String line;
	    		while ((line = input.readLine()) != null) {
	    			sb.append(line);
	    		}
	        	//System.out.println(sb.toString());
	        }else{
	        	System.out.println("接口请求失败code="+code);
	        	logger.info("接口请求失败code="+code);
	        }
		}catch(Exception e){
			e.printStackTrace();
			logger.error("接口请求响应异常");
			throw new RuntimeException(e);
		}finally{
			conn.disconnect();
		}
		return sb.toString();
	}
	
	/**
	 * 将json类型的字符串转换成JSONObject对象
	 * @param str
	 * @return
	 */
	public static JSONObject parseStringToJSONObject(String str) { 
		if (str == null || str.trim().length() == 0)       
		   return null;       
		JSONObject jsonObject = null;
		try {
			jsonObject = new JSONObject(str);
		} catch (JSONException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}        
		return jsonObject;   
	}
	
	
}
