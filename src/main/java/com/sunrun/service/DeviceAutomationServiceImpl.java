package com.sunrun.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.sunrun.entity.DevAreaSwitchboardIp;
import com.sunrun.entity.DevBrandModel;
import com.sunrun.entity.DevExclusiveSwitchboardInfo;
import com.sunrun.entity.DevOnlineBatchItil;
import com.sunrun.entity.DevOnlineTask;
import com.sunrun.entity.DevOnlineTaskItil;
import com.sunrun.entity.DevTaskExecute;
import com.sunrun.entity.view.DevOnlineBatchTaskView;
import com.sunrun.mapper.DevAreaSwitchboardIpMapper;
import com.sunrun.mapper.DevBrandModelMapper;
import com.sunrun.mapper.DevExclusiveSwitchboardConnMapper;
import com.sunrun.mapper.DevExclusiveSwitchboardInfoMapper;
import com.sunrun.mapper.DevIosVersionsMapper;
import com.sunrun.mapper.DevOnlineBatchItilMapper;
import com.sunrun.mapper.DevOnlineTaskItilMapper;
import com.sunrun.mapper.DevOnlineTaskMapper;
import com.sunrun.mapper.DevTaskExecuteMapper;
import com.sunrun.util.ITILRestfulInterface;
import com.sunrun.util.Json;
import com.sunrun.util.RestfulRequestUtil;
import com.sunrun.util.StringUtil;

@Service("deviceAutomationService")
public class DeviceAutomationServiceImpl implements DeviceAutomationService {
	private static final Logger logger = LoggerFactory.getLogger(DeviceAutomationServiceImpl.class);
	
	@Value("${itil.user}")
	private String itilUser;
	@Value("${itil.pwd}")
	private String itilPwd;
	
	@Value("${itil.wsURL}")
	private String wsURL;
	
	@Resource
	private DevOnlineBatchItilMapper devOnlineBatchItilMapper;
	@Resource
	private DevOnlineTaskMapper devOnlineTaskMapper;
	@Resource
	private DevTaskExecuteMapper devTaskExecuteMapper;
	@Resource
	private DevOnlineTaskItilMapper devOnlineTaskItilMapper;
	@Resource
	private DevExclusiveSwitchboardConnMapper devExclusiveSwitchboardConnMapper;
	@Resource
	private DevIosVersionsMapper devIosVersionsMapper;
	@Resource
	private DevExclusiveSwitchboardInfoMapper devExclusiveSwitchboardInfoMapper;
	@Resource
	private DevBrandModelMapper devBrandModelMapper; 
	@Resource
	private DevAreaSwitchboardIpMapper devAreaSwitchboardIpMapper;
	
	@Transactional
	@Override
	public boolean saveDevice(DevOnlineTask task, Integer executeStep, String userName) {
		boolean b = true;
		try{
			if(!StringUtils.isEmpty(userName))
				task.setCreate_user(userName);
			devOnlineTaskMapper.saveDevOnlineTask(task);
			/*DevTaskExecute execute = new DevTaskExecute();
			execute.setId(StringUtil.getUuid());
			execute.setTaskId(task.getId());
			execute.setExecuteStep(executeStep);
			execute.setTaskExecuteState(3);
			execute.setTaskOrder(executeStep); 
			execute.setCreate_user(userName);
			devTaskExecuteMapper.saveDevTaskExecute(execute);*/
		}catch(Exception e){
			b = false;
			e.printStackTrace();
			logger.error("新增上线设备任务出错");
			return b;
		}
		return b;
	}


	@Transactional
	@Override
	public boolean deleteTask(String id) {
		boolean b = true;
		try{
			devOnlineTaskItilMapper.updateTaskItil(id, null, 0); 		//删除task与ITIL对应关系
			DevTaskExecute execute = new DevTaskExecute();
			execute.setTaskId(id);
			execute.setState(0);
			devTaskExecuteMapper.updateDevTaskExecute(execute);	//删除该任务在具体执行情况表中的数据
			DevOnlineTask task = new DevOnlineTask();
			task.setId(id);
			task.setState(0);
			devOnlineTaskMapper.updateDevOnlineTask(task);		//再删除任务表
		}catch(Exception e){
			b = false;
			e.printStackTrace();
			logger.error("删除具体任务出错");
			return b;
		}
		return b;
	}

