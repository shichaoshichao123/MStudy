package com.sc.study.leetCode;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/4/23 2:06 下午
 * @desc 给你一个整数数组nums 和一个整数 k。
 * <p>
 * 如果某个 连续 子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。
 * <p>
 * 请返回这个数组中「优美子数组」的数目。
 */
public class No1248 {

    /**
     * 示例 1：
     * <p>
     * 输入：nums = [1,1,2,1,1], k = 3
     * 输出：2
     * 解释：包含 3 个奇数的子数组是 [1,1,2,1] 和 [1,2,1,1] 。
     * 示例 2：
     * <p>
     * 输入：nums = [2,4,6], k = 1
     * 输出：0
     * 解释：数列中不包含任何奇数，所以不存在优美子数组。
     * 示例 3：
     * <p>
     * 输入：nums = [2,2,2,1,2,2,1,2,2,2], k = 2
     * 输出：16
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= nums.length <= 50000
     * 1 <= nums[i] <= 10^5
     * 1 <= k <= nums.length
     *
     * @param nums
     * @param k
     * @return
     */
    public int numberOfSubarrays(int[] nums, int k) {
        if (null == nums) {
            return 0;
        }
        if (nums.length < k) {
            return 0;
        }
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (numberOfSubarraysByDg(nums, i, j, k)) {
                    result++;
                }
            }
        }
        return result;

    }

    private boolean numberOfSubarraysByDg(int[] nums, int start, int end, int targetNum) {
        if ((end - start) + 1 < targetNum) {
            return false;
        }
        for (int i = start; i <= end; i++) {
            if (nums[i] % 2 == 1) {
                targetNum--;
            }
        }
        return targetNum == 0;
    }


    /**
     * 滑动窗口
     * <p>
     * 记录下每个奇数的下标，用arr数组暂存
     * 枚举所有的相邻的k个奇数，从窗口的左右开始扩展，遇到新的奇数前停止。通过排列组合可以通过统计左右可扩展的位置数计算总的可能，而不用暴力枚举
     *
     * @param
     */
    private int numberOfSubarraysByHdck(int[] nums, int target) {
        //记录下每个奇数的下标，用arr数组暂存
        int result = 0;
        int oldCount = 0;
        int[] oldCountIndex = new int[nums.length + 2];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 1) {
                //记录每个奇数在原数组的下标
                oldCountIndex[++oldCount] = i;
            }
        }
        //左边界
        oldCountIndex[0] = -1;
        //右边界
        oldCountIndex[oldCount + 1] = nums.length;
        // oldCountIndex[i]是窗口左边界
        // oldCountIndex[i+k-1] 是窗口右边界
        // oldCountIndex[i-1]是左边的上一个奇数，在此之后到arr[i]都可选
        // oldCountIndex[i+k]是右边的下一个奇数，在此之前都arr[i+k-1]都可选
        //前面可选部分长度为oldCountIndex[i]-oldCountIndex[i-1]
        //后面可选部分长度为oldCountIndex[i+k]-oldCountIndex[i+k-1]
        //总的可能数等于前后可选的组合
        for (int i = 1; i + target < oldCount + 2; i++) {
            result += (oldCountIndex[i] - oldCountIndex[i - 1]) * (oldCountIndex[i + target] - oldCountIndex[i + target - 1]);
        }
        return result;
    }

    public static void main(String[] args) {
        No1248 no1248 = new No1248();
        System.out.println(no1248.numberOfSubarrays(new int[]{2044, 96397, 50143}, 1));
        System.out.println(no1248.numberOfSubarrays(new int[]{1, 1, 1, 1, 1}, 1));
        System.out.println(no1248.numberOfSubarrays(new int[]{1, 1, 2, 1, 1}, 3));
        System.out.println(no1248.numberOfSubarrays(new int[]{2, 4, 6}, 1));
        System.out.println(no1248.numberOfSubarrays(new int[]{2, 2, 2, 1, 2, 2, 1, 2, 2, 2}, 2));
        System.out.println("------------------------------");
        System.out.println(no1248.numberOfSubarraysByHdck(new int[]{2044, 96397, 50143}, 1));
        System.out.println(no1248.numberOfSubarraysByHdck(new int[]{1, 1, 1, 1, 1}, 1));
        System.out.println(no1248.numberOfSubarraysByHdck(new int[]{1, 1, 2, 1, 1}, 3));
        System.out.println(no1248.numberOfSubarraysByHdck(new int[]{2, 4, 6}, 1));
        System.out.println(no1248.numberOfSubarraysByHdck(new int[]{2, 2, 2, 1, 2, 2, 1, 2, 2, 2}, 2));
    }


}
