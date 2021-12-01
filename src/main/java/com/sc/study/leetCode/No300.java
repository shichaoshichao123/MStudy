package com.sc.study.leetCode;

import java.util.Arrays;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/5/27 7:40 下午
 * @desc 给你一个整数数组arr 和一个目标值target ，请你返回一个整数value，使得将数组中所有大于value 的值变成value 后，数组的和最接近 target（最接近表示两者之差的绝对值最小）。
 * <p>
 * 如果有多种使得和最接近target的方案，请你返回这些整数中的最小值。
 * <p>
 * 请注意，答案不一定是arr 中的数字。
 * <p>
 */
public class No300 {
    /**
     * 示例 1：
     * <p>
     * 输入：arr = [4,9,3], target = 10
     * 输出：3
     * 解释：当选择 value 为 3 时，数组会变成 [3, 3, 3]，和为 9 ，这是最接近 target 的方案。
     * 示例 2：
     * <p>
     * 输入：arr = [2,3,5], target = 10
     * 输出：5
     * 示例 3：
     * <p>
     * 输入：arr = [60864,25176,27249,21296,20204], target = 56803
     * 输出：11361
     * <p>
     * 提示：
     * <p>
     * 1 <= arr.length <= 10^4
     * 1 <= arr[i], target <= 10^5
     *
     * @param arr
     * @param target
     * @return
     */
    public int findBestValue(int[] arr, int target) {
        if (null == arr) {
            return 0;
        }
        //先排好序
        Arrays.sort(arr);
        int currentSum = 0;
        for (int i = 0; i < arr.length; i++) {
            int x = (target - currentSum) / arr.length - i;
            if (x < arr[i]) {
                //即判断curAve两边
                double curAveDou = (target * 1.0 - currentSum) / (arr.length - i);
                if (curAveDou - x <= 0.5) {
                    return x;
                } else {
                    return x + 1;
                }
            }
            currentSum += arr[i];

        }
        return arr[arr.length - 1];
    }
}
