package com.example.learn.algorithm.stringpc;

import lombok.extern.slf4j.Slf4j;

/**
 * 字符串中数字求和
 * @author asus
 *
 */
@Slf4j
public class NumSun {

	
	public static void main(String[] args) {
		String str ="A-1B--2C--D6E";
		int res = new NumSun().numSun(str);
		log.info("res : {}",res);
	}
	
	public int numSun(String str){
		if(str == null){
			return 0;
		}
		char[] charArr = str.toCharArray();
		int res = 0;
		int num = 0;
		boolean posi = true;
		int cur = 0;
		for(int i = 0;i< charArr.length;i++){
			log.info("charArr[i] :{}",charArr[i]);
			cur = charArr[i] -'0';
			log.info("cur :{}",cur);
			if(cur < 0|| cur >9){// 如果不是数字
				res += num;
				log.info("res += nu :{}",res);
				num = 0;
				if(charArr[i] == '-'){
					// 判断符号
					if(i - 1 > -1 && charArr[i - 1] == '-' ){
						posi = !posi;
					}else{
						// 单个符号
						posi = false;
					}
				}else{
					posi = true;
				}
			}else{
				num = (posi ? cur : -cur);
				log.info("num :{}",num);
			}
		}
		res += num;
		return res;
	}
	
}