	@Transactional
	@Override
	public boolean deleteExecute(String id) {
		boolean b = true;
		try{
			devTaskExecuteMapper.deleteDevTaskExecute(id, null);
		}catch(Exception e){
			e.printStackTrace();
			logger.error("删除任务执行情况出错");
			return false;
		}
		return b;
	}
	
	@Override
	public List<DevOnlineBatchTaskView> findDevBatchTask(DevOnlineBatchTaskView batchView, String like, String sortBy, String order, String limit) {
		List<DevOnlineBatchTaskView> list = null;
		try{
			list = devOnlineBatchItilMapper.findItilTask(batchView, like, sortBy, order, limit);
		}catch(Exception e){
			e.printStackTrace();
			logger.error("查询itil任务出错");
		}
		return list;
	}

	@Override
	public boolean updateBatch(DevOnlineBatchItil batch) {
		boolean b = true;
		try{
			devOnlineBatchItilMapper.updateDevOnlineBatch(batch);
		}catch(Exception e){
			b = false;
			e.printStackTrace();
			logger.error("修改批次出错了");
			return b;
		}
		return b;
	}

	@Transactional
	@Override
	public boolean updateTask(DevOnlineTask task, Integer executeStep, Object object, String userName) {
		boolean b = true;
		try{
			if(!StringUtils.isEmpty(userName))
				task.setUpdate_user(userName); 
			devOnlineTaskMapper.updateDevOnlineTask(task);
			//保存每一步步骤执行情况
			DevTaskExecute execute = new DevTaskExecute();
			execute.setId(StringUtil.getUuid());
			execute.setTaskId(task.getId());
			execute.setExecuteStep(executeStep);
			execute.setTaskExecuteState(3);
			execute.setCreate_user(userName);
			devTaskExecuteMapper.saveDevTaskExecute(execute);
		}catch(Exception e){
			b = false;
			e.printStackTrace();
			logger.error("修改批次下的任务出错了");
			return b;
		}
		return b;
	}

	@Override
	public boolean updateExecute(DevTaskExecute execute) {
		boolean b = true;
		try{
			devTaskExecuteMapper.updateDevTaskExecute(execute);
		}catch(Exception e){
			b = false;
			e.printStackTrace();
			logger.error("修改批次下的任务出错了");
		}
		return b;
	}


	@Override
	public DevOnlineBatchTaskView findTaskById(DevOnlineBatchTaskView taskView) {
		return devOnlineTaskMapper.findTaskById(taskView);
	}


	@Override
	public void saveTaskItil(String itilNumber, List<String> taskIds, String userName) {
		try{
			for(int i=0;i<taskIds.size();i++){
				DevOnlineTaskItil taskItil = new DevOnlineTaskItil();
				taskItil.setDevOnlineTaskId(taskIds.get(i));
				taskItil.setItilNumber(itilNumber);
				taskItil.setId(StringUtil.getUuid());
				taskItil.setCreate_user(userName); 
				devOnlineTaskItilMapper.saveTaskItil(taskItil);
			}
		}catch(Exception e){
			e.printStackTrace();
			logger.error("保存工单与任务的对应关系出错了");
			throw new RuntimeException(e);
		}
	}

	@Transactional
	@Override
	public void deleteTaskItil(String taskId, String itilNumber) {
		try{
			devOnlineTaskItilMapper.deleteTaskItil(taskId, itilNumber);	//删除ITIL与task对应关系
			devOnlineTaskMapper.deleteDevOnlineTask(taskId, null);		//删除任务
		}catch(Exception e){
			e.printStackTrace();
			logger.error("删除itil任务出错");
			throw new RuntimeException(e);
		}
	}


	@Transactional
	@Override
	public boolean updateTask2(DevOnlineTask task, DevTaskExecute execute, Integer executeStep, String userName) {
		boolean b = true;
		try{
			if(task!=null){
				task.setUpdate_user(userName); 
				task.setState(1);
				devOnlineTaskMapper.updateDevOnlineTask(task);
			}
			//保存每一步步骤执行情况
			if(execute!=null){
				//保存前先查询下是否有该步骤，有就重新更新state=0再插入
				List<DevTaskExecute> li = devTaskExecuteMapper.findTaskExecute(execute.getTaskId(), executeStep, null);
				if(li!=null && li.size()>0){
					DevTaskExecute e = new DevTaskExecute();
					e.setExecuteStep(executeStep);
					e.setTaskId(execute.getTaskId());
					e.setState(0);
					e.setUpdate_user(userName);
					devTaskExecuteMapper.updateDevTaskExecute(e);
				}
				execute.setCreate_user(userName); 
				devTaskExecuteMapper.saveDevTaskExecute(execute);
			}
		}catch(Exception e){
			e.printStackTrace();
			logger.error("修改批次下的任务出错了");
			return false;
		}
		return b;
	}
 
