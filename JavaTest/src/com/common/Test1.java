package com.common;

public class Test1 {
	public static void main(String[] args) {
		String str = "23412";
//		乘以的倍数 1 10 100 1000 10000 。。。
		int mulNumber = 1;
//		合计
		int sum = 0;
		char[] arrs = str.toCharArray();
		for(int i = arrs.length-1 ; i >=0 ;i--){
//			取到第i位整数
			int temp = Character.getNumericValue(arrs[i]);
//			第i位乘以倍数
			temp = temp * mulNumber;
//			累加第i位
			sum += temp;
//			倍数乘以10
			mulNumber = mulNumber * 10;
		}
		System.out.println(sum);
	}
}
