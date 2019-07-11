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
