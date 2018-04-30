package com.algorithm.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by TangZz on 2018/4/30.
 * ����һ��ֻ���� '('��')'��'{'��'}'��'['��']' ���ַ������ж��ַ����Ƿ���Ч��
 * <p>
 * ��Ч�ַ��������㣺
 * <p>
 * �����ű�������ͬ���͵������űպϡ�
 * �����ű�������ȷ��˳��պϡ�
 * ע����ַ����ɱ���Ϊ����Ч�ַ�����
 * <p>
 * ʾ�� 1:
 * <p>
 * ����: "()"
 * ���: true
 * ʾ�� 2:
 * <p>
 * ����: "()[]{}"
 * ���: true
 * ʾ�� 3:
 * <p>
 * ����: "(]"
 * ���: false
 * ʾ�� 4:
 * <p>
 * ����: "([)]"
 * ���: false
 * ʾ�� 5:
 * <p>
 * ����: "{[]}"
 * ���: true
 */
public class IsValid {


    /**
     * ���Ŵ������
     */
    public boolean isValidPre(String s) {
        char[] symbol = s.toCharArray();
        int len = symbol.length;
        if (len % 2 != 0) return false;

        //���������žͷ������飬�����ž�ɾ��Ԫ�أ����鳤�Ȳ��ܼ��룬�����ȫ�������ŵ����
        char[] arr = new char[len];
        int cIndex = 0;
        for (char c : symbol) {
            if (c == '(' || c == '[' || c == '{') {
                //������ѹ������
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


    //�ж������ַ������Ƿ�һ��
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
