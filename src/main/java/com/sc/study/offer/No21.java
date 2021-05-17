package com.sc.study.offer;

import java.util.Arrays;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/5/17 4:34 下午
 * @desc 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 */
public class No21 {
    /**
     * 示例：
     * <p>
     * 输入：nums =[1,2,3,4]
     * 输出：[1,3,2,4]
     * 注：[3,1,2,4] 也是正确的答案之一。
     * <p>
     * <p>
     * 提示：
     * <p>
     * 0 <= nums.length <= 50000
     * 1 <= nums[i] <= 10000
     *
     * @param nums
     * @return
     */
    public int[] exchange(int[] nums) {
        if (null == nums) {
            return null;
        }
        int changeIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            if (current % 2 == 1) {
                if (nums[changeIndex] % 2 != 1) {
                    int temp = nums[changeIndex];
                    nums[changeIndex] = current;
                    nums[i] = temp;
                }
                changeIndex++;
            } else {
                if (current % 2 == 1) {
                    changeIndex++;
                }
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        No21 no21 = new No21();
        System.out.println(Arrays.toString(no21.exchange(new int[]{1, 2, 3, 4})));
    }
}
