CREATE TABLE dev_port_command_info (
	id VARCHAR(32) NOT NULL COMMENT '主键',
	task_id varchar(32) not null COMMENT '外键，引用端口开通工单表的主键',
	handler_name VARCHAR(100) COMMENT '处理人名称 ',
	switchboard_ip VARCHAR(20) COMMENT '交换机IP',
	port_mode_vlan VARCHAR(800) COMMENT '端口：Eth1/11',
	command varchar(800) COMMENT '指令',
	method varchar(200) COMMENT '指令对应方法名',
	execute_state TINYINT DEFAULT 1 COMMENT '指执行的状态 1 成功 2 失败 3 未提交',
	execute_info varchar(200) COMMENT '执行结果详情', 
	
	create_time DATETIME COMMENT '创建时间',
	create_user VARCHAR(32) COMMENT '创建人员id',
	update_time DATETIME COMMENT '修改时间',
	update_user VARCHAR(32) COMMENT '修改人员id',
	state TINYINT DEFAULT 1 COMMENT '状态 0 代表已删除，1代表正常',
	PRIMARY KEY (id)
) ENGINE=INNODB DEFAULT CHARSET=UTF8 ROW_FORMAT=DYNAMIC COLLATE = UTF8_BIN COMMENT '设备端口开通工单执行详情表';