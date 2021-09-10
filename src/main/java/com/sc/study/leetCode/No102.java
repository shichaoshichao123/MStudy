package com.sc.study.leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/9/10 2:08 下午
 * @desc 102. 二叉树的层序遍历
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 */
public class No102 {

    public static void main(String[] args) {
        No102 no102 = new No102();
    }

    /**
     * 二叉树：[3,9,20,null,null,15,7],
     * <p>
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * 返回其层序遍历结果：
     * <p>
     * [
     * [3],
     * [9,20],
     * [15,7]
     * ]
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (null == root) {
            return result;
        }
        Queue<TreeNode> nodeQueue = new LinkedBlockingQueue<>();
        nodeQueue.add(root);
        while (!nodeQueue.isEmpty()) {
            List<Integer> levelData = new ArrayList<>();
            int size = nodeQueue.size();
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = nodeQueue.poll();
                if (null != currentNode) {
                    levelData.add(currentNode.val);
                    if (null != currentNode.left) {
                        nodeQueue.add(currentNode.left);
                    }
                    if (null != currentNode.right) {
                        nodeQueue.add(currentNode.right);
                    }
                }
            }
            result.add(levelData);
        }
        return result;
    }

}
