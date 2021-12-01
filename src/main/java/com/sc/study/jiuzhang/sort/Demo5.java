package com.sc.study.jiuzhang.sort;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/11/23 8:59 下午
 * @desc
 */
public class Demo5 {
    public static void main(String[] args) {
        int[] origin = new int[]{2, 3, 1, 6, 5, 4, 33, 44, 55, 66, 1};
        Sort.printInfo(origin);
//        quickSort5(origin);
        mergeSort5(origin, 0, origin.length - 1, new int[origin.length]);
        System.out.println();
        Sort.printInfo(origin);
    }

    /**
     * 快速排序
     *
     * @param origin
     */
    public static void quickSort5(int[] origin) {
        if (null == origin || origin.length <= 1) {
            return;
        }
        doQuickSort(origin, 0, origin.length - 1);
    }

    private static void doQuickSort(int[] origin, int left, int right) {
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
        doQuickSort(origin, left, end);
        doQuickSort(origin, start, right);
    }


    /**
     * 归并排序
     *
     * @param origin
     * @param left
     * @param right
     * @param temp
     */
    public static void mergeSort5(int[] origin, int left, int right, int[] temp) {
        if (left >= right) {
            return;
        }
        // 直接进行二分归并
        mergeSort5(origin, left, (left + (right - left) / 2), temp);
        mergeSort5(origin, (left + (right - left) / 2 + 1), right, temp);
        //归并
        doMergeSort5(origin, left, right, temp);
    }

    private static void doMergeSort5(int[] origin, int left, int right, int[] temp) {
        int leftIndex = left;
        int tempIndex = leftIndex;
        int middle = left + (right - left) / 2;
        int rightIndex = middle + 1;

        while (leftIndex <= middle && rightIndex <= right) {
            if (origin[leftIndex] < origin[rightIndex]) {
                temp[tempIndex++] = origin[leftIndex++];
            } else {
                temp[tempIndex++] = origin[rightIndex++];
            }
        }
        while (leftIndex <= middle) {
            temp[tempIndex++] = origin[leftIndex++];

        }

        while (rightIndex <= right) {
            temp[tempIndex++] = origin[rightIndex++];

        }
        for (int i = left; i <= right; i++) {
            origin[i] = temp[i];
        }

    }
}
