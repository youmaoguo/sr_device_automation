package com.sunrun.service;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunrun.entity.DevOnlineBatchItil;
import com.sunrun.entity.DevOnlineTask;
import com.sunrun.entity.DevOnlineTaskItil;
import com.sunrun.entity.DevTaskExecute;
import com.sunrun.entity.view.DevOnlineBatchTaskView;
import com.sunrun.mapper.DevOnlineBatchItilMapper;
import com.sunrun.mapper.DevOnlineTaskItilMapper;
import com.sunrun.mapper.DevOnlineTaskMapper;
import com.sunrun.mapper.DevTaskExecuteMapper;
import com.sunrun.util.StringUtil;

@Service("deviceAutomationService")
public class DeviceAutomationServiceImpl implements DeviceAutomationService {
	private static final Logger logger = LoggerFactory.getLogger(DeviceAutomationServiceImpl.class);
	@Resource
	private DevOnlineBatchItilMapper devOnlineBatchItilMapper;
	@Resource
	private DevOnlineTaskMapper devOnlineTaskMapper;
	@Resource
	private DevTaskExecuteMapper devTaskExecuteMapper;
	@Resource
	private DevOnlineTaskItilMapper devOnlineTaskItilMapper;
	
	@Transactional
	@Override
	public boolean saveDevice(DevOnlineTask task) {
		boolean b = true;
		try{
			devOnlineTaskMapper.saveDevOnlineTask(task);
		}catch(Exception e){
			b = false;
			e.printStackTrace();
			logger.error("新增批次任务出错");
		}
		return b;
	}


	@Transactional
	@Override
	public boolean deleteTask(String id) {
		boolean b = true;
		try{
			devOnlineTaskItilMapper.deleteTaskItil(id, null); 		//删除task与ITIL对应关系
			devTaskExecuteMapper.deleteDevTaskExecute(null, id);	//删除该任务在具体执行情况表中的数据
			devOnlineTaskMapper.deleteDevOnlineTask(id, null);		//再删除任务表
		}catch(Exception e){
			b = false;
			e.printStackTrace();
			logger.error("删除具体任务出错");
		}
		return b;
	}

	@Transactional
	@Override
	public boolean deleteExecute(String id) {
		boolean b = true;
		try{
			devTaskExecuteMapper.deleteDevTaskExecute(id, null);
		}catch(Exception e){
			b = false;
			e.printStackTrace();
			logger.error("删除任务执行情况出错");
		}
		return b;
	}
	
	@Override
	public List<DevOnlineBatchTaskView> findDevBatchTask(DevOnlineBatchTaskView batchView, String like, String sortBy, String order, String limit) {
		List<DevOnlineBatchTaskView> list = null;
		try{
			list = devOnlineBatchItilMapper.findItilTask(batchView, like, sortBy, order, limit);
		}catch(Exception e){
			e.printStackTrace();
			logger.error("查询itil任务出错");
		}
		return list;
	}

	@Override
	public boolean updateBatch(DevOnlineBatchItil batch) {
		boolean b = true;
		try{
			devOnlineBatchItilMapper.updateDevOnlineBatch(batch);
		}catch(Exception e){
			b = false;
			e.printStackTrace();
			logger.error("修改批次出错了");
		}
		return b;
	}

	@Override
	public boolean updateTask(DevOnlineTask task) {
		boolean b = true;
		try{
			devOnlineTaskMapper.updateDevOnlineTask(task);
		}catch(Exception e){
			b = false;
			e.printStackTrace();
			logger.error("修改批次下的任务出错了");
		}
		return b;
	}

	@Override
	public boolean updateExecute(DevTaskExecute execute) {
		boolean b = true;
		try{
			devTaskExecuteMapper.updateDevTaskExecute(execute);
		}catch(Exception e){
			b = false;
			e.printStackTrace();
			logger.error("修改批次下的任务出错了");
		}
		return b;
	}


	@Override
	public DevOnlineTask findTaskById(String id) {
		return devOnlineTaskMapper.findTaskById(id);
	}


	@Override
	public void saveTaskItil(String itilNumber, List<String> taskIds) {
		try{
			for(int i=0;i<taskIds.size();i++){
				DevOnlineTaskItil taskItil = new DevOnlineTaskItil();
				taskItil.setDevOnlineTaskId(taskIds.get(i));
				taskItil.setItilNumber(itilNumber);
				taskItil.setId(StringUtil.getUuid());
				devOnlineTaskItilMapper.saveTaskItil(taskItil);
			}
		}catch(Exception e){
			e.printStackTrace();
			logger.error("保存工单与任务的对应关系出错了");
			throw new RuntimeException(e);
		}
	}

	@Transactional
	@Override
	public void deleteTaskItil(String taskId, String itilNumber) {
		try{
			devOnlineTaskItilMapper.deleteTaskItil(taskId, itilNumber);	//删除ITIL与task对应关系
			devOnlineTaskMapper.deleteDevOnlineTask(taskId, null);		//删除任务
		}catch(Exception e){
			e.printStackTrace();
			logger.error("删除itil任务出错");
			throw new RuntimeException(e);
		}
	}
	

}
