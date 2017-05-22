package com.kxw.io.bio;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 服务端
 * <p>
 * Created by kangxiongwei3 on 2017/5/22 17:45.
 */
public class SocketServer {

    //线程池
    private static final ExecutorService pool = Executors.newFixedThreadPool(10);

    public static void main(String[] args) throws IOException {

        ServerSocket server = new ServerSocket(8888);
        //不断尝试获取新连接
        while (true) {
            //获取客户端连接
            Socket socket = server.accept();
            if (socket != null) System.out.println("有新的客户端连接上了...");
            pool.execute(new SocketServerThread(socket));
        }

    }


    static class SocketServerThread implements Runnable {

        private Socket socket;

        public SocketServerThread(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            InputStream in = null;
            OutputStream out = null;
            //从客户端获取
            try {
                in = socket.getInputStream();
                out = socket.getOutputStream();
                //读取客户端内容
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                String line;
                StringBuffer buffer = new StringBuffer("接收到的字符串为：\n");
                while ((line = reader.readLine()) != null && !"EOF".equals(line)) {
                    buffer.append(line).append("\n");
                }
                //写出服务端内容
                PrintWriter writer = new PrintWriter(new OutputStreamWriter(out));
                writer.println(buffer.toString());
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (in != null) in.close();
                    if (out != null) out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
