package com.sunrun.service;

import com.sunrun.entity.DevOnlineTask;

public interface TestService {
	
	/**
	 * 模拟申请ip方法
	 * @param count
	 * @return
	 */
	String applyIp(Integer count, DevOnlineTask task);
	
	
	/**
	 * 模拟回填方法
	 * @param ip
	 * @param status
	 * @return
	 */
	boolean callback(String ip, Integer status);
	
	
}
