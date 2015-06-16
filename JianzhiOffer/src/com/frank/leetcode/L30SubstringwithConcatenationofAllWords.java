package com.frank.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * 
 */

public class L30SubstringwithConcatenationofAllWords {

	boolean isok(String[] my, String sub, int len, int num) {
		if (sub.length() < len * num) {
			return false;
		}
		String now = sub;
		for (int i = 0; i < num; i++) {
			if (now.contains(my[i])) {
				int ind = now.indexOf(my[i]);
				String left=now.substring(0, ind)+"#";
				String right=now.substring(ind+len);
				now =left+right;
//				System.out.println(now);
			} else
				return false;
		}

		return true;
	}

	public List<Integer> findSubstring(String s, String[] words) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		int la = s.length();
		int lb = words.length;
		if (la < lb)
			return res;

		int len = words[0].length();
		for (int i = 0; i < la; i++) {
			int end = i + len * lb;
			end = end > la ? la : end;
			String sub = s.substring(i, end);
			if (isok(words, sub, len, lb)) {
				res.add(i);
			}
		}

		return res;
	}

	public static void main(String[] args) {
		String[] my = new String[] { "fooo", "barr", "wing", "ding", "wing" };

		boolean b = new L30SubstringwithConcatenationofAllWords().isok(my,
				"lingmindraboofooowingdingbarrwingmonkeypoundcake", 4, 5);
		System.out.println(b);

		List<Integer> l = new L30SubstringwithConcatenationofAllWords()
				.findSubstring("lingmindraboofooowingdingbarrwingmonkeypoundcake",
						my);
		for (Integer k : l)
			System.out.println(k);

	}
}
