package com.sc.study.suanfa.bst;

import java.util.*;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/3/22 5:56 下午
 * @desc N皇后问题
 */
public class Queue {

    public static void main(String[] args) {
        System.out.println(result);

        doBuildQueue(4, new ArrayList<>(), new HashSet<>(), new HashSet<>());
        System.out.println(result);
    }

    /**
     * 在NxN的棋盘里放下最多的皇后
     *
     * @param n
     * @return
     */
    private static List<String[]> buildQueue(int n) {
        if (n < 1) {
            return Collections.emptyList();
        }
        List<String[]> res = new ArrayList<>();
        Set<Integer> cols = new HashSet<>();
        Set<Integer> pie = new HashSet<>();
        Set<Integer> na = new HashSet<>();
        //进行递归求解
        return res;
    }

    private static List<Integer> result = new ArrayList<>();

    private static void doBuildQueue(int n, List<Integer> currentResult, Set<Integer> pieSet, Set<Integer> naSet) {
        int currentRow = currentResult.size();
        if (currentRow == n) {
            //已经到了最后一行了
            result.addAll(currentResult);
            return;
        }
        for (int col = 0; col < n; col++) {
            if (!currentResult.contains(col) && !pieSet.contains(col + currentRow) && !naSet.contains(currentRow - col)) {
                //当前位置既不在之前的往后的同一行，同一列，同一斜行，所以是合法的位置，进行下一行的递归
                currentResult.add(col);
                pieSet.add(currentRow + col);
                naSet.add(currentRow - col);
                doBuildQueue(n, currentResult, pieSet, naSet);
            }
        }

    }
}
