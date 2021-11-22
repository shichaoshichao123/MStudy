package com.sc.study.jiuzhang.tree;

import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/11/20 3:33 下午
 * @desc
 */
public class TwoCha {

    public static void main(String[] args) {
        Node root = new Node(1);
        Node left = new Node(2);
        Node right = new Node(3);
        Node node1 = new Node(4);
        Node node2 = new Node(5);
        Node node3 = new Node(6);
        Node node4 = new Node(7);
        root.left = left;
        root.right = right;
        left.left = node1;
        left.right = node2;
        System.out.println(bspByQueue(root));
        System.out.println(bspByDummyNode(root));
        System.out.println(checkTreeIsBalance(root));
        List<Integer> list = new ArrayList<>();
        listAllNode(root, list);
        System.out.println(list);
        List<String> list1 = new ArrayList<>();
        listAllPath(root, root.value + "", list1);
        System.out.println(list1);

    }


    /**
     * 通过单个队列广度优先遍历二叉树
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> bspByQueue(Node root) {
        if (null == root) {
            return Collections.emptyList();
        }
        Queue<Node> queue = new LinkedBlockingQueue<>();
        queue.add(root);
        List<List<Integer>> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int currentSize = queue.size();
            for (int i = 0; i < currentSize; i++) {
                Node currentNode = queue.poll();
                if (null == currentNode) {
                    break;
                }
                level.add(currentNode.value);
                if (null != currentNode.left) {
                    queue.add(currentNode.left);
                }
                if (null != currentNode.right) {
                    queue.add(currentNode.right);
                }
            }
            result.add(level);
        }
        return result;
    }

    /**
     * 通过使用虚拟节点的方式进行BSP
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> bspByDummyNode(Node root) {
        if (null == root) {
            return Collections.emptyList();
        }
        Queue<Node> queue = new LinkedBlockingQueue<>();
        queue.add(root);
        queue.add(new Node());
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> level = new ArrayList<>();
        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            if (null == currentNode.value) {
                if (!level.isEmpty()) {
                    //更新下一层
                    result.add(level);
                }
                //整个队列都为空了就没必要再循环下去了
                if (0 == queue.size()) {
                    break;
                }
                level = new ArrayList<>();
                queue.offer(new Node());
            } else {
                level.add(currentNode.value);
                if (null != currentNode.left) {
                    queue.add(currentNode.left);
                }
                if (null != currentNode.right) {
                    queue.add(currentNode.right);
                }
            }
        }
        return result;
    }

    /**
     * 校验一棵树是否为平衡二叉树
     *
     * @param root
     * @return
     */
    public static TreeResult checkTreeIsBalance(Node root) {
        if (null == root) {
            return new TreeResult(true, 0);
        }
        TreeResult leftTreeResult = checkTreeIsBalance(root.left);
        TreeResult rightTreeResult = checkTreeIsBalance(root.right);
        Integer rootHeight = Math.max(leftTreeResult.getMaxHeight(), rightTreeResult.getMaxHeight()) + 1;//注意+1
        if (Math.abs(leftTreeResult.getMaxHeight() - rightTreeResult.getMaxHeight()) > 1) {
            return new TreeResult(false, rootHeight);
        }
        if (!leftTreeResult.isBalance || !rightTreeResult.isBalance) {
            return new TreeResult(false, rootHeight);
        }
        return new TreeResult(true, rootHeight);

    }


    @Data
    static class TreeResult {
        Boolean isBalance;
        Integer maxHeight;

        public TreeResult(Boolean isBalance, Integer maxHeight) {
            this.isBalance = isBalance;
            this.maxHeight = maxHeight;
        }
    }


    static class Node {
        Integer value;
        Node left;
        Node right;

        public Node() {
        }

        public Node(Integer value) {
            this.value = value;
        }

        public Node(Integer value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }


    /**
     * 找出一颗树中所有的节点
     *
     * @param root
     * @return
     */
    public static void listAllNode(Node root, List<Integer> list) {
        if (null == root) {
            return;
        }
        list.add(root.value);
        listAllNode(root.left, list);
        listAllNode(root.right, list);
    }


    /**
     * 列出一颗树的所有自上而下的路径
     *
     * @param root
     * @param path
     * @param list
     */
    public static void listAllPath(Node root, String path, List<String> list) {
        if (root == null) {
            return;
        }
        if (null == root.left && null == root.right) {
            list.add(path);
            return;
        }
        if (root.left != null) {
            listAllPath(root.left, path + "->" + root.left.value, list);
        }
        if (root.right != null) {
            listAllPath(root.right, path + "->" + root.right.value, list);
        }
    }
}
