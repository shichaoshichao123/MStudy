package com.sc.study.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/4/15 2:15 下午
 * @desc 在一个 m*n 的二维字符串数组中输出二叉树，并遵守以下规则：
 * <p>
 * 行数m应当等于给定二叉树的高度。
 * 列数n应当总是奇数。
 * 根节点的值（以字符串格式给出）应当放在可放置的第一行正中间。根节点所在的行与列会将剩余空间划分为两部分（左下部分和右下部分）。你应该将左子树输出在左下部分，右子树输出在右下部分。左下和右下部分应当有相同的大小。即使一个子树为空而另一个非空，你不需要为空的子树输出任何东西，但仍需要为另一个子树留出足够的空间。然而，如果两个子树都为空则不需要为它们留出任何空间。
 * 每个未使用的空间应包含一个空的字符串""。
 * 使用相同的规则输出子树。
 */
public class No655 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
//        TreeNode node2 = new TreeNode(2);
//        node2.right = new TreeNode(4);
//        root.left = node2;
//        root.right = new TreeNode(3);
//        System.out.println(3/2);
//        System.out.println(1/2);

        No655 n = new No655();
        System.out.println(n.printTree(root));
    }

    /**
     * 示例 1:
     * <p>
     * 输入:
     * 1
     * /
     * 2
     * 输出:
     * [["", "1", ""],
     * ["2", "", ""]]
     * 示例 2:
     * <p>
     * 输入:
     * 1
     * / \
     * 2   3
     * \
     * 4
     * 输出:
     * [["", "", "", "1", "", "", ""],
     * ["", "2", "", "", "", "3", ""],
     * ["", "", "4", "", "", "", ""]]
     * 示例 3:
     * <p>
     * 输入:
     * 1
     * / \
     * 2   5
     * /
     * 3
     * /
     * 4
     * 输出:
     * [["",  "",  "", "",  "", "", "", "1", "",  "",  "",  "",  "", "", ""]
     * ["",  "",  "", "2", "", "", "", "",  "",  "",  "",  "5", "", "", ""]
     * ["",  "3", "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]
     * ["4", "",  "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]]
     * <p>
     * 注意: 二叉树的高度在范围 [1, 10] 中。
     * 思路：其实就是按层输出二叉树,本质上就是求出每层节点的位置并放入二维数组中去
     *
     * @param root
     * @return
     */
    public List<List<String>> printTree(TreeNode root) {
        if (null == root) {
            return null;
        }
        //求出二叉树的高度
        int row = getTreeHeight(root);
        //根据高度得到二维数组的列数
        int col = (1 << row) - 1;
        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            List<String> rowContent = new ArrayList<>();
            for (int j = 0; j < col; j++) {
                rowContent.add("");
            }
            result.add(rowContent);
        }
        middleView(root, result, 0, 0, col);
        return result;
    }

    /**
     * 便利整颗树并复制每个节点的位置
     *
     * @param node
     * @param minX
     * @param maxX
     */
    private void middleView(TreeNode node, List<List<String>> result, Integer level, Integer minX, Integer maxX) {
        if (null == node) {
            return;
        }
        int currentX;
        currentX = (maxX + minX) / 2;
        result.get(level).set(currentX, String.valueOf(node.val));
        middleView(node.left, result, level + 1, minX, currentX);
        middleView(node.right, result, level + 1, currentX + 1, maxX);

    }


    /**
     * 求得树的高度
     *
     * @param root
     * @return
     */
    private int getTreeHeight(TreeNode root) {
        if (null == root) {
            return 0;
        }
        return Math.max(getTreeHeight(root.left), getTreeHeight(root.right)) + 1;
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
