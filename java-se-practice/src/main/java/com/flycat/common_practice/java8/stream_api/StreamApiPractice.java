package com.flycat.common_practice.java8.stream_api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class StreamApiPractice {

    /**
     * 选择以a开头的 最长字符串
     *
     * @param stringList
     */
    public static void findMaxLengthStr(List<String> stringList) {
        System.out.println(
                stringList.stream()
                .filter(x->x.startsWith("a"))
                .mapToInt(String::length)
                .max().orElse(0)
        );
    }

    public static void main(String[] args) throws IOException {
//        String[] ss = { "abb", "abcd", "fegc", "efe", "adfes" };
//        findMaxLengthStr(Arrays.asList(ss));
//        System.out.println("请输入 ");
        Scanner scanner = new Scanner(System.in);
        List<Integer> bottleNums = new ArrayList<>();
        while (scanner.hasNext()) {
            int nextInt = scanner.nextInt();
            if (nextInt == 0) {
                break;
            }
            bottleNums.add(nextInt);
        }
        bottleNums.forEach(x->{
            System.out.println(findRealNum(x, 3));
        });
    }

    public static int findRealNum(int bottleNum,int exchangeFactor) {
        int num = 0;
        int count = bottleNum / exchangeFactor;
        num += count;
        int remainder = bottleNum % exchangeFactor;
        while ((count + remainder) / exchangeFactor > 0) {
            remainder =  (count + remainder) % exchangeFactor;
            count = (count + remainder) / exchangeFactor;
            num += count;
        }
        if (remainder == 1) {
            num += 1;
        }
        return num;
    }
}
