package com.algorithm.easy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by TangZz on 2018/10/22.
 * <p>
 * ����һ���ַ�������֤���Ƿ��ǻ��Ĵ���ֻ������ĸ�������ַ������Ժ�����ĸ�Ĵ�Сд��
 * <p>
 * ˵���������У����ǽ����ַ�������Ϊ��Ч�Ļ��Ĵ���
 * <p>
 * ʾ�� 1:
 * <p>
 * ����: "A man, a plan, a canal: Panama"
 * ���: true
 * ʾ�� 2:
 * <p>
 * ����: "race a car"
 * ���: false
 */
public class IsPalindrome_125 {


    /**
     * ���Ŵ������
     * 1.ͷβ2��ָ�룬����ɨ��
     * 2.����������ֺ�Ӣ�ģ�����һ��
     * 3.������ǣ���Ƚ�ֵ�Ƿ���ͬ
     * @param s
     * @return
     */
    public boolean isPalindromePre(String s) {
        if(s == "")
            return true;
        char[] c = s.toCharArray();
        int low = 0;
        int high = c.length - 1;
        while(low < high){
            if(!((c[low] <= 57 && c[low] >= 48) || (c[low] <= 90 && c[low] >= 65) || (c[low] <= 122 && c[low] >= 97))){
                low++;
                continue;
            }
            if(!((c[high] <= 57 && c[high] >= 48) || (c[high] <= 90 && c[high] >= 65) || (c[high] <= 122 && c[high] >= 97)))             {
                high--;
                continue;
            }
            if(!(c[low] == c[high] || (c[low] <= 90 && c[low] >= 65 && c[low] + 32 == c[high]) || (c[high] <= 90 && c[high] >= 65 && c[high] + 32 == c[low])))
                return false;
            low++;
            high--;
        }
        return true;
    }



    public boolean isPalindrome(String s) {
        if (null == s) {
            return false;
        }
        if ("".equals(s)) {
            return true;
        }
        StringBuffer s1 = new StringBuffer();
        StringBuffer s2 = new StringBuffer();
        char[] chars = s.trim().toUpperCase().toCharArray();
        int leng = chars.length;
        for (int i = 0; i < leng; i++) {
            if ((chars[i] >= 48 && chars[i] <= 57) || (chars[i] >= 65 && chars[i] <= 90) || (chars[i] >= 99 && chars[i] <= 122)) {
                s1.append(chars[i]);
            }
            if ((chars[leng - 1 - i] >= 48 && chars[leng - 1 - i] <= 57) || (chars[leng - 1 - i] >= 65 && chars[leng - 1 - i] <= 90) || (chars[leng - 1 - i] >= 99 && chars[leng - 1 - i] <= 122)) {
                s2.append(chars[leng - 1 - i]);
            }
        }
        if(s1.toString().equals(s2.toString())){
            return true;
        }else{
            return false;
        }
       /* Pattern pattern = Pattern.compile("[^A-Za-z0-9]");
        Matcher matcher = pattern.matcher(s.trim().toUpperCase());
        s = matcher.replaceAll("");
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            if (chars[i] != chars[chars.length - 1 - i]) {
                return false;
            }
        }
        return true;*/
    }

    public static void main(String[] args) {
        //0~9 48~57
        //A~Z 65~90
        //a~z 99~122
    /*    System.out.println('1' + 0);
        System.out.println('9' + 0);
        System.out.println('0' + 0);
        System.out.println('A' + 0);
        System.out.println('Z' + 0);
        System.out.println('a' + 0);
        System.out.println('z' + 0);*/
        System.out.println(new IsPalindrome_125().isPalindrome("A man, a plan, a canal: Panama"));
    }
}
