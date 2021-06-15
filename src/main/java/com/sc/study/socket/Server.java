package com.sc.study.socket;

import lombok.SneakyThrows;

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
        Socket socket = server.accept();
    }

    /**
     * 进行服务端逻辑
     *
     * @param server
     */
    private static void doServer(Socket server) {

    }

}
