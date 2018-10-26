package com.algorithm.easy;

/**
 * Created by TangZz on 2018/10/25.
 * <p>
 * ��дһ�������ҵ������������ཻ����ʼ�ڵ㡣
 * <p>
 * <p>
 * <p>
 * ���磬�������������
 * <p>
 * A:          a1 �� a2
 * �K
 * c1 �� c2 �� c3
 * �J
 * B:     b1 �� b2 �� b3
 * �ڽڵ� c1 ��ʼ�ཻ��
 * <p>
 * <p>
 * <p>
 * ע�⣺
 * <p>
 * �����������û�н��㣬���� null.
 * �ڷ��ؽ���������������뱣��ԭ�еĽṹ��
 * �ɼٶ���������ṹ��û��ѭ����
 * ���������� O(n) ʱ�临�Ӷȣ��ҽ��� O(1) �ڴ档
 */
public class GetIntersectionNode_160 {


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (null == headA || null == headB) {
            return null;
        }
        ListNode headC = null;
        while (null != headA && null != headB) {
            while (null != headA) {
                if( headA == headB){
                    return headA;
                }
            }
        }

        if (headA == headB) {
            return headA;
        }
        return getIntersectionNode(headA.next, headB);
    }

    public static void main(String[] args) {

    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}