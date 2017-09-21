package com.writeread;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeSet;

public class TestRead {
	public static void main(String[] args) {
		try {
			Map<String,Integer> resultMap = reader();
			System.out.println(resultMap);
			resultMap =  getTop10FromMap(resultMap);
			System.out.println(resultMap);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static Map<String, Integer> getTop10FromMap(
			Map<String, Integer> resultMap) {
		Map<String, Integer>  result = new LinkedHashMap<>();
		TreeSet<String> treeSet = new TreeSet<String>(new Comparator<String>() {
			public int compare(String o1, String o2) {
				return -o1.compareTo(o2) ;
			};
		});
//		Map<String, String>  treeMap = new TreeMap<>();
		
//		将int转为4位数的字符串
//		比较的key为 0001AB这种形式，确保key唯一同时能比较出大小
		for(String word : resultMap.keySet()){
			int number = resultMap.get(word);
			String key = numberFormat(number,word);
			treeSet.add(key);
			if(treeSet.size()>10){
				treeSet.remove(treeSet.last());
			}
		}
		for(String key : treeSet){
			addMapFromKey(result,key);
		}
		return result;
	}

	private static void addMapFromKey(Map<String, Integer> result, String key) {
		String str1 = key.substring(0, 4);
		String str2 = key.substring(4, key.length());
		result.put(str2, Integer.valueOf(str1));
	}

	/** 
	* @Title: numberFormat 
	* @Description: 返回一个形式如果 0001AB的比较字符串
	* @param @param number
	* @param @param word
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	private static String numberFormat(Integer number, String word) {
		String str = String.valueOf(number);
		while(str.length()<4){
			str = 0+str;
		}
		return str+word;
	}

	private static Map<String,Integer> reader() throws IOException {
		File file = new File("C://Test.txt");
		BufferedReader bw = new BufferedReader(new FileReader(file));
		Map<String,Integer> resultMap = new HashMap<>();
		while(bw.ready()){
			String word = bw.readLine();
			int number = 1;
			if(resultMap.containsKey(word)){
				number = resultMap.get(word)+1;
			}
			resultMap.put(word, number);
		}
		bw.close();
		return resultMap;
	}
}
