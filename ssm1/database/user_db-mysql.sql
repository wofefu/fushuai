drop database if exists user_db;

create database user_db default character set utf8;

use user_db;

create table t_user (
  id int primary key auto_increment,
  username varchar(60),
  password varchar(100),
  phone varchar(20),
  address varchar(200)
);