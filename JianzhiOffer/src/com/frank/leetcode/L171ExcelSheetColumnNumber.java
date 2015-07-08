package com.frank.leetcode;

public class L171ExcelSheetColumnNumber {
	public int titleToNumber(String s) {
		int num=0;
		if(s.length()==0)
			return num;
		int i=s.length()-1;
		int j=1;
		while(i>=0){
			char c=s.charAt(i);
			System.out.println(c);
			int val=Integer.valueOf(c)-Integer.valueOf('A')+1;
			System.out.println(val);
			num+=val*j;
			j*=10;
			i--;
		}
		
		return num;
	}
	
	public static void main(String[] args) {
		new L171ExcelSheetColumnNumber().titleToNumber("A");
		System.out.println();
	}
}
