package com.algorithm.easy;

/**
 * Created by TangZz on 2018/10/12.
 * <p>
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * <p>
 * 本题中，一棵高度平衡二叉树定义为：
 * <p>
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 * <p>
 * 示例 1:
 * <p>
 * 给定二叉树 [3,9,20,null,null,15,7]
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回 true 。
 * <p>
 * 示例 2:
 * <p>
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 * <p>
 * 1
 * / \
 * 2   2
 * / \
 * 3   3
 * / \
 * 4   4
 * 返回 false 。
 */
public class IsBalanced {

    /**
     * 最优代码分析
     * 1.思路一致，在获取二叉树最大深度的时候判断是否是平衡二叉树
     * 2.通过私有全局变量在获取最后结果
     * 3.都不能在判断第一次为非平衡二叉树时中断递归返回结果
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
