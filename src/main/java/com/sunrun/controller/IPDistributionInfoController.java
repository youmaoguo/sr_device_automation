package com.sunrun.controller;

import java.lang.reflect.Field;
import java.net.InetAddress;
import java.util.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sunrun.entity.DevIpDistributionBean;
import com.sunrun.entity.DevIpSegmentConfigBean;
import com.sunrun.entity.DevIpSegmentDistributionBean;
import com.sunrun.entity.MenuBean;
import com.sunrun.service.IPDistributionInfoService;
import com.sunrun.util.IPPoolUtil;
import com.sunrun.util.Json;
import com.sunrun.util.PrintIP;
import com.sunrun.util.StringUtil;

/**
 * ip网段管理 、 ip分配管理
 *
 * @author jl
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
     * @param like        模糊搜索值
     * @param exact       精准搜索值
     * @param sortBy      排序值（根据哪个属性排序）
     * @param order       降序或者升序(desc/asc)
     * @param currentPage 当前页数（从1开始）
     * @param pageSize    每页显示数目
     */
    @RequestMapping(value = "/deviceAutomation/ip_segment_distribution/v1/dataInfo", method = RequestMethod.GET, produces = "application/json")
    public void ip_segment_distribution_dataInfo(HttpServletRequest request, HttpServletResponse response,
                                                 @RequestParam(value = "selectColumnName", required = false) String selectColumnName,
                                                 @RequestParam(value = "exact", required = false) String exact,
                                                 @RequestParam(value = "like", required = false) String like,
                                                 @RequestParam(value = "sortBy", required = false) String sortBy,
                                                 @RequestParam(value = "order", required = false) String order,
                                                 @RequestParam(value = "currentPage", required = false, defaultValue = "0") Integer currentPage,
                                                 @RequestParam(value = "pageSize", required = false, defaultValue = "0") Integer pageSize) {

        logger.info("查询 入参是：" + request.getQueryString());
        try {
            String value = "";
            if (exact != null && "".equals(exact)) {
                value = exact.trim();
            } else {
                value = like!=null?like.trim():"";
            }
            DevIpSegmentDistributionBean bean = parDevIpSegmentDistributionBean(selectColumnName, value);


            List<DevIpSegmentDistributionBean> list = iPDistributionInfoService.findDevIpSegmentDistribution(bean,
                    exact, like, sortBy, order, page(currentPage, pageSize));
            Integer total = iPDistributionInfoService.countDevIpSegmentDistribution(bean, exact, like);
            response(list, pageSize, total, currentPage, "查询成功", request, response);

        } catch (Exception e) {
            response(e, "查询数据出错", request, response);
        }

    }

    /**
     * 查询 IP 记录
     *
     * @param request
     * @param response
     * @param like        模糊搜索值
     * @param exact       精准搜索值
     * @param sortBy      排序值（根据哪个属性排序）
     * @param order       降序或者升序(desc/asc)
     * @param currentPage 当前页数（从1开始）
     * @param pageSize    每页显示数目
     */
    @RequestMapping(value = "/deviceAutomation/ip_distribution/v1/dataInfo", method = RequestMethod.GET, produces = "application/json")
    public void findDevIpDistribution(HttpServletRequest request, HttpServletResponse response,
                                      @RequestParam(value = "tabName", required = true) String tabName,
                                      @RequestParam(value = "selectColumnName", required = false) String selectColumnName,
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
            String value = "";
            if (exact != null && "".equals(exact)) {
                value = exact.trim();
            } else {
                value = like!=null?like.trim():"";
            }


            DevIpDistributionBean bean = parDevIpDistributionBean(selectColumnName, value);
            bean.setNetworkType(null == tabName || "所有".equals(tabName) ? null : tabName.trim());
            List<DevIpDistributionBean> list = iPDistributionInfoService.findDevIpDistribution(bean, exact, like,
                    sortBy, order, page(currentPage, pageSize));
            Integer total = iPDistributionInfoService.countDevIpDistribution(bean, exact, like);
            response(list, pageSize, total, currentPage, "查询成功", request, response);
        } catch (Exception e) {
            response(e, "查询数据出错", request, response);
        }

    }

    /**
     * 查询网段 总记录数据
     *
     * @param request
     * @param response
     * @param like        模糊搜索值
     * @param exact       精准搜索值
     * @param sortBy      排序值（根据哪个属性排序）
     * @param order       降序或者升序(desc/asc)
     * @param currentPage 当前页数（从1开始）
     * @param pageSize    每页显示数目
     */
    @RequestMapping(value = "/deviceAutomation/ip_segment_distribution/v1/statistics", method = RequestMethod.GET, produces = "application/json")
    public void ip_segment_distribution_statistics(HttpServletRequest request, HttpServletResponse response,
                                                   @RequestParam(value = "selectColumnName", required = false) String selectColumnName,
                                                   @RequestParam(value = "exact", required = false) String exact,
                                                   @RequestParam(value = "like", required = false) String like,
                                                   @RequestParam(value = "sortBy", required = false) String sortBy,
                                                   @RequestParam(value = "order", required = false) String order,
                                                   @RequestParam(value = "currentPage", required = false, defaultValue = "0") Integer currentPage,
                                                   @RequestParam(value = "pageSize", required = false, defaultValue = "0") Integer pageSize) {

        List<Object> data = new ArrayList<Object>();
        logger.info("查询 入参是：" + request.getQueryString());
        try {
            String value = "";
            if (exact != null && "".equals(exact)) {
                value = exact.trim();
            } else {
                value = like!=null?like.trim():"";
            }
            DevIpSegmentDistributionBean bean = parDevIpSegmentDistributionBean(selectColumnName, value);


            Integer total = iPDistributionInfoService.countDevIpSegmentDistribution(bean, exact, like);

            response(pageSize, total, currentPage, "查询成功", request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response(e, "查询数据出错", request, response);
        }

    }

    /**
     * 查询 IP 总记录数据
     *
     * @param request
     * @param response
     * @param like        模糊搜索值
     * @param exact       精准搜索值
     * @param sortBy      排序值（根据哪个属性排序）
     * @param order       降序或者升序(desc/asc)
     * @param currentPage 当前页数（从1开始）
     * @param pageSize    每页显示数目
     */
    @RequestMapping(value = "/deviceAutomation/ip_distribution/v1/statistics", method = RequestMethod.GET, produces = "application/json")
    public void countDevIpDistribution(HttpServletRequest request, HttpServletResponse response,
                                       @RequestParam(value = "tabName", required = true) String tabName,
                                       @RequestParam(value = "selectColumnName", required = false) String selectColumnName,
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

            String value = "";
            if (exact != null && "".equals(exact)) {
                value = exact.trim();
            } else {
                value = like!=null?like.trim():"";
            }


            DevIpDistributionBean bean = parDevIpDistributionBean(selectColumnName, value);
            bean.setNetworkType(null == tabName || "所有".equals(tabName) ? null : tabName.trim());

            Integer total = iPDistributionInfoService.countDevIpDistribution(bean == null ? new DevIpDistributionBean() : bean, exact, like);
            response(pageSize, total, currentPage, "查询成功", request, response);
        } catch (Exception e) {
            response(e, "查询数据出错", request, response);
        }
    }

    /**
     * 查询 网络类型、用途、设备类型、类别、ip地址类型、用途规划 的值
     *
     * @param request
     * @param response
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


            }

            if (keyAndValues.size() >= 1) {
                JSONObject obj = new JSONObject();
                // key 和 value 的值都一样。
                obj.put("key", "");
                obj.put("value", "请选择");
                data.add(obj);
            } else {
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
            // 返回数据
            response2(json, response, request);
        } catch (Exception e) {
            response(e, "查询数据出错", request, response);
        }

    }

    /**
     * 查询 负责人 接口 的值
     *
     * @param request
     * @param response
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
            // 返回数据
            response2(json, response, request);
        } catch (Exception e) {
            response(e, "查询数据出错", request, response);
        }

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
        JSONArray dataJSONArray = obj.getJSONArray("data");

        List<DevIpSegmentDistributionBean> devIpSegmentDistributionBeanList = new ArrayList<DevIpSegmentDistributionBean>();

        // 记录ip地址对应的IP网段
        Map<String, String> ipSegmentMap = new HashMap<String, String>();
        ipSegmentMap.clear();
        try {

            for (Iterator iterator = dataJSONArray.iterator(); iterator.hasNext(); ) {
                JSONObject job = (JSONObject) iterator.next();
                String ipSegment = job.getString("ip");
                String subnetMask = job.getString("subnetMask");
                if (subnetMask == null || (Integer.parseInt(subnetMask) > 24)) {
                    json.setCollect(null);
                    json.setData(null);
                    json.setRet_info("网段:" + ipSegment + "/" + subnetMask + ",填写的子网掩码不能大于24，请核实。");
                    json.setRet_code(500);
                    json.setSuccess(false);
                    response(json, response, request);
                    return;
                }

                // 根据 IP网段去查， 是否有记录，如果有记录，则不进行插入操作。
                if (checkCountDevIpSegmentDistribution(ipSegment, subnetMask, request, response)) {
                    return;
                }


                // 生成新IP网段，校验IP 网段
                ipSegmentMap = getIPSegmentMap(ipSegment, subnetMask, request, response);

                if (ipSegmentMap.size() < 1) {
                    continue;
                }


                Iterator<Map.Entry<String, String>> ipSegmentMapIterator = ipSegmentMap.entrySet().iterator();
                while (ipSegmentMapIterator.hasNext()) {
                    Map.Entry<String, String> entry = ipSegmentMapIterator.next();

                    String newSegment = entry.getKey();
                    if (newSegment == null) {
                        continue;
                    }

                    // 根据重新分割过的网段 去查， 是否有记录，如果有记录，则不进行插入操作。
                    if (checkCountDevIpSegmentDistribution(PrintIP.IpSegment(newSegment), "24", request, response)) {
                        return;
                    }

                    // -------构建 ip网段 bean

                    obj.put("ipSegment", newSegment);
                    devIpSegmentDistributionBeanList.add(createDevIpSegmentDistribution(obj.toJSONString()));
                }
            }


            if (devIpSegmentDistributionBeanList != null && devIpSegmentDistributionBeanList.size() > 0) {
                // 保存IP 网段信息
                iPDistributionInfoService.saveIpSegmentDistribution(devIpSegmentDistributionBeanList);


                //构建 ip bean
                List<DevIpDistributionBean> IPDistributionBeanList = createIpDistributionBean(ipSegmentMap, jsonStr);

                // 保存IP 信息
                iPDistributionInfoService.saveDevIpDistribution(IPDistributionBeanList);

            }


            json.setRet_info("成功");
            json.setRet_code(201);

            response(json, response, request);
        } catch (Exception e) {

            response(e, "保存数据出错", request, response);
        }

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
        // 根据 招行 李云龙要求， 每一次对数据的修改，相当于：把原记录逻辑删除，再插入一条新记录。

        Json json = new Json();
        logger.info("/deviceAutomation/ip_segment_distribution/v1/dataUpdate 入参是：" + jsonStr);
        JSONObject obj = JSONObject.parseObject(jsonStr);
        List<DevIpSegmentDistributionBean> devIpSegmentDistributionBeanList = new ArrayList<DevIpSegmentDistributionBean>();
        List<DevIpDistributionBean> devIpDistributionBeanList = new ArrayList<DevIpDistributionBean>();


        try {

            String userId = obj.getString("userId");
            String usercode = obj.getString("usercode");
            String responsible = obj.getString("responsible");
            JSONArray idJSONArray = obj.getJSONArray("id");




            // 数据库中这条记录的 负责人
            String responsible_db = "";


            for (Iterator iterator = idJSONArray.iterator(); iterator.hasNext(); ) {
                String id = (String) iterator.next();
                // 根据 ID 在 dev_ip_segment_distribution 网中 查询 IP
                DevIpSegmentDistributionBean devIpSegmentDistributionBean = new DevIpSegmentDistributionBean();
                devIpSegmentDistributionBean.setId(id);
                List<DevIpSegmentDistributionBean> list = iPDistributionInfoService
                        .findDevIpSegmentDistribution(devIpSegmentDistributionBean, null, null, null, null, null);

                // 根据 ID 是否存在这条记录
                if (list != null && list.size() == 1) {
                    devIpSegmentDistributionBean=list.get(0);

                    // 校验 当networkType  发生变化时， 是否有权限进行修改
                    if (!checkRole(obj, list.get(0), request, response)) {
                        return;
                    }

                } else {
                    json.setCollect(null);
                    json.setData(null);
                    json.setRet_info("失败：没有找到此条记录。");
                    json.setRet_code(500);
                    json.setSuccess(false);
                    response(json, response, request);
                    return;
                }

                // 校验 负责人
                if (!checkResponsible(responsible, responsible_db, "", userId, usercode, request, response)) {
                    return;
                }

                // 如果这个网段下面的 IP ，有被使用了， 也不可以去更新。
                DevIpDistributionBean bean2 = new DevIpDistributionBean();
                bean2.setIsUseInteger(1);
                bean2.setIpSegment(devIpSegmentDistributionBean.getIp());
                bean2.setOperationType("update");
                Integer total2 = iPDistributionInfoService.countDevIpDistribution(bean2, null, null);

                if (total2 > 0) {
                    // 没有权限
                    json.setCollect(null);
                    json.setData(null);
                    json.setRet_info("此网段下的IP已有被使用，不能进行修改。");
                    json.setRet_code(500);
                    json.setSuccess(false);
                    response(json, response, request);
                    return;
                }


                obj.put("ipSegment", list.get(0).getIp());
                obj.put("operationTypeInteger", 2);
                obj.put("address", list.get(0).getAddress());


                //构建 IP网段 Bean

                devIpSegmentDistributionBeanList.add(createDevIpSegmentDistribution(obj.toJSONString()));


                // 构建 IpDistribution Bean
                // 记录ip地址对应的IP网段
                Map<String, String> ipSegmentMap = new HashMap<String, String>();
                ipSegmentMap.clear();
                ipSegmentMap.put(devIpSegmentDistributionBean.getIp(), devIpSegmentDistributionBean.getIp());

                devIpDistributionBeanList.addAll(createIpDistributionBean(ipSegmentMap, obj.toJSONString()));


            }


            //修改与增加  IP 网段信息
            if (devIpSegmentDistributionBeanList != null && devIpSegmentDistributionBeanList.size() > 0) {
                iPDistributionInfoService.editIpSegmentDistribution(devIpSegmentDistributionBeanList);
                iPDistributionInfoService.saveIpSegmentDistribution(devIpSegmentDistributionBeanList);
            }


            //修改与增加  IP信息
            if (devIpDistributionBeanList != null && devIpDistributionBeanList.size() > 0) {
                iPDistributionInfoService.saveDevIpDistribution(devIpDistributionBeanList);
            }

            json.setRet_info("成功");
            json.setRet_code(201);
            response(json, response, request);


        } catch (Exception e) {
            response(e, "修改数据出错", request, response);
        }

    }

    /**
     * 修改IP接口
     *
     * @param jsonStr
     * @param request
     * @param response
     */
    @RequestMapping(value = "/deviceAutomation/ip_distribution/v1/dataUpdate", method = RequestMethod.POST, produces = "application/json")
    public void dataUpdateIpDistribution(@RequestBody String jsonStr, HttpServletRequest request, HttpServletResponse response) {
        Json json = new Json();
        logger.info("/deviceAutomation/ip_distribution/v1/dataUpdate 入参是：" + jsonStr);
        JSONObject obj = JSONObject.parseObject(jsonStr);
        String idOrIPDataType = "";

        List<DevIpDistributionBean> devIpDistributionBeanList = new ArrayList<DevIpDistributionBean>();
        DevIpDistributionBean devIpDistributionBean_one = new DevIpDistributionBean();

        //数据库中 id 的值。因为修改时，会根据页面传过来的IP或ID值去数据库中查询是否有这条记录。所以方便操作，查询到记录后，统一用数据库中的ID 去更新记录。
        HashSet<String> idValues_db = new HashSet<String>();

        try {
            String userId = obj.getString("userId");
            String remark = obj.getString("remark");
            String useType = obj.getString("useType");
            String responsible = obj.getString("responsible");
            String subnetMask = obj.getString("subnetMask");
            String vlan = obj.getString("vlan");
            String gateway = obj.getString("gateway");
            String userName = obj.getString("userName");
            String usercode = obj.getString("usercode");
            String systemName = obj.getString("systemName");
            Integer ipType = obj.getInteger("ipType");
            String ip = "";

            String ipSegment = "";


            JSONArray idOrIPDataJSONArray = new JSONArray(); // ip 或 id 参数 数组。
            if (obj.containsKey("id")) {
                idOrIPDataJSONArray = obj.getJSONArray("id");
                idOrIPDataType = "id";
            }
            if (obj.containsKey("ip")) {
                idOrIPDataJSONArray = obj.getJSONArray("ip");
                idOrIPDataType = "ip";
            }


            for (Iterator iterator = idOrIPDataJSONArray.iterator(); iterator.hasNext(); ) {

                DevIpDistributionBean devIpDistributionBean = new DevIpDistributionBean();

                String idOrIPData = (String) iterator.next();

                if (idOrIPData == null) {

                    response(new Exception(), "id或IP参数异常，请核实", request, response);
                    return;
                }


                if (idOrIPDataType.equals("ip")) {
                    devIpDistributionBean.setIp(idOrIPData);
                    ip = idOrIPData;

                } else {
                    devIpDistributionBean.setId(idOrIPData);
                    devIpDistributionBean_one.setId(idOrIPData);
                }


                // 根据ID 去查询记录，
                List<DevIpDistributionBean> list = iPDistributionInfoService
                        .findDevIpDistribution(devIpDistributionBean, null, null, null, null, null);

                String responsible_db = "";
                DevIpDistributionBean responsibleDevIpDistributionBean = null;
                // 判断是否有记录
                if (list.size() > 0) {
                    responsibleDevIpDistributionBean = list.get(0);
                    idValues_db.add(responsibleDevIpDistributionBean.getId());
                    responsible_db = responsibleDevIpDistributionBean.getResponsible() == null ? ""
                            : responsibleDevIpDistributionBean.getResponsible();
                    //这里只取最后一条记录的 ipSegment；
                    ipSegment = responsibleDevIpDistributionBean.getIpSegment();
                } else {
                    json.setCollect(null);
                    json.setData(null);
                    json.setRet_info("没有找到相关记录：" + idOrIPDataType + " " + idOrIPData);
                    json.setRet_code(500);
                    json.setSuccess(false);
                    response(json, response, request);
                    return;
                }

                // 校验 负责人权限
                if (!checkResponsible(responsible, responsible_db, responsibleDevIpDistributionBean.getIsUse(), userId, usercode, request, response)) {
                    return;
                }

                // 判断是否有 责任人， 如果有，则IP为实占。
                if (!StringUtils.isEmpty(responsible) ||  responsibleDevIpDistributionBean.getIsUseInteger()==1) {
                    devIpDistributionBean.setIsUseInteger(1);
                    devIpDistributionBean.setResponsible(responsible);
                } else {
                    //默认情况下为 未使用
                    devIpDistributionBean.setIsUseInteger(0);
                    devIpDistributionBean.setResponsible(null);

                    // 2网关地址；3广播地址；4预留地址
                    if (ipType != null && (ipType == 2 || ipType == 3 || ipType == 4)) {
                        devIpDistributionBean.setIsUseInteger(1);
                    }
                }


                devIpDistributionBean.setAddress(responsibleDevIpDistributionBean.getAddress());
                devIpDistributionBean.setNetworkType(responsibleDevIpDistributionBean.getNetworkType());
                devIpDistributionBean.setUseType(useType);
                devIpDistributionBean.setIpSegment(responsibleDevIpDistributionBean.getIpSegment());
                devIpDistributionBean.setIp(responsibleDevIpDistributionBean.getIp());

                devIpDistributionBean.setRemark(remark);
                devIpDistributionBean.setUpdate_user(userId);

                devIpDistributionBean.setUpdate_user(userId);
                devIpDistributionBean.setUpdateUserInfo(
                        (usercode == null ? "" : usercode) + "/" + (userName == null ? "" : userName));
                devIpDistributionBean.setRemark(remark);
                devIpDistributionBean.setVlan(vlan);
                devIpDistributionBean.setSubnetMask(subnetMask);
                devIpDistributionBean.setGateway(gateway);


                devIpDistributionBean.setNewId(StringUtil.getUuid());
                devIpDistributionBean.setSystemName(systemName);

                devIpDistributionBean.setOperationTypeInteger(2);
                devIpDistributionBean.setIpType(ipType == null ? 1 : ipType);



                devIpDistributionBeanList.add(devIpDistributionBean);


                devIpDistributionBean_one.setIpSegment(responsibleDevIpDistributionBean.getIpSegment());

            }

            if (idValues_db.size() > 0) {
                iPDistributionInfoService.editIpDistribution(idValues_db);

                iPDistributionInfoService.saveDevIpDistribution(devIpDistributionBeanList);
            }

            if (!"".equals(ipSegment)) {
                iPDistributionInfoService.updateIpSegmentDistribution(ipSegment);
            }

            json.setRet_info("成功");
            json.setRet_code(201);
            response(json, response, request);
        } catch (Exception e) {
            response(e, "修改数据出错", request, response);

        }

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
        String userId = obj.getString("userId");
        String userName = obj.getString("userName");
        String usercode = obj.getString("usercode");

        JSONArray dataJSONArray = obj.getJSONArray("data");
        try {

            // 根据 ID 在 dev_ip_segment_distribution 网中 查询 IP
            DevIpSegmentDistributionBean devIpSegmentDistributionBean = new DevIpSegmentDistributionBean();
            devIpSegmentDistributionBean.setId(ID);
            List<DevIpSegmentDistributionBean> list = iPDistributionInfoService
                    .findDevIpSegmentDistribution(devIpSegmentDistributionBean, null, null, null, null, null);

            if (list != null && list.size() == 1) {

                // 校验 删除权限
                if (!checkDelete(obj, request, response)) {
                    return;
                }

                devIpSegmentDistributionBean.setIpSegment(list.get(0).getIp());
                devIpSegmentDistributionBean.setUpdateUserInfo(usercode + "/" + userName);
                devIpSegmentDistributionBean.setUpdate_user(userId);

                // 查找 这个IP 段中是否有实占的记录

                DevIpDistributionBean bean = new DevIpDistributionBean();
                bean.setIpSegment(list.get(0).getIp());
                bean.setIsUseInteger(1);
                bean.setOperationType("delete");
                Integer total = iPDistributionInfoService.countDevIpDistribution(bean, null, null);
                if (total > 0) {
                    json.setCollect(null);
                    json.setData(null);
                    json.setRet_info("此网段已有相关IP被分配，不能被删除");
                    json.setRet_code(500);
                    json.setSuccess(false);
                } else {
                    iPDistributionInfoService.deleteIpSegmentDistribution(devIpSegmentDistributionBean);
                    json.setRet_info("成功");
                    json.setRet_code(201);
                }

            } else {
                json.setCollect(null);
                json.setData(null);
                json.setRet_info("没有找到此记录");
                json.setRet_code(500);
                json.setSuccess(false);
            }

            response(json, response, request);

        } catch (Exception e) {
            response(e, "修改数据出错", request, response);
        }

    }

    /**
     * 统计 ip网段和ip记录的条数
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "/deviceAutomation/dev_ip_segment_ip_count/v1/dataInfo", method = RequestMethod.GET, produces = "application/json")
    public void dev_ip_segment_ip_count(HttpServletRequest request, HttpServletResponse response) {
        Json json = new Json();
        List<MenuBean> ipSegmentAndIPMenulist = new ArrayList<MenuBean>();
        logger.info("查询 入参是：" + request.getQueryString());
        try {
            MenuBean menuBean = new MenuBean();
            // ip 网段 菜单信息
            menuBean.setFunctionsModeNumber("15");
            List<MenuBean> ipSegmentMenulist = iPDistributionInfoService.findMenu(menuBean);
            if (ipSegmentMenulist != null && ipSegmentMenulist.size() > 0) {
                // ip 网段记录条数
                DevIpSegmentDistributionBean bean = new DevIpSegmentDistributionBean();
                Integer total = iPDistributionInfoService.countDevIpSegmentDistribution(bean, null, null);
                MenuBean ipSegmentMenuBean = ipSegmentMenulist.get(0);
                ipSegmentMenuBean.setBadge(total.toString());
                ipSegmentAndIPMenulist.add(ipSegmentMenuBean);
            }

            // ip 菜单信息
            menuBean.setFunctionsModeNumber("16");
            List<MenuBean> ipMenulist = iPDistributionInfoService.findMenu(menuBean);
            if (ipMenulist != null && ipMenulist.size() > 0) {
                // ip 记录条数
                DevIpDistributionBean bean2 = new DevIpDistributionBean();
                Integer total2 = iPDistributionInfoService.countDevIpDistribution(bean2, null, null);
                MenuBean ipMenuBean = ipMenulist.get(0);
                ipMenuBean.setBadge(total2.toString());
                ipSegmentAndIPMenulist.add(ipMenuBean);
            }

            response(ipSegmentAndIPMenulist, "查询成功", request, response);

        } catch (Exception e) {
            response(e, "查询数据出错", request, response);
        }

    }


    /**
     * 核验 ip 网段是否已录入过
     *
     * @param ipSegment  网段
     * @param subnetMask 掩码
     * @param request
     * @param response
     */
    public boolean checkCountDevIpSegmentDistribution(String ipSegment, String subnetMask, HttpServletRequest request,
                                                      HttpServletResponse response) {

        boolean returnValue = false;
        // 根据 IP网段去查， 是否有记录，如果有记录，则不进行插入操作。
        DevIpSegmentDistributionBean devIpSegmentDistributionBean_select = new DevIpSegmentDistributionBean();
        devIpSegmentDistributionBean_select.setIpSegment(ipSegment);
        devIpSegmentDistributionBean_select.setSubnetMask(subnetMask);
        Integer total = iPDistributionInfoService.countDevIpSegmentDistribution(devIpSegmentDistributionBean_select,
                null, null);
        Json json = new Json();
        if (total > 0) {
            json.setCollect(null);
            json.setData(null);
            json.setRet_info("网段:" + ipSegment + "/" + subnetMask + ",已录入过，请核实。");
            json.setRet_code(200);
            json.setSuccess(false);
            response(json, response, request);
            returnValue = true;
        }
        return returnValue;
    }

    /**
     * 校验 责任人
     *
     * @param responsible    页面上填写的 责任人
     * @param responsible_db 数据库中这条记录所对应的 责任人
     * @param userId
     * @param isUse
     * @param usercode
     * @param request
     * @param response
     * @return
     */
    public boolean checkResponsible(String responsible, String responsible_db, String isUse, String userId, String usercode,
                                    HttpServletRequest request, HttpServletResponse response) {

        boolean returnValue = false;
        Json json = new Json();

        // 超级管理员 有所有可修改的权限。
        if (iPDistributionInfoService.findUserRole("超级管理员", userId) > 0) {
            returnValue = true;
            return returnValue;
        }

        // 如果 原记录的负责人已有值，则不可以进行修改。如果登陆账号就是负责人除外
        if (responsible_db!=null && responsible_db.contains(usercode)) {
            returnValue = true;
            return returnValue;

        }

        // 当参数 传过来的负责人有值时
        if (responsible != null && responsible.length() > 0) {

            //  如果数据库中 原记录的负责人没有值，则需要去校验是否有权限，才能去修改。
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
                    return returnValue;
                }

            } else {

                // 如果数据库中  原记录的负责人已有值，则不可以进行修改。如果登陆账号就是负责人除外
                if (!responsible_db.contains(usercode)) {
                    // 没有权限
                    json.setCollect(null);
                    json.setData(null);
                    json.setRet_info("此记录已有相关负责人，不能进行修改。");
                    json.setRet_code(500);
                    json.setSuccess(false);
                    response(json, response, request);
                    return returnValue;

                }
            }

        } else {

            if (isUse != null && "使用".equals(isUse)) {
                    // 没有权限
                    json.setCollect(null);
                    json.setData(null);
                    json.setRet_info("此用户没有修改权限");
                    json.setRet_code(500);
                    json.setSuccess(false);
                    response(json, response, request);
                    returnValue = false;

            } else {
                returnValue = true;
            }

            return returnValue;
        }
        returnValue = true;
        return returnValue;
    }

    /**
     * 校验 当networkType 发生变化时， 是否有权限进行修改
     *
     * @param obj
     * @param db_devIpSegmentDistributionBean
     * @param request
     * @param response
     * @return
     */
    public boolean checkRole(JSONObject obj, DevIpSegmentDistributionBean db_devIpSegmentDistributionBean,
                             HttpServletRequest request, HttpServletResponse response) {

        boolean returnValue = false;
        Json json = new Json();

        String userId = obj.getString("userId");
        String networkType = obj.getString("networkType");


        // 判断是否是超级管理员
        if (iPDistributionInfoService.findUserRole("超级管理员", userId) < 1) {
            // 不是超级管理员的情况下
            // 判断 networkType useType devType 的值是否发生了变化
            if (!networkType.equals(db_devIpSegmentDistributionBean.getNetworkType())) {
                json.setCollect(null);
                json.setData(null);
                json.setRet_info("此用户没有修改权限");
                json.setRet_code(500);
                json.setSuccess(false);
                response(json, response, request);
                return returnValue;

            }

        }

        returnValue = true;
        return returnValue;
    }

    /**
     * 删除时，进行权限校验 ，只有 超级管理员 才能删除。
     *
     * @param obj
     * @param request
     * @param response
     * @return
     */
    public boolean checkDelete(JSONObject obj, HttpServletRequest request, HttpServletResponse response) {

        boolean returnValue = false;
        Json json = new Json();

        String userId = obj.getString("userId");

        // 判断是否是超级管理员
        if (iPDistributionInfoService.findUserRole("超级管理员", userId) < 1) {
            // 不是超级管理员的情况下

            json.setCollect(null);
            json.setData(null);
            json.setRet_info("此用户没有修改权限");
            json.setRet_code(500);
            json.setSuccess(false);
            response(json, response, request);
            return returnValue;

        }

        returnValue = true;
        return returnValue;
    }


    /**
     * 将selectColumnName 拆分后转换成 DevIpSegmentDistributionBean
     *
     * @param selectColumnName
     * @param value
     * @return
     */
    public DevIpSegmentDistributionBean parDevIpSegmentDistributionBean(String selectColumnName, String value) {
        DevIpSegmentDistributionBean per = new DevIpSegmentDistributionBean();
        try {
            if(selectColumnName == null && (value==null || "".equals(value.trim())  )){
                return per;
            }

            if (selectColumnName == null) {
                selectColumnName="remark,ip_Segment,address,network_Type,use_Type,vlan,gateway";
            }

            String[] selectColumnNameString = selectColumnName.split(",");


            if (selectColumnNameString != null && selectColumnNameString.length > 0) {
                Class<?> demo1 = null;
                demo1 = Class.forName("com.sunrun.entity.DevIpSegmentDistributionBean");

                //创建实例
                Object devIpSegmentDistributionBean = demo1.newInstance();

                //读取 DevIpDistributionBean 中的各个属性名称。放入 map 中。
                Field[] fields = per.getClass().getDeclaredFields();
                String[] fieldNames = new String[fields.length];
                Map<String, String> infoMap = new HashMap<String, String>();
                for (int i = 0; i < fields.length; i++) {
                    infoMap.put(fields[i].getName(), fields[i].getName());
                }

                for (String cloum : selectColumnNameString) {
                    String cloumName = StringUtil.filedConvertProperty(cloum);
                    if (infoMap.containsKey(cloumName)) {
                        //获得id 属性
                        Field a = demo1.getDeclaredField(cloumName);
                        a.setAccessible(true);
                        //给id 属性赋值
                        a.set(devIpSegmentDistributionBean, value);
                    }
                }


                per = (DevIpSegmentDistributionBean) devIpSegmentDistributionBean;


            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return per;

    }


    /**
     * 将selectColumnName 拆分后转换成 DevIpDistributionBean
     *
     * @param selectColumnName
     * @param value
     * @return
     */
    public DevIpDistributionBean parDevIpDistributionBean(String selectColumnName, String value) {
        DevIpDistributionBean per = new DevIpDistributionBean();
        try {
            if(selectColumnName == null && (value==null || "".equals(value.trim())  )){
                return per;
            }

            if (selectColumnName == null) {
                selectColumnName ="remark,ip,address,netwk_Type,use_Type,system_Name,responsible";
            }

            String[] selectColumnNameString = selectColumnName.split(",");
            if (selectColumnNameString != null && selectColumnNameString.length > 0) {
                Class<?> demo1 = null;
                demo1 = Class.forName("com.sunrun.entity.DevIpDistributionBean");

                //创建实例
                Object devIpDistributionBean = demo1.newInstance();

                //读取 DevIpDistributionBean 中的各个属性名称。放入 map 中。
                Field[] fields = per.getClass().getDeclaredFields();
                String[] fieldNames = new String[fields.length];
                Map<String, String> infoMap = new HashMap<String, String>();
                for (int i = 0; i < fields.length; i++) {
                    infoMap.put(fields[i].getName(), fields[i].getName());
                }

                //根据selectColumnNameString，把值赋给各个属性。
                for (String cloum : selectColumnNameString) {
                    String cloumName = StringUtil.filedConvertProperty(cloum);
                    if (infoMap.containsKey(cloumName)) {
                        //获得id 属性
                        Field a = demo1.getDeclaredField(cloumName);
                        a.setAccessible(true);
                        //给id 属性赋值
                        a.set(devIpDistributionBean, value);
                    }
                }

                per = (DevIpDistributionBean) devIpDistributionBean;


            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return per;

    }


    /**
     * 查询IP操作历史记录信息
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "/ip_distribution/v1/historyDataInfo", method = RequestMethod.GET, produces = "application/json")
    public void ip_distribution_historyDataInfo(HttpServletRequest request,
                                                HttpServletResponse response, @RequestParam(value = "ip", required = false) String ip) {


        JSONObject paramObj = StringUtil.getParaTOJsonString(request.getQueryString());


        logger.info("查询 入参是：" + request.getQueryString());
        try {

            DevIpDistributionBean bean = new DevIpDistributionBean();

            bean.setIp(ip);

            List<DevIpDistributionBean> list = iPDistributionInfoService.ip_distribution_historyDataInfo(bean);

            response(list, "查询成功", request, response);

        } catch (Exception e) {
            response(e, "查询数据出错", request, response);
        }

    }


    /**
     * 查询IP网段操作历史记录信息
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "/ip_segment_distribution/v1/historyDataInfo", method = RequestMethod.GET, produces = "application/json")
    public void ipSegment_distribution_historyDataInfo(HttpServletRequest request,
                                                       HttpServletResponse response, @RequestParam(value = "ipSegment", required = false) String ipSegment) {

        JSONObject paramObj = StringUtil.getParaTOJsonString(request.getQueryString());


        if (ipSegment != null && ipSegment.contains("/")) {
            String[] ipsegmentSplit = ipSegment.split("/");
            ipSegment = ipsegmentSplit[0];
        }


        logger.info("查询 入参是：" + request.getQueryString());
        try {

            DevIpSegmentDistributionBean bean = new DevIpSegmentDistributionBean();
            bean.setIpSegment(ipSegment);
            List<DevIpSegmentDistributionBean> list = iPDistributionInfoService.ipSegment_distribution_historyDataInfo(bean);
            response(list, "查询成功", request, response);

        } catch (Exception e) {
            response(e, "查询数据出错", request, response);
        }

    }

    /**
     * 生成 IP网段
     *
     * @param ipSegment
     * @param subnetMask
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public Map<String, String> getIPSegmentMap(String ipSegment, String subnetMask, HttpServletRequest request, HttpServletResponse response) throws Exception {

        // 记录ip地址对应的IP网段
        Map<String, String> ipSegmentMap = new HashMap<String, String>();
        // 开始IP
        String startIP = IPPoolUtil.getStartIPString(ipSegment, Integer.parseInt(subnetMask));
        // 结束IP
        String endIP = IPPoolUtil.getEndIPString(ipSegment, Integer.parseInt(subnetMask));

        long ip1 = PrintIP.getIP(InetAddress.getByName(startIP));
        long ip2 = PrintIP.getIP(InetAddress.getByName(endIP));

        // 得到 开始IP 与 结束IP 之间所有的24位掩码的网段。
        for (long myip = ip1; myip <= ip2; myip++) {
            String ip = PrintIP.toIP(myip).getHostAddress();

            if (!ipSegmentMap.containsKey(PrintIP.IpSegment(ip))) {
                ipSegmentMap.put(PrintIP.IpSegment(ip), PrintIP.IpSegment(ip));
            }
        }
        return ipSegmentMap;
    }

    /**
     * 生成IP记录Bean
     *
     * @param ipSegmentMap
     * @param jsonStr
     * @throws Exception
     */
    public List<DevIpDistributionBean> createIpDistributionBean(Map<String, String> ipSegmentMap, String jsonStr) throws Exception {
        List<DevIpDistributionBean> devIpDistributionBeanList = new ArrayList<DevIpDistributionBean>();
        Json json = new Json();
        JSONObject obj = JSONObject.parseObject(jsonStr);

        String userId = obj.getString("userId");
        String address = obj.getString("address");
        String networkType = obj.getString("networkType");
        String useType = obj.getString("useType");
        String remark = obj.getString("remark");
        String responsible = obj.getString("responsible");
        String userName = obj.getString("userName");
        String usercode = obj.getString("usercode");

        String gateway = obj.getString("gateway");
        String vlan = obj.getString("vlan");
        String campOn = obj.getString("campOn");
        //因为 修改IP网段时， 也会调用 此方法， 会传operationTypeInteger值过来
        String operationTypeInteger = obj.getString("operationTypeInteger");

        try {
            // 循环网段
            Iterator ipSegmentMapIterator = ipSegmentMap.keySet().iterator();

            // 对重新计算过的网段进行 1)网段信息录入 2）网段拆解成IP
            while (ipSegmentMapIterator.hasNext()) {
                Object ipSegmentKey = ipSegmentMapIterator.next();

                // --- 根据重新分割过的网段 ，来计算 新的 开始IP 、结束IP
                // 开始IP
                String startIP3 = IPPoolUtil.getStartIPString(ipSegmentMap.get(ipSegmentKey), 24);
                // 结束IP
                String endIP4 = IPPoolUtil.getEndIPString(ipSegmentMap.get(ipSegmentKey), 24);

                // 把 ip 地址 变成 long 对角，方便下面的 for 循环。
                long ip3 = PrintIP.getIP(InetAddress.getByName(startIP3));
                long ip4 = PrintIP.getIP(InetAddress.getByName(endIP4));

                for (long myip = ip3; myip < ip4; myip++) {

                    // ---------构建 ip bean
                    DevIpDistributionBean bean = new DevIpDistributionBean();
                    //
                    String ip = PrintIP.toIP(myip).getHostAddress();

                    bean.setIp(ip);

                    //根据 IP 去查询 这条记录是否存在。

                    List<DevIpDistributionBean> list = iPDistributionInfoService
                            .findDevIpDistribution(bean, null, null, null, null, null);
                    // 判断是否有记录
                    if (list.size() > 0) {
                        bean = list.get(0);

                    } else {

                        bean.setUseType(useType);
                        bean.setIpSegment(PrintIP.IpSegment(ip));
                        bean.setIpType(1);
                    }

                    bean.setAddress(address);
                    bean.setNetworkType(networkType);
                    bean.setUseType(useType);
                    bean.setUpdate_user(userId);
                    bean.setRemark(remark);
                    bean.setUpdateUserInfo(usercode + "/" + userName);
                    bean.setVlan(vlan);
                    bean.setGateway(gateway);


                    if (operationTypeInteger != null) {
                        bean.setOperationTypeInteger(Integer.parseInt(operationTypeInteger));
                    } else {
                        bean.setOperationTypeInteger(1);
                    }


                    // 判断是否有 责任人， 如果有，则IP为实占。
                    if (responsible != null && responsible.trim().length() > 0) {
                        bean.setIsUseInteger(1);
                        bean.setResponsible(responsible);
                    } else {
                        bean.setIsUseInteger(0);
                    }

                    // 判断是否有为预占
                    if (campOn != null && "1".equals(campOn)) {

                        bean.setCampOn(1);
                        if(responsible==null || responsible.trim().length()<1){
                            bean.setIsUseInteger(1);
                        }
                    } else {
                        bean.setCampOn(0);
                    }


                    bean.setId(StringUtil.getUuid());
                    devIpDistributionBeanList.add(bean);
                }


            }


        } catch (Exception e) {
            throw e;
        }

        return devIpDistributionBeanList;

    }


    /**
     * 生成IP网段记录Bean
     *
     * @param jsonStr
     * @throws Exception
     */
    public DevIpSegmentDistributionBean createDevIpSegmentDistribution(String jsonStr) throws Exception {
        DevIpSegmentDistributionBean devIpSegmentDistributionBean = new DevIpSegmentDistributionBean();
        Json json = new Json();

        try {
            JSONObject obj = JSONObject.parseObject(jsonStr);
            String userId = obj.getString("userId");
            String address = obj.getString("address");
            String networkType = obj.getString("networkType");
            String useType = obj.getString("useType");
            String remark = obj.getString("remark");
            String responsible = obj.getString("responsible");
            String userName = obj.getString("userName");
            String usercode = obj.getString("usercode");
            String ipSegment = obj.getString("ipSegment");
            String gateway = obj.getString("gateway");
            String vlan = obj.getString("vlan");
            String campOn = obj.getString("campOn");
            //因为 修改IP网段时， 也会调用 此方法， 会传operationTypeInteger值过来
            String operationTypeInteger = obj.getString("operationTypeInteger");


            if (operationTypeInteger != null) {
                devIpSegmentDistributionBean.setOperationTypeInteger(Integer.parseInt(operationTypeInteger));
            } else {
                devIpSegmentDistributionBean.setOperationTypeInteger(1);
            }


            devIpSegmentDistributionBean.setAddress(address);
            devIpSegmentDistributionBean.setNetworkType(networkType);
            devIpSegmentDistributionBean.setUseType(useType);
            devIpSegmentDistributionBean.setRemark(remark);
            devIpSegmentDistributionBean.setVlan(vlan);
            devIpSegmentDistributionBean.setGateway(gateway);
            devIpSegmentDistributionBean.setIpSegment(ipSegment);
            devIpSegmentDistributionBean.setUpdateUserInfo(usercode + "/" + userName);
            devIpSegmentDistributionBean.setUpdate_user(userId);
            // 根据与招行许博约定，如录入的小于24的掩码，则拆分成多个 24的掩码
            devIpSegmentDistributionBean.setSubnetMask("24");


            // 根据子网掩码，算出IP 数量
            devIpSegmentDistributionBean.setAllIp(IPPoolUtil.getPoolMax(24));

            // 判断是否有 责任人， 如果有，则IP为实占。
            if (responsible != null && responsible.trim().length() > 0) {
                devIpSegmentDistributionBean.setUsedIp(IPPoolUtil.getPoolMax(24));
                devIpSegmentDistributionBean.setResponsible(responsible);
            } else {
                devIpSegmentDistributionBean.setUsedIp(0);
            }

            // 判断是否有为预占
            if (campOn != null && "1".equals(campOn)) {
                devIpSegmentDistributionBean.setUsedIp(IPPoolUtil.getPoolMax(24));
                devIpSegmentDistributionBean.setCampOn(1);
            } else {
                devIpSegmentDistributionBean.setUsedIp(0);
                devIpSegmentDistributionBean.setCampOn(0);
            }


            devIpSegmentDistributionBean.setId(StringUtil.getUuid());

        } catch (Exception e) {
            throw e;
        }

        return devIpSegmentDistributionBean;

    }


}
