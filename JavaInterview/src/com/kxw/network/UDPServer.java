package com.kxw.network;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * Created by kangxiongwei on 2015/7/17.
 */
public class UDPServer {

    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(5678);
        //接收客户端发送的UDP数据报
        byte[] buffer = new byte[100];
        DatagramPacket packet = new DatagramPacket(buffer,100);
        socket.receive(packet);
        byte[] data = packet.getData();
        String receiveData = new String(data,0,packet.getLength());
        System.out.println(receiveData);

        //发送返回结果
        String receiveLength = String.valueOf(receiveData.length());
        DatagramPacket packet1 = new DatagramPacket(receiveLength.getBytes(),receiveLength.getBytes().length,packet.getAddress(),packet.getPort());
        socket.send(packet1);

        socket.close();
    }

}
