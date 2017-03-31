package com.minifly.test;

public class SingleTonTest {
	
	public static void main(String arg[]){
		SingleTon singleTon = SingleTon.getInstance();
		/**
		 * 以为是要打印出来 1,1的，不过真正的打印的是1，0
		 * 希望能分析出来为什么
		 * 
		 */
		System.out.println("count1 " + singleTon.count1);
		System.out.println("count2 " + singleTon.count2);
	}
}
