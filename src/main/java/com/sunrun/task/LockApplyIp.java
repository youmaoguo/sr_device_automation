package com.sunrun.task;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

import javax.annotation.Resource;

import com.sunrun.entity.DevOnlineTask;
import com.sunrun.service.AddSwitchDeviceService;
import com.sunrun.service.DeviceAutomationService;

public class LockApplyIp {
	
	@Resource
	private DeviceAutomationService deviceAutomationService;
	@Resource
	private AddSwitchDeviceService addSwitchDeviceService;
	
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
    public boolean checkHaveIp(String ip, String id, String vlan){
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
    			t.setId(id);
    			deviceAutomationService.updateTask2(t, null, null, null);
    		}
    		if(!b){
    			t.setManagerIp(ip);
    			t.setVlan(vlan);
    		}else{
    			t.setManagerIp(null);
    			t.setVlan(null);
    		}
    		t.setId(id);
    		addSwitchDeviceService.writeProcess(t, 2, b==false?"从看板申请ip和vlan成功":"从看板申请到重复的ip,失败", !b, null, null);
    	}catch(Exception e){
    		e.printStackTrace();
    	}finally{
    		lock.unlock();
    	}
    	return b;
    }

}
