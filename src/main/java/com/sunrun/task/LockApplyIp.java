package com.sunrun.task;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

import javax.annotation.Resource;

import com.sunrun.entity.DevOnlineTask;
import com.sunrun.service.DeviceAutomationService;

public class LockApplyIp {
	
	@Resource
	private DeviceAutomationService deviceAutomationService;
	
	public static ReentrantLock lock=new ReentrantLock();
	
	 // 定义一个私有的构造方法
    private LockApplyIp() {  
    }  

    // 将自身的实例对象设置为一个属性,并加上Static和final修饰符
    private static final LockApplyIp instance = new LockApplyIp();  

    // 静态方法返回该类的实例
    public static LockApplyIp getInstancei() {  
        return instance;  
    } 
    
    /**
     * 去数据库查这个ip,没有就插入库 返回fasle,有就返回true
     * @param ip
     * @return
     */
    public boolean checkHaveIp(String ip, String id){
    	boolean b = true;
    	lock.lock();
    	try{
        	//去数据库查这个ip
    		DevOnlineTask t = new DevOnlineTask();
			t.setManagerIp(ip);
    		List<DevOnlineTask> li = deviceAutomationService.findTask(t);
    		if(li==null || li.size()==0){
    			b = false;
    			//没有就插入库 返回true
    			deviceAutomationService.updateTask2(t, null, null, null);
    		}
        	
    	}catch(Exception e){
    		e.printStackTrace();
    	}finally{
    		lock.unlock();
    	}
    	return b;
    }

}
