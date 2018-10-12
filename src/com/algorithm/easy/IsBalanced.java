package com.algorithm.easy;

/**
 * Created by TangZz on 2018/10/12.
 * <p>
 * ����һ�����������ж����Ƿ��Ǹ߶�ƽ��Ķ�������
 * <p>
 * �����У�һ�ø߶�ƽ�����������Ϊ��
 * <p>
 * һ��������ÿ���ڵ� ���������������ĸ߶Ȳ�ľ���ֵ������1��
 * <p>
 * ʾ�� 1:
 * <p>
 * ���������� [3,9,20,null,null,15,7]
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * ���� true ��
 * <p>
 * ʾ�� 2:
 * <p>
 * ���������� [1,2,2,3,3,null,null,4,4]
 * <p>
 * 1
 * / \
 * 2   2
 * / \
 * 3   3
 * / \
 * 4   4
 * ���� false ��
 */
public class IsBalanced {

    /**
     * ���Ŵ������
     * 1.˼·һ�£��ڻ�ȡ�����������ȵ�ʱ���ж��Ƿ���ƽ�������
     * 2.ͨ��˽��ȫ�ֱ����ڻ�ȡ�����
     * 3.���������жϵ�һ��Ϊ��ƽ�������ʱ�жϵݹ鷵�ؽ��
     */

    private boolean balacned = true;
    public int height(TreeNode root)
    {
        if(root == null)return 0;
        int left = height(root.left);
        int right = height(root.right);
        balacned = balacned && (Math.abs(left - right) <=1);
        return 1 + Math.max(left, right);
    }
    public boolean isBalancedPre(TreeNode root)
    {
        if(root == null)return true;
        height(root);
        return balacned;
    }


    public boolean isBalanced(TreeNode root) {
        if (null == root) {
            return true;
        }
        if (isBalancedNum(root) < 0) {
            return false;
        }
        return true;
    }

    public int isBalancedNum(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int maxLeft = isBalancedNum(root.left);
            int maxRight = isBalancedNum(root.right);
            if (maxLeft < 0 || maxRight < 0 || maxLeft - maxRight > 1 || maxRight - maxLeft > 1) {
                return -1;
            }
            return Math.max(maxLeft, maxRight) + 1;
        }
    }

    public static void main(String[] args) {
        new IsBalanced().test();
    }

    public void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
//        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(4);
        root.right.left.left = new TreeNode(6);
        System.out.println(isBalanced(root));
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
