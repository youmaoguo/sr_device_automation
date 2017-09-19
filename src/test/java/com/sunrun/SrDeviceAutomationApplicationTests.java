package com.sunrun;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sunrun.entity.DevOnlineTask;
import com.sunrun.entity.DevPortCommandInfo;
import com.sunrun.entity.DevPortDredgeOrder;
import com.sunrun.mapper.DevPortCommandInfoMapper;
import com.sunrun.mapper.DevPortDredgeOrderMapper;
import com.sunrun.service.AddSwitchDeviceService;
import com.sunrun.service.DeviceAutomationService;
import com.sunrun.task.PortCheck;
import com.sunrun.util.StringUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SrDeviceAutomationApplicationTests {

	private boolean flag = true;
	
	@Resource
	private DeviceAutomationService deviceAutomationService;
	@Resource
	private AddSwitchDeviceService addSwitchDeviceService;
	@Resource
	private PortCheck portCheck;
	@Resource
	private DevPortDredgeOrderMapper devPortDredgeOrderMapper;
	@Resource
	private DevPortCommandInfoMapper devPortCommandInfoMapper;
	
	
	@Test
	public void contextLoads() {
		DevPortDredgeOrder port = new DevPortDredgeOrder();
		port.setId("1");
		port.setState(1);
		devPortDredgeOrderMapper.editPortDredgeOrder(port);
	}
	
	public static void main(String[] args) {
		String port= "125-dd-0101;";
		String[] p = port.split(";");
		System.out.println(p.length);
		for(int i=0;i<p.length;i++){
			System.out.println("i="+i+"--"+p[i]);
		}
		
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
