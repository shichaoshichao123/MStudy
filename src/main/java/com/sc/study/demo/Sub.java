package com.sc.study.demo;

import org.springframework.util.StringUtils;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/10/10 11:55 上午
 * @desc
 */
public class Sub {

    public static void main(String[] args) {
        System.out.println(getMaxSubChar("fish1o1234", "hisho1234"));
    }


    /**
     * 求两个字符串的最长公共子串
     *
     * @param a
     * @param b
     * @return
     */
    public static String getMaxSubChar(String a, String b) {
        if (StringUtils.isEmpty(a) || StringUtils.isEmpty(b)) {
            return null;
        }
        char[] ac = a.toCharArray();
        char[] bc = b.toCharArray();
        StringBuilder result = new StringBuilder();
        int[][] brand;
        if (ac.length >= bc.length) {
            brand = new int[ac.length][bc.length];
        } else {
            brand = new int[bc.length][ac.length];
        }
        int minLen = Math.min(ac.length, bc.length);
        for (int k = 0; k < brand.length; k++) {
            for (int i = k; i < brand.length; i++) {
                for (int j = 0; j < brand[0].length; j++) {
                    if (i < minLen) {
                        if (i == j) {
                            if (ac[i] == bc[i]) {
                                if (i == 0) {
                                    brand[i][j] = 1;
                                } else {
                                    brand[i][j] = brand[i - 1][j - 1] + 1;
                                }
                                result.append(ac[i]);
                            } else {
                                brand[i][j] = 0;
                            }
                        }
                    } else {
                        brand[i][j] = 0;
                    }
                }
            }
        }

        return result.toString();
    }
}

