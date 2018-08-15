package com.algorithm.easy;

/**
 * Created by TangZz on 2018/8/15.
 * <p>
 * ����һ����������ɾ�������ظ���Ԫ�أ�ʹ��ÿ��Ԫ��ֻ����һ�Ρ�
 * <p>
 * ʾ�� 1:
 * <p>
 * ����: 1->1->2
 * ���: 1->2
 * ʾ�� 2:
 * <p>
 * ����: 1->1->2->3->3
 * ���: 1->2->3
 */
public class DeleteDuplicates {


    /**
     * ���Ŵ������
     */
    public ListNode deleteDuplicatesPre(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode pre = head;
        ListNode next = head.next;
        int value = head.val;
        while(next!= null){
            if(value != next.val){
                value = next.val;
                pre.next = next;
                pre = next;
                next = next.next;
            }else{
                next = next.next;
            }
        }
        pre.next = null;
        return head;
    }

    public ListNode deleteDuplicates(ListNode head) {
        if( null == head){
            return null;
        }
        ListNode delList = new ListNode(head.val);
        ListNode result = delList;
        int value = head.val;
        while( null != head){
            if(value == head.val){
                head = head.next;
                delList.next = null;
            }else{
                value = head.val;
                delList.next = head;
                delList = delList.next;
                head = head.next;
            }
        }
        return result;
    }

    public static void main(String[] args) {
       new DeleteDuplicates().test();
    }
    public void test(){
        ListNode list = new ListNode(1);
        ListNode pre = list;
        list.next  = new ListNode(1);
        list = list.next;
        list.next = new ListNode(2);
        list = list.next;
        list.next  = new ListNode(3);
        list = list.next;
        list.next  = new ListNode(3);
        list = list.next;
        list.next  = new ListNode(4);
//        list = list.next;
//        list.next  = new ListNode(5);
        ListNode val = pre;
        while ( null != pre){
            System.out.print(pre.val+"-->");
            pre = pre.next;
        }
        System.out.println("");
        System.out.println("------------");
        ListNode result = new DeleteDuplicates().deleteDuplicates(val);
        while ( null != result){
            System.out.print(result.val+"-->");
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

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
}
