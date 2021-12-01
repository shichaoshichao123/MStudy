package com.sc.study.leetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/9/10 2:01 下午
 * @desc
 */
public class No94 {
    public static void main(String[] args) {
        No94 no94 = new No94();
    }

    /**
     * 给定一个二叉树的根节点 root ，返回它的 中序遍历。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：root = [1,null,2,3]
     * 输出：[1,3,2]
     * 示例 2：
     * <p>
     * 输入：root = []
     * 输出：[]
     * 示例 3：
     * <p>
     * 输入：root = [1]
     * 输出：[1]
     * 示例 4：
     * <p>
     * <p>
     * 输入：root = [1,2]
     * 输出：[2,1]
     * 示例 5：
     * <p>
     * <p>
     * 输入：root = [1,null,2]
     * 输出：[1,2]
     *  
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        if (null == root) {
            return Collections.emptyList();
        }
        List<Integer> result = new ArrayList<>();
        doInorderTraversal(root, result);
        return result;
    }

    private void doInorderTraversal(TreeNode node, List<Integer> result) {
        if (null == node) {
            return;
        }
        if (node.left != null) {
            doInorderTraversal(node.left, result);
        }
        result.add(node.val);
        if (node.right != null) {
            doInorderTraversal(node.right, result);
        }

    }

}
