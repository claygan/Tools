package com.quest.test.number;

import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Test;

import java.text.DecimalFormat;

/**
 * Created by Quest on 2018/8/16.
 */
public class NumberTest {
    /**
     * 计算百分比
     */
    @Test
    public void rate() {
        int x = 0;
        int y = 2;
        DecimalFormat df = new DecimalFormat("0.00%");
        System.out.println(df.format(Double.valueOf(x)/Double.valueOf(y)));
    }


}
