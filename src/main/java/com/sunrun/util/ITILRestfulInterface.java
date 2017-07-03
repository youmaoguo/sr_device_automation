package com.sunrun.util;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.xml.rpc.ServiceException;

import org.json.JSONArray;
import org.json.JSONException;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.peregrine.servicecenter.PWS.CMBChangeInstanceType;
import com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeClose;
import com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeCmbService;
import com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeCmbServiceHowlong;
import com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeCmbServiceImpact;
import com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeCmbServiceIsdown;
import com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeDescriptionStructure;
import com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeDescriptionStructureDescription;
import com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeHeader;
import com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeMiddle;
import com.peregrine.servicecenter.PWS.CMBChangeInstanceTypeMiddleChangePlan;
import com.peregrine.servicecenter.PWS.CMBChangeKeysType;
import com.peregrine.servicecenter.PWS.CMBChangeModelType;
import com.peregrine.servicecenter.PWS.CMBChange_PortType;
import com.peregrine.servicecenter.PWS.CMBChange_Service;
import com.peregrine.servicecenter.PWS.CMBChange_ServiceLocator;
import com.peregrine.servicecenter.PWS.CreateCMBChangeRequest;
import com.peregrine.servicecenter.PWS.CreateCMBChangeResponse;
import com.peregrine.servicecenter.PWS.Common.BooleanType;
import com.peregrine.servicecenter.PWS.Common.DateTimeType;
import com.peregrine.servicecenter.PWS.Common.DecimalType;
import com.peregrine.servicecenter.PWS.Common.MessageType;
import com.peregrine.servicecenter.PWS.Common.StringType;

/**
 * 请求itil方法
 * @author ymg
 *
 */
public class ITILRestfulInterface {

	
	/**
	 * 创建ITIL工单
	 * @param requestUrl	路径
	 * @param paramterObj	参数对象
	 * @param requestMethod	请求方式
	 * @param authorization	头部验证
	 * @return	
	 */
	public static String createITIL(String requestUrl, Object paramterObj, String requestMethod, String authorization) throws Exception{
		Json json = new Json();
		JSONObject param = new JSONObject();
		param.put("GenRequest", paramterObj);
		String sb = RestfulRequestUtil.getResponse(requestUrl, param, requestMethod, authorization);
		ItilJsonUtil itil = JSON.parseObject(sb, ItilJsonUtil.class);
		if(StringUtils.isEmpty(sb) || itil==null){
			json.setRet_code(400);
			json.setRet_info("itil返回空信息");
			json.setSuccess(false);
			return JSONObject.toJSONString(json);
		}
		if(itil.getReturnCode()==0 && itil.getGenRequest()!=null){
			json.setSuccess(true);
			json.setRet_code(200);
			json.setRet_info("工单创建成功");
			json.setData(itil.getGenRequest());
		}else{
			json.setSuccess(false);
			json.setRet_code(500);
			json.setRet_info("工单创建失败");
			json.setData(null);
		}
		return JSONObject.toJSONString(json);
	}
	
	/**
	 * 根据工单number号查询ITIL工单具体信息
	 * @param requestUrl	路径
	 * @param paramterObj	参数对象
	 * @param requestMethod	请求方式
	 * @param authorization	头部验证
	 * @return
	 */
	public static String queryITILByNumber(String requestUrl, Object paramterObj, String requestMethod, String authorization) throws Exception{
		Json json = new Json();
		String sb = RestfulRequestUtil.getResponse(requestUrl, paramterObj, requestMethod, authorization);
		org.json.JSONObject obj = new org.json.JSONObject(sb);
		Integer code = (Integer) obj.get("ReturnCode");
		JSONArray array = obj.getJSONArray("content");
		if(code!=0 && !StringUtils.isEmpty(array) && array.length()>0){
			List<ItilGenrequestBo> list = new ArrayList<ItilGenrequestBo>();
			for(int i=0;i<array.length();i++){
				org.json.JSONObject o = (org.json.JSONObject) array.get(i);	//获取对象
				org.json.JSONObject a =  (org.json.JSONObject) o.get("GenRequest");
				ItilGenrequestBo bo = JSONObject.parseObject(a.toString(), ItilGenrequestBo.class);
				list.add(bo);
			}
			json.setSuccess(true);
			json.setRet_code(200);
			json.setRet_info("查询工单成功");
			json.setData(list);
		}else{
			json.setSuccess(false);
			json.setRet_code(500);
			json.setRet_info("查询工单失败");
			json.setData(null);
		}
		return JSONObject.toJSONString(json);
	}
	
