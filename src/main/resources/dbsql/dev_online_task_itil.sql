CREATE TABLE dev_online_task_itil(                              
	id varchar(32) not null comment '主键',
	itil_number varchar(100) not null comment 'itil申请单编号 ',
	dev_online_task_id varchar(100) not null comment '设备上线记录对应ID',
	
	create_time datetime comment '创建时间',
	create_user varchar(32) comment '创建人员id',
	update_time datetime comment '修改时间',
	update_user varchar(32) comment '修改人员id',
	state tinyint default 1 comment '状态 0 代表已删除，1代表正常',
	primary key (id)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8 ROW_FORMAT=DYNAMIC collate=utf8_bin COMMENT '设备上线批次任务与 itil对应表';
