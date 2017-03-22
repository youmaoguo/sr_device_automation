package com.sunrun.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.sunrun.entity.DevIosVersions;

/**
 * 设备版本库信息
 * @author ymg
 *
 */

@Mapper
public interface DevIosVersionsMapper {
	
	/**
	 * 新增
	 * @param version
	 */
	void saveIosVersion(@Param("version") DevIosVersions version);
	
	/**
	 * 修改
	 * @param version
	 */
	void updateIosVersion(@Param("version") DevIosVersions version);
	
	/**
	 * 删除
	 * @param id
	 */
	void deleteIosVersion(@Param("id") String id);
	
	/**
	 * 查询
	 * @param version
	 * @return
	 */
	List<DevIosVersions> findIosVersion(@Param("version") DevIosVersions version);
}
