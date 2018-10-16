package com.algorithm.easy;

/**
 * Created by TangZz on 2018/10/16.
 * <p>
 * ����һ����������һ��Ŀ��ͣ��жϸ������Ƿ���ڸ��ڵ㵽Ҷ�ӽڵ��·��������·�������нڵ�ֵ��ӵ���Ŀ��͡�
 * <p>
 * ˵��: Ҷ�ӽڵ���ָû���ӽڵ�Ľڵ㡣
 * <p>
 * ʾ��:
 * �������¶��������Լ�Ŀ��� sum = 22��
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \      \
 * 7    2      1
 * ���� true, ��Ϊ����Ŀ���Ϊ 22 �ĸ��ڵ㵽Ҷ�ӽڵ��·�� 5->4->11->2
 */
public class HasPathSum {


    /**
     * ���д������
     * ����˼·һ�£�����ֻҪ�ж���һ����֧ʵ�־����������������ֻҪ�����ж������������������ж������������ˣ�
     * û��Ҫ�ж�2�����������Ľ��
     * ���߾��ǰ� || ��Ϊ |  |���ǰ����TRUE�Ͳ����жϺ����������
     */
    public boolean hasPathSumPre(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.val == sum && root.left == null && root.right == null) return true;
        if (hasPathSumPre(root.left, sum - root.val)) {
            return true;
        }
        if (hasPathSumPre(root.right, sum - root.val)) {
            return true;
        }
        return false;
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (null == root) {
            return false;
        }
        if (null == root.left && null == root.right && root.val == sum) {
            return true;
        }
        sum = sum - root.val;
        return hasPathSum(root.left, sum) | hasPathSum(root.right, sum); // ԭ����  return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }


    public static void main(String[] args) {
        new HasPathSum().test();
    }

    public void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.right = new TreeNode(1);

//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
        System.out.println(this.hasPathSum(root, 22));

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
