package com.algorithm.easy;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class MergeTwoLists {

    /**
     * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     * <p>
     * 示例：
     * <p>
     * 输入：1->2->4, 1->3->4
     * 输出：1->1->2->3->4->4
     */


    /**
     * 最优代码分析
     * 1. 先判断是否有1个有序链表为null,如果有则直接返回另外一个有序链表
     * 2. 声明4个变量 head用户存放第一个元素，判断第一个元素是在l1还是在l2
     * 3. 循环判断l1和l2是否为空，判断值，把小的赋值给需要输出的链表
     * 4. 判断l2和l2单独不为空的时候，循环赋值
     */
    public ListNode mergeTwoListsPre(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode head = null, index = null, current1 = l1, current2 = l2;
        if (current1.val <= current2.val) {
            head = index = current1;
            current1 = current1.next;
        } else {
            head = index = current2;
            current2 = current2.next;
        }
        while (current1 != null && current2 != null) {
            if (current1.val <= current2.val) {
                index = index.next = current1;
                current1 = current1.next;
            } else {
                index = index.next = current2;
                current2 = current2.next;
            }
        }
        while (current1 != null) {
            index = index.next = current1;
            current1 = current1.next;
        }
        while (current2 != null) {
            index = index.next = current2;
            current2 = current2.next;
        }
        return head;
    }


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = null;
        if (null != l1 && null != l2) {
            if (l1.val <= l2.val) {
                result = l1;
                result.next = mergeTwoLists(l1.next, l2);
            } else {
                result = l2;
                result.next = mergeTwoLists(l1, l2.next);
            }
        } else if (null != l2) {
            result = l2;
        } else {
            result = l1;
        }
        return result;
    }


    public static void main(String[] args) {
        new MergeTwoLists().test();
    }

    public void test() {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(3);
//        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode result = mergeTwoLists(l1, null);
        System.out.println(result);
        while (null != result) {
            System.out.print(result.val + "->");
            result = result.next;
        }
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


}