package com.sc.study.leetCode;

import java.util.*;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/6/15 3:18 下午
 * @desc 给你一个整数数组arr ，请你将数组中的每个元素替换为它们排序后的序号。
 * <p>
 * 序号代表了一个元素有多大。序号编号的规则如下：
 * <p>
 * 序号从 1 开始编号。
 * 一个元素越大，那么序号越大。如果两个元素相等，那么它们的序号相同。
 * 每个数字的序号都应该尽可能地小。
 */
public class No1331 {
    /**
     * 示例 1：
     * <p>
     * 输入：arr = [40,10,20,30]
     * 输出：[4,1,2,3]
     * 解释：40 是最大的元素。 10 是最小的元素。 20 是第二小的数字。 30 是第三小的数字。
     * 示例 2：
     * <p>
     * 输入：arr = [100,100,100]
     * 输出：[1,1,1]
     * 解释：所有元素有相同的序号。
     * 示例 3：
     * <p>
     * 输入：arr = [37,12,28,9,100,56,80,5,12]
     * 输出：[5,3,4,2,8,6,7,1,3]
     */
    public int[] arrayRankTransform(int[] arr) {
        if (null == arr || arr.length == 0) {
            return new int[]{};
        }
        //去重
        List<Integer> data = new ArrayList<>();
        for (int k : arr) {
            if (!data.contains(k)) {
                data.add(k);
            }
        }
        Integer[] arr2 = new Integer[data.size()];
        data.toArray(arr2);
        Arrays.sort(arr2);
        Map<Integer, Integer> rankCache = new HashMap<>(8);
        int rank = 1;
        for (int j : arr2) {
            rankCache.putIfAbsent(j, rank++);
        }
        int[] result = new int[arr.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = rankCache.get(arr[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        No1331 no1331 = new No1331();
//        System.out.println(no1331.arrayRankTransform(new int[]{40, 10, 20, 30}));
//        System.out.println(no1331.arrayRankTransform(new int[]{100,100,100}));
        System.out.println(no1331.arrayRankTransform(new int[]{37, 12, 28, 9, 100, 56, 80, 5, 12}));
    }

}
