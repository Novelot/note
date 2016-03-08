# Android测试笔记 #

## 使用方法 ##  
1. 继承AndroidTestCase
2. 配置指令集:instrumentation在manifest节点下
3. 配置函数库:uses-library在Application节点下
4. assertEquals  


## 相关类 ##
```
Object
	junit.framework.Assert:断言类,提供assertXXX()和failXXX()方法;
		junit.framework.TestCase:没有抽象方法的抽象类
			FailedToCreateTests
			android.test.AndroidTestCase
				android.test.ProviderTestCase2
				android.test.LoaderTestCase
				android.test.ServiceTestCase
				android.test.ApplicationTestCase
			android.test.InstrumentationTestCase
				SingleLaunchActivityTestCase
				SyncBaseInstrumentation
				ProviderTestCase:过时
				ActivityTestCase
					ActivityInstrumentationTestCase:过时
					ActivityUnitTestCase
					ActivityInstrumentationTestCase2
```
## 几个重要的类 ##  
## TestCase:无抽象方法的抽象类  
```
setUp() 
tearDown()
runTest()  
```

## InstrumentationTestCase
#### 内部成员:  
```
Instrumentation(因撕戳么儿,忒深)指令集  
newApplication()  
newActivity()  
getContext()  
callApplicationOnCreate():调用Application的onCreate()方法;  
callActivityOnXXX():等生命周期方法;  
execStartActivity():  
```

#### 内部方法:  
```
runTest() :重写父类方法,通过反射调用被测方法;  
tearDown():重写父类方法;  
setUp() :未重写父类方法; 
``` 
```
getInstrumentation()
launchActivity()
launchActivityWithIntent()
runTestOnUiThread()
```

## ActivityTestCase
#### 内部成员:  
Activity

#### 内部方法:  
```
setUp() :未重写父类方法;  
```
```
getActivity():  
setActivity():  
scrubClass():刷除类,将类中的成员变量清为null,利用反射;  
```
## ActivityInstrumentationTestCase2
#### 内部成员:
	
#### 内部方法:  
```
tearDown():重写父类方法,finish(结束)Activity,scrubClass(刷除)ActivityInstrumentationTestCase2;
setUp() :重写父类方法;  
runTest():重写父类方法,目的是为了先创建Activity;  
```
```
getActivity():对父类中的成员变量mActivity进行了强转;如有必要会先创建Activity;  
setActivityIntent():  
```

## AndroidTestCase ##
#### 内部成员: 
``` 
Context 上下文
```

#### 内部方法:  
```
setUp():重写父类方法;  
tearDown():重写父类方法;  
runTest():未重写;  
```

```
getContext():获取上下文;  
assertXXXRequiresPermission():断言是否拥有某种系统权限;  
scrubClass():刷除类,将类中的成员变量清为null,利用反射;  
```
## JUnit测试框架(j2se) ##
```
@Test注解
	被测类必须:public
	被测方法必须:无参数,无返回值,非静态  
@Before在被测方法之前调用;  
@After在被测方法之后调用;  
@BeforeClass在类被加载后立即调用,方法必须static;  
@AfterClass在类被释放前执行,方法必须为static;  
```