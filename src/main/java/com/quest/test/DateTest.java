package com.quest.test;

import com.quest.commons.utils.DateUtil;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Quest on 2017/9/5.
 */
public class DateTest {
    @Test
    public void test(){
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DATE, 1);
        System.out.println(DateUtil.getDateString(cal.getTime()));
    }
}
