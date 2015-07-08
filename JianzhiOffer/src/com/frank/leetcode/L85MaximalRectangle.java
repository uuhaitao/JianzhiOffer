package com.frank.leetcode;

import java.util.Stack;

public class L85MaximalRectangle {
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

	public int maximalRectangle(char[][] matrix) {
		int rows = matrix.length;
		if (rows == 0)
			return 0;
		int colums = matrix[0].length;

		int[] line = new int[colums];
		for (int m = 0; m < colums; m++) {
			line[m] = matrix[0][m] == '0' ? 0 : 1;
		}
		int maxarea = largestRectangleArea(line);

		for (int i = 1; i < rows; i++) {
			int currline[] = new int[colums];
			for (int j = 0; j < colums; j++) {
				currline[j] = matrix[i][j] == '0' ? 0 : line[j] + 1;
			}
			int area = largestRectangleArea(currline);
			if (area > maxarea)
				maxarea = area;
			line = currline;
		}
		return maxarea;
	}
	
	public static void main(String[] args) {
		char matrix[][]={
				"11111101111111110111110111111111111110111101111111111111111111011111111011111111111111101110111110111111111001101111111111111011111111111111111001111111111111111111111111111111111101111101111111111110".toCharArray(),
				"11111111111111101111111111111100111111111111111111111110111111111111111111111111101111111111011111111111111111111111111110111111111011111111111111111111111111111111111011111111111111001111111111111111".toCharArray(),
				"01101101111111111111111111111111111111101111111111111111111101111111111111011110111111010111111111111111111111011111010111111111111111111111111111111111111011101111111111111111011111111111101111111100".toCharArray(),
				"11111111011111111111111011111111111111111111111110111101111111111111111111101111111111111111111111111101011111111111110111111110110111111101111111111111111111111111100111111111101111101111101011111111".toCharArray(),
				"11111111111111111111110011111111111111111111101111101111111111111111111111111111111111111111111111111111111111111111111111111111011101111101011111111111111111111111110111101111111111101111111111111111".toCharArray(),
				"11111110111101110111111111111111111111111111111111111111111111111111101111111111111111110101111111101111011111111111110111101111101111111111111111111011101111111111111111111111111101101101111110111111".toCharArray(),
				"11111111111111111101111111111111111101111111111111111111111111111111111111111111111111111111010111110111110111110111111111101110111111111111111111111110101111111110111111111111101110110111111101111111".toCharArray(),
				"10111111111101111111111111111111111111111111111111111111111110011111101011011111111011111111111110111111111111111111111111111100101011001101111111011111111111011111111111101111111111111111111111101110".toCharArray()
				
		};
		
		new L85MaximalRectangle().maximalRectangle(matrix);
		
	}

}