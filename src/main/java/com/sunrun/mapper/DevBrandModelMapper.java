package com.sunrun.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.sunrun.entity.DevBrandModel;

/**
 * 设备品牌型号对应
 * @author ymg
 *
 */

@Mapper
public interface DevBrandModelMapper {
	
	/**
	 * 新增
	 * @param version
	 */
	void saveDevBrandModel(@Param("model") DevBrandModel model);

	/**
	 * 查询
	 * @param version
	 * @return
	 */
	List<DevBrandModel> findBrandModel(@Param("model") DevBrandModel model);
	
}
