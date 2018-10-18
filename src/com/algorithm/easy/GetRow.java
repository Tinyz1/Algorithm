package com.algorithm.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by TangZz on 2018/10/18.
 * <p>
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 * <p>
 * <p>
 * <p>
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * <p>
 * 示例:
 * <p>
 * 输入: 3
 * 输出: [1,3,3,1]
 * 进阶：
 * <p>
 * 你可以优化你的算法到 O(k) 空间复杂度吗？
 */
public class GetRow {


    /**
     * 最优代码分析
     * 单层循环，然后生成每一个list中的值
     * 问题是：
     * 下一个值 = 当前值 * （行数 - 第几个） / (第几个+1) 这个公式是这么来的
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
