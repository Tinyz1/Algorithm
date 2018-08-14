package com.algorithm.easy;

/**
 * Created by TangZz on 2018/8/14.
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 注意：给定 n 是一个正整数。
 * <p>
 * 示例 1：
 * <p>
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 * <p>
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 */
public class ClimbStairs {

    private int help(int n, int[] memo) {
        if (n == 1 || n == 0)
            return 1;
        if (memo[n] == -1) {
            memo[n] = help(n - 1, memo) + help(n - 2, memo);
        }
        return memo[n];
    }

    /**
    *
    * */
    public int climbStairsPre(int n) {
        int[] memo = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            memo[i] = -1;
        }
        return help(n, memo);
    }


    public int climbStairs(int n) {
        int[] result = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            if (i <= 1) {
                result[i] = 1;
            } else {
                result[i] = result[i - 1] + result[i - 2];
            }
        }
        return result[n];
    }

    public int climbStairs_zz(int n) {
        if (n > 2) {
            return climbStairs(n - 1) + climbStairs(n - 2);
        } else {
            return n;
        }
    }


    public static void main(String[] args) {
        System.out.println(new ClimbStairs().climbStairs(44));//1134903170
    }
}
