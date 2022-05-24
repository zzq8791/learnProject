package com.example.learn.algorithm.stringpc;

import lombok.extern.slf4j.Slf4j;

/**
 * 判断两个词是否是变形词
 * 题目：给定两个字符串，如果两个字符串长度相等，词语出现的次数相等，就是互为变形词
 * @author asus
 *
 */
@Slf4j
public class DeformationWord {

	public static void main(String[] args) {
		String str1 = "123";
		String str2 = "231";
		boolean flag = new DeformationWord().isDeformationWord(str1, str2); 
		System.out.println(flag);
	}
	
	private boolean isDeformationWord(String str1,String str2){
		
		if(str1 == null || str2 == null || (str1.length() != str2.length())){
			return false;
		}
		
		char[] char1 = str1.toCharArray();
		char[] char2 = str2.toCharArray();
		// 统计灭个词语出现的次数
		int[] map = new int[256];
		for(int i = 0;i<char1.length;i++){
			map[char1[i]] ++ ;
		}
		log.info("msg : {}",map);
		for(int x = 0;x<char2.length;x++){
			log.info("stchar2[x]:{},(map[char2[x]]:{},msg2st : {}",char2[x],map[char2[x]],map);
			if(map[char2[x]] -- == 0){
				log.info("endchar2[x]:{},(map[char2[x]]:{},msg2st : {}",char2[x],map[char2[x]],map);
				return false;
			}
		}
		
		return true;
	}
	
}
