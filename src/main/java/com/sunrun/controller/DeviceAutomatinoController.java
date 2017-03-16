package com.sunrun.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.sunrun.entity.DevOnlineTask;
import com.sunrun.entity.view.DevOnlineBatchTaskView;
import com.sunrun.service.DeviceAutomationService;
import com.sunrun.util.Json;
import com.sunrun.util.StringUtil;

/**
 * 交换机自动化控制器层
 * @author ymg
 *
 */
@RestController
public class DeviceAutomatinoController extends BaseController{
	private static final Logger logger = LoggerFactory.getLogger(DeviceAutomatinoController.class);
	
	@Resource
	private DeviceAutomationService deviceAutomationService;
	
	/**
	 * 查询批次任务
	 * @param request		
	 * @param batchId		批次ID(可选参数，暂时没用到)
	 * @param batchState	批次状态（1或者2：未完成；3：已经完成。可选参数，不传递就是查询所有状态的，传递了就是查询具体状态的）
	 * @param id			任务id,(参数可选)
	 * @param executeStep	任务步骤（参数可选）
	 * 
	 * 类似下面几个参数基本上用不到了（现在和前端默认是不带分页，把所有数据返回）
	 * @param like			模糊查询值/搜索值
	 * @param sortBy		排序值（根据哪个属性排序）
	 * @param order			排序方式（desc,asc）
	 * @param currentPage	当前第几页
	 * @param pageSize		每页记录数
	 * @return				返回json字符串
	 */
	@RequestMapping(value = "/deviceAutomation/v1/findDevBatchTask", method = RequestMethod.GET, produces="application/json")
	public void findDevBatchTask(HttpServletRequest request, HttpServletResponse response,
								@RequestParam(value = "id", required = false) String taskId,
								@RequestParam(value = "executeStep", required = false) Integer executeStep,
								@RequestParam(value = "batchState", required = false) Integer batchState,
								@RequestParam(value = "batchId", required = false) String batchId,
								@RequestParam(value = "like", required = false) String like, 
								@RequestParam(value = "sortBy", required = false) String sortBy, 
								@RequestParam(value = "order", required = false) String order, 
								@RequestParam(value = "currentPage", required = false, defaultValue = "0") Integer currentPage,
								@RequestParam(value = "pageSize", required = false, defaultValue = "0") Integer pageSize){
		Json json = new Json();
		String info = "查询批次任务交换机设备成功";
		Integer code = 200;	//200:用户查询数据成功
		Boolean success = true;
		System.out.println("========"+ request.getQueryString());
		try{
			DevOnlineBatchTaskView batchView = new DevOnlineBatchTaskView();
			if(batchId!=null && !"".equals(batchId)){
				batchView.setId(batchId);
			}
			if(batchState!=null){
				batchView.setBatchState(batchState); 
			}
			if(taskId!=null && !"".equals(taskId) && executeStep!=null){
				batchView.setTaskId(taskId);
				batchView.setExecuteStep(executeStep); 
			}
			List<DevOnlineBatchTaskView> list = deviceAutomationService.findDevBatchTask(batchView, like, sortBy, order, page(currentPage, pageSize));
			Map<Object, Object> collect = new HashMap<Object, Object>();
			collect.put("total", (list!=null && list.size()>0) ? list.size() : 0);
			collect.put("pagesize", setPageSize(currentPage, pageSize, list));
			json.setCollect(collect);
			json.setData(list);
			
		}catch(Exception e){
			e.printStackTrace();
			info = "查询批次任务交换机设备出错";
			code = 500;
			success = false;
			logger.error(info);
		}
		json.setRet_code(code);
		json.setRet_info(info);
		json.setSuccess(success);
		//返回数据
		/*if(isCrossDomain(request))
			return returnJsonP(json);
		else
			return returnJson(json);*/
		response(json, response, request);
	}
	
