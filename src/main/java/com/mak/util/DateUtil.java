/**
 * @file DateUtil.java
 * @project java8learn
 * @copyright 无锡雅座在线科技股份有限公司
 */
package com.mak.util;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

/**
 * Date类型操作工具类
 *
 * @author maliqiang
 * @version 1.0
 * @create 2017-11-06
 */
public class DateUtil {
    /**
     * 获取某年第几天的具体日期
     * @param year
     * @param dayOfYear
     * @return
     */
    public LocalDate getCurrentDateByDays(int year, int dayOfYear) {
        if (year == 0) {
            year = LocalDate.now().getYear();
        }
        return LocalDate.ofYearDay(year, dayOfYear);
    }

    public Date getNow(){
//        LocalDate now = LocalDate.now();
        Instant instant = Instant.now();
        return Date.from(instant);
    }
}
