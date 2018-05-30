package com.algorithm.easy;

/**
 * Created by TangZz on 2018/5/14.
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * <p>
 * 输入为非空字符串且只包含数字 1 和 0。
 * <p>
 * 示例 1:
 * <p>
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 * <p>
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 */
public class AddBinary {


    /**
     * 最优代码分析
     * 1.把入参a和b的2个数组，转化为长数组和短数组，这样只需要比较长和短，无需判断a和b2种情况
     * 2.'0' 是48  '1' 是49   2个字符的相加变为 0 和 1 的相加
     * 3. 1/2 , 0/2 = 0 不需要进位  2/2 则需要进位， 当前位就是 %2 的结果
     * 4. 最后进位就要在返回的字符前+1
     */
    public String addBinaryPre(String a, String b) {
        if (a == null || b == null) {
            return a == null ? b : a;
        }
        int m = a.length();
        int n = b.length();
        int size = Math.max(m, n);
        char[] result = new char[size];
        char[] longArray = m > n ? a.toCharArray() : b.toCharArray();
        char[] shortArray = m > n ? b.toCharArray() : a.toCharArray();
        int diff = longArray.length - shortArray.length; // important
        int carry = 0;
        for (int i = size - 1; i >= 0; i--) {
            int sum = carry + (longArray[i] - '0');
            if (i - diff >= 0) {
                sum += (shortArray[i - diff] - '0');
            }
            carry = sum / 2;
            result[i] = (char) (sum % 2 + '0');
        }

        if (carry != 0) {
            return "1" + new String(result);
        }
        return new String(result);
    }

    public String addBinary(String a, String b) {
        char[] charA = a.toCharArray();
        char[] charB = b.toCharArray();
        int plusNum = 0;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = charA.length - 1, j = charB.length - 1; i >= 0 || j >= 0; i--, j--) {
            if (i >= 0 && j >= 0) {
                if ('0' == charA[i] && '0' == charB[j]) {
                    if (plusNum == 1) {
                        stringBuffer.insert(0, '1');
                        plusNum = 0;
                    } else {
                        stringBuffer.insert(0, '0');
                        plusNum = 0;
                    }
                }
                if (('1' == charA[i] && '0' == charB[j]) || ('0' == charA[i] && '1' == charB[j])) {
                    if (plusNum == 1) {
                        stringBuffer.insert(0, '0');
                        plusNum = 1;
                    } else {
                        stringBuffer.insert(0, '1');
                        plusNum = 0;
                    }
                }
                if ('1' == charA[i] && '1' == charB[j]) {
                    if (plusNum == 1) {
                        stringBuffer.insert(0, '1');
                        plusNum = 1;
                    } else {
                        stringBuffer.insert(0, '0');
                        plusNum = 1;
                    }
                }
            } else if (i >= 0) {
                if ('0' == charA[i] && plusNum == 0) {
                    stringBuffer.insert(0, '0');
                } else if (('0' == charA[i] && plusNum == 1) || ('1' == charA[i] && plusNum == 0)) {
                    stringBuffer.insert(0, '1');
                    plusNum = 0;
                } else if ('1' == charA[i] && plusNum == 1) {
                    stringBuffer.insert(0, '0');
                    plusNum = 1;
                }
            } else if (j >= 0) {
                if ('0' == charB[j] && plusNum == 0) {
                    stringBuffer.insert(0, '0');
                } else if (('0' == charB[j] && plusNum == 1) || ('1' == charB[j] && plusNum == 0)) {
                    stringBuffer.insert(0, '1');
                    plusNum = 0;
                } else if ('1' == charB[j] && plusNum == 1) {
                    stringBuffer.insert(0, '0');
                    plusNum = 1;
                }
            }
        }
        if (plusNum == 1) {
            stringBuffer.insert(0, '1');
        }
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        System.out.println(1/2);
        System.out.println(2/2);
        StringBuffer test = new StringBuffer();
//        System.out.println(new AddBinary().addBinary("100", "110010"));
    }
}
