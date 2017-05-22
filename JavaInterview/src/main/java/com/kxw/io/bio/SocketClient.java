package com.kxw.io.bio;

import java.io.*;
import java.net.Socket;

/**
 * 客户端
 *
 * Created by kangxiongwei3 on 2017/5/22 18:23.
 */
public class SocketClient {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8888);
        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();

        PrintWriter writer = new PrintWriter(new OutputStreamWriter(out));
        writer.println("hello socket");
        writer.println("hello BIO");
        writer.println("EOF");
        writer.flush();

        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }

        in.close();
        out.close();
    }



}
