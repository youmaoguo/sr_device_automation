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
import com.sunrun.mapper.DevExclusiveSwitchboardConnMapper;
import com.sunrun.mapper.DevIosVersionsMapper;
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
	@Resource
	private DevExclusiveSwitchboardConnMapper devExclusiveSwitchboardConnMapper;
	@Resource
	private DevIosVersionsMapper devIosVersionsMapper;
	
	@Transactional
	@Override
	public boolean saveDevice(DevOnlineTask task, Integer executeStep) {
		boolean b = true;
		try{
			devOnlineTaskMapper.saveDevOnlineTask(task);
			DevTaskExecute execute = new DevTaskExecute();
			execute.setId(StringUtil.getUuid());
			execute.setTaskId(task.getId());
			execute.setExecuteStep(executeStep);
			execute.setTaskExecuteState(3);
			devTaskExecuteMapper.saveDevTaskExecute(execute);
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

	@Transactional
	@Override
	public boolean updateTask(DevOnlineTask task, Integer executeStep, Object object) {
		boolean b = true;
		try{
			if(executeStep>0 && executeStep<6)
				devOnlineTaskMapper.updateDevOnlineTask(task);
			//第五步.保存接入交换机配置信息
			if(executeStep==5){
				List<String> l = (List<String>) object;
				//调用大文本api
				
			}
			//第六步，保存带外交换机信息  || 第七步，写交换机入管理口ip
			if(executeStep==6 /*|| executeStep==7*/){
				List<DevOnlineTask> l = (List<DevOnlineTask>) object;
				for(int i=0;i<l.size();i++){
					DevOnlineTask t = l.get(i);
					devOnlineTaskMapper.updateDevOnlineTask(t);
				}
			}
			
			//保存每一步步骤执行情况
			DevTaskExecute execute = new DevTaskExecute();
			execute.setId(StringUtil.getUuid());
			execute.setTaskId(task.getId());
			execute.setExecuteStep(executeStep);
			execute.setTaskExecuteState(3);
			devTaskExecuteMapper.saveDevTaskExecute(execute);
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
	public DevOnlineBatchTaskView findTaskById(DevOnlineBatchTaskView taskView) {
		return devOnlineTaskMapper.findTaskById(taskView);
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


	@Transactional
	@Override
	public boolean updateTask2(DevOnlineTask task, DevTaskExecute execute, Integer executeStep) {
		boolean b = true;
		try{
			devOnlineTaskMapper.updateDevOnlineTask(task);
			//保存每一步步骤执行情况
			devTaskExecuteMapper.saveDevTaskExecute(execute);
		}catch(Exception e){
			b = false;
			e.printStackTrace();
			logger.error("修改批次下的任务出错了");
		}
		return b;
	}
	

}
