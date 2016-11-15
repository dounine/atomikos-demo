# jdbc-example
此例子演示使用`spring`的`jdbcTemplate`对两个数据库进行一至性操作

### 使用说明
1.请先创建两个数据库,分别为 `jdbc_master` 与 `jdbc_slave`

2.在两个数据库中执行如下创表语句
```
CREATE TABLE `user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```