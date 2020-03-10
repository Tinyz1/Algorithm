package com.algorithm.easy;

/**
 * 168. Excel��������
 * ����һ������������������ Excel �������Ӧ�������ơ�
 * <p>
 * ���磬
 * <p>
 * 1 -> A
 * 2 -> B
 * 3 -> C
 * ...
 * 26 -> Z
 * 27 -> AA
 * 28 -> AB
 * ...
 * ʾ�� 1:
 * <p>
 * ����: 1
 * ���: "A"
 * ʾ��?2:
 * <p>
 * ����: 28
 * ���: "AB"
 * ʾ��?3:
 * <p>
 * ����: 701
 * ���: "ZY"
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/excel-sheet-column-title
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class ConvertToTitle_168 {

    //�ڴ���С-��ʹ�õݹ飬ѭ��ʵ��
    public String convertToTitleMin(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            int c = n % 26;
            if(c == 0){
                c = 26;
                n -= 1;
            }
            sb.insert(0, (char) ('A' + c - 1));//��ͷ����ֵ
            n /= 26;
        }
        return sb.toString();
    }

    //��ʱ����-�������ܿ�
    public String convertToTitleFast(int n) {
        StringBuffer sb = new StringBuffer();
        while (n > 0) {
            n--;
            char c = (char) ('A'+ n%26);
            n /= 26;
            sb.append(c);
        }
        return sb.reverse().toString();//��ת
    }


    public String convertToTitle(int n) {
        if (n <= 26) {
            return String.valueOf((char) (n + 64));
        } else {
            int a = n / 26;
            int b = n - a * 26;
            if (b == 0) {
                a -= 1;
                b = 26;
            }
            String str = String.valueOf((char) (b + 64));
            if (a > 26) {
                return convertToTitle(a) + str;
            } else {
                return String.valueOf((char) (a + 64)) + str;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new ConvertToTitle_168().convertToTitle(52));
    }
}
