package com.minifly.utils;

public class StringUtils {

	/**
	 * 将字符串转化成整形
	 * @param dest
	 * @return
	 */
	public static int string2Int(String dest){
		if(dest==null || "".equals(dest)){
			return 0;
		}
		try{
			return Integer.parseInt(dest);
		}catch(Exception e){
			return 0;
		}
	}
}
