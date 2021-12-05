package com.sc.study.jiuzhang.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/11/24 6:36 下午
 * @desc
 */
public class Demo {
    public static void main(String[] args) {
        System.out.println(getAllSub(new int[]{1, 2, 3}));

        int[] origin = new int[]{0, 3, 5, 2, 9};
        System.out.println(origin);
        int[] date = getTartDiffIndex(origin, 1);
        System.out.println(Arrays.asList(date));
        System.out.println(origin);
        int[] origin1 = new int[]{0, 3, 5, 2, 9};
        System.out.println(windowSum(origin1,2));
    }

    /**
     * 获取所有子集
     *
     * @param origin
     * @return
     */
    private static List<List<Integer>> getAllSub(int[] origin) {
        List<List<Integer>> result = new ArrayList<>();
        if (null == origin) {
            return result;
        }
        doGetAllSub(origin, 0, new ArrayList<>(), result);
        return result;
    }

    private static void doGetAllSub(int[] origin, int deepIndex, List<Integer> temp, List<List<Integer>> result) {
        result.add(new ArrayList<>(temp));
        for (int i = deepIndex; i < origin.length; i++) {
            temp.add(origin[i]);
            doGetAllSub(origin, deepIndex + 1, temp, result);
            temp.remove(temp.size() - 1);
        }
    }

    private static int getUniqueNum(int[] origin) {
        if (null == origin || origin.length <= 0) {
            return 0;
        }
        Arrays.sort(origin);
        int i, j = 1;
        for (i = 0; i < origin.length; i++) {
            while (j < origin.length && origin[i] == origin[j]) {
                j++;
            }
            if (j >= origin.length) {
                break;
            }
            origin[i + 1] = origin[j];
        }
        return i + 1;
    }

    private static int[] getTartDiffIndex(int[] origin, int target) {
        if (null == origin || origin.length <= 1) {
            return null;
        }
        Arrays.sort(origin);
        target = Math.abs(target);
        int i, j = 1;
        for (i = 0; i < origin.length; i++) {
            j = Math.max(j, i + 1);
            while (j < origin.length && origin[j] - origin[i] < target) {
                j++;
            }
            if (j >= origin.length) {
                break;
            }
            if (origin[j] - origin[i] == target) {
                return new int[]{i, j};
            }
        }
        return new int[]{-1, -1};
    }

    private static List<Integer> windowSum(int[] origin, int rangeNum) {
        if (null == origin || origin.length < rangeNum) {
            return null;
        }
        List<Integer> result = new ArrayList<>();
        int i, j = 0;
        int current = 0;
        for (i = 0; i < origin.length; i++) {
            while (j < origin.length && j - i < rangeNum) {
                current += origin[j];
                j++;
            }
            if (j - i == rangeNum) {
                result.add(current);
            }
            //立马减掉第一个
            current -= origin[i];
        }
        return result;
    }
}
