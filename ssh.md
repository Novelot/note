# SSH配置遇到的问题 #  

问题  
```
$ ssh -p 29418 liuyl@git.kaolafm.com
Unable to negotiate with 192.168.4.28: no matching key exchange method found. Their offer: diffie-hellman-group1-sha1
```

解决方法：  
在`~/.ssh/config`目录下新建config文件，config文件内容如下：  
```
Host *
	KexAlgorithms +diffie-hellman-group1-sha1
```  
再次输入：  
```
ssh -p 29418 liuyl@git.kaolafm.com
```
