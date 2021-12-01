package com.sc.study.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/6/9 10:48 上午
 * @desc 从链表中删去总和值为零的连续节点
 * 给你一个链表的头节点head，请你编写代码，反复删去链表中由 总和值为 0 的连续节点组成的序列，直到不存在这样的序列为止。
 * <p>
 * 删除完毕后，请你返回最终结果链表的头节点。
 */
public class No1171 {
    /**
     * 示例 1：
     * <p>
     * 输入：head = [1,2,-3,3,1]
     * 输出：[3,1]
     * 提示：答案 [1,2,1] 也是正确的。
     * 示例 2：
     * <p>
     * 输入：head = [1,2,3,-3,4]
     * 输出：[1,2,4]
     * 示例 3：
     * <p>
     * 输入：head = [1,2,3,-3,-2]
     * 输出：[1]
     */
    public ListNode removeZeroSumSublists(ListNode head) {
        if (null == head) {
            return null;
        }
        List<ListNode> nodeList = new ArrayList<>();
        while (head.next != null) {
            if(head.val!=0){
                nodeList.add(head);

            }
            head = head.next;
        }
        if(head.val!=0){
            nodeList.add(head);

        }
        List<ListNode> resultList = new ArrayList<>();
        for (int i = 0; i < nodeList.size(); i++) {
            System.out.println("i=====" + i);
            ListNode currentNode = nodeList.get(i);
            int currentSum = currentNode.val;
            boolean sumZero = false;
            for (int j = i + 1; j < nodeList.size(); j++) {
                currentSum += nodeList.get(j).val;
                if (currentSum == 0) {
                    i = j;
                    sumZero = true;
                    break;
                }
            }
            if (!sumZero && currentSum != 0) {
                resultList.add(currentNode);
            }

        }
        ListNode tureResult = null;
        if (!resultList.isEmpty()) {
            ListNode headNode = new ListNode(resultList.get(0).val);
            tureResult = headNode;
            for (int i = 1; i < resultList.size(); i++) {
                headNode.next = new ListNode(resultList.get(i).val);
                headNode = headNode.next;
            }
        }

        return tureResult;
    }

    public static void main(String[] args) {
        No1171 no1171 = new No1171();
        ListNode head = new ListNode(0);
//        ListNode node2 = new ListNode(2);
//        ListNode node3 = new ListNode(3);
//        ListNode node4 = new ListNode(-3);
//        ListNode node5 = new ListNode(-2);
//        head.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
        ListNode result = no1171.removeZeroSumSublists(head);
        System.out.println(result);
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}


