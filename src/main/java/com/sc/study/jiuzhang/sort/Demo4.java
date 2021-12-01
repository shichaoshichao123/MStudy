package com.sc.study.jiuzhang.sort;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/11/23 11:30 上午
 * @desc
 */
public class Demo4 {
    public static void main(String[] args) {
        int[] origin = new int[]{2, 3, 1, 6, 5, 4, 33, 44, 55, 66, 1};
        Sort.printInfo(origin);
//        quickSort4(origin);
        mergeSort4(origin, 0, origin.length - 1, new int[origin.length]);
        System.out.println();
        Sort.printInfo(origin);
    }


    public static void quickSort4(int[] origin) {
        if (null == origin || origin.length <= 1) {
            return;
        }
        doQuickSort4(origin, 0, origin.length - 1);
    }

    private static void doQuickSort4(int[] origin, int left, int right) {
        //必须的边界条件
        if (left >= right) {
            return;
        }
        int start = left, end = right;
        int flagValue = origin[left + (right - left) / 2];
        while (start <= end) {
            while (start <= end && origin[start] < flagValue) {
                start++;
            }
            while (start <= end && origin[end] > flagValue) {
                end--;
            }
            if (start <= end) {
                int temp = origin[start];
                origin[start] = origin[end];
                origin[end] = temp;
                start++;
                end--;
            }
        }
        doQuickSort4(origin, left, end);
        doQuickSort4(origin, start, right);
    }

    public static void mergeSort4(int[] origin, int left, int right, int[] temp) {
        //必须的边界条件，不然会产生栈溢出
        if (left >= right) {
            return;
        }
        //分段
        mergeSort4(origin, left, left + (right - left) / 2, temp);
        mergeSort4(origin, left + (right - left) / 2 + 1, right, temp);
        //合并
        doMergeSort(origin, left, right, temp);
    }

    private static void doMergeSort(int[] origin, int left, int right, int[] temp) {
        int leftStart = left;
        int tempStart = leftStart;
        int middle = left + (right - left) / 2;
        int rightStart = middle + 1;

        while (leftStart <= middle && rightStart <= right) {
            if (origin[leftStart] < origin[rightStart]) {
                temp[tempStart++] = origin[leftStart++];
            } else {
                temp[tempStart++] = origin[rightStart++];
            }
        }
        while (leftStart <= middle) {
            temp[tempStart++] = origin[leftStart++];
        }
        while (rightStart <= right) {
            temp[tempStart++] = origin[rightStart++];
        }
        //合并
        for (int i = left; i <= right; i++) {
            origin[i] = temp[i];
        }
    }
}
