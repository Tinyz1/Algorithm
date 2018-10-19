package com.algorithm.easy;

/**
 * Created by TangZz on 2018/10/19.
 * <p>
 * ����һ�����飬���ĵ� i ��Ԫ����һ֧������Ʊ�� i ��ļ۸�
 * <p>
 * ���һ���㷨�����������ܻ�ȡ�������������Ծ����ܵ���ɸ���Ľ��ף��������һ֧��Ʊ����
 * <p>
 * ע�⣺�㲻��ͬʱ�����ʽ��ף���������ٴι���ǰ���۵�֮ǰ�Ĺ�Ʊ����
 * <p>
 * ʾ�� 1:
 * <p>
 * ����: [7,1,5,3,6,4]
 * ���: 7
 * ����: �ڵ� 2 �죨��Ʊ�۸� = 1����ʱ�����룬�ڵ� 3 �죨��Ʊ�۸� = 5����ʱ������, ��ʽ������ܻ������ = 5-1 = 4 ��
 * ����ڵ� 4 �죨��Ʊ�۸� = 3����ʱ�����룬�ڵ� 5 �죨��Ʊ�۸� = 6����ʱ������, ��ʽ������ܻ������ = 6-3 = 3 ��
 * ʾ�� 2:
 * <p>
 * ����: [1,2,3,4,5]
 * ���: 4
 * ����: �ڵ� 1 �죨��Ʊ�۸� = 1����ʱ�����룬�ڵ� 5 �� ����Ʊ�۸� = 5����ʱ������, ��ʽ������ܻ������ = 5-1 = 4 ��
 * ע���㲻���ڵ� 1 ��͵� 2 ����������Ʊ��֮���ٽ�����������
 * ��Ϊ��������ͬʱ�����˶�ʽ��ף���������ٴι���ǰ���۵�֮ǰ�Ĺ�Ʊ��
 * ʾ�� 3:
 * <p>
 * ����: [7,6,4,3,1]
 * ���: 0
 * ����: �����������, û�н������, �����������Ϊ 0��
 */
public class MaxProfitII {


    /**
     * ���Ŵ������
     * ���ҵ���С����������������
     * ��Ѱ�ҵĹ����У�û�б�Ҫȥ�Ƚϲ�ֵ��ֻ���ҵ���������
     * �����˴�ѭ���Ĵ���
     */

    public int maxProfitIIPre(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int i = 0;
        int max = 0;
        while(i < nums.length){
            //�ҵ�������С����
            while(i < nums.length - 1 && nums[i+1] <= nums[i])
                i++;
            int min = nums[i];
            //�ҵ�����������
            while(i < nums.length - 1 && nums[i+1] >= nums[i])
                i++;
            max += (i < nums.length) ? (nums[i++] - min) : 0;
        }
        return max;
    }

    public int maxProfitIIPre2(int[] prices) {
        int result = 0;
        int temp = 0;
        for(int i = 1; i < prices.length; i++){
            temp = prices[i] - prices[i - 1];
            if(temp > 0)result += temp;
        }
        return result;
    }


    public int maxProfitII(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int result = 0;
        int min = prices[0];
        int max = prices[0];
        int win = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < max) {
                result += win;
                win = 0;
                min = prices[i];
                max = prices[i];
            } else  { // } else if (prices[i] >= max) { ȥ��if�е��ж����������ٳ���Ƚϴ���
                max = prices[i];
                win = max - min;
            }
        }
        if (win > 0) {
            result += win;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 4, 5, 6, 7, 9, 10};
        System.out.println(new MaxProfitII().maxProfitII(prices));
        int[] prices1 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        System.out.println(new MaxProfitII().maxProfitII(prices1));
        int[] prices2 = {10, 3, 3, 4, 9, 1, 6, 7, 10, 2};
        System.out.println(new MaxProfitII().maxProfitII(prices2));
    }
}
