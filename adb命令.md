ADB 命令
=
#### 参考
>http://www.2cto.com/kf/201502/376365.html

### 1. 打开Activity  

```
adb shell
am start -n com.edog.car/com.edog.activity.SplashActivity
```

### 2. 控制音量  

增大音量
```
adb shell input keyevent 24
```
减小音量
```
adb shell input keyevent 25
```

### 3. 关闭应用  

```
adb shell am force-stop 包名
```

### 4. 将电脑上的文件复制到手机上  

```
adb push 电脑上的路径 手机路径(不用带文件名,只写文件夹名就行)
```

### 5. 使用adb查看log  

清空log  
`adb logcat -c`  

打印log  
`adb logcat`  

清空并打印  
`adb logcat -c && adb logcat`  

使用I,V,D,E,F,W等过滤  
`adb logcat *:I`  

打印指定TAG;!!!!!!!!!!重要!!!!!!!!!!!!!!!  
`adb logcat TAG:* *:S`

打印有时间的log;  
`adb logcat -v time`  

只显示进程id  
`adb logcat -v process`  


### 6. 设置安装路径  

pm 查看
0 auto
1 内存
2 sdcard

`pm set-install-location 2 `  

### 7. 查看设备信息
`adb shell getprop > log`