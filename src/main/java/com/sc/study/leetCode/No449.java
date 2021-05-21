package com.sc.study.leetCode;

import java.util.ArrayDeque;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/5/21 3:19 下午
 * @desc 序列化是将数据结构或对象转换为一系列位的过程，以便它可以存储在文件或内存缓冲区中，或通过网络连接链路传输，以便稍后在同一个或另一个计算机环境中重建。
 * 设计一个算法来序列化和反序列化 二叉搜索树 。 对序列化/反序列化算法的工作方式没有限制。 您只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序列化为最初的二叉搜索树。
 * <p>
 * 编码的字符串应尽可能紧凑。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [2,1,3]
 * 输出：[2,1,3]
 * 示例 2：
 * <p>
 * 输入：root = []
 * 输出：[]
 */
public class No449 {
    public String serialize(TreeNode root) {
        StringBuilder result = new StringBuilder();
        doSerialize(result, root);
        return result.toString();
    }

    private void doSerialize(StringBuilder stringBuilder, TreeNode node) {
        if (null != node) {
            doSerialize(stringBuilder, node.left);
            doSerialize(stringBuilder, node.right);
            stringBuilder.append(node.val);
        }
    }

    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }
        ArrayDeque<Integer> nums = new ArrayDeque<>();
        for (String s : data.split("\\s+")){
            nums.add(Integer.valueOf(s));

        }
        return helper(Integer.MIN_VALUE, Integer.MAX_VALUE, nums);

    }
    public TreeNode helper(Integer lower, Integer upper, ArrayDeque<Integer> nums) {
        if (nums.isEmpty()){
            return null;

        }
        int val = nums.getLast();
        if (val < lower || val > upper){
            return null;

        }
        nums.removeLast();
        TreeNode root = new TreeNode(val);
        root.right = helper(val, upper, nums);
        root.left = helper(lower, val, nums);
        return root;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        No449 no449 = new No449();
        System.out.println(no449.serialize(root));
       TreeNode result =  no449.deserialize("[2,1,3]");
        System.out.println(result);
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
