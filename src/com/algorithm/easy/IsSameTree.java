package com.algorithm.easy;

/**
 * Created by TangZz on 2018/8/20.
 * <p>
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 * <p>
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * 1         1
 * / \       / \
 * 2   3     2   3
 * <p>
 * [1,2,3],   [1,2,3]
 * <p>
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:
 * 1          1
 * /           \
 * 2             2
 * <p>
 * [1,2],     [1,null,2]
 * <p>
 * 输出: false
 * 示例 3:
 * <p>
 * 输入:
 * 1         1
 * / \       / \
 * 2   1     1   2
 * <p>
 * [1,2,1],   [1,1,2]
 * <p>
 * 输出: false
 */
public class IsSameTree {

    /**
     * 最优代码分析
     * 判断是否都为null，都为null则是true，有一个不是null则为false
     * 判断是否相等，相等就递归，不想等就返回false
     */
    public boolean isSameTreePre(TreeNode p, TreeNode q) {
        if (q == null && p == null)
            return true;
        else if (q == null)
            return false;
        else if (p == null)
            return false;
        if (p.val == q.val) {
            return isSameTreePre(p.left, q.left) && isSameTreePre(p.right, q.right);
        }
        return false;
    }


    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (null == p && null == q) {
            return true;
        }
        if ((null != p && null == q) || (null == p && null != q) || (p.val != q.val)) {
            return false;
        }
        boolean flag = false;
        if (p.val == q.val) {
            flag = true;
        }
        if (null != p.left || null != q.left) {
            flag = flag && isSameTree(p.left, q.left);
        }
        if (null != p.right || null != q.right) {
            flag = flag && isSameTree(p.right, q.right);
        }
        return flag;
    }


    public static void main(String[] args) {
        new IsSameTree().test();
    }

    public void test() {

        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(3);
        p.right = null;

        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(3);
        q.right = null;
        q.left.right = new TreeNode(1);


        System.out.println(new IsSameTree().isSameTree(p, q));
    }


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

}