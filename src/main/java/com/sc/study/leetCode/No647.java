package com.sc.study.leetCode;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/5/11 5:02 下午
 * @desc 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串
 */
public class No647 {
    /**
     * 示例 1：
     * <p>
     * 输入："abc"
     * 输出：3
     * 解释：三个回文子串: "a", "b", "c"
     * 示例 2：
     * <p>
     * 输入："aaa"
     * 输出：6
     * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
     *
     * @param s
     * @return
     */
    public int countSubstrings(String s) {
        if (null == s) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (isReturnText(s.substring(i, j+1))) {
                    count++;
                }
            }
        }
        return count;

    }

    public static void main(String[] args) {
        No647 no647 = new No647();
        System.out.println(no647.countSubstrings("abc"));
//        System.out.println(no647.countSubstrings("aaa"));
    }

    /**
     * 校验是否是回文
     *
     * @param text
     * @return
     */
    private boolean isReturnText(String text) {
        if (null == text) {
            return false;
        }

        text = text.trim();
        int length = text.length();
        if (length == 0) {
            return false;
        }
        if (length == 1) {
            return true;
        }
        int left = 0;
        int right = length - 1;
        if (0 == length % 2) {
            //偶数长度
            while (left < right) {
                if (text.charAt(left) != text.charAt(right)) {
                    return false;
                }
                left++;
                right--;
            }
            return true;
        } else {
            //奇数长度
            int mid = length / 2;
            while (left < mid) {
                if (text.charAt(left) != text.charAt(right)) {
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }

    }


}
