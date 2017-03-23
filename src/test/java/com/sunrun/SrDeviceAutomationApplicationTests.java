package com.sunrun;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sunrun.util.StringUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SrDeviceAutomationApplicationTests {

	@Test
	public void contextLoads() {
	}

	public static void main(String[] args) {
		String s = StringUtil.read("D:\\port.txt");
		try {
			//s = new String(s.getBytes("gbk"),"utf-8");
			org.json.JSONObject obj = new org.json.JSONObject(s);
			Object str = obj.get("data");
			System.out.println(str.toString()); 
			List<String> l = com.alibaba.fastjson.JSONArray.parseArray(str.toString(), String.class);
			System.out.println(l.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
}
