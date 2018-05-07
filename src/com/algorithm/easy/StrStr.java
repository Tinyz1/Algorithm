package com.algorithm.easy;

/**
 * Created by TangZz on 2018/5/7.
 * 实现 strStr() 函数。
 * <p>
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 * <p>
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * <p>
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 */
public class StrStr {

    /**
     * 这个的最优代码都是通过indexOf实现的
     */
    public int strStrPre(String haystack, String needle) {
        char[] source = haystack.toCharArray();
        int sourceOffset = 0;
        int sourceCount = source.length;
        char[] target = needle.toCharArray();
        int targetOffset = 0;
        int targetCount = target.length;
        int fromIndex = 0;

        if (fromIndex >= sourceCount) {
            return (targetCount == 0 ? sourceCount : -1);
        }
        if (fromIndex < 0) {
            fromIndex = 0;
        }
        if (targetCount == 0) {
            return fromIndex;
        }

        char first = target[targetOffset];
        int max = sourceOffset + (sourceCount - targetCount);

        for (int i = sourceOffset + fromIndex; i <= max; i++) {
            /* Look for first character. */
            if (source[i] != first) {
                while (++i <= max && source[i] != first) ;
            }

            /* Found first character, now look at the rest of v2 */
            if (i <= max) {
                int j = i + 1;
                int end = j + targetCount - 1;
                for (int k = targetOffset + 1; j < end && source[j]
                        == target[k]; j++, k++)
                    ;

                if (j == end) {
                    /* Found whole string. */
                    return i - sourceOffset;
                }
            }
        }
        return -1;
    }


    public int strStr(String haystack, String needle) {
        if (null == haystack || null == needle) {
            return -1;
        }
        if ("".equals(needle)) {
            return 0;
        }
        char[] hchars = haystack.toCharArray();
        char[] nChars = needle.toCharArray();
        boolean flag = true;
        for (int i = 0; i < hchars.length; i++) {
            if (hchars.length - i >= nChars.length) {
                flag = true;
                for (int j = 0; j < nChars.length; j++) {
                    if (hchars[i + j] != nChars[j]) {
                        flag = false;
                        break;
                    }
                }
                if (!flag) {
                    continue;
                } else {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("hello".indexOf("lll"));
        System.out.println(new StrStr().strStr("hello", null));
        System.out.println(new StrStr().strStr("hello", ""));
        System.out.println(new StrStr().strStr("hello", "ll"));
        System.out.println(new StrStr().strStr("hello", "ll0f"));
        System.out.println(new StrStr().strStr("a", "a"));
    }
}
