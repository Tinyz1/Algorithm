package com.algorithm.easy;

/**
 * Created by TangZz on 2018/5/7.
 * ����������ָһ���������У��������е�������˳����б������õ���һ��������ǰ�������£�
 * <p>
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 ������  "one 1"  ("һ��һ") , �� 11��
 * 11 ������ "two 1s" ("����һ"��, �� 21��
 * 21 ������ "one 2",  "one 1" ��"һ����" ,  "һ��һ") , �� 1211��
 * <p>
 * ����һ�������� n ������������еĵ� n �
 * <p>
 * ע�⣺����˳�򽫱�ʾΪһ���ַ�����
 * <p>
 * ʾ�� 1:
 * <p>
 * ����: 1
 * ���: "1"
 * ʾ�� 2:
 * <p>
 * ����: 4
 * ���: "1211"
 */
public class CountAndSay {


    /**
     * ���Ŵ������
     * �ܵ�˼�뻹�ǵݹ�
     * ѭ���ַ�����������ַ���������ͬ���ַ�����
     * �������ͬ����Ȼ����������Ȼ�������ѭ��ֱ�ӴӲ���ͬ�Ŀ�ʼ
     */
    public String countAndSayPre(int n) {
        if (n == 1) return "1";
        String s = getString("1");
        for (int i = 0; i < n - 2; ++i) {
            s = getString(s);
        }
        return s;
    }

    private String getString(String s) {
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        int num;
        for (int i = 0; i < chars.length; ) {
            num = 1;
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[j] == chars[i]) ++num;
                else break;
            }
            sb.append(num).append(chars[i]);
            i += num;
        }
        return sb.toString();
    }


    public String countAndSay(int n) {
        if (1 == n) {
            return "1";
        }
        char[] chars = countAndSay(n - 1).toCharArray();
        char value = chars[0];
        int count = 0;
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < chars.length; i++) {
            if (value == chars[i]) {
                ++count;
            } else {
                result.append(count).append(value);
                value = chars[i];
                count = 1;
            }
        }
        result.append(count).append(value);
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println("1".toCharArray()[0]);
        System.out.println(new CountAndSay().countAndSay(1));
        System.out.println(new CountAndSay().countAndSay(2));
        System.out.println(new CountAndSay().countAndSay(3));
        System.out.println(new CountAndSay().countAndSay(4));
        System.out.println(new CountAndSay().countAndSay(5));
        System.out.println(new CountAndSay().countAndSay(6));
        System.out.println(new CountAndSay().countAndSay(7));
        System.out.println("13211311123113112211");
        System.out.println(new CountAndSay().countAndSay(10));
    }
}
