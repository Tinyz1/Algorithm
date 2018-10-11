package com.algorithm.easy;

/**
 * Created by TangZz on 2018/10/11.
 */
public class SortedArrayToBST {

    /**
     * 108. ����������ת��Ϊ����������
     * ��һ�������������е��������飬ת��Ϊһ�ø߶�ƽ�������������
     * <p>
     * �����У�һ���߶�ƽ���������ָһ��������ÿ���ڵ� ���������������ĸ߶Ȳ�ľ���ֵ������ 1��
     * <p>
     * ʾ��:
     * <p>
     * ������������: [-10,-3,0,5,9],
     * <p>
     * һ�����ܵĴ��ǣ�[0,-3,9,-10,null,5]�������Ա�ʾ��������߶�ƽ�������������
     * <p>
     * 0
     * / \
     * -3   9
     * /   /
     * -10  5
     */


    /**
     * ���Ŵ������
     * 1.��������˼·���ǵݹ飬�ݹ���˼·���Լ�˼����һ��
     * 2.�ڽ���ٽ�ֵ��˼·�ȽϺ�
     * 3.���ҵ�ֵ�Ƿ���ȣ���������˵���Ѿ���ٵ�����һ����
     * 4.����  3,4  3+4/2 = 3  3���������� 3,��3-1��  3>2 �򷵻�Ϊ��      3���������� ��3+1��,4  4=4 ����������4
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
