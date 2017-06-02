create table dev_exclusive_switchboard_conn
(
		id varchar(32) not null comment 'id',
		exclusive_switchboard_info varchar(200) comment '带外交机要信息描述',
		exclusive_switchboard_ip varchar(20) comment '带外交机ip',
		exclusive_switchboard_port varchar(10) comment '带外交机端口',
		exclusive_switchboard_order smallint comment '带外交机顺序',
		brand_name varchar(64) comment '品牌名称',
		model_name varchar(64) comment '型号',
		current_ios_version varchar(100) comment '当前IOS版本信息',
		create_time datetime comment '创建时间',
		create_user varchar(32) comment '创建人员id',
		update_time datetime comment '修改时间',
		update_user varchar(32) comment '修改人员id',
		state tinyint default 1 comment '状态 0 代表已删除，1代表正常',
		primary key (id)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8 ROW_FORMAT=DYNAMIC collate=utf8_bin COMMENT '带外交换机连接信息表';
