package com.quest.test;

import com.quest.service.HandlerAware;
import com.quest.service.impl.HandlerAwareImpl;
import org.junit.Test;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Quest on 2017/9/1.
 */
public class Java8NewFeatureTest {
    /**
     * java8。list新增sort方法，并自带自然排序功能
    * */
    @Test
    public void list_sort(){
        List<Integer> list = Arrays.asList(2, 5, 20, 87, 3, 24, 32, 36, 7, 2, 26, 56, 33, 13);
        list.sort(Comparator.naturalOrder());
        list.forEach(System.out::print);
    }
    /**
     * java8，接口中可以实现方法： 1.在接口内声明静态方法 2.指定一个默认方法。
    * */
    @Test
    public void interface_impl_method(){
        HandlerAware aware = new HandlerAwareImpl();
        aware.get();
        aware.set("SF");
        HandlerAware.put("C");
    }

    /**
     * 证明 JVM 不知道异常检查
    * */
    @Test
    public  void jvmCheckedException() {
        doThrow(new SQLException());
    }

    static void doThrow(Exception e) {
        Java8NewFeatureTest.<RuntimeException> doThrow0(e);
    }

    @SuppressWarnings("unchecked")
    static <E extends Exception> void doThrow0(Exception e) throws E {
        throw (E) e;
    }
}
