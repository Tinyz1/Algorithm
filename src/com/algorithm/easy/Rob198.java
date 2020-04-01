package com.algorithm.easy;

/**
 * 198. ��ҽ���
 * ����һ��רҵ��С͵���ƻ�͵���ؽֵķ��ݡ�ÿ�䷿�ڶ�����һ�����ֽ�Ӱ����͵�Ե�Ψһ��Լ���ؾ������ڵķ���װ���໥��ͨ�ķ���ϵͳ������������ڵķ�����ͬһ���ϱ�С͵���룬ϵͳ���Զ�������
 * <p>
 * ����һ������ÿ�����ݴ�Ž��ķǸ��������飬�������ڲ���������װ�õ�����£��ܹ�͵�Ե�����߽�
 * <p>
 * ʾ�� 1:
 * <p>
 * ����: [1,2,3,1]
 * ���: 4
 * ����: ͵�� 1 �ŷ��� (��� = 1) ��Ȼ��͵�� 3 �ŷ��� (��� = 3)��
 * ?    ͵�Ե�����߽�� = 1 + 3 = 4 ��
 * ʾ�� 2:
 * <p>
 * ����: [2,7,9,3,1]  [20,7,9,30,1]
 * ���: 12
 * ����: ͵�� 1 �ŷ��� (��� = 2), ͵�� 3 �ŷ��� (��� = 9)������͵�� 5 �ŷ��� (��� = 1)��
 * ?    ͵�Ե�����߽�� = 2 + 9 + 1 = 12 ��
 * <p>
 */
public class Rob198 {


    public int robMin(int[] nums) {
        int preMax = 0;
        int curMax = 0;
        for(int x:nums){
            int temp = curMax;
            curMax = Math.max(preMax + x, curMax);
            preMax = temp;
        }
        return curMax;
    }

    public int robFast(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }
        int[] ans = new int[nums.length];
        ans[0] = nums[0];
        ans[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            ans[i] = Math.max(nums[i] + ans[i - 2], ans[i - 1]);
        }
        return ans[ans.length - 1];
    }

    public int rob(int[] nums) {
        int len = nums.length;
        if (len <= 3) {
            switch (len) {
                case 0:
                    return 0;
                case 1:
                    return nums[0];
                case 2:
                    return nums[0] >= nums[1] ? nums[0] : nums[1];
                case 3:
                    return nums[1] >= nums[0] + nums[2] ? nums[1] : nums[0] + nums[2];
            }
            return 0;
        } else {
            int a = 0;
            int b = 0;
            int c = 0;
            int temp = 0;
            a = nums[0];
            b = nums[1];
            c = nums[0] + nums[2];
            for (int i = 3; i < len; i++) {
                if (a >= b) {
                    temp = c;
                    c = a + nums[i];
                    a = b;
                    b = temp;
                } else {
                    temp = c;
                    c = b + nums[i];
                    a = b;
                    b = temp;
                }
            }
            return a >= b && a >= c ? a : b >= c ? b : c;
        }
    }

    /*
     * 2        3
     *   7      10
     *     11
     * 7        1
     *      10  1
     *   11     1
     * */
    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};
        System.out.println(new Rob198().rob(nums));


    }
}
