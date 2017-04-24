package com.sunrun.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.sunrun.entity.DevExclusiveSwitchboardConn;

/**
 * 带外交换机连接信息mapper
 * @author ymg
 *
 */
@Mapper
public interface DevExclusiveSwitchboardConnMapper {

	/**
	 * 新增
	 * @param conn
	 */
	void saveSwitchboardConn(@Param("conn") DevExclusiveSwitchboardConn conn);
	
	
	
	/**
	 * 查询
	 * @param id
	 * @return
	 */
	List<DevExclusiveSwitchboardConn> findSwitchboardConn(@Param("id") String id);
	
}
