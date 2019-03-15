package com.quest.test.jvm.entity;

public class Son extends Father {
    static {
        System.out.println("Son->static block");
    }
    {
        System.out.println("Son->block");
    }

    private int b = 3;
    private static int a = 4;

    public Son() {
        System.out.println("Son construct a:" + a + ",b:" + b);
    }

    public static void main(String[] args) {
        new Son();
    }
}
