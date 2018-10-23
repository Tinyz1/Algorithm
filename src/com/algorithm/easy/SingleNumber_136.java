package com.algorithm.easy;

/**
 * Created by TangZz on 2018/10/23.
 * <p>
 * ����һ���ǿ��������飬����ĳ��Ԫ��ֻ����һ�����⣬����ÿ��Ԫ�ؾ��������Ρ��ҳ��Ǹ�ֻ������һ�ε�Ԫ�ء�
 * <p>
 * ˵����
 * <p>
 * ����㷨Ӧ�þ�������ʱ�临�Ӷȡ� ����Բ�ʹ�ö���ռ���ʵ����
 * <p>
 * ʾ�� 1:
 * <p>
 * ����: [2,2,1]
 * ���: 1
 * ʾ�� 2:
 * <p>
 * ����: [4,1,2,1,2]
 * ���: 4
 */
public class SingleNumber_136 {

    /**
     * ���Ŵ������
     * 1.ʹ��������Ԥ���
     * 2.������ͬ���������Ϊ0��.һ������0��������������
     * 3.��Ҫ��ʽ   a = b^a^b ,���������г���2�ε����ݣ����֮����ԭ�е�ֵ��ֻҪ��������������õ��ľ�����ֻ����һ�ε�ֵ
     */
    public int singleNumberPre(int[] nums) {
        //������ͬ���������Ϊ0��һ������0��������������
        int test = 0;
        for ( int i = nums.length -1 ; i >= 0; --i) {
            test ^= nums[i];
        }
        return test;
    }

    public int singleNumber(int[] nums) {
        boolean flag ;
        for (int i = 0; i < nums.length; i++) {
            flag = true;
            for (int j = 0; j < nums.length; j++) {
                if (i != j && nums[i] == nums[j]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return nums[i];
            }
        }
        return 0;
    }


    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(new SingleNumber_136().singleNumber(nums));
    }
}
