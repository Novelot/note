程序进化论之ImageLoader
=
1. 参考:
>https://github.com/nostra13/Android-Universal-Image-Loader 

2. Features
- Multithread image loading (async or sync)
- Wide customization of ImageLoader's configuration (thread executors, downloader, decoder, memory and disk cache, display image options, etc.)
- Many customization options for every display image call (stub images, caching switch, decoding options, Bitmap processing and displaying, etc.)
- Image caching in memory and/or on disk (device's file system or SD card)
- Listening loading process (including downloading progress)



---
多线程下载图片，图片可以来源于网络，文件系统，项目文件夹assets中以及drawable中等
支持随意的配置ImageLoader，例如线程池，图片下载器，内存缓存策略，硬盘缓存策略，图片显示选项以及其他的一些配置
支持图片的内存缓存，文件系统缓存或者SD卡缓存
支持图片下载过程的监听
根据控件(ImageView)的大小对Bitmap进行裁剪，减少Bitmap占用过多的内存
较好的控制图片的加载过程，例如暂停图片加载，重新开始加载图片，一般使用在ListView,GridView中，滑动过程中暂停加载图片，停止滑动的时候去加载图片
提供在较慢的网络下对图片进行加载
---
素描的手法:
1. 轮廓;
2.  
- 功能相近的方法抽取到统一的一个类里; 
- 为涉及策略的具体类抽取出父类接口;
3. 删除不必要的方法;
4. 弱引用
5. 挥发
6. Builder模式实现配置的可定制化

# fresco
参考:
>https://www.fresco-cn.org/




# okhttp
## 参考:
>http://www.jianshu.com/p/a5782d9f24d3

## 特性:
- 支持 SPDY ，共享同一个Socket来处理同一个服务器的所有请求,socket自动选择最好路线，并支持自动重连,拥有自动维护的socket连接池，减少握手次数

 - 拥有队列线程池，轻松写并发

 - 如果SPDY不可用，则通过连接池来减少请求延时

 - 拥有Interceptors轻松处理请求与响应（比如透明GZIP压缩,LOGGING）,无缝的支持GZIP来减少数据流量

 - 基于Headers的缓存策略,缓存响应数据来减少重复的网络请求

- 会从很多常用的连接问题中自动恢复。如果您的服务器配置了多个IP地址，当第一个IP连接失败的时候，OkHttp会自动尝试下一个IP。OkHttp还处理了代理服务器问题和SSL握手失败问题。

- 使用 OkHttp 无需重写您程序中的网络代码。OkHttp实现了几乎和java.net.HttpURLConnection一样的API。如果您用了 Apache HttpClient，则OkHttp也提供了一个对应的okhttp-apache 模块。



----
- 支持HTTP2/SPDY黑科技
- socket自动选择最好路线，并支持自动重连
- 拥有自动维护的socket连接池，减少握手次数
- 拥有队列线程池，轻松写并发
- 拥有Interceptors轻松处理请求与响应（比如透明GZIP压缩,LOGGING）
- 基于Headers的缓存策略






有哪些特性?为了实现这样的特性,是如何设计的?