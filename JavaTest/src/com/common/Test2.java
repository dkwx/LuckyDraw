package com.common;

public class Test2 {
	
//	0��ASCII��
	private static final int ZERO_ASCII = (int)'0';
	
	public static void main(String[] args) {
		String str = "23412";
//		���Եı��� 1 10 100 1000 10000 ������
		int mulNumber = 1;
//		�ϼ�
		int sum = 0;
		char[] arrs = str.toCharArray();
		for(int i = arrs.length-1 ; i >=0 ;i--){
//			��iλ��ASCII��
			int arrAscii = (int)arrs[i];
//			��iλ����   ���ڵ�iλ��ascii�� ��ȥ 0��ASCII��
			int temp = arrAscii - ZERO_ASCII;;
//			��iλ���Ա���
			temp = temp * mulNumber;
//			�ۼӵ�iλ
			sum += temp;
//			��������10
			mulNumber = mulNumber * 10;
		}
		System.out.println(sum);
	}
}
