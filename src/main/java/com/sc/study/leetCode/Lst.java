package com.sc.study.leetCode;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/5/15 2:56 下午
 * @desc
 */
public class Lst {
    /**
     * 用于获取一个数组的组大递增子数组（不要求元素间相邻）的长度
     * 使用动态规划的方式 时间复杂度 o(n2)
     *
     * @param origin
     * @return
     */
    public int getLst(int[] origin) {
        if (null == origin || origin.length == 0) {
            return 0;
        }
        int[] dp = new int[origin.length + 1];
        //初始化状态转移结果
        Arrays.fill(dp, 1);
        int res = 1;
        //进行状态递推
        for (int i = 0; i < origin.length; i++) {
            for (int j = 0; j < i; j++) {
                if (origin[j] < origin[i]) {
                    dp[i] = Math.max(dp[j], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    /**
     * 通过二分法进行查找 时间复杂度(o(nlog2n))
     *
     * @param origin
     * @return
     */
    public int getByBS(int[] origin) {
        if (null == origin || origin.length == 0) {
            return 0;
        }
        //用于存放零时结果并且在这上面进行二分查找
        List<Integer> lstList = new ArrayList<>();
        for (int i = 0; i < origin.length; i++) {
            if (CollectionUtils.isEmpty(lstList)) {
                lstList.add(origin[i]);
            } else {
                //在这里进行二分查找，如果发现当前数比容器内最大的数还要大直接往后面添加，其他情况下找跟当前元素差距最小的元素对齐进行替换

                int left = 0;
                int right = lstList.size() - 1;
                if (lstList.get(right) < origin[i]) {
                    lstList.add(origin[i]);
                } else {
                    int mid = 0;
                    while (right >= left) {
                        mid = (right + left) / 2;
                        if (lstList.get(mid) < origin[i]) {
                            left = mid + 1;
                        } else {
                            right = mid - 1;

                        }
                    }
                    lstList.set(mid, origin[i]);
                }
            }
        }
        return lstList.size();


    }

    public static void main(String[] args) {
        Lst lst = new Lst();
        System.out.println(lst.getLst(new int[]{1, 10, 9, 2, 101, 18, 20}));
        System.out.println(lst.getLst(new int[]{0, 1, 0, 3, 2, 3}));
        System.out.println(lst.getByBS(new int[]{1, 10, 9, 2, 101, 18, 20}));
        System.out.println(lst.getByBS(new int[]{0, 1, 0, 3, 2, 3}));
        System.out.println(lst.getByBS(new int[]{3,5,6,2,5,4,19,5,6,7,12}));
    }
}
