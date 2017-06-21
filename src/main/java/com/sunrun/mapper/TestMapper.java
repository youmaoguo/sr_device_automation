package com.sunrun.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.sunrun.entity.Test;

@Mapper
public interface TestMapper {

	List<Test> findTestIp(@Param("test") Test test);
	
	/**
	 * 回填 修改ip状态
	 * @param test
	 */
	void updateTest(@Param("test") Test test);
	
}
