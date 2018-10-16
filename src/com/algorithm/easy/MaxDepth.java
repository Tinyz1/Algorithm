package com.algorithm.easy;

/**
 * ����һ�����������ҳ��������ȡ�
 * <p>
 * �����������Ϊ���ڵ㵽��ԶҶ�ӽڵ���·���ϵĽڵ�����
 * <p>
 * ˵��: Ҷ�ӽڵ���ָû���ӽڵ�Ľڵ㡣
 * <p>
 * ʾ����
 * ���������� [3,9,20,null,null,15,7]��
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * �������������� 3 ��
 */
public class MaxDepth {

    public int maxDepthPre(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int maxLeft = maxDepthPre(root.left);
            int maxRight = maxDepthPre(root.right);
            return Math.max(maxLeft, maxRight) + 1;
        }
    }


    public int maxDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int max = 0;
        if (null != root) {
            max = 1;
        }
        if (null != root.left || null != root.right) {
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            max = max + (left >= right ? left : right);
        }
        return max;
    }


    public static void main(String[] args) {
        new MaxDepth().test();
    }

    public void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(4);
        System.out.println(maxDepth(root));
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}