package com.algorithm.easy;

/**
 * 颠倒给定的 32 位无符号整数的二进制位。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入: 00000010100101000001111010011100
 * 输出: 00111001011110000010100101000000
 * 解释: 输入的二进制串 00000010100101000001111010011100 表示无符号整数 43261596，
 * 因此返回 964176192，其二进制表示形式为 00111001011110000010100101000000。
 * 示例 2：
 * <p>
 * 输入：11111111111111111111111111111101
 * 输出：10111111111111111111111111111111
 * 解释：输入的二进制串 11111111111111111111111111111101 表示无符号整数 4294967293，
 * ?     因此返回 3221225471 其二进制表示形式为 10101111110010110010011101101001。
 * ?
 * <p>
 * 提示：
 * <p>
 * 请注意，在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，因为无论整数是有符号的还是无符号的，其内部的二进制表示形式都是相同的。
 * 在 Java 中，编译器使用二进制补码记法来表示有符号整数。因此，在上面的?示例 2?中，输入表示有符号整数 -3，输出表示有符号整数 -1073741825。
 * ?
 * <p>
 * 进阶:
 * 如果多次调用这个函数，你将如何优化你的算法？
 * <p>
 */
public class Solution_190 {


    /*
    最优解，最小内存
     */
    public int reverseBitsMin(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            res |= ((n >> i) & 1);
            /*
            res <<= 1;  //res 左移一位空出位置
            res |= (n & 1); //得到的最低位加过来
            n >>= 1;//原数字右移一位去掉已经处理过的最低位
            */
        }
        return res;
    }

    /*
        取当前 n 的最后一位：n & 1
        将最后一位移动到对应位置，第一次为 31 位，第二次是 30 位，即：31、30、29... 1、0，写作代码 bit << 31;
        退出条件，二进制反转时，如果剩余位数全位 0，则可以不用再反转。
     */
    public int reverseBits1(int n) {
        int ans = 0;
        for (int bitsSize = 31; n != 0; n = n >>> 1, bitsSize--) {
            ans += (n & 1) << bitsSize;
        }
        return ans;
    }

    /*
    初始为 abcdefghijklmnopqrstuvwxyz012345
    第一步结果:  qrstuvwxyz012345  abcdefghijklmnop
    第二步结果:  yz012345 qrstuvwx   ijklmnop abcdefgh
    第三步结果:  2345 yz01 uvwx qrst  mnop  ijkl efgh abcd
    第四步结果:  45 23 01 yz wx uv st qr  op mn kl ij gh ef cd ab
    第五步结果:  5 4 3 2 1 0 z y x w v u t s r q  p o n m l k j i h g f e d c b a
    如何创造? 先屏蔽 再移位 比如要创造4位错位, 即12345678换位56781234,
    那么先屏蔽5678得到12340000, 移位得到00001234, 同理可得56780000, 再加起来得到56781234;
    然后再2位错位, 即屏蔽得到56001200, 移位得到00560012, 同理可得78003400, 加起来得到78563412;
    再创造一位错位, 即先屏蔽得到70503010,移位得到07050301, 同理可得80604020, 加起来就是最后结果即87654321
    * */
    public int reverseBits2(int n) {
        n = ((n & 0xffff0000) >>> 16) | ((n & 0x0000ffff) << 16);
        n = ((n & 0xff00ff00) >>> 8) | ((n & 0x00ff00ff) << 8);
        n = ((n & 0xf0f0f0f0) >>> 4) | ((n & 0x0f0f0f0f) << 4);
        n = ((n & 0xcccccccc) >>> 2) | ((n & 0x33333333) << 2);
        n = ((n & 0xaaaaaaaa) >>> 1) | ((n & 0x55555555) << 1);
        return n;
    }


    // you need treat n as an unsigned value
    /*
     不能处理输入为1的情况，
     输入:00000000000000000000000000000001
     输出:10000000000000000000000000000000
     输出值>2^32
     2147483648l
     */
    public int reverseBits(int n) {
        char[] chars = Integer.toBinaryString(n).toCharArray();
        int len = chars.length;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 32; i++) {
            if (i >= len) {
                sb.append("0");
            } else {
                sb.append(chars[len - 1 - i]);
            }
        }
        /*
         * 1.判断首位是否是1
         *   1.1 0 表示颠倒之后的数是正数，直接转为 整数返回
         *   1.1 1 表示颠倒之后的数是负数，则需要 -1 取反，获取对应的正数
         * */
        String str = sb.toString();
        char[] resultChars = str.toCharArray();
        boolean b = true;
        if (resultChars[0] == '0') {
            return Integer.parseInt(str, 2);
        } else {
            //-1
            for (int i = 31; i >= 0; i--) {
                if (b) {
                    if (resultChars[i] == '1') {
                        resultChars[i] = '0';
                        b = false;
                    } else {
                        resultChars[i] = '1';
                    }
                }
            }
            //取反
            for (int i = 31; i >= 0; i--) {
                resultChars[i] = resultChars[i] == '1' ? '0' : '1';
            }
            return -1 * Integer.parseInt(String.valueOf(resultChars), 2);
        }
    }

    public static void main(String[] args) {
//        //01111111111111111111111111111110
//        System.out.println(Integer.parseInt("01111111111111111111111111111110", 2));
//        System.out.println(Integer.toBinaryString(2147483646));
//        System.out.println(Long.toBinaryString(2147483648l));
        System.out.println("###########1############");
        System.out.println(Integer.toBinaryString(1));
        System.out.println(new Solution_190().reverseBits(1));
        System.out.println(Integer.toBinaryString(new Solution_190().reverseBits(1)));

        System.out.println("###########3############");
        System.out.println(Integer.toBinaryString(3));
        System.out.println(new Solution_190().reverseBits(3));
        System.out.println(Integer.toBinaryString(new Solution_190().reverseBits(3)));

        System.out.println("###########4############");
        System.out.println(Integer.toBinaryString(4));
        System.out.println(new Solution_190().reverseBits(4));
        System.out.println(Integer.toBinaryString(new Solution_190().reverseBits(4)));

        System.out.println("###########-5############");
        System.out.println(Integer.toBinaryString(-5));
        System.out.println(new Solution_190().reverseBits(-5));
        System.out.println(Integer.toBinaryString(new Solution_190().reverseBits(-5)));

        System.out.println("###########-6############");
        System.out.println(Integer.toBinaryString(-6));
        System.out.println(new Solution_190().reverseBits(-6));
        System.out.println(Integer.toBinaryString(new Solution_190().reverseBits(-6)));
    }

}
