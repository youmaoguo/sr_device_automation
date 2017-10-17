package com.sunrun.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.sunrun.entity.DevPortCommandInfo;

/**
 * 设备端口开通工单执行详情接口
 * @author ymg
 *
 */

@Mapper
public interface DevPortCommandInfoMapper {
	
	/**
	 * 新增
	 * @param port
	 */
	void savePortCommandInfo(@Param("port") DevPortCommandInfo port);
	

	/**
	 * 查询
	 * @param port
	 * @return
	 */
	List<DevPortCommandInfo> findPortCommandInfo(@Param("port") DevPortCommandInfo port);
	
	/**
	 * 编辑
	 * @param port
	 */
	void editPortCommand(@Param("port") DevPortCommandInfo port);
	
	void editExecuteStatusGT(@Param("port") DevPortCommandInfo port);
	
	void editExecuteStatusLT(@Param("port") DevPortCommandInfo port);
	
	/**
	 * 查找工单下有多个少ip和端口
	 * @param taskId
	 * @return
	 */
	List<DevPortCommandInfo> findIpAndPortByTaskId(@Param("taskId") String taskId);

	/**
	 * 根据ip和端口查询具体执行情况
	 * @param port
	 * @return
	 */
	List<DevPortCommandInfo> findExecuteDetail(@Param("port") DevPortCommandInfo port);
	
}
