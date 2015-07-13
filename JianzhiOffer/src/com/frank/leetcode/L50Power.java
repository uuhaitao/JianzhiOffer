package com.frank.leetcode;

public class L50Power {
	public double myPow(double x, int n) {
		int sign=1;
		if(x<0)
			sign=-1;
		
		double val=power(Math.abs(x), Math.abs(n));
		if(n<0)
			val=1.0/val;
		if(Math.abs(n)%2==1 && sign==-1)
			val=0-val;
		return val;
	}
	
	//zheng shu
	public double power(double x, int n){
		if(n==0)
			return 1;
		if(n==1)
			return x;
		double val=power(x, n/2);
		if(n%2==0){
			return val*val;
		}
		else
			return val*val*x;
	}
	public static void main(String[] args) {
		System.out.println(new L50Power().myPow(-2, -3));
	}
	
}
