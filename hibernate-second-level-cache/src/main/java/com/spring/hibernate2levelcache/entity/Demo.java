package com.spring.hibernate2levelcache.entity;

public class Demo {
	String name;

	public Demo() {
		name="xyz";
	}
	
	static String ram(String x)
	{
		return x;
	}

public static void main(String[] args)
{
	Demo obj= new Demo();
	System.out.println("hiii"+obj.name);
	
	String result=ram("abc");
	System.out.println("wefsd"+ result);
}
}
