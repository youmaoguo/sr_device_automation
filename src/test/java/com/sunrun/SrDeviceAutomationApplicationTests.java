package com.sunrun;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sunrun.entity.DevOnlineTask;
import com.sunrun.service.DeviceAutomationService;
import com.sunrun.task.AddSwitchDevice;
import com.sunrun.task.KvmInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SrDeviceAutomationApplicationTests {

	private boolean flag = true;
	
	@Resource
	private DeviceAutomationService deviceAutomationService;

	@Test
	public void contextLoads() {
		String[] taskIds = {"28380b02be494bb4b7133a764b5177a8", "47c70af62e7a4d0b8143cfe09caa51ef","4fa5b51d1ba24dc5955ed28161a355e4"};
		String s = deviceAutomationService.concatDeviceItilInfo(taskIds);
		System.out.println(s);
	}
	
	public static void main(String[] args) {
		
		
	}

	
}
