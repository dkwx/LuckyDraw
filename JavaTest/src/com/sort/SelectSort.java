package com.sort;

import java.util.Arrays;

public class SelectSort {

	public static void main(String[] args) {
		
		int sortArray[] = {1,5,3,2,7,6,8};
		
		bubble(sortArray);
		
		System.out.println(Arrays.toString(sortArray));

	}

	private static void bubble(int[] array) {
		for(int i = 0 ; i < array.length ; i++){
			for(int j = i+1 ; j < array.length;j++){
				if(array[i]>array[j]){
					int temp = array[j];
					array[j] = array[i];
					array[i] = temp;
				}
			}
		}
	}

}
