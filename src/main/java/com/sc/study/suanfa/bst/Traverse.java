package com.sc.study.suanfa.bst;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/3/15 9:27 下午
 * @desc 二叉树的遍历
 */
public class Traverse {

    public static void main(String[] args) {
        MyTree myTree = new MyTree();
        myTree.add(new MyTree.TreeNode(12));
        myTree.add(new MyTree.TreeNode(13));
        myTree.add(new MyTree.TreeNode(2));
        myTree.add(new MyTree.TreeNode(14));
        myTree.add(new MyTree.TreeNode(3));
        List<Integer> result1 = new ArrayList<>();
        preOrderTraverse(myTree.root, result1);
        List<Integer> result2 = new ArrayList<>();
        mindOrderTraverse(myTree.root, result2);
        List<Integer> result3 = new ArrayList<>();
        postOrderTraverse(myTree.root, result3);
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(levelReviews(myTree.root));
        System.out.println(levelReviewsByDsp(myTree.root));
        System.out.println(minDeep(myTree.root));
        System.out.println(maxDeep(myTree.root));
        System.out.println(generateKh(6));
    }

    /**
     * 前序遍历
     *
     * @param root
     * @return
     */
    private static void preOrderTraverse(MyTree.TreeNode root, List<Integer> result) {
        if (null == root) {
            return;
        }
        result.add(root.value);
        preOrderTraverse(root.leftChild, result);
        preOrderTraverse(root.rightChild, result);

    }


    /**
     * 中序遍历
     *
     * @param root
     * @return
     */
    private static void mindOrderTraverse(MyTree.TreeNode root, List<Integer> result) {
        if (null == root) {
            return;
        }
        mindOrderTraverse(root.leftChild, result);
        result.add(root.value);
        mindOrderTraverse(root.rightChild, result);
    }

    /**
     * 后序遍历
     *
     * @param root
     * @return
     */
    private static void postOrderTraverse(MyTree.TreeNode root, List<Integer> result) {
        if (null == root) {
            return;
        }
        postOrderTraverse(root.leftChild, result);
        postOrderTraverse(root.rightChild, result);
        result.add(root.value);
    }

    /**
     * 广度优先算法按层的纬度遍历二叉树
     *
     * @param root
     * @return 返回包含各层的集合，顺序就是层级的顺序
     */
    private static List<List<Integer>> levelReviews(MyTree.TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (null == root) {
            return result;
        }

        //定义用于按层级遍历的辅助队列
        Queue<MyTree.TreeNode> reviewQueue = new LinkedBlockingQueue<>();
        reviewQueue.add(root);
        //如果是图的遍历的话可以再定义一个访问过的Node集合用于排除重复访问的情况
        while (!reviewQueue.isEmpty()) {
            //用于存放当前层级节点
            List<Integer> currentLevel = new ArrayList<>();
            int queueSize = reviewQueue.size();
            // 将辅助队列中的node逐个取出进行遍历操作
            for (int i = 0; i < queueSize; i++) {
                MyTree.TreeNode currentNode = reviewQueue.poll();
                currentLevel.add(currentNode.value);
                //进行当前节点的左右节点操作,其实这也是在进行下一层的遍历，直到没有子节点的时候队列也空了那就是返回结果的时候
                if (null != currentNode.leftChild) {
                    reviewQueue.add(currentNode.leftChild);
                }
                if (null != currentNode.rightChild) {
                    reviewQueue.add(currentNode.rightChild);
                }
            }
            result.add(currentLevel);
        }
        return result;
    }

    /**
     * 使用深度优先算法进行树的分层遍历
     *
     * @param root
     * @return
     */
    private static List<List<Integer>> levelReviewsByDsp(MyTree.TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (null == root) {
            return result;
        }
        doLevelReviewsByDsp(root, 0, result);
        return result;

    }

    /**
     * 深度优先递归逻辑
     *
     * @param root
     * @param level
     * @return
     */
    private static void doLevelReviewsByDsp(MyTree.TreeNode root, Integer level, List<List<Integer>> result) {
        //如果当前层级深度还没有对应的内容集合说明之前还没遍历到这个深度，直接新建一个层级容器放入结果集中
        List<Integer> currentLevelContent;
        if (result.size() < level + 1) {
            currentLevelContent = new ArrayList<>();
            result.add(currentLevelContent);
        } else {
            currentLevelContent = result.get(level);
        }
        //采用递归的方式进行深度遍历
        currentLevelContent.add(root.value);
        if (null != root.leftChild) {
            doLevelReviewsByDsp(root.leftChild, level + 1, result);
        }
        if (null != root.rightChild) {
            doLevelReviewsByDsp(root.rightChild, level + 1, result);

        }

    }

    /**
     * 求出一棵树的最大深度
     *
     * @param root
     * @return
     */
    private static Integer maxDeep(MyTree.TreeNode root) {
        if (null == root) {
            return 0;
        }
        //递归求出左子树与右子树的最大深度取两者中大的那个返回，注意要加一
        return Math.max(maxDeep(root.leftChild), maxDeep(root.rightChild)) + 1;
    }

    /**
     * 求出一棵树的最小深度
     *
     * @param root
     * @return
     */
    private static Integer minDeep(MyTree.TreeNode root) {
        if (null == root) {
            return 0;
        }
        Integer leftChildMinDeep = minDeep(root.leftChild);
        Integer rightChildMinDeep = minDeep(root.leftChild);
        //递归求出左子树与右子树的最大深度取两者中小的那个返回，注意要加一
        return (0 == leftChildMinDeep || 0 == rightChildMinDeep) ? 1 + leftChildMinDeep + rightChildMinDeep : Math.min(leftChildMinDeep, rightChildMinDeep) + 1;

    }

    /**
     * 该方法用于生成指定个合法的括号组成的合法序列
     *
     * @param n
     * @return
     */
    private static List<String> generateKh(int n) {
        List<String> result = new ArrayList<>();
        if (n <= 0) {
            return Collections.emptyList();
        }
        doGenerateKh("", result, n, n);
        return result;
    }

    /**
     * 进行递归生成的逻辑
     *
     * @param currentResult 当前生成的结果
     * @param result        用于存放所有的结果
     * @param leftNum       剩余可用的左括号数量
     * @param rightNum      剩余可用的右括号数量
     */
    private static void doGenerateKh(String currentResult, List<String> result, int leftNum, int rightNum) {
        if (0 == leftNum && 0 == rightNum) {
            //说明所有括号都用完了，已经生成了响应的结果，保存结果跳出递归
            result.add(currentResult);
        }
        //只要还有左括号就可以进行递归
        if (leftNum > 0) {
            doGenerateKh(currentResult + "(", result, leftNum - 1, rightNum);

        }
        //这里加了一个rightNum > leftNum的原因是要保证左括号在前因为又括号在前的肯定是不合法的，所以进行相应的剪枝
        if (rightNum > leftNum) {
            doGenerateKh(currentResult + ")", result, leftNum, rightNum - 1);
        }

    }

}
