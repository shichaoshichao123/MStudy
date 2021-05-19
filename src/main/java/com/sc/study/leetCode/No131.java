package com.sc.study.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/5/19 4:52 下午
 * @desc 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 * <p>
 * 回文串 是正着读和反着读都一样的字符串。
 */
public class No131 {

    /**
     * 示例 1：
     * <p>
     * 输入：s = "aab"
     * 输出：[["a","a","b"],["aa","b"]]
     * 示例 2：
     * <p>
     * 输入：s = "a"
     * 输出：[["a"]]
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= s.length <= 16
     * s 仅由小写英文字母组成
     *
     * @param s
     * @return
     */
    public List<List<String>> partition(String s) {
        if (null == s) {
            return new ArrayList<>();
        }
        for (int i = 0; i < s.length(); i++) {

        }
    }
}
