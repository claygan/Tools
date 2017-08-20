package com.quest.test;

public class ExecutionSequence {
	public static int a=1;
	static{
		a = 2;
		System.out.println("静态代码块:"+a);//step 1
	}
	{
		a = 3;
		System.out.println("构造代码块:"+a);// step 2
	}
	public ExecutionSequence(){
		this("调用带参构造方法1，a=" + a); // Step 3
		a = 4;
		System.out.println("构造方法："+a);
		{
			a = 5;
			System.out.println("构造方法中的普通代码块："+a);
		}
	}
	public ExecutionSequence(String b){
		System.out.println("带参构造方法："+b); // Step 
	}
	
	public static void main(String[] args) {
		ExecutionSequence sequence = null;//jvm加载类，静态代码块以及静态变量执行
		sequence = new ExecutionSequence();
	}
}
