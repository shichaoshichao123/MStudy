package com.sc.study.leetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/4/22 10:10 上午
 * @desc 给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。
 */
public class No95 {

    public static void main(String[] args) {

    }

    /**
     * 示例：
     * <p>
     * 输入：3
     * 输出：
     * [
     * [1,null,3,2],
     * [3,2,null,1],
     * [3,1,null,null,2],
     * [2,1,3],
     * [1,null,2,null,3]
     * ]
     * 解释：
     * 以上的输出对应以下 5 种不同结构的二叉搜索树：
     * <p>
     * 1         3     3      2      1
     * \       /     /      / \      \
     * 3     2     1      1   3      2
     * /     /       \                 \
     * 2     1         2                 3
     * <p>
     * <p>
     * 提示：
     * 0 <= n <= 8
     * <p>
     * 思路：中顺遍历是一个从小到大有序的
     *
     * @param n
     * @return
     */
    public List<TreeNode> generateTrees(int n) {
        if (n <= 0) {
            return Collections.emptyList();
        }

        return generateTreesByDg(1, n);
    }

    private List<TreeNode> generateTreesByDg(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if (start > end) {
            res.add(null);
            return res;
        }
        //分别作为跟节点的情况
        for (int i = start; i <= end; i++) {
            //由于本身就是有序的所以跟节点的左边就是它的左子树的组成右边为它的右子树组成
            List<TreeNode> left = generateTreesByDg(start, i - 1);
            List<TreeNode> right = generateTreesByDg(i + 1, end);
            //两层遍历获得左右子树的内容
            for (TreeNode lh : left) {
                for (TreeNode rh : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = lh;
                    root.right = rh;
                    res.add(root);
                }
            }
        }
        return res;
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
