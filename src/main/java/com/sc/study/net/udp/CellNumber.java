package com.sc.study.net.udp;

import lombok.SneakyThrows;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.UUID;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/6/21 8:01 下午
 * @desc 广播接收者
 */
public class CellNumber {

    @SneakyThrows
    public static void main(String[] args) {
        String sn = UUID.randomUUID().toString();
        CellListener cellListener = new CellListener(sn);
        cellListener.start();
        //读取任意字符腿出
        System.in.read();
        cellListener.exit();

    }

    private static class CellListener extends Thread {
        //唯一标识
        private final String sn;
        private boolean done = false;
        private DatagramSocket datagramSocket;

        public CellListener(String sn) {
            this.sn = sn;
        }

        @SneakyThrows
        @Override
        public void run() {
            super.run();
            System.out.println("开始监听广播 .....");
            try {
                datagramSocket = new DatagramSocket(20000);
                while (!done) {
                    byte[] buf = new byte[1024];
                    DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length);
                    //接收广播
                    datagramSocket.receive(datagramPacket);
                    String address = datagramPacket.getAddress().getHostAddress();
                    int port = datagramPacket.getPort();
                    int length = datagramPacket.getLength();
                    String data = new String(datagramPacket.getData(), 0, length);
                    //输出接收到的数据
                    System.out.println("接收到来自IP:" + address + " 端口:" + port + "发来的UDP广播报文,内容长度:" + length + " 具体内容:" + data);
                    //获取回播端口
                    int responsePort = MessageCreator.parsePort(data);
                    if (-1 != responsePort) {
                        //构建广播回播报文
                        String response = MessageCreator.buildResponseMessage(sn);
                        byte[] responseData = response.getBytes();
                        DatagramPacket responsePacket = new DatagramPacket(responseData, responseData.length, datagramPacket.getAddress(), responsePort);
                        datagramSocket.send(responsePacket);
                        System.out.println("完成广播监听回播，回播端口:" + responsePort);

                    }

                }
            } catch (SocketException ignore) {
            } finally {
                close();
            }
            System.out.println("结束广播监听.....");

        }

        private void close() {
            if (datagramSocket != null) {
                datagramSocket.close();
                datagramSocket = null;
            }
        }

        void exit() {
            done = true;
            close();
        }
    }
}
