package com.algorithm.easy;

/**
 * 阶乘后的零
 * 给定一个整数 n，返回 n! 结果尾数中零的数量。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 3
 * 输出: 0
 * 解释:?3! = 6, 尾数中没有零。
 * 示例?2:
 * <p>
 * 输入: 5
 * 输出: 1
 * 解释:?5! = 120, 尾数中有 1 个零.
 * 说明: 你算法的时间复杂度应为?O(log?n)?。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/factorial-trailing-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TrailingZeroes_172 {

    /*
    最优解 最小内存
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
    最优解，最快执行
    基本差不多
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
       判断数字中有几个5
       如果5的阶乘，则需要再判断一次，
       判断有几个5，再判断有几个25，再判断有几个5^3....依次循环

       疑问：
         n/5 + n/5/5   1808548329 输出452137076
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
1220703125:1   在运算中，计算乘法时，int类型容易出问题  2^32 = 4294967296   这里*5的时候出问题了
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
1220703125:1  修改成long 就对了

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
