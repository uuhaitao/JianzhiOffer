package com.frank.hihocoder;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int num(List<Integer> list){
		int len=list.size();
		int curr=list.get(0);
		int res=1;
		int dur=1;
		for(int i=1;i<len;i++){
			if(list.get(i)==curr){
				dur++;
			}else{
				res*=(dur+1);
				curr=list.get(i);
				dur=1;
			}
		}
		res*=(dur+1);
		return res;
	}
	
	static int getnum(int n) {
		List<Integer> res = new LinkedList<Integer>();
		int i = n;
		int j = 2;
		int curr=0;
		int result=1;
		int dur=0;
		while (j <= i) {
			if (i % j == 0) {
				if(curr==0){
					dur=1;
					curr=j;
				}else if(curr==j){
					dur++;
				}
				else{
					result*=(dur+1);
					curr=j;
					dur=1;
				}
				i = i / j;
			} else {
				j++;
			}
		}
		return result*(dur+1);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int max=0;
		int best=1;
		for(int i=2;i<n;i++){
			int tmp=getnum(i);
			if(tmp>max){
				best=i;
				max=tmp;
			}
		}
		System.out.println(best);
	}
}
