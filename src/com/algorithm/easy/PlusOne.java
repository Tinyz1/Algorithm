package com.algorithm.easy;

/**
 * Created by TangZz on 2018/5/10.
 * ����һ���Ǹ�������ɵķǿ����飬�ڸ����Ļ����ϼ�һ������һ���µ����顣
 * <p>
 * ���λ���ִ�����������λ�� ������ÿ��Ԫ��ֻ�洢һ�����֡�
 * <p>
 * ����Լ���������� 0 ֮�⣬��������������㿪ͷ��
 * <p>
 * ʾ�� 1:
 * <p>
 * ����: [1,2,3]
 * ���: [1,2,4]
 * ����: ���������ʾ���� 123��
 * ʾ�� 2:
 * <p>
 * ����: [4,3,2,1]
 * ���: [4,3,2,2]
 * ����: ���������ʾ���� 4321��
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {
        if (digits[digits.length - 1] + 1 < 10) {
            digits[digits.length - 1] += 1;
            return digits;
        }
        int plusNum = (digits[digits.length - 1] + 1) / 10;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (plusNum > 0) {
                digits[i] += 1;
                if (digits[i] >= 10) {
                    digits[i] %= 10;
                    plusNum = 1;
                } else {
                    break;
                }
                if (i == 0 && plusNum > 0) {
                    int[] result = new int[digits.length + 1];
                    result[0] = 1;
                    for (int j = 0; j < digits.length; j++) {
                        result[j + 1] = digits[j];
                    }
                    return result;
                }
            } else {
                break;
            }
        }
        return digits;
    }

    public static void main(String[] args) {
        int[] digits = {9};
        int[] result = new PlusOne().plusOne(digits);
        for (int res : result) {
            System.out.println(res);
        }
    }
}
