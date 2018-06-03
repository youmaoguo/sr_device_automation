package com.sunrun.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface CommondMapper {
	
	
	/**
	 * 通用新增 eg：insert into table(id, name, age) values('xx1', 'jet', 24)
	 * @param table	表名
	 * @param field	新增的字段
	 * @param value	值
	 */
	void insert(@Param("table") String table, @Param("field") String field, @Param("value") String value);
	
	
	/**
	 * 通用删除 eg：delete from table where state=0
	 * @param table 	表名
	 * @param condition	条件
	 * @return 返回受影响的行数
	 */
	 void delete(@Param("table") String table, @Param("condition") String condition);
	
	
	/**
	 * 通用删除 eg：update table set name='judy',age=21 where state=0
	 * @param table 	表名
	 * @param field		更新语句
	 * @param condition	条件
	 * @return 返回受影响的行数
	 */
	void update(@Param("table") String table, @Param("field") String field, @Param("condition") String condition);

	
	/**
	 * 通用查询 eg: select id,name,age from table where state=0
	 * @param table	表
	 * @param field	查询字段
	 * @param condition	条件
	 * @return
	 */
	List<Map<String, Object>> select(@Param("table") String table, @Param("field") String field, @Param("condition") String condition);
	
	
	
}
