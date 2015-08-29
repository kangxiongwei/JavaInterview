package com.kxw.network;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by kangxiongwei on 2015/7/17.
 * 通过TCP协议进行网络编程
 */
public class TCPServer {

    public static void main(String[] args) throws Exception{
        //建立socket
        ServerSocket serverSocket = new ServerSocket(5678);
        Socket socket = serverSocket.accept();
        //获取流
        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();
        //通过输入流来读取客户端发送过来的字符串
        byte[] buffer = new byte[100];
        int length = is.read(buffer,0,buffer.length);
        String readContent = new String(buffer,0,length);
        System.out.println("Read from client content: "+readContent);
        //通过输出流将响应写回给客户端
        String strLength = String.valueOf(readContent.length());
        os.write(strLength.getBytes());
        //关闭资源
        os.close();
        is.close();
        socket.close();
    }

}
