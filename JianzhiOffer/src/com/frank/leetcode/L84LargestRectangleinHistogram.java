package com.frank.leetcode;

import java.util.Stack;

public class L84LargestRectangleinHistogram {
	public int largestRectangleArea(int[] height) {
		Stack<Integer> st = new Stack<Integer>();
		int len = height.length;
		int i = 0;
		int maxarea = 0;
		while (i <= len) {
			int curr = 0;
			if (i < len)
				curr = height[i];
			if (st.isEmpty() || curr >= height[st.peek()]) {
				st.push(i);
				i++;
			} else {
				int ind = st.peek();
				st.pop();
				int length = st.isEmpty() ? i : i - st.peek() - 1;
				int tmp_max = height[ind] * length;
				if (tmp_max > maxarea)
					maxarea = tmp_max;
			}
		}

		return maxarea;
	}
}
