package com.sc.study.jiuzhang.sort;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/11/25 8:32 下午
 * @desc
 */
public class Demo7 {
    public static void main(String[] args) {
        int[] origin = new int[]{2, 3, 1, 6, 5, 4, 33, 44, 55, 66, 1};
        Sort.printInfo(origin);
//        quickSort7(origin);
        mergeSort7(origin, 0, origin.length - 1, new int[origin.length]);
        System.out.println();
        Sort.printInfo(origin);
    }

    public static void quickSort7(int[] origin) {
        if (null == origin || origin.length <= 1) {
            return;
        }
        doMergeSort7(origin, 0, origin.length - 1);
    }

    private static void doMergeSort7(int[] origin, int left, int right) {
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
                //交换
                int temp = origin[start];
                origin[start] = origin[end];
                origin[end] = temp;
                start++;
                end--;
            }
        }
        doMergeSort7(origin, left, end);
        doMergeSort7(origin, start, right);
    }

    public static void mergeSort7(int[] origin, int left, int right, int[] temp) {
        if (left >= right) {
            return;
        }
        //erfen
        mergeSort7(origin, 0, left + (right - left) / 2, temp);
        mergeSort7(origin, left + (right - left) / 2 + 1, right, temp);
        doMergeSort7(origin, left, right, temp);

    }

    private static void doMergeSort7(int[] origin, int left, int right, int[] temp) {
        int leftStart = left;
        int tempStart = leftStart;
        int mid = left + (right - left) / 2;
        int rightIndex = mid + 1;

        while (leftStart <= mid && rightIndex <= right) {
            if (origin[leftStart] < origin[rightIndex]) {
                temp[tempStart++] = origin[leftStart++];
            } else {
                temp[tempStart++] = origin[rightIndex++];
            }
        }

        while (leftStart <= mid) {
            temp[tempStart++] = origin[leftStart++];
        }

        while (rightIndex <= right) {
            temp[tempStart++] = origin[rightIndex++];
        }
        //guibing
        for (int i = left; i <= right; i++) {
            origin[i] = temp[i];
        }
    }
}
