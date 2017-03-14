package com.sunrun.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.sunrun.entity.DevOnlineTask;

/**
 * 设备上线批次任务接口
 * @author ymg
 *
 */

@Mapper
public interface DevOnlineTaskMapper {

	/**
	 * 新增备上线批次任务
	 * @param task
	 * @return
	 */
	Integer saveDevOnlineTask(@Param("task") DevOnlineTask task);
	
	/**
	 * 修改上线批次任务
	 * @param task
	 * @return
	 */
	Integer updateDevOnlineTask(@Param("task") DevOnlineTask task);
	
	/**
	 * 删除上线批次任务
	 * @param id		任务id
	 * @param batchId	外键，批次batchId
	 * @return
	 */
	Integer deleteDevOnlineTask(@Param("id") String id, @Param("batchId") String batchId);
	
	/**
	 * 根据任务ID查询任务对象
	 * @param id
	 * @return
	 */
	DevOnlineTask findTaskById(@Param("id") String id);
	
	
}
