package com.frank.leetcode;


public class L59SpiralMatrix {
	public int[][] generateMatrix(int n) {
		int res[][] = new int[n][n];
		boolean visited[][] = new boolean[n][n];
		helper(res, 0, 0, n, n, 0, visited, 1);
		return res;
	}

	void helper(int res[][], int i, int j, int rows, int clos, int dir,
			boolean[][] visited, int val) {
		if (isok(i, j, rows, clos, visited)) {
			res[i][j] = val;
			visited[i][j] = true;
		} else {
			return;
		}

		if (dir == 0) {
			if (isok(i, j + 1, rows, clos, visited)) {
				helper(res, i, j + 1, rows, clos, dir, visited, val + 1);
			} else {
				helper(res, i + 1, j, rows, clos, (dir + 1) % 4, visited,
						val + 1);
			}
		}

		if (dir == 1) {
			if (isok(i + 1, j, rows, clos, visited)) {
				helper(res, i + 1, j, rows, clos, dir, visited, val + 1);
			} else {
				helper(res, i, j - 1, rows, clos, (dir + 1) % 4, visited,
						val + 1);
			}
		}

		if (dir == 2) {
			if (isok(i, j - 1, rows, clos, visited)) {
				helper(res, i, j - 1, rows, clos, dir, visited, val + 1);
			} else {
				helper(res, i - 1, j, rows, clos, (dir + 1) % 4, visited,
						val + 1);
			}
		}
		if (dir == 3) {
			if (isok(i - 1, j, rows, clos, visited)) {
				helper(res, i - 1, j, rows, clos, dir, visited, val + 1);
			} else {
				helper(res, i, j + 1, rows, clos, (dir + 1) % 4, visited,
						val + 1);
			}
		}

	}

	boolean isok(int i, int j, int rows, int cols, boolean[][] visited) {
		if (i >= 0 && j >= 0 && i < rows && j < cols) {
			return !visited[i][j];
		}
		return false;
	}

	public static void main(String[] args) {
//		int a=1;
//		int res[][]=new L59SpiralMatrix().generateMatrix(1);
		System.out.println();
	}
}
