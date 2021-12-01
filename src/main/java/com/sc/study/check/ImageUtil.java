package com.sc.study.check;

import java.util.Random;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/6/3 2:13 下午
 * @desc
 */
public class ImageUtil {
    private static String path;
    public static String getUrl(String imagePath) {
        path = imagePath;
        if (path.isEmpty()) {
            return null;
        } else {
            Random random = new Random();
            try {
                Thread.sleep(random.nextInt(10) * 100L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return path.startsWith("/") ? "https://cdn.wanwudezhi.com" + path : "https://cdn.wanwudezhi.com/" + path;
        }
    }

}
