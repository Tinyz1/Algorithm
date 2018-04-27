package com.algorithm.easy;

/**
 * 2018/4/25.
 * ����һ�� 32 λ�з����������������е����ֽ��з�ת��
 * <p>
 * ʾ�� 1:
 * <p>
 * ����: 123
 * ���: 321
 * ʾ�� 2:
 * <p>
 * ����: -123
 * ���: -321
 * ʾ�� 3:
 * <p>
 * ����: 120
 * ���: 21
 * ע��:
 * <p>
 * �������ǵĻ���ֻ�ܴ洢 32 λ�з�������������ֵ��Χ�� [?2 31,  2 31 ? 1]������������裬�����ת�������������򷵻� 0��
 */
public class Reverse {

    /**
     * ���Ŵ������
     * 1.�ж��Ƿ��Ǹ���
     * 2.��long�洢ȡ������
     * r = r*10 + x%10 (ȡ����)
     * x /= 10 (ȡ����)
     * 3.����Ǹ�������ȡ��
     * 4.�ж��Ƿ񳬳�int���͵�������С
     */

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
        System.out.println(new Reverse().reverse(1534236469));
    }

}