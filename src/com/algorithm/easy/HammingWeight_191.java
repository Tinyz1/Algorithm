package com.algorithm.easy;

/**
 * 191. λ1�ĸ���
 * ��дһ��������������һ���޷�������������������Ʊ��ʽ������λ��Ϊ ��1��?�ĸ�����Ҳ����Ϊ������������
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺00000000000000000000000000001011
 * �����3
 * ���ͣ�����Ķ����ƴ� 00000000000000000000000000001011?�У�������λΪ '1'��
 * ʾ�� 2��
 * <p>
 * ���룺00000000000000000000000010000000
 * �����1
 * ���ͣ�����Ķ����ƴ� 00000000000000000000000010000000?�У�����һλΪ '1'��
 * ʾ�� 3��
 * <p>
 * ���룺11111111111111111111111111111101
 * �����31
 * ���ͣ�����Ķ����ƴ� 11111111111111111111111111111101 �У����� 31 λΪ '1'��
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * ��ע�⣬��ĳЩ���ԣ��� Java���У�û���޷����������͡�����������£���������������ָ��Ϊ�з����������ͣ����Ҳ�ӦӰ������ʵ�֣���Ϊ�����������з��ŵĻ����޷��ŵģ����ڲ��Ķ����Ʊ�ʾ��ʽ������ͬ�ġ�
 * �� Java �У�������ʹ�ö����Ʋ���Ƿ�����ʾ�з�����������ˣ��������?ʾ�� 3?�У������ʾ�з������� -3��
 * ?
 * <p>
 */
public class HammingWeight_191 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result += n & 1;
            n = n >> 1;
        }
        return result;
    }


    /*
        ��С�ڴ棬
        �����¸�ֵN,ֱ����λi
     */
    public int hammingWeightMin(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if (((n >> i) & 1) == 1)
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new HammingWeight_191().hammingWeight(3));
        System.out.println(new HammingWeight_191().hammingWeight(1));
        System.out.println(new HammingWeight_191().hammingWeight(-3));


    }
}
