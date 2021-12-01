package com.sc.study.leetCode;

import java.util.Stack;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/5/8 3:46 下午
 * @desc 给你一个单链表的引用结点head。链表中每个结点的值不是 0 就是 1。已知此链表是一个整数数字的二进制表示形式。
 * 请你返回该链表所表示数字的 十进制值 。
 */
public class No1290 {

    /**
     * 示例 1：
     * <p>
     * 输入：head = [1,0,1]
     * 输出：5
     * 解释：二进制数 (101) 转化为十进制数 (5)
     * 示例 2：
     * <p>
     * 输入：head = [0]
     * 输出：0
     * 示例 3：
     * <p>
     * 输入：head = [1]
     * 输出：1
     * 示例 4：
     * <p>
     * 输入：head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
     * 输出：18880
     * 示例 5：
     * <p>
     * 输入：head = [0,0]
     * 输出：0
     * <p>
     * 提示：
     * <p>
     * 链表不为空。
     * 链表的结点总数不超过30。
     * 每个结点的值不是0 就是 1。
     *
     * @param head
     * @return
     */
    public int getDecimalValue(ListNode head) {
        if (head == null){
            return 0;

        }
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        int mark = 1;
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop() * mark;
            mark <<= 1;
        }
        return ans;

    }

    public static void main(String[] args) {
        No1290 no1290 = new No1290();
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(0);
        ListNode node2 = new ListNode(1);
        head.next = node1;
        node1.next = node2;
        System.out.println(no1290.getDecimalValue(head));
    }



    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
