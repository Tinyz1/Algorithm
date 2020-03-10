package com.algorithm.easy;

/**����֮�� II - ������������
 * ����һ���Ѱ�����������?���������飬�ҵ�������ʹ���������֮�͵���Ŀ������
 * <p>
 * ����Ӧ�÷����������±�ֵ index1 �� index2������ index1?����С��?index2��
 * <p>
 * ˵��:
 * <p>
 * ���ص��±�ֵ��index1 �� index2�����Ǵ��㿪ʼ�ġ�
 * ����Լ���ÿ������ֻ��ӦΨһ�Ĵ𰸣������㲻�����ظ�ʹ����ͬ��Ԫ�ء�
 * ʾ��:
 * <p>
 * ����: numbers = [2, 7, 11, 15], target = 9
 * ���: [1,2]
 * ����: 2 �� 7 ֮�͵���Ŀ���� 9 ����� index1 = 1, index2 = 2 ��
 * <p>
 */


public class TwoSum_167 {

    //�ڴ�ռ������-�Ż�������������
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


    //��ʱ����-�Ż��½����ֵ����
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
