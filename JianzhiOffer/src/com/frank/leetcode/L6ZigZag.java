package com.frank.leetcode;

public class L6ZigZag {

	/*
	 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given
	 * number of rows like this: (you may want to display this pattern in a
	 * fixed font for better legibility) P A H N A P L S I I G Y I R
	 */

	public static String convert(String s, int numRows) {
		String []lines=new String[numRows];
		for (int i=0;i<numRows;i++){
			lines[i]="";
		}
		char []a=s.toCharArray();
		int dir=-1;
		int row=0;
		
		for (int i=0;i<a.length;i++){
			lines[row]+=""+a[i];
			if(row==0 || row==numRows-1)
				dir*=-1;
			row+=dir;
			row%=numRows;
		}
			
		String res="";
		for (String line : lines)
			res+=line;
		return res;
	}

	public static void main(String[] args) {
		System.out.println(convert("AB", 1));
	}

}
