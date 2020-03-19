package com.algorithm.easy;

/**
 * 189. ��ת����
 * ����һ�����飬�������е�Ԫ�������ƶ� k ��λ�ã����� k �ǷǸ�����
 * <p>
 * ʾ�� 1:
 * <p>
 * ����: [1,2,3,4,5,6,7] �� k = 3
 * ���: [5,6,7,1,2,3,4]
 * ����:
 * ������ת 1 ��: [7,1,2,3,4,5,6]
 * ������ת 2 ��: [6,7,1,2,3,4,5]
 * ������ת 3 ��: [5,6,7,1,2,3,4]
 * ʾ�� 2:
 * <p>
 * ����: [-1,-100,3,99] �� k = 2
 * ���: [3,99,-1,-100]
 * ����:
 * ������ת 1 ��: [99,-1,-100,3]
 * ������ת 2 ��: [3,99,-1,-100]
 * ˵��:
 * <p>
 * �������������Ľ�����������������ֲ�ͬ�ķ������Խ��������⡣
 * Ҫ��ʹ�ÿռ临�Ӷ�Ϊ O(1) �� ԭ�� �㷨��
 */
public class Rotate_189 {

    /*
���� 1������
��򵥵ķ�������ת k �Σ�ÿ�ν�������ת 1 ��Ԫ�ء�

public class Solution {
    public void rotate(int[] nums, int k) {
        int temp, previous;
        for (int i = 0; i < k; i++) {
            previous = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
    }
}
���Ӷȷ���

ʱ�临�Ӷȣ�O(n*k) ��ÿ��Ԫ�ض����ƶ� 1 ����O(n)�� k�Σ�O(k)�� ��
�ռ临�Ӷȣ�O(1) ��û�ж���ռ䱻ʹ�á�

���� 2��ʹ�ö��������
�㷨
���ǿ�����һ���������������ÿ��Ԫ�طŵ���ȷ��λ���ϣ�Ҳ����ԭ���������±�Ϊ i �����ǰ����ŵ� (i+k)\%���鳤�� ��λ�á�
Ȼ����µ����鿽����ԭ�����С�

public class Solution {
    public void rotate(int[] nums, int k) {
        int[] a = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            a[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = a[i];
        }
    }
}
���Ӷȷ���

ʱ�临�Ӷȣ� O(n) �������ַŵ��µ���������Ҫһ���������һ�������������Ԫ�ؿ�����ԭ���顣
�ռ临�Ӷȣ� O(n)����һ��������Ҫԭ���鳤�ȵĿռ䡣

���� 3��ʹ�û�״�滻
�㷨

�������ֱ�Ӱ�ÿһ�����ַŵ�������λ�ã��������ĺ������ʧԭ����Ԫ�ء�
��ˣ�������Ҫ�ѱ��滻�����ֱ����ڱ��� temp ���档
Ȼ�����ǽ����滻���֣�temp���ŵ�����ȷ��λ�ã�������������� n �Σ� n ������ĳ��ȡ�
������Ϊ������Ҫ�����������е�Ԫ�ض��ƶ���

���ǣ����ַ������ܻ��и����⣬��� n%k==0������ k=k%n ����Ϊ��� k ���� n ���ƶ� k ��ʵ�����൱���ƶ� k%n�Σ���
��������£����ǻᷢ����û�б����������ֵ�����»ص��������֡���ʱ������Ӧ�ô���һ�����ֿ�ʼ���ظ���ͬ�Ĺ��̡�
���ڣ����ǿ������淽����֤�������裬������������ n ��Ԫ�ز��� k ��Ҫ���ƶ��Ĵ���������һ�������� n%k=0 ��
��һ���У������ƶ����ֵ��±� i���� i%k==0��������Ϊ����ÿ�� k ��������ֻ�ᵽ�����Ϊ k ��λ���±������
ÿһ�֣����Ƕ����ƶ� n/k ��Ԫ�ء�
��һ���У����ǻ��ƶ����� i\%k==1 ��λ�õ������������ִλ�һֱ�����������ٴ����� i%k==0 �ĵط�Ϊֹ��
��ʱ i=k����ʱ����ȷλ���ϵ����ֹ��� k * n\k = n��������������ֶ�����ȷλ���ϡ�

�����ǿ�һ�½����������ӣ��Ը��õ�˵��������̣�

nums: [1, 2, 3, 4, 5, 6]
k: 2


public class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }
}
���Ӷȷ���

ʱ�临�Ӷȣ�O(n) ��ֻ������ÿ��Ԫ��һ�Ρ�
�ռ临�Ӷȣ�O(1) ��ʹ���˳���������ռ䡣


���� 4��ʹ�÷�ת
�㷨

����������������ʵ����������ת���� k �Σ� k\%n ��β��Ԫ�ػᱻ�ƶ���ͷ����ʣ�µ�Ԫ�ػᱻ����ƶ���
����������У��������Ƚ�����Ԫ�ط�ת��Ȼ��תǰ k ��Ԫ�أ��ٷ�ת���� n-k ��Ԫ�أ����ܵõ���Ҫ�Ľ����
���� n=7�� k=3 ��

ԭʼ����                  : 1 2 3 4 5 6 7
��ת�������ֺ�             : 7 6 5 4 3 2 1
��תǰ k �����ֺ�          : 5 6 7 4 3 2 1
��ת�� n-k �����ֺ�        : 5 6 7 1 2 3 4 --> ���
public class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
���Ӷȷ���

ʱ�临�Ӷȣ�O(n) �� n ��Ԫ�ر���ת���ܹ� 3 �Ρ�
�ռ临�Ӷȣ�O(1) �� û��ʹ�ö���Ŀռ䡣
     */

    public void rotate(int[] nums, int k) {
        int length = nums.length;
        k = k % length;
        int temp[] = new int[k];
        for (int i = 0; i < k; i++) {
            temp[i] = nums[length - k + i];
        }
        for (int i = length - 1; i >= 0; i--) {
            if (i >= k) {
                nums[i] = nums[i - k];
            } else {
                nums[i] = temp[i];
            }
        }
    }


    public static void main(String[] args) {
        int[] n = {1, 2, 3, 4, 5, 6, 7};
        new Rotate_189().rotate(n, 3);
    }
}
