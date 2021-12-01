package com.sc.study.leetCode;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/4/14 4:59 下午
 * @desc leetCode第七题
 */
public class No7 {

    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(0));
    }

    /**
     * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
     * <p>
     * 如果反转后整数超过 32 位的有符号整数的范围[−231, 231− 1] ，就返回 0。
     * <p>
     * 输入：x = 123
     * 输出：321
     * 输入：x = -123
     * 输出：-321
     * 输入：x = 120
     * 输出：21
     * 输入：x = 0
     * 输出：0
     *
     * @param x
     * @return
     */
    public static int reverse(int x) {
        if (0 == x) {
            return 0;
        }
        String xStr = x + "";
        if (x < 0) {
            xStr = xStr.substring(1);
        }
        String resStr = "";
        for (int i = xStr.length(); i > 0; i--) {
            resStr += xStr.substring(i - 1, i);
        }
        if (x < 0) {
            resStr = "-" + resStr;
        }
        try {
            return Integer.parseInt(resStr);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
