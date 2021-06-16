package com.sc.study.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/6/16 5:15 下午
 * @desc 请判断一个链表是否为回文链表。
 */
public class No234 {

    /**
     * 示例 1:
     * <p>
     * 输入: 1->2
     * 输出: false
     * 示例 2:
     * <p>
     * 输入: 1->2->2->1
     * 输出: true
     * 进阶：
     * 你能否用O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        return doIsPalindrome1(head);

    }

    public static void main(String[] args) {
        No234 no234 = new No234();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(1);
        node1.next = node2;
        System.out.println(no234.isPalindrome(node1));
        node2.next = node3;
        node3.next =node4;
        System.out.println(no234.isPalindrome(node1));
    }


    private boolean doIsPalindrome1(ListNode head) {
        if (null == head) {
            return false;
        }
        List<ListNode> nodeList = new ArrayList<>();
        while (null != head.next) {
            nodeList.add(head);
            head = head.next;
        }
        nodeList.add(head);
        int left = 0;
        int right = nodeList.size() - 1;
        while (left < right) {
            if (nodeList.get(left).val != nodeList.get(right).val) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
