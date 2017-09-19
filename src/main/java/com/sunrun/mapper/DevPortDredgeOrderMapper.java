package com.sunrun.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.sunrun.entity.DevPortDredgeOrder;

/**
 * 设备端口开通工单接口
 * @author ymg
 *
 */

@Mapper
public interface DevPortDredgeOrderMapper {
	
	/**
	 * 新增
	 * @param port
	 */
	void savePortDredgeOrder(@Param("port") DevPortDredgeOrder port);
	
	/**
	 * 修改
	 * @param port
	 */
	void editPortDredgeOrder(@Param("port") DevPortDredgeOrder port);

	/**
	 * 查询
	 * @param port
	 * @param like		模糊查询值/搜索值
	 * @param sortBy	排序值（根据哪个属性排序）
	 * @param order		排序方式（desc,asc）
	 * @param limit		分页条件
	 * @return
	 */
	List<DevPortDredgeOrder> findPortDredgeOrder(@Param("port") DevPortDredgeOrder port, @Param("like") String like, @Param("sortBy") String sortBy, @Param("order") String order, @Param("limit") String limit);
	
	/**
	 * 统计
	 * @param port
	 * @param like		模糊查询值/搜索值
	 * @param sortBy	排序值（根据哪个属性排序）
	 * @param order		排序方式（desc,asc）
	 * @param limit		分页条件
	 */
	Integer countPortDredgeOrder(@Param("port") DevPortDredgeOrder port, @Param("like") String like, @Param("sortBy") String sortBy, @Param("order") String order);
	
	/**
	 * 查询是ip下是否存在重复的端口和vlan
	 * @param switchboardIp
	 * @param port
	 * @param vlan
	 * @return
	 */
	Integer distinctCountPortVlan(@Param("switchboardIp") String switchboardIp, @Param("port") String port, @Param("vlan") String vlan);
	
}
