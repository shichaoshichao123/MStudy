package com.sc.study.leetCode;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/4/29 5:04 下午
 * @desc 给定一个二维的甲板， 请计算其中有多少艘战舰。战舰用'X'表示，空位用'.'表示。你需要遵守以下规则：
 * <p>
 * 给你一个有效的甲板，仅由战舰或者空位组成。
 * 战舰只能水平或者垂直放置。换句话说,战舰只能由1xN (1 行, N 列)组成，或者Nx1 (N 行, 1 列)组成，其中N可以是任意大小。
 * 两艘战舰之间至少有一个水平或垂直的空位分隔- 即没有相邻的战舰。
 */
public class No419 {

    /**
     * 示例 :
     * <p>
     * X..X
     * ...X
     * ...X
     * 在上面的甲板中有2艘战舰。
     * <p>
     * 无效样例 :
     * <p>
     * ...X
     * XXXX
     * ...X
     * 你不会收到这样的无效甲板- 因为战舰之间至少会有一个空位将它们分开。
     * <p>
     * 进阶:
     * <p>
     * 你可以用一次扫描算法，只使用O(1)额外空间，并且不修改甲板的值来解决这个问题吗？
     *
     * @param board
     * @return
     */
    public int countBattleships(char[][] board) {
        if (null == board) {
            return 0;
        }
        int rowResult = 0;
        for (int i = 0; i < board.length; i++) {
            int tempResult = 0;
            for (int j = 0; j < board[0].length; j++) {
                if ('X' == board[i][j]) {
                    if (isMatch(board, i, j, true)) {
                        break;
                    }
                    tempResult++;
                }

            }
            rowResult = Math.max(rowResult, tempResult);
        }
        int colResult = 0;
        for (int i = 0; i < board[0].length; i++) {
            int tempResult = 0;
            for (int j = 0; j < board.length; j++) {
                if ('X' == board[j][i]) {
                    if (isMatch(board, j, i, false)) {
                        break;
                    }
                    tempResult++;
                }

            }
            colResult = Math.max(colResult, tempResult);
        }

        return Math.max(rowResult, colResult);
    }

    public static void main(String[] args) {
        No419 no419 = new No419();
        char[][] board = new char[][]{{'X', '.', '.', 'X'}, {'.', '.', '.', 'X'}, {'.', '.', '.', 'X'}};
        char[][] board1 = new char[][]{{'.', '.', '.', 'X'}, {'X', 'X', 'X', 'X'}, {'.', '.', '.', 'X'}};
        System.out.println(no419.countBattleships(board));
        System.out.println(no419.countBattleships(board1));
    }

    /**
     * 校验是否有效
     *
     * @param board
     * @param row
     * @param col
     * @return
     */
    private boolean isMatch(char[][] board, int row, int col, boolean isRow) {
        if (isRow) {
            int afterCol = Math.min(board[0].length - 1, col + 1);
            if (afterCol == board[0].length - 1) {
                return false;
            }
            return board[row][afterCol] == 'X';
        } else {
            int afterRow = Math.min(board.length - 1, row + 1);
            if (afterRow == board.length - 1) {
                return false;
            }
            return board[afterRow][col] == 'X';

        }
    }
}
