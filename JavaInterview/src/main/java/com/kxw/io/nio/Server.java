package com.kxw.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Created by kangxiongwei3 on 2017/5/22 19:01.
 */
public class Server {

    public static void main(String[] args) throws IOException {
        //channel
        ServerSocketChannel channel = ServerSocketChannel.open();

        ServerSocket serverSocket = channel.socket();
        //地址重用
        serverSocket.setReuseAddress(true);
        serverSocket.bind(new InetSocketAddress("localhost", 9888));

        // 分配一个新的字节缓冲区
        ByteBuffer dst = ByteBuffer.allocate(4096);

        while (true) {
            SocketChannel socketChannel = channel.accept();
            //设置阻塞，接不到就停
            socketChannel.configureBlocking(true);
            int nread = 0;
            while (nread != -1) {
                try {
                    nread = socketChannel.read(dst);// 往缓冲区里读
                    byte[] array = dst.array();//将数据转换为array
                    //打印
                    String string = new String(array, 0, dst.position());
                    System.out.print(string);
                    dst.clear();
                } catch (IOException e) {
                    e.printStackTrace();
                    nread = -1;
                }
            }
        }


    }


}
