package com.common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test4 {
	private static final DateFormat YYMMDD_FORMATTER = new SimpleDateFormat("yyƒÍMM‘¬dd»’");
	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(YYMMDD_FORMATTER.format(date));
	}
}
