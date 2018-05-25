package com.algorithm.easy;

/**
 * Created by TangZz on 2018/5/14.
 * ���������������ַ������������ǵĺͣ��ö����Ʊ�ʾ����
 * <p>
 * ����Ϊ�ǿ��ַ�����ֻ�������� 1 �� 0��
 * <p>
 * ʾ�� 1:
 * <p>
 * ����: a = "11", b = "1"
 * ���: "100"
 * ʾ�� 2:
 * <p>
 * ����: a = "1010", b = "1011"
 * ���: "10101"
 */
public class AddBinary {

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
                if ('0' == charA[i] || plusNum == 0) {
                    stringBuffer.insert(0, charA[i]);
                }
                if ('1' == charA[i] && plusNum == 1) {
                    stringBuffer.insert(0, '0');
                    plusNum = 1;
                }
            } else if (j >= 0) {
                if ('0' == charB[j] || plusNum == 0) {
                    stringBuffer.insert(0, charB[j]);
                }
                if ('1' == charB[j] && plusNum == 1) {
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
        StringBuffer test = new StringBuffer();
        System.out.println(new AddBinary().addBinary("100", "11"));
    }
}
