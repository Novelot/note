# Android注解学习笔记 #

>### 参考:  
>http://anupcowkur.com/posts/a-look-at-android-support-annotations/

`compile 'com.android.support:support-annotations:20.0.0'`

# Nullness注解
```
@Nullable 可为null  
@NonNull 不可为null
```

# 资源类型注解  
```
@StringRes  
```

# IntDef和StringDef注解  
```
@IntDef({1, 2, 3}) 只在{1,2,3}中选择
@StringDef  
```