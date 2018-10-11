package com.algorithm.easy;

/**
 * Created by TangZz on 2018/10/11.
 */
public class SortedArrayToBST {

    /**
     * 108. 将有序数组转换为二叉搜索树
     * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
     * <p>
     * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
     * <p>
     * 示例:
     * <p>
     * 给定有序数组: [-10,-3,0,5,9],
     * <p>
     * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
     * <p>
     * 0
     * / \
     * -3   9
     * /   /
     * -10  5
     */


    /**
     * 最优代码分析
     * 1.解决问题的思路还是递归，递归解决思路和自己思考的一致
     * 2.在解决临界值的思路比较好
     * 3.左右的值是否相等，如果相等则说明已经穷举到最后的一个了
     * 4.比如  3,4  3+4/2 = 3  3的左子树是 3,（3-1）  3>2 则返回为空      3的右子树是 （3+1）,4  4=4 右子树就是4
     *
     */
    public TreeNode sortedArrayToBSTPre(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    public TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        } else if (start == end) {
            return new TreeNode(nums[start]);
        } else {
            int mid = (start + end) / 2;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = sortedArrayToBST(nums, start, mid - 1);
            root.right = sortedArrayToBST(nums, mid + 1, end);
            return root;
        }
    }


    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        } else if (nums.length == 1) {
            return new TreeNode(nums[0]);
        }
        return addTreeNode(nums, 0, nums.length - 1);
    }

    public TreeNode addTreeNode(int[] nums, int leftNum, int rightNum) {
        int middleNum = (leftNum + rightNum) / 2;
        TreeNode root = new TreeNode(nums[middleNum]);
        if (middleNum == leftNum) {

        } else if (middleNum - leftNum == 1) {
            root.left = new TreeNode(nums[leftNum]);
        } else {
            root.left = addTreeNode(nums, leftNum, middleNum - 1);
        }
        if (rightNum == middleNum) {

        } else if (rightNum - middleNum == 1) {
            root.right = new TreeNode(nums[rightNum]);
        } else {
            root.right = addTreeNode(nums, middleNum + 1, rightNum);
        }
        return root;
    }


    public static void main(String[] args) {
        new SortedArrayToBST().test();
    }

    public void test() {
        int[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17};
        TreeNode root = this.sortedArrayToBST(nums);

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
