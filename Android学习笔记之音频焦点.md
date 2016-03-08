# 音频焦点笔记 #

# OnAudioFocusChangeListener 

## 常量说明 ## 

### * AUDIOFOCUS_GAIN:  
获得了Audio Focus;  

### * AUDIOFOCUS_LOSS:  
失去了Audio Focus，并将会持续很长的时间。这里因为可能会停掉很长时间，所以不仅仅要停止Audio的播放，最好直接释放掉Media资源。而因为停止播放Audio的时间会很长，如果程序因为这个原因而失去AudioFocus，最好不要让它再次自动获得AudioFocus而继续播放，不然突然冒出来的声音会让用户感觉莫名其妙，感受很不好。这里直接放弃AudioFocus，当然也不用再侦听远程播放控制【如下面代码的处理】。要再次播放，除非用户再在界面上点击开始播放，才重新初始化Media，进行播放.  

### * AUDIOFOCUS_LOSS_TRANSIENT:  
暂时失去Audio Focus，并会很快再次获得。必须停止Audio的播放，但是因为可能会很快再次获得AudioFocus，这里可以不释放Media资源;  

### * AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK(-3):  
暂时失去AudioFocus，但是可以继续播放，不过要在降低音量。

---
## 一些问题 ##  

1. 当有语音控制时,此时播放器会失去音频焦点,如果暂停播放器,并保存了之前的播放状态,那么,当语音控制的命令时"播放器暂停"时,播放器会暂停,然后,播放器重新获取到焦点,并恢复之前保存的播放状态,这时,恢复成"播放"状态,与语音命令冲突;  

2. 音量  
```
// 设置音量
AudioManager audioManager = (AudioManager) mContext
		.getSystemService(Context.AUDIO_SERVICE);
int maxVolume = audioManager
		.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, maxVolume,
		AudioManager.FLAG_PLAY_SOUND);
Log.d("volumn",
		"current volumn:"
				+ audioManager
						.getStreamVolume(AudioManager.STREAM_MUSIC));
```