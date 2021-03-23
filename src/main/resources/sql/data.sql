-- truncate table `type`;

insert into `type` values(1, '收入支出类型',null,0);
insert into `type` values(2, '收入',null,0);
insert into `type` values(3, '支出',null,0);
insert into `type` values(4, '转账',null,0);

insert into `type_tree` values (1,1,0);
insert into `type_tree` values (1,2,1);
insert into `type_tree` values (1,3,1);
insert into `type_tree` values (1,4,1);
insert into `type_tree` values (2,2,0);
insert into `type_tree` values (3,3,0);
insert into `type_tree` values (4,4,0);


insert into `type` values(20, '账户类型',null,0);
insert into `type` values(21, '现金账户',null,0);
insert into `type` values(22, '银行卡账户',null,0);
insert into `type` values(23, '投资账户',null,0);

insert into `type_tree` values (20,20,0);
insert into `type_tree` values (20,21,1);
insert into `type_tree` values (20,22,1);
insert into `type_tree` values (20,23,1);
insert into `type_tree` values (21,21,0);
insert into `type_tree` values (22,22,0);
insert into `type_tree` values (23,23,0);


insert into `type` values(40, '资产负债类型',null,0);
insert into `type` values(41, '资产',null,0);
insert into `type` values(42, '负债',null,0);


insert into `type_tree` values (40,40,0);
insert into `type_tree` values (40,41,1);
insert into `type_tree` values (40,42,1);
insert into `type_tree` values (41,41,0);
insert into `type_tree` values (42,42,0);

insert into `type` values(99, '测试',null,0);

truncate table `dict_item`;

insert into `dict_item` (`type`, `code`, `name`, `item_order`, `delflag`) values ('CURRENCY','CNY','人民币',0,0);
insert into `dict_item` (`type`, `code`, `name`, `item_order`, `delflag`) values ('CURRENCY','USD','美元',1,0);

commit;


