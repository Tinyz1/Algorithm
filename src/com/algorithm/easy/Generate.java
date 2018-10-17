package com.algorithm.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by TangZz on 2018/10/17.
 * ����һ���Ǹ����� numRows������������ǵ�ǰ numRows �С�
 * <p>
 * <p>
 * <p>
 * ����������У�ÿ�����������Ϸ������Ϸ������ĺ͡�
 * <p>
 * ʾ��:
 * <p>
 * ����: 5
 * ���:
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 */
public class Generate {

    /**
     * ���д������
     * 1.�ҳ�������ǵľ��幫ʽ��ֱ�Ӽ���
     */
    public List<List<Integer>> generatePre(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            int number = 1;
            List<Integer> rowList = new ArrayList<>();
            //��ӡ�ո��ַ���
            //System.out.format("%"+(numRows-i)*2+"s","");
            for (int j = 0; j <= i; j++) {
                //System.out.format("%4d",number);
                rowList.add(number);
                number = number * (i - j) / (j + 1);
            }
            res.add(rowList);
            //System.out.println();
        }
        return res;
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        for (int i = 1; i <= numRows; i++) {
            if (i == 1) {
                list.add(1);
                result.add(list);
            } else {
                list = nextList(result, list);
            }
        }
        return result;
    }

    public List<Integer> nextList(List<List<Integer>> result, List<Integer> list) {
        List<Integer> nextList = new LinkedList<>();
        for (int i = 0; i <= list.size(); i++) {
            if (i == 0 || i == list.size()) {
                nextList.add(1);
            } else {
                nextList.add(list.get(i - 1) + list.get(i));
            }
        }
        result.add(nextList);
        return nextList;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = new Generate().generate(6);
        for (List<Integer> res : result) {
            for (Integer r : res) {
                System.out.print(r + ",");
            }
            System.out.println("");
        }
    }

}
