package com.algorithm.easy;

import java.util.Map;

/**
 * 2018/4/25.
 * 给定一个 32 位有符号整数，将整数中的数字进行反转。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 * 示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 * 注意:
 * <p>
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [?2 31,  2 31 ? 1]。根据这个假设，如果反转后的整数溢出，则返回 0。
 */
public class SolutionReverse {


    public int reversePre(int x) {
        boolean negative = x < 0;
        if (negative) x = -x;
        long r = 0;
        while (x > 0) {
            r = r * 10 + x % 10;
            x /= 10;
        }
        if (negative) r = -r;
        if (r > Integer.MAX_VALUE || r < Integer.MIN_VALUE) return 0;
        return (int) r;
    }


    public int reverse(int x) {
        int result = 0;
        int flag = 1;
        int checkNum = 0;
        if (x < 0) {
            x = x * -1;
            flag = -1;
        }
        while (x / 10 > 0 || (x / 10 == 0 && (x - x / 10 * 10) > 0)) {
            checkNum = result;
            result = result * 10 + (x - x / 10 * 10);
            x = x / 10;
            if (result / 10 > checkNum || result / 10 < checkNum) {
                result = 0;
                flag = 0;
            }
        }
        if (flag == -1) {
            if (x == Integer.MIN_VALUE || x == Integer.MIN_VALUE) {
                result = 0;
            } else {
                result = result * flag;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE);
        System.out.println(new SolutionReverse().reverse(1534236469));
    }

}
