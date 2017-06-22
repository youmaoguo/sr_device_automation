package com.sunrun.service;

import java.util.Map;

import com.sunrun.entity.DevExclusiveSwitchboardConn;
import com.sunrun.entity.DevOnlineTask;
import com.sunrun.util.Json;

public interface AddSwitchDeviceService {
	
	/**添加设备第1步：
	 * 保存设备品牌、型号、主机名等基本信息
	 * @param task
	 * @return
	 */
	Json saveDeviceBaseInfo(DevOnlineTask task, String userName);
	
	/**添加设备第2步：
	 * 从看板申请ip和vlan
	 * @param thirdPartUrl
	 * @param auth
	 * @param task
	 * @return
	 */
	Json appIpAndVlan(String thirdPartUrl, String auth, DevOnlineTask task, String userName, Integer count);
	
	/**添加设备第2步：
	 * 从看板申请ip和vlan
	 * @param thirdPartUrl
	 * @param auth
	 * @param task
	 * @return
	 */
	Json appIpAndVlan2(String thirdPartUrl, String auth, DevOnlineTask task, String userName, Integer count);
	
	/**添加设备第3步：
	 * 在交换机上ping 在看板系统上申请到的IP地址，看网络是否通
	 * @param thirdPartUrl
	 * @param auth
	 * @param taskId
	 * @return
	 */
	Json pingFun(String thirdPartUrl, String auth, DevOnlineTask task, Map<String, String> map, String userName);
	
	/**添加设备第4步：
	 * 网络室管理员申请IP地址，修改IP地址状态（ip地址回填）
	 * @param thirdPartUrl
	 * @param auth
	 * @param task
	 * @return
	 */
	Json adminRequestIP(String thirdPartUrl, String auth, DevOnlineTask task, Map<String, String> map, String userName, int state, String usercode);

	/**添加设备第5步：
	 * 判断汇聚交换机端口上是否有配置及端口状态是否为down
	 * @param thirdPartUrl
	 * @param auth
	 * @param task
	 * @return
	 */
	Json portCheck(String thirdPartUrl, String auth, DevOnlineTask task, String userName);
	
	/**添加设备第6步：
	 * 生成汇聚交换机配置 并记录
	 * @param thirdPartUrl
	 * @param auth
	 * @param taskId
	 * @return
	 */
	Json CreatConverPage(String thirdPartUrl, String auth, DevOnlineTask task, Map<String, String> map, String userName);
	
	/**添加设备第7步：
	 * 生成接入交换机配置 并记录
	 * @param thirdPartUrl
	 * @param auth
	 * @param taskId
	 * @return
	 */
	Json CreatAccessPage(String thirdPartUrl, String auth, DevOnlineTask task, Map<String, String> map, String userName);
	
	/**添加设备第8步：
	 * 保存带外交换机端口与接入交换机的连接
	 * @param conn
	 * @param userName
	 * @param task
	 * @return
	 */
	Json exclusiveSwitchboardConn(DevExclusiveSwitchboardConn conn, DevOnlineTask task, String userName);
	
	/**添加设备第9步：
	 * 请求写入接入交换机配置管理口IP
	 * @param thirdPartUrl
	 * @param auth
	 * @param task
	 * @return
	 */
	Json managementPort(String thirdPartUrl, String auth, DevOnlineTask task, String userName);
	
	/**
	 * 查询交换机实际版本
	 * @param thirdPartUrl
	 * @param auth
	 * @param task
	 * @param userName
	 * @return
	 */
	Json findDeviceIosVersion(String thirdPartUrl, String auth, DevOnlineTask task, String userName);
	
	/**添加设备第10步：
	 * 查看ios版本是否最新，不是最新需要升级ios版本
	 * @param thirdPartUrl
	 * @param auth
	 * @param taskId
	 * @return
	 */
	Json checkIosVersion(String thirdPartUrl, String auth, DevOnlineTask task, String userName);
	
	/**添加设备第11步：
	 * 写入接入交换机配置
	 * @param thirdPartUrl
	 * @param auth
	 * @param taskId
	 * @return
	 */
	Json writeAccessConfig(String thirdPartUrl, String auth, String taskId, String userName);
	
	/**添加设备第11步：(new)
	 * 写入接入交换机配置(new)
	 * @param thirdPartUrl
	 * @param auth
	 * @param task
	 * @param userName
	 * @return
	 */
	Json writeNewAccessConfig(String thirdPartUrl, String auth, DevOnlineTask task, String userName);

	
	
	/**添加设备第12步：
	 * 上线交换机邮件发送通知
	 * @param thirdPartUrl
	 * @param auth
	 * @param taskId
	 * @return
	 */
	Json SendEmailswitchDevice(String thirdPartUrl, String auth, String[] taskId, String emails, String names, String title, String content, String userName);
	
	/**添加设备第13步：
	 * 上线交换机ITIL工单申请
	 * @param thirdPartUrl
	 * @param auth
	 * @param taskId
	 * @return
	 */
	Json switchDeviceITIL(String thirdPartUrl, String itilPlannedEnd, String[] taskId, String userName, String usercode);
	
	/**添加设备第14步：
	 * 写入汇聚交换机配置
	 * @param thirdPartUrl
	 * @param auth
	 * @param taskId
	 * @return
	 */
	Json writeGatherConfig(String thirdPartUrl, String auth, String taskId, String userName);
	
	/**添加设备第14步：(new)
	 * 写入汇聚交换机配置(new)
	 * @param thirdPartUrl
	 * @param auth
	 * @param taskId
	 * @return
	 */
	Json writeNewGatherConfig(String thirdPartUrl, String auth, DevOnlineTask task, String userName);
	
	
	/**添加设备第15步：
	 * 在汇聚交换机和接入交换机写入配置后，对现网的情况进行检验排错
	 * @param thirdPartUrl
	 * @param auth
	 * @param task
	 * @return
	 */
	Json checkConfig(String thirdPartUrl, String auth, DevOnlineTask task, String userName);
	
	/**添加设备第15步：(new)
	 * 在汇聚交换机和接入交换机写入配置后，对现网的情况进行检验排错(new)
	 * @param thirdPartUrl
	 * @param auth
	 * @param task
	 * @return
	 */
	Json checkNewConfig(String thirdPartUrl, String auth, DevOnlineTask task, String userName);

	void writeProcess(DevOnlineTask t,  Integer executeStep, String info, boolean success, String userName, String taskExecuteNote);
	
	
}
