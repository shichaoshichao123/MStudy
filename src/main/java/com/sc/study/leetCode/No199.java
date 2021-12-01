package com.sc.study.leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/5/19 10:15 上午
 * @desc 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 */
public class No199 {
    /**
     * 示例:
     * <p>
     * 输入:[1,2,3,null,5,null,4]
     * 输出:[1, 3, 4]
     * 解释:
     * <p>
     * 1            <---
     * /   \
     * 2     3         <---
     * \     \
     * 5     4       <---
     * 可以使用按层遍历的方式每次只取每层最后一个子节点
     *
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        if (null == root) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> nodeQueue = new LinkedBlockingQueue<>();
        nodeQueue.offer(root);
        while (!nodeQueue.isEmpty()) {
            int levelSize = nodeQueue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = nodeQueue.poll();
                if (null != currentNode) {
                    if (i == levelSize - 1) {
                        result.add(currentNode.val);
                    }
                    if (null != currentNode.left) {
                        nodeQueue.add(currentNode.left);
                    }
                    if (null != currentNode.right) {
                        nodeQueue.add(currentNode.right);
                    }
                }
            }

        }
        return result;
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
