package com.algorithm.easy;

/**
 * 198. 打家劫舍
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 * ?    偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2:
 * <p>
 * 输入: [2,7,9,3,1]  [20,7,9,30,1]
 * 输出: 12
 * 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 * ?    偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 * <p>
 */
public class Rob198 {


    public int robMin(int[] nums) {
        int preMax = 0;
        int curMax = 0;
        for(int x:nums){
            int temp = curMax;
            curMax = Math.max(preMax + x, curMax);
            preMax = temp;
        }
        return curMax;
    }

    public int robFast(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }
        int[] ans = new int[nums.length];
        ans[0] = nums[0];
        ans[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            ans[i] = Math.max(nums[i] + ans[i - 2], ans[i - 1]);
        }
        return ans[ans.length - 1];
    }

    public int rob(int[] nums) {
        int len = nums.length;
        if (len <= 3) {
            switch (len) {
                case 0:
                    return 0;
                case 1:
                    return nums[0];
                case 2:
                    return nums[0] >= nums[1] ? nums[0] : nums[1];
                case 3:
                    return nums[1] >= nums[0] + nums[2] ? nums[1] : nums[0] + nums[2];
            }
            return 0;
        } else {
            int a = 0;
            int b = 0;
            int c = 0;
            int temp = 0;
            a = nums[0];
            b = nums[1];
            c = nums[0] + nums[2];
            for (int i = 3; i < len; i++) {
                if (a >= b) {
                    temp = c;
                    c = a + nums[i];
                    a = b;
                    b = temp;
                } else {
                    temp = c;
                    c = b + nums[i];
                    a = b;
                    b = temp;
                }
            }
            return a >= b && a >= c ? a : b >= c ? b : c;
        }
    }

    /*
     * 2        3
     *   7      10
     *     11
     * 7        1
     *      10  1
     *   11     1
     * */
    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};
        System.out.println(new Rob198().rob(nums));


    }
}
