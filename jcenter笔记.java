jcenter�ʼ�

Maven Publishing (new)
https://docs.gradle.org/current/userguide/publishing_maven.html

How Do I Upload My Stuff to Bintray?
https://bintray.com/docs/usermanual/uploads/uploads_howdoiuploadmystufftobintray.html

Gradle User Guide
https://docs.gradle.org/current/userguide/userguide

=====================================================================
1.gpg4win
����gpg����
�ο�:
	http://www.ruanyifeng.com/blog/2013/07/gpg.html
	http://gpg4win.org/
���ص�ַ:
	http://files.gpg4win.org/gpg4win-2.2.6.exe
ʹ�÷���:
	���gpg4win-compendium-en.pdf


2.gradle
=====================================================================
ע��:
�������library module������ͬartifactIdһ��

��Ϊ��Bintray�������Ŀ��maven-metadata.xml�ļ���·����gruopId+"/"+module���ơ�
�������groupId��com.example��artifactId��test����module������library��
��ʱ����Ŀ�ļ�����com.example.testĿ¼�µģ���maven-metadata.xml�ļ�ȴ����com.example.libraryĿ¼�µġ�
����һ��������ж����ĿgroupIdһ����artifactId��һ������module���ƶ���library�Ļ������ܾͻ��ͻ��
ĿǰΪֹ�һ�û���ҵ����õĽ���취����ֻ����module���ƺ�artifactId����һ�£��������˭�и��õİ취����ӭ���Խ�����
=====================================================================