	/*@Transactional
	@Override
	public boolean switchDeviceITIL(String itil, String itilPlannedEnd, String updateUser, String[] taskId, String usercode) {
		boolean b = true;
		try{
			JSONObject paramterObj = new JSONObject();
			paramterObj.put("assignee", "01091231");
			paramterObj.put("title", "测试门户系统上线交换机申请itil工单");
			paramterObj.put("category", "流程管理");
			paramterObj.put("subcategory", "ITIL系统");
			paramterObj.put("businessArea", "其他");
			paramterObj.put("requestor", "01091231");
			paramterObj.put("description", "测试门户系统请求新建接口genrequests");
			paramterObj.put("sourceId", "portal");
			
			SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			Date d = f.parse(itilPlannedEnd);
			SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
			String sr = fmt.format(d);
			paramterObj.put("plannedEnd", sr);
			String sb = ITILRestfulInterface.createITIL(itil, paramterObj, "POST", StringUtil.basic64Encord(itilUser, itilPwd));
			System.out.println(sb.toString());
			Json j = JSONObject.parseObject(sb.toString(), Json.class);
			if(j.getRet_code()!=200 || j.getSuccess()==false){
				b = false;
			}else{
				ItilGenrequestBo bo = JSONObject.parseObject(j.getData().toString(), ItilGenrequestBo.class);
				DevOnlineBatchItil it = new DevOnlineBatchItil();
				it.setItilNumber(!StringUtils.isEmpty(bo.getNumber()) ? bo.getNumber() : null);
				it.setItilAssignee(!StringUtils.isEmpty(bo.getAssignee()) ? bo.getAssignee() : null);
				it.setItilCategory(!StringUtils.isEmpty(bo.getCategory()) ? bo.getCategory() : null);
				it.setItilSubcategory(!StringUtil.isInteger(bo.getSubcategory()) ? bo.getSubcategory() : null);
				it.setItilBusinessArea(!StringUtils.isEmpty(bo.getBusinessArea()) ? bo.getBusinessArea() : null);
				it.setItilStatus(!StringUtils.isEmpty(bo.getStatus()) ? bo.getStatus() : null);
				it.setItilRequestor(!StringUtils.isEmpty(bo.getRequestor()) ? bo.getRequestor() : null);
				it.setItilTitle(!StringUtils.isEmpty(bo.getTitle()) ? bo.getTitle() : null);
				it.setItilDescription(!StringUtils.isEmpty(bo.getDescription()) ? Arrays.toString(bo.getDescription()) : null);
				it.setItilPlannedEnd(!StringUtils.isEmpty(bo.getPlannedEnd()) ? bo.getPlannedEnd() : null);
				it.setId(StringUtil.getUuid());
				it.setCreate_user(updateUser);
				//往工单批次表插入数据
				devOnlineBatchItilMapper.saveDevOnlineBatch(it); 
				
				//往工单和任务对应关系表插入数据
				for(int i=0;i<taskId.length;i++){
					DevOnlineTaskItil taskItil = new DevOnlineTaskItil();
					taskItil.setId(StringUtil.getUuid());
					taskItil.setDevOnlineTaskId(taskId[i]);
					taskItil.setItilNumber(bo.getNumber());
					taskItil.setCreate_user(updateUser);
					devOnlineTaskItilMapper.saveTaskItil(taskItil);
				}
				
			}
		}catch(Exception e){
			e.printStackTrace();
			logger.error("申请ITIL工单处理业务出错");
			return false;
		}
		return b;
	}*/
	
