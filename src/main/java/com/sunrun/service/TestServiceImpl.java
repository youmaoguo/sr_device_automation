package com.sunrun.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sunrun.entity.DevOnlineTask;
import com.sunrun.entity.Test;
import com.sunrun.mapper.TestMapper;

@Service("testService")
public class TestServiceImpl implements TestService {

	@Resource
	private TestMapper testMapper;
	@Resource
	DeviceAutomationService deviceAutomationService;
	
	@Override
	public String applyIp(Integer count, DevOnlineTask task){
		Test test = new Test();
		test.setStatus(0);
		List<Test> list = testMapper.findTestIp(test);
		if(count==null || count==1){
			String ip = list.get(0).getIp();
			task.setManagerIp(ip);
			deviceAutomationService.updateTask2(task, null, null, "");
			return ip;
		}else{
			String ip = "";
			if(count>1 && count<list.size()){
				for(int i=0;i<list.size();i++){
					if(count-1>=i){
						ip += list.get(i).getIp()+",";
					}
				}
			}
			task.setManagerIp(ip);
			deviceAutomationService.updateTask2(task, null, null, "");
			return ip;
		}
	}

	@Override
	public boolean callback(String ip, Integer status){
		Test test = new Test();
		test.setIp(ip);
		test.setStatus(status);
		testMapper.updateTest(test);
		return true;
	}

}
