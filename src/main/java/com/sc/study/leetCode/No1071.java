package com.sc.study.leetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/5/20 4:35 下午
 * @desc 对于字符串S 和T，只有在 S = T + ... + T（T 自身连接 1 次或多次）时，我们才认定“T 能除尽 S”。
 * <p>
 * 返回最长字符串X，要求满足X 能除尽 str1 且X 能除尽 str2。
 */
public class No1071 {
    /**
     * 示例 1：
     * <p>
     * 输入：str1 = "ABCABC", str2 = "ABC"
     * 输出："ABC"
     * 示例 2：
     * <p>
     * 输入：str1 = "ABABAB", str2 = "ABAB"
     * 输出："AB"
     * 示例 3：
     * <p>
     * 输入：str1 = "LEET", str2 = "CODE"
     * 输出：""
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= str1.length <= 1000
     * 1 <= str2.length <= 1000
     * str1[i] 和str2[i] 为大写英文字母
     * tip:求出被处理字符串的最长非均分子串
     *
     * @param str1
     * @param str2
     * @return
     */
    public String gcdOfStrings(String str1, String str2) {
        String min1 = getMinRepeatSubString(str1);
        String min2 = getMinRepeatSubString(str2);
        return min1.equals(min2) ? min1 : "";
    }


    public static void main(String[] args) {
        No1071 no1071 = new No1071();
        System.out.println(no1071.getMinRepeatSubString("ABABAB"));
//        System.out.println(no1071.gcdOfStrings("ABCABC", "ABC"));
//        System.out.println(no1071.gcdOfStrings("ABABAB", "ABAB"));
//        System.out.println(no1071.gcdOfStrings("LEET", "CODE"));


    }


    /**
     * 获取最短可重复串
     *
     * @param originStr
     * @return
     */
    public String getMinRepeatSubString(String originStr) {
        int canSpitNums = originStr.length();
        while (canSpitNums > 1) {
            Set<String> filterSet = new HashSet<>();
            int cellStart = 0;
            int length = originStr.length();
            int cellLength = length / canSpitNums;
            while (cellStart < length) {
                String cell = originStr.substring(cellStart, cellStart + cellLength);
                filterSet.add(cell);
                if (filterSet.size() > 1) {
                    break;
                }
                cellStart += cellLength;

            }
            if (filterSet.size() == 1) {
                return originStr.substring(0, cellLength);
            }
            filterSet.clear();
            if (length % 2 == 0) {
                canSpitNums -= 1;

            } else {
                canSpitNums -= 2;

            }
        }
        return originStr;
    }
}
