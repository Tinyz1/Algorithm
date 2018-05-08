package com.algorithm.easy;

import java.util.ArrayList;

/**
 * Created by TangZz on 2018/5/7.
 * 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例:
 * <p>
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 * <p>
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 */
public class MaxSubArray {


    /**
     * 最优代码分析
     */
    public int maxSubArrayPre(int[] nums) {
        int length = nums.length;
        if(length==0){
            return 0;
        }
        int sum = nums[0];
        int b = 0;
        for(int i=0;i<length;i++){
            if(b>0){
                b += nums[i];
            }else{
                b = nums[i];
            }
            if(sum<b){
                sum = b;
            }
        }
        return sum;
    }


    public int maxSubArray(int[] nums) {
        if (null == nums || 0 == nums.length) {
            return 0;
        }
        if (1 == nums.length) {
            return nums[0];
        }
        int maxNum = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (maxNum < nums[i]) {
                maxNum = nums[i];
            }
        }
        int result = maxNum;
        int value = 0;
        for (int i = 0; i < nums.length; i++) {
            value = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                value += nums[j];
                if(result < value){
                    result = value;
                }
            }
        }
        return result > maxNum ? result : maxNum;
    }

    public static void main(String[] args) {
        int[] nums0 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] nums1 = {-2, -2, 1};
        int[] nums2 = {1, -2, -2};
        int[] nums3 = {3, -2, -3, -3, 1, 3, 0};
        int[] nums4 = {0, 3, 1, -3, -3, -2, 3};
        int[] nums5 = {-2, -1};

        System.out.println(new MaxSubArray().maxSubArray(nums0));
        System.out.println(new MaxSubArray().maxSubArray(nums1));
        System.out.println(new MaxSubArray().maxSubArray(nums2));
        System.out.println(new MaxSubArray().maxSubArray(nums3));
        System.out.println(new MaxSubArray().maxSubArray(nums4));
        System.out.println(new MaxSubArray().maxSubArray(nums5));
    }
}
