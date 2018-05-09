package com.algorithm.easy;

/**
 * Created by TangZz on 2018/5/9.
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 * <p>
 * 如果不存在最后一个单词，请返回 0 。
 * <p>
 * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
 * <p>
 * 示例:
 * <p>
 * 输入: "Hello World"
 * 输出: 5
 */
public class LengthOfLastWord {

    /**
     * 最有代码分析
     * 1.判断是否长度为空
     * 2.如果没有空格，则返回长度-1
     * 3.从最后开始，找第一个空格，然后返回字符长度
     */
    public int lengthOfLastWordPre(String s) {
        if (s.length() == 0)
            return 0;
        int i = s.length() - 1;
        while (true) {
            if (s.charAt(i) != ' ' || i == 0)
                break;
            i--;
        }
        int j = i;
        while (s.charAt(j) != ' ') {
            if (j == 0) {
                if (s.charAt(0) != ' ')
                    return i + 1 - j;
                break;
            }
            j--;
        }
        return i - j;
    }

    public int lengthOfLastWord(String s) {
        String[] str = s.split(" ");
        return null == str || 0 == str.length ? 0 : str[str.length - 1].length();
    }

    public static void main(String[] args) {
        String str = "    ";
        System.out.println(new LengthOfLastWord().lengthOfLastWord(str));
    }
}
