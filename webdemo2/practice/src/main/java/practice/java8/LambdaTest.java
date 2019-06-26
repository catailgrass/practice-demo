package practice.java8;

import java.util.Comparator;

/**
 *
 * @Des  表达一系列简化的数据操作 参数，返回 都可省略
 * 表达式整体是一个方法的简写（匿名内部类）
 * 本质上其实是接口的 一种具体实现
 *
 * 可省略的 参数类型声明
 * 可省略的 参数 圆括号
 * 可省略的 方法体 {}
 * 可省略的 返回关键字 return
 */
public class LambdaTest {
    public static void main(String args[]){
        LambdaTest tester = new LambdaTest();

        // 类型声明
        MathOperation addition = (int a, int b) -> a + b;

        // 不用类型声明
        MathOperation subtraction = (a, b) -> a - b;

        // 大括号中的返回语句
        MathOperation multiplication = (int a, int b) -> { return a * b; };

        // 没有大括号及返回语句
        MathOperation division = (int a, int b) -> a / b;

        System.out.println("10 + 5 = " + tester.operate(10, 5, addition));
        System.out.println("10 - 5 = " + tester.operate(10, 5, subtraction));
        System.out.println("10 x 5 = " + tester.operate(10, 5, multiplication));
        System.out.println("10 / 5 = " + tester.operate(10, 5, division));

        // 不用括号
        GreetingService greetService1 = message ->
                System.out.println("Hello " + message);

        // 用括号
        GreetingService greetService2 = (message) ->
                System.out.println("Hello " + message);

        greetService1.sayMessage("Runoob");
        greetService2.sayMessage("Google");

        // 复杂的
        BarkService barkService = name -> System.out.println(name + " . the dog bark at you");
        barkService.barkAtSm("Tom");
    }

    interface MathOperation {
        int operation(int a, int b);
    }

    interface GreetingService {
        void sayMessage(String message);
    }

    interface BarkService{
        void barkAtSm(String name);
    }
    private int operate(int a, int b, MathOperation mathOperation){
        return mathOperation.operation(a, b);
    }
}
