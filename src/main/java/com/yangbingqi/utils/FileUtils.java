package com.yangbingqi.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class FileUtils {
	
	
	public static String getExtendName(String fileName) {
		if(fileName != null && fileName.trim().length()>0) {
			return "�����ļ�Ŀ¼";
		}
		int lastIndexOf = fileName.lastIndexOf(".");
		String substring = fileName.substring(fileName.lastIndexOf("."));
		System.out.println(fileName);
		return "";
	}
	
	public static void ReadFileByLine(String filename) {

		File file = new File(filename);

		InputStream is = null;

		Reader reader = null;

		BufferedReader bufferedReader = null;

		try {

		is = new FileInputStream(file);

		reader = new InputStreamReader(is);

		bufferedReader = new BufferedReader(reader);

		String line = null;

		while ((line = bufferedReader.readLine()) != null) {

		System.out.println(line);

		}

		} catch (FileNotFoundException e) {

		e.printStackTrace();

		} catch (IOException e) {

		e.printStackTrace();

		} finally {

		try {

		if (null != bufferedReader)

		bufferedReader.close();

		if (null != reader)

		reader.close();

		if (null != is)

		is.close();

		} catch (IOException e) {

		e.printStackTrace();

		}

		}

		}

		//7.6.3.2 ���ֽڶ�ȡ�ļ�
		/**

		* ���ֽڶ�ȡ�ļ�

		*

		* @param filename

		*/

		public static void ReadFileByBytes(String filename) {

		File file = new File(filename);

		InputStream is = null;

		try {

		is = new FileInputStream(file);

		int index = 0;

		while (-1 != (index = is.read())) {

		System.out.write(index);

		}

		} catch (FileNotFoundException e) {

		e.printStackTrace();

		} catch (IOException e) {

		// TODO Auto-generated catch block

		e.printStackTrace();

		} finally {

		try {

		if (null != is)

		is.close();

		} catch (IOException e) {

		e.printStackTrace();

		}

		}

		System.out.println("-----------------------------------");

		try {

		is = new FileInputStream(file);

		byte[] tempbyte = new byte[1000];

		int index = 0;

		while (-1 != (index = is.read(tempbyte))) {

		System.out.write(tempbyte, 0, index);

		}

		} catch (FileNotFoundException e) {

		e.printStackTrace();

		} catch (IOException e) {

		// TODO Auto-generated catch block

		e.printStackTrace();

		} finally {

		try {

		if (null != is)

		is.close();

		} catch (IOException e) {

		e.printStackTrace();

		}

		}

		}

		//7.6.3.3 ���ַ���ȡ�ļ�
		/**

		* ���ַ���ȡ�ļ�

		*

		* @param filename

		*/

		public static List<String> ReadFileByChar(String filename) {

		List<String> list = new ArrayList();
		File file = new File(filename);

		InputStream is = null;

		BufferedReader isr = null;

		try {

		is = new FileInputStream(file);

		isr = new BufferedReader(new InputStreamReader(is));

		String str = isr.readLine();

		while (str != null) {
		list.add(str);
		str = isr.readLine();		
		}

		} catch (FileNotFoundException e) {

		e.printStackTrace();

		} catch (IOException e) {

		e.printStackTrace();

		} finally {

		try {

		if (null != is)

		is.close();

		if (null != isr)

		isr.close();

		} catch (IOException e) {

		e.printStackTrace();

		}

		}
		return list;

		}

		//7.6.4 д���ı��ļ�
		//ͨ��BufferedWriterд�ļ�
		/**

		* ͨ��BufferedWriterд�ļ�

		*

		* @param filename

		*/

		public static void Write2FileByBuffered(String filename) {

		File file = new File(filename);

		FileOutputStream fos = null;

		OutputStreamWriter osw = null;

		BufferedWriter bw = null;

		try {

		if (!file.exists()) {

		file.createNewFile();

		}

		fos = new FileOutputStream(file);

		osw = new OutputStreamWriter(fos);

		bw = new BufferedWriter(osw);

		bw.write("Write2FileByBuffered");

		} catch (FileNotFoundException e) {

		e.printStackTrace();

		} catch (IOException e) {

		e.printStackTrace();

		} finally {

		if (null != bw) {

		try {

		bw.close();

		} catch (IOException e) {

		e.printStackTrace();

		}

		}

		if (null != osw) {

		try {

		osw.close();

		} catch (IOException e) {

		e.printStackTrace();

		}

		}

		if (null != fos) {

		try {

		fos.close();

		} catch (IOException e) {

		e.printStackTrace();

		}

		}

		}

		}

		//ͨ��FileWriterд�ļ�
		/**

		* ͨ��FileWriterд�ļ�

		*

		* @param filename

		*/

		public static void Write2FileByFileWriter(String filename) {

		File file = new File(filename);

		FileWriter fw = null;

		try {

		if (!file.exists()) {

		file.createNewFile();

		}

		fw = new FileWriter(file);

		fw.write("Write2FileByFileWriter");

		} catch (IOException e) {

		e.printStackTrace();

		} finally {

		if (null != fw) {

		try {

		fw.close();

		} catch (IOException e) {

		e.printStackTrace();

		}

		}

		}

		}

		//7.6.5 �����ļ�����
		public static void download(String realPath,HttpServletRequest request,HttpServletResponse response,String filename) throws FileNotFoundException {

		/* // ���ر����ļ�

		String fileName = "Operator.doc".toString(); // �ļ���Ĭ�ϱ�����

		*/ // ��������

		InputStream inStream = new FileInputStream(realPath+filename);// �ļ��Ĵ��·��

		// ��������ĸ�ʽ

		response.reset();

		response.setContentType("bin");

		response.addHeader("Content-Disposition", "attachment; filename=\"" + filename+"\"");

		
		// ѭ��ȡ�����е�����

		byte[] b = new byte[1024];

		int len;

		try {

		while ((len = inStream.read(b)) > 0)

		response.getOutputStream().write(b, 0, len);

		inStream.close();

		} catch (IOException e) {

		e.printStackTrace();

		}

		}

	
}
