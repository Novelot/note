# proguard学习笔记 #

>### 参考:  
>http://www.jianshu.com/p/0202845db617  
>http://www.trinea.cn/android/proguard-grammar/



# 1. 不混淆某个包下的所有类  

`-keep class com.packagename.**{*;}`

# 2. ProGuard的常用语法
```
-libraryjars class_path 应用的依赖包，如android-support-v4
-keep [,modifier,...] class_specification 不混淆某些类
-keepclassmembers [,modifier,...] class_specification 不混淆类的成员
-keepclasseswithmembers [,modifier,...] class_specification 不混淆类及其成员
-keepnames class_specification 不混淆类及其成员名
-keepclassmembernames class_specification 不混淆类的成员名
-keepclasseswithmembernames class_specification 不混淆类及其成员名
-assumenosideeffects class_specification 假设调用不产生任何影响，在proguard代码优化时会将该调用remove掉。如system.out.println和Log.v等等
-dontwarn [class_filter] 不提示warnning
```  
>### 关于proguard更多语法可见：  
>http://proguard.sourceforge.net/index.html#manual/usage.html  


# 3. proguard与log level结合解决debug模式Log问题  
常见的Android debug日志的打法是定义一个静态变量DEBUG_STATUS，如果为true，则打印log，否则不打印。对于release模式该变量为false，debug模式变量为true。这里介绍一个更好的方法，不用担心正式发布时一不小心错改了该变量。
 
proguard的作用就是在release模式压缩、优化、混淆代码，其中的压缩和优化就包括去除不必要的代码，我们可以利用这一特性解决debug日志的问题，在proguard.cfg中添加
```
-assumenosideeffects class android.util.Log {
    public static *** d(...);
    public static *** v(...);
}
```