package com.sunrun.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.sunrun.util.Base64Util;
import com.sunrun.util.Json;

public class BaseController {
	
	private static final Logger logger = LoggerFactory.getLogger(BaseController.class);
	
	public String getUserName(HttpServletRequest request){
		//String userName = (String)request.getSession().getAttribute("userName");		//从会话中获取
		String userName = (String)request.getServletContext().getAttribute("userName");	//从context上下文中获取
		if(!StringUtils.isEmpty(userName))
			return userName;
		else
			return null;
	}
	
	/**
	 * 设置跨域请求.由于spring mvc4.2 默认支持跨域
	 * @param response
	 */
	public void setResponse(HttpServletResponse response){
		/**设置响应头允许ajax跨域访问**/
		response.setHeader("Access-Control-Allow-Origin","*");
		/**星号表示所有的异域请求都可以接受，*/
		response.setHeader("Access-Control-Allow-Methods","*");
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
	}
	
	/**
	 * 后台响应回客户端，单纯返回json格式
	 * @param json
	 * @param response
	 */
	public void response(Json json, HttpServletResponse response){
		setResponse(response);
		try {
			response.getWriter().print(JSONObject.toJSONString(json, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullStringAsEmpty));
			logger.info("后台响应json格式数据："+JSONObject.toJSONString(json));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 后台响应回客户端，返回有区分json和jsonP两种格式
	 * @param json
	 * @param response
	 * 
	 */
	public void response(Json json, HttpServletResponse response, HttpServletRequest request){
		setResponse(response);
		try {
			String callback = request.getParameter("callback");	//参数值必须为：jsonpCallBack
			if(callback==null || callback.equals(""))
				response.getWriter().print(JSONObject.toJSONString(json, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullStringAsEmpty));
			else
				response.getWriter().print(callback + "(" + JSONObject.toJSONString(json, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullStringAsEmpty));
			logger.info("后台响应json格式数据："+JSONObject.toJSONString(json));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void response2(Json json, HttpServletResponse response, HttpServletRequest request){
		setResponse(response);
		try {
			String callback = request.getParameter("callback");	//参数值必须为：jsonpCallBack
			if(callback==null || callback.equals(""))
				response.getWriter().print(JSONObject.toJSONString(json, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.WriteDateUseDateFormat));
			else
				response.getWriter().print(callback + "(" + JSONObject.toJSONString(json, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.WriteDateUseDateFormat));
			logger.info("后台响应json格式数据："+JSONObject.toJSONString(json));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 判断是否跨域请求（和前端商定，跨域请求必须带‘callback’参数）
	 * @param request
	 * @return
	 */
	public Boolean isCrossDomain(HttpServletRequest request){
		String callback = request.getParameter("callback");
		if(callback==null || callback.equals(""))
			return false;
		else
			return true;
	}
	
	/**
	 * 返回跨域请求所需要的jsonp格式
	 * @param json
	 * @return
	 */
	public String returnJsonP(Json json){
		return "jsonpCallBack("+JSONObject.toJSONString(json, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullStringAsEmpty)+")";
	}
	
	/**
	 * 返回json格式
	 * @param json
	 * @return
	 */
	public String returnJson(Json json){
		return JSONObject.toJSONString(json, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullStringAsEmpty);
	}
	
	/**
	 * 分页条件
	 * @param currentPage	当前第几页
	 * @param pageSize		每页记录数
	 * @return
	 */
	public String page(Integer currentPage, Integer pageSize){
		String limit = null;
		if(pageSize==0)
			pageSize = 20;//若只是传递了页数，则默认每页20
		if(currentPage>=1)
			limit = (currentPage+1-1)*pageSize + ", " + pageSize;
		if(currentPage<=0)
			limit = "0, " + pageSize;
		return limit;
	}
	
	public Integer setPageSize(Integer currentPage, Integer pageSize, int total){
		Integer a = 0;
		if(pageSize==0)
			pageSize = 20;//若只是传递了页数，则默认每页20
		if(total==0){
			a = 0;
		}else if(total>=pageSize){
			if(currentPage<=0)
				a = pageSize;
			if(currentPage>=1){
				int size = total - pageSize*(currentPage+1-1);
				if(size>0 && size>=pageSize)
					a = pageSize;
				else if(size>0 && size<pageSize)
					a = size;
				else
					a = 0;
			}
		}else if(total<pageSize){
			a = total;
		}
		return a;
	}
	
	/**
	 * 返回base64加密后的用户名字和密码
	 * @param username
	 * @param pwd
	 * @return
	 */
	public String Basic64Encord(String username, String pwd){
		byte[] b = (username + ":" + pwd).getBytes();
		return "Basic " + Base64Util.base64Encode(b);
	}
	
}
