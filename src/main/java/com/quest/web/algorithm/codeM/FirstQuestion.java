package com.quest.web.algorithm.codeM;
import java.util.Scanner;
/** 
 * @ClassName: FirstQuestion
 * @Description: 美团外卖的品牌代言人袋鼠先生最近正在进行音乐研究。他有两段音频，每段音频是一个表示音高的序列。现在袋鼠先生想要在第二段音频中找出与第一段音频最相近的部分。

具体地说，就是在第二段音频中找到一个长度和第一段音频相等且是连续的子序列，使得它们的 difference 最小。两段等长音频的 difference 定义为：
difference = SUM(a[i] - b[i])2 (1 ≤ i ≤ n),其中SUM()表示求和 
其中 n 表示序列长度，a[i], b[i]分别表示两段音频的音高。现在袋鼠先生想要知道，difference的最小值是多少？数据保证第一段音频的长度小于等于第二段音频的长度。

输入描述:
第一行一个整数n(1 ≤ n ≤ 1000)，表示第一段音频的长度。
第二行n个整数表示第一段音频的音高（0 ≤ 音高 ≤ 1000）。
第三行一个整数m(1 ≤ n ≤ m ≤ 1000)，表示第二段音频的长度。
第四行m个整数表示第二段音频的音高（0 ≤ 音高 ≤ 1000）。


输出描述:
输出difference的最小值
 * 
 * @author ganshimin@zhongzhihui.com
 * @date: 2017年6月16日 上午11:00:22
 */  
public class FirstQuestion {

		public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        int n = sc.nextInt();
	        String[] a_arr = new String[n];
	        for(int i = 0; i < n; i++){
	        	a_arr[i] = sc.next();
	        	while(Integer.valueOf(a_arr[i])>1000 || Integer.valueOf(a_arr[i])<0){
	        		System.out.println("请输入0<=a<=1000以内的数字");
	        		a_arr[i] = sc.next();
	        	}
	        } 
	        int m = sc.nextInt();
	        while(m < n){
	        	System.out.println("第二段音频长度不得小于第一段");
	        	m = sc.nextInt();
	        }
	        String[] b_arr = new String[m];
	        for(int i = 0; i < m; i++){
	        	b_arr[i] = sc.next();
	        	while(Integer.valueOf(b_arr[i])>1000 || Integer.valueOf(b_arr[i])<0){
	        		System.out.println("请输入0<=a<=1000以内的数字");
	        		b_arr[i] = sc.next();
	        	}
	        } 
	        int result = -1;
	        int difference = 0;
        	for (int i = 0; i < m-n+1; i++) {
        		for (int j = 0; j < n; j++) {
        			int a_value = Integer.valueOf(a_arr[j]);
        			int b_value = Integer.valueOf(b_arr[i+j]);
        			double seq = Math.pow((a_value-b_value),2);
        			difference += seq;
				}
        		if(result == -1 ||result > difference){
        			result = difference;
        		}else{
        			difference = 0;
        		}
			}
	        System.out.println(result);
		}
}
