RxAndroid
=
# 操作符 
---
from :将其他种类的对象和数据类型转换为Observable 

flatMap :接收一个Observable的输出作为输入，同时输出另外一个Observable

filter :输出和输入相同的元素，并且会过滤掉那些不满足检查条件的

toList :

just : 获取输入数据, 直接分发, 更加简洁, 省略其他回调.

range : 操作符的作用根据出入的初始值n和数目m发射一系列大于等于n的m个值。

concat : 

---
消息数量过滤操作符的使用

take :输出最多指定数量的结果

take ：取前n个数据 

takeLast：取后n个数据 

first 只发送第一个数据 

last 只发送最后一个数据 

skip() 跳过前n个数据发送后面的数据 

skipLast() 跳过最后n个数据，发送前面的数据 


---
startWith() 插入数据

delay操作符，延迟数据发送 

----
interval 轮询操作符，循环发送数据，数据从0开始递增 

---
distinct    过滤重复的数据

