package com.sunrun.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sunrun.entity.DevOnlineBatchItil;
import com.sunrun.service.DeviceAutomationService;
import com.sunrun.util.Json;
import com.sunrun.util.RestfulRequestUtil;
import com.sunrun.util.StringUtil;

@RestController
public class ITILController extends BaseController{
	
	private static final Logger logger = LoggerFactory.getLogger(ITILController.class);
	
	@Value("${itil.changeItils}")
	private String changeItils;
	
	@Value("${itil.user}")
	private String user;
	
	@Value("${itil.pwd}")
	private String pwd;
	
	@Resource
	private DeviceAutomationService deviceAutomationService;
	
	@RequestMapping(value = "/deviceAutomation/v1/queryChangeITILStatus", method = RequestMethod.GET, produces="application/json")
	public void queryChangeITILStatus(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "itilNumber") String itilNumber){
		logger.info("sr_device_automation查询变更ITIL单子,请求参数是：itilNumber="+itilNumber);
		Json json = new Json();
		if(StringUtils.isEmpty(itilNumber)){
			json.setRet_code(401);
			json.setRet_info("缺少查询参数itilNumber");
			json.setData(null);
			response(json, response, request);
		}
		try {
			String sb = RestfulRequestUtil.getResponse(changeItils+"?view=expand&number="+itilNumber, null, "GET", StringUtil.basic64Encord(user, pwd));
			if(!StringUtils.isEmpty(sb)){
				org.json.JSONObject obj = new org.json.JSONObject(sb);
				Integer code = (Integer) obj.get("ReturnCode");
				JSONArray array = obj.getJSONArray("content");
				if(code==0 && !StringUtils.isEmpty(array) && array.length()>0){
					for(int i=0;i<array.length();i++){
						org.json.JSONObject o = (org.json.JSONObject) array.get(i);	//获取对象
						org.json.JSONObject o1 = o.getJSONObject("GenChange").getJSONObject("header");
						String number = o1.getString("number");
						String status = o.getJSONObject("GenChange").getString("status");
						if(number.equals(itilNumber)){
							DevOnlineBatchItil itil = new DevOnlineBatchItil();
							itil.setItilStatus(status);
							itil.setItilNumber(number);
							deviceAutomationService.updateBatch(itil);
						}
					}
					
				}
				json.setRet_code(200);
				json.setRet_info("查询变更ITIL单子返回成功");
				json.setData(sb);
			}else{
				json.setRet_code(500);
				json.setRet_info("查询变更ITIL单子返回空");
				json.setData(sb);
			}
			logger.info("sr_device_automation查询变更ITIL单子返回："+sb);
			
		} catch (Exception e) {
			logger.error("sr_device_automation查询变更ITIL单子状态出错");
			e.printStackTrace();
		}
		//返回数据
		response(json, response, request);
	}
	
	
	
}
