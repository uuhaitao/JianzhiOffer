package com.frank.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * 
 */
public class L17AllpossiblePhoneNum {

	List<String> result = new ArrayList<String>();  
	public List<String> letterCombinations(String digits) {
		if(digits.length()<1)
			return result;
		
        String[] map = new String[10];  
        map[0] = "";  
        map[1] = "";  
        map[2] = "abc";  
        map[3] = "def";  
        map[4] = "ghi";  
        map[5] = "jkl";  
        map[6] = "mno";  
        map[7] = "pqrs";  
        map[8] = "tuv";  
        map[9] = "wxyz"; 
        rec_add("",digits,0,map);
        return result;
	}
	public void rec_add(String prex, String digits, int ind, String[] map){
		
		if(ind==digits.length())
			result.add(prex);
		else{
			String cur=map[digits.charAt(ind)-'0'];
			for (char c :cur.toCharArray()){
				String now=prex+c;
				rec_add(now,digits,ind+1,map);
			}
		}
	}
	

	public static void main(String[] args) {

	}

}