	@Transactional
	@Override
	public boolean switchDeviceITIL(String itil, String itilPlannedEnd, String updateUser, String[] taskId, String usercode) {
		boolean b = true;
		try{
			String description = concatDeviceItilInfo(taskId);
			String sb = ITILRestfulInterface.createChangeITIL(wsURL, usercode,  itilUser, itilPwd, itilPlannedEnd, description);
			Json j = JSONObject.parseObject(sb, Json.class);
			if(j.getRet_code()!=201 || j.getSuccess()==false){
				b = false;
			}else{
				JSONObject bo = JSONObject.parseObject(j.getData().toString());
				DevOnlineBatchItil it = new DevOnlineBatchItil();
				it.setItilNumber(!StringUtils.isEmpty(bo.getString("changeNumber")) ? bo.getString("changeNumber") : null);
				//it.setItilAssignee(!StringUtils.isEmpty(bo.getString("requestedBy")) ? bo.getString("requestedBy") : null);
				it.setItilRequestor(!StringUtils.isEmpty(bo.getString("requestedBy")) ? bo.getString("requestedBy") : null);
				it.setItilStatus(!StringUtils.isEmpty(bo.getString("cMBStatus")) ? bo.getString("cMBStatus") : null);
				it.setItilPlannedEnd(!StringUtils.isEmpty(bo.getString("plannedEndDate")) ? bo.getString("plannedEndDate") : null);
				it.setId(StringUtil.getUuid());
				it.setCreate_user(updateUser);
				//往工单批次表插入数据
				devOnlineBatchItilMapper.saveDevOnlineBatch(it); 
				
				//往工单和任务对应关系表插入数据
				for(int i=0;i<taskId.length;i++){
					DevOnlineTaskItil taskItil = new DevOnlineTaskItil();
					taskItil.setId(StringUtil.getUuid());
					taskItil.setDevOnlineTaskId(taskId[i]);
					taskItil.setItilNumber(bo.getString("changeNumber"));
					taskItil.setCreate_user(updateUser);
					devOnlineTaskItilMapper.saveTaskItil(taskItil);
				}
				
			}
		}catch(Exception e){
			e.printStackTrace();
			logger.error("申请ITIL变更工单处理业务出错");
			return false;
		}
		return b;
	}


	@Override
	public List<DevOnlineTask> findPort(String taskId) {
		return devOnlineTaskMapper.findPort(taskId);
	}


	@Override
	public List<DevTaskExecute> findTaskExecute(String taskId, String order) {
		return devTaskExecuteMapper.findTaskExecute(taskId, null, order);
	}


	@Override
	public Json findKvmInfo(DevExclusiveSwitchboardInfo info, String thirdPartUrl, String auth) {
		Json j = new Json();
		String s = "获取kvm接口所对应的设备型号信息成功";
		Integer code = 200;	//200:用户查询数据成功
		Boolean success = true;
		List<Object> li = new ArrayList<Object>();
		try{
			//先查询出带外交换机的ip和端口
			List<DevExclusiveSwitchboardInfo> list = devExclusiveSwitchboardInfoMapper.findDevExclusiveSwitchboardInfo(info);
			for(int i=0;i<list.size();i++){
				DevExclusiveSwitchboardInfo d = list.get(i);
				JSONObject param = new JSONObject();
				param.put("method_name", "/interchanger/v1/checkModel");
				param.put("host", d.getExclusiveSwitchboardIp());
				param.put("port", d.getExclusiveSwitchboardPort());
				param.put("user", d.getTelnetUser()!=null ?d.getTelnetUser() : null);
				param.put("password", d.getTelnetPwd()!=null ? d.getTelnetPwd() : null);
				String sb = RestfulRequestUtil.getResponse(thirdPartUrl, param, "post", auth);
				Json json = JSONObject.parseObject(sb, Json.class);
				if(json.getRet_code()==200){
					
					JSONObject oo = JSONObject.parseObject(json.getData().toString());
					String model = oo.get("model").toString();
					com.alibaba.fastjson.JSONArray iosList = (com.alibaba.fastjson.JSONArray) oo.get("iosList");
					String ios = "";
					for(int z=0;z<iosList.size();z++){
						ios += iosList.get(z).toString() + ",";
					}
					//在根据model去查询品牌型号表
					DevBrandModel bean = new DevBrandModel();
					bean.setModelName(model);
					List<DevBrandModel> ll = devBrandModelMapper.findBrandModel(bean);
					if(ll!=null && ll.size()>0){
						bean = ll.get(0);
					}
					JSONObject obj = new JSONObject();
					obj.put("exclusiveSwitchboardIp", d.getExclusiveSwitchboardIp());
					obj.put("exclusiveSwitchboardPort", d.getExclusiveSwitchboardPort());
					obj.put("exclusiveSwitchboardOrder", d.getExclusiveSwitchboardOrder());
					obj.put("brandName", bean.getBrandName());
					obj.put("modelName", bean.getModelName());
					obj.put("currentIosVersion", ios.substring(0, ios.length()-1));
					li.add(obj);
				}/*else{
					code = json.getRet_code();
					success = json.getSuccess();
					s = json.getRet_info();
				}*/
			}
			
		}catch(Exception e){
			logger.error("kvm接口所对应的设备型号信息接口出错");
			e.printStackTrace();
			j.setRet_code(500);
			j.setRet_info("kvm接口所对应的设备型号信息接口出错");
			j.setSuccess(false);
			return j;
		}
		j.setRet_code(code);
		j.setRet_info(s);
		j.setSuccess(success);
		j.setData(li); 
		return j;
	}


