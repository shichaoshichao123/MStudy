package com.sc.study.offer;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/10/24 3:20 下午
 * @desc
 */
public class RebuildTree {
    public static void main(String[] args) {
        int[] frontOrder = new int[]{1, 2, 4, 7, 3, 5, 6, 8};
        int[] midOrder = new int[]{4, 7, 2, 1, 5, 3, 8, 6};
        System.out.println(doRebuildTree(frontOrder, midOrder));

    }

    public static Node doRebuildTree(int[] frontOrder, int[] midOrder) {
        if (null == frontOrder || null == midOrder) {
            return null;
        }
        return doRebuildTreeCell(frontOrder, 0, frontOrder.length - 1, midOrder, 0, midOrder.length - 1);
    }

    /**
     * 进行递归构建
     *
     * @param frontOrder
     * @param frontOrderStart
     * @param frontOrderEnd
     * @param midOrder
     * @param midOrderStart
     * @param midOrderEnd
     * @return
     */
    private static Node doRebuildTreeCell(int[] frontOrder, int frontOrderStart, int frontOrderEnd, int[] midOrder, int midOrderStart, int midOrderEnd) {
        //根结点值
        Node currentRoot = new Node();
        int rootValue = frontOrder[frontOrderStart];
        currentRoot.value = rootValue;
        currentRoot.leftChild = currentRoot.rightChild = null;
        //表示该树就只有一个元素
        if (frontOrderStart == frontOrderEnd) {
            return currentRoot;
        }
        //处理中序便利，找出左右子树
        int i = midOrderStart;
        while (midOrderStart <= midOrderEnd && midOrder[i] != rootValue) {
            i++;
        }
        //通过i去从新索引
        if (i > 0) {
            currentRoot.leftChild = doRebuildTreeCell(frontOrder, frontOrderStart + 1, frontOrderStart + i + 1, midOrder, midOrderStart + 1, midOrderStart + i + 1);
        }
        if (midOrderEnd - midOrderStart > i) {
            currentRoot.rightChild = doRebuildTreeCell(frontOrder, frontOrderStart + i + 2, frontOrderEnd, midOrder, midOrderStart + i + 2, midOrderEnd);
        }
        return currentRoot;
    }


    /**
     * 获取指定树中指定节点的中序便利的下一节点
     *
     * @param node
     * @return
     */
    public static Node getNextForMidOrder(Node node) {
        if (null == node) {
            return null;
        }
        Node result = null;
        Node rightChild = node.rightChild;
        //如果当前节点有右子树，则下一个便利节点一定是其右子树中的最左节点(包含其右子树的右子树)
        if (null != rightChild) {
            while (null != rightChild.leftChild) {
                rightChild = rightChild.leftChild;
            }
            result = rightChild;
        } else if (null != node.father) {
            //当无右子树的时候有两种情况，1：当前节点是其父亲节点的左节点则下一节点就是父节点 1：否则向上追溯，知道找到某个祖先节点是其父节点的左节点，那么下一节点就是该祖先节点的父节点
            Node current = node;
            Node father = node.father;
            while (null != father && current == father.rightChild) {
                current = father;
                father = father.father;
            }
            result = father;
        }
        return result;
    }


    public static class Node {
        int value;
        Node father;
        Node leftChild;
        Node rightChild;

        public Node(int value, Node leftChild, Node rightChild) {
            this.value = value;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }

        public Node() {
        }
    }
}
