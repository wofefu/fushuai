create schema if not exists store_sales collate utf8_general_ci;

create table goods_sort
(
    id bigint auto_increment comment '分类编号'
        primary key,
    name varchar(255) not null comment '分类名称'
)
    comment '商品分类表';

create table goods_detail
(
    id bigint auto_increment comment '编号'
        primary key,
    sortId bigint not null comment '分类编号',
    name varchar(255) not null comment '商品名称',
    address varchar(255) not null comment '产地',
    price float(10,2) not null comment '单价有效位数为 10，小
数位数为 2',
    createDate datetime not null comment '生产日期 ',
    remaining int not null comment '剩余数量 ',
    constraint `goods_detail _goods_sort_id_fk`
        foreign key (sortId) references goods_sort (id)
)
    comment '商品明细表';


INSERT INTO store_sales.goods_detail (id, sortId, name, address, price, createDate, remaining) VALUES (1, 1, '毛笔', '安徽', 12, '2020-04-17 04:47:52', 10);
INSERT INTO store_sales.goods_detail (id, sortId, name, address, price, createDate, remaining) VALUES (2, 1, '铅笔盒', '江苏', 20, '2020-04-17 04:48:39', 30);
INSERT INTO store_sales.goods_detail (id, sortId, name, address, price, createDate, remaining) VALUES (3, 2, '台灯', '安徽', 30, '2020-04-17 04:49:11', 10);
INSERT INTO store_sales.goods_detail (id, sortId, name, address, price, createDate, remaining) VALUES (4, 3, '锅巴', '海南', 10, '2020-04-17 04:49:53', 50);
INSERT INTO store_sales.goods_detail (id, sortId, name, address, price, createDate, remaining) VALUES (5, 3, '臭豆腐', '日本', 15, '2020-04-17 04:50:37', 30);
INSERT INTO store_sales.goods_detail (id, sortId, name, address, price, createDate, remaining) VALUES (6, 4, '拖把', '江苏', 30, '2020-04-17 04:51:30', 60);
INSERT INTO store_sales.goods_sort (id, name) VALUES (1, '文具');
INSERT INTO store_sales.goods_sort (id, name) VALUES (2, '小电器');
INSERT INTO store_sales.goods_sort (id, name) VALUES (3, '零食');
INSERT INTO store_sales.goods_sort (id, name) VALUES (4, '日用百货');