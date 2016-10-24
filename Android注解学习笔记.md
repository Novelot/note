Android注解学习笔记
=

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
@DrawableRes  
@ColorRes  
@InterpolatorRes  
@AnyRes  
```

# IntDef和StringDef注解  
```
@IntDef({1, 2, 3}) 只在{1,2,3}中选择
@StringDef  
```  
  
# 线程注解  
```  
@UiThread  
@MainThread  
@WorkerThread  
@BinderThread  
```  
# 混淆注解  
```  
@Keep
```

# 权限注解  
```  
@RequiresPermission(Manifest.permission.SET_WALLPAPER)  

@RequiresPermission(anyOf = {
    Manifest.permission.ACCESS_COARSE_LOCATION,
    Manifest.permission.ACCESS_FINE_LOCATION})  

@RequiresPermission(allOf = {
    Manifest.permission.READ_HISTORY_BOOKMARKS, 
    Manifest.permission.WRITE_HISTORY_BOOKMARKS})  

```  
# 继承限制注解  
```  
@CallSuper  
```  
# 返回值注解  
```  
@CheckResult  
@CheckResult(suggest="#enforcePermission(String,int,int,String)")  
```  

# 其他  
```  
@ColorRes  
@ColorInt  
@Size  
@IntRange  
@FloatRange  
@IntRange(from=0,to=255)  
@Size(min=1)  
@Size(max=23)  
@Size(2)    
```  
