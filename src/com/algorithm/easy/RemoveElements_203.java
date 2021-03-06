package com.algorithm.easy;

/**
 * @Author: zhaozw
 * @Description:
 * @Date: Create in 13:42 2020/11/16
 * <p>
 * <p>
 * ɾ�������е��ڸ���ֵ val �����нڵ㡣
 * <p>
 * ʾ��:
 * <p>
 * ����: 1->2->6->3->4->5->6, val = 6
 * ���: 1->2->3->4->5
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
        ��������ʹ��
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

    //�Ż�˼·
    public ListNode removeElementsPre(ListNode head, int val) {
        if (null == head) {
            return null;
        } else {
            ListNode deal = new ListNode(0);
            deal.next = head;
            ListNode result = deal;
            while (head != null) { // ֱ���жϵ�ǰ�����ֵ�Ƿ�һ��
                if (head.val == val) {  //�����ȣ������������һ������head����һ�����жϵ�һ���ڵ��Ƿ�����ͬ��ֵ���������������ǣ���ֵ��
                    deal.next = head.next;
                } else {
                    deal = head;//�������ȣ������������head
                }
                head = head.next;//ȡ��һ��ֵ
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
