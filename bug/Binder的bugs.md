Binder的bugs
=
1. 
```
10:34:24.562 23026-23037/com.kaolafm.sdk.client W/JavaBinder: BinderProxy is being destroyed but the application did not call unlinkToDeath to unlink all of its death recipients beforehand.  Releasing leaked death recipient: com.kaolafm.sdk.client.KLClientAPI$1
```

2. aidl不支持重载
