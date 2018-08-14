package com.algorithm.easy;

/**
 * Created by TangZz on 2018/6/6.
 * ʵ�� int sqrt(int x) ������
 * <p>
 * ���㲢���� x ��ƽ���������� x �ǷǸ�������
 * <p>
 * ���ڷ������������������ֻ���������Ĳ��֣�С�����ֽ�����ȥ��
 */
public class MySqrt {

    /**
     * ����Int�����ֵ�� 2147483647
     * ����ƽ�������� 46340 * 46340 =  2147395600  Ҳ�������ľ��� 46340
     * �����ʹ�� 46341 * 46341 = -2147479015
     * ��Ҫ�����ڴ���ƽ����ʱ��Ҫ�ж��Ƿ�֧��
     *
     * ͨ�����ַ�����ƽ���� -- ���ַ�������Ŀ찡
     */


    public int mySqrtPre(int x) {
        int low = 0, high = 46341, mid = 0;
        while (low <= high) {
            if (mid == low + (high - low) / 2) {
                return mid;
            }
            mid = low + (high - low) / 2;
            int square = mid * mid;
            if (square == x) {
                return mid;
            } else if (square > x) {
                high = mid;
            } else {
                low = mid;
            }
        }
        return mid;
    }

    public int mySqrt(int x) {
        long result = 0;
        long result1 = result * result;
        while (result1 <= x) {
            result++;
            result1 = result * result;
        }
        return Integer.valueOf((result - 1) + "");
    }


    public static void main(String[] args) {
        int result = new MySqrt().mySqrt(2147395600);
        System.out.println(result);
        System.out.println(new MySqrt().mySqrt(4));
    }
}
