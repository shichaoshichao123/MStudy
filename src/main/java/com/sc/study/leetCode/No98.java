package com.sc.study.leetCode;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/5/7 10:56 上午
 * @desc 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 假设一个二叉搜索树具有如下特征：
 * <p>
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树
 */
public class No98 {

    /**
     * 示例1:
     * <p>
     * 输入:
     * 2
     * / \
     * 1   3
     * 输出: true
     * 示例2:
     * <p>
     * 输入:
     * 5
     * / \
     * 1   4
     * / \
     * 3   6
     * 输出: false
     * 解释: 输入为: [5,1,4,null,null,3,6]。
     * 根节点的值为 5 ，但是其右子节点值为 4 。
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        return doIsValidBST(root, null, null);

    }

    private boolean doIsValidBST(TreeNode node, Integer max, Integer min) {
        if (null == node) {
            return true;
        }
        if (null != min && node.val <= min) {
            return false;
        }
        if (null != max && node.val >= max) {
            return false;
        }
        return doIsValidBST(node.left, node.val, min) && doIsValidBST(node.right, max, node.val);
    }

    public static void main(String[] args) {
        No98 no98 = new No98();
        TreeNode root = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(3);
        root.left = node1;
        root.right = node2;
        TreeNode root2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(3);
        TreeNode node6 = new TreeNode(6);
        root2.left = node3;
        root2.right = node4;
        node3.left = node5;
        node3.right = node6;
        System.out.println(no98.isValidBST(root));
        System.out.println(no98.isValidBST(root2));
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
