package com.algorithm.easy;

/**
 * Created by TangZz on 2018/8/14.
 * ������������¥�ݡ���Ҫ n ������ܵ���¥����
 * <p>
 * ÿ��������� 1 �� 2 ��̨�ס����ж����ֲ�ͬ�ķ�����������¥���أ�
 * <p>
 * ע�⣺���� n ��һ����������
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺 2
 * ����� 2
 * ���ͣ� �����ַ�����������¥����
 * 1.  1 �� + 1 ��
 * 2.  2 ��
 * ʾ�� 2��
 * <p>
 * ���룺 3
 * ����� 3
 * ���ͣ� �����ַ�����������¥����
 * 1.  1 �� + 1 �� + 1 ��
 * 2.  1 �� + 2 ��
 * 3.  2 �� + 1 ��
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
