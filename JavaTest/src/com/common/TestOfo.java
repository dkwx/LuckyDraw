package com.common;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/** 
* @ClassName: TestOfo 
* @Description: UTF-8 计算ofo的锁的撞库情况（写死的情况，只能四位）
* @author daikai3 
* @date 2017年9月21日 下午1:14:05 
*  
*/
public class TestOfo {
	static char[] chs = {'1','2','3','4'};
	/** 
	* @Fields allCase :所有的情况
	*/ 
	static Set<String> allCase = new LinkedHashSet<>();
	/** 
	* @Fields rightCase : 可以完成的某种情况
	*/ 
	static Set<String> rightCase = new LinkedHashSet<>();
	public static void main(String[] args) {
		runProgram();
	}
	/** 
	* @Title: runProgram 
	* @Description: 运行程序 
	* @param     设定文件 
	* @return void    返回类型 
	* @throws 
	*/
	private static void runProgram() {
//		拿到所有的情况
		fillAllCase(allCase);
//		System.out.println(allCase.size());
//		System.out.println(allCase);
		
//		拿到第一个值1111
		String start = "";
		for(int i = 0; i < chs.length;i++){
			start+=chs[0];
		}
//		从第一个值开始一个个往下走得到正确的一种情况
		runCompute(start);
//		System.out.println(rightCase);
//		存储需要按下的字符
		List<Character> chars = new ArrayList<>();
//		存储前一个字符
		String preStr = "";
		for(String str : rightCase){
//			拿到当前字符串和前面的字符串不同的部分
			String differentStr = compareStrWithPreStrDifferentPart(str,preStr);
			System.out.print(str);
			System.out.println("和前面不同的部分："+differentStr);
//			存储下来不同的部分
			for(char  ch : differentStr.toCharArray()){
				chars.add(ch);
			}
//			把当前字符当作前一个字符
			preStr = str;
		}
		System.out.println(chars.size());
//		System.out.println(chars);
	}
	/** 
	* @Title: compareStrWithPreStrDifferentPart 
	* @Description: 得到两个字符串不同的部分，前一个字符串  1 111   后一个   111 2 则不同的部分为2
	* @param @param str
	* @param @param preStr
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	private static String compareStrWithPreStrDifferentPart(String str,
			String preStr) {
//		如果两个字符串1111 1111相同，返回空，理论上不可能存在这种情况
		if(str.equals(preStr)){
			return "";
		}
//		因为两个字符串不可能完全相同，所以依次比较当前字符串的前n-1/n-2/n-3....位和前一个字符串的末尾是否相同
		int i = 1;
		while(i<str.length()){
//			如果 1111 是以 111结尾
//			即1112的subString(0,3)
//			111
			String subString = str.substring(0,(str.length()-i));
//			1111 是否以111结尾
			if(preStr.endsWith(subString)){
//				如果是则返回 1112的剩余部分2
				return str.substring(str.length()-i,str.length());
			};
//			如果不是则判断1111 和1112的 11结尾
			i++;
		}
//		如果循环结束还没有找到相同的部分，则两个字符串完全不同，则完整返回当前字符串
		return str;
	}
	/** 
	* @Title: runCompute 
	* @Description:迭代运行
	* @param @param nowCase    设定文件 
	* @return void    返回类型 
	* @throws 
	*/
	private static void runCompute(String nowCase) {
//		递归调用停止的条件，所有的情况都被移除就停止递归
		if(allCase.size()==0){
			return;
		}
//		把当前的字符串当作步骤存储起来
		rightCase.add(nowCase);
//		在所有的情况集合中移除当前的情况
		allCase.remove(nowCase);
		if(allCase.size()>0){
//			查找下一个字符，并且递归调用本方法
			runCompute(findNext(nowCase));
		}
			
		
	}
	/** 
	* @Title: findNext 
	* @Description: 寻找下一个字符串
	* @param @param nowCase
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	private static String findNext(String nowCase) {
//		从当前字符串的后n-1位开始找有没有以这n-1位开头的情况
		int lastNumber = nowCase.length()-1;
//		查找不到的条件
		while(lastNumber>1){
//			得到当前字符串的后3、2、1位字符串
			String lastString = getLastString(lastNumber,nowCase);
//			找所有情况中是否存在后几位字符串开头的字符串
			String nextStr = findStartWithStr(lastString);
//			如果找到返回
			if(null!=nextStr){
				return nextStr;
			}
//			没找到再缩小范围
			lastNumber--;
		}
//		最终查找不到的话，则从所有情况中找一个新的字符串当作下一个
		return allCase.iterator().next();
		
	}
	/** 
	* @Title: findStartWithStr 
	* @Description: 从所有情况中查找以lastString开头的字符串
	* @param @param lastString
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	private static String findStartWithStr(String lastString) {
		for(String str : allCase){
			if(str.startsWith(lastString)){
				return str;
			}
		}
		return null;
	}
	/** 
	* @Title: getLastString 
	* @Description: 得到最后i位
	* @param @param i
	* @param @param nowCase
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	private static String getLastString(int lastNumber, String nowCase) {
		return nowCase.substring(nowCase.length()-lastNumber);
	}
	/** 
	* @Title: fillAllCase 
	* @Description: 遍历所有情况的可能存储起来
	* @param @param allCase    设定文件 
	* @return void    返回类型 
	* @throws 
	*/
	private static void fillAllCase(Set<String> allCase) {
		for(char ch1 : chs){
			for(char ch2 : chs){
				for(char ch3 : chs){
					for(char ch4 : chs){
						allCase.add(getString(ch1,ch2,ch3,ch4));
					}
				}
			}
		}
	}
	/** 
	* @Title: getString 
	* @Description: 根据字符拼接字符串 
	* @param @param ch1
	* @param @param ch2
	* @param @param ch3
	* @param @param ch4
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	private static String getString(char ch1, char ch2, char ch3, char ch4) {
		StringBuffer sb = new StringBuffer();
		sb.append(ch1);
		sb.append(ch2);
		sb.append(ch3);
		sb.append(ch4);
		return sb.toString();
	}
}
