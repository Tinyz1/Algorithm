package com.algorithm.easy;


/**
 * Created by TangZz on 2018/8/22
 * *给定一个二叉树，检查它是否是镜像对称的。
 * <p>
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * <p>
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * <p>
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 * 说明:
 * <p>
 * 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。.
 */
public class IsSymmetric {


    /**
     * 最优代码分析
     * 1.利用递归，找到基本条件就是 如果都是空，则相等
     * 2.有一个不为空则不想等
     * 3.都不为空，则比较值，并递归孩子节点
     */
    public boolean isSymmetricPre(TreeNode root) {
        return isMirror(root, root);
    }

    boolean isMirror(TreeNode tree1, TreeNode tree2) {
        if (tree1 == null && tree2 == null) {
            return true;
        }
        if (tree1 == null || tree2 == null) {
            return false;
        }
        return tree1.val == tree2.val && isMirror(tree1.left, tree2.right) && isMirror(tree1.right, tree2.left);
    }


    public boolean isSymmetric(TreeNode root) {
        if (null == root) {
            return true;
        }
        return isSame(root.left, root.right);
    }

    public boolean isSame(TreeNode left, TreeNode right) {
        if (null == left && null == right) {
            return true;
        }
        if ((null == left && null != right) || (null != left && null == right) || (left.val != right.val)) {
            return false;
        }
        if (null != left.left || null != right.right || null != left.right || null != right.left) {
            return isSame(left.left, right.right) && isSame(left.right, right.left);
        }
        return true;
    }


    public static void main(String[] args) {
//        System.out.println("null1nullnullnullnullnullnullnull".split("null").length);
        new IsSymmetric().test();
    }


    public void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(4);
        System.out.println(this.isSymmetric(root));
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSymmetricFlase(TreeNode root) {

        StringBuffer leftBuffer = new StringBuffer();
        StringBuffer rightBuffer = new StringBuffer();

        TreeNode[] rootNodes = {root};
        TreeNode[] checkNodes = null;
        boolean flag = true;
        while (flag) {
            if (checkNodes == null) {
                checkNodes = rootNodes;
            } else {
                checkNodes = new TreeNode[rootNodes.length * 2];
                for (int k = 0; k < rootNodes.length; k++) {
                    checkNodes[2 * k] = null == rootNodes[k] ? null : rootNodes[k].left;
                    checkNodes[2 * k + 1] = null == rootNodes[k] ? null : rootNodes[k].right;
                }
            }
            leftBuffer.delete(0, leftBuffer.length());
            rightBuffer.delete(0, rightBuffer.length());
            for (int j = 0; j < checkNodes.length; j++) {
                leftBuffer.append(null == checkNodes[j] ? "null" : String.valueOf(checkNodes[j].val));
                rightBuffer.append(null == checkNodes[checkNodes.length - 1 - j] ? "null" : String.valueOf(checkNodes[checkNodes.length - 1 - j].val));
            }
            if (!leftBuffer.toString().equals(rightBuffer.toString())) {
                return false;
            }
            rootNodes = checkNodes;
            flag = leftBuffer.toString().split("null").length > 0 ? true : false;
        }
        return true;

    }
}
