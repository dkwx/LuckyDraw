package com.writeread;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class TestWrite {
	private  static final Random r = new Random();
	private  static final int A_ASCII_NUMBER = 'A';
	
	public static void main(String[] args) {
		try {
			write();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void write() throws IOException {
		File file = new File("C://Test.txt");
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
		for(int i = 0 ;i < 1000 ;i ++){
			String str = getRandomStr();
			bw.write(str);
			bw.newLine();
		}
		bw.close();
	}

	/** 
	* @Title: getRandomStr 
	* @Description: ��Ϊֻ��һǧ�У�����ֻ��������ĸ�Ż��ظ���26*26<1000 
	* @param @return    �趨�ļ� 
	* @return String    �������� 
	* @throws 
	*/
	private static String getRandomStr() {
		int randomInt = r.nextInt(26);
		char c1 = (char) (A_ASCII_NUMBER+randomInt);
		randomInt = r.nextInt(26);
		char c2 = (char) (A_ASCII_NUMBER+randomInt);
		return ""+c1+c2;
	}
}
