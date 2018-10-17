package com.algorithm.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by TangZz on 2018/10/17.
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * <p>
 * <p>
 * <p>
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * <p>
 * 示例:
 * <p>
 * 输入: 5
 * 输出:
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
     * 最有代码分析
     * 1.找出杨辉三角的具体公式，直接计算
     */
    public List<List<Integer>> generatePre(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            int number = 1;
            List<Integer> rowList = new ArrayList<>();
            //打印空格字符串
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
