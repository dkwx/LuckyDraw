package com.common;

import java.util.Arrays;

public class test01 {

	public static void main(String[] args) {
		int sum = 0;
		String str1 = "12345";
		char[] arr1 = str1.toCharArray();
		int[] arr2 = new int[arr1.length];
		for (int i = 0; i < arr1.length; i++) {
			arr2[i] = Character.getNumericValue(arr1[arr1.length - 1 - i]);
			arr2[i] = (int) (arr2[i] * (Math.pow(10, i)));
			sum = sum + arr2[i];
		}
		System.out.println(sum);
		System.out.println(Arrays.toString(arr2));
	}

}