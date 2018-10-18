package com.algorithm.easy;

/**
 * Created by TangZz on 2018/10/18.
 * <p>
 * ����һ�����飬���ĵ� i ��Ԫ����һ֧������Ʊ�� i ��ļ۸�
 * <p>
 * ��������ֻ�������һ�ʽ��ף������������һ֧��Ʊ�������һ���㷨�����������ܻ�ȡ���������
 * <p>
 * ע���㲻���������Ʊǰ������Ʊ��
 * <p>
 * ʾ�� 1:
 * <p>
 * ����: [7,1,5,3,6,4]
 * ���: 5
 * ����: �ڵ� 2 �죨��Ʊ�۸� = 1����ʱ�����룬�ڵ� 5 �죨��Ʊ�۸� = 6����ʱ��������������� = 6-1 = 5 ��
 * ע���������� 7-1 = 6, ��Ϊ�����۸���Ҫ��������۸�
 * ʾ�� 2:
 * <p>
 * ����: [7,6,4,3,1]
 * ���: 0
 * ����: �����������, û�н������, �����������Ϊ 0��
 */
public class MaxProfit {


    /**
     * ���д������
     * ��ԭ����else���ж��Ƿ�Ҫ���¸�ֵ��result��������ֱ����else if()�������
     */
    public int maxProfitPre(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int min = prices[0];
        int result = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else if (prices[i] - min > result) {
                result = prices[i] - min;
            }
        }
        return result;
    }

    /**
     * ˼·
     * 1.��ǰ��ʼ���ҵ���һ�α�ǰ��С����
     * 2.���αȽ�������ͺ�������Ĵ�С��
     */
    public int maxProfit(int[] prices) {
        if (null == prices || prices.length == 0) {
            return 0;
        }
        int push = prices[0];
        int result = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] <= push) {
                push = prices[i];
            } else {
                result = prices[i] - push > result ? prices[i] - push : result;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 4, 5, 6, 7, 9, 10};
        System.out.println(new MaxProfit().maxProfit(prices));
        int[] prices1 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        System.out.println(new MaxProfit().maxProfit(prices1));
        int[] prices2 = {10, 3, 3, 4, 9, 1, 6, 7, 10, 2};
        System.out.println(new MaxProfit().maxProfit(prices2));
    }
}
