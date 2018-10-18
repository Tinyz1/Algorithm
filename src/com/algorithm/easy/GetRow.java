package com.algorithm.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by TangZz on 2018/10/18.
 * <p>
 * ����һ���Ǹ����� k������ k �� 33������������ǵĵ� k �С�
 * <p>
 * <p>
 * <p>
 * ����������У�ÿ�����������Ϸ������Ϸ������ĺ͡�
 * <p>
 * ʾ��:
 * <p>
 * ����: 3
 * ���: [1,3,3,1]
 * ���ף�
 * <p>
 * ������Ż�����㷨�� O(k) �ռ临�Ӷ���
 */
public class GetRow {


    /**
     * ���Ŵ������
     * ����ѭ����Ȼ������ÿһ��list�е�ֵ
     * �����ǣ�
     * ��һ��ֵ = ��ǰֵ * ������ - �ڼ����� / (�ڼ���+1) �����ʽ����ô����
     */

    public List<Integer> getRowPre(int rowIndex) {
        long temp = 1;
        List<Integer> row = new LinkedList<>();
        for (int i = 0; i <= rowIndex; i++) {
            row.add((int) temp);
            temp = temp * (rowIndex - i) / (i + 1);
        }
        return row;
    }


    public List<Integer> getRowSlow(int rowIndex) {
        Integer[] result = new Integer[rowIndex + 1];
        Arrays.fill(result, 0);
        result[0] = 1;
        for(int i = 1; i <= rowIndex; i++) {
            for(int j = i; j > 0; j--) {
                result[j] = result[j] + result[j - 1];
            }
        }
        return Arrays.asList(result);
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> rowList = new ArrayList<>();
        Long number = new Long(1);
        for (int j = 0; j <= rowIndex; j++) {
            rowList.add(number.intValue());
            number = number * (rowIndex - j) / (j + 1);
        }
        return rowList;
    }

    public static void main(String[] args) {

    }
}
