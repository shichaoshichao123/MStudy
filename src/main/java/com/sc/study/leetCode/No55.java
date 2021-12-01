package com.sc.study.leetCode;

import java.util.Arrays;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/5/26 4:01 下午
 * @desc 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个下标。
 */
public class No55 {
    /**
     * 示例1：
     * <p>
     * 输入：nums = [2,3,1,1,4]
     * 输出：true
     * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
     * 示例2：
     * <p>
     * 输入：nums = [3,2,1,0,4]
     * 输出：false
     * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
     * <p>
     * 提示：
     * <p>
     * 1 <= nums.length <= 3 * 104
     * 0 <= nums[i] <= 105
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        if (null == nums) {
            return false;

        }
        int arrive = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > arrive) {
                return false;
            }
            arrive = Math.max(nums[i] + i, arrive);
        }
        return true;

    }
}
