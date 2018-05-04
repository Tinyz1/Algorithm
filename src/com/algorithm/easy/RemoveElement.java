package com.algorithm.easy;

/**
 * Created by TangZz on 2018/5/4.
 * ����һ������ nums ��һ��ֵ val������Ҫԭ���Ƴ�������ֵ���� val ��Ԫ�أ������Ƴ���������³��ȡ�
 * <p>
 * ��Ҫʹ�ö��������ռ䣬�������ԭ���޸��������鲢��ʹ�� O(1) ����ռ����������ɡ�
 * <p>
 * Ԫ�ص�˳����Ըı䡣�㲻��Ҫ���������г����³��Ⱥ����Ԫ�ء�
 * <p>
 * ʾ�� 1:
 * <p>
 * ���� nums = [3,2,2,3], val = 3,
 * <p>
 * ����Ӧ�÷����µĳ��� 2, ���� nums �е�ǰ����Ԫ�ؾ�Ϊ 2��
 * <p>
 * �㲻��Ҫ���������г����³��Ⱥ����Ԫ�ء�
 * ʾ�� 2:
 * <p>
 * ���� nums = [0,1,2,2,3,0,4,2], val = 2,
 * <p>
 * ����Ӧ�÷����µĳ��� 5, ���� nums �е�ǰ���Ԫ��Ϊ 0, 1, 3, 0, 4��
 * <p>
 * ע�������Ԫ�ؿ�Ϊ����˳��
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
 * int len = removeElement(nums, val);
 * <p>
 * // �ں������޸�����������ڵ������ǿɼ��ġ�
 * // ������ĺ������صĳ���, �����ӡ�������иó��ȷ�Χ�ڵ�����Ԫ�ء�
 * for (int i = 0; i < len; i++) {
 * print(nums[i]);
 * }
 */
public class RemoveElement {


    /**
     * ���Ŵ������
     * 1.��ʼ���������±�
     * 2.������е����ݺ�ָ����ֵ��ͬ�������¶���������
     */
    public int removeElementPre(int[] nums, int val) {
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[len++] = nums[i];
            }
        }
        return len;
    }

    public int removeElement(int[] nums, int val) {
        if (null == nums || 0 == nums.length) {
            return 0;
        } else {
            int index = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != val) {
                    nums[index++] = nums[i];
                }
            }
            return index;
            //֮ǰ��index-- ,����֮����-- ûʲô�ã������Ӵ����ʱ������
        }
    }

    public static void main(String[] args) {
//        int nums[] ={0,1,4,2,5,2,5,1,3,4,5,5,4,6,6,8,9,4,3};
        int nums[] = {5, 4, 3, 5, 2, 1};
        int val = 5;
        int result = new RemoveElement().removeElement(nums, val);
        System.out.println(result);
        for (int i = 0; i < result; i++) {
            System.out.println(nums[i]);
        }
    }
}
