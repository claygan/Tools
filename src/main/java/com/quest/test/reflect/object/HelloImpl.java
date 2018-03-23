package com.quest.test.reflect.object;

/**
 * Created by Quest on 2018/3/16.
 */
public class HelloImpl implements Hello {
    @Override
    public void sayHello() {
        System.out.println("hello! are you ok?");
    }

    @Override
    public void sayBye() {
        System.out.println("bye! see you again");
    }
}
