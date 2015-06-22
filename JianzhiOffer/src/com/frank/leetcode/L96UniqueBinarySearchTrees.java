package com.frank.leetcode;

public class L96UniqueBinarySearchTrees {
	public static int numTrees(int n) {
		int M=n>2?n:2;
        int res[]=new int [M+1];
		res[0]=1;
		
		for(int i=1;i<=2;i++){
			res[i]=i;
		}
		
		for(int i=3;i<=n;i++){
			for(int j=0;j<i;j++){
				res[i]+=res[j]*res[i-j-1];
			}
		}
		
		return res[n];

	}
	
	public static void main(String[] args) {
		numTrees(5);
	}
}
