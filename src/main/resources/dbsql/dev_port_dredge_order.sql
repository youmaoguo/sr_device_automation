CREATE TABLE dev_port_dredge_order (
	id VARCHAR(32) NOT NULL COMMENT '主键',
	handler_name VARCHAR(100) COMMENT '处理人名称 ',
	switchboard_ip VARCHAR(20) COMMENT '交换机IP',
	port_mode_vlan VARCHAR(800) COMMENT '端口-模式-vlan 信息，格式为：Eth1/11-trunk-vlan190;Eth1/12-trunk-vlan192;',
	execute_state TINYINT DEFAULT 1 COMMENT '执行状态 1:新建；2：执行中；3：执行成功； 4：执行失败',
	create_time DATETIME COMMENT '创建时间',
	create_user VARCHAR(32) COMMENT '创建人员id',
	update_time DATETIME COMMENT '修改时间',
	update_user VARCHAR(32) COMMENT '修改人员id',
	state TINYINT DEFAULT 1 COMMENT '状态 0 代表已删除，1代表正常',
	PRIMARY KEY (id)
) ENGINE=INNODB DEFAULT CHARSET=UTF8 ROW_FORMAT=DYNAMIC COLLATE = UTF8_BIN COMMENT '设备端口开通工单表';