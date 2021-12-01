package com.sc.study.leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/4/13 8:16 下午
 * @desc leetCode 第二题
 */
public class No2 {

    /**
     * [2,4,9]
     * [5,6,4,9]
     * [7,0,4,0,1]
     *
     * @param args
     */
    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(9);
        node1.next = node2;
        node2.next = node3;
        ListNode node8 = new ListNode(5);
        ListNode node9 = new ListNode(6);
        ListNode node10 = new ListNode(4);
        ListNode node11 = new ListNode(9);
        node8.next = node9;
        node9.next = node10;
        node10.next = node11;

        ListNode result = doSolution(node1, node8);
        System.out.println(result);


    }

    /**
     * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
     * <p>
     * 请你将两个数相加，并以相同形式返回一个表示和的链表。
     * <p>
     * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/add-two-numbers
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param node1
     * @param node2
     * @return
     */
    private static ListNode doSolution(ListNode node1, ListNode node2) {
        if (null == node1 && null == node2) {
            return new ListNode();

        }
        List<ListNode> node1Stack = buildStack(node1);
        List<ListNode> node2Stack = buildStack(node2);
        if (node1Stack.size() >= node2Stack.size()) {
            return doAdd(node1Stack, node2Stack);
        } else {
            return doAdd(node2Stack, node1Stack);

        }


    }

    /**
     * 抽取出的指定逻辑注意大的栈一定要放前面
     *
     * @param bigStack
     * @param minStack
     * @return
     */
    private static ListNode doAdd(List<ListNode> bigStack, List<ListNode> minStack) {
        List<ListNode> temp = new ArrayList<ListNode>();
        boolean needAdd = false;
        for (int i = 0; i < minStack.size(); i++) {
            ListNode current1 = bigStack.get(i);
            ListNode current2 = minStack.get(i);
            int base = current1.value + (needAdd ? 1 : 0);
            if (base > current1.value) {
                needAdd = false;
            }
            if (base + current2.value - 10 >= 0) {
                needAdd = true;
                temp.add(new ListNode(base + current2.value - 10));
            } else {
                temp.add(new ListNode(base + current2.value));
            }
        }
        for (int i = minStack.size() ; i < bigStack.size(); i++) {
            ListNode current1 = bigStack.get(i);
            int base = current1.value + (needAdd ? 1 : 0);
            if (base > current1.value) {
                needAdd = false;
            }
            if (base >= 10) {
                needAdd = true;
                temp.add(new ListNode(base - 10));


            } else {
                temp.add(new ListNode(base));

            }
        }
        if (needAdd) {
            temp.add(new ListNode(1));
        }

        return List2ListNode(temp);
    }

    private static ListNode List2ListNode(List<ListNode> temp) {
        for (int i = 1; i < temp.size(); i++) {
            temp.get(i - 1).next = temp.get(i);


        }
        return temp.get(0);
    }

    /**
     * 将整个链表入栈
     *
     * @param node
     * @return
     */
    private static List<ListNode> buildStack(ListNode node) {
        List<ListNode> result = new Stack<>();
        if (null != node) {
            do {
                result.add(node);
                node = node.next;
            } while (null != node);
        }
        return result;
    }


    static class ListNode {

        /**
         * 节点值
         */
        Integer value;

        /**
         * 下一个节点
         */
        ListNode next;


        public ListNode() {
            this.value = 0;
            this.next = null;
        }

        public ListNode(Integer value) {
            this.value = value;
            this.next = null;
        }

        public ListNode(Integer value, ListNode next) {
            this.value = value;
            this.next = next;
        }


    }

}


