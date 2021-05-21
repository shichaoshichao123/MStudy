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
        for (int i = str2.length(); i > 0; i--) {
            //子串至少要是两者的某一个公约数
            if (str1.length() % i == 0 && str2.length() % i == 0) {
                String current = str2.substring(0, i);
                if (checkIsGcd(str1, current) && checkIsGcd(str2, current)) {
                    return current;
                }
            }
        }
        return "";
    }

    /**
     * 校验是否合法
     *
     * @param origin
     * @param target
     * @return
     */
    public boolean checkIsGcd(String origin, String target) {
        int length = origin.length();
        int targetLength = target.length();
        int times = length / targetLength;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < times; i++) {
            sb.append(target);
        }
        return sb.toString().equals(origin);
    }

    public static void main(String[] args) {
        No1071 no1071 = new No1071();
//        System.out.println(no1071.gcdOfStrings("ABCABC", "ABC"));
        System.out.println(no1071.gcdOfStrings("ABABABAB", "ABAB"));
        System.out.println(no1071.gcdOfStrings("ABABAB", "ABAB"));
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
