package com.algorithm.easy;

/**
 * �׳˺����
 * ����һ������ n������ n! ���β�������������
 * <p>
 * ʾ�� 1:
 * <p>
 * ����: 3
 * ���: 0
 * ����:?3! = 6, β����û���㡣
 * ʾ��?2:
 * <p>
 * ����: 5
 * ���: 1
 * ����:?5! = 120, β������ 1 ����.
 * ˵��: ���㷨��ʱ�临�Ӷ�ӦΪ?O(log?n)?��
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/factorial-trailing-zeroes
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class TrailingZeroes_172 {

    /*
    ���Ž� ��С�ڴ�
     */
    public int trailingZeroesMin(int n) {
        int count = 0;
        while (n > 0) {
            count += n / 5;
            n = n / 5;
        }
        return count;
    }

    /*
    ���Ž⣬���ִ��
    �������
     */
    public int trailingZeroesFast(int n) {
        int res = 0;
        int tmp = n;
        while (tmp != 0) {
            tmp /= 5;
            res += tmp;
        }
        return res;
    }

    /*
       �ж��������м���5
       ���5�Ľ׳ˣ�����Ҫ���ж�һ�Σ�
       �ж��м���5�����ж��м���25�����ж��м���5^3....����ѭ��

       ���ʣ�
         n/5 + n/5/5   1808548329 ���452137076
5:361709665
25:72341933
125:14468386
625:2893677
3125:578735
15625:115747
78125:23149
390625:4629
1953125:925
9765625:185
48828125:37
244140625:7
1220703125:1   �������У�����˷�ʱ��int�������׳�����  2^32 = 4294967296   ����*5��ʱ���������
1808548329:1
452807053:3
-2030932031:0
-1564725563:-1
766306777:2
-463433411:-3
452137078


5:361709665
25:72341933
125:14468386
625:2893677
3125:578735
15625:115747
78125:23149
390625:4629
1953125:925
9765625:185
48828125:37
244140625:7
1220703125:1  �޸ĳ�long �Ͷ���

1808548329:361709665
361709665:72341933
72341933:14468386
14468386:2893677
2893677:578735
578735:115747
115747:23149
23149:4629
4629:925
925:185
185:37
37:7
7:1
     */
    public int trailingZeroes(int n) {
        int result = 0;
        while (n >= 5) {
            result += n / 5;
//            System.out.println(n+":"+n / 5);
            n /= 5;

        }
        return result;
    }


    public int trailingZeroesError(int n) {
       /* int result = 0;
        int temp = 5;
        while (n >= temp) {
            result += n / temp;
            System.out.println(temp+":"+n / temp);
            temp *= 5;
        }
        return result;*/
        int result = 0;
        long temp = 5;
        while (n >= temp) {
            result += n / temp;
            System.out.println(temp+":"+n / temp);
            temp *= 5;
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(new TrailingZeroes_172().trailingZeroes(5));
        System.out.println(new TrailingZeroes_172().trailingZeroes(30));
        System.out.println(new TrailingZeroes_172().trailingZeroes(5 * 5 * 5 + 1));
        System.out.println(new TrailingZeroes_172().trailingZeroes(1808548329));//452137076
        System.out.println(new TrailingZeroes_172().trailingZeroesError(1808548329));//452137078
    }
}
