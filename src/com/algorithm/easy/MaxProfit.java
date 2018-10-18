package com.algorithm.easy;

/**
 * Created by TangZz on 2018/10/18.
 * <p>
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * <p>
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 注意你不能在买入股票前卖出股票。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * 示例 2:
 * <p>
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 */
public class MaxProfit {


    /**
     * 最有代码分析
     * 把原来在else中判断是否要重新赋值给result的条件，直接在else if()后面加上
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
     * 思路
     * 1.从前开始，找到第一次比前面小的数
     * 2.依次比较这个数和后面的数的大小，
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
