package com.flycat.common_practice.innerclass;

import java.util.ArrayList;
import java.util.List;

public class AnonymousInnerClass {
    private List list = new ArrayList() {
        {//类的初始化块
            add("sdfasdf");
        }
    };
    {
        System.out.println(list.get(0));
    }

    public static void main(String[] args) {
        new AnonymousInnerClass();
    }
}
