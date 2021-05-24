package com.sc.study.leetCode;

import java.util.Arrays;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/5/24 4:47 下午
 * @desc 给你一个整数数组arr。请你将数组中的元素按照其二进制表示中数字 1 的数目升序排序。
 * <p>
 * 如果存在多个数字二进制中1的数目相同，则必须将它们按照数值大小升序排列。
 * <p>
 * 请你返回排序后的数组。
 */
public class No1356 {
    /**
     * 示例 1：
     * 输入：arr = [0,1,2,3,4,5,6,7,8]
     * 输出：[0,1,2,4,8,3,5,6,7]
     * 解释：[0] 是唯一一个有 0 个 1 的数。
     * [1,2,4,8] 都有 1 个 1 。
     * [3,5,6] 有 2 个 1 。
     * [7] 有 3 个 1 。
     * 按照 1 的个数排序得到的结果数组为 [0,1,2,4,8,3,5,6,7]
     * 示例 2：
     * <p>
     * 输入：arr = [1024,512,256,128,64,32,16,8,4,2,1]
     * 输出：[1,2,4,8,16,32,64,128,256,512,1024]
     * 解释：数组中所有整数二进制下都只有 1 个 1 ，所以你需要按照数值大小将它们排序。
     * 示例 3：
     * <p>
     * 输入：arr = [10000,10000]
     * 输出：[10000,10000]
     * 示例 4：
     * <p>
     * 输入：arr = [2,3,5,7,11,13,17,19]
     * 输出：[2,3,5,17,7,11,13,19]
     * 示例 5：
     * <p>
     * 输入：arr = [10,100,1000,10000]
     * 输出：[10,100,10000,1000]
     *
     * @param arr
     * @return
     */
    public int[] sortByBits(int[] arr) {
        //先进行一次排序，那么之后如果计算出1的个数一样的情况直接往放
        Arrays.sort(arr);
        Domain[] result = new Domain[arr.length];
        for (int i = 0; i < arr.length; i++) {
            buildResult(result, arr[i]);
        }
        int[] data = new int[result.length];
        for (int i = 0; i < result.length; i++) {
            data[i] = result[i].originNum;
        }
        return data;
    }

    public static void main(String[] args) {
        No1356 no1356 = new No1356();
        System.out.println(no1356.sortByBits(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8}));

    }

    private void buildResult(Domain[] result, int currentNum) {
        int num = get1Num(currentNum);
        Domain currentDomain = new Domain(num, currentNum);
        if (null == result[0]) {
            result[0] = currentDomain;
            return;
        }
        for (int i = 0; i < result.length - 1; i++) {
            //说明最大了
            if (null == result[i]) {
                result[i] = currentDomain;
                break;
            } else if (result[i].num == num && (result[i + 1] == null || result[i + 1].num != num)) {
                for (int j = result.length - 2; j > i; j--) {
                    result[j + 1] = result[j];
                }
                result[i + 1] = currentDomain;
                break;
            } else if (result[i].num > num) {
                for (int j = result.length - 2; j >= i; j--) {
                    result[j + 1] = result[j];
                }
                result[i] = currentDomain;
                break;
            }
        }

    }

    /**
     * 获取制定整数二进制表示中1的个数
     *
     * @param n
     * @return
     */
    private int get1Num(int n) {
        if (n == 0) {
            return 0;
        }
        int result = 0;
        while (n != 0) {
            n = n & (n - 1);
            result++;
        }
        return result;
    }

    public static class Domain {
        int num;
        int originNum;

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public int getOriginNum() {
            return originNum;
        }

        public void setOriginNum(int originNum) {
            this.originNum = originNum;
        }

        public Domain(int num, int originNum) {
            this.num = num;
            this.originNum = originNum;
        }
    }
}
