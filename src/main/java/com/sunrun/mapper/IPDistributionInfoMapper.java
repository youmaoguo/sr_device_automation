package com.sunrun.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.sunrun.entity.DevIpDistributionBean;
import com.sunrun.entity.DevIpSegmentConfigBean;
import com.sunrun.entity.DevIpSegmentDistributionBean;
import com.sunrun.entity.DevPortDredgeOrder;
import com.sunrun.entity.MenuBean;
import com.sunrun.util.Json;

/**
 * 
 * @author jl
 *
 */

@Mapper
public interface IPDistributionInfoMapper {

	/**
	 * 新增 IP 网段记录
	 */
	void saveIpSegmentDistribution(@Param("para") List<DevIpSegmentDistributionBean> devIpSegmentDistributionBeanList);

	/**
	 * 新增 IP 记录
	 */
	void saveDevIpDistribution(@Param("para") List<DevIpDistributionBean> devIpDistributionBean);

	/**
	 * 修改 IP 网段记录
	 * @param devIpSegmentDistributionBeanList
	 */
	void editIpSegmentDistribution(@Param("para") List<DevIpSegmentDistributionBean> devIpSegmentDistributionBeanList);

	/**
	 * 修改 IP 记录
	 *
	 */
	void editIpDistribution(@Param("set") Set<String> idValues_db);

	/**
	 * 删除 IP 网段记录
	 *
	 */
	void deleteIpSegmentDistribution(
			@Param("para")   DevIpSegmentDistributionBean  devIpSegmentDistributionBean );

 

	/**
	 * 查询
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
	List<DevIpSegmentDistributionBean> findDevIpSegmentDistribution(@Param("para") DevIpSegmentDistributionBean para,
			@Param("exact") String exact, @Param("like") String like, @Param("sortBy") String sortBy,
			@Param("order") String order, @Param("limit") String limit);

	/**
	 * 查询 IP 记录
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
	List<DevIpDistributionBean> findDevIpDistribution(@Param("para") DevIpDistributionBean devIpDistributionBean,
			@Param("exact") String exact, @Param("like") String like, @Param("sortBy") String sortBy,
			@Param("order") String order, @Param("limit") String limit);

	/**
	 * 统计
	 *
	 * @param like
	 *            模糊查询值/搜索值
	 */
	Integer countDevIpSegmentDistribution(@Param("para") DevIpSegmentDistributionBean para,
			@Param("exact") String exact, @Param("like") String like);

	/**
	 * 统计 IP 记录
	 * 
	 * @param like
	 *            模糊查询值/搜索值
	 */
	Integer countDevIpDistribution(@Param("para") DevIpDistributionBean devIpDistributionBean,
			@Param("exact") String exact, @Param("like") String like);

	/**
	 * 查询 网络类型、用途、设备类型、类别、ip地址类型、用途规划 的值
	 * 
	 * @return
	 */
	List<DevIpSegmentConfigBean> findDevIpSegmentConfigBean(
			@Param("para") DevIpSegmentConfigBean devIpSegmentConfigBean);

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
	List<MenuBean> findMenu(@Param("para") MenuBean menuBean );


	/**
	 *查询IP网段操作历史记录
	 * @param devIpSegmentDistributionBean
	 * @return
	 */
	List<DevIpSegmentDistributionBean> find_ipSegment_distribution_historyDataInfo(@Param("para")  DevIpSegmentDistributionBean devIpSegmentDistributionBean  );

	/**
	 * 查询IP操作历史记录信息
	 * @param devIpDistributionBean
	 * @return
	 */
	List<DevIpDistributionBean> find_ip_distribution_historyDataInfo(@Param("para") DevIpDistributionBean devIpDistributionBean );


	/**
	 * 更新 IpSegmentDistribution 中IP使用数量
	 * @param ipSegment
	 */
	void  updateIpSegmentDistribution(@Param("ipSegment")String ipSegment);


}
