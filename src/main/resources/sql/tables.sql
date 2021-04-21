drop table if exists `user_info`;

create table `user_info` (
  `user_id`  int(20) unsigned not null auto_increment comment '用户ID',
  `user_name` varchar(200) comment '用户名',
  `name` varchar(200) comment '姓名',
  `password` varchar(200) comment '用户密码',
  `validflag`  tinyint(1) unsigned default 1 comment '有效标志',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 comment '用户';


drop table if exists `account_book`;

create table `account_book` (
   `book_id`  int(20) unsigned not null auto_increment comment '账本ID',
   `name` varchar(200) comment '账本名称',
   `user_id` int(20) unsigned comment '用户ID',
   `validflag`  tinyint(1) unsigned default 1 comment '有效标志',
   PRIMARY KEY (`book_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 comment '账本';


drop table if exists `account`;

create table `account` (
  `account_id`  int(20) unsigned not null auto_increment comment '账户ID',
  `book_id` int(20) unsigned comment '所属账本',
  `name` varchar(200) comment '账户名称',
  `account_no` varchar(200) comment '账户号',
  `type` varchar(100) comment '账户类别',
  `currency`  varchar(10) comment '账户币别',
  `balance` DECIMAL(18,2) comment '账户余额',
  `month_in` DECIMAL(18,2) comment '当月收入累计金额',
  `month_out` DECIMAL(18,2) comment '当月支出累计金额',
  `month_transfer` DECIMAL(18,2) comment '当月转出累计金额',
  `validflag`  tinyint(1) unsigned default 1  comment '有效标志',
  PRIMARY KEY (`account_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 comment '账户';


drop table if exists `balance_history`;

create table `balance_history` (
   `account_id` int(20) unsigned comment '账户',
   `hisdate` DATE comment '历史日期',
   `currency`  varchar(10) comment '账户币别',
   `before_balance` DECIMAL(18,2) comment '日初账户余额',
   `balance` DECIMAL(18,2) comment '日末账户余额',
   `day_in` DECIMAL(18,2) comment '当日收入累计金额',
   `day_out` DECIMAL(18,2) comment '当日支出累计金额',
   `day_transfer` DECIMAL(18,2) comment '当日转出累计金额',
   `month_in` DECIMAL(18,2) comment '月收入累计金额',
   `month_out` DECIMAL(18,2) comment '月支出累计金额',
   `month_transfer` DECIMAL(18,2) comment '月转出累计金额',
   `is_month` tinyint(1) unsigned comment '是否月末',
   `is_season` tinyint(1) unsigned comment '是否季末',
   `is_year` tinyint(1) unsigned comment '是否年末',
   PRIMARY KEY (`account_id`, `hisdate`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 comment '余额历史';


drop table if exists `record`;

create table `record` (
  `record_id`  varchar(50) not null comment '记账记录ID',
  `record_type` int(20) comment '类型：收入、支出、转账',
  `record_type_id` int(20) comment '具体类型',
  `account_id`  int(20) comment '账户',
  `real_account_id`  int(20) comment '实际支付账户，该字段针对微信、支付宝等虚拟账户',
  `currency`  varchar(10) comment '币别',
  `amount` DECIMAL(18,2) comment '金额',
  `source` varchar(10) comment '信息来源：微信，支付宝等等',
  `happen_time` DATETIME comment '交易时间',
  `party` varchar(300) comment '商户信息',
  `product` varchar(500) comment '商品信息',
  `status` varchar(50) comment '交易状态',
  `note` varchar(500) comment '备注',
  `validflag`  tinyint(1) unsigned default 1 comment '有效标志',
  PRIMARY KEY (`record_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 comment '记账记录';



drop table if exists `file_info`;

create table `file_info`(
  `file_id` varchar(50) not null  comment '文件ID',
  `name` varchar(200) comment '文件名称',
  `address` varchar(300) comment '文件存放位置',
  `validflag`  tinyint(1) unsigned default 1 comment '有效标志',
  PRIMARY KEY (`file_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 comment '文件信息';

drop table if exists `type`;

create table `type` (
  `type_id`  int(20) unsigned not null auto_increment comment '类型ID',
  `name`  varchar(50) comment '类型名称',
  `note` varchar(500) comment '备注',
  `validflag`  tinyint(1) unsigned default 1 comment '有效标志',
  PRIMARY KEY (`type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 comment '类型';



drop table if exists `type_tree`;

create table `type_tree` (
  `ancestor`  int(20) unsigned not null comment '祖先',
  `descendant`  int(20) unsigned not null comment '后代',
  `level` int(5) unsigned not null comment '后代相对祖先的层级',
  PRIMARY KEY (`ancestor`,`descendant`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 comment '类型树结构';

drop table if exists `dict_item`;

create table `dict_item` (
  `item_id`  int(20) unsigned not null auto_increment comment '字典ID',
  `type`  varchar(50) comment '字典类型',
  `code`  varchar(100) comment '字典码值',
  `name`  varchar(200) comment '字典名称',
  `item_order` int(20) unsigned comment '字典顺序',
  `validflag`  tinyint(1) unsigned default 1 comment '有效标志',
  PRIMARY KEY (`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 comment '字典表';
