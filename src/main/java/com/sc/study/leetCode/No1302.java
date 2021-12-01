package com.sc.study.leetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/4/21 1:39 下午
 * @desc 给你一棵二叉树的根节点 root ，请你返回 层数最深的叶子节点的和 。
 */
public class No1302 {

    /**
     * 示例 1：
     * <p>
     * <p>
     * <p>
     * 输入：root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
     * 输出：15
     * 示例 2：
     * <p>
     * 输入：root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
     * 输出：19
     * <p>
     * <p>
     * 提示：
     * <p>
     * 树中节点数目在范围 [1, 104]之间。
     * 1 <= Node.val <= 100
     * <p>
     * 思路：直接按层遍历，并且只对最后一层的节点进行相加获得结果
     *
     * @param root
     * @return
     */
    public int deepestLeavesSum(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int maxLevel = maxLevel(root);
        //先求出这颗树的最大深度
        Queue<List<TreeNode>> levelQueue = new LinkedBlockingQueue<>();
        levelQueue.add(Collections.singletonList(root));
        int currentLevel = 0;
        int result = 0;
        while (!levelQueue.isEmpty()) {
            currentLevel++;
            List<TreeNode> currentNodes = levelQueue.poll();
            if (null != currentNodes) {
                if (currentLevel == maxLevel) {
                    for (TreeNode sub : currentNodes) {
                        result += sub.val;
                    }
                } else {
                    List<TreeNode> nextLevelNodes = new ArrayList<>();
                    for (TreeNode sub : currentNodes) {
                        if (null != sub.left) {
                            nextLevelNodes.add(sub.left);
                        }
                        if (null != sub.right) {
                            nextLevelNodes.add(sub.right);
                        }

                    }
                    levelQueue.add(nextLevelNodes);
                }


            }

        }
        return result;

    }

    /**
     * 获取树的最大深度
     *
     * @param root
     * @return
     */
    private int maxLevel(TreeNode root) {
        if (null == root) {
            return 0;
        }
        return Math.max(maxLevel(root.left), maxLevel(root.right)) + 1;
    }


    public class TreeNode {
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
