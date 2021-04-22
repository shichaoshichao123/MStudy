package com.sc.study.sf.list;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/4/22 1:44 下午
 * @desc
 */
public class DpDemo {

    public static void main(String[] args) {
        Long start1 = System.currentTimeMillis();
        System.out.println(doGetFbnqbyDg(50));
        System.out.println("耗时:" + (System.currentTimeMillis() - start1));
        Long start2 = System.currentTimeMillis();
        System.out.println(doGetFbnqbyDp(50));
        System.out.println("耗时:" + (System.currentTimeMillis() - start2));
    }

    /**
     * 递归的方式求斐波那契数
     *
     * @param n
     * @return
     */
    private static double doGetFbnqbyDg(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        return doGetFbnqbyDg(n - 1) + doGetFbnqbyDg(n - 2);
    }

    /**
     * 通过动态规划的方式求解斐波那契
     *
     * @param n
     * @return
     */
    private static double doGetFbnqbyDp(int n) {
        double[] result = new double[n + 1];
        result[0] = 0;
        result[1] = 1;
        result[2] = 2;
        for (int i = 3; i <= n; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }
        return result[n-1];

    }
}
