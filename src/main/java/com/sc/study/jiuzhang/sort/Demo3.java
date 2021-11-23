package com.sc.study.jiuzhang.sort;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/11/23 11:01 上午
 * @desc
 */
public class Demo3 {
    public static void main(String[] args) {
        int[] origin = new int[]{2, 3, 1, 6, 5, 4, 33, 44, 55, 66, 1};
        Sort.printInfo(origin);
//        quickSort3(origin);
        mergeSort3(origin, 0, origin.length - 1, new int[origin.length]);
        System.out.println();
        Sort.printInfo(origin);
    }

    /**
     * 快速排序
     *
     * @param origin
     */
    public static void quickSort3(int[] origin) {
        if (null == origin) {
            return;
        }
        doQuickSort(origin, 0, origin.length - 1);
    }

    /**
     * 快排逻辑
     *
     * @param origin
     * @param left
     * @param right
     */
    private static void doQuickSort(int[] origin, int left, int right) {
        if (left >= right) {
            return;
        }
        int start = left, end = right;
        //注意这个值
        int flagValue = origin[left + (right - left) / 2];
        while (start <= end) {
            //定位不符合标志值的位置
            while (start <= end && origin[start] < flagValue) {
                start++;
            }
            while (start <= end && origin[end] > flagValue) {
                end--;
            }
            //如果两个指针还未相遇说明需要进行交换
            if (start <= end) {
                int temp = origin[start];
                origin[start] = origin[end];
                origin[end] = temp;
                //交换后再相向移动指针
                start++;
                end--;
            }
        }
        //缩小规模继续以上操作
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
    public static void mergeSort3(int[] origin, int left, int right, int[] temp) {
        if (left >= right) {
            return;
        }
        //直接一分为二
        mergeSort3(origin, left, (right + left) / 2, temp);
        mergeSort3(origin, (right + left) / 2 + 1, right, temp);
        //执行归并逻辑
        doMergeSort3(origin, left, right, temp);
    }

    /**
     * 归并逻辑
     *
     * @param origin
     * @param left
     * @param right
     * @param temp
     */
    private static void doMergeSort3(int[] origin, int left, int right, int[] temp) {
        if (left >= right) {
            return;
        }
        int leftStart = left;
        int tempStart = leftStart;
        int middle = (left + right) / 2;
        int rightStart = middle + 1;
        while (leftStart <= middle && rightStart <= right) {
            if (origin[leftStart] < origin[rightStart]) {
                temp[tempStart++] = origin[leftStart++];
            } else {
                temp[tempStart++] = origin[rightStart++];
            }
        }

        //处理没有遍历到的
        while (leftStart <= middle) {
            temp[tempStart++] = origin[leftStart++];
        }
        while (rightStart <= right) {
            temp[tempStart++] = origin[rightStart++];
        }
        //按照索引归并
        for (int i = left; i <= right; i++) {
            origin[i] = temp[i];
        }
    }

}
