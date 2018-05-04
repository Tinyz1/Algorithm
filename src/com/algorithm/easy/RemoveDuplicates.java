package com.algorithm.easy;

/**
 * Created by TangZz on 2018/5/4.
 * ����һ���������飬����Ҫ��ԭ��ɾ���ظ����ֵ�Ԫ�أ�ʹ��ÿ��Ԫ��ֻ����һ�Σ������Ƴ���������³��ȡ�
 * <p>
 * ��Ҫʹ�ö��������ռ䣬�������ԭ���޸��������鲢��ʹ�� O(1) ����ռ����������ɡ�
 * <p>
 * ʾ�� 1:
 * <p>
 * �������� nums = [1,1,2],
 * <p>
 * ����Ӧ�÷����µĳ��� 2, ����ԭ���� nums ��ǰ����Ԫ�ر��޸�Ϊ 1, 2��
 * <p>
 * �㲻��Ҫ���������г����³��Ⱥ����Ԫ�ء�
 * ʾ�� 2:
 * <p>
 * ���� nums = [0,0,1,1,1,2,2,3,3,4],
 * <p>
 * ����Ӧ�÷����µĳ��� 5, ����ԭ���� nums ��ǰ���Ԫ�ر��޸�Ϊ 0, 1, 2, 3, 4��
 * <p>
 * �㲻��Ҫ���������г����³��Ⱥ����Ԫ�ء�
 * ˵��:
 * <p>
 * Ϊʲô������ֵ��������������Ĵ���������?
 * <p>
 * ��ע�⣬�����������ԡ����á���ʽ���ݵģ�����ζ���ں������޸�����������ڵ������ǿɼ��ġ�
 * <p>
 * ����������ڲ���������:
 * <p>
 * // nums ���ԡ����á���ʽ���ݵġ�Ҳ����˵������ʵ�����κο���
 * int len = removeDuplicates(nums);
 * <p>
 * // �ں������޸�����������ڵ������ǿɼ��ġ�
 * // ������ĺ������صĳ���, �����ӡ�������иó��ȷ�Χ�ڵ�����Ԫ�ء�
 * for (int i = 0; i < len; i++) {
 * print(nums[i]);
 * }
 */
public class RemoveDuplicates {


    /**
     * ���Ŵ������
     * 1.�ж������Ƿ�Ϊnull
     * 2.������ͳ���Ϊ1������ ֱ�ӷ��س���
     * 3.������������±꣬�ж��������±��е�ֵ�Ƿ����һ��ֵ���
     * 4.����Ⱦ͸�ֵ�����������±꣬++index
     * 5.�������鳤�Ⱦ����±�+1��index��0��ʼ��
     */
    public int removeDuplicatesPre(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length <= 1) {
            return nums.length;
        }
        // ��������±�
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[index] != nums[i]) {
                // �����i��Ԫ�غ��������index�����ʱ����Ҫ���±�Ϊi��Ԫ��ֵ�ŵ�������index+1λ��
                nums[++index] = nums[i];
            }
        }
        // ѭ��������������������һ��Ԫ�ص��±�index��so����ĳ���Ϊindex+1
        return index + 1;
    }


    public int removeDuplicates(int[] nums) {
        if (null == nums || nums.length < 1) {
            return 0;
        } else if (1 == nums.length) {
            return 1;
        }
        int num = nums[0];
        int index = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > num) {
                nums[index] = nums[i];
                num = nums[i];
                index++;
            }
        }
        return index--;
    }

    public static void main(String[] args) {
        int[] nums = {};
//        int[] nums = {1};
        System.out.println(new RemoveDuplicates().removeDuplicates(nums));
        for (int num : nums) {
            System.out.println(num);
        }

    }
}
