package com.kxw.io.nio;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

/**
 * Created by kangxiongwei3 on 2017/5/22 19:01.
 */
public class Client {

    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        // 打开socket的nio管道
        SocketChannel sc = SocketChannel.open();
        sc.connect(new InetSocketAddress("localhost", 10000));// 绑定相应的ip和端口
        sc.configureBlocking(true);// 设置阻塞
        // 将文件放到channel中
        FileChannel fc = new FileInputStream("/Users/kangxiongwei/my.cnf").getChannel();// 打开文件管道
        //做好标记量
        long size = fc.size();
        int pos = 0;
        int offset = 4096;
        long curnset = 0;
        long counts = 0;
        //循环写
        while (pos < size) {
            curnset = fc.transferTo(pos, 4096, sc);//把文件直接读取到socket chanel中，返回传输的字节数
            pos += offset;
            counts += curnset;
        }
        //关闭
        fc.close();
        sc.close();
        //打印传输字节数
        System.out.println(counts);
        // 打印时间
        System.out.println("bytes send--" + counts + " and totaltime--"
                + (System.currentTimeMillis() - start));
    }


}
