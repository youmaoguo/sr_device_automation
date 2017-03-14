package com.sunrun.service;

import java.util.List;
import com.sunrun.entity.DevOnlineBatchItil;
import com.sunrun.entity.DevOnlineTask;
import com.sunrun.entity.DevTaskExecute;
import com.sunrun.entity.view.DevOnlineBatchTaskView;

/**
 * 交换机设备自动化业务层
 * @author ymg
 *
 */
public interface DeviceAutomationService {
	
	/**
	 * 新增某一批次下具体的新增任务
	 * @param task	具体新增的任务对象
	 * @return		true or false
	 */
	boolean saveDevice(DevOnlineTask task);
	
	/**
	 * 删除批次Itil
	 * @param taskId	  任务id
	 * @param itilNumber 工单号
	 */
	void deleteTaskItil(String taskId, String itilNumber);
	
	/**
	 * 删除具体任务（即此操作还要删除该任务下的执行情况）
	 * @param id 任务id
	 * @return
	 */
	boolean deleteTask(String id);
	
	/**
	 * 删除任务执行情况
	 * @param id	任务执行情况id
	 * @return
	 */
	boolean deleteExecute(String id);
	
	/**
	 * 查询批次任务
	 * @param batchView	批次、任务、执行情况的javaBean
	 * @param like		模糊查询值/搜索值
	 * @param sortBy	排序值（根据哪个属性排序）
	 * @param order		排序方式（desc,asc）
	 * @param limit		分页条件
	 * @return
	 */
	List<DevOnlineBatchTaskView> findDevBatchTask(DevOnlineBatchTaskView batchView, String like, String sortBy, String order, String limit);
	
	/**
	 * 修改某一批次
	 * @param batch
	 * @return
	 */
	boolean updateBatch(DevOnlineBatchItil batch);
	
	/**
	 * 修改批次下的任务
	 * @return
	 */
	boolean updateTask(DevOnlineTask task);
	
	/**
	 * 修改具体任务的执行情况
	 * @param execute
	 * @return
	 */
	boolean updateExecute(DevTaskExecute execute);
	
	/**
	 * 根据id查询任务对象
	 * @param id	任务id
	 * @return
	 */
	DevOnlineTask findTaskById(String id); 
	
	/**
	 * 保存工单与任务的对应关系
	 * @param itilNumber	工单号
	 * @param taskIds		任务id
	 */
	void saveTaskItil(String itilNumber, List<String> taskIds);
	
}
