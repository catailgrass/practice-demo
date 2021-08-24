package com.flycat.common_practice.javaNewFeature;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamApiPractise {


    public static void main(String[] args) {

        List<String> names = Arrays.asList("tom","lili","zhangsan");
        List<String> namesUpper = names.stream().map(x -> x.toUpperCase()).collect(Collectors.toList());
        namesUpper.stream().forEach(System.out::println);

        List<String> numStrs = Arrays.asList("121111","454454545","6768767878");
        List<Long> nums = numStrs.stream().map(x -> Long.valueOf(x)).collect(Collectors.toList());
        nums.stream().forEach(x-> System.out.println(x));
    }
}
