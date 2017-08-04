CREATE TABLE dev_ios_ftp_info(                              	id varchar(32) not null comment '主键',	brand_name varchar(64) not null comment '品牌名称',	model_name varchar(64) not null comment '型号',	console_telnet_user varchar(50)   comment 'console口登录用户', 	console_telnet_pwd  varchar(50)   comment 'console口登录密码', 	telnet_type varchar(20)   comment '管理口登录协议',	telnet_user varchar(50)   comment '管理口登录用户',	telnet_port varchar(20)   comment '管理口登录端口',	telnet_pwd  varchar(50)   comment '管理口登录密码',	create_time datetime comment '创建时间',	create_user varchar(32) comment '创建人员id',	update_time datetime comment '修改时间',	update_user varchar(32) comment '修改人员id',	state tinyint default 1 comment '状态 0 代表已删除，1代表正常',	primary key (id)) ENGINE=InnoDB DEFAULT CHARSET=UTF8 ROW_FORMAT=DYNAMIC collate=utf8_bin COMMENT '各型号设备登陆ftp下载ios版本信息';