package com.sc.study.leetCode;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/9/25 10:34 上午
 * @desc
 */
public class GetSum {

    public static void main(String[] args) {
        System.out.println(getSumByDg(new int[]{2, 4, 6, 0, 2}));
    }

    /**
     * 通过递归的方式对一个数组求和
     *
     * @param data
     * @return
     */
    private static int getSumByDg(int[] data) {
        if (null == data || data.length == 0) {
            return 0;
        }
        //进行递归
        int[] sub = new int[data.length - 1];
        System.arraycopy(data, 1, sub, 0, data.length - 1);
        return data[0] + getSumByDg(sub);
    }


    /**
     * 快排
     *
     * @param data
     * @return
     */
    private static int[] quickSort(int[] data, int left, int right) {
        //已经有序
        if (null == data || data.length < 2) {
            return data;
        }
        int base = data[0];
        return null ;

    }
}

