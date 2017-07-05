package com.quest.test;

public class ClassLoaderTest {

	public static void main(String[] args) {
		System.out.println(ClassLoaderTest.class.getClassLoader());
		System.out.println(ClassLoaderTest.class.getClassLoader().getParent());
		System.out.println(ClassLoaderTest.class.getClassLoader().getParent().getParent());
	}

}
