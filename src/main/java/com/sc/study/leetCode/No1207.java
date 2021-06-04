package com.sc.study.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/6/4 3:54 下午
 * @desc 给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。
 * <p>
 * 如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。
 */
public class No1207 {
    /**
     * 示例 1：
     * <p>
     * 输入：arr = [1,2,2,1,1,3]
     * 输出：true
     * 解释：在该数组中，1 出现了 3 次，2 出现了 2 次，3 只出现了 1 次。没有两个数的出现次数相同。
     * 示例 2：
     * <p>
     * 输入：arr = [1,2]
     * 输出：false
     * 示例 3：
     * <p>
     * 输入：arr = [-3,0,1,-3,1,1,1,-3,10,0]
     * 输出：true
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= arr.length<= 1000
     * -1000 <= arr[i] <= 1000
     *
     * @param arr
     * @return
     */
    public boolean uniqueOccurrences(int[] arr) {
        if (null == arr || arr.length == 0) {
            return true;
        }
        List<Integer> nums = new ArrayList<>();
        List<Integer> countNums = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int currentCount = 0;
            int current = arr[i];
            if (nums.contains(current)) {
                continue;
            } else {
                nums.add(current);
            }
            for (int j = i + 1; j < arr.length; j++) {
                int nextCurrent = arr[j];
                if (current == nextCurrent) {
                    currentCount++;
                }
            }
            if (countNums.contains(currentCount)) {
                return false;
            } else {
                countNums.add(currentCount);

            }
        }
        return true;
    }

    public static void main(String[] args) {
        No1207 no1207 = new No1207();
        System.out.println(no1207.uniqueOccurrences(new int[]{1,2}));
        System.out.println(no1207.uniqueOccurrences(new int[]{1,2,2,1,1,3}));
        System.out.println(no1207.uniqueOccurrences(new int[]{-3,0,1,-3,1,1,1,-3,10,0}));
    }
}
