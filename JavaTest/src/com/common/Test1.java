package com.common;

public class Test1 {
	public static void main(String[] args) {
		String str = "23412";
//		���Եı��� 1 10 100 1000 10000 ������
		int mulNumber = 1;
//		�ϼ�
		int sum = 0;
		char[] arrs = str.toCharArray();
		for(int i = arrs.length-1 ; i >=0 ;i--){
//			ȡ����iλ����
			int temp = Character.getNumericValue(arrs[i]);
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
