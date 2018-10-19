package com.algorithm.easy;

/**
 * Created by TangZz on 2018/10/19.
 * <p>
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * <p>
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [7,1,5,3,6,4]
 * 输出: 7
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 * 随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 * 示例 2:
 * <p>
 * 输入: [1,2,3,4,5]
 * 输出: 4
 * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 * 注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
 * 因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 * 示例 3:
 * <p>
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 */
public class MaxProfitII {


    /**
     * 最优代码分析
     * 先找到最小的数，再找最大的数
     * 在寻找的过程中，没有必要去比较差值，只到找到了最大的数
     * 减少了大循环的次数
     */

    public int maxProfitIIPre(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int i = 0;
        int max = 0;
        while(i < nums.length){
            //找到附近最小的数
            while(i < nums.length - 1 && nums[i+1] <= nums[i])
                i++;
            int min = nums[i];
            //找到附近最大的数
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
            } else  { // } else if (prices[i] >= max) { 去掉if中的判断条件，减少程序比较次数
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
