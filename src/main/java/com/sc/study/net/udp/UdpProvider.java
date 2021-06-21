package com.sc.study.net.udp;

import lombok.SneakyThrows;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/6/21 4:53 下午
 * @desc 用于发送UDP报文
 */
public class UdpProvider {

    @SneakyThrows
    public static void main(String[] args) {
        System.out.println("开始UdpProvider。。。。");
        //构建DatagramSocket
        DatagramSocket datagramSocket = new DatagramSocket();
        //发送数据
        String response = "来自UdpProvider:你好！";
        byte[] responseData = response.getBytes();
        DatagramPacket responsePacket = new DatagramPacket(responseData, responseData.length);
        responsePacket.setAddress(Inet4Address.getLocalHost());
        responsePacket.setPort(20000);
        //发送
        datagramSocket.send(responsePacket);
        //创建接收实体
        final byte[] buf = new byte[1024];
        //创建报文对象
        DatagramPacket dataPacket = new DatagramPacket(buf, buf.length);
        //接收UDP数据
        datagramSocket.receive(dataPacket);
        //获取得到的报文信息
        String address = dataPacket.getAddress().getHostAddress();
        int port = dataPacket.getPort();
        int length = dataPacket.getLength();
        String data = new String(dataPacket.getData(), 0, length);
        //输出接收到的数据
        System.out.println("UdpProvider 接收到来自IP:" + address + " 端口:" + port + "发来的UDP报文,内容长度:" + length + " 具体内容:" + data);
        //完成整个过程
        System.out.println("结束UdpProvider。。。。");
        datagramSocket.close();
    }
}
