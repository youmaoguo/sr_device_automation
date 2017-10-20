package com.sunrun.service;

import java.util.List;


import com.sunrun.entity.DevPortDredgeOrder;
import com.sunrun.util.Json;

public interface DevPortDredgeOrderService {
	
	/**
	 * 新增工单记录
	 * @param id
	 * @param userId
	 * @param handlerName
	 * @param switchboardIp
	 * @param portModeVlan
	 * @param switchboardUser
	 * @param switchboardPass
	 * @return
	 */
	Json savePortDredgeOrder(String id,String userId, String handlerName, String switchboardIp, String portModeVlan,String switchboardUser,String switchboardPass, String portDescribe, String vlanDescribe);
	
	
	/**
	 * 修改
	 * @param port
	 */
	void editPortDredgeOrder(DevPortDredgeOrder port);

	/**
	 * 查询
	 * @param port
	 * @param like		模糊查询值/搜索值
	 * @param sortBy	排序值（根据哪个属性排序）
	 * @param order		排序方式（desc,asc）
	 * @param limit		分页条件
	 * @return
	 */
	List<DevPortDredgeOrder> findPortDredgeOrder(DevPortDredgeOrder port, String like, String sortBy, String order, String limit);
	
	/**
	 * 统计
	 * @param port
	 * @param like		模糊查询值/搜索值
	 * @param sortBy	排序值（根据哪个属性排序）
	 * @param order		排序方式（desc,asc）
	 * @param limit		分页条件
	 */
	Integer countPortDredgeOrder(DevPortDredgeOrder port, String like, String sortBy, String order);

	/**
	 * 执行命令
	 * @param id
	 * @param switchboardIp
	 * @param portModeVlan
	 * @param switchboardUser
	 * @param switchboardPass
	 * @return
	 */
	Json executeCommand(String id, String switchboardIp, String portModeVlan,String switchboardUser,String switchboardPass, String portDescribe);

	/**
	 * 查询工单下的所有执行情况
	 * @param taskId
	 * @return
	 */
	Json findExecuteDetail(String taskId);
	
}
