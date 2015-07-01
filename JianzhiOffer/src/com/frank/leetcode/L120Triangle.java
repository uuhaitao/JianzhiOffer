package com.frank.leetcode;

import java.util.ArrayList;
import java.util.List;

public class L120Triangle {
	public int minimumTotal(List<List<Integer>> triangle) {
		int res=Integer.MAX_VALUE;
		int size=triangle.size();
		List<Integer> min=new ArrayList<Integer>();
		min.add(triangle.get(0).get(0));
		for	(int i=1;i<size;i++){
			List<Integer> curr=triangle.get(i);
			List<Integer> currmin=new ArrayList<Integer>();
			currmin.add(min.get(0)+curr.get(0));
			for(int j=1;j<i;j++){
				currmin.add(Math.min(min.get(j), min.get(j-1))+curr.get(j));
			}
			currmin.add(min.get(i-1)+curr.get(i));
			min=currmin;
		}
		for(Integer e:min){
			if(e<res)
				res=e;
		}
		return res;
	}
	
	public static void main(String[] args) {
		List<List<Integer>> triangle=new ArrayList<List<Integer>>();
		List<Integer> line1=new ArrayList<Integer>();
		line1.add(-1);
		List<Integer> line2=new ArrayList<Integer>();
		line2.add(2);
		line2.add(3);
		List<Integer> line3=new ArrayList<Integer>();
		line3.add(1);
		line3.add(-1);
		line3.add(-3);
		triangle.add(line1);
		triangle.add(line2);
		triangle.add(line3);
		new L120Triangle().minimumTotal(triangle);
	}
}
