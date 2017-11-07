package com.quest.commons.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author luog
 * @version V1.0
 * @Title: DateUtil.java
 * @Package com.ws.platform.core.module.wscms.util
 * @Description: TODO(用一句话描述该文件做什么)
 * @date 2012-11-26 下午2:35:13
 */
public class DateUtil {
    private static Logger logger = LoggerFactory.getLogger(DateUtil.class);

    public static String YYYY_MM_DD = "yyyy_MM_dd";
    public static String YYYY_MM_DD_HH_MM_ss = "yyyy_MM_dd_HH_mm_ss";
    public static String HH_MM_ss = "HH_mm_ss";
    public static String YYYYMMDD = "yyyyMMdd";
    public static String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
    public static String HHMMss = "HHmmss";

    /**
     * @param date
     * @return String 返回类型
     * @Title: getDateString
     * @Description: 使用"yyyy-MM-dd HH:mm:ss"格式化日期
     * @author Yanjh
     */
    public static String getDateString(Date date) {
        return getDateString(date, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * @param date   日期
     * @param format 模式
     * @return String 返回类型
     * @Title: getDateString
     * @Description: 格式化日期
     * @author Yanjh
     */
    public static String getDateString(Date date, String format) {
        if (date != null) {
            SimpleDateFormat formatter = new SimpleDateFormat(format);
            String dateString = formatter.format(date);
            return dateString;
        }
        return null;
    }

    /**
     * @param strDate
     * @param format
     * @return Date 返回类型
     * @Title: parseDate
     * @Description: 解析Date，string to java.util.Date
     * @author Yanjh
     */
    public static Date parseDate(String strDate, String format) {
        if (strDate != null && !strDate.trim().equals("")) {
            SimpleDateFormat formatter = new SimpleDateFormat(format);
            Date date = null;
            try {
                date = formatter.parse(strDate);
            } catch (ParseException e) {
                logger.error(StackTraceUtil.getStackTrace(e));
            }
            return date;
        }
        return null;
    }

    /***
     *
     * @Title: getDaysBetween
     * @Description: 计算两个日期之间的天数(date1<date2)
     * @author wujl
     * @param @param date1
     * @param @param date2
     * @param @return 设定文件
     * @return int 返回类型
     */
    public static int getDaysBetween(Date begin, Date end) {
        long from = begin.getTime();
        long to = end.getTime();
        if (to < from) {
            return 0;
        }
        return (int) (to - from) / (1000 * 60 * 60 * 24);
    }

    public static int getMouthBetween(Date begin, Date end) {
        //
        long from = begin.getTime();
        long to = end.getTime();
        //
        if (to < from) {
            return 0;
        }
        return (int) (to - from) / (1000 * 60 * 60 * 24 * 30);
    }

    /**
     * @param time
     * @return
     */
    public static int getHour(Date time) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(time);
        int hourTime = calendar.get(Calendar.HOUR_OF_DAY);

        return hourTime;
    }

    public static int getDayOfMonth(Date time) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(time);
        int hourTime = calendar.get(Calendar.DAY_OF_MONTH);

        return hourTime;
    }

    public static int getDayOfYear(Date time) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(time);
        int hourTime = calendar.get(Calendar.DAY_OF_YEAR);

        return hourTime;
    }

    public static int getMonth(Date time) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(time);
        int hourTime = calendar.get(Calendar.MONTH);

        return hourTime;
    }

    public static int getMinute(Date time) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(time);
        int hourTime = calendar.get(Calendar.MINUTE);

        return hourTime;
    }

    public static int getYear(Date time) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(time);
        int hourTime = calendar.get(Calendar.YEAR);

        return hourTime;
    }

    public static Date getCurrentWeekDayStartTime() {
        DateFormat shortSdf = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat longSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar c = Calendar.getInstance();
        try {
            int weekday = c.get(Calendar.DAY_OF_WEEK) - 2;
            c.add(Calendar.DATE, -weekday);
            c.setTime(longSdf.parse(shortSdf.format(c.getTime()) + " 00:00:00"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return c.getTime();
    }

    public static Date getCurrentWeekDayEndTime() {
        DateFormat shortSdf = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat longSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar c = Calendar.getInstance();
        try {
            int weekday = c.get(Calendar.DAY_OF_WEEK);
            c.add(Calendar.DATE, 8 - weekday);
            c.setTime(longSdf.parse(shortSdf.format(c.getTime()) + " 23:59:59"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return c.getTime();
    }

    public static Date getTheCurrentLastTime(Date date) {
        SimpleDateFormat dateformat1 = new SimpleDateFormat("yyyy-MM-dd 23:59:59");
        String format = dateformat1.format(date);
        date = DateUtil.parseDate(format, "yyyy-MM-dd HH:mm:ss");
        return date;
    }

    public static Date preDay(Date date) {
        Calendar in = Calendar.getInstance();
        in.setTime(date);
        in.add(Calendar.DAY_OF_MONTH, -1);
        in.set(Calendar.HOUR_OF_DAY, 0);
        in.set(Calendar.MINUTE, 0);
        in.set(Calendar.SECOND, 0);
        in.set(Calendar.MILLISECOND, 0);
        return in.getTime();
    }

    public static Date preTime(Date date) {
        Calendar in = Calendar.getInstance();
        in.setTime(date);
        in.set(Calendar.HOUR_OF_DAY, 0);
        in.set(Calendar.MINUTE, 0);
        in.set(Calendar.SECOND, 0);
        in.set(Calendar.MILLISECOND, 0);
        return in.getTime();
    }

    public static Date add(Date date, int field, int value) {
        Calendar in = Calendar.getInstance();
        in.setTime(date);
        in.add(field, value);
        return in.getTime();
    }

    public static void main(String[] args) throws ParseException {
        Date date = new Date();
        SimpleDateFormat dateformat1 = new SimpleDateFormat("yyyy-MM-dd 23:59:59");
        String format = dateformat1.format(date);
        date = DateUtil.parseDate(format, "yyyy-MM-dd HH:mm:ss");
        System.out.println(date);
    }


}
