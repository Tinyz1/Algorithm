package com.algorithm.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by TangZz on 2018/4/30.
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 * <p>
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 * <p>
 * 输入: "{[]}"
 * 输出: true
 */
public class IsValid {


    /**
     * 最优代码分析
     */
    public boolean isValidPre(String s) {
        char[] symbol = s.toCharArray();
        int len = symbol.length;
        if (len % 2 != 0) return false;

        //遇到左括号就放入数组，右括号就删除元素，数组长度不能减半，会出现全部左括号的情况
        char[] arr = new char[len];
        int cIndex = 0;
        for (char c : symbol) {
            if (c == '(' || c == '[' || c == '{') {
                //左括号压入数组
                arr[cIndex] = c;
                cIndex++;
            } else {
                cIndex -= 1;
                if (cIndex < 0)
                    return false;
                boolean flag = check(arr[cIndex], c);
                if (!flag)
                    return false;//
            }
        }
        return cIndex == 0;
    }


    //判断两个字符符号是否一对
    private boolean check(char a, char b) {
        return (a == '(' && b == ')') || (a == '[' && b == ']') || (a == '{' && b == '}');
    }

    public boolean isValid(String s) {
        if (null == s || s.length() == 1) {
            return false;
        }
        if ("".equals(s)) {
            return true;
        }
        Stack<Character> check = new Stack<>();
        char ch[] = s.toCharArray();
        for (int c = 0; c < s.length(); c++) {
            switch (ch[c]) {
                case '(':
                    check.push('(');
                    break;
                case ')':
                    if (check.empty() || check.pop() != '(') {
                        return false;
                    }
                    break;
                case '[':
                    check.push('[');
                    break;
                case ']':
                    if (check.empty() || check.pop() != '[') {
                        return false;
                    }
                    break;
                case '{':
                    check.push('{');
                    break;
                case '}':
                    if (check.empty() || check.pop() != '{') {
                        return false;
                    }
                    break;
                default:
                    break;
            }
        }
        return check.empty() ? true : false;
    }


    public static void main(String[] args) {
        System.out.println(new IsValid().isValid(""));
        System.out.println(new IsValid().isValid("()"));
        System.out.println(new IsValid().isValid("()[]{}"));
        System.out.println(new IsValid().isValid("[()]"));
        System.out.println(new IsValid().isValid("([)]"));
        System.out.println(new IsValid().isValid("){"));
        System.out.println(new IsValid().isValid("({}[]{()})"));

    }
}
