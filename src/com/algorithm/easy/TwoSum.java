package com.algorithm.easy;

/**
 * 2018-04-24
 * ����һ�����������һ��Ŀ��ֵ���ҳ������к�ΪĿ��ֵ����������
 * <p>
 * ����Լ���ÿ������ֻ��Ӧһ�ִ𰸣���ͬ����Ԫ�ز��ܱ��ظ����á�
 * <p>
 * ʾ��:
 * <p>
 * ���� nums = [2, 7, 11, 15], target = 9
 * <p>
 * ��Ϊ nums[0] + nums[1] = 2 + 7 = 9
 * ���Է��� [0, 1]
 */
public class TwoSum {


    /*
     * ���Ŵ������
     * 1.��ȡ�����е����ֵ����Сֵ
     * 2.�� Ŀ��ֵ-��Сֵ���������ֵ�� �����ֵ ��Ҫ�ų�
     * 3.�� Ŀ��ֵ-���ֵ��������Сֵ�� С����ֵ ��Ҫ�ų�
     * 4.ȡ ���ֵ �� �������ֵ �н�С����ֵ ʵ�����ֵ
     * 5.ȡ ��Сֵ �� ������Сֵ �нϴ����ֵ ʵ����Сֵ
     * 6.�����������������ݲ���һ���������ģ�������Ҫ�ҵ���ֵ������ ʵ�����ֵ-ʵ����Сֵ+1 ��������������ô���
     * 7.����һ������Ϊ��������������flagNum[],�ж��Ƿ��з���������ֵ
     * �������ص㣡����
     *  8.ѭ��������Ҫ�жϵ����ݣ����ų�С��ʵ����Сֵ�ʹ���ʵ�����ֵ��
     *  9.��һ�����ݾ��� ʵ����Сֵ���� Ŀ��ֵ - num[i](ʵ����Сֵ) - ʵ����Сֵ > 0  && < ��������  �����������У���Ϊ�±��ȡ��ֵһ����-1��
     *    �������д������ num[i](ʵ����Сֵ) - ʵ����Сֵ = 0 ,falgNum[0] = i������ʵ����Сֵ�����������е��±꣩
     *  10. Ŀ��ֵ  - num[i] - ʵ����Сֵ ��Ϊ�±꣬��flagNum[]����ֵ������ζ��
     *      Ŀ��ֵ - a(����������ֵ) - ʵ����Сֵ = Ŀ��ֵ - b(����������ֵ) - ʵ����Сֵ
     *      Ŀ��ֵ = a + b
     *      �����������
     */





    public int[] twoSumPre(int[] nums, int target) {
        //��һ������С��Χ�������ֵ����Сֵ�ķ�Χ��С
        int maxInNums = Integer.MIN_VALUE;    //�ҳ������е����ֵ
        int minInNums = Integer.MAX_VALUE;    //�ҳ������е���Сֵ
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < minInNums)
                minInNums = nums[i];
            if (nums[i] > maxInNums)
                maxInNums = nums[i];
        }

        int maxSecondNum = target - minInNums;    //��һ���������ֵ
        int minSecondNum = target - maxInNums;    //��һ��������Сֵ
        //��Ϊ��������������������ģ����������
        int maxNum = maxSecondNum > maxInNums ? maxInNums : maxSecondNum;    //��������С��������������С������
        int minNum = minSecondNum < minInNums ? minInNums : minSecondNum;    //��С�����Ǵ���������������������
        //����һ�������������ֵ����Сֵ�����飬Ϊ��֮��Ĵ洢��׼��������Ϊ������ֻ�п������������Χ֮�䣩
        //������������ֵ��ֵΪ-1����Ϊ�⽫�����±�Ĵ洢������Ҫ��ֵ��Ϊ-1��
        int[] flagNum = new int[maxNum - minNum + 1];
        for (int i = 0; i < flagNum.length; i++) {
            flagNum[i] = -1;
        }

        for (int i = 0; i <= nums.length; i++) {
            if (nums[i] >= minNum && nums[i] <= maxNum) {    //���Ƚ����Ƿ��ڷ�Χ�ڵ��ж�
                if (flagNum[target - nums[i] - minNum] != -1)
                    return new int[]{flagNum[target - nums[i] - minNum], i};
                else
                    flagNum[nums[i] - minNum] = i;
            }
        }
        return new int[]{0, 0};
    }


    public int[] twoSum(int[] nums, int target) {
        int[] result = {0, 0};
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        return result;
    }


    public static void main(String[] args) throws Exception {
        int[] nums = { 2, 3, 5, 7, 10, 11, 15, 22};
        int target = 14;
        int[] result = new TwoSum().twoSumPre(nums, target);
        for (int num : result) {
            System.out.println(num);
        }
    }
}


