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

    public boolean isSymmetric(TreeNode root) {
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

    public static void main(String[] args) {
//        System.out.println("null1nullnullnullnullnullnullnull".split("null").length);
        new IsSymmetric().test();
    }

    public void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
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
}
