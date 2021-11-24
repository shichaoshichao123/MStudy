package com.sc.study.jiuzhang.sort;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/11/24 6:17 下午
 * @desc
 */
public class Demo6 {
    public static void main(String[] args) {
        int[] origin = new int[]{2, 3, 1, 6, 5, 4, 33, 44, 55, 66, 1};
        Sort.printInfo(origin);
//        quickSort6(origin);
        mergeSort6(origin, 0, origin.length - 1, new int[origin.length]);
        System.out.println();
        Sort.printInfo(origin);
    }

    public static void quickSort6(int[] origin) {
        if (null == origin || origin.length <= 1) {
            return;
        }
        doQuickSort6(origin, 0, origin.length - 1);
    }

    private static void doQuickSort6(int[] origin, int left, int right) {
        if (left >= right) {
            return;
        }
        int start = left;
        int end = right;
        int flagValue = origin[left + (right - left) / 2];
        while (start <= end) {
            while (start <= end && origin[start] < flagValue) {
                start++;
            }

            while (start <= end && origin[end] > flagValue) {
                end--;
            }
            if (start <= end) {
                //交换
                int temp = origin[start];
                origin[start] = origin[end];
                origin[end] = temp;
                start++;
                end--;
            }
        }
        //缩小规模再来一次
        doQuickSort6(origin, left, end);
        doQuickSort6(origin, start, right);
    }

    /**
     * 归并排序
     *
     * @param origin
     * @param left
     * @param right
     * @param temp
     */
    public static void mergeSort6(int[] origin, int left, int right, int[] temp) {
        if (left >= right) {
            return;
        }
        //直接暴力一分为二
        mergeSort6(origin, left, left + (right - left) / 2, temp);
        mergeSort6(origin, left + (right - left) / 2 + 1, right, temp);
        //合并
        doMergeSort6(origin, left, right, temp);
    }

    private static void doMergeSort6(int[] origin, int left, int right, int[] temp) {
        int leftStart = left;
        int tempStart = leftStart;
        int middle = left + (right - left) / 2;
        int rightStart = left + (right - left) / 2 + 1;

        //进行两个数组的有序归并
        while (leftStart <= middle && rightStart <= right) {
            if (origin[leftStart] < origin[rightStart]) {
                temp[tempStart++] = origin[leftStart++];
            } else {
                temp[tempStart++] = origin[rightStart++];
            }
        }
        //处理没有遍历完整的
        while (leftStart <= middle) {
            temp[tempStart++] = origin[leftStart++];
        }

        while (rightStart <= right) {
            temp[tempStart++] = origin[rightStart++];
        }
        //数据移动
        for (int i = left; i <= right; i++) {
            origin[i] = temp[i];
        }
    }
}
