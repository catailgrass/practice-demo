package com.flycat.common_practice.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface A {
    void execute();
}
class AImpl implements A{
    @Override
    public void execute() {
        System.out.println("execute success ");
    }
}
public class JDKProxy implements InvocationHandler {
    private A a ;
    public JDKProxy(A target) {
        this.a = target;
    }
    public A createProxy() {
        return (A) Proxy.newProxyInstance(a.getClass().getClassLoader(),a.getClass().getInterfaces(),this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if ("execute".equals(method.getName())) {
            System.out.println("execute is proxy ");
        }else {
            System.out.println(method.getName()+ "is not proxy");
        }
        return method.invoke(a,args);
    }

    public static void main(String[] args) {
        AImpl a = new AImpl();
        JDKProxy jdkProxy = new JDKProxy(a);
        A proxy = jdkProxy.createProxy();
        proxy.execute();
    }
}
