create schema if not exists qsms collate utf8_general_ci;

create table classes
(
    cname varchar(255) not null comment '类别名称',
    id bigint auto_increment comment '类别编号'
        primary key
)
    comment '类别信息表';

create table faqs
(
    id bigint auto_increment comment '问题编号'
        primary key,
    title varchar(255) not null comment '标题',
    createDate date not null comment '创建时间，去系统当前时间',
    content varchar(255) not null comment '内容',
    classId bigint not null comment '类别编号',
    constraint faqs_classes_id_fk
        foreign key (classId) references classes (id)
)
    comment '常见问题表';

INSERT INTO qsms.classes (cname, id) VALUES ('C语言', 1);
INSERT INTO qsms.classes (cname, id) VALUES ('PHP', 2);
INSERT INTO qsms.classes (cname, id) VALUES ('Java语言', 3);
INSERT INTO qsms.classes (cname, id) VALUES ('c#语言', 4);
INSERT INTO qsms.faqs (id, title, createDate, content, classId) VALUES (1, 'java常见问题', '2020-03-29', '各种问题', 3);
INSERT INTO qsms.faqs (id, title, createDate, content, classId) VALUES (2, 'PHP常见问题', '2020-03-29', 'PHP问日', 2);
INSERT INTO qsms.faqs (id, title, createDate, content, classId) VALUES (3, 'C语言常见问题', '2020-03-29', 'C语言常见温柔', 1);
INSERT INTO qsms.faqs (id, title, createDate, content, classId) VALUES (4, '多个省份', '2020-03-29', '双方的公司的', 2);
INSERT INTO qsms.faqs (id, title, createDate, content, classId) VALUES (5, '东风公司法定', '2020-03-29', '阿斯顿发斯蒂芬', 1);