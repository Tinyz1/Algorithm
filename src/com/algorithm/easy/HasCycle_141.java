package com.algorithm.easy;

/**
 * Created by TangZz on 2018/10/23.
 * ����һ�������ж��������Ƿ��л���
 * <p>
 * ���ף�
 * ���ܷ�ʹ�ö���ռ������⣿
 */
public class HasCycle_141 {

    /**
     * ˫ָ��
     * ˼·
     * <p>
     * ����һ�£������˶�Ա�Բ�ͬ���ٶ��ڻ����������ܲ��ᷢ��ʲô��
     * <p>
     * �㷨
     * <p>
     * ͨ��ʹ�þ��� ��ͬ�ٶ� �Ŀ졢������ָ����������ռ临�Ӷȿ��Ա������� O(1)O(1)����ָ��ÿ���ƶ�һ��������ָ��ÿ���ƶ�������
     * <p>
     * ����б��в����ڻ������տ�ָ�뽫�����ȵ���β������ʱ���ǿ��Է��� false��
     * <p>
     * ���ڿ���һ��������������ָ��Ϳ�ָ������������ڻ����������ܲ����˶�Ա���ֱ��֮Ϊ������������ߣ���������������һ����׷�������ߡ�����Ϊʲô�أ������������������������� A�� - ���������ֻ���������һ��������һ�ε����У����Ǿͻ�ֱ�����һ����������������
     * <p>
     * ��������ֻ������أ����磬����û�п��ǿ�������������֮�����������������������ʵ�����뵽����Ϊ����һ�λ������´ε������ֻ��������ᵽ����� A
     */

    public boolean hasCyclePre(ListNode head) {
        if(head == null) return false;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                return true;
        }
        return false;
    }

    public boolean hasCycle(ListNode head) {
        if (null == head || null == head.next) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    public boolean hasCycleZz(ListNode head) {
        if (null == head || null == head.next) {
            return false;
        }
        return run(head.next,head.next.next);
    }

    public boolean run(ListNode slow, ListNode fast) {
        if (slow == fast) {
            return true;
        } else {
            if (null == fast || null == fast.next) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
            return run(slow, fast);
        }
    }


    public static void main(String[] args) {

    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
