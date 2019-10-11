package com.dduan.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * udp 服务器线程处理类
 */
public class ServerThread extends Thread {

    private DatagramSocket socket=null;
    private DatagramPacket packet=null;

    public ServerThread(DatagramSocket socket, DatagramPacket packet) {
        this.socket=socket;
        this.packet=packet;
    }

    @Override
    public void run() {
        String info=null;
        InetAddress address=null;
        int port=8800;
        byte[] data;
        try {
            // 读取数据
            info=new String(packet.getData(), 0, packet.getLength());
            System.out.printf("我是服务器，客户端说：%s%n", info);

            // 获取套接字绑定的地址和端口号
            address=packet.getAddress();
            port=packet.getPort();
            System.out.printf("客户端IP：%s | 客户端端口号：%d%n", address, port);

            /**
             * 向客户端响应数据
             */

            data="欢迎您！".getBytes();
            // 创建数据报，包含响应的数据
            DatagramPacket packet1=new DatagramPacket(data,data.length,address,port);
            // 响应客户端
            socket.send(packet1);

        } catch (IOException e) {
            e.printStackTrace();
        }
        // 关闭资源
        //socket.close();
    }
}
