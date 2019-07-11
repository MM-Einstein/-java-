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
