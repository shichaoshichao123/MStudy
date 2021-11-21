package com.sc.study.jiuzhang.tree;

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
        root.left = left;
        root.right = right;
        left.left = node1;
        left.right = node2;
        System.out.println(bspByQueue(root));
        System.out.println(bspByDummyNode(root));
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
}
