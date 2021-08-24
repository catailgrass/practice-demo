package com.flycat.common_practice.springIOC;

public class HelloSpringFactory {
    public static HelloSpring createHelloSpring() {
        System.out.println("createHelloSpring");
        return new HelloSpring();
    }
    public HelloSpring createHelloSpringInstance() {
        System.out.println("createHelloSpringInstance");
        return new HelloSpring();
    }
}
