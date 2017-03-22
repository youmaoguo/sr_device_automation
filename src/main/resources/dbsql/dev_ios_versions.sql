CREATE TABLE dev_ios_versions(                              
	id varchar(32) not null comment '主键',
	brand_name varchar(64) comment '品牌名称',
	model_name varchar(64) comment '型号',
	ios_version varchar(100) comment 'IOS版本信息',
	ios_version_2 varchar(100) comment '备用字段',
	newth_ios_version tinyint default 1 comment '是否最新版本 0 代表否，1代表是',
	create_time datetime comment '创建时间',
	create_user varchar(32) comment '创建人员id',
	update_time datetime comment '修改时间',
	update_user varchar(32) comment '修改人员id',
	state tinyint default 1 comment '状态 0 代表已删除，1代表正常',
	primary key (id)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8 ROW_FORMAT=DYNAMIC collate=utf8_bin COMMENT '设备版本库信息表';