	/**
	 * 创建变更itil工单
	 * @param wsURL				webservice的请求地址
	 * @param usercode			员工编号：01091231
	 * @param wsUser			用户名
	 * @param wsPwd				用户密码
	 * @param itilPlannedEnd	期望完成时间
	 * @param itilPlannedStart	期望开始时间
	 * @param description		描述内容
	 * @param area				区域
	 * @return
	 * @throws Exception
	 */
	public static String createChangeITIL(String wsURL, String usercode, String userName, String wsUser, String wsPwd, String itilPlannedEnd, String itilPlannedStart, String description, String area) throws Exception{
		Json json = new Json();
		//String wsURL = "http://10.1.248.21:13081/sc62server/PWS/CMBChange";
		//String wsUser = "01091231";
		//String wsPwd = "";
		CMBChange_Service service = new CMBChange_ServiceLocator() ;
		try {
			CMBChange_PortType stub = (CMBChange_PortType)service.getCMBChange(new URL(wsURL), wsUser, wsPwd);
			CreateCMBChangeRequest req = new CreateCMBChangeRequest();
			req.setIgnoreEmptyElements(true);
			req.setUpdateconstraint(-1l);
			CMBChangeModelType model = new CMBChangeModelType();
			
			model.setKeys(new CMBChangeKeysType());
			model.setMessages(new MessageType[] {});
			
			CMBChangeInstanceType instance = new CMBChangeInstanceType();
			CMBChangeInstanceTypeHeader header = new CMBChangeInstanceTypeHeader();
			SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
			Date ds = f.parse(itilPlannedEnd);
			Calendar calendar1 = Calendar.getInstance();
	        calendar1.setTime(ds);
	        calendar1.add(Calendar.HOUR_OF_DAY, -8);//由于itil数据库时间比正常时间提前了8小时，所以这里减去8
	        Date d1 = calendar1.getTime();
	        String start = fmt.format(d1);
			header.setPlannedStartDate(new DateTimeType(start));
			Calendar calendar = Calendar.getInstance();
	        calendar.setTime(ds);
	        calendar.add(Calendar.HOUR_OF_DAY, +4);//+4hour
	        Date d = calendar.getTime();
	        String end = fmt.format(d);
			header.setPlannedEndDate(new DateTimeType(end));
			
			/*Date ds = f.parse(itilPlannedStart);
			Calendar calendar1 = Calendar.getInstance();
	        calendar1.setTime(ds);
	        calendar1.add(Calendar.HOUR_OF_DAY, -8);//由于itil数据库时间比正常时间提前了8小时，所以这里减去8
	        Date d1 = calendar1.getTime();
			String start1 = fmt.format(d1);
			header.setPlannedStartDate(new DateTimeType(start1));
			if(StringUtils.isEmpty(itilPlannedEnd)){
				Calendar calendar = Calendar.getInstance();
		        calendar.setTime(ds);
		        calendar.add(Calendar.HOUR_OF_DAY, +4);//+4hour
		        Date d = calendar.getTime();
		        String end = fmt.format(d);
				header.setPlannedEndDate(new DateTimeType(end));
			}else{
				Date d2 = f.parse(itilPlannedEnd);
				Calendar calendar2 = Calendar.getInstance();
		        calendar2.setTime(d2);
		        calendar2.add(Calendar.HOUR_OF_DAY, -8);//由于itil数据库时间比正常时间提前了8小时，所以这里减去8
		        d2 = calendar2.getTime();
				String end2 = fmt.format(d2);
				header.setPlannedStartDate(new DateTimeType(end2));
			}*/
			
			header.setBriefDescription(new StringType("申请"+area+"区接入交换机上线"));
			header.setRequestedBy(new StringType(usercode));
			instance.setHeader(header);
			
			CMBChangeInstanceTypeDescriptionStructure descriptionStructure = new CMBChangeInstanceTypeDescriptionStructure();
			StringType[] des = new StringType[] {new StringType(description)};
			descriptionStructure.setDescription(new CMBChangeInstanceTypeDescriptionStructureDescription("申请"+area+"区接入交换机上线",des));
			instance.setDescriptionStructure(descriptionStructure);
			
			CMBChangeInstanceTypeMiddle middle = new CMBChangeInstanceTypeMiddle();
			middle.setCm3RSource(new StringType("其他"));
			middle.setCmbDR(new BooleanType(true));
			middle.setBusinessSYS(new StringType("网络"));
			middle.setBusinesssubSYS(new StringType("业务网"));
			middle.setBusinessCategory(new StringType("业务网非核心网络新增或减少设备"));
			
			String plan = "1.变更方案说明\n";
			plan += "确定接入交换机上线机架位置及区域\n";
			plan += "准备接入交换机和汇聚交换机配置\n";
			plan += "写入接入交换机配置并进行跳线连接到汇聚交换机\n";
			plan += "写入汇聚交换机配置\n";
			plan += "技术验证设备配置是否符合要求\n\n";
			plan += "2.变更失败后果及规避措施\n";
			plan += "新设备上线不会影响到原有配置，若变更失败进行回退\n\n";
			plan += "3.回退方案\n";
			plan += "断开接入交换机与汇聚交换机连线\n";
			plan += "删除汇聚交换机接口配置并shutdown接口\n";
			CMBChangeInstanceTypeMiddleChangePlan changePlan = new CMBChangeInstanceTypeMiddleChangePlan();
			changePlan.setChangePlan(new StringType[] {new StringType(plan)});
			middle.setChangePlan(changePlan);
			instance.setMiddle(middle);
			
			instance.setCMBPlanImple(new StringType(usercode));
			instance.setCmbplanimplefullname(new StringType(userName));
			
			CMBChangeInstanceTypeCmbService cmbService = new CMBChangeInstanceTypeCmbService();
			CMBChangeInstanceTypeCmbServiceImpact impact = new CMBChangeInstanceTypeCmbServiceImpact();
			impact.setImpact(new StringType[] {new StringType("普通")});
			cmbService.setImpact(impact);
			
			CMBChangeInstanceTypeCmbServiceHowlong howlong = new CMBChangeInstanceTypeCmbServiceHowlong();
			howlong.setHowlong(new StringType[] {new StringType("0")});
			cmbService.setHowlong(howlong);
			
			CMBChangeInstanceTypeCmbServiceIsdown isdown = new CMBChangeInstanceTypeCmbServiceIsdown();
			isdown.setIsdown(new StringType[] {new StringType("否")});
			cmbService.setIsdown(isdown);
			
			instance.setCmbService(cmbService);
			
			CMBChangeInstanceTypeClose close = new CMBChangeInstanceTypeClose();
			DecimalType de = new DecimalType();
			de.set_value(null);
			close.setCompletionCode(de);
			instance.setClose(close); 
			instance.setCMBStatus(new StringType("审核中"));
			model.setInstance(instance);
			req.setModel(model);
			CreateCMBChangeResponse rp = stub.createCMBChange(req);
			
			String changeNumber = rp.getModel().getKeys().getChangeNumber().toString().toString();
			String status = rp.getModel().getInstance().getHeader().getStatus().toString();
			String cMBStatus = rp.getModel().getInstance().getCMBStatus().toString();
			String requestedBy = rp.getModel().getInstance().getHeader().getRequestedBy().toString();
			String plannedStartDate = rp.getModel().getInstance().getHeader().getPlannedStartDate().toString();
			String plannedEndDate = rp.getModel().getInstance().getHeader().getPlannedEndDate().toString();
			
			JSONObject o = new JSONObject();
			o.put("changeNumber", changeNumber);
			o.put("status", status);
			o.put("cMBStatus", cMBStatus);
			o.put("requestedBy", requestedBy);
			o.put("plannedStartDate", plannedStartDate);
			o.put("plannedEndDate", plannedEndDate);
			
			json.setRet_code(201);
			json.setRet_info("申请变更ITIL工单成功");
			json.setData(o);
			json.setSuccess(true);
			
		} catch (Exception e) {
			e.printStackTrace();
			json.setRet_code(500);
			json.setSuccess(false);
			json.setRet_info("申请变更ITIL工单错误");
			return JSONObject.toJSONString(json);
		} 
		return JSONObject.toJSONString(json);
	}
	
