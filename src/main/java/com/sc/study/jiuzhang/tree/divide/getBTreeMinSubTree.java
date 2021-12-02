package com.sc.study.jiuzhang.tree.divide;

import com.sc.study.jiuzhang.tree.TwoCha;

/**
 * 获取和值为最小的子树
 */
public class getBTreeMinSubTree {
    public static void main(String[] args) {

    }

    private static int miniNum = Integer.MAX_VALUE;
    private static TwoCha.Node targetNode;

    public static TwoCha.Node getMinSub(TwoCha.Node root) {
        getMinSubTreeSum(root);
        return targetNode;
    }

    /**
     * 根据全局变量的求解方式
     *
     * @param root
     * @return
     */
    private static int getMinSubTreeSum(TwoCha.Node root) {
        if (null == root) {
            return 0;
        }
        //获取左子树的和
        int leftSubTreeSum = getMinSubTreeSum(root.left);
        //获取又子树的和
        int rightSubTreeSum = getMinSubTreeSum(root.right);
        //树的和
        int treeSum = root.value + leftSubTreeSum + rightSubTreeSum;
        //进行是否最小子树判断
        if (treeSum < miniNum) {
            miniNum = treeSum;
            targetNode = root;
        }
        return treeSum;
    }

    /**
     * 根据返回对象的求解方法
     *
     * @param root
     * @return
     */
    private static ResultContent getMinSubTree(TwoCha.Node root) {
        if (null == root) {
            return new ResultContent(0, 0, null);
        }
        //获取左子树的结果
        ResultContent leftResult = getMinSubTree(root.left);
        //获取右子树的结果
        ResultContent rightContent = getMinSubTree(root.right);
        //计算当前树的相关值
        int currentNum = leftResult.currentSum + rightContent.currentSum + root.value;
        int minSum = currentNum;
        TwoCha.Node minRoot = root;
        if (minSum >= rightContent.nimNum) {
            minSum = rightContent.nimNum;
            minRoot = rightContent.minRoot;
        }

        if (minSum >= leftResult.nimNum) {
            minSum = leftResult.nimNum;
            minRoot = leftResult.minRoot;
        }
        return new ResultContent(minSum, currentNum, minRoot);
    }


    static class ResultContent {
        int nimNum;
        int currentSum;
        TwoCha.Node minRoot;

        public ResultContent(int nimNum, int currentSum, TwoCha.Node minRoot) {
            this.nimNum = nimNum;
            this.currentSum = currentSum;
            this.minRoot = minRoot;
        }
    }
}
