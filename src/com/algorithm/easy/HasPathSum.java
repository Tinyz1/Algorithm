package com.algorithm.easy;

/**
 * Created by TangZz on 2018/10/16.
 * <p>
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \      \
 * 7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2
 */
public class HasPathSum {


    /**
     * 最有代码分析
     * 总体思路一致，由于只要判断有一个分支实现就算符合条件，所以只要优先判断左子树，或者优先判断右子树就行了，
     * 没必要判断2个子树拿最后的结果
     * 或者就是把 || 改为 |  |如果前面是TRUE就不会判断后面的条件了
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
        return hasPathSum(root.left, sum) | hasPathSum(root.right, sum); // 原来是  return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
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
