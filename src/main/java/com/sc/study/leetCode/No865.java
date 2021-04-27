package com.sc.study.leetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/4/27 10:39 上午
 * @desc 给定一个根为root的二叉树，每个节点的深度是 该节点到根的最短距离 。
 * <p>
 * 如果一个节点在 整个树 的任意节点之间具有最大的深度，则该节点是 最深的 。
 * <p>
 * 一个节点的 子树 是该节点加上它的所有后代的集合。
 * <p>
 * 返回能满足 以该节点为根的子树中包含所有最深的节点 这一条件的具有最大深度的节点。
 */
public class No865 {
    /**
     * 示例 1：
     * <p>
     * <p>
     * <p>
     * 输入：root = [3,5,1,6,2,0,8,null,null,7,4]
     * 输出：[2,7,4]
     * 解释：
     * 我们返回值为 2 的节点，在图中用黄色标记。
     * 在图中用蓝色标记的是树的最深的节点。
     * 注意，节点 5、3 和 2 包含树中最深的节点，但节点 2 的子树最小，因此我们返回它。
     * 示例 2：
     * <p>
     * 输入：root = [1]
     * 输出：[1]
     * 解释：根节点是树中最深的节点。
     * 示例 3：
     * <p>
     * 输入：root = [0,1,3,null,2]
     * 输出：[2]
     * 解释：树中最深的节点为 2 ，有效子树为节点 2、1 和 0 的子树，但节点 2 的子树最小。
     *
     * @param root
     * @return
     */
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (null == root) {
            return null;
        }
        //1：获取树的最大深度
        int maxLevel = maxLevel(root);
        //2：按层遍历获取到最大深度下的所有叶子节点
        List<TreeNode> maxLevelNode = getSomeLevelNode(root, maxLevel);
        //3：求出这些最大深度叶子节点的公共父节点
        return getParentNode(root, maxLevelNode);
    }

    public static void main(String[] args) {
        No865 no865 = new No865();
        TreeNode root = new TreeNode(0);
        System.out.println(no865.subtreeWithAllDeepest(root).val);
        TreeNode node3 = new TreeNode(3);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        root.left = node1;
        root.right = node3;
        node3.left = node2;
        System.out.println(no865.subtreeWithAllDeepest(root).val);

    }

    /**
     * 获取多个节点的最近公共父节点
     *
     * @param node
     * @param nodes
     * @return
     */
    private TreeNode getParentNode(TreeNode node, List<TreeNode> nodes) {
        if (null == node) {
            return node;
        }
        for (TreeNode treeNode : nodes) {
            if (treeNode.equals(node)) {
                return node;
            }
        }
        //从左子树中获取公共父节点
        TreeNode node1 = getParentNode(node.left, nodes);
        //从右子树中获取公共父节点
        TreeNode node2 = getParentNode(node.right, nodes);
        //左边没有公共父节点的情况下就不需要再考虑左边了
        if (null == node1) {
            return node2;
        }
        //右边没有公共父节点的情况下就不需要再考虑右边了
        else if (null == node2) {
            return node1;
        }
        //两边都没有满足条件的说明当前节点就是最近的公共父节点
        else {
            return node;
        }
    }

    /**
     * 获取某棵树的某层上所有节点元素
     *
     * @param node
     * @return
     */
    private List<TreeNode> getSomeLevelNode(TreeNode node, int level) {
        if (null == node) {
            return Collections.emptyList();
        }
        int currentLevel = 1;
        Queue<TreeNode> levelQueue = new LinkedBlockingQueue<>();
        levelQueue.add(node);
        List<TreeNode> result = new ArrayList<>();
        while (!levelQueue.isEmpty()) {
            int size = levelQueue.size();
            if (currentLevel == level) {
                for (int i = 0; i < size; i++) {
                    result.add(levelQueue.poll());
                }
                break;
            }
            for (int i = 0; i < size; i++) {
                TreeNode current = levelQueue.poll();
                if (null == current) {
                    continue;
                }
                if (null != current.left) {
                    levelQueue.add(current.left);
                }
                if (null != current.right) {
                    levelQueue.add(current.right);
                }
            }
            currentLevel++;

        }
        return result;
    }

    /**
     * 求一棵树的最大深度
     *
     * @param node
     * @return
     */
    private int maxLevel(TreeNode node) {
        if (null == node) {
            return 0;
        }
        return Math.max(maxLevel(node.left), maxLevel(node.right)) + 1;
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
