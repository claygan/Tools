package com.quest.test;

import com.quest.exceptions.ValueAbsentException;
import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * jdk8新特性，判空工具
 */
public class OptionalTest {
    /*
    * [of]:为非null的值创建一个Optional。
    of方法通过工厂方法创建Optional类。需要注意的是，
    创建对象时传入的参数不能为null。如果传入参数为null，则抛出NullPointerException 。
    */
    @Test
    public void of(){
        Optional<String> value = Optional.of("asdada");
        System.out.println( value.get());
        Optional<String> nullvalue = Optional.of(null);
        System.out.println( nullvalue.get());
    }

    /*
    * [ofNullable]:为指定的值创建一个Optional，如果指定的值为null，则返回一个空的Optional。
    * [orElse]:如果有值则将其返回，否则返回指定的其它值。
    * [orElseGet]:orElseGet方法可以接受Supplier接口的实现用来生成默认值
    * [orElseThrow]:如果有值则将其返回，否则抛出supplier接口创建的异常。
    */
    @Test
    public void ofNullable() {
        Optional<String> value = Optional.ofNullable(null);
        Optional<String> value1 = Optional.ofNullable("aaa");
        //
        System.out.println(value1.get());
        System.out.println(value1.orElse("can i output?"));
        System.out.println(value1.orElseGet(()->"[orElseGet]:can i output?"));
        //
        System.out.println("-------------------------------------");
        if (value.isPresent()) {
            System.out.println(value.get());//获取不到值则抛出NoSuchElementException。
        }
        System.out.println(value.orElse("[orElse]:the value is null"));
        System.out.println(value.orElseGet(()->"[orElseGet]:this is a default value"));
        try {
            System.out.println(value.orElseThrow(ValueAbsentException::new));
        } catch (Throwable e) {
            System.out.println(e.getMessage());
        }

    }

    /*
     如果Optional实例有值则为其调用consumer，否则不做处理

    要理解ifPresent方法，首先需要了解Consumer类。简答地说，Consumer类包含一个抽象方法。
    该抽象方法对传入的值进行处理，但没有返回值。Java8支持不用接口直接通过lambda表达式传入参数。
     */
    @Test
    public void ifPresent(){
        Optional<String> value = Optional.ofNullable("quest");
        value.ifPresent((val)->{
            System.out.println("what happen? "+ val);
        });
    }
    /*
    [map]:如果有值，则对其执行调用mapping函数得到返回值。如果返回值不为null，则创建包含mapping返回值的Optional作为map方法返回值，否则返回空Optional。
    [flatMap]:如果有值，为其执行mapping函数返回Optional类型返回值，否则返回空Optional。flatMap与map（Funtion）方法类似，
          区别在于flatMap中的mapper返回值必须是Optional。调用结束时，flatMap不会对结果用Optional封装。
    */
    @Test
    public void map(){
        //map方法用来对Optional实例的值执行一系列操作。通过一组实现了Function接口的lambda表达式传入操作
        //map方法执行传入的lambda表达式参数对Optional实例的值进行修改。
        //为lambda表达式的返回值创建新的Optional实例作为map方法的返回值。
        Optional<String> name = Optional.ofNullable("quest");
        Optional<String> upperName = name.map((value) -> value.toUpperCase());
        System.out.println(upperName.orElse("No value found"));
        upperName = name.flatMap((value) -> Optional.ofNullable(value.toLowerCase()));//flatMap方法中的lambda表达式返回值必须是Optionl实例。
        System.out.println(upperName.orElse("No value found"));
    }

    /*
      [filter]:如果有值并且满足断言条件返回包含该值的Optional，否则返回空Optional。
            filter个方法通过传入限定条件对Optional实例的值进行过滤
    */
    @Test
    public void filter(){
        //实现了Predicate接口的lambda表达式
        Optional<String> name = Optional.of("question");
        //filter方法检查给定的Option值是否满足某些条件。
        //如果满足则返回同一个Option实例，否则返回空Optional。
        Optional<String> longName = name.filter((value) -> value.length() > 6);
        System.out.println(longName.orElse("The name is less than 6 characters"));

        //另一个例子是Optional值不满足filter指定的条件。
        Optional<String> anotherName = Optional.of("quest");
        Optional<String> shortName = anotherName.filter((value) -> value.length() > 6);
        //输出：name长度不足6字符
        System.out.println(shortName.orElse("The name is less than 6 characters"));
    }

    @Test
    public void collections(){
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println(CollectionUtils.isNotEmpty(null));
    }
    @Test
    public void test1(){
        String str = "1,2";
        System.out.println(Arrays.toString(str.split(",")));
    }
}
