-- auto Generated on 2020-03-05
-- DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`(
	id INT (11) NOT NULL AUTO_INCREMENT COMMENT 'id',
	username VARCHAR (50) UNIQUE NOT NULL DEFAULT '' COMMENT 'username',
	`password` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'password',
	`role` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'role',
	PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 'user';