	/**
	 * 添加交换机设备(页面每个‘下一步’调用的方法)
	 * @param jsonStr	json格式的请求参数字符串
	 * @param auth		Authorization认证参数
	 * @param request	request请求对象
	 * @return			返回json格式的字符串
	 */
	@RequestMapping(value = "/deviceAutomation/v1/editDevice", method = RequestMethod.POST, produces="application/json", consumes="application/json", headers={"Authorization=sys/sysPwd/user/userPwd"})
	public void editDevice(@RequestBody String jsonStr, @RequestHeader("Authorization") String auth, HttpServletRequest request, HttpServletResponse response){
		Json json = new Json();
		String info = "编辑交换机设备成功";
		Integer code = 201;	//201:用户新建或修改数据成功
		Boolean success = true;
		try{
			JSONObject obj = JSONObject.parseObject(jsonStr);
			String id = obj.getString("id");	//taskId 任务id
			Integer executeStep = obj.getIntValue("executeStep");//任务步骤
			
			String brandName = obj.getString("brandName");
			String modelName = obj.getString("modelName");
			String areaName = obj.getString("areaName");
			String devOnlineRack = obj.getString("devOnlineRack");
			String hostName = obj.getString("hostName");
			DevOnlineTask task = new DevOnlineTask();
			task.setBrandName(brandName);
			task.setModelName(modelName);
			task.setAreaName(areaName);
			task.setDevOnlineRack(devOnlineRack);
			task.setHostName(hostName);
			
			String managerIp = obj.getString("managerIp");
			String mainSwitchboardIp = obj.getString("mainSwitchboardIp");
			String mainSwitchboardPort = obj.getString("mainSwitchboardPort");
			String backupSwitchboardIp = obj.getString("backupSwitchboardIp");
			String backupSwitchboardPort = obj.getString("backupSwitchboardPort");
			String exclusiveSwitchboardIp = obj.getString("exclusiveSwitchboardIp");
			String exclusiveSwitchboardPort = obj.getString("exclusiveSwitchboardPort");
			task.setManagerIp(managerIp);
			task.setMainSwitchboardIp(mainSwitchboardIp);
			task.setMainSwitchboardPort(mainSwitchboardPort);
			task.setBackupSwitchboardIp(backupSwitchboardIp);
			task.setBackupSwitchboardPort(backupSwitchboardPort);
			task.setExclusiveSwitchboardIp(exclusiveSwitchboardIp);
			task.setExclusiveSwitchboardPort(exclusiveSwitchboardPort);
			
			String d = null;
			if(StringUtils.isEmpty(id)){
				String uuid = StringUtil.getUuid();
				d = uuid;
				task.setId(uuid);
				deviceAutomationService.saveDevice(task, executeStep); 
			}else{
				d = id;
				task.setId(id);
				deviceAutomationService.updateTask(task, executeStep);
			}
			
			//编辑完之后还要把这条信息返回给前端
			//DevOnlineTask data = deviceAutomationService.findTaskById(d);
			json.setData(d);
			
		}catch(Exception e){
			e.printStackTrace();
			info = "编辑批次任务交换机设备出错了";
			code = 500;
			success = false;
			logger.error(info);
		}
		json.setRet_code(code);
		json.setRet_info(info);
		json.setSuccess(success);
		//返回数据
		response(json, response, request);
	}
	
	/**
	 * 删除交换机设备
	 * @param jsonStr	json格式的请求参数字符串
	 * @param auth		Authorization认证参数
	 * @param request	request请求对象
	 * @return			返回json格式的字符串
	 */
	@RequestMapping(value = "/deviceAutomation/v1/deleteDevice", method = {RequestMethod.POST, RequestMethod.DELETE}, produces="application/json", consumes="application/json", headers={"Authorization=sys/sysPwd/user/userPwd"})
	public void deleteDevice(@RequestBody String jsonStr, @RequestHeader("Authorization") String auth, HttpServletRequest request,HttpServletResponse response){
		Json json = new Json();
		String info = "删除成功";
		Integer code = 201;	//201:用户新建或修改数据成功
		Boolean success = true;
		try{
			JSONObject obj = new JSONObject();
			String itilNumber = obj.getString("itilNumber");//itil批次Id
			String taskId = obj.getString("taskId");		//任务Id
			String executeId = obj.getString("executeId");	//执行情况Id
			
			//删除itil批次
			if(!StringUtils.isEmpty(itilNumber) && !StringUtils.isEmpty(taskId))
				deviceAutomationService.deleteTaskItil(itilNumber, taskId);
			
			//删除任务
			if(!StringUtils.isEmpty(taskId) && StringUtils.isEmpty(itilNumber) && StringUtils.isEmpty(executeId))
				deviceAutomationService.deleteTask(taskId);
			
			//删除执行情况
			if(!StringUtils.isEmpty(executeId) && StringUtils.isEmpty(taskId) && StringUtils.isEmpty(itilNumber))
				deviceAutomationService.deleteExecute(executeId);
				
			
		}catch(Exception e){
			code = 500;
			success = false;
			logger.error("删除出错");
			e.printStackTrace();
		}
		json.setRet_code(code);
		json.setRet_info(info);
		json.setSuccess(success);
		//返回数据
		response(json, response, request); 
	}
	
	
	

}
