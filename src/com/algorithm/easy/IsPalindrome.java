package com.algorithm.easy;

/**
 * 2018/4/26.
 * �ж�һ�������Ƿ��ǻ���������������ָ���򣨴������ң��͵��򣨴������󣩶�����һ����������
 * <p>
 * ʾ�� 1:
 * <p>
 * ����: 121
 * ���: true
 * ʾ�� 2:
 * <p>
 * ����: -121
 * ���: false
 * ����: �������Ҷ�, Ϊ -121 �� ���������, Ϊ 121- �����������һ����������
 * ʾ�� 3:
 * <p>
 * ����: 10
 * ���: false
 * ����: ���������, Ϊ 01 �����������һ����������
 * <p>
 * ����:
 * <p>
 * ���ܲ�������תΪ�ַ�����������������
 */
public class IsPalindrome {

    /**
     * ���Ŵ������
     * 1.�ų�С��0��ֵ
     * 2.С��10ֵһ���ǻ�����
     * 3.��ȡ��ֵ�Ǽ�λ��
     * 4.�жϵ�һλ���͵ڶ�λ��
     * x/��λ��  ==  x/10 �Ƿ����
     * x%��λ�� �����ٵ�һλ
     * x%��λ��/10 ���������һλ
     * ��λ��/100  = ��һ�αȽϵ���λ��
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
