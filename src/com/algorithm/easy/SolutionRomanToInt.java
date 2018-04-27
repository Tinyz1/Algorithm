package com.algorithm.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by TangZz on 2018/4/27.
 * 罗马数字包含以下七种字符：I， V， X， L，C，D 和 M。
 * <p>
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * <p>
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "III"
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: "IV"
 * 输出: 4
 * 示例 3:
 * <p>
 * 输入: "IX"
 * 输出: 9
 * 示例 4:
 * <p>
 * 输入: "LVIII"
 * 输出: 58
 * 解释: C = 100, L = 50, XXX = 30, III = 3.
 * 示例 5:
 * <p>
 * 输入: "MCMXCIV"
 * 输出: 1994
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 */
public class SolutionRomanToInt {

    /**
     * 最优代码分析
     * 1.使用toCharArray() 拆分字符串为每个字符
     * 2.循环每个字段，对字符使用 switch
     * 3.针对下列规则判断是 +数值 还是 -数值
     * 【规则】 I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
     * 【规则】 X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
     * 【规则】 C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
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
