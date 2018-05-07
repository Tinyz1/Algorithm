package com.algorithm.easy;

/**
 * Created by TangZz on 2018/5/7.
 * 报数序列是指一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 * <p>
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 * <p>
 * 给定一个正整数 n ，输出报数序列的第 n 项。
 * <p>
 * 注意：整数顺序将表示为一个字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1
 * 输出: "1"
 * 示例 2:
 * <p>
 * 输入: 4
 * 输出: "1211"
 */
public class CountAndSay {


    /**
     * 最优代码分析
     * 总的思想还是递归
     * 循环字符串，找这个字符串后面相同的字符串，
     * 如果不相同，则然后输出结果，然后最完成循环直接从不相同的开始
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
