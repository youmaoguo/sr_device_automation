package com.sunrun;

 import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature; 
import com.sunrun.entity.DevIpSegmentDistributionBean;
import com.sunrun.entity.DevOnlineTask;
import com.sunrun.entity.SysSendEmailBean;
import com.sunrun.entity.SysSendEmailBean.MailConsignee;
import com.sunrun.entity.view.DevOnlineBatchTaskView;
import com.sunrun.util.Json;
import com.sunrun.util.StringUtil;

public class MY {

	public static void main(String[] args)   {
		JSONObject obj = new JSONObject();
		JSONArray array = new JSONArray();
		Json json = new Json();
		 
			obj.put("pageSize", 12);
			obj.put("total", 14);
			obj.put("currentPage", 13);
			array.add(obj);
			json.setData(array);
		
		 System.out.println(JSONObject.toJSONString(json));
}
	
}
