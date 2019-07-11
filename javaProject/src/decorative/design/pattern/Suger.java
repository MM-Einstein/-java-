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
