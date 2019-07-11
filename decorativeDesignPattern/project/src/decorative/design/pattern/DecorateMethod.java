package decorative.design.pattern;

/*
* 抽象装饰类
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
