package com.algorithm.easy;

/**
 * Created by TangZz on 2018/4/27.
 * ��дһ�������������ַ��������е������ǰ׺��
 * <p>
 * ��������ڹ���ǰ׺�����ؿ��ַ��� ""��
 * <p>
 * ʾ�� 1:
 * <p>
 * ����: ["flower","flow","flight"]
 * ���: "fl"
 * ʾ�� 2:
 * <p>
 * ����: ["dog","racecar","car"]
 * ���: ""
 * ����: ���벻���ڹ���ǰ׺��
 * ˵��:
 * <p>
 * ��������ֻ����Сд��ĸ a-z ��
 */
public class LongestCommonPrefix {


    /**
     * ���Ŵ������
     * @param strs
     * @return
     */
    public String longestCommonPrefixPre(String[] strs) {
        if (null == strs || strs.length < 1) {
            return "";
        } else if (strs.length == 1) {
            return strs[0];
        }
        // orz Ĥ�ݴ���
        /*�����ʱ����һ��Ԫ��*/
        int i = 1;
        String pre = strs[0];/*ȡ��һ��Ԫ����Ϊ�Ƚ���*/
        while (i < strs.length) /*�������������1��ʱ�����Ҫ�Ƚ�*/ {
            while (strs[i].indexOf(pre) != 0) /*���Ƚ��� ���� ��ͷ */
                pre = pre.substring(0, pre.length() - 1);/*��ȡ -1�Ĳ��� ���һֱ���ǣ����ǽ�ȡ��""�մ����մ�һ���ǿ�ͷ������*/
            i++; /*��һ������Ƚ�*/
        }
        return pre;
    }


    public String longestCommonPrefix(String[] strs) {
        String pubStr = "";
        String nextStr = "";
        if (strs.length == 0) {

        } else if (strs.length == 1) {
            pubStr = strs[0];
        } else {
            for (int i = 1; i < strs.length; i++) {
                if (i == 1) {
                    pubStr = strs[0];

                    nextStr = strs[1];
                } else {
                    nextStr = strs[i];
                }
                while (pubStr.length() > 0) {
                    if (0 != nextStr.indexOf(pubStr)) {
                        pubStr = pubStr.substring(0, pubStr.length() - 1);
                    } else {
                        break;
                    }
                }
                if ("".equals(pubStr)) {
                    break;
                }
            }
        }
        return pubStr;
    }

    public static void main(String[] args) {
        System.out.println(
                new LongestCommonPrefix().longestCommonPrefix(
                        new String[]{
                                "a"
                        }
                )
        );
        System.out.println(
                new LongestCommonPrefix().longestCommonPrefix(
                        new String[]{
                        }
                )
        );
        System.out.println(
                new LongestCommonPrefix().longestCommonPrefix(
                        new String[]{
                                "flower", "flow", "flight"
                        }
                )
        );
        System.out.println(
                new LongestCommonPrefix().longestCommonPrefix(
                        new String[]{
                                "c", "acc", "ccc"
                        }
                )
        );

    }

}
