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
