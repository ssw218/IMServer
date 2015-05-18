package com.lyk.im.test;

public class calculator {

	public static void main(String[] args) {
		System.out.println(pow(20, 20));
	}
	
	static long pow(long a, long b) {
		long c = 1;
		for(int i = 0; i < b; i++)
			c *= a;
		return c;
	}

}
