package com.dduan.test;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * Created by Admin on 2019/10/9
 */
public class Test01 {
    public static void main(String[] args) throws UnknownHostException {
        // 获取 InetAddress 实例
        InetAddress inetAddress=InetAddress.getLocalHost();
        System.out.printf("计算机名称：%s%n", inetAddress.getHostName());
        System.out.printf("IP地址：%s%n", inetAddress.getHostAddress());

        // 获取字节数组形式的ip
        byte[] bytes=inetAddress.getAddress();
        System.out.printf("字节数组形式的IP：%s%n", Arrays.toString(bytes));

        // 直接输出InetAddress 对象
        System.out.println(inetAddress);

        // 根据机器名获取InetAddress实例
        InetAddress inetAddress1=InetAddress.getByName("DESKTOP-9SHN4O4");

        // 根据IP地址获取InetAddress实例
        InetAddress inetAddress2=InetAddress.getByName("169.254.231.143");

        System.out.printf("计算机名称：%s%n", inetAddress2.getHostName());
        System.out.printf("IP地址：%s%n", inetAddress2.getHostAddress());
    }
}
