package com.sunrun.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.sunrun.entity.DevExclusiveSwitchboardInfo;


/**
 * 带外交换机信息接口mapper
 * @author ymg
 *
 */

@Mapper
public interface DevExclusiveSwitchboardInfoMapper {

	/**
	 * 新增
	 * @param info
	 */
	//void saveDevExclusiveSwitchboardInfo(@Param("info") DevExclusiveSwitchboardInfo info);
	
	/**
	 * 查询
	 * @return
	 */
	List<DevExclusiveSwitchboardInfo> findDevExclusiveSwitchboardInfo(@Param("info") DevExclusiveSwitchboardInfo info);
	
}
