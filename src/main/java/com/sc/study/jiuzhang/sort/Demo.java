package com.sc.study.jiuzhang.sort;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/11/16 11:15 上午
 * @desc
 */
public class Demo {

    public static void main(String[] args) {
        int[] origin = new int[]{2, 3, 1, 6, 5, 4};
        Sort.printInfo(origin);
//        quickSort(origin);
        mergeSort(origin);
        System.out.println();
        Sort.printInfo(origin);


    }

    /**
     * 快排序
     *
     * @param origin
     */
    public static void quickSort(int[] origin) {
        if (null == origin || origin.length <= 1) {
            return;
        }
        //执行快排逻辑
        doQuickSort(origin, 0, origin.length - 1);
    }

    private static void doQuickSort(int[] origin, int left, int right) {
        if (left >= right) {
            return;
        }
        int i = left, j = right;
        //取操作范围的中间元素作为标志值
        int flagValue = origin[(left + right) / 2];
        while (i <= j) {
            //定位左边大于标志值的位置
            while (i <= j && origin[i] < flagValue) {
                i++;
            }
            //定位右边小于标志值的元素
            while (i <= j && origin[j] > flagValue) {
                j--;
            }
            //当有响应的值出现的时候进行交换处理
            if (i <= j) {
                int temp = origin[i];
                origin[i] = origin[j];
                origin[j] = temp;
                i++;
                j--;
            }
        }
        //进行缩小范围递归操作
        doQuickSort(origin, left, j);
        doQuickSort(origin, i, right);
    }

    /**
     * 归并排序
     *
     * @param origin
     */
    public static void mergeSort(int[] origin) {
        if (null == origin) {
            return;
        }
        int[] temp = new int[origin.length ];
        doMergeSort(origin, 0, origin.length - 1, temp);
    }

    /**
     * 归并排序递归单元
     *
     * @param origin
     * @param left
     * @param right
     * @param temp
     */
    private static void doMergeSort(int[] origin, int left, int right, int[] temp) {
        if (left >= right) {
            return;
        }
        //直接进行二分归并
        doMergeSort(origin, left, (left + right) / 2, temp);
        doMergeSort(origin, (left + right) / 2 + 1, right, temp);
        //进行合并逻辑
        doMerge(origin, left, right, temp);
    }

    /**
     * 具体合并逻辑
     *
     * @param origin
     * @param left
     * @param right
     * @param temp
     * @return
     */
    private static void doMerge(int[] origin, int left, int right, int[] temp) {
        int mid = (left + right) / 2;
        int leftStart = left, rightStart = mid + 1, tempStart = leftStart;

        //进行数组合并
        while (leftStart <= mid && rightStart <= right) {
            if (origin[leftStart] < origin[rightStart]) {
                temp[tempStart++] = origin[leftStart++];
            } else {
                temp[tempStart++] = origin[rightStart++];
            }
        }
        //处理合并两个数组的时候没有遍历完的情况，这里不管直接往下走
        while (leftStart <= mid) {
            temp[tempStart++] = origin[leftStart++];
        }
        while (rightStart <= right) {
            temp[tempStart++] = origin[rightStart++];
        }
        //进行赋值
        for (int i = left; i <= right; i++) {
            origin[i] = temp[i];
        }
    }

}
