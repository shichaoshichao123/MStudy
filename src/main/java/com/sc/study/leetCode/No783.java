package com.sc.study.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/6/22 4:44 下午
 * @desc 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 */
public class No783 {

    /**
     * 示例 1：
     * <p>
     * <p>
     * 输入：root = [4,2,6,1,3]
     * 输出：1
     * 示例 2：
     * <p>
     * <p>
     * 输入：root = [1,0,48,null,null,12,49]
     * 输出：1
     * <p>
     * 提示：
     * <p>
     * 树中节点数目在范围 [2, 100] 内
     * 0 <= Node.val <= 105
     * 差值是一个正数，其数值等于两值之差的绝对值
     * <p>
     * 思路:找到最大节点与最小节点，递归的方式
     *
     * @param root
     * @return
     */
    public int minDiffInBST(TreeNode root) {
        if (null == root) {
            return 0;
        }
        return doMinDiffInBSTByMidOrder(root);
    }


    public static void main(String[] args) {
        No783 no783 = new No783();
        TreeNode root = new TreeNode(4);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(6);
        root.left = node1;
        root.right = node2;
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(3);
        node1.left = node3;
        node1.right = node4;
        System.out.println(no783.minDiffInBST(root));
    }

    /**
     * 递归的方式
     *
     * @param node
     * @param max  true 获取最大值 false 获取最小值
     * @return
     */
    private int doMinDiffInBSTByRevolution(TreeNode node, boolean max) {
        return 0;
    }

    /**
     * 通过一次中序便利求解
     *
     * @param root
     * @return
     */
    int res = Integer.MAX_VALUE;
    int preValue = -1;

    private int doMinDiffInBSTByMidOrder(TreeNode root) {
        doMidOrder(root);
        return res;
    }

    /**
     * 中序便历
     *
     * @param node
     */
    private void doMidOrder(TreeNode node) {
        if (null == node) {
            return;
        }
        doMidOrder(node.left);
        if (preValue == -1) {
            preValue = node.val;
        } else {
            res = Math.min(res, node.val - preValue);
            preValue = node.val;
        }
        doMidOrder(node.right);
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
