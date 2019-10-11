package com.dduan.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 使用URL读取网页内容
 * Created by Admin on 2019/10/9
 */
public class Test03 {
    public static void main(String[] args) {
        try {
            // 创建一个 URL实例
            URL url = new URL("http://www.baidu.com");
            // 通过URL的openStream方法获取URL对象所表示的资源的字节输入流
            InputStream inputStream=url.openStream();
            // 将字节输入流转换为字符输入流
            InputStreamReader isr = new InputStreamReader(inputStream,"utf-8");
            // 为字符输入流添加缓冲
            BufferedReader bufferedReader = new BufferedReader(isr);
            // 读取数据
            String data = bufferedReader.readLine();
            // 循环读取数据
            while (data!= null){
                System.out.println(data);
                data = bufferedReader.readLine();
            }
            bufferedReader.close();
            isr.close();
            inputStream.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
