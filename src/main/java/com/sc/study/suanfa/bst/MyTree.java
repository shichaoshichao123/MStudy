package com.sc.study.suanfa.bst;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/3/13 11:35 上午
 * @desc
 */
public class MyTree {

    protected TreeNode root;

    /**
     * 添加节点
     *
     * @param node
     */
    public void add(TreeNode node) {
        if (null == node) {
            return;
        }
        if (root == null) {
            root = node;
        } else {
            doAdd(root, node);

        }
    }

    private void doAdd(TreeNode parent, TreeNode node) {
        if (null != parent) {
            if (parent.value >= node.value) {
                if (null == parent.leftChild) {
                    parent.leftChild = node;

                } else {
                    doAdd(parent.leftChild, node);

                }
            } else {
                if (parent.rightChild == null) {
                    parent.rightChild = node;

                } else {
                    doAdd(parent.rightChild, node);

                }
            }
        }
    }

    /**
     * 中序便利整颗树
     */
    public void reviewTree() {
        if (null != root) {
            recursion(root);
        } else {
            System.out.println("null");

        }
    }

    private void recursion(TreeNode node) {
        if (null == node) {
            return;
        }
        recursion(node.leftChild);
        System.out.println(node.value);
        recursion(node.rightChild);
    }

    public static class TreeNode {
        public Integer value;
        public TreeNode leftChild;
        public TreeNode rightChild;

        public TreeNode(Integer value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "value=" + value +
                    ", leftChild=" + leftChild +
                    ", rightChild=" + rightChild +
                    '}';
        }
    }

    public static void main(String[] args) {
        MyTree myTree = new MyTree();
        myTree.add(new TreeNode(12));
        myTree.add(new TreeNode(13));
        myTree.add(new TreeNode(2));
        myTree.add(new TreeNode(14));
        myTree.add(new TreeNode(3));
        myTree.reviewTree();
        System.out.println(checkIsBst(myTree));
        MyTree myTree1 = new MyTree();
        TreeNode node1 = new TreeNode(12);
        TreeNode node2 = new TreeNode(13);
        TreeNode node3 = new TreeNode(12);
        TreeNode node4 = new TreeNode(14);
        TreeNode node5 = new TreeNode(13);
        myTree.add(node1);
        myTree.add(node2);
        myTree.add(node3);
        myTree.add(node4);
        myTree.add(node5);

        System.out.println(false||false&&true&&true);
        System.out.println(findNearShareParent(myTree.root, node4, node2));
    }

    /**
     * 检验给定的树是否是二叉搜索树
     *
     * @param myTree
     * @return
     */
    private static boolean checkIsBst(MyTree myTree) {
        if (null == myTree) {
            return false;
        }
        return doCheckIsBst(myTree.root, null, null);

    }

    /**
     * 递归校验逻辑
     *
     * @param root
     * @param min
     * @param max
     * @return
     */
    private static boolean doCheckIsBst(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;

        }
        if (null != min && min >= root.value) {
            return false;
        }
        if (null != max && max <= root.value) {
            return false;

        }

        return doCheckIsBst(root.leftChild, min, root.value) && doCheckIsBst(root.rightChild, root.value, max);
    }

    /**
     * 求以某个节点为根的二叉树中的两个节点的最近公共祖先节点
     * 采用递归的查询方式，去递归查询node1与node2在对应的子树中是否存在如果不存在就可以抛弃对该子树的进一步递归查找了
     * 如果存在就将root向下移动循化递归查找直到root==node1或node2的时候说明已经找到了
     *
     * @param root
     * @param node1
     * @param node2
     * @return
     */
    private static TreeNode findNearShareParent(TreeNode root, TreeNode node1, TreeNode node2) {
        if (null == root) {
            return root;
        }
        if (root == node1) {
            return node1;
        }
        if (root == node2) {
            return node2;

        }
        //递归
        TreeNode result1 = findNearShareParent(root.leftChild, node1, node2);
        TreeNode result2 = findNearShareParent(root.rightChild, node1, node2);
        //进行返回判断
        return null == result1 ? result2 : null == result2 ? result1 : root;
    }
}
