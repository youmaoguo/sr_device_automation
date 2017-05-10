CREATE TABLE dev_online_batch_itil(                              
	id varchar(32) not null comment '主键',
	batch_name varchar(100) comment '批次名称',
	batch_describe varchar(500) comment '批次描述',
	itil_number varchar(100) comment 'itil申请单编号 文本，唯一键 151200319843 itil系统返回',
	itil_assignee varchar(100) comment '处理人 文本00203045 必须为ITIL操作员账号，一般是员工号',
	itil_category varchar(100) comment ' 类别 文本 流程管理',
	itil_subcategory varchar(100) comment '子类别 文本 ITIL系统',
	itil_businessArea varchar(100) comment '小类别 文本 其他',
	itil_status varchar(100) comment '状态 文本 待审批 系统自动生成，无需填写',
	itil_requestor varchar(100) comment '申请人 文本 036131 联系人ID，一般为一事通ID',
	itil_title varchar(400) comment '标题 文本 评估体系平台系统请求',
	itil_description varchar(1000) comment '申请内容',
	itil_plannedEnd varchar(50) comment '期望完成时间',
	batch_state tinyint default 1 comment '批次状态 1：新建；2：执行中；3：完成;4:废除;5:失败',
	create_time datetime comment '创建时间',
	create_user varchar(32) comment '创建人员id',
	update_time datetime comment '修改时间',
	update_user varchar(32) comment '修改人员id',
	state tinyint default 1 comment '状态 0 代表已删除，1代表正常',
	primary key (id)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8 ROW_FORMAT=DYNAMIC collate=utf8_bin COMMENT '设备上线批次itil工单表';
