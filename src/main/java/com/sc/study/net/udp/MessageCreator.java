package com.sc.study.net.udp;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/6/21 5:16 下午
 * @desc
 */
public class MessageCreator {
    private static final String LEADER_PORT = "我在找你们，收到广播的回复端口:";
    private static final String CELL_PORT = "已经收到广播,我的回复内容:";


    /**
     * 构建广播搜索信息
     *
     * @param port
     * @return
     */
    public static String buildSearchMessageWithPort(int port) {
        return LEADER_PORT + port;

    }

    /**
     * 解析广播搜索回传端口
     *
     * @param searchMessage
     * @return
     */
    public static int parsePort(String searchMessage) {
        if (searchMessage.startsWith(LEADER_PORT)) {
            return Integer.parseInt(searchMessage.substring(LEADER_PORT.length()));
        }
        return -1;
    }


    /**
     * 构建广播回传信息
     *
     * @param res
     * @return
     */
    public static String buildResponseMessage(String res) {
        return CELL_PORT + res;
    }

    /**
     * 用于解析广播回传信息
     *
     * @param response
     * @return
     */
    public static String parseResponseMessage(String response) {
        if (response.startsWith(CELL_PORT)) {
            return response.substring(CELL_PORT.length());
        }
        return null;
    }

}
