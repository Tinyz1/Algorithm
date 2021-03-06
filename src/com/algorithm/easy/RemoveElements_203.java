package com.algorithm.easy;

/**
 * @Author: zhaozw
 * @Description:
 * @Date: Create in 13:42 2020/11/16
 * <p>
 * <p>
 * 删除链表中等于给定值 val 的所有节点。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 * <p>
 * 1->2->6->3->4->5->6
 * 1->2->6->3->4->5->6
 * 1->2->6->3->4->5->6
 */
public class RemoveElements_203 {
    public static void main(String[] args) {
        new RemoveElements_203().test();

    }

    public void test() {
        ListNode headC = new ListNode(1);
        headC.next = new ListNode(1);

        ListNode result = removeElementsPre(headC, 1);
        System.out.println( null != result ? result.toString() : "null");
        headC.next = new ListNode(2);
        headC.next.next = new ListNode(6);
        headC.next.next.next = new ListNode(3);
        headC.next.next.next.next = new ListNode(4);
        headC.next.next.next.next.next = new ListNode(5);
        headC.next.next.next.next.next.next = new ListNode(6);
        ListNode headA = new ListNode(6);
        headA.next = headC;
        System.out.println(removeElementsPre(headA, 6).toString());
    }

    /*
        操作链表使用
     */
    public ListNode removeElements(ListNode head, int val) {
        if (null == head) {
            return null;
        } else {
            ListNode deal = new ListNode(0);
            deal.next = head;
            ListNode result = deal;
            while (deal != null) {
                if (null != deal.next && val == deal.next.val) {
                    deal.next = deal.next.next;
                } else {
                    deal = deal.next;
                }
            }
            return result.next;
        }
    }

    //优化思路
    public ListNode removeElementsPre(ListNode head, int val) {
        if (null == head) {
            return null;
        } else {
            ListNode deal = new ListNode(0);
            deal.next = head;
            ListNode result = deal;
            while (head != null) { // 直接判断当前链表的值是否一致
                if (head.val == val) {  //如果相等，则处理链表的下一个就是head的下一个；判断第一个节点是否是相同的值，是则跳过；不是，则赋值；
                    deal.next = head.next;
                } else {
                    deal = head;//如果不相等，则处理链表就是head
                }
                head = head.next;//取下一个值
            }
            return result.next;
        }
    }



    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return val + "," + (null != next ? next.toString() : "");
        }
    }

}
