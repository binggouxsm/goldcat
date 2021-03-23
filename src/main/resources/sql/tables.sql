drop table if exists `account_book`;

create table `account_book` (
   `book_id`  int(20) unsigned not null auto_increment comment '账本ID',
   `name` varchar(200) comment '账本名称',
   `delflag`  tinyint unsigned comment '有效标志',
   PRIMARY KEY (`book_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 comment '账本';


drop table if exists `account`;

create table `account` (
  `account_id`  int(20) unsigned not null auto_increment comment '账户ID',
  `book_id` int(20) unsigned comment '所属账本',
  `name` varchar(200) comment '账户名称',
  `type` int(20) comment '账户类别',
  `currency`  varchar(10) comment '账户币别',
  `balance` DECIMAL(18,2) comment '账户余额',
  `delflag`  tinyint unsigned comment '有效标志',
  PRIMARY KEY (`account_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 comment '账户';


drop table if exists `balance_history`;

create table `balance_history` (
   `balance_history_id`  int(20) unsigned not null auto_increment comment '余额历史ID',
   `account_id` int(20) unsigned comment '账户',
   `hisdate` DATE comment '历史日期',
   `currency`  varchar(10) comment '账户币别',
   `balance` DECIMAL(18,2) comment '账户余额',
   `is_month` tinyint unsigned comment '是否月末',
   `is_season` tinyint unsigned comment '是否季末',
   `is_year` tinyint unsigned comment '是否年末',
   `delflag`  tinyint unsigned comment '有效标志',
   PRIMARY KEY (`balance_history_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 comment '余额历史';


drop table if exists `record`;

create table `record` (
  `record_id`  varchar(50) not null comment '记账记录ID',
  `record_type` varchar(50) comment '类型：收入、支出、转账',
  `record_type_id` int(20) comment '具体类型',
  `account_id`  varchar(50) comment '账户',
  `currency`  varchar(10) comment '币别',
  `amount` DECIMAL(18,2) comment '金额',
  `happen_time` DATETIME comment '交易事件',
  `party` varchar(300) comment '商户信息',
  `note` varchar(500) comment '备注',
  `delflag`  tinyint unsigned comment '有效标志',
  PRIMARY KEY (`record_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 comment '记账记录';

drop table if exists `type`;

create table `type` (
  `type_id`  int(20) unsigned not null auto_increment comment '类型ID',
  `name`  varchar(50) comment '类型名称',
  `note` varchar(500) comment '备注',
  `delflag`  tinyint unsigned comment '有效标志',
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
  `code`  varchar(200) comment '字典码值',
  `name`  varchar(200) comment '字典名称',
  `item_order` int(20) unsigned comment '字典顺序',
  `delflag`  tinyint unsigned default 0 comment '有效标志',
  PRIMARY KEY (`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 comment '字典表';
