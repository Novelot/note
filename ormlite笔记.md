# ormlite笔记 #  

# 注解  
## @DatabaseTable 表注解  
1. tableName 表名
## @DatabaseField 字段注解  
1. columnName 			
数据库表的字段名;
2. dataType   			
数据类型,默认为java类的类型,一般不需指定;
3. defaultValue 		
默认值;
4. width 				
字段长度,该参数为整型,如果修饰的字段为String,则默认为255个字符长度;
5. canBeNull			
是否可以为Null;
6. id					
是否为id字段(可理解为主键),默认为false.一个类只能有一个字段是id字段;
7. generatedId 			
是否为自动生成的id字段,默认为false.一个类只能有一个该字段;
8. generatedIdSequence 	;
9. foreign 				
是否为外键;
10. useGetSet			
是否提供get/set方法;
11. unknownEnumName  	
未知的枚举类型
12. throwIfNull 		
如果发现为null或者试图将null写入主键字段,则抛出异常;
13. persisted			
是否将该字段写入数据库,默认为true;
14. format 				
类型,目前可选的只有DATA_STRING(以时间的字符串保存)和STRING_BYTES(将字符串按字节存储);
15. unique				
是否单值唯一,不允许两条数据的值相同,如果firstName和lastNmae两个字段都设置该注解并设置为true,其中firstName="Bob",lastName="Smith",则其他记录中的firstName不能为"Bob",lastName不能为"Smith";
16. uniqueCombo			
组合值唯一,如果firstName和lastNmae两个字段都设置该注解并设置为true,其中firstName="Bob",lastName="Smith",则另一条记录不能firstName="Bob"且lastName="Smith",但可以其中之一是不同的;  
17. index 				
是否需要创建索引列(列名_idx),默认为false;
18. uniqueIndex 		;
19. indexName 			;
20. uniqueIndexName		;
21. foreignAutoRefresh	;
22. maxForeignAutoRefreshLevel	;
23. allowGeneratedIdInsert		;
24. columnDefinition			;
25. foreignAutoCreate			
自动创建外键;
26. version						;
27. foreignColumnName			;



 