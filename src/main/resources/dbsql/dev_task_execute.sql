create table dev_task_execute
(
	id varchar(32) not null comment '主键',
	task_id varchar(36) not null comment '任务id(引用表dev_online_task的id)',
	task_type tinyint comment '任务类型，此字段目前不使用，备用',
	task_order smallint default 1 comment '任务执行顺序',
	task_describe varchar(500) comment '任务描述',
	task_execute_state tinyint default 1 comment '任务执行状态 1：新建；2：执行中；3：成功;4:失败',
	task_execute_note varchar(1000) comment '脚本执行情况',
	task_execute_begin datetime comment '任务开始执行时间',
	task_execute_end datetime comment '任务执行完成时间',
	create_time datetime comment '创建时间',
	create_user varchar(32) comment '创建人员id',
	update_time datetime comment '修改时间',
	update_user varchar(32) comment '修改人员id',
	state tinyint default 1 comment '状态 0 代表已删除，1代表正常',
	primary key (id),
	foreign key(task_id) references dev_online_task(id)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8 ROW_FORMAT=DYNAMIC collate=utf8_bin COMMENT '任务执行情况表';
