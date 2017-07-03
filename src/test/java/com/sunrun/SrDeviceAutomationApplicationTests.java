package com.sunrun;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sunrun.service.DeviceAutomationService;

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
		String itilPlannedEnd = "2017-07-03 19:00";
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
		Date ds;
		try {
			ds = f.parse(itilPlannedEnd);
			Calendar calendar = Calendar.getInstance();
	        calendar.setTime(ds);
	        calendar.add(Calendar.HOUR_OF_DAY, +4);
	        Date d = calendar.getTime();
	        String start = fmt.format(d);
	        System.out.println(d);
	        System.out.println(start);
	        
	        System.out.println(" 1 2 3 4 ".replaceAll(" ", "").trim());
	        
	        String plan = "1.变更方案说明\n";
			plan += "确定接入交换机上线机架位置及区域\n";
			plan += "准备接入交换机和汇聚交换机配置\n";
			plan += "写入接入交换机配置并进行跳线连接到汇聚交换机\n";
			plan += "写入汇聚交换机配置\n";
			plan += "技术验证设备配置是否符合要求\n\n";
			plan += "2.变更失败后果及规避措施\n";
			plan += "新设备上线不会影响到原有配置，若变更失败进行回退\n\n";
			plan += "3.回退方案\n";
			plan += "断开接入交换机与汇聚交换机连线\n";
			plan += "删除汇聚交换机接口配置并shutdown接口\n";
	        System.out.println(plan);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}

	
}
