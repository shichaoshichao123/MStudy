package com.sc.study.sf.list;

import com.sc.study.sf.list.base.MyList;

/**
 * @author yingqi
 * @version 1.0
 * @date 2020-12-27 13:20
 * @desc 进行链表的反转：
 * 1->2->3->4->5 ---》 5->4->3->2->1
 */
public class FZ {

    public static void main(String[] args) {
        MyList<Integer> list = new MyList<>();
        list.add(new MyList.MyNode<>(1));
        list.add(new MyList.MyNode<>(2));
        list.add(new MyList.MyNode<>(3));
        list.add(new MyList.MyNode<>(4));
        list.add(new MyList.MyNode<>(5));
        System.out.println("------链表----");
        System.out.println("判断是否存在环链的结果:" + isCycle(list));

    }


    /**
     * 进行反转操作
     *
     * @param list
     */
    private static void reverse(MyList<Integer> list) {
        MyList.MyNode head;
        if (null != list && null != (head = list.getHead())) {
            //记录当前操作的节点
            MyList.MyNode current = head;
            //记录当前操作节点的前一个节点，由于是从头节点开始的所以开始为null
            MyList.MyNode pre = null;
            while (current != null) {
                //记录下当前操作节点的后一个节点
                MyList.MyNode originNext = current.next;
                //将当前操作节点的下一个节点反转为它的前一个节点
                current.next = pre;
                //将当前节点设置成前一个节点用于下一个操作节点使用
                pre = current;
                //当前指针向下遍历
                current = originNext;
            }
            //将之前的最后一个节点设置成当前链表的头节点，反转完成
            list.setHead(pre);

        }
    }

    /**
     * 进行是否存在环链的判断
     *
     * @param list
     * @return
     */
    private static boolean isCycle(MyList<Integer> list) {
        MyList.MyNode head;
        if (null != list && null != (head = list.getHead())) {
            MyList.MyNode quick = head;
            MyList.MyNode slow = head;
            while (quick != null && null != quick.next && null != slow) {
                quick = quick.next.next;
                slow = slow.next;
                if (quick == slow) {
                    return true;
                }

            }


        }
        return false;

    }
}
