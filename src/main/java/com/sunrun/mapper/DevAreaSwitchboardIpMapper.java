package com.sunrun.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.sunrun.entity.DevAreaSwitchboardIp;

/**
 * 设备品牌型号对应
 * @author ymg
 *
 */

@Mapper
public interface DevAreaSwitchboardIpMapper {
	

	/**
	 * 查询
	 * @param version
	 * @return
	 */
	List<DevAreaSwitchboardIp> findAreaIp(@Param("area") DevAreaSwitchboardIp area);
	
}
