package com.yangbingqi.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtils {
	
	/*
	* ����1��(5��)    ���ش������ڵ��³�
	* ��һ��ʱ����󣬷��ظ�ʱ�������µ�1��0ʱ0��0�롣����һ��Date�����ֵ��2019-05-18 11:37:22
	* �򷵻صĽ��Ϊ2019-05-01 00:00:00
	*/
	public static Date getDateByInitMonth(Date src) {
		//��ȡ������
		Calendar c = Calendar.getInstance();
		
		//���ݴ�������ڹ���������
		c.setTime(src);
		
		//�����³�
		c.set(Calendar.DAY_OF_MONTH, 1);
		//����Сʱ
		c.set(Calendar.HOUR_OF_DAY, 0);
		//���÷���
		c.set(Calendar.MINUTE, 0);
		//������
		c.set(Calendar.SECOND, 0);
		
		return c.getTime();
	}
	/*
	* ����2��(5��)
	* ��һ��ʱ����󣬷��ظ�ʱ�������µ������23ʱ59��59�룬��Ҫ�����´���С�Ͷ������������
	* ����һ��Date�����ֵ��2019-05-18 11:37:22���򷵻ص�ʱ��Ϊ2019-05-31 23:59:59
	* ����һ��Date�����ֵ��2019-02-05 15:42:18���򷵻ص�ʱ��Ϊ2019-02-28 23:59:59
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
	 * @Description: ���������ڼ�������
	 * @param src
	 * @return
	 * @return: String
	 */
	public static String getAge(Date src) {
		if(src.compareTo(new Date())>0) {
			return "������Ϸ��ĳ�������";
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
		return "���������:"+age;
	}
	
	//7.4.4 �ж��Ƿ��ڱ���
	public static boolean isThisWeek(Date date) {

	SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");

	Calendar firstDayOfWeek = Calendar.getInstance(Locale.getDefault());

	firstDayOfWeek.setFirstDayOfWeek(Calendar.MONDAY);

	int day = firstDayOfWeek.get(Calendar.DAY_OF_WEEK);

	firstDayOfWeek.add(Calendar.DATE, -day+1+1);// �����+1����Ϊ�����տ�ʼ

	// ����һ������

	System.out.println(format.format(firstDayOfWeek.getTime()));

	Calendar lastDayOfWeek = Calendar.getInstance(Locale.getDefault());

	lastDayOfWeek.setFirstDayOfWeek(Calendar.MONDAY);

	day = lastDayOfWeek.get(Calendar.DAY_OF_WEEK);

	lastDayOfWeek.add(Calendar.DATE, 7-day+1);

	// ���������������

	System.out.println(format.format(lastDayOfWeek.getTime()));

	return (date.getTime()<lastDayOfWeek.getTime().getTime() && date.getTime()>firstDayOfWeek.getTime().getTime() );

	}

}
