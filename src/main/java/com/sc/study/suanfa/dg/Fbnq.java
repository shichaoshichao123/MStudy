package com.sc.study.suanfa.dg;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/4/8 7:29 下午
 * @desc
 */
public class Fbnq {

    public static void main(String[] args) {
        System.out.println(getGbnqByDg(10));
        System.out.println(getGbnqByDtgh(10));
        int[][] brands = new int[8][8];
        brands[1][6] = 1;
        brands[1][2] = 1;
        brands[2][4] = 1;
        brands[3][0] = 1;
        brands[3][2] = 1;
        brands[3][5] = 1;
        brands[4][2] = 1;
        brands[5][3] = 1;
        brands[5][4] = 1;
        brands[5][6] = 1;
        brands[6][1] = 1;
        brands[6][5] = 1;

        System.out.println(getChuLuByDG(brands, 0, 0, 7, 7));
        System.out.println(getChuLuByDTGH(brands, 0, 0, 7, 7));
    }

    /**
     * 递归的方式求斐波那契数
     *
     * @param n
     * @return
     */
    private static int getGbnqByDg(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return getGbnqByDg(n - 1) + getGbnqByDg(n - 2);

        }
    }

    /**
     * 动态规划的方式求斐波那契数
     * 递归的方式会存在很多重复的计算，所以动态规划的方式存放计算结果进行反向递推得道最后要的值,是一种以空间换时间的方式
     *
     * @param n
     * @return
     */
    private static int getGbnqByDtgh(int n) {
        int[] result = new int[n + 1];
        result[0] = 0;
        result[1] = 1;
        for (int i = 2; i <= n; i++) {
            result[i] = result[i - 2] + result[i - 1];
        }
        return result[n];
    }

    /**
     * 递归的方式计算一个方形棋盘中一个点到另一个点的走法有多少种（移动的时候只能向右或者向下移动）
     *
     * @param brands
     * @param row
     * @param col
     * @return
     */
    private static int getChuLuByDG(int[][] brands, int row, int col, int endRow, int endCol) {
        if (row >= brands.length || col >= brands.length || row < 0 || col < 0) {
            return 0;
        }
        if (brands[row][col] == 1) {
            return 0;
        } else if (row == endRow && col == endCol) {
            return 1;
        }
        return getChuLuByDG(brands, row + 1, col, endRow, endCol) + getChuLuByDG(brands, row, col + 1, endRow, endCol);
    }

    /**
     * 使用动态规划的方式进行求解
     *
     * @param brands
     * @param row
     * @param col
     * @param endRow
     * @param endCol
     * @return
     */
    private static int getChuLuByDTGH(int[][] brands, int row, int col, int endRow, int endCol) {
        brands[endRow][endCol] = 1;
        int[][] result = new int[endRow+1][endCol+1];
        for (int i = endRow; i >= 0; i--) {
            for (int j = endCol; j >= 0; j--) {
                if(brands[i][j]==1){
                    result[i][j] = 0;
                }else
                if (i == endRow || j == endCol) {
                    result[i][j] = 1;
                } else {
                    result[i][j] = result[i + 1][j] + result[i][j + 1];
                }
            }
        }
        return result[0][0];
    }
}
