package com.sc.study.net.udp;

import lombok.SneakyThrows;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/6/21 5:58 下午
 * @desc 搜索者
 */
public class Searcher {

    /**
     * 广播回调接口
     */
    private static final int COLL_BACK_PORT = 30000;

    @SneakyThrows
    public static void main(String[] args) {
        System.out.println("开始进行广播搜索.....");
        Listener listener = doListener();
        sendBroadcast();
        System.in.read();
        List<Device> devices = listener.getDevicesAndClose();
        for (Device item : devices) {
            System.out.println("收到广播的设备:" + item);
        }
        System.out.println("结束广播搜索.....");

    }

    /**
     * 用于发送广播信息
     */
    @SneakyThrows
    private static void sendBroadcast() {
        System.out.println("开始发送广播报文.....");
        DatagramSocket datagramSocket = new DatagramSocket();
        String message = MessageCreator.buildSearchMessageWithPort(COLL_BACK_PORT);
        byte[] messageData = message.getBytes();
        //组装udp包
        DatagramPacket datagramPacket = new DatagramPacket(messageData, messageData.length);
        datagramPacket.setAddress(Inet4Address.getByName("255.255.255.255"));
        datagramPacket.setPort(20000);
        //发送
        datagramSocket.send(datagramPacket);
        datagramSocket.close();
        System.out.println("广播报文发送完成.....");
    }

    /**
     * 进行监听工作
     *
     * @return
     * @throws InterruptedException
     */
    private static Listener doListener() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Listener listener = new Listener(COLL_BACK_PORT, countDownLatch);
        listener.start();
        System.out.println("开始监听广播回调.....");
        countDownLatch.await();
        return listener;
    }

    static class Device {
        int port;
        String ip;
        String sn;

        public Device(int port, String ip, String sn) {
            this.port = port;
            this.ip = ip;
            this.sn = sn;
        }

        @Override
        public String toString() {
            return "Device{" +
                    "port=" + port +
                    ", ip='" + ip + '\'' +
                    ", sn='" + sn + '\'' +
                    '}';
        }
    }

    /**
     * 回调监听类
     */
    static class Listener extends Thread {
        private final int listenerPort;
        private final CountDownLatch countDownLatch;
        private final List<Device> devices = new ArrayList<>();
        private boolean done = false;
        private DatagramSocket ds = null;

        public Listener(int listenerPort, CountDownLatch countDownLatch) {
            this.listenerPort = listenerPort;
            this.countDownLatch = countDownLatch;
        }

        @SneakyThrows
        @Override
        public void run() {
            super.run();
            //通知启动
            countDownLatch.countDown();
            try {
                ds = new DatagramSocket(COLL_BACK_PORT);
                while (!done) {
                    byte[] buff = new byte[1024];
                    DatagramPacket datagramPacket = new DatagramPacket(buff, buff.length);
                    ds.receive(datagramPacket);
                    String address = datagramPacket.getAddress().getHostAddress();
                    int port = datagramPacket.getPort();
                    int length = datagramPacket.getLength();
                    String data = new String(datagramPacket.getData(), 0, length);
                    //输出接收到的数据
                    System.out.println("接收到来自IP:" + address + " 端口:" + port + "发来的UDP回播报文,内容长度:" + length + " 具体内容:" + data);
                    String sn = MessageCreator.parseResponseMessage(data);
                    if (null != sn) {
                        Device device = new Device(port, address, sn);
                        devices.add(device);
                    }

                }
            } catch (SocketException ignore) {
            } finally {
                close();
            }
            System.out.println("监听结束.....");
        }

        private void close() {
            if (null != ds) {
                ds.close();
                ds = null;
            }
        }

        List<Device> getDevicesAndClose() {
            done = true;
            close();
            return devices;
        }

    }
}
