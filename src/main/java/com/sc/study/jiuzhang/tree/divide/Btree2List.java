package com.sc.study.jiuzhang.tree.divide;

/**
 * @author yingqi
 * @date 2021/12/2
 * @desc 将二叉树转成链表
 */
public class Btree2List {

    public static void main(String[] args) {

    }

    /**
     * 拉直一个二叉树
     *
     * @param root
     * @return
     */
    private static BtreeNode flattenBtree(BtreeNode root) {
        if (null == root) {
            return null;
        }
        BtreeNode leftLast = flattenBtree(root.left);
        BtreeNode rightLast = flattenBtree(root.right);
        //左边不为空就要进行合并拉直操作
        if (null != leftLast) {
            leftLast.right = root.right;
            root.right = root.left;
            // 这步很重要
            root.left = null;
        }

        //返回最后一个节点
        if (rightLast != null) {
            return rightLast;
        }
        if (leftLast != null) {
            return leftLast;
        }
        return root;
    }
}
