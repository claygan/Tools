package com.quest.test.number;

import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Test;

/**
 * Created by Quest on 2018/3/21.
 */
public class CompareTest {
    @Test
    public void floutTest(){
        String value = null;//5.1251231
        Float upper = 5.1251234F;
        Float lower = 1.4242123F;
        System.out.println(NumberUtils.toFloat(value));
        System.out.println(upper - NumberUtils.toFloat(value) <= 1e-6);
        System.out.println(upper - NumberUtils.toFloat(value) <= 0);
    }

    @Test
    public void toFloatTest(){
        String value = "512";
        System.out.println(NumberUtils.toFloat(value));

        String standardValue = "512.0";
        System.out.println(NumberUtils.toFloat(value) - NumberUtils.toFloat(standardValue) != 0);
    }
}
