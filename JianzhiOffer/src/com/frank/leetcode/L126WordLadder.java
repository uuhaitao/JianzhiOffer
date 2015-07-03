package com.frank.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class L126WordLadder {

	public int ladderLength(String beginWord, String endWord,
			Set<String> wordDict) {
		if (beginWord == null || endWord == null || beginWord.equals(endWord))
			return 0;
		if (isOneChange(beginWord, endWord))
			return 2;
		HashMap<String, Integer> dist = new HashMap<String, Integer>();
		Queue<String> que = new LinkedList<String>();
		que.add(beginWord);
		dist.put(beginWord, 1);
		while (!que.isEmpty()) {
			String root = que.poll();
			int distance=dist.get(root);
			for (int i = 0; i < root.length(); i++) {
				for (char c = 'a'; c <= 'z'; c++) {
					if (c == root.charAt(i))
						continue;
					StringBuilder sb = new StringBuilder(root);
					sb.setCharAt(i, c);
					
					if(wordDict.contains(sb.toString())){
						if(sb.toString().equals(endWord))
							return distance+1;
						if(!dist.containsKey(sb.toString())){
							dist.put(sb.toString(), distance+1);
							que.add(sb.toString());
						}
					}
				}
			}
		}

		return 0;
	}

	boolean isOneChange(String a, String b) {
		if (a.equals(b))
			return false;
		int diff = 0;
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) != b.charAt(i))
				diff++;
			if (diff >= 2)
				return false;
		}
		return diff == 1;
	}

	public static void main(String[] args) {

	}

}
