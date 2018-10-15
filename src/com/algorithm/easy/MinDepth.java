package com.algorithm.easy;

/**
 * Created by TangZz on 2018/10/15.
 * <p>
 * 给定一个二叉树，找出其最小深度。
 * <p>
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * <p>
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最小深度  2.
 */
public class MinDepth {


    /**
     * 最优代码分析
     * 1.如果左子树为空，则读取右子树的最小深度
     * 2.如果右子树为空，则读取左子树的最小深度
     * 3.如果都不为空，则取左右子树中较小的深度
     */

    public int minDepthPre(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null)
            return minDepthPre(root.right) + 1;
        if (root.right == null)
            return minDepthPre(root.left) + 1;
        return Math.min(minDepthPre(root.left), minDepthPre(root.right)) + 1;
    }


    public int minDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);
        if (leftDepth == 0 && rightDepth == 0) {
            return 1;
        } else if (leftDepth == 0) {
            return rightDepth + 1;
        } else if (rightDepth == 0) {
            return leftDepth + 1;
        } else {
            return Math.min(leftDepth, rightDepth) + 1;
        }
    }

    public static void main(String[] args) {
        new MinDepth().test();
    }

    public void test() {
        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
////        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(5);
//        root.right.left = new TreeNode(6);
//        root.right.right = new TreeNode(7);
        System.out.println(minDepth(root));

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
