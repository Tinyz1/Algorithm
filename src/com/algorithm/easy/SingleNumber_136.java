package com.algorithm.easy;

/**
 * Created by TangZz on 2018/10/23.
 * <p>
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * <p>
 * 说明：
 * <p>
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入: [4,1,2,1,2]
 * 输出: 4
 */
public class SingleNumber_136 {

    /**
     * 最优代码分析
     * 1.使用异或这个预算符
     * 2.两个相同的数异或结果为0，.一个数跟0异或是这个数本身
     * 3.主要公式   a = b^a^b ,所以数组中出现2次的数据，异或之还是原有的值，只要把整个数组异或，拿到的就是中只出现一次的值
     */
    public int singleNumberPre(int[] nums) {
        //两个相同的数异或结果为0，一个数跟0异或是这个数本身
        int test = 0;
        for ( int i = nums.length -1 ; i >= 0; --i) {
            test ^= nums[i];
        }
        return test;
    }

    public int singleNumber(int[] nums) {
        boolean flag ;
        for (int i = 0; i < nums.length; i++) {
            flag = true;
            for (int j = 0; j < nums.length; j++) {
                if (i != j && nums[i] == nums[j]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return nums[i];
            }
        }
        return 0;
    }


    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(new SingleNumber_136().singleNumber(nums));
    }
}
