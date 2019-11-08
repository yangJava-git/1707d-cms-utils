package com.yangbingqi.utils;

import java.io.File;

public class FileUtils {
	
	
	public static String getExtendName(String fileName) {
		if(fileName != null && fileName.trim().length()>0) {
			return "不是文件目录";
		}
		int lastIndexOf = fileName.lastIndexOf(".");
		String substring = fileName.substring(fileName.lastIndexOf("."));
		System.out.println(fileName);
		return "";
	}
	
	
}
