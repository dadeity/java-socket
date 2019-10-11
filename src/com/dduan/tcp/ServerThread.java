package com.dduan.tcp;

import java.io.*;
import java.net.Socket;

/**
 * tcp服务器线程处理类
 */
public class ServerThread extends Thread {
    // 和本线程相关的Socket
    Socket socket=null;

    public ServerThread(Socket socket) {
        this.socket=socket;
    }

    // 线程执行的操作，响应客户端的请求

    @Override
    public void run() {
        InputStream is=null;
        InputStreamReader isr=null;
        BufferedReader br=null;
        OutputStream os=null;
        PrintWriter pw =null;

        try {
            // 获取输入流，并读取客户端发送的信息
            /*字节输入流*/
            is=socket.getInputStream();
            // 将字节流转换为字符流
            isr=new InputStreamReader(is);
            // 为输入流添加缓冲
            br=new BufferedReader(isr);

            String info=null;
            // 循环读取客户端信息
            while ((info=br.readLine()) != null) {
                System.out.printf("我是服务器，客户端说：%s%n", info);
            }
            // 关闭输入流
            socket.shutdownInput();

            // 获取输出流，响应客户端的请求
            os=socket.getOutputStream();
            // 包装为打印流
            pw=new PrintWriter(os);
            pw.write("欢迎您！");
            // 调用flush()，刷新缓存
            pw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                // 关闭资源
                if (pw != null) {
                    pw.close();
                }
                if (os != null) {
                    os.close();
                }
                if (br != null) {
                    br.close();
                }
                if (isr != null) {
                    isr.close();
                }
                if (is != null) {
                    is.close();
                }
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
