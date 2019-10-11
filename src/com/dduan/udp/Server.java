package com.dduan.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 服务器端，基于udp协议的用户登录
 */
public class Server {
    public static void main(String[] args) throws IOException {
        /**
         * 接收客户端发送得数据
         */
        // 1. 创建服务器端DatagramSocket，指定端口
        DatagramSocket socket=new DatagramSocket(8800);
        byte[] data=null;
        DatagramPacket packet=null;
        int count=0;
        System.out.println("***服务器端已经启动，等待客户端发送数据***");
        while (true){
            // 创建字节数组，指定接收数据包的大小
            data=new byte[1024];
            // 创建数据包，用户接受客户端发送的数据
            packet=new DatagramPacket(data, data.length);
            // 接收客户端发送得数据，receive()此方法在接收到数据之前会一直阻塞
            socket.receive(packet);
            // 创建一个新的线程
            ServerThread serverThread =new ServerThread(socket,packet);
            // 启动线程
            serverThread.start();
            //统计客户端的数量
            count++;
            System.out.println("服务器端被连接过的次数：" + count);
            // 获取当前连接客户端IP
            InetAddress address = packet.getAddress();
            System.out.println("当前客户端的IP为：" + address.getHostAddress());

        }
    }
}