package com.sc.study.leetCode;

import java.util.Stack;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/4/16 10:39 上午
 * @desc 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 */
public class No224 {

    public static void main(String[] args) {
        // System.out.println(calculate("1 + 1"));
        //System.out.println(calculate(" 2-1 + 2 "));
        System.out.println(calculate("(1+(4+5+2)-3)+(6+8)"));
        //System.out.println(calculate("(1 + 1)"));
    }

    /**
     * 示例 1：
     * <p>
     * 输入：s = "1 + 1"
     * 输出：2
     * 示例 2：
     * <p>
     * 输入：s = " 2-1 + 2 "
     * 输出：3
     * 示例 3：
     * <p>
     * 输入：s = "(1+(4+5+2)-3)+(6+8)"
     * 输出：23
     * <p>
     * 思路:使用堆栈/逆波兰表达式
     *
     * @param s
     * @return
     */
    public static int calculate(String s) {
        if (null == s) {
            return 0;
        }
        //用于存放结果以及上一个左括号开始之前的结果以及操作符
        Stack<Integer> cahce = new Stack<>();
        int res = 0;
        //标识加 -1标识减
        int sign = 1;
        for (int i = 0; i < s.length(); i++) {

            Character current = s.charAt(i);
            if (' ' == current) {
                continue;
            } else if (current == '+') {
                sign = 1;

            } else if (current == '-') {
                sign = -1;

            } else if (current == '(') {
                //是一个新括号的开始，这时候利用栈缓存上一次的计算结果以及与下一次括号的操作是加还是减法
                cahce.push(res);
                res = 0;
                cahce.push(sign);
                sign = 1;
            } else if (current == ')') {
                //一个括号但元的结束，进行相关的计算.注意pop顺序
                res = cahce.pop() * res + cahce.pop();
            } else {
                //计算当前数字（可能存在多位的）
                if (Character.isDigit(current)) {
                    int cur = current - '0';
                    while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                        //得到数字（包含不同位的）
                        cur = cur * 10 + s.charAt(++i) - '0';
                    }
                    res = res + sign * cur;
                }
            }
        }
        return res;

    }

    /**
     * 只处理加减法
     *
     * @param operator
     * @param num1
     * @param num2
     * @return
     */
    private static int doCalculate(Character operator, int num1, int num2) {
        if ("-".equals(operator + "")) {
            return num1 - num2;
        }
        return num1 + num2;

    }
}
