package com.algorithm.easy;

/**
 * Created by TangZz on 2018/5/7.
 * ����һ�����������һ��Ŀ��ֵ�����������ҵ�Ŀ��ֵ�������������������Ŀ��ֵ�������������У����������ᱻ��˳������λ�á�
 * <p>
 * ����Լ������������ظ�Ԫ�ء�
 * <p>
 * ʾ�� 1:
 * <p>
 * ����: [1,3,5,6], 5
 * ���: 2
 * ʾ�� 2:
 * <p>
 * ����: [1,3,5,6], 2
 * ���: 1
 * ʾ�� 3:
 * <p>
 * ����: [1,3,5,6], 7
 * ���: 4
 * ʾ�� 4:
 * <p>
 * ����: [1,3,5,6], 0
 * ���: 0
 */
public class SearchInsert {

    /**
     * ���Ŵ������  ���ַ�����
     * ͨ�����ַ��ҵ���target��ֵ��ӽ���2������������ȵ���
     * ���жϴ�С����λ��
     */
    public int searchInsertPre(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right - 1) {
            int middle = (left + right) / 2;
            int cmp = nums[middle] - target;
            if (cmp < 0) {
                left = middle + 1;
            } else if (cmp > 0) {
                right = middle - 1;
            } else {
                return middle;
            }
        }
        if (nums[left] > target) {
            return left;
        } else if (nums[right] < target) {
            return right + 1;
        } else if (nums[left] == target) {
            return left;
        } else {
            return right;
        }
    }

    public int searchInsert(int[] nums, int target) {
        if (null == nums || 0 == nums.length) {
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) {
                return i;
            } else if (target > nums[i] && i + 1 < nums.length && target < nums[i + 1]) {
                return i + 1;
            } else if (target < nums[0]) {
                return 0;
            }
            //�����Ч��ѭ���ڲ�
/*            if (target == nums[i]) {
                return i;
            }
            if (target > nums[i]) {
                return i + 1;
            } */
        }
        return nums.length;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3, 5, 6};
        int[] nums2 = {1, 3, 5, 6};
        int[] nums3 = {1, 3, 5, 6};
        int[] nums4 = {1, 3, 5, 6};
        System.out.println(new SearchInsert().searchInsert(nums1, 5));
        System.out.println(new SearchInsert().searchInsert(nums2, 2));
        System.out.println(new SearchInsert().searchInsert(nums3, 7));
        System.out.println(new SearchInsert().searchInsert(nums4, 0));

    }
}
