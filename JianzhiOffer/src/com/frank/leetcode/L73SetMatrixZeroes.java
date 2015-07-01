package com.frank.leetcode;

public class L73SetMatrixZeroes {
	public void setZeroes(int[][] matrix) {
		int rows = matrix.length;
		int colums = matrix[0].length;
		int[] zerorows = new int[rows];
		int[] zerocols = new int[colums];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < colums; j++) {
				if (matrix[i][j] == 0) {
					zerorows[i] = 1;
					zerocols[j] = 1;
				}
			}
		}
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < colums; j++) {
				if (zerorows[i] == 1 || zerocols[j] == 1)
					matrix[i][j] = 0;
			}
		}

	}
}
