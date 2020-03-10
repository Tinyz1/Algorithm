package com.algorithm.easy;

/**两数之和 II - 输入有序数组
 * 给定一个已按照升序排列?的有序数组，找到两个数使得它们相加之和等于目标数。
 * <p>
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1?必须小于?index2。
 * <p>
 * 说明:
 * <p>
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * 示例:
 * <p>
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 * <p>
 */


public class TwoSum_167 {

    //内存占用最少-优化变量声明部分
    public int[] twoSumMin(int[] numbers, int target) {
        int[] index=new int[2];
        for(int i=0;i<numbers.length-1;i++){
            for(int j=i+1;j<numbers.length;j++){
                if(numbers[i]+numbers[j]==target&&i<j){
                    index[0]=i+1;
                    index[1]=j+1;
                    return index;
                }
            }
        }
        return index;
    }


    //耗时最少-优化下结果赋值部分
    public int[] twoSumFast(int[] numbers, int target) {
        int[] ret = new int[2];
        int low = 0;
        int high = numbers.length - 1;
        while(low < high) {
            if(numbers[low] + numbers[high] > target) {
                high--;
            }
            else if(numbers[low] + numbers[high] < target) {
                low++;
            }
            else if(numbers[low] + numbers[high] == target) {
                ret[0] = low + 1;
                ret[1] = high + 1;
                return ret;
            }
        }
        return ret;
    }

    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            if ((numbers[i] + numbers[j]) < target) {
                i++;
            } else if ((numbers[i] + numbers[j]) > target) {
                j--;
            } else if ((numbers[i] + numbers[j]) == target) {
                break;
            }
        }
        int[] results = new int[2];
        results[0] = i + 1;
        results[1] = j + 1;
        return results;
    }

    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        int[] results = new TwoSum_167().twoSum(numbers, 9);
        for(int r:results){
            System.out.println(r);
        }

    }
}
