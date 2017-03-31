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
	
    public static String cutStrTo8(String dest){
        if(dest == null || "".equals(dest) || dest.length() <= 8 ){
            return dest;
        }
        return dest.substring(dest.length()-8,dest.length());
    }
    
    
    public static void main(String arg[]){
    	System.out.println(cutStrTo8("mdzz_1008611"));
    }
}
