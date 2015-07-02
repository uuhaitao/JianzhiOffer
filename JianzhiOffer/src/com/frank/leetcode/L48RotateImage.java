package com.frank.leetcode;

public class L48RotateImage {
	public void rotate(int[][] matrix) {
		int n = matrix.length;
		for (int i = 1; i <= n / 2; i++) {
			for (int j = 0; j < n - 2 * i + 1; j++) {
				int left_up = matrix[i - 1][i - 1 + j];
				matrix[i - 1][i - 1 + j] = matrix[n - i - j][i - 1];// to
																	// left_up
				matrix[n - i - j][i - 1] = matrix[n - i][n - i - j];// to
																	// bottom_left
				matrix[n - i][n - i - j] = matrix[i - 1 + j][n - i];// bottom_right
				matrix[i - 1 + j][n - i] = left_up;
			}
		}
	}

	public static void main(String[] args) {
		new L48RotateImage().rotate(new int[][] { { 1, 2 }, { 3, 4 } });
	}
}
