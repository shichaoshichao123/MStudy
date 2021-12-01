package com.sc.study.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/4/21 6:18 下午
 * @desc 如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为摆动序列。第一个差（如果存在的话）可能是正数或负数。少于两个元素的序列也是摆动序列。
 * <p>
 * 例如，[1,7,4,9,2,5] 是一个摆动序列，因为差值 (6,-3,5,-7,3)是正负交替出现的。相反, [1,4,7,2,5]和[1,7,4,5,5] 不是摆动序列，第一个序列是因为它的前两个差值都是正数，第二个序列是因为它的最后一个差值为零。
 * <p>
 * 给定一个整数序列，返回作为摆动序列的最长子序列的长度。 通过从原始序列中删除一些（也可以不删除）元素来获得子序列，剩下的元素保持其原始顺序。
 */
public class No376 {

    public static void main(String[] args) {
        No376 no376 = new No376();
        System.out.println(no376.wiggleMaxLength(new int[]{1, 7, 4, 9, 2, 5}));
        System.out.println(no376.wiggleMaxLength(new int[]{1,17,5,10,13,15,10,5,16,8}));
        System.out.println(no376.wiggleMaxLength(new int[]{1,2,3,4,5,6,7,8,9}));
    }

    /**
     * 示例 1:
     * <p>
     * 输入: [1,7,4,9,2,5]
     * 输出: 6
     * 解释: 整个序列均为摆动序列。
     * 示例 2:
     * <p>
     * 输入: [1,17,5,10,13,15,10,5,16,8]
     * 输出: 7
     * 解释: 这个序列包含几个长度为 7 摆动序列，其中一个可为[1,17,10,13,10,16,8]。
     * 示例 3:
     * <p>
     * 输入: [1,2,3,4,5,6,7,8,9]
     * 输出: 2
     * 进阶:
     * 你能否用O(n) 时间复杂度完成此题?
     *
     * @param nums
     * @return
     */
    public int wiggleMaxLength(int[] nums) {
        if (null == nums) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int flag = -100;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length ; i++) {
            if (i + 1 == nums.length) {
                result.add(nums[i]);
                break;
            }
            int currentResult = nums[i] - nums[i + 1];
            if (currentResult < 0) {
                if (flag == -1) {
                    continue;
                }
                flag = -1;
            } else if (currentResult > 0) {
                if (flag == 1) {
                    continue;
                }
                flag = 1;

            } else {
                continue;
            }
            result.add(nums[i]);
        }
        return result.size();
    }

}
