package com.sc.study.socket;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Inet4Address;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/6/8 8:50 下午
 * @desc
 */
public class Client {
    @SneakyThrows
    public static void main(String[] args) {
        Socket client = new Socket();
        client.setSoTimeout(3000);
        client.connect(new InetSocketAddress(Inet4Address.getLocalHost(), 8888), 3000);
        System.out.println("已经与服务器建立了连接.....");

        try {
            doClient(client);
        } catch (Exception e) {
            System.out.println("客户端发送数据失败:" + e);
        }
        client.close();
        System.out.println("与服务器断开连接...");
    }

    @SneakyThrows
    private static void doClient(Socket client) {
        //构建键盘输入流
        InputStream inputStream = System.in;
        BufferedReader input = new BufferedReader(new InputStreamReader(inputStream));

        //获取socket输出流
        PrintStream printStream = new PrintStream(client.getOutputStream());

        //获取socket输入流
        BufferedReader socketIn = new BufferedReader(new InputStreamReader(client.getInputStream()));
        boolean continueFlag = true;
        do {
            //读取键盘输入的一行发送给服务器
            printStream.println(input.readLine());
            //接收服务器返回的数据并输出
            String echo = socketIn.readLine();
            if ("bye".equalsIgnoreCase(echo)) {
                continueFlag = false;
            }
            System.out.println(echo);
        } while (continueFlag);
        //关闭相关流资源
        printStream.close();
        socketIn.close();
        input.close();
    }
}
