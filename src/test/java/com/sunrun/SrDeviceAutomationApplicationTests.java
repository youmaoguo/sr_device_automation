package com.sunrun;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sunrun.entity.DevOnlineTask;
import com.sunrun.service.DeviceAutomationService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SrDeviceAutomationApplicationTests {

	@Resource
	private DeviceAutomationService deviceAutomationService;

	@Test
	public void contextLoads() {

		System.out.println(11);
		List<DevOnlineTask> li = deviceAutomationService.findPort("1");
		System.out.println(li.size());
	}

	
}
