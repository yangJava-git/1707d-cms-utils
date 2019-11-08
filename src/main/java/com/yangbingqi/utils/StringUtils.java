package com.yangbingqi.utils;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {
	
	//�п�
	public static boolean isEmpty(String src) {		
		return !(null != src && src.trim().length() > 0);
	}
	
	//�Ƿ���ֵ
	public static boolean isValue(String src) {		
		return (null != src && src.trim().length() > 0);
	}
	
	//��֤�ֻ���
	public static boolean verifyPhone(String phone) {
		String regex = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[013678])|(18[0,5-9]))\\d{8}$";

		Pattern p = Pattern.compile(regex);

		Matcher m = p.matcher(phone);

		boolean isMatch = m.matches();

		return isMatch ;
	}
	
	//��֤����
	public static boolean verifyEmail(String email) {
		String regEx1 = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";

		Pattern p = Pattern.compile(regEx1);

		Matcher m = p.matcher(email);

		boolean isMatch = m.matches();

		return isMatch;

	}
	
	//��֤ȫΪ��ĸ
	public static boolean verifyStr(String str) {
		String regEx1 = "[a-zA-Z]+";

		Pattern p = Pattern.compile(regEx1);

		Matcher m = p.matcher(str);

		boolean isMatch = m.matches();

		return isMatch;

	}
	
	//��ȡnλ�����Ӣ���ַ���
	public static String randomStr(int sum) {
		StringBuilder sb = new StringBuilder();

		Random random = new Random();

		for(int i=0;i<sum;i++) {

		int t = 'A' + random.nextInt(26);

		sb.append((char)t);

		
		}
		return sb.toString();
	}

}
