package com.quest.algorithm.codeM;

import java.util.Scanner;

/** 
 * @ClassName: SecondQuestion
 * @Description: 组委会正在为美团点评CodeM大赛的决赛设计新赛制。
比赛有 n 个人参加（其中 n 为2的幂），每个参赛者根据资格赛和预赛、复赛的成绩，会有不同的积分。
比赛采取锦标赛赛制，分轮次进行，设某一轮有 m 个人参加，那么参赛者会被分为 m/2 组，每组恰好 2 人，m/2 组的人分别厮杀。
我们假定积分高的人肯定获胜，若积分一样，则随机产生获胜者。获胜者获得参加下一轮的资格，输的人被淘汰。重复这个过程，直至决出冠军。
现在请问，参赛者小美最多可以活到第几轮（初始为第0轮）？
 * 
 * @author ganshimin@zhongzhihui.com
 * @date: 2017年6月16日 下午2:49:38
 */  
public class SecondQuestion {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		int a_m = a[0];//小美积分
		int turns = 0;//轮数
		int ranking = 1;//排名
		//begin
		for (int i = 1; i < a.length; i++) {
			if(a_m < a[i]){
				ranking++;
			}
		}
		int mostTurn = (int)(Math.log(n)/Math.log(2));
		System.out.println("mostTurn:"+mostTurn);
		System.out.println("ranking:"+ranking);
		int temp = 0;
		
		for (int i = mostTurn; i >= 0; i--) {
			if(ranking <= temp){
				turns = i;
				break;
			}else if(ranking == n){//倒数第一
				turns = 1;
				break;
			}
			temp += Math.pow(2, i-1);
			System.out.println("temp:"+temp);
		}
		System.out.println(turns);
		
		
	}
}
