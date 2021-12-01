package com.sc.study.jiuzhang.tree;

import java.util.Stack;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/11/25 8:56 下午
 * @desc
 */
public class BstIteratorDemo1 {
    private Stack<TwoCha.Node> stack;

    public BstIteratorDemo1(TwoCha.Node currentNode) {
        this.stack = new Stack<>();
        //构建从指定节点开始的最左节点栈
        pushMostLeftNode(currentNode);
    }

    /**
     * 将指定节点开始到最左子节点的路径入栈
     *
     * @param currentNode
     */
    private void pushMostLeftNode(TwoCha.Node currentNode) {
        while (null != currentNode) {
            stack.push(currentNode);
            currentNode = currentNode.left;
        }
    }

    public boolean hashNext() {
        return !stack.isEmpty();
    }


    /**
     * 得到下一个节点不能进行回索
     *
     * @return
     */
    public TwoCha.Node next() {
        TwoCha.Node currentNode = stack.pop();
        if (currentNode.right != null) {
            pushMostLeftNode(currentNode.right);
        }
        return currentNode;
    }

    /**
     * 能进行回溯哦的方式
     *
     * @return
     */
    public TwoCha.Node nextV2() {
        //先拿到栈顶元素，不出栈
        TwoCha.Node currentNode = stack.peek();
        TwoCha.Node node = currentNode;
        if (node.right != null) {
            //有右子节点的情况,先不对该节点进行出栈，而是对其右子树进行最左入栈
            node = node.right;
            pushMostLeftNode(node);
        } else {
            //没有右子节点的情况说明直接已经是出栈序列了直接弹出
            node = stack.pop();
            //循环遍历只要遇到栈顶元素的右子节点是当前节点就继续弹出，因为顺序上右子节点的遍历顺序要在跟节点之后，并且被弹出的跟节点其实在之前if条件下已经返回过了，所以不寻找遍历节点丢失的情况
            while (!stack.isEmpty() && stack.peek().right == node) {
                node = stack.pop();
            }
        }
        return currentNode;
    }

}
