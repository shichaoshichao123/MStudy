package com.sc.study.leetCode;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/6/15 5:09 下午
 * @desc 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
 * 请注意，你可以假定字符串里不包括任何不可打印的字符。
 */
public class No434 {
    /**
     * 输入: "Hello, my name is John"
     * 输出: 5
     * 解释: 这里的单词是指连续的不是空格的字符，所以 "Hello," 算作 1 个单词。
     *
     * @param s
     * @return
     */
    public int countSegments(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        String[] split = s.split(" ");
        int res = 0;
        for (String s2 : split) {
            if (s2.length() > 0) {
                res++;

            }
        }
        return res;
    }

    public static void main(String[] args) {
        No434 no434 = new No434();
        System.out.println(no434.countSegments("Hello, my name is John"));
        System.out.println(no434.countSegments(", , , ,        a, eaefa"));
    }
}
