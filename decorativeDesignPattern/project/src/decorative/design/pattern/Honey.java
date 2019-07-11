package decorative.design.pattern;

/*
 * 抽象装饰类的具体类
 * */

public class Honey extends DecorateMethod {
    //public  Honey(){}
    public Honey(Drink drink) {
        super(drink);
        //System.out.println("=======");
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
