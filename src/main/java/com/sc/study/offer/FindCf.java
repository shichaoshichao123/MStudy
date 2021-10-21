package com.sc.study.offer;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/10/16 2:19 下午
 * @desc
 */
public class FindCf {

    public static void main(String[] args) {
//        System.out.println(getDuplicateNum(new int[]{2, 3, 1, 0, 2, 5, 3}));
        System.out.println(getDuplicateNumByRange(new int[]{7, 3, 1, 8, 2, 5, 3}));
    }

    /**
     * 通过修改数组的方式查询出数组中的一个重复元素
     * -1 代表没有重复的元素
     * [2,3,1,0,2,5,3]
     * 要求空间复杂度O(1)
     *
     * @param nums
     * @return
     */
    public static int getDuplicateNum(int[] nums) {
        if (null == nums || nums.length == 0) {
            return -1;
        }
        for (int num : nums) {
            if (nums[1] < 0 || num > nums.length - 1) {
                return -1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            //这里会直到找到对应序号的值或者有重复的值为止跳出循环
            while (i != nums[i]) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                } else {
                    //交换
                    int temp = nums[i];
                    nums[i] = nums[temp];
                    nums[temp] = temp;
                }
            }
        }
        return -1;
    }

    /**
     * 再不修改原数组的情况下查找一个重复元素
     * 要求空间复杂度O(1)
     *
     * @param nums
     * @return
     */
    public static int getDuplicateNumByRange(int[] nums) {
        if (null == nums || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            int count = showTimes(nums, start, mid);
            if (start == mid) {
                if (count > 1) {
                    return start;
                } else {
                    break;
                }
            }
            if (count > mid - start + 1) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    private static int showTimes(int[] nums, int left, int right) {
        if (null == nums || left > right) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= left && nums[i] <= right) {
                count++;
            }
        }
        return count;

    }
}
