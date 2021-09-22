package com.sc.study.leetCode;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/9/12 9:38 上午
 * @desc
 */
public class Demo2 {

    public static void main(String[] args) {
        Demo2 demo2 = new Demo2();
//        int[] data = new int[]{-1, -1, 2, -1, 1, 9, -1, -2, 1};
        int[] data = new int[]{-5, -1, -2, 1, -2, -6};
//        int[] data = new int[]{1,2,-3};
        int[] result = demo2.getMaxSubChar2(data);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

    private int[] getMaxSubChar1(int[] data) {
        int left = 0;
        int right = 0;
        if (null == data) {
            return null;
        }
        int len = data.length;
        int max = 0;
        for (int i = 0; i < len; i++) {
            int temp = data[i];
            for (int j = i + 1; j < len; j++) {
                temp += data[j];
                if (temp > max) {
                    left = i;
                    right = j;
                    max = temp;
                }
            }
        }
        return new int[]{left, right};
    }

    /**
     * 使用类似滑动窗口的方式
     *
     * @param data
     * @return
     */
    private int[] getMaxSubChar2(int[] data) {
        int left = 0;
        int right = 0;
        if (null == data) {
            return null;
        }
        int len = data.length;
        int temp = 0;
//        int max = Integer.MIN_VALUE;
//        for (int i = 0; i < len; i++) {
//            if (max < data[i]) {
//                max = data[i];
//                left = i;
//                right = i;
//            }
//        }
//        if (max <= 0) {
//            return new int[]{left, right};
//        }
        left = 0;
        int max = 0;
        int resLeft = 0;
        int resRight = 0;
        for (int i = 0; i < len; i++) {
            temp += data[i];
            if (temp <= 0) {
                left = i + 1;
                temp = 0;
            }
            if (max < temp) {
                max = temp;
                right = i;
                resLeft = left;
                resRight = right;
            }

        }
        return new int[]{resLeft, resRight};
    }

}
