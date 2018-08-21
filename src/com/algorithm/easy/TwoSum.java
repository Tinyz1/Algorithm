package com.algorithm.easy;

/**
 * 2018-04-24
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 * <p>
 * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class TwoSum {


    /*
     * 最优代码分析
     * 1.获取数组中的最大值和最小值
     * 2.比 目标值-最小值（理论最大值） 大的数值 需要排除
     * 3.比 目标值-最大值（理论最小值） 小的数值 需要排除
     * 4.取 最大值 和 理论最大值 中较小的数值 实际最大值
     * 5.取 最小值 和 理论最小值 中较大的数值 实际最小值
     * 6.由于整数数组中数据并不一定是连续的，所以需要找到数值最多就是 实际最大值-实际最小值+1 （最多可能数）这么多个
     * 7.声明一个长度为最大可能数的数组flagNum[],判断是否有符合条件的值
     * ！！！重点！！！
     *  8.循环所有需要判断的数据，并排除小于实际最小值和大于实际最大值的
     *  9.第一条数据就是 实际最小值，有 目标值 - num[i](实际最小值) - 实际最小值 > 0  && < 最多可能数  所以在数组中，最为下标获取的值一定是-1，
     *    在数组中存放数据 num[i](实际最小值) - 实际最小值 = 0 ,falgNum[0] = i（就是实际最小值在整数数组中的下标）
     *  10. 目标值  - num[i] - 实际最小值 最为下标，在flagNum[]中有值，则意味着
     *      目标值 - a(符合条件的值) - 实际最小值 = 目标值 - b(符合条件的值) - 实际最小值
     *      目标值 = a + b
     *      符合条件输出
     */





    public int[] twoSumPre(int[] nums, int target) {
        //第一步：缩小范围，将最大值和最小值的范围缩小
        int maxInNums = Integer.MIN_VALUE;    //找出数组中的最大值
        int minInNums = Integer.MAX_VALUE;    //找出数组中的最小值
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < minInNums)
                minInNums = nums[i];
            if (nums[i] > maxInNums)
                maxInNums = nums[i];
        }

        int maxSecondNum = target - minInNums;    //另一个数的最大值
        int minSecondNum = target - maxInNums;    //另一个数的最小值
        //因为这两个数都是在数组里的，因此我们有
        int maxNum = maxSecondNum > maxInNums ? maxInNums : maxSecondNum;    //最大的数是小于两个上限中最小的数的
        int minNum = minSecondNum < minInNums ? minInNums : minSecondNum;    //最小的数是大于两个下限中最大的数的
        //创建一个容量代表最大值和最小值的数组，为了之后的存储做准备。（因为两个数只有可能是在这个范围之间）
        //并将他的所有值赋值为-1（因为这将进行下标的存储，所以要赋值成为-1）
        int[] flagNum = new int[maxNum - minNum + 1];
        for (int i = 0; i < flagNum.length; i++) {
            flagNum[i] = -1;
        }

        for (int i = 0; i <= nums.length; i++) {
            if (nums[i] >= minNum && nums[i] <= maxNum) {    //首先进行是否在范围内的判断
                if (flagNum[target - nums[i] - minNum] != -1)
                    return new int[]{flagNum[target - nums[i] - minNum], i};
                else
                    flagNum[nums[i] - minNum] = i;
            }
        }
        return new int[]{0, 0};
    }


    public int[] twoSum(int[] nums, int target) {
        int[] result = {0, 0};
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        return result;
    }


    public static void main(String[] args) throws Exception {
        int[] nums = { 2, 3, 5, 7, 10, 11, 15, 22};
        int target = 14;
        int[] result = new TwoSum().twoSumPre(nums, target);
        for (int num : result) {
            System.out.println(num);
        }
    }
}


