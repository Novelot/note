linux下安装android环境
=


## 安装Android SDK

1.	`wget https://dl.google.com/android/repository/tools_r25.2.3-linux.zip` (jdk1.8)
	`wget https://dl.google.com/android/repository/tools_r22.0.1-linux.zip`(jdk1.7)

2. `sdkmanager --list`   
遇到如下错误提示:
```
/usr/bin/env:bad interpreter :No such file
```
因为在sdkmanager脚本中用到了/usr/bin/env,但是系统中没有这个文件
解决方法:
```
mkdir /usr/bin/env
chmod 777 /usr/bin/env
```
3. `android list sdk --all`
打印如下结果:
```
   1- Android SDK Tools, revision 24.1.2
   2- Android SDK Platform-tools, revision 22
   3- Android SDK Build-tools, revision 22.0.1
   4- Android SDK Build-tools, revision 22 (Obsolete)
   5- Android SDK Build-tools, revision 21.1.2
   6- Android SDK Build-tools, revision 21.1.1 (Obsolete)
   7- Android SDK Build-tools, revision 21.1 (Obsolete)
   8- Android SDK Build-tools, revision 21.0.2 (Obsolete)
   9- Android SDK Build-tools, revision 21.0.1 (Obsolete)
  10- Android SDK Build-tools, revision 21 (Obsolete)
  11- Android SDK Build-tools, revision 20
  12- Android SDK Build-tools, revision 19.1
  13- Android SDK Build-tools, revision 19.0.3 (Obsolete)
  14- Android SDK Build-tools, revision 19.0.2 (Obsolete)
  15- Android SDK Build-tools, revision 19.0.1 (Obsolete)
  16- Android SDK Build-tools, revision 19 (Obsolete)
  17- Android SDK Build-tools, revision 18.1.1 (Obsolete)
  18- Android SDK Build-tools, revision 18.1 (Obsolete)
  19- Android SDK Build-tools, revision 18.0.1 (Obsolete)
  20- Android SDK Build-tools, revision 17 (Obsolete)
  21- Documentation for Android SDK, API 22, revision 1
  22- SDK Platform Android 5.1.1, API 22, revision 2
  23- SDK Platform Android 5.0.1, API 21, revision 2
  24- SDK Platform Android 4.4W.2, API 20, revision 2
  25- SDK Platform Android 4.4.2, API 19, revision 4
  26- SDK Platform Android 4.3.1, API 18, revision 3
  27- SDK Platform Android 4.2.2, API 17, revision 3
```
4. android update sdk -u --all --filter 1,2,3,5,11,12,22,23,24,25,26,27,28,29,88,89

## 安装gradle
1. `wget https://downloads.gradle.org/distributions/gradle-3.5-bin.zip`(在官网(https://gradle.org/releases)找最新的) 
2. 配置环境变量
3. `gradle -v`查看是否安装成功

## 执行gradle,指定sdk路径
```
gradle tasks -Dorg.gradle.java.home=/opt/java/jdk1.8.0_121

FAILURE: Build failed with an exception.

* What went wrong:
A problem occurred configuring project ':lunar'.
> You have not accepted the license agreements of the following SDK components:
  [Android SDK Platform 22, Android SDK Build-Tools 22.0.1].
  Before building your project, you need to accept the license agreements and complete the installation of the missing components using the Android Studio SDK Manager.
  Alternatively, to learn how to transfer the license agreements from one workstation to another, go to http://d.android.com/r/studio-ui/export-licenses.html

* Try:
Run with --stacktrace option to get the stack trace. Run with --info or --debug option to get more log output.

```
在android sdk 目录下创建licenses/android-sdk-license文件,内容如下:
`8933bad161af4178b1185d1a37fbf41ea5269c55`
