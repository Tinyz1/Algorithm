package com.algorithm.easy;

/**
 * Created by TangZz on 2018/5/7.
 * ʵ�� strStr() ������
 * <p>
 * ����һ�� haystack �ַ�����һ�� needle �ַ������� haystack �ַ������ҳ� needle �ַ������ֵĵ�һ��λ�� (��0��ʼ)����������ڣ��򷵻�  -1��
 * <p>
 * ʾ�� 1:
 * <p>
 * ����: haystack = "hello", needle = "ll"
 * ���: 2
 * ʾ�� 2:
 * <p>
 * ����: haystack = "aaaaa", needle = "bba"
 * ���: -1
 * ˵��:
 * <p>
 * �� needle �ǿ��ַ���ʱ������Ӧ������ʲôֵ�أ�����һ���������кܺõ����⡣
 * <p>
 * ���ڱ�����ԣ��� needle �ǿ��ַ���ʱ����Ӧ������ 0 ������C���Ե� strstr() �Լ� Java�� indexOf() ���������
 */
public class StrStr {

    /**
     * ��������Ŵ��붼��ͨ��indexOfʵ�ֵ�
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
