package com.algorithm.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by TangZz on 2018/4/27.
 * �������ְ������������ַ���I�� V�� X�� L��C��D �� M��
 * <p>
 * �ַ�          ��ֵ
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * ���磬 �������� 2 д�� II ����Ϊ�������е� 1��12 д�� XII ����Ϊ X + II �� 27 д��  XXVII, ��Ϊ XX + V + II ��
 * <p>
 * ͨ������£�����������С�������ڴ�����ֵ��ұߡ���Ҳ�������������� 4 ��д�� IIII������ IV������ 1 ������ 5 ����ߣ�����ʾ�������ڴ��� 5 ��С�� 1 �õ�����ֵ 4 ��ͬ���أ����� 9 ��ʾΪ IX���������Ĺ���ֻ�������������������
 * <p>
 * I ���Է��� V (5) �� X (10) ����ߣ�����ʾ 4 �� 9��
 * X ���Է��� L (50) �� C (100) ����ߣ�����ʾ 40 �� 90��
 * C ���Է��� D (500) �� M (1000) ����ߣ�����ʾ 400 �� 900��
 * ����һ���������֣�����ת��������������ȷ���� 1 �� 3999 �ķ�Χ�ڡ�
 * <p>
 * ʾ�� 1:
 * <p>
 * ����: "III"
 * ���: 3
 * ʾ�� 2:
 * <p>
 * ����: "IV"
 * ���: 4
 * ʾ�� 3:
 * <p>
 * ����: "IX"
 * ���: 9
 * ʾ�� 4:
 * <p>
 * ����: "LVIII"
 * ���: 58
 * ����: C = 100, L = 50, XXX = 30, III = 3.
 * ʾ�� 5:
 * <p>
 * ����: "MCMXCIV"
 * ���: 1994
 * ����: M = 1000, CM = 900, XC = 90, IV = 4.
 */
public class SolutionRomanToInt {

    /**
     * ���Ŵ������
     * 1.ʹ��toCharArray() ����ַ���Ϊÿ���ַ�
     * 2.ѭ��ÿ���ֶΣ����ַ�ʹ�� switch
     * 3.������й����ж��� +��ֵ ���� -��ֵ
     * ������ I ���Է��� V (5) �� X (10) ����ߣ�����ʾ 4 �� 9��
     * ������ X ���Է��� L (50) �� C (100) ����ߣ�����ʾ 40 �� 90��
     * ������ C ���Է��� D (500) �� M (1000) ����ߣ�����ʾ 400 �� 900��
     */
    class SolutionPre {
        public int romanToInt(String s) {
            char[] chr = s.toCharArray();
            int res = 0;
            for (int i = 0; i < chr.length; i++) {
                switch (chr[i]) {
                    case 'C':
                        if (i + 1 < chr.length) {
                            if (chr[i + 1] == 'D' || chr[i + 1] == 'M') {
                                res -= 100;
                                break;
                            }

                        }
                        res += 100;
                        break;
                    case 'X':
                        if (i + 1 < chr.length) {
                            if (chr[i + 1] == 'L' || chr[i + 1] == 'C') {
                                res -= 10;
                                break;
                            }

                        }
                        res += 10;
                        break;
                    case 'I':
                        if (i + 1 < chr.length) {
                            if (chr[i + 1] == 'V' || chr[i + 1] == 'X') {
                                res -= 1;
                                break;
                            }

                        }
                        res += 1;
                        break;
                    case 'M':
                        res += 1000;
                        break;
                    case 'D':
                        res += 500;
                        break;
                    case 'L':
                        res += 50;
                        break;
                    case 'V':
                        res += 5;
                        break;
                    default:
                        break;
                }
            }
            return res;
        }
    }


    public int romanToInt(String s) {
        int len = s.length();
        String s1 = null;
        int flagNum1 = 0;
        int flagNum2 = 0;
        int flagNum3 = 0;
        Map<String, Integer> map = new HashMap<>();
        int result = 0;
        for (int i = 0; i < len; i++) {
            s1 = s.substring(s.length() - (i + 1), s.length() - i);
            if ("I".equals(s1)) {
                if (flagNum1 > 0) {
                    result--;
                    flagNum1--;
                } else {
                    result += 1;
                }
            } else if ("V".equals(s1)) {
                result += 5;
                flagNum1++;
            } else if ("X".equals(s1)) {
                if (flagNum2 > 0) {
                    result -= 10;
                    flagNum2--;
                } else {
                    result += 10;
                }
                flagNum1++;
            } else if ("L".equals(s1)) {
                result += 50;
                flagNum2++;
            } else if ("C".equals(s1)) {
                if (flagNum3 > 0) {
                    result -= 100;
                    flagNum3--;
                } else {
                    result += 100;
                }
                flagNum2++;
            } else if ("D".equals(s1)) {
                result += 500;
                flagNum3++;
            } else if ("M".equals(s1)) {
                result += 1000;
                flagNum3++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new SolutionRomanToInt().romanToInt("LVIII"));
    }
}
