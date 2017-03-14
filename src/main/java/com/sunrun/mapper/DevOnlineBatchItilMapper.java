package com.sunrun.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.sunrun.entity.DevOnlineBatchItil;
import com.sunrun.entity.view.DevOnlineBatchTaskView;

/**
 * 设备上线批次（表名：dev_online_batch）mapper接口
 * @author ymg
 *
 */
@Mapper
public interface DevOnlineBatchItilMapper {
	
	/**
	 * 新增设备上线批次记录
	 * @param batch
	 * @return
	 */
	Integer saveDevOnlineBatch(@Param("itil") DevOnlineBatchItil itil);
	
	/**
	 * 修改设备上线批次记录
	 * @param batch
	 * @return
	 */
	Integer updateDevOnlineBatch(@Param("itil") DevOnlineBatchItil itil);
	
	/**
	 * 删除该设备上线批次记录
	 * @param id	批次id
	 * @return
	 */
	Integer deleteDevOnlineBatch(@Param("id") String id);
	
	/**
	 * 根据批次号id查询
	 * @param id	批次号id
	 * @return
	 */
	DevOnlineBatchItil findBatchById(@Param("id") String id);
	
	/**
	 * 查询某一批次下所有的任务和任务执行情况（三表联合查询）
	 * @param taskView	批次、任务、执行情况的javaBean
	 * @param like		模糊查询值/搜索值
	 * @param sortBy	排序值（根据哪个属性排序）
	 * @param order		排序方式（desc,asc）
	 * @param limit		分页条件
	 * @return
	 */
	List<DevOnlineBatchTaskView> findItilTask(@Param("taskView") DevOnlineBatchTaskView taskView,
			@Param("like") String like, @Param("sortBy") String sortBy, @Param("order") String order, @Param("limit") String limit);
	
	/**
	 * 统计某一批次下所有的任务和任务执行情况条数（三表联合查询）
	 * @param taskView	批次、任务、执行情况的javaBean
	 * @param like		模糊查询值/搜索值
	 * @param sortBy	排序值（根据哪个属性排序）
	 * @param order		排序方式（desc,asc）
	 * @param limit		分页条件
	 * @return
	 */
	Integer countItilTask(@Param("taskView") DevOnlineBatchTaskView taskView,
			@Param("like") String like, @Param("sortBy") String sortBy, @Param("order") String order, @Param("limit") String limit);

}
