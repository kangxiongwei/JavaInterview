package com.kxw.io.nio;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.net.URL;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * NIO api测试
 * Created by kangxiongwei3 on 2017/5/23 14:12.
 */
public class NioApiTest {

    private static String path;
    private static FileInputStream in;

    /**
     * 初始化
     */
    @Before
    public void setUp() throws FileNotFoundException {
        URL url = NioApiTest.class.getClassLoader().getResource("");
        Assert.assertNotNull(url);
        path = url.getPath();
        in = new FileInputStream(path + "/canlidate.xml");
    }

    /**
     * 创建Buffer
     */
    @Test
    public void testCreateBuffer() {
        //ByteBuffer buffer = ByteBuffer.allocate(1024);
        byte array[] = new byte[1024];
        ByteBuffer buffer = ByteBuffer.wrap(array);

        buffer.put((byte) 'a');
        buffer.put((byte) 'b');
        buffer.put((byte) 'c');
        buffer.flip();
        System.out.println((char) buffer.get());
        System.out.println((char) buffer.get());
        System.out.println((char) buffer.get());
    }


    /**
     * 1. 从文件流读取数据到Channel
     * 2. 从Channel读取数据到Buffer
     * 3. 打印Buffer中的内容
     *
     * @throws IOException
     */
    @Test
    public void testReadChannel() throws IOException {
        //从文件流获取channel
        FileChannel channel = in.getChannel();
        //创建buffer
        ByteBuffer buffer = ByteBuffer.allocate(4096);
        //从channel读取数据到buffer中
        channel.read(buffer);

        buffer.flip();
        StringBuilder builder = new StringBuilder();
        while (buffer.remaining() > 0) {
            byte b = buffer.get();
            builder.append((char) b);
        }
        System.out.println(builder.toString());
    }

    /**
     * 写出buffer内容到文件
     *
     * @throws IOException
     */
    @Test
    public void testWriteChannel() throws IOException {
        byte message[] = {83, 111, 109, 101, 32, 98, 121, 116, 101, 115, 46};
        //从输出流获取channel
        FileOutputStream out = new FileOutputStream(new File("E:/channel.txt"));
        FileChannel channel = out.getChannel();
        //获取buffer
        ByteBuffer buffer = ByteBuffer.allocate(4096);
        for (int i = 0; i < message.length; i++) {
            buffer.put(message[i]);
        }
        buffer.flip();
        //写出数据到channel
        channel.write(buffer);
        //刷新
        out.flush();
    }

    /**
     * 用NIO拷贝文件
     */
    @Test
    public void testCopyFile() throws IOException {
        FileOutputStream out = new FileOutputStream("E:\\copy.txt");

        FileChannel fin = in.getChannel();
        FileChannel fout = out.getChannel();

        //ByteBuffer buffer = ByteBuffer.allocate(1024);
        ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
        while (true) {
            buffer.clear();
            int r = fin.read(buffer);
            if (r == -1) break;
            buffer.flip();
            fout.write(buffer);
        }
        out.flush();
        out.close();
    }

    /**
     * 释放资源
     *
     * @throws IOException
     */
    @After
    public void tearDown() throws IOException {
        in.close();
    }

}
