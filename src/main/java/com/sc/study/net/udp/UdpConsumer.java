package com.sc.study.net.udp;

import lombok.SneakyThrows;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/6/21 4:53 下午
 * @desc
 * 用于搜索UDP报文
 */
public class UdpConsumer {
    @SneakyThrows
    public static void main(String[] args) {
        System.out.println("开始UdpConsumer。。。。");
        //构建DatagramSocket
        DatagramSocket datagramSocket = new DatagramSocket(20000);
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
        System.out.println("UdpConsumer 接收到来自IP:" + address + " 端口:" + port + "发来的UDP报文,内容长度:" + length + " 具体内容:" + data);
        //进行回传
        String response = "UdpConsumer收到了:" + data;
        byte[] responseData = response.getBytes();
        DatagramPacket responsePacket = new DatagramPacket(responseData, responseData.length, dataPacket.getAddress(), dataPacket.getPort());
        //发送回复
        datagramSocket.send(responsePacket);
        //完成整个过程
        System.out.println("结束UdpConsumer。。。。");
        datagramSocket.close();
    }
}
