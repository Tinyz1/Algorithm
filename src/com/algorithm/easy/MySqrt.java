package com.algorithm.easy;

/**
 * Created by TangZz on 2018/6/6.
 * 实现 int sqrt(int x) 函数。
 * <p>
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * <p>
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 */
public class MySqrt {

    /**
     * 由于Int最大数值是 2147483647
     * 最大的平方根就是 46340 * 46340 =  2147395600  也就是最大的就是 46340
     * 如果是使用 46341 * 46341 = -2147479015
     * 需要考虑在处理平方根时需要判断是否支持
     *
     * 通过二分法找下平方根 -- 二分法才是真的快啊
     */


    public int mySqrtPre(int x) {
        int low = 0, high = 46341, mid = 0;
        while (low <= high) {
            if (mid == low + (high - low) / 2) {
                return mid;
            }
            mid = low + (high - low) / 2;
            int square = mid * mid;
            if (square == x) {
                return mid;
            } else if (square > x) {
                high = mid;
            } else {
                low = mid;
            }
        }
        return mid;
    }

    public int mySqrt(int x) {
        long result = 0;
        long result1 = result * result;
        while (result1 <= x) {
            result++;
            result1 = result * result;
        }
        return Integer.valueOf((result - 1) + "");
    }


    public static void main(String[] args) {
        int result = new MySqrt().mySqrt(2147395600);
        System.out.println(result);
        System.out.println(new MySqrt().mySqrt(4));
    }
}
