package com.sc.study.offer;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/10/24 2:43 下午
 * @desc
 */
public class FindX {

    public static void main(String[] args) {
        int[][] brand = new int[][]{{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 110, 13}, {6, 8, 11, 15}};
        System.out.println(doFindX(brand, 1));
    }


    /**
     * 查找X是否处于二维矩阵中（非暴力迭代的方式）
     * tip：矩阵行从左到右递增
     * 矩阵列从上到下递增
     *
     * @param brand
     * @param x
     * @return
     */
    public static boolean doFindX(int[][] brand, int x) {
        if (brand.length == 0) {
            return false;
        }
        int row = 0;
        int col = brand[0].length - 1;
        while (row < brand.length && col >= 0) {
            int current = brand[row][col];
            if (current == x) {
                return true;
            } else if (current < x) {
                row++;
            } else {
                col--;
            }
        }
        return false;
    }
}
