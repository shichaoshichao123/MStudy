package com.sc.study.jiuzhang.recursive;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/11/24 6:32 下午
 * @desc
 */
public class Demo {

    public static void main(String[] args) {
        int[] origin5 = new int[]{1, 2, 3, 4, 7, 9};
        System.out.println(erfenSearch(origin5, 9));
    }


    public static int erfenSearch(int[] origin, int target) {
        if (null == origin || origin.length <= 0) {
            return -1;
        }
        int start = 0, end = origin.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            int cur = origin[mid];
            if (cur == target) {
                return mid;
            } else if (cur < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (origin[start] == target) {
            return start;
        }
        if (origin[end] == target) {
            return end;
        }
        return -1;
    }
}
