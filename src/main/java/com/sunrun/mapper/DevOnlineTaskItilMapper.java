package com.sunrun.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.sunrun.entity.DevOnlineTaskItil;

/**
 * 设备上线批次任务与 itil对应接口
 * @author ymg
 *
 */

@Mapper
public interface DevOnlineTaskItilMapper {
	
	/**
	 * 插入记录
	 * @param taskItil
	 */
	void saveTaskItil(@Param("taskItil") DevOnlineTaskItil taskItil);
	
	/**
	 * 查询itil与Task的对应关系
	 * @param taskId
	 * @param itilNumber
	 * @return
	 */
	List<DevOnlineTaskItil> findTaskItilMap(@Param("taskId") String taskId, @Param("itilNumber") String itilNumber, @Param("id") String id);
	
	/**
	 * 删除
	 * @param taskId		任务id
	 * @param itilNumber	工单号
	 */
	void deleteTaskItil(@Param("taskId") String taskId, @Param("itilNumber") String itilNumber);
	
}
