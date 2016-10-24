Apollo源码分析
=
## 1. 蓝牙和线控监听 
```
<receiver android:name="com.andrew.apolloMod.service.MediaButtonIntentReceiver" >
    <intent-filter>
         <action android:name="android.intent.action.MEDIA_BUTTON" />
         <action android:name="android.media.AUDIO_BECOMING_NOISY" />
     </intent-filter>
</receiver>
``` 

## 2. 音频焦点监听 

## 3. 