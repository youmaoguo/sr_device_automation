package com.sunrun.service;

import java.util.List;

import com.sunrun.entity.DevAreaSwitchboardIp;
import com.sunrun.entity.DevExclusiveSwitchboardInfo;
import com.sunrun.entity.DevOnlineBatchItil;
import com.sunrun.entity.DevOnlineTask;
import com.sunrun.entity.DevTaskExecute;
import com.sunrun.entity.view.DevOnlineBatchTaskView;
import com.sunrun.util.Json;

/**
 * 交换机设备自动化业务层
 * @author ymg
 *
 */
public interface DeviceAutomationService {
	
	/**
	 * 新增某一批次下具体的新增任务
	 * @param task	具体新增的任务对象
	 * @param executeStep	任务步骤
	 * @return		true or false
	 */
	boolean saveDevice(DevOnlineTask task, Integer executeStep, String userName);
	
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
	 * @param task			任务对象
	 * @param executeStep	任务步骤
	 * @param object		配置数据信息
	 * @return
	 */
	boolean updateTask(DevOnlineTask task, Integer executeStep, Object object, String userName);
	
	/**
	 * 修改批次下的任务,并且记录任务执行情况log
	 * @param task			任务对象
	 * @param execute		具体任务的执行情况对象
	 * @param executeStep	任务步骤
	 * @return
	 */
	boolean updateTask2(DevOnlineTask task,DevTaskExecute execute, Integer executeStep, String userName);
	
	/**
	 * 修改具体任务的执行情况
	 * @param execute
	 * @return
	 */
	boolean updateExecute(DevTaskExecute execute);
	
	/**
	 * 查询任务对象
	 * @param taskView	
	 * @return
	 */
	DevOnlineBatchTaskView findTaskById(DevOnlineBatchTaskView taskView); 
	
	/**
	 * 查找所有的主备汇聚端口
	 * @return
	 */
	List<DevOnlineTask> findPort(String taskId);
	
	/**
	 * 保存工单与任务的对应关系
	 * @param itilNumber	工单号
	 * @param taskIds		任务id
	 */
	void saveTaskItil(String itilNumber, List<String> taskIds, String userName);
	
	
	/**
	 * 上线交换机ITIL工单处理业务
	 * @param itilPlannedEnd
	 * @param updateUser
	 * @param taskId
	 */
	boolean switchDeviceITIL(String itil, String itilPlannedEnd, String updateUser, String[] taskId, String usercode);
	
	/**
	 * 根据任务id查询任务执行情况
	 * @param taskId	任务id
	 * @param order		根据哪个字段降序排序
	 * @return
	 */
	List<DevTaskExecute> findTaskExecute(String taskId, String order);
	
	/**
	 * kvm接口所对应的设备型号信息接口
	 * @param info
	 * @param thirdPartUrl
	 * @param auth
	 * @return
	 */
	Json findKvmInfo(DevExclusiveSwitchboardInfo info, String thirdPartUrl, String auth);
	
	/**
	 * 查询区域汇聚交换机ip对应
	 * @param info
	 * @return
	 */
	List<DevAreaSwitchboardIp> findAreaIp(DevAreaSwitchboardIp info);
	
	/**
	 * 查询带外交换机信息
	 * @param info
	 * @return
	 */
	List<DevExclusiveSwitchboardInfo> findDevExclusiveSwitchboardInfo(DevExclusiveSwitchboardInfo info);
	
	
}
