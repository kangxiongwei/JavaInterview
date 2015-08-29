package com.kxw.network;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Created by kangxiongwei on 2015/7/17.
 */
public class UDPClient {

    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        String str = "Hello World!";
        DatagramPacket packet = new DatagramPacket(str.getBytes(),str.length(), InetAddress.getLocalHost(),5678);
        socket.send(packet);

        byte[] buffer = new byte[100];
        DatagramPacket packet1 = new DatagramPacket(buffer,100);
        socket.receive(packet1);
        String response = new String(packet1.getData(),0,packet1.getLength());
        System.out.println("The server response is : "+response);

        socket.close();
    }

}
