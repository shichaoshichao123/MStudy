package com.sc.study.leetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/5/6 4:31 下午
 * @desc 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * <p>
 * 叶子节点 是指没有子节点的节点。
 */
public class No113 {

    /**
     * 示例 1：
     * <p>
     * <p>
     * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
     * 输出：[[5,4,11,2],[5,8,4,5]]
     * 示例 2：
     * <p>
     * <p>
     * 输入：root = [1,2,3], targetSum = 5
     * 输出：[]
     * 示例 3：
     * <p>
     * 输入：root = [1,2], targetSum = 0
     * 输出：[]
     *
     * @param root
     * @param targetSum
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (null == root) {
            return Collections.emptyList();
        }
        List<List<Integer>> result = new ArrayList<>();
        doPathSum(root, targetSum, result,null);
        return result;
    }

    private void doPathSum(TreeNode node, int targetSum, List<List<Integer>> result, List<Integer> path) {
        if (null == path) {
            path = new ArrayList<>();
        }
        if (null == node.left && null == node.right) {
            if (0 == targetSum - node.val) {
                path.add(node.val);
                result.add(path);
            }
            return;
        }
        if (null != node.left) {
            List<Integer> current = new LinkedList<>(path);
            current.add(node.val);
            doPathSum(node.left, targetSum - node.val, result, current);

        }
        if (null != node.right) {
            List<Integer> current = new LinkedList<>(path);
            current.add(node.val);
            doPathSum(node.right, targetSum - node.val, result, current);

        }

    }


    public static void main(String[] args) {
        No113 no113 = new No113();
//        TreeNode root = new TreeNode(5);
//        TreeNode root1 = new TreeNode(4);
//        TreeNode root2 = new TreeNode(8);
//        TreeNode root3 = new TreeNode(11);
//        TreeNode root4 = new TreeNode(13);
//        TreeNode root5 = new TreeNode(14);
//        TreeNode root6 = new TreeNode(4);
//        TreeNode root7 = new TreeNode(7);
//        TreeNode root8 = new TreeNode(2);
//        TreeNode root9 = new TreeNode(5);
//        TreeNode root10 = new TreeNode(1);
//        root.left = root1;
//        root.right = root2;
//        root1.left = root3;
//        root3.left = root7;
//        root3.right = root8;
//        root2.left = root4;
//        root2.right = root6;
//        root6.left = root9;
//        root6.right = root10;

//        TreeNode root = new TreeNode(1);
//        TreeNode node1 = new TreeNode(2);
//        TreeNode node2 = new TreeNode(3);
//        root.left = node1;
//        root.right = node2;
        TreeNode root = new TreeNode(-2);
        TreeNode node1 = new TreeNode(-3);
//        TreeNode node2 = new TreeNode(3);
        root.left = node1;
//        root.right = node2;
        System.out.println(no113.pathSum(root, -5));
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
