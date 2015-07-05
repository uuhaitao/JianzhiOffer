package com.frank.leetcode;


public class L43MultiplyStrings {
	public String multiply(String num1, String num2) {
		int len1 = num1.length();
		int len2 = num2.length();
		if (len1 == 0 || len2 == 0 || num1.equals("0") || num2.equals("0"))
			return "0";
		int res[] = new int[len1 + len2];
		for (int i = 0; i < len1; i++) {
			int a = Integer.valueOf(num1.charAt(len1 - i - 1)-'0');
			for (int j = 0; j < len2; j++) {
				int b=Integer.valueOf(num2.charAt(len2 - j - 1)-'0');
				int multi=a*b;
				res[i+j]+=multi;
				int rio=res[i+j]/10;
				res[i+j+1]+=rio;
				res[i+j]%=10;
			}
		}
		
		StringBuilder sb=new StringBuilder();
		int i=res.length-1;
		while(res[i]==0){
			i--;
		}
		for(;i>=0;i--){
			sb.append(res[i]);
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		new L43MultiplyStrings().multiply("999","999");
	}
}
