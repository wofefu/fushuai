create schema if not exists news_db collate utf8_general_ci;

create table news_category
(
    id bigint auto_increment comment '新闻分类编号'
        primary key,
    name varchar(255) not null
)
    comment '新闻分类表';

create table news_detail
(
    id bigint auto_increment comment '新闻编号'
        primary key,
    categoryId bigint not null comment '新闻分类编号',
    title varchar(255) not null comment '新闻标题',
    summary varchar(255) null comment '新闻摘要',
    author varchar(255) null comment '作者',
    createDate date not null comment '创建时间',
    updateDate date null comment '更新时间',
    constraint news_detail_news_category_id_fk
        foreign key (categoryId) references news_category (id)
)
    comment '新闻表';



INSERT INTO news_db.news_category (id, name) VALUES (1, '国际');
INSERT INTO news_db.news_category (id, name) VALUES (2, '国内');
INSERT INTO news_db.news_category (id, name) VALUES (3, '军事');
INSERT INTO news_db.news_detail (id, categoryId, title, summary, author, createDate, updateDate) VALUES (1, 1, '韩国', '韩国信管', '小红', '2020-03-31', '2020-03-31');
INSERT INTO news_db.news_detail (id, categoryId, title, summary, author, createDate, updateDate) VALUES (2, 2, '合肥', '合肥的繁荣', '小夫', '2020-03-31', '2020-03-31');
INSERT INTO news_db.news_detail (id, categoryId, title, summary, author, createDate, updateDate) VALUES (3, 2, '亳州', '亳州的美丽', '夏明', '2020-03-18', '2020-03-31');
INSERT INTO news_db.news_detail (id, categoryId, title, summary, author, createDate, updateDate) VALUES (4, 3, '军事要以', '各国军队', '小黑', '2020-03-31', '2020-03-31');