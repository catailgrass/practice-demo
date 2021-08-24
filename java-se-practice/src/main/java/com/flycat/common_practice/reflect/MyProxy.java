package com.flycat.common_practice.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyProxy {
    /**
     * JDK动态代理 只能通过接口来实现
     * 动态代理：编译时类型无需关心具体的实现 这些东西完全交给代理来完成
     * 继承了 invocationhandler 的handler方法
     * 作用 在执行目标方法之前 或之后 插入一些通用处理过程
     * 使用 AOP 面向切面编程
     */
    interface Person{
        void walk();
        void sayHello(String s);
    }

    /**
     * 执行被代理对象的所有方法是 都会被替换成执行下面的 invoke
     */
   static class MyInvocationHandler implements InvocationHandler{
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("运行了"+method);
            if (args == null) {
                System.out.println("运行了无实参的方法");
            }else{
                String string = "";
                for (Object o : args) {
                    string += (String) o;
                }
                System.out.println("有参数 "+string);
            }
            return null;
        }
    }

    public static void main(String[] args) {
        MyProxy.MyInvocationHandler handler = new MyProxy.MyInvocationHandler();
        Person person = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(),new Class[]{Person.class} , handler);
//        handler.invoke(person,Person.class.getMethod(""))
        person.sayHello("南京");
        person.walk();
    }
}
