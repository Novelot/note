Android中的设计模式
=
设计模式最初是由[GoF](http://baike.baidu.com/view/1082055.htm) 提出

# 1. 单例
```
public final class InputMethodManager {

static InputMethodManager sInstance;

public static InputMethodManager getInstance() {
 synchronized (InputMethodManager.class) {
	 if (sInstance == null) {
		 IBinder b = ServiceManager.getService(Context.INPUT_METHOD_SERVICE);
		 IInputMethodManager service = IInputMethodManager.Stub.asInterface(b);
		 sInstance = new InputMethodManager(service, Looper.getMainLooper());
	 }
	 return sInstance;
 }
}
```
# 2. 工厂 

	2.1 静态工厂 

	2.2 简单工厂 

	2.3 工厂方法 

	2.4 抽象工厂
# 3. 策略
# 4. 观察者
	java.util.Observable;
	java.util.Observer;
# 5. 装饰
	FileInputStream;
	BufferedInputStream;
	LineNumberInputStream;
# 6. 命令
	
# 7. 模板方法
# 8. 适配器
# 9. 组合
# 10. 迭代器
# 11. 状态
# 12. 代理 
* 和装饰模式的差别
# 13. ioc(控制反转、依赖注入)
# 14. 访问者
	注解butterknife












