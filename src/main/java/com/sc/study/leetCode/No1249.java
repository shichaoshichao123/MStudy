package com.sc.study.leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/4/20 5:00 下午
 * @desc 给你一个由 '('、')' 和小写字母组成的字符串 s。
 * <p>
 * 你需要从字符串中删除最少数目的 '(' 或者 ')'（可以删除任意位置的括号)，使得剩下的「括号字符串」有效。
 * <p>
 * 请返回任意一个合法字符串。
 * <p>
 * 有效「括号字符串」应当符合以下任意一条要求：
 * <p>
 * 空字符串或只包含小写字母的字符串
 * 可以被写作AB（A连接B）的字符串，其中A和B都是有效「括号字符串」
 * 可以被写作(A)的字符串，其中A是一个有效的「括号字符串」
 */
public class No1249 {

    public static void main(String[] args) {
        No1249 no1249 = new No1249();
        System.out.println(no1249.minRemoveToMakeValid("lee(t(c)o)de)"));
        System.out.println(no1249.minRemoveToMakeValid("a)b(c)d"));
        System.out.println(no1249.minRemoveToMakeValid("))(("));
        System.out.println(no1249.minRemoveToMakeValid("(a(b(c)d)"));
        System.out.println(no1249.minRemoveToMakeValid("())()((("));
    }

    /**
     * 示例 1：
     * <p>
     * 输入：s = "lee(t(c)o)de)"
     * 输出："lee(t(c)o)de"
     * 解释："lee(t(co)de)" , "lee(t(c)ode)" 也是一个可行答案。
     * 示例 2：
     * <p>
     * 输入：s = "a)b(c)d"
     * 输出："ab(c)d"
     * 示例 3：
     * <p>
     * 输入：s = "))(("
     * 输出：""
     * 解释：空字符串也是有效的
     * 示例 4：
     * <p>
     * 输入：s = "(a(b(c)d)"
     * 输出："a(b(c)d)"
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= s.length <= 10^5
     * s[i]可能是'('、')'或英文小写字母
     *
     * @param s
     * @return
     */
    public String minRemoveToMakeValid(String s) {
        if (null == s) {
            return "";
        }
        Stack<Character> leftKhStacks = new Stack<Character>();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (')' == s.charAt(i)) {
                if (!leftKhStacks.isEmpty()) {
                    leftKhStacks.pop();
                } else {
                    continue;
                }
            }
            if ('(' == s.charAt(i)) {
                leftKhStacks.push(s.charAt(i));
            }
            result.append(s.charAt(i));
        }
        //结果移除固定数量个左括号()()(((
        String midRes = result.toString();
        if (0 != leftKhStacks.size()) {
            StringBuilder result2 = new StringBuilder();
            int temp = 0;
            List<Integer> indexList = getCanRemoveIndex(midRes, leftKhStacks.size());
            for (int i = 0; i < midRes.length(); i++) {
                if (temp < leftKhStacks.size()) {
                    if ('(' == midRes.charAt(i) && indexList.contains(i)) {
                        temp++;
                        continue;
                    }
                }
                result2.append(midRes.charAt(i));

            }
            return result2.toString();

        } else {
            return midRes;
        }
    }


    private List<Integer> getCanRemoveIndex(String origin, int limit) {
        Stack<Character> rightKhStacks = new Stack<Character>();
        List<Integer> result = new ArrayList<>();
        for (int i = origin.length() - 1; i >= 0; i--) {
            if (result.size() == limit) {
                break;
            }
            if ('(' == origin.charAt(i)) {
                if (rightKhStacks.isEmpty()) {
                    result.add(i);
                } else {
                    rightKhStacks.pop();
                }

            } else if (')' == origin.charAt(i)) {
                rightKhStacks.add(origin.charAt(i));
            }
        }
        return result;
    }
}
