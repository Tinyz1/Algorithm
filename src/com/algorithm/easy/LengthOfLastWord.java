package com.algorithm.easy;

/**
 * Created by TangZz on 2018/5/9.
 * ����һ����������Сд��ĸ�Ϳո� ' ' ���ַ��������������һ�����ʵĳ��ȡ�
 * <p>
 * ������������һ�����ʣ��뷵�� 0 ��
 * <p>
 * ˵����һ��������ָ����ĸ��ɣ����������κοո���ַ�����
 * <p>
 * ʾ��:
 * <p>
 * ����: "Hello World"
 * ���: 5
 */
public class LengthOfLastWord {

    /**
     * ���д������
     * 1.�ж��Ƿ񳤶�Ϊ��
     * 2.���û�пո��򷵻س���-1
     * 3.�����ʼ���ҵ�һ���ո�Ȼ�󷵻��ַ�����
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