	/**
	 * 根据工单number号查询变更ITIL工单具体信息
	 * @param requestUrl	路径
	 * @param paramterObj	参数对象
	 * @param requestMethod	请求方式
	 * @param authorization	头部验证
	 * @return
	 */
	public static String queryChangeITILByNumber(String requestUrl, Object paramterObj, String requestMethod, String authorization) throws Exception{
		Json json = new Json();
		String sb = RestfulRequestUtil.getResponse(requestUrl, paramterObj, requestMethod, authorization);
		org.json.JSONObject obj = new org.json.JSONObject(sb);
		Integer code = (Integer) obj.get("ReturnCode");
		JSONArray array = obj.getJSONArray("content");
		List<Object> list = new ArrayList<Object>();
		if(code==0 && !StringUtils.isEmpty(array) && array.length()>0){
			for(int i=0;i<array.length();i++){
				JSONObject d = new JSONObject();
				org.json.JSONObject o = (org.json.JSONObject) array.get(i);	//获取对象
				org.json.JSONObject o1 = o.getJSONObject("GenChange").getJSONObject("header");
				String briefDescription = o1.getString("briefDescription");
				String category = o1.getString("category");
				String number = o1.getString("number");
				String openTime = o1.getString("openTime");
				String plannedEnd = o1.getString("plannedEnd");
				String plannedStart = o1.getString("plannedStart");
				String status = o.getJSONObject("GenChange").getString("status");
				String implementGroup = o.getJSONObject("GenChange").getString("implementGroup");
				String implementer = o.getJSONObject("GenChange").getString("implementer");
				String topSystems = o.getJSONObject("GenChange").getString("topSystems");
				d.put("briefDescription", briefDescription);
				d.put("category", category);
				d.put("number", number);
				d.put("openTime", openTime);
				d.put("plannedEnd", plannedEnd);
				d.put("plannedStart", plannedStart);
				d.put("status", status);
				d.put("implementGroup", implementGroup);
				d.put("implementer", implementer);
				d.put("topSystems", topSystems);
				list.add(d);
			}
			json.setSuccess(true);
			json.setRet_code(200);
			json.setRet_info("查询变更工单成功");
			json.setData(list);
		}else{
			json.setSuccess(false);
			json.setRet_code(500);
			json.setRet_info("查询变更工单失败");
			json.setData(null);
		}
		return JSONObject.toJSONString(json);
	}
	
	public static void main(String[] args) {
		String itilPlannedEnd = "2017-09-30 19:10";
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
		try {
			Date ds = f.parse(itilPlannedEnd);
			if(ds.getHours()>=19 && ds.getMinutes()>0){
				System.out.println(111);
			}
			
			Calendar calendar = Calendar.getInstance();
	        calendar.setTime(ds);
	        calendar.add(Calendar.DAY_OF_MONTH, +3);//+1今天的时间加一天
	        Date d = calendar.getTime();
	        String end = fmt.format(d);
			System.out.println(end);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		String s = StringUtil.readFile("D:\\port.txt");
		
		List<ItilGenrequestBo> list = new ArrayList<ItilGenrequestBo>();
		try {
			org.json.JSONObject obj = new org.json.JSONObject(s);
			JSONArray array = obj.getJSONArray("content");
			for(int i=0;i<array.length();i++){
				org.json.JSONObject o = (org.json.JSONObject) array.get(i);	//获取对象
				org.json.JSONObject a =  (org.json.JSONObject) o.get("GenRequest");
				ItilGenrequestBo bo = JSONObject.parseObject(a.toString(), ItilGenrequestBo.class);
				list.add(bo);
			}
			System.out.println(list.toString()); 
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	
}
