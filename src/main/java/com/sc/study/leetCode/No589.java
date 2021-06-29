package com.sc.study.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/6/29 4:45 下午
 * @desc 给定一个 N 叉树，返回其节点值的 前序遍历 。
 * <p>
 * N 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。
 */
public class No589 {
    /**
     * 示例 1：
     * <p>
     * <p>
     * <p>
     * 输入：root = [1,null,3,2,4,null,5,6]
     * 输出：[1,3,5,6,2,4]
     *
     * @param root
     * @return
     */
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        preorderByRecursion(root, result);
        return result;
    }

    /**
     * 通过递归进行遍历
     *
     * @param node
     * @return
     */
    public static void preorderByRecursion(Node node, List<Integer> result) {
        if (null == node) {
            return;
        }
        result.add(node.val);
        List<Node> children = node.children;
        for (Node child : children) {
            preorderByRecursion(child, result);
        }

    }

    /**
     * 通过迭代进行遍历
     *
     * @param node
     * @return
     */
    public static void preorderByDd(Node node, List<Integer> result) {
        if (null == node) {
            return;
        }
        result.add(node.val);
        List<Node> children = node.children;
        for (Node child : children) {
            preorderByRecursion(child, result);
        }

    }

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    ;
}
