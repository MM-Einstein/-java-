package singleCase.design.pattern;

/*
* 饿汉式
* */
class Single{
    private static Single s = new Single();//类一加载，对象就已经存在了
    private Single(){}//私有化构造函数，无法在类的外部new对象
    public static Single getInstance(){//对外提供获取对象的方法
        return s;
    }
}

/*
* 懒汉式
* */
class Single2{
    private static Single2 s = null;
    private Single2(){}//私有化构造函数，无法在类的外部new对象
    public static Single2 getInstance(){
        if(s==null)
            s=new Single2();
        return s;

    }
}

public class SingleDemo {
    public static void main(String[] args) {
        Single s1 = Single.getInstance();
        Single2 s2 = Single2.getInstance();
    }
}
