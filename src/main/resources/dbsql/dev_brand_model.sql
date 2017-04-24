CREATE TABLE dev_brand_model(                              	id varchar(32) not null comment '主键',	brand_name varchar(64) comment '品牌名称',	model_name varchar(64) comment '型号',	ios_version varchar(100) comment 'IOS版本信息',	ios_version_2 varchar(100) comment '备用字段',	create_time datetime comment '创建时间',	create_user varchar(32) comment '创建人员id',	update_time datetime comment '修改时间',	update_user varchar(32) comment '修改人员id',	state tinyint default 1 comment '状态 0 代表已删除，1代表正常',	primary key (id)) ENGINE=InnoDB DEFAULT CHARSET=UTF8 ROW_FORMAT=DYNAMIC collate=utf8_bin COMMENT '设备品牌型号对应表';