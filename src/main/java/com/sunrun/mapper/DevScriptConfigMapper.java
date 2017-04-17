package com.sunrun.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.sunrun.entity.DevScriptConfig;

/**
 * 设备脚本配制信息mapper接口
 * @author ymg
 *
 */

@Mapper
public interface DevScriptConfigMapper {

	/**
	 * 新增配置信息
	 * @param config
	 */
	void saveDevScriptConfig(@Param("config") DevScriptConfig config);
	
	/**
	 * 查询配置信息
	 * @param config
	 * @return
	 */
	List<DevScriptConfig> findDevScriptConfig(@Param("config") DevScriptConfig config);
	
	
}
