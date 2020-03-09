package com.algorithm.easy;

/**
 * Created by TangZz on 2018/10/25.
 * <p>
 * 编写一个程序，找到两个单链表相交的起始节点。
 * <p>
 * <p>
 * <p>
 * 例如，下面的两个链表：
 * <p>
 * A:___________a1 → a2
 * ______________________↘
 * ________________________c1 → c2 → c3
 * ______________________↗
 * B:_____b1 → b2 → b3
 * 在节点 c1 开始相交。
 * <p>
 * <p>
 * <p>
 * 注意：
 * <p>
 * 如果两个链表没有交点，返回 null.
 * 在返回结果后，两个链表仍须保持原有的结构。
 * 可假定整个链表结构中没有循环。
 * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 */
public class GetIntersectionNode_160 {


    //1.不能通过链表取反去判断，这样链表就会有问题，只能使用当前链表
    //2.将链表头尾关联,判断链表中是否有环形链表，有环形的，则表示有相交的节点；
    //3.获取环开始的位置，就是需要返回的节点

    /**
     * 方法三：双指针法
     * 创建两个指针 pA 和 pB，分别初始化为链表 A 和 B 的头结点。然后让它们向后逐结点遍历。
     * 当 pA 到达链表的尾部时，将它重定位到链表 B 的头结点 (你没看错，就是链表 B); 类似的，当 pB 到达链表的尾部时，将它重定位到链表 A 的头结点。
     * 若在某一时刻 pA 和 pB 相遇，则 pA/pB 为相交结点。
     * 想弄清楚为什么这样可行, 可以考虑以下两个链表: A={1,3,5,7,9,11} 和 B={2,4,9,11}，相交于结点 9。 由于 B.length (=4) < A.length (=6)，pB 比 pA 少经过 22 个结点，会先到达尾部。将 pB 重定向到 A 的头结点，pA 重定向到 B 的头结点后，pB 要比 pA 多走 2 个结点。因此，它们会同时到达交点。
     * 如果两个链表存在相交，它们末尾的结点必然相同。因此当 pA/pB 到达链表结尾时，记录下链表 A/B 对应的元素。若最后元素不相同，则两个链表不相交。
     * 复杂度分析
     * <p>
     * 时间复杂度 : O(m+n)O(m+n)。
     * 空间复杂度 : O(1)O(1)。
     * <p>
     */

    /**
     * A+B  和  B+A 比较   数量一致，每次都找下一个，最后一样的就是相同的交点
     * 最后相同的就是交点
     *
     * */




    //执行效率最优解
    public ListNode getIntersectionNodeFast(ListNode headA, ListNode headB) {
        ListNode l1 = headA, l2 = headB;
        while (l1 != l2) {
            l1 = (l1 == null) ? headB : l1.next;
            l2 = (l2 == null) ? headA : l2.next;
        }
        return l1;
    }

    //消耗内存最小
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