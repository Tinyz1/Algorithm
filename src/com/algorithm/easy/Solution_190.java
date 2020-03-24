package com.algorithm.easy;

/**
 * �ߵ������� 32 λ�޷��������Ķ�����λ��
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ����: 00000010100101000001111010011100
 * ���: 00111001011110000010100101000000
 * ����: ����Ķ����ƴ� 00000010100101000001111010011100 ��ʾ�޷������� 43261596��
 * ��˷��� 964176192��������Ʊ�ʾ��ʽΪ 00111001011110000010100101000000��
 * ʾ�� 2��
 * <p>
 * ���룺11111111111111111111111111111101
 * �����10111111111111111111111111111111
 * ���ͣ�����Ķ����ƴ� 11111111111111111111111111111101 ��ʾ�޷������� 4294967293��
 * ?     ��˷��� 3221225471 ������Ʊ�ʾ��ʽΪ 10101111110010110010011101101001��
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * ��ע�⣬��ĳЩ���ԣ��� Java���У�û���޷����������͡�����������£���������������ָ��Ϊ�з����������ͣ����Ҳ�ӦӰ������ʵ�֣���Ϊ�����������з��ŵĻ����޷��ŵģ����ڲ��Ķ����Ʊ�ʾ��ʽ������ͬ�ġ�
 * �� Java �У�������ʹ�ö����Ʋ���Ƿ�����ʾ�з�����������ˣ��������?ʾ�� 2?�У������ʾ�з������� -3�������ʾ�з������� -1073741825��
 * ?
 * <p>
 * ����:
 * �����ε�������������㽫����Ż�����㷨��
 * <p>
 */
public class Solution_190 {


    /*
    ���Ž⣬��С�ڴ�
     */
    public int reverseBitsMin(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            res |= ((n >> i) & 1);
            /*
            res <<= 1;  //res ����һλ�ճ�λ��
            res |= (n & 1); //�õ������λ�ӹ���
            n >>= 1;//ԭ��������һλȥ���Ѿ�����������λ
            */
        }
        return res;
    }

    /*
        ȡ��ǰ n �����һλ��n & 1
        �����һλ�ƶ�����Ӧλ�ã���һ��Ϊ 31 λ���ڶ����� 30 λ������31��30��29... 1��0��д������ bit << 31;
        �˳������������Ʒ�תʱ�����ʣ��λ��ȫλ 0������Բ����ٷ�ת��
     */
    public int reverseBits1(int n) {
        int ans = 0;
        for (int bitsSize = 31; n != 0; n = n >>> 1, bitsSize--) {
            ans += (n & 1) << bitsSize;
        }
        return ans;
    }

    /*
    ��ʼΪ abcdefghijklmnopqrstuvwxyz012345
    ��һ�����:  qrstuvwxyz012345  abcdefghijklmnop
    �ڶ������:  yz012345 qrstuvwx   ijklmnop abcdefgh
    ���������:  2345 yz01 uvwx qrst  mnop  ijkl efgh abcd
    ���Ĳ����:  45 23 01 yz wx uv st qr  op mn kl ij gh ef cd ab
    ���岽���:  5 4 3 2 1 0 z y x w v u t s r q  p o n m l k j i h g f e d c b a
    ��δ���? ������ ����λ ����Ҫ����4λ��λ, ��12345678��λ56781234,
    ��ô������5678�õ�12340000, ��λ�õ�00001234, ͬ��ɵ�56780000, �ټ������õ�56781234;
    Ȼ����2λ��λ, �����εõ�56001200, ��λ�õ�00560012, ͬ��ɵ�78003400, �������õ�78563412;
    �ٴ���һλ��λ, �������εõ�70503010,��λ�õ�07050301, ͬ��ɵ�80604020, �����������������87654321
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
     ���ܴ�������Ϊ1�������
     ����:00000000000000000000000000000001
     ���:10000000000000000000000000000000
     ���ֵ>2^32
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
         * 1.�ж���λ�Ƿ���1
         *   1.1 0 ��ʾ�ߵ�֮�������������ֱ��תΪ ��������
         *   1.1 1 ��ʾ�ߵ�֮������Ǹ���������Ҫ -1 ȡ������ȡ��Ӧ������
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
            //ȡ��
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
