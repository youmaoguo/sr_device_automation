package com.sunrun;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONObject;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SrDeviceAutomationApplicationTests {

	@Test
	public void contextLoads() {
	}

	public static void main(String[] args) {
		JSONObject obj = new JSONObject();
		obj.put("id", "1");
		System.out.println(obj.toJSONString());
		System.out.println(obj.getString("id"));
		String name = obj.getString("name");
		if(StringUtils.isEmpty(name)){
			System.out.println("空");
		}
	}
	
	
}
