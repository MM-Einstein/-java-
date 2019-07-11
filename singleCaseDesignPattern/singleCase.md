# 单例设计模式

- **设计模式**：对问题行之有效的解决方式。其实他是一种思想
## 单例设计模式：
**解决的问题**：可以保证一个类在内存中的对象唯一性。比如，对于多个程序使用同一个配置信息对象时，就需要保证该对象的唯一性。

**如何保证唯一性：**
1. 不允许其他程序用new创建该类对象。
2. 在该类中创建一个本类实例
3. 对外提供一个方法，让其他程序可以获取该对象

**步骤：**
1. 私有化该类的构造函数
2. 通过new在本类中创建一个本类对象
3. 定义一个公有方法，将创建的对象返回

```
/*饿汉式*/
class Single{	//类一加载，对象就已经存在了
	static Single s=new Single();
	private Single(){}
	public static Single getInstance(){
		return s;
	}
}

/*懒汉式*/
class Single2{	//类加载进来没有对象，只有调用了getInstance方法时，才会创建对象。
				//单例的延迟加载形式。
	private static Single2 s=null;
	private Single2(){};
	public static Single2 getInstance(){
		if(s==null)
			s=new Single2();
		return s;
	}
}
class SingleDemo{
	public static void main(String[] args){
		Single ss=Single.getInstance();
	}
}
```


>线程安全

```
package singleCase.design.pattern;
//静态的同步函数使用的锁是：该函数所属字节码文件对象，可以用getClass方法获取，也可以用当前类名.class表示。
class SingleSafe{
    private static SingleSafe s = null;
    private SingleSafe(){}
    public static SingleSafe getInstance(){
        if(s==null){
            synchronized (SingleSafe.class){
                s=new SingleSafe();
            }
        }
        return s;
    }
}

public class SingleSafeDemo {
    public static void main(String[] args) {
        SingleSafe s = SingleSafe.getInstance();
    }
}
```
