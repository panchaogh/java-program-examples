package top.pcstar.commons.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author: PanChao
 * @Description: 日期工具类
 * @Date: Created in 14:11 2018/7/3
 */
public class DateUtil {
    private static final String DEFAULT_PATTERN = "yyyy-MM-dd";

    /**
     * 获取当前服务器时间
     *
     * @param format 日期格式化,例如yyyy-MM-dd
     * @return
     */
    public static String getCurrentServerDate(String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(Calendar.getInstance().getTime());
    }

    /**
     * 获取默认格式(yyyy-MM-dd)的当前服务器时间
     *
     * @return
     */
    public static String getDefaultFormatCurrentServerDate() {
        return getCurrentServerDate(DEFAULT_PATTERN);
    }

    /**
     * 获取当月月初日期
     * @param currentDate 当前日期
     * @param pattern 日期格式
     * @return
     * @throws ParseException
     */
    public static String getCurrentMonthFirstDay(String currentDate, String pattern) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date date = simpleDateFormat.parse(currentDate);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return simpleDateFormat.format(calendar.getTime());
    }

    /**
     * 获取当月月初日期
     * @param currentDate 当前日期(格式为 yyyy-MM-dd)
     * @return
     * @throws ParseException
     */
    public static String getCurrentMonthFirstDay(String currentDate) throws ParseException {
        return getCurrentMonthFirstDay(currentDate, DEFAULT_PATTERN);
    }

    /**
     * 获取次月月初日期
     * @param currentDate 当前日期
     * @param pattern 日期格式
     * @return
     * @throws ParseException
     */
    public static String getNextMonthFirstDay(String currentDate, String pattern) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date date = simpleDateFormat.parse(currentDate);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return simpleDateFormat.format(calendar.getTime());
    }
    /**
     * 获取次月月初日期
     * @param currentDate 当前日期(格式为 yyyy-MM-dd)
     * @return
     * @throws ParseException
     */
    public static String getNextMonthFirstDay(String currentDate) throws ParseException {
        return getNextMonthFirstDay(currentDate, DEFAULT_PATTERN);
    }

    /**
     * 获取当月月末日期
     * @param currentDate 当前日期
     * @param pattern 日期格式
     * @return
     * @throws ParseException
     */
    public static String getCurrentMonthEndDay(String currentDate, String pattern) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date date = simpleDateFormat.parse(currentDate);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, 0);
        return simpleDateFormat.format(calendar.getTime());
    }
    /**
     * 获取当月月末日期
     * @param currentDate 当前日期(格式为 yyyy-MM-dd)
     * @return
     * @throws ParseException
     */
    public static String getCurrentMonthEndDay(String currentDate) throws ParseException {
        return getCurrentMonthEndDay(currentDate, DEFAULT_PATTERN);
    }
}
