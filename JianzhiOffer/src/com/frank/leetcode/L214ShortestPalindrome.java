package com.frank.leetcode;

public class L214ShortestPalindrome {

	public String shortestPalindrome(String s) {
		if(s.length()<=1)
			return s;
		char[] a=s.toCharArray();
		int max_len=0;
		int bestcenter=0;
		int lens=s.length();
		for (int i=0;i<a.length;i++){
			int p=1;
			int len=1;
			while((i-p>=0) && (i+p<lens) && (a[i-p]==a[i+p])){
				len+=2;
				p++;
			}
			if((i-p<0 || i+p>=a.length) && len>max_len){
				max_len=len;
				bestcenter=i;
			}
			
			len=0;
			p=1;
			while((i-p+1>=0) && (i+p<=a.length-1) && (a[i-p+1]==a[i+p])){
				len+=2;
				p++;
			}
			if((i-p<0 || i+p>=a.length) && len>max_len){
				max_len=len;
				bestcenter=i;
			}
		}

		if(max_len%2==0)
		{
			int p=max_len/2;
			if(bestcenter-p<0)
			{
				StringBuilder sb=new StringBuilder(s.substring(bestcenter+p+1)).reverse();
				return sb.toString()+s;
			}
			else
			{
				StringBuilder sb=new StringBuilder(s.substring(0,bestcenter-p+1)).reverse();
				return s+sb.toString();
			}
		}
		else
		{
			int p=(max_len-1)/2;
			if(bestcenter-p-1<0)
			{
				StringBuilder sb=new StringBuilder(s.substring(bestcenter+p+1)).reverse();
				return sb.toString()+s;
			}
			else
			{
				StringBuilder sb=new StringBuilder(s.substring(0,bestcenter-p+1)).reverse();
				return s+sb.toString();
			}
		}
	}

	public static void main(String[] args) {
		String s=new L214ShortestPalindrome().shortestPalindrome("baff");
		System.out.println(s);
	}

}
