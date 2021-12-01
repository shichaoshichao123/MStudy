package com.sc.study.leetCode;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/9/10 2:02 下午
 * @desc
 */
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
