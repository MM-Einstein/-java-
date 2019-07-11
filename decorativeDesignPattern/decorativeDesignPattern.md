# 装饰设计模式

- 定义：指在不改变现有对象结构的情况下，动态地给该对象增加一些职责（即增加其额外功能）的模式，它属于对象结构型模式。

- 装饰设计模式的优点：
  1. 采用装饰模式扩展对象的功能比采用继承方式更加灵活。
  2. 可以设计出多个不同的具体装饰类，创造出多个不同行为的组合。

- 其主要缺点是：装饰模式增加了许多子类，如果过度使用会使程序变得很复杂。


## 装饰设计模式的结构

装饰设计模式主要包含以下几个角色：   
    1. 抽象构件（Component）角色：定义一个抽象接口以规范准备接收附加责任的对象。  
    2. 具体构件（Concrete    Component）角色：实现抽象构件，通过装饰角色为其添加一些职责。  
    3. 抽象装饰（Decorator）角色：实现抽象构件，并包含具体构件的实例，可以通过其子类扩展具体构件的功能。  
    4. 具体装饰（ConcreteDecorator）角色：实现抽象装饰的相关方法，并给具体构件对象添加附加的责任。  


<div align=center>
<img src="https://github.com/MM-Einstein/DesignPattern/blob/master/decorativeDesignPattern/images/1.png"/>   

图1. 装饰设计模式结构图
</div>


## 装饰设计模式与继承的区别
==先简单分析一下装饰者模式和继承方式的共同点：== 通过继承的方式可以使子类具有父类的属性和方法。子类继承父类后，因为一些业务需求可以通过重写的方式来加强父类的方法的一些功能，也可以重新定义某些属性，即覆盖父类的原有属性和方法，使其获得与父类不同的功能。而装饰者模式的最基本的功能就是对传入的一个对象进行功能的加强与优化。那么问题来了，既然继承方式也可以对已有类或对象进行加强，那为什么还要衍生出装饰者模式这一思想呢？重头戏在下面：

**装饰者模式的意图定义为：动态地给一个对象添加一些额外的职责。单单就这简短的依据话就可以知道，除了最基本的增强已有对象的功能外，恐怕装饰者模式存在的更重要的意义就在于动态的为对象添加一些功能（或分配额外职责）。那么这句话到底是什么意思呢？它到底解决了什么样的问题呢？下面通过一些最简单的示例来具体分析一下：**

假设Milk是父类，也可以在牛奶中加入糖、蜂蜜、咖啡。。。如果使用继承的方式，会有多少种搭配呢？


这里我们看到，如果使用继承的方法，我们要写很多子类，增加了程序的臃肿性和耦合性，而且类与类之间的耦合度高。于是出现了装饰设计模式。  

Java中的IO机制就用到了装饰者模式，比如常用的  
***BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filepath)));***  
***BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));***  

对于BufferedWriter/BufferedReader来说，如果使用继承，那么每个类型的文件都需要覆盖父类的缓冲方法，调用的时候每个类型文件的方法都不一样，而装饰设计模式只需创建一个类即可，这个类的对象所调用的方法在每个类型文件的调用中都是一致的。通过BufferedReader对已有对象FileReader的功能进行加强和优化。其实它不仅可以加强FileReader，所有的字符输入流都可以通过这种方式进行包装。它是如何实现的呢？注意重点来了：**==其实很简单，它只不过将所有的字符输入流抽象出了一个基类或接口 即Reader,然后通过构造方法的形式将Reader传递给BufferedReader，此时BufferedReader就可以对所有的字符输入流进行拦截和优化了。其中，Reader就相当于抽象装饰类DecorateMethod，BufferedWriter/BufferedReader类就相当于具体装饰类，即Suger/Coffee/Honey类,***Writer/***Reader相当于真实对象，即Milk对象。==**


## 装饰设计模式格式
首先我们要有一个真实的对象和装饰对象，它们两个要实现同一个接口，还有有具体的装饰对象，简易的说就是将真实对象作为具体装饰对象的构造方法的参数，给装饰对象添加功能。


## 代码
> 接口类

```java
package decorative.design.pattern;

/*
* 定义接口
* */
public interface Drink {
    public float money();
    public String description();
}
```

> 抽象装饰类：DecorateMethod

```
package decorative.design.pattern;

/*
* 抽象装饰类：
* */
public abstract class DecorateMethod implements Drink{
    private Drink drink;
    //public  DecorateMethod(){}
    public DecorateMethod(Drink drink){     //根据多态，这里做了向上转型(Drink)milk
        this.drink=drink;
    }

    @Override
    public String description() {
        return drink.description();     //实际调用的是Milk类中重写的description()方法
    }

    @Override
    public float money() {
        return drink.money();       //实际调用的是Milk类中重写的money()方法
    }
}
```
> 真实对象：Milk

```
package decorative.design.pattern;

/*
* 真实对象
* */

public class Milk implements Drink {

    @Override
    public float money() {
        return 3f;
    }

    @Override
    public String description() {
        return "milk";
    }
}
```
> 抽象装饰类的具体类：Coffee

```
package decorative.design.pattern;

/*
 * 抽象装饰类的具体类
 * */

public class Coffee extends DecorateMethod {
    public Coffee(Drink drink) {
        super(drink);
    }

    @Override
    public String description() {
        return super.description()+"+"+"coffee";
    }

    @Override
    public float money() {
        return super.money()+3f;
    }
}
```
> 抽象装饰类的具体类：Suger

```
package decorative.design.pattern;

/*
* 抽象装饰类的具体类
* */
public class Suger extends DecorateMethod {
    //private Drink drink;

    public Suger(Drink drink) { //根据多态，这里做了向上转型(Drink)milk

        super(drink);
        //this.drink = drink;
    }

    @Override
    public String description() {
        return super.description()+"+"+"suger"; //调用了DecorateMethod抽象修饰类的description()方法
    }

    @Override
    public float money() {
        return super.money()+1.5f;
    }
}
```
> 抽象装饰类的具体类：Honey

```
package decorative.design.pattern;

/*
 * 抽象装饰类的具体类
 * */

public class Honey extends DecorateMethod {
    //public  Honey(){}
    public Honey(Drink drink) {
        super(drink);
    }

    @Override
    public String description() {
        return super.description()+"+"+"honey";
    }

    @Override
    public float money() {
        return super.money()+2f;
    }
}
```
> 测试case

```
package decorative.design.pattern;

public class TestCase {
    public static void main(String[] args) {
        //创建一个牛奶对象
        Milk milk = new Milk();
        //Drink drink = new Milk();
        System.out.println(milk.description()+":"+milk.money());
        //System.out.println("-------------");

        //牛奶+糖
        Suger suger = new Suger(milk);
        System.out.println(suger.description()+":"+suger.money());

        //牛奶+蜂蜜
        Honey honey = new Honey(milk);
//        Honey honey = new Honey();
        System.out.println(honey.description()+":"+honey.money());
        Drink drink = honey;

        //牛奶+蜂蜜+咖啡
        Coffee coffee = new Coffee(honey);//因为honey是DecorateMethod类的子类，所以也实现了Drink接口，所以这里可以传Honey类的对象
        System.out.println(coffee.description()+":"+coffee.money());
    }
}
```
