package com.sc.study.leetCode;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/5/21 2:57 下午
 * @desc 给你一个二叉树的根节点root。设根节点位于二叉树的第 1 层，而根节点的子节点位于第 2 层，依此类推。
 * <p>
 * 请你找出层内元素之和 最大 的那几层（可能只有一层）的层号，并返回其中最小 的那个。
 */
public class No1161 {
    public int maxLevelSum(TreeNode root) {
        if (null == root) {
            return 0;
        }
        Queue<TreeNode> levelQueue = new LinkedBlockingQueue<>();
        Integer currentSum = null;
        int result = 0;
        int currentLevel = 0;
        levelQueue.add(root);
        while (!levelQueue.isEmpty()) {
            currentLevel++;
            int currentSize = levelQueue.size();
            int tempNum = 0;
            for (int i = 0; i < currentSize; i++) {
                TreeNode node = levelQueue.poll();
                if (null != node) {
                    tempNum += node.val;
                    if (null != node.left) {
                        levelQueue.add(node.left);
                    }
                    if (null != node.right) {
                        levelQueue.add(node.right);
                    }
                }
            }
            if (null == currentSum || tempNum > currentSum) {
                currentSum = tempNum;
                result = currentLevel;
            }
        }
        return result;

    }


    /**
     * 示例 1：
     * 输入：root = [1,7,0,7,-8,null,null]
     * 输出：2
     * 解释：
     * 第 1 层各元素之和为 1，
     * 第 2 层各元素之和为 7 + 0 = 7，
     * 第 3 层各元素之和为 7 + -8 = -1，
     * 所以我们返回第 2 层的层号，它的层内元素之和最大。
     * 示例 2：
     * <p>
     * 输入：root = [989,null,10250,98693,-89388,null,null,null,-32127]
     * 输出：2
     * <p>
     * 提示：
     * <p>
     * 树中的节点数介于1和10^4之间
     * -10^5 <= node.val <= 10^5
     */
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
