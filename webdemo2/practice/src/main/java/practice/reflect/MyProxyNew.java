package practice.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyProxyNew {
    interface Dog{
        void run();
        void info();
    }
    static class BigDog implements Dog{
        @Override
        public void run() {
            System.out.println("我跑的很快");
        }

        @Override
        public void info() {
            System.out.println("我是一只大狗");
        }
    }
   static class DogUtil {
        void method1(){
            System.out.println("模拟的通用方法1");
        }
        void method2(){
            System.out.println("模拟的通用方法2");
        }
    }
    static class MyInvocationHandler implements InvocationHandler{
        //需要被代理的对象
        private Object object;

        public void setObject(Object object) {
            this.object = object;
        }

        public Object getObject() {
            return object;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            DogUtil dogUtil = new DogUtil();
            dogUtil.method1();
            //通过反射来执行主调的方法 （这里的主调被代理了）
            Object result = method.invoke(getObject(), args);
            dogUtil.method2();
            return result;
        }
    }
    static Object getProxy(Object target){
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler();
        myInvocationHandler.setObject(target);
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),myInvocationHandler);
    }

    public static void main(String[] args) {
        Dog dog = (Dog) getProxy(new BigDog());
        dog.info();
        dog.run();
    }
}
