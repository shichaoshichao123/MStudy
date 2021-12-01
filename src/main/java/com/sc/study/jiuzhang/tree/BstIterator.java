package com.sc.study.jiuzhang.tree;

import java.util.Stack;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/11/23 8:20 下午
 * @desc 二叉树迭代器
 */
public class BstIterator {

    private Stack<TwoCha.Node> stack;

    public BstIterator(TwoCha.Node node) {
        this.stack = new Stack<>();
        getMostLeft(node);
    }

    /**
     * 获取一某个节点为根结点的到达最左节点的路径并入栈
     */
    private void getMostLeft(TwoCha.Node node) {
        while (null != node) {
            stack.push(node);
            node = node.left;
        }
    }

    public boolean hashNext() {
        return !stack.isEmpty();
    }

    /**
     * 中序迭代
     *
     * @return
     */
    public TwoCha.Node next() {
        TwoCha.Node current = stack.pop();
        //又子数不为空直接进行又子数的最左节点路径入栈
        if (null != current.right) {
            getMostLeft(current.right);
        }
        return current;
    }

    /**
     * 保留前后完整路径的迭代方式
     *
     * @return
     */
    public TwoCha.Node nextV2() {
        TwoCha.Node current = stack.peek();
        TwoCha.Node node = current;
        if (node.right == null) {
            //出栈当前栈顶元素
            node = stack.pop();
            //由于是中顺遍历所以如果出现stack.peek().right == node 说明当前栈顶元素是前一个节点的跟节点需要先进行遍历
            while (!stack.isEmpty() && stack.peek().right == node) {
                node = stack.pop();
            }
        } else {
            node = node.right;
            //进行左左路径入栈
            getMostLeft(node);
        }
        return current;
    }
}

