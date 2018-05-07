package com.algorithm.easy;

/**
 * Created by TangZz on 2018/5/7.
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 你可以假设数组中无重复元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 * <p>
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 * <p>
 * 输入: [1,3,5,6], 0
 * 输出: 0
 */
public class SearchInsert {

    /**
     * 最优代码分析  二分法查找
     * 通过二分法找到和target数值最接近的2个数，或者相等的数
     * 再判断大小返回位置
     */
    public int searchInsertPre(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right - 1) {
            int middle = (left + right) / 2;
            int cmp = nums[middle] - target;
            if (cmp < 0) {
                left = middle + 1;
            } else if (cmp > 0) {
                right = middle - 1;
            } else {
                return middle;
            }
        }
        if (nums[left] > target) {
            return left;
        } else if (nums[right] < target) {
            return right + 1;
        } else if (nums[left] == target) {
            return left;
        } else {
            return right;
        }
    }

    public int searchInsert(int[] nums, int target) {
        if (null == nums || 0 == nums.length) {
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) {
                return i;
            } else if (target > nums[i] && i + 1 < nums.length && target < nums[i + 1]) {
                return i + 1;
            } else if (target < nums[0]) {
                return 0;
            }
            //相对有效的循环内部
/*            if (target == nums[i]) {
                return i;
            }
            if (target > nums[i]) {
                return i + 1;
            } */
        }
        return nums.length;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3, 5, 6};
        int[] nums2 = {1, 3, 5, 6};
        int[] nums3 = {1, 3, 5, 6};
        int[] nums4 = {1, 3, 5, 6};
        System.out.println(new SearchInsert().searchInsert(nums1, 5));
        System.out.println(new SearchInsert().searchInsert(nums2, 2));
        System.out.println(new SearchInsert().searchInsert(nums3, 7));
        System.out.println(new SearchInsert().searchInsert(nums4, 0));

    }
}
