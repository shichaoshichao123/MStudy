package com.sc.study.offer;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/5/17 5:21 下午
 * @desc 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 */
public class No25 {
    /**
     * 示例1：
     * <p>
     * 输入：1->2->4, 1->3->4
     * 输出：1->1->2->3->4->4
     * 限制：
     * <p>
     * 0 <= 链表长度 <= 1000
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (null == l1) {
            return l2;
        } else if (null == l2) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