	@Override
	public List<DevAreaSwitchboardIp> findAreaIp(DevAreaSwitchboardIp info) {
		return devAreaSwitchboardIpMapper.findAreaIp(info);
	}


	@Override
	public List<DevExclusiveSwitchboardInfo> findDevExclusiveSwitchboardInfo(DevExclusiveSwitchboardInfo info) {
		return devExclusiveSwitchboardInfoMapper.findDevExclusiveSwitchboardInfo(info);
	}


	@Override
	public String concatDeviceInfo(String[] ids) {
		String content = StringUtil.emailHeadStr();
		for(int i=0;i<ids.length;i++){
			List<DevOnlineTask> view = findPort(ids[i]);
			if(view!=null && view.size()>0){
				DevOnlineTask task = view.get(0);
				content += "<tr height='80' style='mso-height-source:userset;height:25.0pt'>";
				content += "<td height='80' class='xl66' width='85' style='border:1px solid #ededed;height:25.0pt;border-top:none;width:64pt'>"+task.getBrandName()+"</td>";
				content += "<td class='xl66' width='72' style='border:1px solid #ededed;width:54pt'>"+task.getModelName()+"</td>";
				content += "<td class='xl66' width='125' style='border:1px solid #ededed;width:94pt'>"+task.getAreaName()+"</td>";
				content += "<td class='xl69' width='165' style='border:1px solid #ededed;width:124pt'>"+task.getMainSwitchboardIp()+"<font class='font7'>:"+task.getMainSwitchboardPort()+"</font></td>";
				content += "<td class='xl67' width='165' style='border:1px solid #ededed;width:124pt'>"+task.getBackupSwitchboardIp()+"<font class='font7'>:"+task.getBackupSwitchboardPort()+"</font></td>";
				content += "<td class='xl68' width='165' style='border:1px solid #ededed;width:124pt'><font class='font6'>"+task.getDevOnlineRack()+"</font></td>";
				content += "<td class='xl66' width='244' style='border:1px solid #ededed;width:183pt'>"+task.getHostName()+"</td>";
				content += "<td class='xl66' width='165' style='border:1px solid #ededed;width:124pt'>"+task.getManagerIp()+"</td>";
				content += "<td class='xl66' width='238' style='border:1px solid #ededed;width:179pt'>"+task.getExclusiveSwitchboardInfo()+"</td></tr>";
			}
		}
		content += "</tbody></table></div><div><includetail><!--<![endif]--></includetail></div>";
		return content;
	}
	
	@Override
	public String concatDeviceItilInfo(String[] ids){
		String s = "共"+ids.length+"条设备上线信息:\n";
		for(int i=0;i<ids.length;i++){
			List<DevOnlineTask> view = findPort(ids[i]);
			if(view!=null && view.size()>0){
				DevOnlineTask task = view.get(0);
				s += (i+1) + "、设备品牌:"+task.getBrandName() + ",型号:"+task.getModelName()+",区域:"+task.getAreaName()+
						",主汇聚交机:"+task.getMainSwitchboardIp()+",主汇聚交机端口:"+task.getMainSwitchboardPort()+
						",备汇聚交机:"+task.getBackupSwitchboardIp()+",备汇聚交机端口:"+task.getBackupSwitchboardPort()+
						",上线机架位置:"+task.getDevOnlineRack()+",hostname:"+task.getHostName()+
						",管理口ip:"+task.getManagerIp()+",带外交机信息:"+task.getExclusiveSwitchboardInfo()+"。\n";
			}
		}
		return s;
	}


	@Override
	public List<DevOnlineBatchItil> findItilStatus() {
		return devOnlineBatchItilMapper.findItilStatus();
	}


	@Override
	public List<DevOnlineTask> findTask(DevOnlineTask task) {
		return devOnlineTaskMapper.findTask(task);
	}


	@Override
	public List<DevOnlineTask> findTaskByTime() {
		return devOnlineTaskMapper.findTaskByTime();
	}
	

}
