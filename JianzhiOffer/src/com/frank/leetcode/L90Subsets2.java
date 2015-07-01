package com.frank.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L90Subsets2 {
	public List<List<Integer>> subsets(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		generate(nums,0,res,nums.length);
		res.add(new ArrayList<Integer>());
		return res;
	}
	void generate(int[] nums,int ind,List<List<Integer>> res,int len){
		if(ind>=len)
			return;
		List<Integer> curr=new ArrayList<Integer>();
		if(ind==0 || nums[ind]!=nums[ind-1])
			curr.add(nums[ind]);
		int size=res.size();
		for(int i=0;i<size;i++){
			List<Integer> m=new ArrayList<Integer>(res.get(i));
			m.add(nums[ind]);
			if(!res.contains(m))
			res.add(m);
		}
		if(curr.size()>0)
		res.add(curr);
		generate(nums, ind+1, res, len);
	}
	public static void main(String[] args) {
		new L90Subsets2().subsets(new int[]{1,1});
	}
	
}
