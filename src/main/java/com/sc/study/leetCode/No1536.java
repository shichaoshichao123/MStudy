package com.sc.study.leetCode;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/4/26 2:38 下午
 * @desc 给你一个nxn的二进制网格grid，每一次操作中，你可以选择网格的相邻两行进行交换。
 * <p>
 * 一个符合要求的网格需要满足主对角线以上的格子全部都是 0。
 * <p>
 * 请你返回使网格满足要求的最少操作次数，如果无法使网格符合要求，请你返回 -1。
 * <p>
 * 主对角线指的是从(1, 1)到(n, n)的这些格子。
 */
public class No1536 {

    /**
     * 示例 1：
     * <p>
     * <p>
     * <p>
     * 输入：grid = [[0,0,1],[1,1,0],[1,0,0]]
     * 输出：3
     * 示例 2：
     * <p>
     * <p>
     * <p>
     * 输入：grid = [[0,1,1,0],[0,1,1,0],[0,1,1,0],[0,1,1,0]]
     * 输出：-1
     * 解释：所有行都是一样的，交换相邻行无法使网格符合要求。
     * 示例 3：
     * <p>
     * <p>
     * <p>
     * 输入：grid = [[1,0,0],[1,1,0],[1,1,1]]
     * 输出：0
     *
     * @param grid
     * @return
     */
    public int minSwaps(int[][] grid) {
        if (null == grid) {
            return 0;

        }
        int changeTimes = 0;
        for (int i = 0; i < grid.length; i++) {
            if (!isMatch2Row(grid[i], i)) {
                //进行匹配行的搜索
                int oldChangeTimes = changeTimes;
                for (int j = i + 1; j < grid.length; j++) {
                    if (isMatch2Row(grid[j], i)) {
                        changeTimes += j - i;
                        //将符合条件的行冒泡上去
                        int[] temp = grid[j];
                        for (int k = j; k > i; k--) {
                            grid[k] = grid[k - 1];
                        }
                        grid[i] = temp;
                        break;
                    }
                }
                if (oldChangeTimes == changeTimes) {
                    return -1;
                }
            }
        }
        return changeTimes;
    }

    /**
     * 匹配某行是否满足条件
     *
     * @param rowData
     * @param row
     * @return
     */
    private boolean isMatch2Row(int[] rowData, int row) {
        for (int i = row + 1; i < rowData.length; i++) {
            if (rowData[i] != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 用于校验当前表格是否满足条件
     *
     * @return
     */
    private boolean isMatch2Row(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = i + 1; j < grid.length; j++) {
                if (grid[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        No1536 no1536 = new No1536();
        System.out.println(no1536.minSwaps(new int[][]{{0, 0, 1}, {1, 1, 0}, {1, 0, 0}}));
        System.out.println(no1536.minSwaps(new int[][]{{1, 0, 0}, {1, 1, 0}, {1, 1, 1}}));
        System.out.println(no1536.minSwaps(new int[][]{{0,1,1,0}, {0,1,1,0}, {0,1,1,0}, {0,1,1,0}}));
    }
}
