package com.frank.leetcode;

public class L221MaximalSquare {
	public int maximalSquare(char[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return 0;
		int rows = matrix.length;
		int cols = matrix[0].length;
		int d[][] = new int[rows][cols];
		int max = 0;
		for (int i = 0; i < rows; i++) {
			if (matrix[i][0] == '1') {
				max = 1;
				d[i][0] = 1;
			}
		}
		for (int i = 0; i < cols; i++) {
			if (matrix[0][i] == '1') {
				max = 1;
				d[0][i] = 1;
			}
		}

		for (int i = 1; i < rows; i++) {
			for (int j = 1; j < cols; j++) {
				if (matrix[i][j] == '1') {
					d[i][j] = Math.min(Math.min(d[i][j - 1], d[i - 1][j]),d[i-1][j-1]) + 1;
					max = Math.max(max, d[i][j]);
				}
				else{
					d[i][j]=0;
				}
			}
		}
		return max * max;
	}
	public static void main(String[] args) {
		char[][] m={{'1','1'},{'1','1'}};
		int res=new L221MaximalSquare().maximalSquare(m);
		System.out.println(res);
	}
	
	
}
