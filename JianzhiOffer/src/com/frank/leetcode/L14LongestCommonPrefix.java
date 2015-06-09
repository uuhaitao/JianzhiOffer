package com.frank.leetcode;
/*
 * Write a function to 
 *   find the longest common prefix string amongst an array of strings.
 * 
 */
public class L14LongestCommonPrefix {
	public static String longestCommonPrefix(String[] strs) {
		int lens=strs.length;
		if (lens==0)
			return "";
		if(lens==1)
			return strs[0];
		
		int min=strs[0].length();
		String comm=strs[0];
		for(int i=1;i<lens;i++){
			String c=strs[i];
			int l=Math.min(min, c.length());
			
			int ind=0;
			while(ind<=l-1){
				if(comm.charAt(ind)==c.charAt(ind)){
					ind++;
				}
				else{
					break;
				}
			}
			comm=c.substring(0, ind);
			min=ind;
		}
		
		
		return comm;
        
    }
	
	public static void main(String[] args) {
		String []test={"abcdbbb","abcd","abcd"};
		System.out.println(longestCommonPrefix(test));
	}
}
