package com.sunrun.controller;

import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.axis.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sunrun.entity.DevIpDistributionBean;
import com.sunrun.entity.DevIpSegmentConfigBean;
import com.sunrun.entity.DevIpSegmentDistributionBean;
import com.sunrun.entity.DevPortDredgeOrder;
import com.sunrun.service.IPDistributionInfoService;
import com.sunrun.task.PortDredgeExecuteInfo;
import com.sunrun.util.Base64Util;
import com.sunrun.util.IPPoolUtil;
import com.sunrun.util.Json;
import com.sunrun.util.PrintIP;
import com.sunrun.util.StringUtil;

/**
 * ip网段管理 、 ip分配管理
 * 
 * @author jl
 *
 */
@RestController
public class IPDistributionInfoController extends BaseController {

	private static final Logger logger = LoggerFactory.getLogger(IPDistributionInfoController.class);

	@Resource
	private IPDistributionInfoService iPDistributionInfoService;

	/**
	 * 查询网段信息
	 * 
	 * @param request
	 * @param response
	 * @param like
	 *            模糊搜索值
	 * @param exact
	 *            精准搜索值
	 * @param sortBy
	 *            排序值（根据哪个属性排序）
	 * @param order
	 *            降序或者升序(desc/asc)
	 * @param currentPage
	 *            当前页数（从1开始）
	 * @param pageSize
	 *            每页显示数目
	 */
	@RequestMapping(value = "/deviceAutomation/ip_segment_distribution/v1/dataInfo", method = RequestMethod.GET, produces = "application/json")
	public void ip_segment_distribution_dataInfo(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "networkType", required = false) String networkType,
			@RequestParam(value = "useType", required = false) String useType,
			@RequestParam(value = "devType", required = false) String devType,
			@RequestParam(value = "exact", required = false) String exact,
			@RequestParam(value = "like", required = false) String like,
			@RequestParam(value = "sortBy", required = false) String sortBy,
			@RequestParam(value = "order", required = false) String order,
			@RequestParam(value = "currentPage", required = false, defaultValue = "0") Integer currentPage,
			@RequestParam(value = "pageSize", required = false, defaultValue = "0") Integer pageSize) {
		Json json = new Json();
		List<Object> data = new ArrayList<Object>();
		JSONObject obj = new JSONObject();
		logger.info("查询 入参是：" + request.getQueryString());
		try {
			DevIpSegmentDistributionBean bean = new DevIpSegmentDistributionBean();
			bean.setNetworkType(networkType);
			bean.setUseType(useType);
			bean.setDevType(devType);

			List<DevIpSegmentDistributionBean> list = iPDistributionInfoService.findDevIpSegmentDistribution(bean,
					exact, like, sortBy, order, page(currentPage, pageSize));
			Integer total = iPDistributionInfoService.countDevIpSegmentDistribution(bean, exact, like);
			obj.put("pageSize", setPageSize(currentPage, pageSize, total));
			obj.put("total", total);
			obj.put("currentPage", currentPage);
			obj.put("data", list);
			data.add(obj);
			json.setData(data);
			json.setRet_info("查询成功");
			json.setRet_code(200);
			json.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("查询 错误");
			json.setCollect(null);
			json.setData(null);
			json.setRet_info("查询失败");
			json.setRet_code(500);
			json.setSuccess(false);
		}
		// 返回数据
		response2(json, response, request);
	}

	/**
	 * 查询 IP 记录
	 * 
	 * @param request
	 * @param response
	 * @param like
	 *            模糊搜索值
	 * @param exact
	 *            精准搜索值
	 * @param sortBy
	 *            排序值（根据哪个属性排序）
	 * @param order
	 *            降序或者升序(desc/asc)
	 * @param currentPage
	 *            当前页数（从1开始）
	 * @param pageSize
	 *            每页显示数目
	 */
	@RequestMapping(value = "/deviceAutomation/ip_distribution/v1/dataInfo", method = RequestMethod.GET, produces = "application/json")
	public void findDevIpDistribution(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "networkType", required = false) String networkType,
			@RequestParam(value = "useType", required = false) String useType,
			@RequestParam(value = "devType", required = false) String devType,
			@RequestParam(value = "exact", required = false) String exact,
			@RequestParam(value = "like", required = false) String like,
			@RequestParam(value = "sortBy", required = false) String sortBy,
			@RequestParam(value = "order", required = false) String order,
			@RequestParam(value = "currentPage", required = false, defaultValue = "0") Integer currentPage,
			@RequestParam(value = "pageSize", required = false, defaultValue = "0") Integer pageSize) {
		Json json = new Json();
		List<Object> data = new ArrayList<Object>();
		JSONObject obj = new JSONObject();
		logger.info("查询 入参是：" + request.getQueryString());
		try {
			DevIpDistributionBean bean = new DevIpDistributionBean();
			bean.setNetworkType(networkType);
			bean.setUseType(useType);
			bean.setDevType(devType);

			List<DevIpDistributionBean> list = iPDistributionInfoService.findDevIpDistribution(bean, exact, like,
					sortBy, order, page(currentPage, pageSize));
			Integer total = iPDistributionInfoService.countDevIpDistribution(bean, exact, like);
			obj.put("pageSize", pageSize);
			obj.put("total", total);
			obj.put("currentPage", currentPage);
			obj.put("data", list);
			data.add(obj);
			json.setData(data);
			json.setRet_info("查询成功");
			json.setRet_code(200);
			json.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("查询 错误");
			json.setCollect(null);
			json.setData(null);
			json.setRet_info("查询失败");
			json.setRet_code(500);
			json.setSuccess(false);
		}
		// 返回数据
		response2(json, response, request);
	}

	/**
	 * 查询网段 总记录数据
	 * 
	 * @param request
	 * @param response
	 * @param like
	 *            模糊搜索值
	 * @param exact
	 *            精准搜索值
	 * @param sortBy
	 *            排序值（根据哪个属性排序）
	 * @param order
	 *            降序或者升序(desc/asc)
	 * @param currentPage
	 *            当前页数（从1开始）
	 * @param pageSize
	 *            每页显示数目
	 */
	@RequestMapping(value = "/deviceAutomation/ip_segment_distribution/v1/statistics", method = RequestMethod.GET, produces = "application/json")
	public void ip_segment_distribution_statistics(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "networkType", required = false) String networkType,
			@RequestParam(value = "useType", required = false) String useType,
			@RequestParam(value = "devType", required = false) String devType,
			@RequestParam(value = "exact", required = false) String exact,
			@RequestParam(value = "like", required = false) String like,
			@RequestParam(value = "sortBy", required = false) String sortBy,
			@RequestParam(value = "order", required = false) String order,
			@RequestParam(value = "currentPage", required = false, defaultValue = "0") Integer currentPage,
			@RequestParam(value = "pageSize", required = false, defaultValue = "20") Integer pageSize) {
		Json json = new Json();
		List<Object> data = new ArrayList<Object>();
		JSONObject obj = new JSONObject();
		JSONArray array = new JSONArray();
		logger.info("查询 入参是：" + request.getQueryString());
		try {
			DevIpSegmentDistributionBean bean = new DevIpSegmentDistributionBean();
			bean.setNetworkType(networkType);
			bean.setUseType(useType);
			bean.setDevType(devType);
			Integer total = iPDistributionInfoService.countDevIpSegmentDistribution(bean, exact, like);
			obj.put("pageSize", pageSize);
			obj.put("total", total);
			obj.put("currentPage", currentPage);
			obj.put("pages",
					((total % pageSize) > 0 ? (Math.floor(total / pageSize) + 1) : (Math.floor(total / pageSize))));
			array.add(obj);
			json.setData(array);
			json.setRet_info("查询成功");
			json.setRet_code(200);
			json.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("查询 错误");
			json.setCollect(null);
			json.setData(null);
			json.setRet_info("查询失败");
			json.setRet_code(500);
			json.setSuccess(false);
		}
		// 返回数据
		response2(json, response, request);
	}

	/**
	 * 查询 IP 总记录数据
	 * 
	 * @param request
	 * @param response
	 * @param like
	 *            模糊搜索值
	 * @param exact
	 *            精准搜索值
	 * @param sortBy
	 *            排序值（根据哪个属性排序）
	 * @param order
	 *            降序或者升序(desc/asc)
	 * @param currentPage
	 *            当前页数（从1开始）
	 * @param pageSize
	 *            每页显示数目
	 */
	@RequestMapping(value = "/deviceAutomation/ip_distribution/v1/statistics", method = RequestMethod.GET, produces = "application/json")
	public void countDevIpDistribution(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "networkType", required = false) String networkType,
			@RequestParam(value = "useType", required = false) String useType,
			@RequestParam(value = "devType", required = false) String devType,
			@RequestParam(value = "exact", required = false) String exact,
			@RequestParam(value = "like", required = false) String like,
			@RequestParam(value = "sortBy", required = false) String sortBy,
			@RequestParam(value = "order", required = false) String order,
			@RequestParam(value = "currentPage", required = false, defaultValue = "0") Integer currentPage,
			@RequestParam(value = "pageSize", required = false, defaultValue = "20") Integer pageSize) {
		Json json = new Json();
		List<Object> data = new ArrayList<Object>();
		JSONArray array = new JSONArray();
		JSONObject obj = new JSONObject();
		logger.info("查询 入参是：" + request.getQueryString());
		try {
			DevIpDistributionBean bean = new DevIpDistributionBean();
			bean.setNetworkType(networkType);
			bean.setUseType(useType);
			bean.setDevType(devType);
			Integer total = iPDistributionInfoService.countDevIpDistribution(bean, exact, like);
			obj.put("pageSize", pageSize);
			obj.put("total", total);
			obj.put("currentPage", currentPage);
			obj.put("pages",
					((total % pageSize) > 0 ? (Math.floor(total / pageSize) + 1) : (Math.floor(total / pageSize))));
			array.add(obj);
			json.setData(array);
			json.setRet_info("查询成功");
			json.setRet_code(200);
			json.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("查询  错误");
			json.setCollect(null);
			json.setData(null);
			json.setRet_info("查询失败");
			json.setRet_code(500);
			json.setSuccess(false);
		}
		// 返回数据
		response2(json, response, request);
	}

	/**
	 * 查询 网络类型、用途、设备类型、类别、ip地址类型、用途规划 的值
	 * 
	 * @param request
	 * @param response
	 * 
	 */
	@RequestMapping(value = "/deviceAutomation/dev_ip_segment_config/v1/dataInfo", method = RequestMethod.GET, produces = "application/json")
	public void dev_ip_segment_config_dataInfo(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "selectDataType", required = false) String selectDataType,
			@RequestParam(value = "networkType", required = false) String networkType,
			@RequestParam(value = "useType", required = false) String useType,
			@RequestParam(value = "devType", required = false) String devType) {
		Json json = new Json();
		List<Object> data = new ArrayList<Object>();

		Map<String, String> keyAndValues = new HashMap<String, String>();

		logger.info("查询 入参是：" + request.getQueryString());
		try {
			DevIpSegmentConfigBean bean = new DevIpSegmentConfigBean();
			bean.setNetworkType(networkType);
			bean.setUseType(useType);
			bean.setDevType(devType);
			List<DevIpSegmentConfigBean> list = iPDistributionInfoService.findDevIpSegmentConfigBean(bean);

			for (DevIpSegmentConfigBean devIpSegmentConfigBean : list) {
				// networkType 网络类型
				if (selectDataType.equals("networkType")) {
					if (devIpSegmentConfigBean.getNetworkType() != null
							&& !devIpSegmentConfigBean.getNetworkType().trim().equals("")
							&& !keyAndValues.containsKey(devIpSegmentConfigBean.getNetworkType().trim())) {
						keyAndValues.put(devIpSegmentConfigBean.getNetworkType().trim(),
								devIpSegmentConfigBean.getNetworkType().trim());
					}

				}

				//

				// useType 网络类型
				if (selectDataType.equals("useType")) {
					if (devIpSegmentConfigBean.getUseType() != null
							&& !devIpSegmentConfigBean.getUseType().trim().equals("")
							&& !keyAndValues.containsKey(devIpSegmentConfigBean.getUseType().trim())) {
						keyAndValues.put(devIpSegmentConfigBean.getUseType().trim(),
								devIpSegmentConfigBean.getUseType().trim());
					}

				}

				// devType 设备类型
				if (selectDataType.equals("devType")) {
					if (devIpSegmentConfigBean.getDevType() != null
							&& !devIpSegmentConfigBean.getDevType().trim().equals("")
							&& !keyAndValues.containsKey(devIpSegmentConfigBean.getDevType().trim())) {
						keyAndValues.put(devIpSegmentConfigBean.getDevType().trim(),
								devIpSegmentConfigBean.getDevType().trim());
					}

				}

				// category 类别
				if (selectDataType.equals("category")) {
					if (devIpSegmentConfigBean.getCategory() != null
							&& !devIpSegmentConfigBean.getCategory().trim().equals("")
							&& !keyAndValues.containsKey(devIpSegmentConfigBean.getCategory().trim())) {
						keyAndValues.put(devIpSegmentConfigBean.getCategory().trim(),
								devIpSegmentConfigBean.getCategory().trim());
					}

				}

				// ipAddressType 类别
				if (selectDataType.equals("ipAddressType")) {
					if (devIpSegmentConfigBean.getIpAddressType() != null
							&& !devIpSegmentConfigBean.getIpAddressType().trim().equals("")
							&& !keyAndValues.containsKey(devIpSegmentConfigBean.getIpAddressType().trim())) {
						keyAndValues.put(devIpSegmentConfigBean.getIpAddressType().trim(),
								devIpSegmentConfigBean.getIpAddressType().trim());
					}

				}

				// userPlan：用途规划
				if (selectDataType.equals("userPlan")) {
					if (devIpSegmentConfigBean.getUserPlan() != null
							&& !devIpSegmentConfigBean.getUserPlan().trim().equals("")
							&& !keyAndValues.containsKey(devIpSegmentConfigBean.getUserPlan().trim())) {
						keyAndValues.put(devIpSegmentConfigBean.getUserPlan().trim(),
								devIpSegmentConfigBean.getUserPlan().trim());
					}

				}

			}

			if (keyAndValues.size() > 1) {
				JSONObject obj = new JSONObject();
				// key 和 value 的值都一样。
				obj.put("key", "");
				obj.put("value", "所有");
				data.add(obj);
			}

			if (keyAndValues.size() < 1) {
				JSONObject obj = new JSONObject();
				// key 和 value 的值都一样。
				obj.put("key", "");
				obj.put("value", "无");
				data.add(obj);
			}

			// 取出 key
			Iterator iter = keyAndValues.entrySet().iterator();
			while (iter.hasNext()) {
				Map.Entry entry = (Map.Entry) iter.next();
				Object key = entry.getKey();
				JSONObject obj = new JSONObject();
				// key 和 value 的值都一样。
				obj.put("key", key);
				obj.put("value", key);
				data.add(obj);
			}

			json.setData(data);
			json.setRet_info("查询成功");
			json.setRet_code(200);
			json.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("查询 错误");
			json.setCollect(null);
			json.setData(null);
			json.setRet_info("查询失败");
			json.setRet_code(500);
			json.setSuccess(false);
		}
		// 返回数据
		response2(json, response, request);
	}

	/**
	 * 查询 负责人 接口 的值
	 * 
	 * @param request
	 * @param response
	 * 
	 */
	@RequestMapping(value = "/deviceAutomation/dev_ip_distribution_config/v1/allocationUser", method = RequestMethod.GET, produces = "application/json")
	public void findAllocationUser(HttpServletRequest request, HttpServletResponse response) {
		Json json = new Json();
		List<Object> data = new ArrayList<Object>();

		Map<String, String> keyAndValues = new HashMap<String, String>();

		logger.info("查询 入参是：" + request.getQueryString());
		try {

			List<String> list = iPDistributionInfoService.findAllocationUser();

			for (String key : list) {
				if (!keyAndValues.containsKey(key.trim())) {
					keyAndValues.put(key.trim(), key.trim());
				}
			}

			if (keyAndValues.size() > 1) {
				JSONObject obj = new JSONObject();
				// key 和 value 的值都一样。
				obj.put("key", "");
				obj.put("value", "请选择");
				data.add(obj);
			}

			if (keyAndValues.size() < 1) {
				JSONObject obj = new JSONObject();
				// key 和 value 的值都一样。
				obj.put("key", "");
				obj.put("value", "无");
				data.add(obj);
			}

			// 取出 key
			Iterator iter = keyAndValues.entrySet().iterator();
			while (iter.hasNext()) {
				Map.Entry entry = (Map.Entry) iter.next();
				Object key = entry.getKey();
				JSONObject obj = new JSONObject();
				// key 和 value 的值都一样。
				obj.put("key", key);
				obj.put("value", key);
				data.add(obj);
			}

			json.setData(data);
			json.setRet_info("查询成功");
			json.setRet_code(200);
			json.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("查询 错误");
			json.setCollect(null);
			json.setData(null);
			json.setRet_info("查询失败");
			json.setRet_code(500);
			json.setSuccess(false);
		}
		// 返回数据
		response2(json, response, request);
	}

	/**
	 * 新增网段接口
	 * 
	 * @param jsonStr
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/deviceAutomation/ip_segment_distribution/v1/DataAdd", method = RequestMethod.POST, produces = "application/json")
	public void saveIpSegmentDistribution(@RequestBody String jsonStr, HttpServletRequest request,
			HttpServletResponse response) {
		Json json = new Json();
		logger.info("deviceAutomation/ip_segment_distribution/v1/DataAdd 入参是：" + jsonStr);
		JSONObject obj = JSONObject.parseObject(jsonStr);

		String userId = obj.getString("userId");
		String address = obj.getString("address");
		String networkType = obj.getString("networkType");
		String useType = obj.getString("useType");
		String devType = obj.getString("devType");
		String remark = obj.getString("remark");

		JSONArray dataJSONArray = obj.getJSONArray("data");
		List<DevIpSegmentDistributionBean> devIpSegmentDistributionBeanList = new ArrayList<DevIpSegmentDistributionBean>();
		List<DevIpDistributionBean> devIpDistributionBeanList = new ArrayList<DevIpDistributionBean>();

		try {

			for (Iterator iterator = dataJSONArray.iterator(); iterator.hasNext();) {
				JSONObject job = (JSONObject) iterator.next();
				String ipSegment = job.getString("ip");
				String subnetMask = job.getString("subnetMask");

				// 根据 IP网段去查， 是否有记录，如果有记录，则不进行插入操作。
				DevIpSegmentDistributionBean devIpSegmentDistributionBean_select = new DevIpSegmentDistributionBean();
				devIpSegmentDistributionBean_select.setIpSegment(ipSegment);
				List<DevIpSegmentDistributionBean> list = iPDistributionInfoService.findDevIpSegmentDistribution(
						devIpSegmentDistributionBean_select, null, null, null, null, null);
				if (list != null && list.size() > 0) {
					json.setCollect(null);
					json.setData(null);
					json.setRet_info("网段:" + ipSegment + ",已录入过，请核实。");
					json.setRet_code(500);
					json.setSuccess(false);
					response(json, response, request);
					return;
				}

				String id = StringUtil.getUuid();
				DevIpSegmentDistributionBean devIpSegmentDistributionBean = new DevIpSegmentDistributionBean();
				devIpSegmentDistributionBean.setId(id);
				devIpSegmentDistributionBean.setAddress(address);
				devIpSegmentDistributionBean.setNetworkType(networkType);
				devIpSegmentDistributionBean.setUseType(useType);
				devIpSegmentDistributionBean.setDevType(devType);
				devIpSegmentDistributionBean.setRemark(remark);

				devIpSegmentDistributionBean.setIpSegment(ipSegment);
				devIpSegmentDistributionBean.setSubnetMask(subnetMask);

				// 根据子网掩码，算出IP 数量
				devIpSegmentDistributionBean.setLeisureIp(IPPoolUtil.getPoolMax(Integer.parseInt(subnetMask)));
				devIpSegmentDistributionBean.setUsedIp(0);

				// 开始IP
				String startIP = IPPoolUtil.getStartIPString(ipSegment, Integer.parseInt(subnetMask));
				// 结束IP
				String endIP = IPPoolUtil.getEndIPString(ipSegment, Integer.parseInt(subnetMask));

				long ip1 = PrintIP.getIP(InetAddress.getByName(startIP));
				long ip2 = PrintIP.getIP(InetAddress.getByName(endIP));
				// 得到 开始IP 与 结束IP 之间所有的IP
				for (long myip = ip1; myip <= ip2; myip++) {
					DevIpDistributionBean bean = new DevIpDistributionBean();
					bean.setId(StringUtil.getUuid());
					bean.setAddress(address);
					bean.setNetworkType(networkType);
					bean.setUseType(useType);
					bean.setDevType(devType);
					bean.setIp(PrintIP.toIP(myip).getHostAddress());
					bean.setIpSegment(ipSegment);
					bean.setRemark(remark);
					bean.setIsUseInteger(0);
					devIpDistributionBeanList.add(bean);

				}

				devIpSegmentDistributionBeanList.add(devIpSegmentDistributionBean);

			}

			iPDistributionInfoService.saveDevIpDistribution(devIpDistributionBeanList);
			iPDistributionInfoService.saveIpSegmentDistribution(devIpSegmentDistributionBeanList);
			json.setRet_info("成功");
			json.setRet_code(201);

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("保存 错误");
			json.setCollect(null);
			json.setData(null);
			json.setRet_info("失败");
			json.setRet_code(500);
			json.setSuccess(false);
		}
		response(json, response, request);
	}

	/**
	 * 新增网段接口
	 * 
	 * @param jsonStr
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/deviceAutomation/ip_distribution/v1/DataAdd", method = RequestMethod.POST, produces = "application/json")
	public void saveIpDistribution(@RequestBody String jsonStr, HttpServletRequest request,
			HttpServletResponse response) {
		Json json = new Json();
		logger.info("/deviceAutomation/ip_distribution/v1/DataAdd 入参是：" + jsonStr);
		JSONObject obj = JSONObject.parseObject(jsonStr);
		JSONArray dataJSONArray = obj.getJSONArray("data");

		try {
			json.setRet_info("成功");
			json.setRet_code(201);

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("保存 错误");
			json.setCollect(null);
			json.setData(null);
			json.setRet_info("失败");
			json.setRet_code(500);
			json.setSuccess(false);
		}
		response(json, response, request);
	}

	/**
	 * 修改网段接口
	 * 
	 * @param jsonStr
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/deviceAutomation/ip_segment_distribution/v1/dataUpdate", method = RequestMethod.POST, produces = "application/json")
	public void dataUpdateIpSegmentDistribution(@RequestBody String jsonStr, HttpServletRequest request,
			HttpServletResponse response) {
		Json json = new Json();
		logger.info("/deviceAutomation/ip_segment_distribution/v1/dataUpdate 入参是：" + jsonStr);
		JSONObject obj = JSONObject.parseObject(jsonStr);
		List<DevIpSegmentDistributionBean> devIpSegmentDistributionBeanList = new ArrayList<DevIpSegmentDistributionBean>();

		try {

			String userId = obj.getString("userId");
			String remark = obj.getString("remark");
			String userName = obj.getString("userName");
			String usercode = obj.getString("usercode");
			JSONArray idJSONArray = obj.getJSONArray("id");

			for (Iterator iterator = idJSONArray.iterator(); iterator.hasNext();) {
				String id = (String) iterator.next();
				// 根据 ID 在 dev_ip_segment_distribution 网中 查询 IP
				DevIpSegmentDistributionBean devIpSegmentDistributionBean = new DevIpSegmentDistributionBean();
				devIpSegmentDistributionBean.setId(id);
				List<DevIpSegmentDistributionBean> list = iPDistributionInfoService
						.findDevIpSegmentDistribution(devIpSegmentDistributionBean, null, null, null, null, null);

				if (list != null && list.size() == 1) {
					devIpSegmentDistributionBean.setIpSegment(list.get(0).getIpSegment());
				}
				devIpSegmentDistributionBean.setRemark(remark);
				devIpSegmentDistributionBean.setUpdate_user(userId);
				devIpSegmentDistributionBean.setUpdateUserInfo(usercode + "/" + userName);
				devIpSegmentDistributionBeanList.add(devIpSegmentDistributionBean);

			}

			iPDistributionInfoService.editIpSegmentDistribution(devIpSegmentDistributionBeanList);

			json.setRet_info("成功");
			json.setRet_code(201);

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("修改 错误");
			json.setCollect(null);
			json.setData(null);
			json.setRet_info("失败");
			json.setRet_code(500);
			json.setSuccess(false);
		}
		response(json, response, request);
	}

	/**
	 * 修改IP接口
	 * 
	 * @param jsonStr
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/deviceAutomation/ip_distribution/v1/dataUpdate", method = RequestMethod.POST, produces = "application/json")
	public void dataUpdateIpDistribution(@RequestBody String jsonStr, HttpServletRequest request,
			HttpServletResponse response) {
		Json json = new Json();
		logger.info("/deviceAutomation/ip_distribution/v1/dataUpdate 入参是：" + jsonStr);
		JSONObject obj = JSONObject.parseObject(jsonStr);
		JSONArray dataJSONArray = obj.getJSONArray("data");
		String idOrIPDataType = "";

		List<DevIpDistributionBean> devIpDistributionBeanList = new ArrayList<DevIpDistributionBean>();
		DevIpDistributionBean devIpDistributionBean_one = new DevIpDistributionBean();

		try {
			String userId = obj.getString("userId");
			String remark = obj.getString("remark");
			String tabName = obj.getString("tabName");
			String allocationUser = obj.getString("allocationUser");
			String responsible = obj.getString("responsible");
			String subnetMask = obj.getString("subnetMask");

			String gateway = obj.getString("gateway");
			String area = obj.getString("area");
			String startNode = obj.getString("startNode");
			String endNode = obj.getString("endNode");
			String startPort = obj.getString("startPort");
			String endPort = obj.getString("endPort");
			String category = obj.getString("category");
			String ipAddressType = obj.getString("ipAddressType");
			String devModel = obj.getString("devModel");
			String userPlan = obj.getString("userPlan");
			String userName = obj.getString("userName");
			String usercode = obj.getString("usercode");

			JSONArray idOrIPDataJSONArray = new JSONArray(); // ip 或 id 参数 数组。
			if (obj.containsKey("id")) {
				idOrIPDataJSONArray = obj.getJSONArray("id");
				idOrIPDataType = "id";
			}
			if (obj.containsKey("ip")) {
				idOrIPDataJSONArray = obj.getJSONArray("ip");
				idOrIPDataType = "ip";
			}
			
			
			 

			for (Iterator iterator = idOrIPDataJSONArray.iterator(); iterator.hasNext();) {
				
				DevIpDistributionBean devIpDistributionBean = new DevIpDistributionBean();

				String idOrIPData = (String) iterator.next();
				if (idOrIPDataType.equals("ip")) {
					devIpDistributionBean.setIp(idOrIPData);
					devIpDistributionBean_one.setIp(idOrIPData);

				} else {
					devIpDistributionBean.setId(idOrIPData);
					devIpDistributionBean_one.setId(idOrIPData);
				}
				
				// 根据ID 去查询记录，  
				List<DevIpDistributionBean> list = iPDistributionInfoService
						.findDevIpDistribution(devIpDistributionBean, null, null, null, null, null);
				
				String responsible_db="";
				DevIpDistributionBean responsibleDevIpDistributionBean=null;
				//判断是否有记录
				if (list.size() > 0) {
					  responsibleDevIpDistributionBean = list.get(0);
					  responsible_db = responsibleDevIpDistributionBean.getResponsible() == null ? ""
							: responsibleDevIpDistributionBean.getResponsible();
				}else{
					json.setCollect(null);
					json.setData(null);
					json.setRet_info("没有找到相关记录："+idOrIPDataType);
					json.setRet_code(500);
					json.setSuccess(false);
					response(json, response, request);
					return;
				}
				

				// 当参数 传过来的负责人有值时
				if (responsible != null && responsible.length() > 0) {
					 	

						//  如果原记录的负责人为空，则需要去校验是否有权限，才能去修改。
						if (responsible_db == null || responsible_db.equals("")) {
							// 如果不一样， 需要校验操作人员是否有权限去操作。
							if (iPDistributionInfoService.findUserRole("网络室操作员", userId) < 1) {
								// 没有权限
								json.setCollect(null);
								json.setData(null);
								json.setRet_info("此用户没有修改负责人权限");
								json.setRet_code(500);
								json.setSuccess(false);
								response(json, response, request);
								return;
							}  

						}else{
							
							// 如果 原记录的负责人已有值，则不可以进行修改。如果登陆账号就是负责人除外
							if (   !responsible_db.equals(responsible.trim()) && !responsible_db.contains(usercode)) { 
									// 没有权限
									json.setCollect(null);
									json.setData(null);
									json.setRet_info("此记录已有相关负责人，不能进行修改。");
									json.setRet_code(500);
									json.setSuccess(false);
									response(json, response, request);
									return;

								 
							}
						}
						
						devIpDistributionBean.setIsUseInteger(1);
						devIpDistributionBean_one.setIsUseInteger(1);
						devIpDistributionBean_one.setIpSegment(responsibleDevIpDistributionBean.getIpSegment());
						
						
				}
						

						devIpDistributionBean.setUpdate_user(userId);
						devIpDistributionBean.setUpdateUserInfo(
								(usercode == null ? "" : usercode) + "/" + (userName == null ? "" : userName));
						devIpDistributionBean.setRemark(remark);
						devIpDistributionBean.setAllocationUser(allocationUser);
						devIpDistributionBean.setArea(area);
						devIpDistributionBean.setStartNode(startNode);
						devIpDistributionBean.setEndNode(endNode);
						devIpDistributionBean.setStartPort(startPort);
						devIpDistributionBean.setEndPort(endPort);
						devIpDistributionBean.setCategory(category);
						devIpDistributionBean.setIpAddressType(ipAddressType);
						devIpDistributionBean.setDevModel(devModel);
						devIpDistributionBean.setUserPlan(userPlan);

						
						devIpDistributionBean_one.setResponsible(responsible);
						devIpDistributionBean_one.setUpdate_user(userId);
						devIpDistributionBean_one.setUpdateUserInfo(
								(usercode == null ? "" : usercode) + "/" + (userName == null ? "" : userName));
						devIpDistributionBean_one.setRemark(remark);
						devIpDistributionBean_one.setAllocationUser(allocationUser);
						devIpDistributionBean_one.setArea(area);
						devIpDistributionBean_one.setStartNode(startNode);
						devIpDistributionBean_one.setEndNode(endNode);
						devIpDistributionBean_one.setStartPort(startPort);
						devIpDistributionBean_one.setEndPort(endPort);
						devIpDistributionBean_one.setCategory(category);
						devIpDistributionBean_one.setIpAddressType(ipAddressType);
						devIpDistributionBean_one.setDevModel(devModel);
						devIpDistributionBean_one.setUserPlan(userPlan); 
						devIpDistributionBeanList.add(devIpDistributionBean); 
					 
				
				
			}
			
			iPDistributionInfoService.editIpDistribution(devIpDistributionBeanList, devIpDistributionBean_one);

			json.setRet_info("成功");
			json.setRet_code(201);
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("修改 错误");
			json.setCollect(null);
			json.setData(null);
			json.setRet_info("失败");
			json.setRet_code(500);
			json.setSuccess(false);
		}
		response(json, response, request);
	}

	/**
	 * 删除网段数据接口
	 * 
	 * @param jsonStr
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/deviceAutomation/ip_segment_distribution/v1/dataDelete/{ID}", method = RequestMethod.POST, produces = "application/json")
	public void dataDeleteIpSegmentDistribution(@PathVariable String ID, @RequestBody String jsonStr,
			HttpServletRequest request, HttpServletResponse response) {
		Json json = new Json();
		logger.info("/deviceAutomation/ip_segment_distribution/v1/dataDelete/{ID} 入参是：" + jsonStr);
		JSONObject obj = JSONObject.parseObject(jsonStr);
		JSONArray dataJSONArray = obj.getJSONArray("data");
		try {

			// 根据 ID 在 dev_ip_segment_distribution 网中 查询 IP
			DevIpSegmentDistributionBean devIpSegmentDistributionBean = new DevIpSegmentDistributionBean();
			devIpSegmentDistributionBean.setId(ID);
			List<DevIpSegmentDistributionBean> list = iPDistributionInfoService
					.findDevIpSegmentDistribution(devIpSegmentDistributionBean, null, null, null, null, null);

			if (list != null && list.size() == 1) {
				devIpSegmentDistributionBean.setIpSegment(list.get(0).getIp());

			}

			iPDistributionInfoService.deleteIpSegmentDistribution(devIpSegmentDistributionBean);
			json.setRet_info("成功");
			json.setRet_code(201);

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("修改 错误");
			json.setCollect(null);
			json.setData(null);
			json.setRet_info("失败");
			json.setRet_code(500);
			json.setSuccess(false);
		}
		response(json, response, request);
	}

}
