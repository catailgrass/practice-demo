package practice;

public class MyInterface {
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
}
