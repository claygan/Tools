package com.quest.web.algorithm.codeM;

/**
 * 美团外卖的配送员用变速跑的方式进行身体训练。
他们训练的方式是：n个人排成一列跑步，前后两人之间相隔 u 米，每个人正常速度均为 v 米/秒。
当某个配送员排在最后的时候，他需要以当时自己的最高速度往前跑，直到超过排头的人 u 米，然后降回到原始速度 v 米/秒。
每个人最初的最高速度为c[i] 米/秒，每轮衰减d[i] 米/秒，也就是说，如果i是第j个跑的，那么他的速度就是c[i]-(j-1)*d[i] 米/秒。
n个人初始以随机的顺序排列，每种顺序的概率完全相等，跑完一轮（每个人都追到排头一次，序列恢复原样）的期望需要的时间是多少？
 *
 *第一行整数n（<=1000）, 实数v(<=100) , 实数u(<=10)
第二行n个实数每个人的速度c[i](<=50000)
第三行n个实数值每个人衰减量d[i](<=10)
输入数据保证每个人的速度不会衰减到<=v
 */
public class A_FirstQuestion {

}
