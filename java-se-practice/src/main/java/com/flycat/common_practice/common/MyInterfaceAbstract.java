package com.flycat.common_practice.common;

public class MyInterfaceAbstract {


    interface FunctionInterface{

    }
    /**
     * 方法只能是     抽象方法      类方法（非抽象）    默认方法（非抽象 default限定）
     * 接口的方法定义了一种行为规范
     * 接口的变量 是固定 public static final  修饰的
     * 接口可以多继承
     * 不能被实例化
     */
    interface Dog{
        void set();//抽象方法 默|认有 public abstract 修饰 所以没有方法体 子类必须实现
        //以下 java 8 允许定义
        default void get() {//接口可以定义 默认方法和 类方法 当然 他们有方法体 子类可以不实现

        }
        static void getDog(){};
    }
    class RunDog implements Dog {

        @Override
        public void set() {

        }
    }
    // ==============================  抽象类   ====================================

    /**
     * 抽象类 提供的是 模板化设计
     */
    abstract class Product{
        private int price;
        abstract int getPrice();
        { // 初始化块

        }
        public void sdf(){ //普通方法

        }
        public Product(){//沟槽函数  子类用来初始化

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
