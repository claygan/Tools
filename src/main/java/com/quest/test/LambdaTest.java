package com.quest.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * expression = (variable) -> action
 *
 * - variable: 这是一个变量,一个占位符。像x,y,z,可以是多个变量；
 * - action: 这里我称它为action, 这是我们实现的代码逻辑部分,它可以是一行代码也可以是一个代码片段。
 */
public class LambdaTest {
    /**
    * Consumer；消费型接口 （输出一个值）
    * void accept(T t)
    */
    @Test
    public void consumer(){
        donation(1000, money -> System.out.println("quest 消费了" + money + "元"));
    }
    public static void donation(Integer money, Consumer<Integer> consumer){
        consumer.accept(money);
    }

    /**
     * supplier：供给型接口 （工厂方法）
     * T get()
    * */
    @Test
    public void supplier(){
        List<Integer> list = supply(4, () -> (int)( Math.random() * 100));
        list.forEach(System.out::println);
    }
    public static List<Integer> supply(Integer len, Supplier<Integer> supplier){
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            resultList.add(supplier.get());
        }
        return resultList;
    }

    /**
    *  function:函数型接口 （输入输出做转换）
    *  R apply(T t)
    */
    @Test
    public void function(){
        System.out.println(convert("123", str -> Integer.valueOf(str)));
    }

    //字符串转Integer
    public static Integer convert(String str, Function<String, Integer> function) {
        return function.apply(str);
    }

    /**
    * predicate：断言型接口 （做过滤器）
    * boolean test(T t)
    */
    @Test
    public void predicate(){
        List<Integer> fruits = Arrays.asList(12,34,23,28,22,52);
        List<Integer> list = filter(fruits, f -> f > 22);
        list.forEach(System.out::println);
    }
    public static List<Integer> filter(List<Integer> fruits,Predicate<Integer> predicate){
        List<Integer> resultFruits = new ArrayList<>();
        for (Integer f : fruits) {
            if(predicate.test(f)){
                resultFruits.add(f);
            }
        }
        return resultFruits;
    }
}
