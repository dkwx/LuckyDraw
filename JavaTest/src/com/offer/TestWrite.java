package com.offer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Random;

public class TestWrite {
	public static void main(String[] args) {

		File file = new File("D://data.txt");
		FileWriter fw = null;
		BufferedWriter writer = null;
		Random r = new Random();
		try {
			fw = new FileWriter(file);
			writer = new BufferedWriter(fw);
			for (int i = 1; i <= 100000; i++) {
				int temp = r.nextInt(10000);
				String str = temp + ",";
				writer.write(str);
				if (i % 10 == 0) {
					writer.newLine();// »»ÐÐ
				}
			}
			writer.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				writer.close();
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
