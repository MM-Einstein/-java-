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
