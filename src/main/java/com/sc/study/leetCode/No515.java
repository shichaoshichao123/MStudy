package com.sc.study.leetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/5/11 3:24 下午
 * @desc 您需要在二叉树的每一行中找到最大的值。
 */
public class No515 {
    /**
     * 输入:
     * <p>
     * 1
     * / \
     * 3   2
     * / \   \
     * 5   3   9
     * <p>
     * 输出: [1, 3, 9]
     * <p>
     * 思路:按层遍历
     */
    public List<Integer> largestValues(TreeNode root) {
        if (null == root) {
            return Collections.emptyList();
        }
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> levelQueue = new LinkedBlockingQueue<>();
        levelQueue.add(root);
        while (!levelQueue.isEmpty()) {
            Integer currentMax = null;
            int levelSize = levelQueue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = levelQueue.poll();
                if (null != current) {
                    if(null==currentMax){
                        currentMax = current.val;
                    }else{
                        currentMax = Math.max(currentMax, current.val);

                    }
                    if (null != current.left) {
                        levelQueue.offer(current.left);

                    }
                    if (null != current.right) {
                        levelQueue.offer(current.right);

                    }
                }
            }
            result.add(currentMax);
        }
        return result;
    }

    public static void main(String[] args) {
        No515 no515 = new No515();
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(9);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.right = node5;
        System.out.println(no515.largestValues(root));
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
