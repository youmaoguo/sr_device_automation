package com.sunrun.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * 交换机自动化控制器层
 * @author ymg
 *
 */
@RestController
public class DeviceAutomatinoController extends BaseController{
	private static final Logger logger = LoggerFactory.getLogger(DeviceAutomatinoController.class);
	
	
	/**
	 * 添加上线交换机设备
	 * @param jsonStr	json格式的请求参数字符串
	 * @param auth		Authorization认证参数
	 * @param response	response响应对象
	 * @param request	request请求对象
	 * @return			返回json格式的字符串
	 */
	@RequestMapping(value = "/deviceAutomation/v1/addSwitchDevice", method = RequestMethod.POST, produces="application/json", consumes="application/json")
	public void addSwitchDevice(HttpServletRequest request, HttpServletResponse response,
								@RequestBody String jsonStr, @RequestHeader("Authorization") String auth){ 
		
	} 
	
	
	
	/**
	 * 查询批次任务
	 * @param request		
	 * @param batchId		批次ID(可选参数，暂时没用到)
	 * @param batchState	批次状态（1或者2：未完成；3：已经完成。可选参数，不传递就是查询所有状态的，传递了就是查询具体状态的）
	 * @param switchState	设备添加状态 1：设备准备；2：汇聚设备配制；3：异常工单;4:成功工单 
	 * @param taskId		任务id,(参数可选)
	 * @param executeStep	任务步骤（参数可选.如要查询itil任务列表，则必须传入此参数值为：0）
	 * 
	 * 类似下面几个参数基本上用不到了（现在和前端默认是不带分页，把所有数据返回）
	 * @param like			模糊查询值/搜索值
	 * @param sortBy		排序值（根据哪个属性排序）
	 * @param order			排序方式（desc,asc）
	 * @param currentPage	当前第几页
	 * @param pageSize		每页记录数
	 * @return				返回json字符串
	 */
	@RequestMapping(value = "/deviceAutomation/v1/findSwitchDevice", method = RequestMethod.GET, produces="application/json")
	public void findSwitchDevice(HttpServletRequest request, HttpServletResponse response,
								@RequestParam(value = "taskId", required = false) String taskId,
								@RequestParam(value = "like", required = false) String like, 
								@RequestParam(value = "sortBy", required = false) String sortBy, 
								@RequestParam(value = "order", required = false) String order, 
								@RequestParam(value = "currentPage", required = false, defaultValue = "0") Integer currentPage,
								@RequestParam(value = "pageSize", required = false, defaultValue = "0") Integer pageSize){
		
	}
	 
	

}
