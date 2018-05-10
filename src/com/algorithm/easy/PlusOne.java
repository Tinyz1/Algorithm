package com.algorithm.easy;

/**
 * Created by TangZz on 2018/5/10.
 * 给定一个非负整数组成的非空数组，在该数的基础上加一，返回一个新的数组。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 * <p>
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
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
