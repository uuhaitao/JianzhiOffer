package com.frank.leetcode;

public class L72EditDistance {
	public int minDistance(String word1, String word2) {

		int rows = word1.length();
		int cols = word2.length();
		if(rows==0)
			return cols;
		if(cols==0)
			return rows;
		int[][] distances = new int[rows][cols];
		for (int i = 0; i < rows; i++) {
			distances[i][0] = i;
		}
		for (int i = 0; i < cols; i++) {
			distances[0][i] = i;
		}
		for (int i = 1; i < rows; i++) {
			for (int j = 1; j < cols; j++) {
				if (word1.charAt(i - 1) == word2.charAt(j - 1))
					distances[i][j] = distances[i - 1][j - 1];
				else
					distances[i][j] = distances[i - 1][j - 1] + 1;
				distances[i][j] = Math.min(distances[i][j],
						Math.min(distances[i][j - 1], distances[i - 1][j]));
			}
		}

		return distances[rows - 1][cols - 1];
	}
}
