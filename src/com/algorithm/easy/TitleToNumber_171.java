package com.algorithm.easy;


/**Excel表列序号
 * 给定一个Excel表格中的列名称，返回其相应的列序号。
 * <p>
 * 例如，
 * <p>
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 * 示例 1:
 * <p>
 * 输入: "A"
 * 输出: 1
 * 示例?2:
 * <p>
 * 输入: "AB"
 * 输出: 28
 * 示例?3:
 * <p>
 * 输入: "ZY"
 * 输出: 701
 * <p>
 */
public class TitleToNumber_171 {

    /*
    最优解-内存最小
        循环获取数据，
        第一位数据*26+下一位数据
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
