package com.algorithm.easy;


import java.util.HashMap;

/**
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 [ n/2 ]的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 */
public class MajorityElement_169 {

    //最优解-时间最少
    /*
     * 使用第一个数据去和其他数据比较，
     * 1.相同，则计数+1
     * 2.不相同，则计数-1,
     * 3.当前计数值为0时，则替换当前数据中比较的值
     *  多数元素大于 n/2 ，所以每个不同的数和多数元素毕竟，还是多数元素多
     * */
    public int majorityElementFast(int[] nums) {
        int num = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (num == nums[i]) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    num = nums[i];
                    count++;
                }
            }
        }
        return num;
    }

    //最优解-内存消耗最小
    /*
     * 1.通过HashMap存放数据值
     * 2.判断数量，然后输出符合条件的数据
     */
    public int majorityElementMin(int[] nums) {
        HashMap<Integer, Integer> res = new HashMap();
        int res_num = 0;
        for (int i = 0; i < nums.length; i++) {
            if (res.containsKey(nums[i]))
                res.put(nums[i], res.get(nums[i]) + 1);
            else
                res.put(nums[i], 1);

            if (res.get(nums[i]) > (nums.length / 2)) {
                res_num = nums[i];
                break;
            }
        }
        return res_num;
    }


    public int majorityElement(int[] nums) {
        int length = nums.length;
        int temp = 0;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (nums[i] > nums[j]) {
                    temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        return nums[length / 2];
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 2, 3, 1, 3};
        System.out.println(new MajorityElement_169().majorityElement(nums));
    }

}
