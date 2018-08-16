package com.algorithm.easy;

/**
 * Created by TangZz on 2018/8/16.
 * <p>
 * �������������������� nums1 �� nums2���� nums2 �ϲ��� nums1 �У�ʹ�� num1 ��Ϊһ���������顣
 * <p>
 * ˵��:
 * <p>
 * ��ʼ�� nums1 �� nums2 ��Ԫ�������ֱ�Ϊ m �� n��
 * ����Լ��� nums1 ���㹻�Ŀռ䣨�ռ��С���ڻ���� m + n�������� nums2 �е�Ԫ�ء�
 * ʾ��:
 * <p>
 * ����:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * ���: [1,2,2,3,5,6]
 */
public class Merge {


    /**
     * ���Ŵ������
     */
    public void mergePre(int[] nums1, int m, int[] nums2, int n) {
        int pos = 0;
        int[] res = new int[nums1.length];
        int mPos = 0, nPos = 0;
        while (mPos < m || nPos < n) {
            if (mPos < m && nPos < n) {
                if (nums1[mPos] <= nums2[nPos]) {
                    res[pos] = nums1[mPos];
                    pos++;
                    mPos++;
                } else {
                    res[pos] = nums2[nPos];
                    pos++;
                    nPos++;
                }
                continue;
            }
            if (mPos == m) {
                res[pos] = nums2[nPos];
                pos++;
                nPos++;
                continue;
            }
            if (nPos == n) {
                res[pos] = nums1[mPos];
                pos++;
                mPos++;
                continue;
            }
        }

        for (int i = 0; i < m + n; i++) {
            nums1[i] = res[i];
        }
    }


    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
        if (m == 0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }
        if (nums1[m - 1] < nums2[0]) {
            for (int i = 0; i < n; i++) {
                nums1[m + i] = nums2[0 + i];
            }
        }
        int realNums1[] = new int[m + n];
        for (int i = 0; i < m; i++) {
            realNums1[i] = nums1[i];
        }
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < m && j < n) {
            if (realNums1[i] <= nums2[j]) {
                nums1[k] = realNums1[i];
                i++;
                k++;
            } else {
                nums1[k] = nums2[j];
                j++;
                k++;
            }
        }
        while (i < m) {
            nums1[k] = realNums1[i];
            i++;
            k++;
        }
        while (j < n) {
            nums1[k] = nums2[j];
            j++;
            k++;
        }
        for (int out : nums1) {
            System.out.println(out);
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 4, 5, 6, 0};
        int m = 5;
        int[] nums2 = {3};
        int n = 1;
        new Merge().merge(nums1, m, nums2, n);
//        int[] test = nums1;
//        test[1]=10;
//        for (int out : nums1) {
//            System.out.println(out);
//        }


    }
}
