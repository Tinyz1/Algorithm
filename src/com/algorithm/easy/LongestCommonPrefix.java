package com.algorithm.easy;

/**
 * Created by TangZz on 2018/4/27.
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * <p>
 * 所有输入只包含小写字母 a-z 。
 */
public class LongestCommonPrefix {


    /**
     * 最优代码分析
     * @param strs
     * @return
     */
    public String longestCommonPrefixPre(String[] strs) {
        if (null == strs || strs.length < 1) {
            return "";
        } else if (strs.length == 1) {
            return strs[0];
        }
        // orz 膜拜大神
        /*数组此时最少一个元素*/
        int i = 1;
        String pre = strs[0];/*取第一个元素作为比较体*/
        while (i < strs.length) /*当数组个数大于1的时候才需要比较*/ {
            while (strs[i].indexOf(pre) != 0) /*当比较体 不是 开头 */
                pre = pre.substring(0, pre.length() - 1);/*截取 -1的部分 如果一直不是，就是截取到""空串，空串一定是开头，跳出*/
            i++; /*下一个对象比较*/
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
