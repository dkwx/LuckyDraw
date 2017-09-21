package com.sort;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		
		int sortArray[] = {1,5,3,2,7,6,8};
		
		bubble(sortArray);
		
		System.out.println(Arrays.toString(sortArray));

	}

	private static void bubble(int[] array) {
		for(int i = 0 ; i < array.length ; i++){
			for(int j = 0 ; j < array.length-1-i;j++){
				if(array[j]>array[j+1]){
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
	}

}
