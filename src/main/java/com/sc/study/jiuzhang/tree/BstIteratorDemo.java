package com.sc.study.jiuzhang.tree;

import java.util.Stack;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/11/25 8:56 下午
 * @desc
 */
public class BstIteratorDemo {
    private Stack<TwoCha.Node> stack;

    public BstIteratorDemo(TwoCha.Node currentNode) {
        this.stack = new Stack<>();
        //构建从指定节点开始的最左节点栈
        pushMostLeftNode(currentNode);
    }

    private void pushMostLeftNode(TwoCha.Node currentNode) {
        while (null != currentNode) {
            stack.push(currentNode);
            currentNode = currentNode.left;
        }
    }

    public boolean hashNext() {
        return !stack.isEmpty();
    }

    public TwoCha.Node next() {
        TwoCha.Node current = stack.pop();
        if (current.right != null) {
            //对right子节点进行最左节点路径入栈
            pushMostLeftNode(current.right);
        }
        return current;
    }

    public TwoCha.Node nextV2() {
        //先感知栈定元素，暂时不出栈
        TwoCha.Node current = stack.peek();
        TwoCha.Node node = current;
        //判断是否有右子节点
        if (null != node.right) {
            //有右子节点，则先不出栈先对又子节点左路径入栈
            node = node.right;
            pushMostLeftNode(node);
        } else {
            //没有又子节点说明已经是当前顺序了，才需要做出栈操作
            node = stack.pop();
            while (!stack.isEmpty() && stack.peek().right == node) {
                node = stack.pop();
            }
        }
        return current;
    }

}
