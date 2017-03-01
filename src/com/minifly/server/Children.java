package com.minifly.server;

public class Children extends Father{
	public static void main(String arg[]){
//		System.out.println("子类的主方法");
		Children children = new Children("");
	}
	
	public Children(){
		System.out.println("子类构造无参");
	}
	public Children(String param){
		super("");
		System.out.println("子类构造带参数");
		
	}
}
