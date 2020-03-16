package com.algorithm.easy;


/**Excel�������
 * ����һ��Excel����е������ƣ���������Ӧ������š�
 * <p>
 * ���磬
 * <p>
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 * ʾ�� 1:
 * <p>
 * ����: "A"
 * ���: 1
 * ʾ��?2:
 * <p>
 * ����: "AB"
 * ���: 28
 * ʾ��?3:
 * <p>
 * ����: "ZY"
 * ���: 701
 * <p>
 */
public class TitleToNumber_171 {

    /*
    ���Ž�-�ڴ���С
        ѭ����ȡ���ݣ�
        ��һλ����*26+��һλ����
     */
    public int titleToNumberMin(String s) {
        int result = 0;
        int l = s.length();
        for(int i = 0; i < l; i++){
            result = result * 26 + (s.charAt(i)-'A' + 1);
        }
        return result;
    }

    public int titleToNumber(String s) {
        int sum = 0;
        char[] chars = s.toCharArray();
        int length = chars.length;
        int temp = 0;
        for (int i = 0; i < length; i++) {
            temp = (((int) chars[i]) - 64);
            if (i < (length - 1)) {
                int j = length - 1 - i;
                while (j > 0) {
                    temp *= 26;
                    j--;
                }
            }
            sum += temp;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("A:" + new TitleToNumber_171().titleToNumber("A"));
        System.out.println("BA:" + new TitleToNumber_171().titleToNumber("BA"));
        System.out.println("AA:" + new TitleToNumber_171().titleToNumber("AA"));
        System.out.println("AB:" + new TitleToNumber_171().titleToNumber("AB"));
        System.out.println("Z:" + new TitleToNumber_171().titleToNumber("Z"));
        System.out.println("ZY:" + new TitleToNumber_171().titleToNumber("ZY"));
        System.out.println("AAA:" + new TitleToNumber_171().titleToNumber("AAA"));
        System.out.println("ABA:" + new TitleToNumber_171().titleToNumber("ABA"));
        System.out.println("BBA:" + new TitleToNumber_171().titleToNumber("BBA"));
    }
}
