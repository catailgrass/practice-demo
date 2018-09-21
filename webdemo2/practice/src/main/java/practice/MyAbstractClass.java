package practice;

public class MyAbstractClass {
    /**
     * 抽象类 提供的是 模板化设计
     */
    abstract class Product{
        private int price;
        abstract int getPrice();

    }
    /**
     * 与接口的区别
     *          接口                          抽象类
     *  普通方法不能有方法体                 可以有
     *  可以多继承
     *  不含构造器                             有 但是只是子类用来初始化它
     *  不能有普通成员变量
     *  没有初始化块
     */
}
