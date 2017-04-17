package com.sunrun;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.sunrun.entity.DevOnlineTask;
import com.sunrun.service.DeviceAutomationService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@Configuration
@EnableTransactionManagement
public class BaseTest {
	
	@Resource
	private DeviceAutomationService deviceAutomationService;
	
	@Test
	public void test(){
		/*List<DevOnlineTask> map = deviceAutomationService.findPort(null);
		System.out.println(map.toString());*/
	}

}
