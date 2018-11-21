## 创建druid数据库
create database druid;
## 选定数据库
use druid;
## 创建简单用户表
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(22) NOT NULL COMMENT '主键',
  `name` varchar(255) NOT NULL COMMENT '用户名',
  `password` varchar(255) NOT NULL COMMENT '密码',
  `age` int(3) NOT NULL COMMENT '年龄',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
