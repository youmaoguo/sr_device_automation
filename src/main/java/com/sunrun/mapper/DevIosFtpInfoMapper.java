package com.sunrun.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.sunrun.entity.DevIosFtpInfo;


@Mapper
public interface DevIosFtpInfoMapper {
	
	
	/**
	 * 查询
	 * @param version
	 * @return
	 */
	List<DevIosFtpInfo> findIosFtpInfo(@Param("version") DevIosFtpInfo version);
	
}
