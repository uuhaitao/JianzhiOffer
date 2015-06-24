package com.frank.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L216CombinationSum2 {
	public List<List<Integer>> combinationSum(int k, int n) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		int[] candidates = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		Arrays.sort(candidates);
		core(candidates, 0, n, res, new ArrayList<Integer>(), k);
		return res;
	}

	public void core(int[] candidates, int start, int target,
			List<List<Integer>> res, List<Integer> item,int k) {
		if(item.size()>k)
			return;
		if (item.size()==k && target == 0) {
			res.add(new ArrayList<Integer>(item));
			return;
		}
		if (target < 0)
			return;
		List<Integer> tmp = new ArrayList<Integer>(item);
		for (int i = start; i < candidates.length; i++) {
			if (i > 0 && candidates[i] == candidates[i - 1])
				continue;
			tmp.add(candidates[i]);
			core(candidates, i+1, target - candidates[i], res, tmp,k);
			tmp.remove(tmp.size() - 1);
		}
	}

	public static void main(String[] args) {
		List<List<Integer>> res = new L216CombinationSum2().combinationSum(
				3, 7);
		for (List<Integer> e : res) {
			for (Integer i : e)
				System.out.print(" " + i);
			System.out.println();
		}
	}

}
