package practice;

public class MyAbstractClass {
    /**
     * 抽象类 提供的是 模板化设计
     */
    abstract class Product{
        private int price;
        abstract int getPrice();
        public void sdf(){

        }
        {

        }
    }
    /**
     * 与接口的区别
     *          接口                          抽象类
     *          类方法 类变量                       不能有任何 static 修饰的成员
     *  普通方法不能有方法体                 可以有
     *  可以多继承
     *  不含构造器                             有 但是只是子类用来初始化它
     *  不能有普通成员变量(只能由类变量)
     *  没有任何初始化块                           不能有 static初始化块 普通 {} 可以
     */
}
