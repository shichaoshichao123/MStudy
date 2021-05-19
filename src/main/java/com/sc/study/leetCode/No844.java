package com.sc.study.leetCode;

import java.util.Stack;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/5/19 4:16 下午
 * @desc 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 * <p>
 * 注意：如果对空文本输入退格字符，文本继续为空。
 */
public class No844 {
    /**
     * 示例 1：
     * <p>
     * 输入：S = "ab#c", T = "ad#c"
     * 输出：true
     * 解释：S 和 T 都会变成 “ac”。
     * 示例 2：
     * <p>
     * 输入：S = "ab##", T = "c#d#"
     * 输出：true
     * 解释：S 和 T 都会变成 “”。
     * 示例 3：
     * <p>
     * 输入：S = "a##c", T = "#a#c"
     * 输出：true
     * 解释：S 和 T 都会变成 “c”。
     * 示例 4：
     * <p>
     * 输入：S = "a#c", T = "b"
     * 输出：false
     *
     * @param s
     * @param t
     * @return
     */
    public boolean backspaceCompare(String s, String t) {
        return getRealText(s).equals(getRealText(t));
    }

    public static void main(String[] args) {
        No844 no844 = new No844();
        System.out.println(no844.backspaceCompare("ab#c","ad#c"));
        System.out.println(no844.backspaceCompare("ab##","c#d#"));
        System.out.println(no844.backspaceCompare("a##c","#a#c"));
        System.out.println(no844.backspaceCompare("a#c","b"));

    }

    /**
     * 获取真实的文案
     *
     * @param origin
     * @return
     */
    public String getRealText(String origin) {
        String result = "";
        if (null != origin) {
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < origin.length(); i++) {
                Character current = origin.charAt(i);
                if ('#' == current) {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                } else {
                    stack.push(current);
                }
            }
            StringBuilder s = new StringBuilder();
            while (!stack.isEmpty()) {
                s.append(stack.pop());
            }
            result = s.toString();
        }
        return result;
    }
}
