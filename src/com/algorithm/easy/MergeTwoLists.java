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
     * ��������������ϲ�Ϊһ���µ������������ء���������ͨ��ƴ�Ӹ�����������������нڵ���ɵġ�
     * <p>
     * ʾ����
     * <p>
     * ���룺1->2->4, 1->3->4
     * �����1->1->2->3->4->4
     */


    /**
     * ���Ŵ������
     * 1. ���ж��Ƿ���1����������Ϊnull,�������ֱ�ӷ�������һ����������
     * 2. ����4������ head�û���ŵ�һ��Ԫ�أ��жϵ�һ��Ԫ������l1������l2
     * 3. ѭ���ж�l1��l2�Ƿ�Ϊ�գ��ж�ֵ����С�ĸ�ֵ����Ҫ���������
     * 4. �ж�l2��l2������Ϊ�յ�ʱ��ѭ����ֵ
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