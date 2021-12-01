package com.sc.study.offer;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/5/18 4:35 下午
 * @desc 统计一个数字在排序数组中出现的次数。
 */
public class No53 {

    /**
     * 示例 1:
     * <p>
     * 输入: nums = [5,7,7,8,8,10], target = 8
     * 输出: 2
     * 示例2:
     * <p>
     * 输入: nums = [5,7,7,8,8,10], target = 6
     * 输出: 0
     * <p>
     * <p>
     * 限制：
     * <p>
     * 0 <= 数组长度 <= 50000
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if (null == nums) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        int count = 0;
        while (right >= left) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                count++;
                for (int i = mid - 1; i >= 0; i--) {
                    if (target == nums[i]) {
                        count++;
                    } else {
                        break;
                    }
                }
                for (int i = mid + 1; i < right; i++) {
                    if (target == nums[i]) {
                        count++;
                    } else {
                        break;
                    }
                }
                break;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        No53 no53 = new No53();
        System.out.println(no53.search(new int[]{2,2}, 2));
//        System.out.println(no53.search(new int[]{5, 7, 7, 8, 8, 10}, 6));
    }
}
