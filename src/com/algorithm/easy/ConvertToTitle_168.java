package com.algorithm.easy;

/**
 * 168. Excel表列名称
 * 给定一个正整数，返回它在 Excel 表中相对应的列名称。
 * <p>
 * 例如，
 * <p>
 * 1 -> A
 * 2 -> B
 * 3 -> C
 * ...
 * 26 -> Z
 * 27 -> AA
 * 28 -> AB
 * ...
 * 示例 1:
 * <p>
 * 输入: 1
 * 输出: "A"
 * 示例?2:
 * <p>
 * 输入: 28
 * 输出: "AB"
 * 示例?3:
 * <p>
 * 输入: 701
 * 输出: "ZY"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/excel-sheet-column-title
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ConvertToTitle_168 {

    //内存最小-不使用递归，循环实现
    public String convertToTitleMin(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            int c = n % 26;
            if(c == 0){
                c = 26;
                n -= 1;
            }
            sb.insert(0, (char) ('A' + c - 1));//开头插入值
            n /= 26;
        }
        return sb.toString();
    }

    //耗时最少-基本都很快
    public String convertToTitleFast(int n) {
        StringBuffer sb = new StringBuffer();
        while (n > 0) {
            n--;
            char c = (char) ('A'+ n%26);
            n /= 26;
            sb.append(c);
        }
        return sb.reverse().toString();//反转
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
