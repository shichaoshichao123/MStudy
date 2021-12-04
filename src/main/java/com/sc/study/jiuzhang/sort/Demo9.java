package com.sc.study.jiuzhang.sort;/** * @author yingqi * @date 2021/12/4 */public class Demo9 {    public static void main(String[] args) {        int[] origin = new int[]{2, 3, 1, 6, 5, 4, 33, 44, 55, 66, 1};        Sort.printInfo(origin);//        quickSort9(origin);        mergeSort9(origin, 0, origin.length - 1, new int[origin.length]);        System.out.println();        Sort.printInfo(origin);    }    public static void quickSort9(int[] origin) {        if (null == origin || origin.length <= 0) {            return;        }        doQuickSort9(origin, 0, origin.length - 1);    }    /**     * 进行快排逻辑     *     * @param origin     * @param left     * @param right     */    private static void doQuickSort9(int[] origin, int left, int right) {        if (left >= right) {            return;        }        int start = left;        int end = right;        int flagValue = origin[left + (right - left) / 2];        while (start <= end) {            while (start <= end && flagValue > origin[start]) {                start++;            }            while (start <= end && flagValue < origin[end]) {                end--;            }            if (start <= end) {                int temp = origin[start];                origin[start] = origin[end];                origin[end] = temp;                start++;                end--;            }        }        doQuickSort9(origin, left, end);        doQuickSort9(origin, start, right);    }    public static void mergeSort9(int[] origin, int left, int right, int[] temp) {        if (left >= right) {            return;        }        mergeSort9(origin, 0, left + (right - left) / 2, temp);        mergeSort9(origin, left + (right - left) / 2 + 1, right, temp);        //归并        doMergeSort9(origin, left, right, temp);    }    /**     * 归并排序     *     * @param origin     * @param left     * @param right     * @param temp     */    private static void doMergeSort9(int[] origin, int left, int right, int[] temp) {        int leftStart = left;        int tempStart = leftStart;        int mid = left + (right - left) / 2;        int rightStart = mid + 1;        while (leftStart <= mid && rightStart <= right) {            if (origin[leftStart] < origin[rightStart]) {                temp[tempStart++] = origin[leftStart++];            } else {                temp[tempStart++] = origin[rightStart++];            }        }        while (leftStart <= mid) {            temp[tempStart++] = origin[leftStart++];        }        while (rightStart <= right) {            temp[tempStart++] = origin[rightStart++];        }        for (int i = left; i <= right; i++) {            origin[i] = temp[i];        }    }}