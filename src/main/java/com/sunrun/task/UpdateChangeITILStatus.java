package com.sunrun.task;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sunrun.entity.DevOnlineBatchItil;
import com.sunrun.service.DeviceAutomationService;
import com.sunrun.util.ITILRestfulInterface;

/**
 * 查询并且更新变更itil工单状态
 * @author ymg
 *
 */
@Component
public class UpdateChangeITILStatus {
	private static final Logger logger = LoggerFactory.getLogger(UpdateChangeITILStatus.class);
	
	@Resource
	private DeviceAutomationService deviceAutomationService;
	
	@Scheduled(cron="0 0/1 * * * ?") //每分钟执行一次  
    public void statusCheck() {      
        logger.info("每分钟执行一次。开始……");  
        List<DevOnlineBatchItil> list = deviceAutomationService.findItilStatus();
        for(int i=0;i<list.size();i++){
        	DevOnlineBatchItil itil = list.get(i);
        	try {
				String sb = ITILRestfulInterface.queryChangeITILByNumber("", null, "GET", "");
				JSONObject obj = JSONObject.parseObject(sb);
				int code = obj.getIntValue("ret_code");
				if(code==200){
					JSONArray array = obj.getJSONArray("data");
					for(int j=0;j<array.size();j++){
						JSONObject o = array.getJSONObject(j);
						String status = o.getString("statue");
						String number = o.getString("number");
						itil.setItilStatus(status);
						itil.setItilNumber(number);
						deviceAutomationService.updateBatch(itil);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
        }
        logger.info("每分钟执行一次。结束。");  
    }    
  
    @Scheduled(fixedRate=20000)  
    public void testTasks() {      
        logger.info("每20秒执行一次。开始……");  
        //statusTask.healthCheck();  
        logger.info("每20秒执行一次。结束。");  
    }    

}