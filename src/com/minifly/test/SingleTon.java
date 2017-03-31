package com.minifly.test;

public class SingleTon {
	public static SingleTon singleTon= new SingleTon();
	public static int count1 , count2=0;
	public SingleTon(){
		count1 ++ ;
		count2 ++ ;
		System.out.println("" + count1 + " " + count2);
	}
	
	public static SingleTon getInstance(){
		return singleTon;
	}
}
