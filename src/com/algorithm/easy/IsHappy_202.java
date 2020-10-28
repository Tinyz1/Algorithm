package com.algorithm.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: zhaozw
 * @Description:
 * @Date: Create in 16:46 2020/10/28
 * <p>
 * <p>
 * ��дһ���㷨���ж�һ���� n �ǲ��ǿ�������
 * <p>
 * ��������������Ϊ������һ����������ÿһ�ν������滻Ϊ��ÿ��λ���ϵ����ֵ�ƽ���ͣ�Ȼ���ظ��������ֱ���������Ϊ 1��
 * Ҳ������ ����ѭ�� ��ʼ�ձ䲻�� 1��
 * ��� ���Ա�Ϊ? 1����ô��������ǿ�������
 * <p>
 * ��� n �ǿ������ͷ��� True �����ǣ��򷵻� False ��
 * <p>
 * ?
 * <p>
 * ʾ����
 * <p>
 * ���룺19
 * �����true
 * ���ͣ�
 * <p>
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 * <p>
 */
public class IsHappy_202 {

    public boolean isHappy(int n) {
        if (n == 1) {
            return true;
        }
        Set set = new HashSet();
        set.add(n);
        int m = getSum(n);
        while (n != m && m != 1 && !set.contains(m)) {
            set.add(m);
            n = m;
            m = getSum(n);
        }
        if (m == 1) {
            return true;
        }
        return false;
    }

    public int getSum(int n) {
        int sum = 0;
        int num = 0;
        while (n >= 10) {
            num = n - (n / 10) * 10;
            sum = sum + num * num;
            n = n / 10;
        }
        return sum + n * n;
    }


    public boolean isHappyFast(int n) {
        HashSet<Integer> set = new HashSet<>();
        while(n != 1) {
            if (set.contains(n)) {
                return false;
            }
            set.add(n);
            int sum = 0;
            while(n != 0) {
                sum += (n % 10) * (n % 10);
                n = n / 10;
            }
            n = sum;
        }
        return true;
    }






    public boolean isHappyMin(int n) {
        int slowRunner = n;
        int fastRunner = getNext(n);
        while (fastRunner != 1 && slowRunner != fastRunner) {
            slowRunner = getNext(slowRunner);
            fastRunner = getNext(getNext(fastRunner));
        }
        return fastRunner == 1;
    }
    public int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }


    public static void main(String[] args) {
        System.out.println("59:" + new IsHappy_202().isHappy(59));
    }
}
