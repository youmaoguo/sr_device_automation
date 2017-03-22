create table dev_online_task
(
	id varchar(32) not null comment '任务id',
	batch_id varchar(32) not null comment '批次id(引用表dev_online_batch的主键)',
	task_type tinyint comment '任务类型 1：接入设备任务;2:汇聚设备任务',
	group_key varchar(100) comment '组名，用于标示多个任务属于同一组',
	task_describe varchar(500) comment '任务描述',
	task_state tinyint default 1 comment '批次任务状态 1：新建；2：执行中；3：完成;4:废除;5:失败',
	brand_name varchar(64) comment '品牌名称',
	model_name varchar(64) comment '型号',
	area_name varchar(100) comment '区域名称',
	area_describe varchar(100) comment '区域描述',
	host_name varchar(100) comment '接入交换机hostname',
	manager_ip varchar(100) comment '接入交换机管理IP',
	
	manager_ip_write tinyint default 0 comment '接入交换机写入配制状态 ；0 ：待写入，1：成功,2:失败',
	access_config_write tinyint default 0 comment '接入交换机写入配制状态 ；0 ：待写入，1：成功,2:失败',
	exclusive_switchboard_info varchar(200) comment '带外交机要信息描述',
	current_ios_version varchar(100) comment '当前IOS版本信息', 
	main_switchboard_config_write tinyint default 0 comment '主汇聚交换机写入配制状态 ；0 ：待写入，1：成功,2:失败',
	
	vlan varchar(100) comment '接入交换机将要上到哪个VLAN上',
	main_switchboard_ip varchar(20) comment '主汇聚交换机ip',
	main_switchboard_port varchar(20) comment '主汇聚交换机端口',
	backup_switchboard_ip varchar(20) comment '备汇聚交换机ip',
	backup_switchboard_port varchar(20) comment '备汇聚交换机端口',
	dev_online_rack varchar(100) comment '上线后所处机架位置描述',
	exclusive_switchboard_ip varchar(20) comment '带外交机ip',
	exclusive_switchboard_port varchar(10) comment '带外交机端口',
	
	create_time datetime comment '创建时间',
	create_user varchar(32) comment '创建人员id',
	update_time datetime comment '修改时间',
	update_user varchar(32) comment '修改人员id',
	state tinyint default 1 comment '状态 0 代表已删除，1代表正常',
	primary key (id)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8 ROW_FORMAT=DYNAMIC collate=utf8_bin COMMENT '设备上线批次任务表';
