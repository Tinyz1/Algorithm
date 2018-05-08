package com.algorithm.easy;

import java.util.ArrayList;

/**
 * Created by TangZz on 2018/5/7.
 * ��������
 * ����һ���������� nums ���ҵ�һ���������͵����������飨���������ٰ���һ��Ԫ�أ������������͡�
 * <p>
 * ʾ��:
 * <p>
 * ����: [-2,1,-3,4,-1,2,1,-5,4],
 * ���: 6
 * ����: ���������� [4,-1,2,1] �ĺ����Ϊ 6��
 * ����:
 * <p>
 * ������Ѿ�ʵ�ָ��Ӷ�Ϊ O(n) �Ľⷨ������ʹ�ø�Ϊ����ķ��η���⡣
 */
public class MaxSubArray {


    /**
     * ���Ŵ������
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
