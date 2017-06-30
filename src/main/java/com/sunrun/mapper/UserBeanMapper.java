package com.sunrun.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.sunrun.entity.UserBean;

@Mapper
public interface UserBeanMapper {

	List<UserBean> findUser(@Param("user") UserBean user);
	
	
	
}
