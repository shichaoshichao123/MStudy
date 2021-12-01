package com.sc.study.socket;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/6/8 8:50 下午
 * @desc
 */
public class Server {

    @SneakyThrows
    public static void main(String[] args) {
        ServerSocket server = new ServerSocket(8888);
        //打开服务
        System.out.println("服务器启动完成");

        while (true) {
            //得到客户端连接
            Socket socket = server.accept();
            //构建客户端处理器
            ClientHandler clientHandler = new ClientHandler(socket);
            //进行处理
            clientHandler.start();
        }
    }

    /**
     * 进行服务端逻辑
     *
     * @param server
     */
    private static void doServer(Socket server) {

    }

    private static class ClientHandler extends Thread {
        private Socket client;
        private boolean flag = true;

        public ClientHandler(Socket client) {
            this.client = client;
        }

        @SneakyThrows
        @Override
        public void run() {
            super.run();
            System.out.println("有新的客户端连接进来:" + client.getInetAddress() + " 端口:" + client.getPort());
            //得到打印流用于给客户端回传消息
            try {
                PrintStream socketOutput = new PrintStream(client.getOutputStream());
                //得到输入流用于接收客户端的消息
                BufferedReader socketInput = new BufferedReader(new InputStreamReader(client.getInputStream()));
                do {
                    String message = socketInput.readLine();
                    if ("bye".equalsIgnoreCase(message)) {
                        flag = false;
                        socketOutput.println("bye");
                    } else {
                        System.out.println("客户端:" + message);
                        socketOutput.println("服务器:收到，" + message);
                    }
                } while (flag);
                socketInput.close();
                socketOutput.close();
            } catch (IOException e) {
                System.out.println(e);
            } finally {
                client.close();
            }
            System.out.println("客户端关闭连接.....");
        }
    }

}
