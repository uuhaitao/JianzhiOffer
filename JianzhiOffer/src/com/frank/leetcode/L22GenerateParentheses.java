package com.frank.leetcode;

import java.util.ArrayList;
import java.util.List;

public class L22GenerateParentheses {

	public List<String> generateParenthesis(int n) {

		ArrayList<String> res = new ArrayList<String>();
		generate_core(0,0, n, "", res);
		return res;
	}

	void generate_core(int left, int right, int n,String curr, ArrayList<String> res) {
		if (left == n && right == n) {
			res.add(curr);
		}
		if(left>right){
			if(left<n){
				generate_core(left+1,right,n,curr+"(",res);
			}
			if(right<n){
				generate_core(left,right+1,n,curr+")",res);
			}
		}
		else{
			if(left<n){
				generate_core(left+1,right,n,curr+"(",res);
			}
		}
	}

	public static void main(String[] args) {
		List<String> r=new L22GenerateParentheses().generateParenthesis(3);
		for (String s:r){
			System.out.println(s);
		}
	}

}
