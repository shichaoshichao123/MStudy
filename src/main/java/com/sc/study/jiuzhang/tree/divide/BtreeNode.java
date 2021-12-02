package com.sc.study.jiuzhang.tree.divide;

/**
 * @author yingqi
 * @date 2021/12/2
 */
public class BtreeNode {
    int value;
    BtreeNode left;
    BtreeNode right;
    BtreeNode parent;

    public BtreeNode(int value, BtreeNode left, BtreeNode right, BtreeNode parent) {
        this.value = value;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }
}
