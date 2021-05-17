package com.sc.study.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/5/17 3:05 下午
 * @desc 给定一棵二叉搜索树，请找出其中第k大的节点。
 */
public class No54 {

    /**
     * 示例 1:
     * <p>
     * 输入: root = [3,1,4,null,2], k = 1
     * 3
     * / \
     * 1   4
     * \
     * 2
     * 输出: 4
     * 示例 2:
     * <p>
     * 输入: root = [5,3,6,2,4,null,null,1], k = 3
     * 5
     * / \
     * 3   6
     * / \
     * 2   4
     * /
     * 1
     * 输出: 4
     * <p>
     * <p>
     * 限制：
     * <p>
     * 1 ≤ k ≤ 二叉搜索树元素个数
     *
     * @param root
     * @param k
     * @return
     */
    public int kthLargest(TreeNode root, int k) {
        if (null == root) {
            return 0;
        }
        List<Integer> data = new ArrayList<>();
        //中序遍历
        midBl(root, data);
        return data.get(k - 1);
    }

    private void midBl(TreeNode node, List<Integer> data) {
        if (null == node) {
            return;
        }
        midBl(node.left, data);
        data.add(node.val);
        midBl(node.right, data);

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
