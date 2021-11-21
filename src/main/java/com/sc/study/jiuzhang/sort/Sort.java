package com.sc.study.jiuzhang.sort;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/11/15 4:17 下午
 * @desc
 */
public class Sort {

    public static void main(String[] args) {
        int[] origin = new int[]{2, 4, 7, 1, 3};
        printInfo(origin);
        System.out.println();
//        quickSort(origin);
        System.out.println(quickSelect(origin,2));
        mergeSort(origin, 0, origin.length - 1, new int[origin.length]);
        System.out.println("====排序后=====");
        printInfo(origin);
    }

    public static void printInfo(int[] origin) {
        for (int i = 0; i < origin.length; i++) {
            System.out.print(origin[i] + ",");
        }
    }

    /**
     * 快速排序
     *
     * @param origin
     */
    private static void quickSort(int[] origin) {
        if (null == origin || origin.length <= 1) {
            return;
        }
        doQuickSort(origin, 0, origin.length - 1);
    }

    /**
     * 快排递归单元
     *
     * @param origin
     * @param left
     * @param right
     */
    private static void doQuickSort(int[] origin, int left, int right) {
        if (left >= right) {
            return;
        }
        int start = left;
        int end = right;
        //选取标志值(范围重大到小)
        int flagValue = origin[(left + right) / 2];
        while (start <= end) {
            //用于定位左边大于标志位的元素
            while (start <= end && origin[start] < flagValue) {
                start++;
            }
            //用于定位右边小于标志为的元素
            while (start <= end && origin[end] > flagValue) {
                end--;
            }
            //找到元素后进行左右索引位置交换
            if (start <= end) {
                int temp = origin[start];
                origin[start] = origin[end];
                origin[end] = temp;
                //交换之后进行指针移动
                start++;
                end--;
            }
        }
        //进行递归调用
        doQuickSort(origin, left, end);
        doQuickSort(origin, start, right);
    }

    /**
     * 归并排序
     *
     * @param origin
     */
    public static void mergeSort(int[] origin, int left, int right, int[] temp) {
        if (left >= right) {
            return;
        }
        //处理左边
        mergeSort(origin, left, (left + right) / 2, temp);
        //处理右边
        mergeSort(origin, (left + right) / 2 + 1, right, temp);
        //归并
        doMerge(origin, left, right, temp);
    }

    /**
     * 归并算法的具体归并逻辑
     *
     * @param origin
     * @param left
     * @param right
     * @param temp
     */
    private static void doMerge(int[] origin, int left, int right, int[] temp) {
        int midIndex = (left + right) / 2;
        int leftIndex = left;
        int rightIndex = midIndex + 1;
        int tempIndex = leftIndex;

        while (leftIndex <= midIndex && rightIndex <= right) {
            if (origin[leftIndex] < origin[rightIndex]) {
                temp[tempIndex++] = origin[leftIndex++];
            } else {
                temp[tempIndex++] = origin[rightIndex++];
            }
        }
        //处理没有遍历完的子数组
        while (leftIndex <= midIndex) {
            temp[tempIndex++] = origin[leftIndex++];
        }
        while (rightIndex <= right) {
            temp[tempIndex++] = origin[rightIndex++];
        }
        //将临时数组中的数据回写到数组中,注意要处理的索引位置正确
        for (int i = left; i <= right; i++) {
            origin[i] = temp[i];
        }
    }


    /**
     * 快速选择算法获取排在第index位的元素
     * 底层是使用快速排序的思想
     *
     * @param origin
     * @param index  排第index位的数
     * @return
     */
    public static int quickSelect(int[] origin, int index) {
        if (null == origin || index < 0) {
            return Integer.MAX_VALUE;
        }
        return doQuickSelect(origin, 0, origin.length - 1, index);
    }

    /**
     * 进行具体放入递归逻辑
     *
     * @param origin
     * @param left
     * @param right
     * @param index
     * @return
     */
    private static int doQuickSelect(int[] origin, int left, int right, int index) {
        int i = left;
        int j = right;
        int flagValue = origin[(left + right) / 2];
        while (i <= j) {
            while (i <= j && origin[i] < flagValue) {
                i++;
            }
            while (i <= j && origin[j] > flagValue) {
                j--;
            }
            //进行交换
            while (i <= j) {
                int temp = origin[i];
                origin[i] = origin[j];
                origin[j] = temp;
                i++;
                j--;
            }
        }
        //进行指定索引所在区间判断再进行递归
        if (left + index - 1 <= j) {
            return doQuickSelect(origin, left, j, index);
        } else if (left + index - 1 >= i) {
            return doQuickSelect(origin, i, right, index - (i - left));
        }
        return origin[j + 1];
    }
}
