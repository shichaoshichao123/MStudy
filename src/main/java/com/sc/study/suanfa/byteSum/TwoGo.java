package com.sc.study.suanfa.byteSum;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/4/1 9:53 下午
 * @desc 二进制运算
 */
public class TwoGo {

    public static void main(String[] args) {
        System.out.println(get1NumWithTowGo(1));
        System.out.println(get1NumWithTowGo2(3));
        System.out.println(calculateNCiMi(2));
        System.out.println(calculateNCiMi(4));
        System.out.println(calculateNCiMi(9));
        System.out.println(getAllBitNumByTargetNum(9));
    }

    /**
     * 计算某个整数对应的二进制表示中1的个数
     * 如:整数3 对应的二进制表示 011 值就为2
     * <p>
     *
     * @param n
     * @return
     */
    private static int get1NumWithTowGo(int n) {
        if (0 == n) {
            return 0;
        }
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }

    /**
     * 计算某个整数对应的二进制表示中1的个数
     *
     * @param n
     * @return
     */
    private static int get1NumWithTowGo2(int n) {
        if (0 == n) {
            return 0;
        }
        //用来进行与运算的标志位
        int mask = 1;
        int count = 0;
        for (int i = 0; i < 32; i++) {
            //注意这里要使用不等于零
            if (0 != (n & mask)) {
                count++;
            }
            //更新mask位 思想：1 位左移动一位就变成了 10 。。100。等。。这样刚好能一直到32位每次都与目标数二进制位的对应位进行以1位标识位的与操作
            mask = mask << 1;
        }
        return count;
    }

    /**
     * 位运算判断某个数是都是2的那次幂
     *
     * @param n
     * @return
     */
    private static boolean calculateNCiMi(int n) {
        if (n <= 0) {
            return false;
        }
        //由于如果一个数是2的n次幂的二进制表示，为1的位数一定是一个，那么我们就可以通过判断为1的位数去做
        int num = 0;
        while (n != 0) {
            n = n & (n - 1);
            num++;
        }
        return 1 == num;
    }


    /**
     * 计算比特位数
     *
     * @param num
     * @return
     */
    private static int[] getAllBitNumByTargetNum(int num) {
        if (num <= 0) {
            return null;
        }
        int[] result = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            result[i] = result[i & (i - 1)] + 1;
        }
        return result;
    }
}
