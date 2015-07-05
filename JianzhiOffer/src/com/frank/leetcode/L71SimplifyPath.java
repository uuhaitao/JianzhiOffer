package com.frank.leetcode;

import java.util.Stack;

public class L71SimplifyPath {
	public String simplifyPath(String path) {
		String [] ps=path.split("/");
		Stack<String> stack=new Stack<String>();
		for(int i=0;i<ps.length;i++){
			if(ps[i].equals("") || ps[i].equals("."))
				continue;
			if(ps[i].equals("..")){
				if(!stack.isEmpty())
					stack.pop();
			}
			else stack.push(ps[i]);
		}
		String res="";
		while(!stack.isEmpty()){
			res="/"+stack.pop()+res;
		}
		
		return res.equals("")?"/":res;
	}
	
	public static void main(String[] args) {
		String r=new L71SimplifyPath().simplifyPath("//a/./b/../../c/");
		System.out.println(r);
	}
}
