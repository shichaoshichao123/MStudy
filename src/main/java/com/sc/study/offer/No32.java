package com.sc.study.offer;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/5/18 4:16 下午
 * @desc 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 */
public class No32 {

    /**
     * 例如:
     * 给定二叉树:[3,9,20,null,null,15,7],
     * <p>
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * 返回：
     * <p>
     * [3,9,20,15,7]
     * <p>
     * <p>
     * 提示：
     * <p>
     * 节点总数 <= 1000
     *
     * @param root
     * @return
     */
    public int[] levelOrder(TreeNode root) {
        if (null == root) {
            return new int[]{};
        }
        List<Integer> originResult = new ArrayList<>();
        Queue<TreeNode> nodeQueue = new LinkedBlockingQueue<>();
        nodeQueue.add(root);
        while (!nodeQueue.isEmpty()) {
            int size = nodeQueue.size();
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = nodeQueue.poll();
                if (null != currentNode) {
                    originResult.add(currentNode.val);
                    if (null != currentNode.left) {
                        nodeQueue.add(currentNode.left);
                    }
                    if (null != currentNode.right) {
                        nodeQueue.add(currentNode.right);

                    }
                }

            }
        }
        int[] result = new int[originResult.size()];
        for (int i = 0; i < originResult.size(); i++) {
            result[i] = originResult.get(i);
        }
        return result;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
