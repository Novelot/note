Mysql学习笔记
=
## 修改utf8编码: 
##### 1. 查看当前编码: 
`show variables like '%character%';`
##### 2. 停止服务: 
`service mysql stop`
##### 3. 修改`/etc/mysql/my.cnf`,添加如下2句: 
```
character_set_server=utf8
init_connect='SET NAMES utf8'
```
##### 4. 启动服务: 
`service mysql start`

## 查看数据库编码格式
`show create database <database_name>`

## 查看表的编码格式
`show create table <table_name>`

## 修改表字段的编码格式
`ALTER TABLE <table_name> CHANGE <colum_name> <colum_name> VARCHAR(256) CHARACTER SET utf8 NOT NULL;`
