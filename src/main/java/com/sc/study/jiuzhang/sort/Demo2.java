package com.sc.study.jiuzhang.sort;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/11/22 9:04 下午
 * @desc
 */
public class Demo2 {
    public static void main(String[] args) {
        int[] origin = new int[]{2, 3, 1, 6, 5, 4, 33, 44, 55, 66, 1};
        Sort.printInfo(origin);
        quickSort2(origin);
//        mergeSort2(origin, 0, origin.length - 1, new int[origin.length]);
        System.out.println();
        Sort.printInfo(origin);
    }


    /**
     * 快速排序
     *
     * @param origin
     */
    public static void quickSort2(int[] origin) {
        if (null == origin || origin.length <= 1) {
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
        //用中点作为标志位
        int flagValue = origin[(right + left) / 2];
        while (start <= end) {
            while (start <= end && origin[start] < flagValue) {
                //定位左边大于中点标志为的位置
                start++;
            }
            while (start <= end && origin[end] > flagValue) {
                //定位右边小于标志位的值
                end--;
            }
            if (start <= end) {
                //说明有定位到的值，所以进行位置交换
                int temp = origin[start];
                origin[start] = origin[end];
                origin[end] = temp;
                //交换之后更新索引
                start++;
                end--;
            }
        }
        //进行（缩小规模的）递归调用(注意上次交换之后start与end的索引位置是相反了)
        doQuickSort(origin, left, end);
        doQuickSort(origin, start, right);
    }

    /**
     * 归并排序
     * 注意归并排序是需要一个额外的空间存饭暂时的归并数据的
     *
     * @param origin
     */
    public static void mergeSort2(int[] origin, int left, int right, int[] temp) {
        if (left >= right) {
            return;
        }
        mergeSort2(origin, left, (left + right) / 2, temp);
        mergeSort2(origin, (left + right) / 2 + 1, right, temp);
        doMergeSort(origin, left, right, temp);
    }

    /**
     * 归并排序逻辑
     *
     * @param origin
     * @param left
     * @param right
     */
    private static void doMergeSort(int[] origin, int left, int right, int[] temp) {
        int leftStart = left;
        int middleIndex = (right + left) / 2;
        int rightStart = middleIndex + 1;
        int tempStart = leftStart;

        //先将两个数组对其比较
        while (leftStart <= middleIndex && rightStart <= right) {
            if (origin[leftStart] < origin[rightStart]) {
                temp[tempStart++] = origin[leftStart++];
            } else {
                temp[tempStart++] = origin[rightStart++];
            }
        }
        //处理没有遍历完成的数组
        while (leftStart <= middleIndex) {
            temp[tempStart++] = origin[leftStart++];
        }
        while (rightStart <= right) {
            temp[tempStart++] = origin[rightStart++];
        }
        //进行归并操作，重新写入到指定位置的原数组中去
        for (int i = left; i <= right; i++) {
            origin[i] = temp[i];
        }

    }
}
