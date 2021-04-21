package com.sc.study.leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/4/19 5:44 下午
 * @desc 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 */
public class No144 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        // TreeNode node3 = new TreeNode(1);
        node1.left = node2;
        root.right = node1;
        No144 no144 = new No144();
        System.out.println(no144.preorderTraversal(root));

    }

    /**
     * 示例 1：
     * <p>
     * <p>
     * 输入：root = [1,null,2,3]
     * 输出：[1,2,3]
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
     * 输出：[1,2]
     * 示例 5：
     * <p>
     * <p>
     * 输入：root = [1,null,2]
     * 输出：[1,2]
     *  
     * <p>
     * 提示：
     * <p>
     * 树中节点数目在范围 [0, 100] 内
     * -100 <= Node.val <= 100
     *  
     * <p>
     * 进阶：递归算法很简单，你可以通过迭代算法完成吗？
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        preorderTraversalByDd(root, result);
        return result;
    }

    /**
     * 迭代的方式进行二叉树的前序遍历
     *
     * @param node
     * @return
     */
    public void preorderTraversalByDd(TreeNode node, List<Integer> result) {
        Stack<TreeNode> myStack = new Stack<>();
        while (!myStack.isEmpty() || null != node) {
            //第一层while进行深度向下到叶子节点
            while (null != node) {
                result.add(node.val);
                myStack.push(node);
                node = node.left;
            }
            //回溯操作
            node = myStack.pop();
            node = node.right;
        }
    }


    /**
     * 递归查找
     *
     * @param node
     * @param result
     * @return
     */
    public void preorderTraversalByDg(TreeNode node, List<Integer> result) {
        if (null == node) {
            return;
        }
        result.add(node.val);
        preorderTraversalByDg(node.left, result);
        preorderTraversalByDg(node.right, result);
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
