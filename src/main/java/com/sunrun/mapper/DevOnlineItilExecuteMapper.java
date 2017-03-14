package com.sunrun.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.sunrun.entity.DevOnlineItilExecute;

/**
 * 设备上线批次_itil工单执行情况接口
 * @author ymg
 *
 */
@Mapper
public interface DevOnlineItilExecuteMapper {
	
	/**
	 * 插入
	 * @param execute
	 */
	void saveItilExecute(@Param("execute") DevOnlineItilExecute execute);
	
	/**
	 * 根据单号查找工单的执行情况信息
	 * @param itilNumber
	 * @return
	 */
	List<DevOnlineItilExecute> findItilExecuteInfo(@Param("itilNumber") String itilNumber);
	
	
}
