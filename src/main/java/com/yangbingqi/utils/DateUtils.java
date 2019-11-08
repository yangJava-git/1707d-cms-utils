package com.yangbingqi.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtils {
	
	/*
	* 方法1：(5分)    返回传入日期的月初
	* 给一个时间对象，返回该时间所在月的1日0时0分0秒。例如一个Date对象的值是2019-05-18 11:37:22
	* 则返回的结果为2019-05-01 00:00:00
	*/
	public static Date getDateByInitMonth(Date src) {
		//获取日历类
		Calendar c = Calendar.getInstance();
		
		//根据传入的日期构建日历类
		c.setTime(src);
		
		//设置月初
		c.set(Calendar.DAY_OF_MONTH, 1);
		//设置小时
		c.set(Calendar.HOUR_OF_DAY, 0);
		//设置分钟
		c.set(Calendar.MINUTE, 0);
		//设置秒
		c.set(Calendar.SECOND, 0);
		
		return c.getTime();
	}
	/*
	* 方法2：(5分)
	* 给一个时间对象，返回该时间所在月的最后日23时59分59秒，需要考虑月大月小和二月特殊情况。
	* 例如一个Date对象的值是2019-05-18 11:37:22，则返回的时间为2019-05-31 23:59:59
	* 例如一个Date对象的值是2019-02-05 15:42:18，则返回的时间为2019-02-28 23:59:59
	*/
	public static Date MonthLastDay(Date src) {
		Calendar c = Calendar.getInstance();
		c.setTime(src);
		c.add(Calendar.MONTH, 1);
		Date dateByInitMonth = DateUtils.getDateByInitMonth(src);
		c.setTime(dateByInitMonth);
		c.add(Calendar.SECOND, -1);
		
		return c.getTime();
	}
	
	
	/**
	 * 
	 * @Title: getAge 
	 * @Description: 给出生日期计算年龄
	 * @param src
	 * @return
	 * @return: String
	 */
	public static String getAge(Date src) {
		if(src.compareTo(new Date())>0) {
			return "请输入合法的出生日期";
		}
		Calendar c = Calendar.getInstance();
		c.setTime(src);
		
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH);
		int i = c.get(Calendar.DAY_OF_MONTH);
		
		c.setTime(new Date());
		
		int year1 = c.get(Calendar.YEAR);
		int month1 = c.get(Calendar.MONTH);
		int i1 = c.get(Calendar.DAY_OF_MONTH);
		
		int age =  year1-year;
		if(month<month1) {
			age --;
		}else if(i<i1) {
			age --;
		}
		return "你的年龄是:"+age;
	}
	
	//7.4.4 判断是否在本周
	public static boolean isThisWeek(Date date) {

	SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");

	Calendar firstDayOfWeek = Calendar.getInstance(Locale.getDefault());

	firstDayOfWeek.setFirstDayOfWeek(Calendar.MONDAY);

	int day = firstDayOfWeek.get(Calendar.DAY_OF_WEEK);

	firstDayOfWeek.add(Calendar.DATE, -day+1+1);// 后面的+1是因为从周日开始

	// 本周一的日期

	System.out.println(format.format(firstDayOfWeek.getTime()));

	Calendar lastDayOfWeek = Calendar.getInstance(Locale.getDefault());

	lastDayOfWeek.setFirstDayOfWeek(Calendar.MONDAY);

	day = lastDayOfWeek.get(Calendar.DAY_OF_WEEK);

	lastDayOfWeek.add(Calendar.DATE, 7-day+1);

	// 本周星期天的日期

	System.out.println(format.format(lastDayOfWeek.getTime()));

	return (date.getTime()<lastDayOfWeek.getTime().getTime() && date.getTime()>firstDayOfWeek.getTime().getTime() );

	}

}
