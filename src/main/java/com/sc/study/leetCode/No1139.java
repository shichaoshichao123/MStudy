package com.sc.study.leetCode;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/4/22 5:09 下午
 * @desc 给你一个由若干 0 和 1 组成的二维网格 grid，请你找出边界全部由 1 组成的最大 正方形 子网格，并返回该子网格中的元素数量。如果不存在，则返回 0。
 */
public class No1139 {

    /**
     * 示例 1：
     * <p>
     * 输入：grid = [[1,1,1],[1,0,1],[1,1,1]]
     * 输出：9
     * 示例 2：
     * <p>
     * 输入：grid = [[1,1,0,0]]
     * 输出：1
     * <p>
     * 提示：
     * <p>
     * 1 <= grid.length <= 100
     * 1 <= grid[0].length <= 100
     * grid[i][j] 为 0 或 1
     *
     * @param grid
     * @return
     */
    public int largest1BorderedSquare(int[][] grid) {
        int result = 0;
        if (null == grid) {
            return result;
        }
        //双重循环进行整个二维网格子的扫描
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                //只有当前点值为1的时候才进行画正方型的尝试，当然这里可以做一些剪枝优化
                if (1 == grid[i][j]) {
                    int temp = maxGz(grid, 1, 0);
                    //选大的
                    result = Math.max(temp, result);
                }
            }
        }
        return result;
    }

    /**
     * 获取最大可能
     *
     * @param grid
     * @param row
     * @param col
     * @return
     */
    private int maxGz(int[][] grid, int row, int col) {
        //从起点开始进行画正方形的校验( 注意这里是要最大的所以应该每次都从最大的可能去画不满足再缩小)
        int originRow = grid.length-1-row;
        int originCol = grid[0].length-1-col;
        int end = Math.min(originRow, originCol);
        for (int i = end; i > 0; i--) {
            if (checkInvalid(grid, i, row, col)) {
                return (i + 1) * (i + 1);
            }
        }
        return 1;

    }

    private boolean checkInvalid(int[][] grid, int end, int row, int col) {
        for (int j = 1; j <= end; j++) {
            //用于计算nxn的内容
            if (grid[row][col + j] == 1 && 1 == grid[row + j][col] && grid[row + end][col + j] == 1 && grid[row + j][col + end] == 1) {
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        No1139 no1139 = new No1139();
        System.out.println(no1139.largest1BorderedSquare(new int[][]{{1, 1, 0}, {1, 1, 1}, {1, 1, 1}, {1, 1, 1}}));
    }


}
