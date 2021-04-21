package com.sc.study.leetCode;

import java.util.HashMap;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/4/15 1:43 下午
 * @desc 给定一种规律 pattern和一个字符串str，判断 str 是否遵循相同的规律。
 * <p>
 * 这里的遵循指完全匹配，例如，pattern里的每个字母和字符串str中的每个非空单词之间存在着双向连接的对应规律。
 */
public class No290 {

    public static void main(String[] args) {
        System.out.println(wordPattern("abba", "dog cat cat dog"));
        System.out.println(wordPattern("abba", "dog cat cat fish"));
        System.out.println(wordPattern("aaaa", "dog cat cat dog"));
        System.out.println(wordPattern("abba", "dog dog dog dog"));
    }

    /**
     * 示例1:
     * <p>
     * 输入: pattern = "abba", str = "dog cat cat dog"
     * 输出: true
     * 示例 2:
     * <p>
     * 输入:pattern = "abba", str = "dog cat cat fish"
     * 输出: false
     * 示例 3:
     * <p>
     * 输入: pattern = "aaaa", str = "dog cat cat dog"
     * 输出: false
     * 示例4:
     * <p>
     * 输入: pattern = "abba", str = "dog dog dog dog"
     * 输出: false
     *
     * @param pattern
     * @param s
     * @return
     */
    public static boolean wordPattern(String pattern, String s) {
        if (null == pattern) {
            return true;
        } else if (null == s) {
            return false;
        }

        String[] content = s.split(" ");
        HashMap<Character, String> patternMap = new HashMap<>(6);
        if (pattern.length() != content.length) {
            return false;
        }
        for (int i = 0; i < pattern.length(); i++) {
            if (null == patternMap.get(pattern.charAt(i))) {
                if (patternMap.containsValue(content[i])) {
                    return false;
                }
                patternMap.put(pattern.charAt(i), content[i]);

            } else {
                if (!patternMap.get(pattern.charAt(i)).equals(content[i])) {
                    return false;
                }
            }
        }
        return true;
    }

}
