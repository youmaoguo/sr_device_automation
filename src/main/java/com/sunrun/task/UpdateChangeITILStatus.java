package com.sunrun.task;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sunrun.entity.DevOnlineBatchItil;
import com.sunrun.service.DeviceAutomationService;
import com.sunrun.util.ITILRestfulInterface;
import com.sunrun.util.StringUtil;

/**
 * 查询并且更新变更itil工单状态
 * @author ymg
 *
 */
@Component
public class UpdateChangeITILStatus {
	private static final Logger logger = LoggerFactory.getLogger(UpdateChangeITILStatus.class);
	
	@Value("${itil.changeItils}")
	private String changeItils;
	
	@Value("${itil.user}")
	private String user;
	
	@Value("${itil.pwd}")
	private String pwd;
	
	@Resource
	private DeviceAutomationService deviceAutomationService;
	
	@Scheduled(cron="0 0/10 * * * ?") //每10分钟执行一次  
    public void statusCheck() {
        logger.info("每10分钟执行一次查询变更itil工单状态。开始……");  
        List<DevOnlineBatchItil> list = deviceAutomationService.findItilStatus();
        for(int i=0;i<list.size();i++){
        	DevOnlineBatchItil itil = list.get(i);
        	try {
        		logger.info("查询变更itil工单状态url:"+changeItils+"?view=expand&number="+itil.getItilNumber()+"; GET方法,头部验证是："+StringUtil.basic64Encord(user, pwd));
				String sb = ITILRestfulInterface.queryChangeITILByNumber(changeItils+"?view=expand&number="+itil.getItilNumber(), null, "GET", StringUtil.basic64Encord(user, pwd));
				logger.info("查询变更itil工单状态返回："+sb);
				if(StringUtils.isEmpty(sb))
					return;
				JSONObject obj = JSONObject.parseObject(sb);
				int code = obj.getIntValue("ret_code");
				if(code==200){
					JSONArray array = obj.getJSONArray("data");
					for(int j=0;j<array.size();j++){
						JSONObject o = array.getJSONObject(j);
						String status = o.getString("status");
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
        logger.info("每10分钟执行一次查询变更itil工单状态。结束。");  
    }    
  

}
