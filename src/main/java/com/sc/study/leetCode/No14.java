package com.sc.study.leetCode;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/6/7 4:24 下午
 * @desc 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 */
public class No14 {
    /**
     * 示例 1：
     * <p>
     * 输入：strs = ["flower","flow","flight"]
     * 输出："fl"
     * 示例 2：
     * <p>
     * 输入：strs = ["dog","racecar","car"]
     * 输出：""
     * 解释：输入不存在公共前缀。
     * <p>
     * 提示：
     * <p>
     * 0 <= strs.length <= 200
     * 0 <= strs[i].length <= 200
     * strs[i] 仅由小写英文字母组成
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (null == strs || strs.length <= 0) {
            return null;
        }
        String pattern = strs[0];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < pattern.length(); i++) {
            Character current = pattern.charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i > strs[j].length() - 1 || strs[j].charAt(i) != current) {
                    return sb.toString();
                }
            }
            sb.append(current);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        No14 no14 = new No14();
        System.out.println(no14.longestCommonPrefix(new String[]{"flower","flow","flight"}));
        System.out.println(no14.longestCommonPrefix(new String[]{"dog","racecar","car"}));
    }
}
