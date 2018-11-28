package top.pcstar.commons.util;

import org.junit.Test;

import java.text.ParseException;

/**
 * @Author: PanChao
 * @Description:
 * @Date: Created in 9:47 2018/8/11
 */
public class DateUtilTest {

    @Test
    public void getCurrentServerDate() {
        String actual = DateUtil.getCurrentServerDate("yyyy-MM-dd HH:mm:ss");
        System.out.println("获取当前服务器时间:" + actual);
    }

    @Test
    public void getDefaultFormatCurrentServerDate() {
        String actual = DateUtil.getDefaultFormatCurrentServerDate();
        System.out.println("获取默认格式(yyyy-MM-dd)的当前服务器时间:" + actual);
    }

    @Test
    public void getCurrentMonthFirstDay() {
        try {
            System.out.println("获取当月月初日期:" + DateUtil.getCurrentMonthFirstDay("2018-08-11"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getCurrentMonthFirstDay1() {
        try {
            System.out.println("获取当月月初日期:" + DateUtil.getCurrentMonthFirstDay("20180811", "yyyyMMdd"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getNextMonthFirstDay() {
        try {
            System.out.println("获取次月月初日期:" + DateUtil.getNextMonthFirstDay("2018-08-11"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getNextMonthFirstDay1() {
        try {
            System.out.println("获取次月月初日期:" + DateUtil.getNextMonthFirstDay("20180811", "yyyyMMdd"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getCurrentMonthEndDay() {
        try {
            System.out.println("获取当月月末日期:" + DateUtil.getCurrentMonthEndDay("2018-08-11"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getCurrentMonthEndDay1() {
        try {
            System.out.println("获取当月月末日期:" + DateUtil.getCurrentMonthEndDay("20180811", "yyyyMMdd"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}