Fragment的坑和技巧
=
# 坑
* 使用ViewPager+Fragment界面消失
> 解决方法:
`android:configChanges="locale|keyboard|keyboardHidden|orientation|fontScale|layoutDirection|screenSize|mcc|mnc"` 

* 啦啦啦 


# 技巧
* 在`onCreate`中设置`setRetainInstance(true)`:在配置变化的时候将这个fragment保存下来.