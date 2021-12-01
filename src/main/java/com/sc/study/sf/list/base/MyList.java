package com.sc.study.sf.list.base;

/**
 * @author yingqi
 * @version 1.0
 * @date 2020-12-27 13:22
 * @desc
 */
public class MyList<T> {

    /**
     * 链表头指针
     */
    private MyNode<T> head;

    /**
     * 尾指针
     */
    private MyNode<T> tail;

    /**
     * 链表大小
     */
    private int size;

    /**
     * 获取头指针
     *
     * @return
     */
    public MyNode<T> getHead() {
        return head;
    }

    /**
     * 获取头指针
     *
     * @return
     */
    public MyNode<T> setHead(MyNode<T> head) {
        return this.head = head;
    }

    /**
     * 添加节点
     *
     * @param node
     */
    public void add(MyNode<T> node) {
        if (null == head) {
            head = node;
            tail = node;

        } else {
            tail.next = node;
            tail = node;

        }
        size++;

    }

    public void showList() {
        if (null == head) {
            return;
        }
        MyNode reset = head;
        StringBuilder sb = new StringBuilder();
        sb.append(head.date);
        while (head.next != null) {
            sb.append("->")
                    .append(head.next.date);
            head = head.next;
        }
        System.out.println(sb.toString());
        head = reset;
    }

    public static class MyNode<T> {

        /**
         * 节点数据
         */
       public T date;

        /**
         * 后继节点
         */
       public MyNode<T> next;

        public MyNode(T date) {
            this.date = date;
        }

        public MyNode(T date, MyNode<T> next) {
            this.date = date;
            this.next = next;
        }


    }

    public static void main(String[] args) {
        MyList<Integer> list = new MyList<>();
        list.add(new MyNode<Integer>(1));
        list.add(new MyNode<>(2));
        list.add(new MyNode<>(3));
        list.add(new MyNode<>(4));
        list.add(new MyNode<>(5));
        list.showList();
    }

}
