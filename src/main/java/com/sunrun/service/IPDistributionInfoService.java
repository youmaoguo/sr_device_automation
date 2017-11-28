package com.sunrun.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sunrun.entity.DevIpDistributionBean;
import com.sunrun.entity.DevIpSegmentConfigBean;
import com.sunrun.entity.DevIpSegmentDistributionBean;
import com.sunrun.entity.MenuBean;
import com.sunrun.util.Json;

public interface IPDistributionInfoService {

	/**
	 * 新增 IP 网段记录
	 */
	void saveIpSegmentDistribution(List<DevIpSegmentDistributionBean> devIpSegmentDistributionBeanList);

	/**
	 * 新增 IP 记录
	 */
	void saveDevIpDistribution(List<DevIpDistributionBean> devIpDistributionBean);

	/**
	 * 修改 IP 网段记录
	 * 
	 *
	 */
	void editIpSegmentDistribution(List<DevIpSegmentDistributionBean> devIpSegmentDistributionBeanList);

	/**
	 * 修改 IP 记录
	 * 
	 *
	 */
	void editIpDistribution(List<DevIpDistributionBean> devIpDistributionBean, DevIpDistributionBean devIpDistributionBean_one);


	/**
	 * 删除 IP 网段记录
	 * 
	 *
	 */
	void deleteIpSegmentDistribution( DevIpSegmentDistributionBean  devIpSegmentDistributionBean );

 

	/**
	 * 查询 IP 网段记录
	 * 
	 *
	 * @param like
	 *            模糊查询值/搜索值
	 * @param sortBy
	 *            排序值（根据哪个属性排序）
	 * @param order
	 *            排序方式（desc,asc）
	 * @param limit
	 *            分页条件
	 * @return
	 */
	List<DevIpSegmentDistributionBean> findDevIpSegmentDistribution(
			DevIpSegmentDistributionBean devIpSegmentDistributionBean, String exact, String like, String sortBy,
			String order, String limit);

	/**
	 * 查询 IP 记录
	 * 
	 *
	 * @param like
	 *            模糊查询值/搜索值
	 * @param sortBy
	 *            排序值（根据哪个属性排序）
	 * @param order
	 *            排序方式（desc,asc）
	 * @param limit
	 *            分页条件
	 * @return
	 */
	List<DevIpDistributionBean> findDevIpDistribution(DevIpDistributionBean devIpDistributionBean, String exact,
			String like, String sortBy, String order, String limit);


	/**
	 *查询IP网段操作历史记录
	 * @param devIpSegmentDistributionBean
	 * @return
	 */
	List<DevIpSegmentDistributionBean> ipSegment_distribution_historyDataInfo( DevIpSegmentDistributionBean devIpSegmentDistributionBean  );

	/**
	 * 查询IP操作历史记录信息
	 * @param devIpDistributionBean
	 * @return
	 */
	List<DevIpDistributionBean> ip_distribution_historyDataInfo( DevIpDistributionBean devIpDistributionBean );



	/**
	 * 统计 IP 网段记录
	 * 
	 * @param like
	 *            模糊查询值/搜索值
	 */
	Integer countDevIpSegmentDistribution(DevIpSegmentDistributionBean devIpSegmentDistributionBean, String exact,
			String like);

	/**
	 * 统计 IP 记录
	 * 
	 * @param like
	 *            模糊查询值/搜索值
	 */
	Integer countDevIpDistribution(DevIpDistributionBean devIpDistributionBean, String exact, String like);

	/**
	 * 查询 网络类型、用途、设备类型、类别、ip地址类型、用途规划 的值
	 * 
	 * @return
	 */
	List<DevIpSegmentConfigBean> findDevIpSegmentConfigBean(DevIpSegmentConfigBean devIpSegmentConfigBean);

	/**
	 * 查询 负责人 接口
	 * 
	 * @return
	 */
	List<String> findAllocationUser();
	
	/**
	 * 查找用户是否有权限
	 * @param name
	 * @param userId
	 * @return
	 */
	Integer findUserRole(@Param("name") String name, @Param("userId") String userId );
 
 
	/**
	 * 查看菜单信息
	 * @param menuBean
	 * @return
	 */
	List<MenuBean> findMenu(MenuBean menuBean );

}
