package com.flycat.common_practice.common;

import java.lang.reflect.Method;

public class StringTest {
    public static void main(String[] args) {
        Class clazz = "".getClass();
        Method[] methods =  clazz.getMethods();
        for (Method m : methods) {
            System.out.println(m.getName());
        }
    }
}
