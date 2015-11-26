jcenter笔记

Maven Publishing (new)
https://docs.gradle.org/current/userguide/publishing_maven.html

How Do I Upload My Stuff to Bintray?
https://bintray.com/docs/usermanual/uploads/uploads_howdoiuploadmystufftobintray.html

Gradle User Guide
https://docs.gradle.org/current/userguide/userguide

=====================================================================
1.gpg4win
用于gpg加密
参考:
	http://www.ruanyifeng.com/blog/2013/07/gpg.html
	http://gpg4win.org/
下载地址:
	http://files.gpg4win.org/gpg4win-2.2.6.exe
使用方法:
	详见gpg4win-compendium-en.pdf


2.gradle
=====================================================================
注意:
保持你的library module的名字同artifactId一样

因为在Bintray上你的项目的maven-metadata.xml文件的路径是gruopId+"/"+module名称。
例如你的groupId是com.example，artifactId是test，但module名称是library。
这时候项目文件是在com.example.test目录下的，但maven-metadata.xml文件却是在com.example.library目录下的。
这样一来如果你有多个项目groupId一样，artifactId不一样，但module名称都是library的话，可能就会冲突。
目前为止我还没有找到更好的解决办法，就只能让module名称和artifactId保持一致，如果你们谁有更好的办法，欢迎留言交流。
=====================================================================