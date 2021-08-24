package com.flycat.common_practice.http;

import java.net.Inet4Address;
import java.net.InetAddress;

public class URLTest {
    public static void main(String[]args){
        try {
            InetAddress inet4Address = Inet4Address.getByName("www.baidu.com");
            Inet4Address inet4Address1 = (Inet4Address) Inet4Address.getLocalHost();
            System.out.println(inet4Address.getAddress().toString());
            System.out.println(inet4Address.getCanonicalHostName());
            System.out.println(inet4Address.getHostAddress());
            System.out.println(inet4Address.getHostName());
            System.out.println(inet4Address1.getHostAddress());
            System.out.println(inet4Address1.getHostName());
            System.out.println(inet4Address1.getAddress());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
