package com.sunrun.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.sunrun.entity.DevTaskExecute;

/**
 * 任务执行情况接口
 * @author ymg
 *
 */
@Mapper
public interface DevTaskExecuteMapper {
	
	/**
	 * 新增任务执行情况
	 * @param execute
	 * @return
	 */
	Integer saveDevTaskExecute(@Param("execute") DevTaskExecute execute);
	
	/**
	 * 更新任务执行情况
	 * @param execute
	 * @return
	 */
	Integer updateDevTaskExecute(@Param("execute") DevTaskExecute execute);
	
	/**
	 * 删除任务执行情况
	 * @param id		具体执行情况id
	 * @param taskId	外键，任务taskId
	 * @return
	 */
	Integer deleteDevTaskExecute(@Param("id") String id, @Param("taskId") String taskId);
	
	/**
	 * 根据任务id查询任务执行情况
	 * @param taskId
	 * @return
	 */
	List<DevTaskExecute> findTaskExecute(@Param("taskId") String taskId, @Param("executeStep") Integer executeStep, @Param("order") String order);

}
