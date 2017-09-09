package com.kxw.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.StringJoiner;

/**
 * Created by kangxiongwei on 2017/6/6.
 */
public class NioSocketServer {

    public static void main(String[] args) throws IOException {
        Selector selector = Selector.open();
        ServerSocketChannel channel = ServerSocketChannel.open();
        channel.configureBlocking(false);

        channel.socket().setReuseAddress(true);
        channel.socket().bind(new InetSocketAddress(10000));

        channel.register(selector, SelectionKey.OP_ACCEPT);

        while (selector.select() > 0) {
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                ByteBuffer buffer = ByteBuffer.allocate(1024);
                SelectionKey key = iterator.next();
                iterator.remove();
                ServerSocketChannel keyChannel = (ServerSocketChannel) key.channel();
                SocketChannel socketChannel = keyChannel.accept();

                //读取数据到buffer
                System.out.println("接收到以下数据");
                socketChannel.read(buffer);
                buffer.flip();
                StringBuilder builder = new StringBuilder();
                while (buffer.remaining() > 0) {
                    byte b = buffer.get();
                    builder.append((char) b);
                }
                System.out.println(builder.toString());

                //写出数据到channel
                

            }
        }

    }



}
