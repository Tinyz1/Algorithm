package com.algorithm.easy;


import java.util.HashMap;

/**
 * ����һ����СΪ n �����飬�ҵ����еĶ���Ԫ�ء�����Ԫ����ָ�������г��ִ������� [ n/2 ]��Ԫ�ء�
 * <p>
 * ����Լ��������Ƿǿյģ����Ҹ������������Ǵ��ڶ���Ԫ�ء�
 * <p>
 * ʾ�� 1:
 * <p>
 * ����: [3,2,3]
 * ���: 3
 * ʾ�� 2:
 * <p>
 * ����: [2,2,1,1,1,2,2]
 * ���: 2
 */
public class MajorityElement_169 {

    //���Ž�-ʱ������
    /*
     * ʹ�õ�һ������ȥ���������ݱȽϣ�
     * 1.��ͬ�������+1
     * 2.����ͬ�������-1,
     * 3.��ǰ����ֵΪ0ʱ�����滻��ǰ�����бȽϵ�ֵ
     *  ����Ԫ�ش��� n/2 ������ÿ����ͬ�����Ͷ���Ԫ�رϾ������Ƕ���Ԫ�ض�
     * */
    public int majorityElementFast(int[] nums) {
        int num = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (num == nums[i]) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    num = nums[i];
                    count++;
                }
            }
        }
        return num;
    }

    //���Ž�-�ڴ�������С
    /*
     * 1.ͨ��HashMap�������ֵ
     * 2.�ж�������Ȼ�������������������
     */
    public int majorityElementMin(int[] nums) {
        HashMap<Integer, Integer> res = new HashMap();
        int res_num = 0;
        for (int i = 0; i < nums.length; i++) {
            if (res.containsKey(nums[i]))
                res.put(nums[i], res.get(nums[i]) + 1);
            else
                res.put(nums[i], 1);

            if (res.get(nums[i]) > (nums.length / 2)) {
                res_num = nums[i];
                break;
            }
        }
        return res_num;
    }


    public int majorityElement(int[] nums) {
        int length = nums.length;
        int temp = 0;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (nums[i] > nums[j]) {
                    temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        return nums[length / 2];
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 2, 3, 1, 3};
        System.out.println(new MajorityElement_169().majorityElement(nums));
    }

}
