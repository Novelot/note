# Android MediaPlayer框架调查 #

### 参考:  
>http://blog.csdn.net/eustoma/article/details/6706492
>http://blog.csdn.net/eustoma/article/details/6706736
>http://blog.csdn.net/eustoma/article/details/6706768
>http://tech.it168.com/lists/13491/0/13491_21.shtml
>http://blog.csdn.net/eustoma/article/details/6719859  
  
### pcm/mp3编解码:  
>http://blog.csdn.net/eustoma/article/details/6719880

## mediaplayer.cpp ##  
```
status_t MediaPlayer::setDataSource(const sp<IMediaPlayer>& player)
{
    status_t err = UNKNOWN_ERROR;
    sp<IMediaPlayer> p;
    { // scope for the lock
        Mutex::Autolock _l(mLock);

        if ( !( (mCurrentState & MEDIA_PLAYER_IDLE) ||
                (mCurrentState == MEDIA_PLAYER_STATE_ERROR ) ) ) {
            LOGE("setDataSource called in state %d", mCurrentState);
            return INVALID_OPERATION;
        }

        clear_l();
        p = mPlayer;
        mPlayer = player;
        if (player != 0) {
            mCurrentState = MEDIA_PLAYER_INITIALIZED;
            err = NO_ERROR;
        } else {
            LOGE("Unable to to create media player");
        }
    }

    if (p != 0) {
        p->disconnect();
    }

    return err;
}

status_t MediaPlayer::prepareAsync_l()
{
    if ( (mPlayer != 0) && ( mCurrentState & ( MEDIA_PLAYER_INITIALIZED | MEDIA_PLAYER_STOPPED) ) ) {
        mPlayer->setAudioStreamType(mStreamType);
        mCurrentState = MEDIA_PLAYER_PREPARING;
        return mPlayer->prepareAsync();
    }
    LOGE("prepareAsync called in state %d", mCurrentState);
    return INVALID_OPERATION;
}
```

## IMediaPlayer.cpp ##  
```
status_t prepareAsync()
{
	Parcel data, reply;
	data.writeInterfaceToken(IMediaPlayer::getInterfaceDescriptor());
	remote()->transact(PREPARE_ASYNC, data, &reply);
	return reply.readInt32();
}
```

## MediaPlayerService ##  

```
static sp<MediaPlayerBase> createPlayer(player_type playerType, void* cookie,
        notify_callback_f notifyFunc)
{
    sp<MediaPlayerBase> p;
    switch (playerType) {
#ifndef NO_OPENCORE
        case PV_PLAYER:
            LOGV(" create PVPlayer");
            p = new PVPlayer();
            break;
#endif
        case SONIVOX_PLAYER:
            LOGV(" create MidiFile");
            p = new MidiFile();
            break;
        case STAGEFRIGHT_PLAYER:
            LOGV(" create StagefrightPlayer");
            p = new StagefrightPlayer;
            break;
        case TEST_PLAYER:
            LOGV("Create Test Player stub");
            p = new TestPlayerStub();
            break;
    }
    if (p != NULL) {
        if (p->initCheck() == NO_ERROR) {
            p->setNotifyCallback(cookie, notifyFunc);
        } else {
            p.clear();
        }
    }
    if (p == NULL) {
        LOGE("Failed to create player object");
    }
    return p;
}

status_t MediaPlayerService::Client::prepareAsync()
{
    LOGV("[%d] prepareAsync", mConnId);
    sp<MediaPlayerBase> p = getPlayer();
    if (p == 0) return UNKNOWN_ERROR;
    status_t ret = p->prepareAsync();
#if CALLBACK_ANTAGONIZER
    LOGD("start Antagonizer");
    if (ret == NO_ERROR) mAntagonizer->start();
#endif
    return ret;
}
```
## StagefrightPlayer ##  
## AwesomePlayer.cpp ##  
```
status_t AwesomePlayer::prepareAsync_l() {
    if (mFlags & PREPARING) {
        return UNKNOWN_ERROR;  // async prepare already pending
    }

    if (!mQueueStarted) {
        mQueue.start();
        mQueueStarted = true;
    }

    mFlags |= PREPARING;
    mAsyncPrepareEvent = new AwesomeEvent(
            this, &AwesomePlayer::onPrepareAsyncEvent);

    mQueue.postEvent(mAsyncPrepareEvent);

    return OK;
}  
```


