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
 * A:___________a1 �� a2
 * ______________________�K
 * ________________________c1 �� c2 �� c3
 * ______________________�J
 * B:_____b1 �� b2 �� b3
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


    //1.����ͨ������ȡ��ȥ�жϣ���������ͻ������⣬ֻ��ʹ�õ�ǰ����
    //2.������ͷβ����,�ж��������Ƿ��л��������л��εģ����ʾ���ཻ�Ľڵ㣻
    //3.��ȡ����ʼ��λ�ã�������Ҫ���صĽڵ�

    /**
     * ��������˫ָ�뷨
     * ��������ָ�� pA �� pB���ֱ��ʼ��Ϊ���� A �� B ��ͷ��㡣Ȼ��������������������
     * �� pA ���������β��ʱ�������ض�λ������ B ��ͷ��� (��û������������ B); ���Ƶģ��� pB ���������β��ʱ�������ض�λ������ A ��ͷ��㡣
     * ����ĳһʱ�� pA �� pB �������� pA/pB Ϊ�ཻ��㡣
     * ��Ū���Ϊʲô��������, ���Կ���������������: A={1,3,5,7,9,11} �� B={2,4,9,11}���ཻ�ڽ�� 9�� ���� B.length (=4) < A.length (=6)��pB �� pA �پ��� 22 ����㣬���ȵ���β������ pB �ض��� A ��ͷ��㣬pA �ض��� B ��ͷ����pB Ҫ�� pA ���� 2 ����㡣��ˣ����ǻ�ͬʱ���ｻ�㡣
     * ���������������ཻ������ĩβ�Ľ���Ȼ��ͬ����˵� pA/pB ���������βʱ����¼������ A/B ��Ӧ��Ԫ�ء������Ԫ�ز���ͬ�������������ཻ��
     * ���Ӷȷ���
     * <p>
     * ʱ�临�Ӷ� : O(m+n)O(m+n)��
     * �ռ临�Ӷ� : O(1)O(1)��
     * <p>
     */

    /**
     * A+B  ��  B+A �Ƚ�   ����һ�£�ÿ�ζ�����һ�������һ���ľ�����ͬ�Ľ���
     * �����ͬ�ľ��ǽ���
     *
     * */




    //ִ��Ч�����Ž�
    public ListNode getIntersectionNodeFast(ListNode headA, ListNode headB) {
        ListNode l1 = headA, l2 = headB;
        while (l1 != l2) {
            l1 = (l1 == null) ? headB : l1.next;
            l2 = (l2 == null) ? headA : l2.next;
        }
        return l1;
    }

    //�����ڴ���С
    public ListNode getIntersectionNodeMin(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        if (headA == headB) {
            return headA;
        }
        ListNode pa = headA;
        ListNode pb = headB;
        while (pa != pb) {
            pa = pa.next;
            pb = pb.next;
            if (pa == null && pb == null) {
                return null;
            }
            if (pa == null) {
                pa = headB;
            }
            if (pb == null) {
                pb = headA;
            }
        }
        return pa;
    }


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (null == headA || null == headB) {
            return null;
        }
        if (headA == headB) {
            return headA;
        }
        ListNode headC = getIntersectionNodeReal(headA, headB.next);
        if (null == headC) {
            return getIntersectionNode(headA.next, headB);
        } else {
            return headC;
        }
    }

    public ListNode getIntersectionNodeReal(ListNode headA, ListNode headB) {
        if (null == headA || null == headB) {
            return null;
        }
        if (headA == headB) {
            return headA;
        }
        return getIntersectionNodeReal(headA, headB.next);
    }


    public static void main(String[] args) {
        new GetIntersectionNode_160().Test();
    }

    public void Test() {
        ListNode headC = new ListNode(8);
        headC.next = new ListNode(4);
        headC.next.next = new ListNode(5);

        ListNode headA = new ListNode(4);  //listA = [4,1,8,4,5]
        headA.next = new ListNode(1);
        headA.next.next = headC;

        ListNode headB = new ListNode(5);  //listB = [5,0,1,8,4,5]
        headB.next = new ListNode(0);
        headB.next.next = new ListNode(1);
        headB.next.next.next = headC;

        System.out.println(getIntersectionNode(headA, headB));

/*        ListNode headD1 = new ListNode(1);
        headD1.next = new ListNode(2);
        headD1.next.next = new ListNode(3);
        headD1.next.next.next = new ListNode(4);
        headD1.next.next.next.next = new ListNode(5);
        headD1.next.next.next.next.next = new ListNode(6);
        headD1.next.next.next.next.next.next = headD1;
        System.out.println(headD1 == headD1.next);*/
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

        @Override
        public String toString() {
            return val + "," + (null != next ? next.toString() : "");
        }
    }

}