Android适配
=

## 参考
> https://developer.android.google.cn/guide/topics/resources/providing-resources.html#BestMatch


## Android 如何查找最佳匹配资源
1. 淘汰与设备配置冲突的资源目录;
2. 选择优先级最高得限定符;如果所有资源文件都不包含该限定符,则下移到下一个限定符;如果有含有该限定符的资源目录,则淘汰其他不含该限定符的目录;
3. 