package com.sc.study.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/6/8 10:42 上午
 * @desc
 * 给定一个整数 n, 返回从 1 到 n 的字典顺序
 */
public class No386 {
    /**
     * 给定 n =1 3，返回 [1,10,11,12,13,2,3,4,5,6,7,8,9] 。
     *
     * 请尽可能的优化算法的时间复杂度和空间复杂度。 输入的数据n小于等于5,000,000。
     *
     * @param n
     * @return
     */
    List<Integer> lst = new ArrayList<>();
    public List<Integer> lexicalOrder(int n) {
        for(int i = 1 ; i < 10 ; i++){
            dfs(n , i);
        }
        return lst;
    }
    public void dfs(int n , int t){
        if(t <= n){
            lst.add(t);
        }else{
            return;
        }
        for(int i = 0 ; i < 10 ; i++){
            dfs(n , 10*t+i);
        }
    }
}
