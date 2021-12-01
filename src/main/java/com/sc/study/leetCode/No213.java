package com.sc.study.leetCode;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/4/15 11:40 上午
 * @desc 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，能够偷窃到的最高金额。
 */
public class No213 {

    public static void main(String[] args) {
        int[] nums1 = new int[]{2, 3, 2};
        int[] nums2 = new int[]{1, 2, 3, 1};
        int[] nums3 = new int[]{0};
        System.out.println(rob(nums1));
        System.out.println(rob(nums2));
        System.out.println(rob(nums3));
    }

    /**
     * 示例1：
     * <p>
     * 输入：nums = [2,3,2]
     * 输出：3
     * 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
     * 示例 2：
     * <p>
     * 输入：nums = [1,2,3,1]
     * 输出：4
     * 解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
     * 偷窃到的最高金额 = 1 + 3 = 4 。
     * 示例 3：
     * <p>
     * 输入：nums = [0]
     * 输出：0
     *
     * @param nums
     * @return
     */
    public static int rob(int[] nums) {
        //使用动态规划的方式，分别区分可从第一个房间开始偷，或者只能从第二个房间开始偷的情况,这样刚好覆盖全量
        if (null != nums) {
            if(nums.length==1){
                return nums[0];
            }
            int[] dp1 = new int[nums.length];
            int[] dp2 = new int[nums.length];
            //初始化最开始的值
            dp1[0] = nums[0];
            dp1[1] = Math.max(nums[0], nums[1]);
            dp2[0] = 0;
            dp2[1] = nums[1];
            for (int i = 2; i < nums.length; i++) {
                dp1[i] = Math.max(dp1[i - 2] + nums[i], dp1[i - 1]);
                dp2[i] = Math.max(dp2[i - 2] + nums[i], dp2[i - 1]);
            }
            return Math.max(dp1[nums.length - 2], dp2[nums.length - 1]);
        }
        return 0;

    }

}
