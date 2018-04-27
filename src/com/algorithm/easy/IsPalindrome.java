package com.algorithm.easy;

/**
 * 2018/4/26.
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 121
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 * <p>
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * <p>
 * 进阶:
 * <p>
 * 你能不将整数转为字符串来解决这个问题吗？
 */
public class IsPalindrome {

    /**
     * 最优代码分析
     * 1.排除小于0的值
     * 2.小于10值一定是回文数
     * 3.获取数值是几位数
     * 4.判断第一位数和第二位数
     * x/总位数  ==  x/10 是否相等
     * x%总位数 就是少第一位
     * x%总位数/10 就是少最后一位
     * 总位数/100  = 下一次比较的总位数
     */
    public boolean isPalindromePre(int x) {
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }
        int len = 1;
        while (x / len >= 10) {
            len *= 10;
        }
        while (x > 0) {
            int left = x / len;
            int right = x % 10;
            if (left != right) {
                return false;
            } else {
                x = (x % len) / 10;
                len /= 100;
            }
        }
        return true;
    }


    public boolean isPalindrome(int x) {
        boolean flag = false;
        int y = 0;
        int z = x;
        while (x > 0) {
            y = y * 10 + x % 10;
            x /= 10;
        }
        if (z == y) {
            flag = true;
        }
        return flag;
    }


    public static void main(String[] args) {
        System.out.println(new IsPalindrome().isPalindrome(1010));
    }

}
