package com.quest.test.jvm.entity;

public class Father {
    //private static Father father = new Father();
    static {
        System.out.println("father->static block");
    }

    {
        System.out.println("father->block");
    }

    public Father() {
        System.out.println("father construct");
    }

    static class Test extends Father{
        public static void main(String[] args) {
            //new Father();
            Class fa = Father.class;
        }
    }

}
