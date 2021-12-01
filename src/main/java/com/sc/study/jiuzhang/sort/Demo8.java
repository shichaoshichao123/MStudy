package com.sc.study.jiuzhang.sort;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/11/27 10:06 上午
 * @desc
 */
public class Demo8 {

    public static void main(String[] args) {
        int[] origin = new int[]{2, 3, 1, 6, 5, 4, 33, 44, 55, 66, 1};
        Sort.printInfo(origin);
//        quickSort8(origin);
        mergeSort8(origin, 0, origin.length - 1, new int[origin.length]);
        System.out.println();
        Sort.printInfo(origin);
    }

    public static void quickSort8(int[] origin) {
        if (null == origin || origin.length <= 1) {
            return;
        }
        doQuickSort8(origin, 0, origin.length - 1);
    }

    private static void doQuickSort8(int[] origin, int left, int right) {
        if (left >= right) {
            return;
        }
        int start = left;
        int end = right;
        int flagValue = origin[left + (right - left)];
        while (start <= end) {
            //分别从左右开始寻找不符合标志点的索引并进行交换
            while (start <= end && origin[start] < flagValue) {
                start++;
            }

            while (start <= end && origin[end] > flagValue) {
                end--;
            }
            //当有不满足条件的元素在这里进行交换
            if (start <= end) {
                int temp = origin[start];
                origin[start] = origin[end];
                origin[end] = temp;
                start++;
                end--;
            }
        }
        doQuickSort8(origin, left, end);
        doQuickSort8(origin, start, right);
    }

    public static void mergeSort8(int[] origin, int left, int right, int[] temp) {
        if (left >= right) {
            return;
        }
        //直接进行二分归并处理
        mergeSort8(origin, 0, left + (right - left) / 2, temp);
        mergeSort8(origin, left + (right - left) / 2+1, right, temp);
        doMergeSort8(origin, left, right, temp);
    }

    private static void doMergeSort8(int[] origin, int left, int right, int[] temp) {
        int leftStart = left;
        int tempStart = leftStart;
        int mid = left + (right - left) / 2;
        int rightStart = mid + 1;
        //进行两个有序子数组得合并
        while (leftStart <= mid && rightStart <= right) {
            if (origin[leftStart] < origin[rightStart]) {
                temp[tempStart++] = origin[leftStart++];
            } else {
                temp[tempStart++] = origin[rightStart++];
            }
        }
        //处理没有遍历完成的子数组
        while (leftStart <= mid) {
            temp[tempStart++] = origin[leftStart++];
        }

        while (rightStart <= right) {
            temp[tempStart++] = origin[rightStart++];
        }


        //进行移动
        for (int i = left; i <= right; i++) {
            origin[i] = temp[i];
        }
    }
}
