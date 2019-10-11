package com.dduan.tcp;


import java.io.*;
import java.net.Socket;

/**
 * 客户端
 */
public class Client {
    public static void main(String[] args) {
        try {
            // 1. 创建客户端Socket，指定服务器地址和端口
            Socket socket=new Socket("127.0.0.1", 8888);
            // 2. 获取输出流，向服务端发送信息
            OutputStream os=socket.getOutputStream(); // 获取字节输出流
            PrintWriter pw= new PrintWriter(os); // 将输出流包装成打印流
            pw.write("用户名：admin;密码：123");
            pw.flush();
            socket.shutdownOutput(); // 关闭输出流

            // 3. 获取输入流，并 读取服务端的响应信息
            InputStream is = socket.getInputStream();
            BufferedReader br= new BufferedReader(new InputStreamReader(is));
            String info=null;
            // 循环读取服务端信息
            while ((info=br.readLine()) != null) {
                System.out.printf("我是客户端，服务端说：%s%n", info);
            }
            // 4. 关闭资源
            br.close();
            is.close();
            pw.close();
            os.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
