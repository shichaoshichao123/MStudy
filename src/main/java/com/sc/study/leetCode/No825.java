package com.sc.study.leetCode;

import java.util.Arrays;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/4/27 3:23 下午
 * @desc 人们会互相发送好友请求，现在给定一个包含有他们年龄的数组，ages[i]表示第 i 个人的年龄。
 * <p>
 * 当满足以下任一条件时，A 不能给 B（A、B不为同一人）发送好友请求：
 * <p>
 * age[B]<= 0.5 * age[A]+ 7
 * age[B]> age[A]
 * age[B]> 100 &&age[A]< 100
 * 否则，A 可以给 B 发送好友请求。
 * <p>
 * 注意如果 A 向 B 发出了请求，不等于 B 也一定会向A 发出请求。而且，人们不会给自己发送好友请求。
 * <p>
 * 求总共会发出多少份好友请求?
 */
public class No825 {
    /**
     * 示例 1：
     * <p>
     * 输入：[16,16]
     * 输出：2
     * 解释：二人可以互发好友申请。
     * 示例 2：
     * <p>
     * 输入：[16,17,18]
     * 输出：2
     * 解释：好友请求可产生于 17 -> 16, 18 -> 17.
     * 示例 3：
     * <p>
     * 输入：[20,30,100,110,120]
     * 输出：3
     * 解释：好友请求可产生于 110 -> 100, 120 -> 110, 120 -> 100.
     *
     * @param ages
     * @return
     */
    public int numFriendRequests(int[] ages) {
        //排除为空或者只有一个人的情况
        if (null == ages || ages.length == 1) {
            return 0;
        }
        int result = 0;
        for (int i = 1; i < ages.length; i++) {
            for (int j = 0; j < i; j++) {
                result += isCanBeFriend(ages[j], ages[i]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        No825 no825 = new No825();
//        System.out.println(no825.numFriendRequests(new int[]{16}));
//        System.out.println(no825.numFriendRequests(new int[]{16, 16}));
        System.out.println(no825.numFriendRequests(new int[]{16, 17, 18}));
        System.out.println(no825.numFriendRequests(new int[]{101,56,69,48,30}));
//        System.out.println(no825.numFriendRequests(new int[]{20, 30, 100, 110, 120}));
    }

    /**
     * 校验是否可以成为朋友
     *
     * @return
     */
    private int isCanBeFriend(int a, int b) {
        if (a > b) {
            int temp = a;
            a = b;
            b = temp;
        }
        if (a <= b * 0.5 + 7) {
            return 0;
        }
        if (a > 100 && b < 100) {
            return 0;
        }
        if (a > b) {
            return 0;

        }
        if (a == b) {
            return 2;
        } else {
            return 1;
        }
    }

}
