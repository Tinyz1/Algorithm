package com.algorithm.easy;

/**
 * Created by TangZz on 2018/8/16.
 * <p>
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * <p>
 * 说明:
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 示例:
 * <p>
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * 输出: [1,2,2,3,5,6]
 */
public class Merge {


    /**
     * 最优代码分析
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
