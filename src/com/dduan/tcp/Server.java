package com.dduan.tcp;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 基于TCP协议的Socket通信，实现用户登录
 * 服务器端
 */
public class Server {
    public static void main(String[] args) {
        try {

            // 创建一个服务器端的socket，即ServerSocket，指定绑定的端口，并监听此端口
            ServerSocket serverSocket=new ServerSocket(8888);
            Socket socket=null;
            // 记录客户端的数量
            int count=0;
            System.out.println("***服务器即将启动，登录客户端的连接***");
            // 循环监听等待客户端的连接
            while (true) {
                // 调用accept方法开始监听， 等待客户端连接
                socket=serverSocket.accept();
                // 创建一个新的线程
                ServerThread serverThread=new ServerThread(socket);
                // 启动线程
                serverThread.start();
                // 统计客户端的数量
                count++;
                // 输出客户端的数量
                System.out.printf("客户端的数量：%d%n", count);

                // 获取当前客户端的IP
                InetAddress address=socket.getInetAddress();
                System.out.printf("当前客户端的IP：%s%n", address.getHostAddress());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
