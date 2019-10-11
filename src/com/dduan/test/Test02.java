package com.dduan.test;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Admin on 2019/10/9
 */
public class Test02 {
    public static void main(String[] args) {

        try {
            // 创建URL 实例
            URL dduan = new URL("http://www.tcp.site");
            // ?后面表示参数，#后面表示锚点
            URL url = new URL(dduan,"/index.html?username=tom#test");
            System.out.printf("协议：%s%n", url.getProtocol());
            System.out.printf("主机：%s%n", url.getHost());
            // 如果未指定端口号，则使用默认端口号，此时getPort方法返回值为-1
            System.out.printf("端口：%d%n", url.getPort());
            System.out.printf("文件路径：%s%n", url.getPath());
            System.out.printf("文件名称：%s%n", url.getFile());
            System.out.printf("相对路径：%s%n", url.getRef());
            System.out.printf("查询字符串：%s%n", url.getQuery());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
