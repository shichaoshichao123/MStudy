package com.sc.study.jiuzhang.tree.divide;

import java.util.HashSet;
import java.util.Set;

/**
 * @author yingqi
 * @date 2021/12/2
 * @desc 求两个节点的最近公共祖先节点
 */
public class NearAncestor {

    public static void main(String[] args) {

    }

    /**
     * 针对有父亲节点的树结构查询两个节点的公共最近祖先解法
     * tip :题中所有节点的值都是唯一的
     *
     * @param root
     * @param node1
     * @param node2
     * @return
     */
    private static NearAncestorNode lcaByParent(NearAncestorNode root, NearAncestorNode node1, NearAncestorNode node2) {
        if (null == root || node1 == null || node2 == null) {
            return null;
        }
        //使用一个集合存放某个节点的所有祖先节点，之后再进行另一个节点的祖先节点便利，只要有一个是在集合中就是要求解的值
        Set<Integer> parentSet = new HashSet<>();
        NearAncestorNode current = node1;
        while (null != current) {
            //这是因为可能两个节点中某个节点就是另一个节点的父亲节点
            parentSet.add(current.value);
            current = current.parent;
        }
        current = node2;
        while (null != current) {

            if (parentSet.contains(current.value)) {
                return current;
            }
            current = current.parent;
        }
        return null;
    }


    /**
     * 不使用父亲节点求解两个节点的最近公共祖先
     *
     * @param root
     * @param node1
     * @param node2
     * @return
     */
    private static NearAncestorNode lcaWithoutParentNode(NearAncestorNode root, NearAncestorNode node1, NearAncestorNode node2) {
        if (null == root) {
            return null;
        }
        if (node1 == root || node2 == root) {
            return root;
        }
        //采用分治法，分别去左右子树中查找是否存在某个节点，碰到第一个就返回

        NearAncestorNode left = lcaWithoutParentNode(root.left, node1, node2);
        NearAncestorNode right = lcaWithoutParentNode(root.right, node1, node2);
        //如果左右子树都有说明当前节点就是他们的最近公共祖先啦
        if (null != left && null != right) {
            return root;
        }
        //如果只有左边不为空那么说明两个节点都在左边
        if (null != left) {
            return left;
        }
        //如果只有右边不为空那么说明两个节点都在左边
        if (null != right) {
            return right;
        }
        //左右都不存在说明没有公共祖先
        return null;
    }

    /**
     * 节点
     */
    static class NearAncestorNode {
        int value;
        NearAncestorNode parent;
        NearAncestorNode left;
        NearAncestorNode right;
    }

}
