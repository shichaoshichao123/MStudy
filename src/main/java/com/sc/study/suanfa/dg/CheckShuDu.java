package com.sc.study.suanfa.dg;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/3/25 8:21 下午
 * @desc 数独解决程序
 */
public class CheckShuDu {

    public static void main(String[] args) {
        Integer[][] board = new Integer[9][9];
        doAnswer(board);
        printBoard(board);
        Integer[] origin = new Integer[]{1, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(search(origin, 6));
        System.out.println(calculateSqr(9.0, 1e-2));
        System.out.println(sqrt(9.0, 1e-2));
    }

    private static void printBoard(Integer[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

    }

    /**
     * 递归解答数独
     *
     * @param board
     * @return
     */
    private static boolean doAnswer(Integer[][] board) {
        //1：用双层循环达到扫描整个棋盘的目的
        //循环行
        for (int i = 0; i < board.length; i++) {
            //循环列
            for (int j = 0; j < board[0].length; j++) {
                //针对还没有填数的格子通过暴力轮循+DFS的方式去拿到最终适合填入的数字
                if (board[i][j] == null) {
                    for (int k = 1; k <= 9; k++) {
                        if (isRegular(board, i, j, k)) {
                            //合法的情况
                            board[i][j] = k;
                            //进行下一层的递归
                            if (doAnswer(board)) {
                                //合法
                                return true;
                            } else {
                                //下一步没有合法的说明因为上一步导致的所以要对上一步进行回溯，再从新从1-9的下一个开始递归
                                board[i][j] = null;
                            }

                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 用来校验当前使用的数是否满足数独的规则
     *
     * @param board
     * @param row
     * @param col
     * @param target
     * @return
     */
    private static boolean isRegular(Integer[][] board, int row, int col, Integer target) {
        for (int i = 0; i < 9; i++) {
            //同一行是否有相同的(包含了不检查自己)
            if (null != board[row][i] && target.equals(board[row][i])) {
                return false;
            }
            //同一列是否有相同的(包含了不检查自己)
            if (null != board[i][col] && target.equals(board[i][col])) {
                return false;
            }
            //检查当前位置所在的3X3小格中是否有相同的(包含了不检查自己)
            int gongRow = 3 * (row / 3) + i / 3;
            int gongCol = 3 * (col / 3) + i % 3;
            if (null != board[gongRow][gongCol] && target.equals(board[gongRow][gongCol])) {
                return false;
            }
        }
        return true;
    }


    /**
     * 二分查找目标值在原数组的下标
     *
     * @param origin
     * @param target
     * @return
     */
    private static Integer search(Integer[] origin, Integer target) {
        if (null == origin || origin.length <= 0) {
            return null;
        }
        int leftIndex = 0;
        int rightIndex = origin.length;
        while (leftIndex <= rightIndex) {
            int mid = (leftIndex + rightIndex) / 2;
            if (origin[mid].equals(target)) {
                return mid;
            } else if (origin[mid] < target) {
                leftIndex = mid + 1;
            } else {
                rightIndex = mid - 1;
            }

        }
        return null;
    }

    /**
     * 计算指定数的平方根
     *
     * @param num
     * @param precise 精确度
     * @return
     */
    private static Double calculateSqr(Double num, Double precise) {
        if (null == num) {
            return null;
        }
        double leftIndex = 0;
        double rightIndex = num;
        while (rightIndex - leftIndex > precise) {
            double mid = (leftIndex + rightIndex) / 2;
            if (mid == num / mid) {
                //刚好能整除
                return mid;
            } else if (mid > num / mid) {
                //通过这个控制精确度
                rightIndex = mid;
            } else {
                //通过这个控制精确度
                leftIndex = mid;
            }

        }
        return (leftIndex + rightIndex) / 2;
    }
    public static double sqrt(double t, Double precise) {
        double low = 0, high = t, middle, squre = 0,
                prec = precise != null ? precise : 1e-5;
        if ( t < 0 ) {
            throw new RuntimeException("Negetive number cannot have a sqrt root.");
        }else if(t>=1){
            while ( high - low > prec ) {
                middle = ( low + high ) / 2;
                squre = middle * middle;

                if ( squre > t ) {
                    high = middle;
                } else {
                    low = middle;
                }
            }
            return ( low + high ) / 2;
        }else{
            low = t;
            high = 1;
            while ( high - low > prec ) {
                middle = ( high+low ) / 2;
                squre = middle * middle;
                if ( squre > t ) {
                    high = middle;
                } else {
                    low = middle;
                }
            }
            return ( high + low ) / 2 + squre;
        }
    }
}
