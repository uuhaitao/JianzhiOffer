package com.frank.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L39CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {

		List<List<Integer>> res=new ArrayList<List<Integer>>();
		if(candidates.length==0)
			return res;
		Arrays.sort(candidates);
		core(candidates,0,target,res,new ArrayList<Integer>());
		return res;
	}
	public void core(int [] candidates, int start,int target,List<List<Integer>> res,List<Integer> item){
		if(target==0){
			res.add(new ArrayList<Integer>(item));
			return;
		}
		if(target<0)
			return;
		List<Integer> tmp=new ArrayList<Integer>(item);
		for(int i=start;i<candidates.length;i++){
			if(i>0 && candidates[i]==candidates[i-1])
				continue;
			tmp.add(candidates[i]);
			core(candidates,i,target-candidates[i],res,tmp);
			tmp.remove(tmp.size()-1);
		}
	}
	
	public static void main(String[] args) {
		List<List<Integer>> res=new L39CombinationSum().combinationSum(new int[]{1}, 1);
		for(List<Integer> e:res){
			for(Integer i:e)
				System.out.print(" "+i);
			System.out.println();
		}
	}
	
}
