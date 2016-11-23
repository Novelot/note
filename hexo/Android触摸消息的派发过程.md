Android触摸消息的派发过程
=
1.消息获取模块--(pipe)->Application---->InputQueue--(next()->nativePollOnce())-->ViewRoot ImputHandler
--(despatchMotion()->DISPATCH_POINTER)-->deliverPointerEvent()-->finishInputEvent()