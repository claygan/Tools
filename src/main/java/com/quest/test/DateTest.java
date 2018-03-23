package com.quest.test;

import com.quest.commons.utils.DateUtil;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static com.itextpdf.text.pdf.PdfName.ca;
import static org.apache.ibatis.ognl.DynamicSubscript.first;

/**
 * Created by Quest on 2017/9/5.
 */
public class DateTest {
    @Test
    public void test() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DATE, 1);
        System.out.println(DateUtil.getDateString(cal.getTime()));
    }

    @Test
    public void test1() {
        Date oDate = DateUtil.parseDate("2017-09-17 00:00:00", "yyyy-MM-dd HH:mm:ss");

        Calendar cal = Calendar.getInstance();
        cal.setTime(oDate);
        cal.add(Calendar.DATE, 1);
        System.out.println(cal.getTime().after(DateUtil.preTime(new Date())));

        System.out.println(DateUtil.preTime(new Date()));
    }

    @Test
    public void getWeek() {
        Calendar calendar = Calendar.getInstance();
        while (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY) {
            calendar.add(Calendar.DATE, -1);
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM月dd日");
        System.out.println(dateFormat.format(calendar.getTime()));
        calendar.add(Calendar.DATE, 6);
        System.out.println(dateFormat.format(calendar.getTime()));
        /*for (int i = 0; i < 7; i++) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM月dd日");
            System.out.println(dateFormat.format(calendar.getTime()));
            calendar.add(Calendar.DATE, 1);
        }*/
    }

    @Test
    public void test3() {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.MONTH, 1);
        c.set(Calendar.DAY_OF_MONTH, 1);//设置为1号,当前日期既为本月第一天
        System.out.println("===============first:" + DateUtil.getDateString(c.getTime()));
        c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        System.out.println("===============last:" + DateUtil.getDateString(c.getTime()));
    }

    @Test
    public void test4(){
        int value = 4;
        System.out.println(Double.valueOf(value));
    }

    @Test
    public void monthStartAndEnd(){
        //获取上个月的第一天时间和最后一天时间
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);//前一个月
        SimpleDateFormat firstDay = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
        System.out.println(firstDay.format(cal.getTime()));

        int maxDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        cal.set(Calendar.DAY_OF_MONTH, maxDay);
        SimpleDateFormat endDay = new SimpleDateFormat("yyyy-MM-dd 23:59:59");
        System.out.println(endDay.format(cal.getTime()));
    }
    @Test
    public void dayStartAndEnd(){
        Calendar sevenCal = Calendar.getInstance();
        sevenCal.add(Calendar.DAY_OF_MONTH, -7);
        SimpleDateFormat firstFormat = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
        String sevenFirst = firstFormat.format(sevenCal.getTime());
        sevenCal.add(Calendar.DAY_OF_MONTH, +6);
        SimpleDateFormat endFormat = new SimpleDateFormat("yyyy-MM-dd 23:59:59");
        String sevenEnd = endFormat.format(sevenCal.getTime());
        System.out.println(sevenFirst);
        System.out.println(sevenEnd);
    }
    @Test
    public void sqlDate(){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, -1);//前一天
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = dateFormat.format(cal.getTime());
        System.out.println(currentDate);


        java.sql.Date date = new java.sql.Date(cal.getTimeInMillis());
        System.out.println(date);
    }
}
