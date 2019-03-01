package com.quest.test;

import org.junit.Test;

/**
 * java位运算
 */
public class BitOperationTest {
    @Test
    public void bitTest() {
        int num = 8;//1000
        int bit = 9;//1001
        System.out.println(num+"&"+bit+": "+(num & bit));
        System.out.println(num+"|"+bit+": "+(num | bit));//按位或
        System.out.println(num+"^"+bit+": "+(num ^ bit));//按位异或(不同的置1)
        System.out.println("~"+num+": "+(~num));
        //>>>和>>的区别是：在执行运算时，>>>运算符的操作数高位补0，而>>运算符的操作数高位移入原来高位的值。
        System.out.println(num+">>2: "+(num >> 1));//除以2^n
        System.out.println(num+">>>2: "+(num >>> 1));
        System.out.println(num+"<<2: "+(num << 2));//乘以2^n  1000->100000
    }
}
