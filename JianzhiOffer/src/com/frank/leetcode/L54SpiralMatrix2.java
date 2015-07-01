package com.frank.leetcode;

import java.util.LinkedList;
import java.util.List;

public class L54SpiralMatrix2 {

	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> res = new LinkedList<Integer>();
		int rows = matrix.length;
		if (rows == 0)
			return res;
		int cols = matrix[0].length;

		boolean[][] visited = new boolean[rows][cols];
		helper(matrix, 0, 0, rows, cols, 0, visited, res);
		return res;
	}

	void helper(int[][] matrix, int i, int j, int rows, int clos, int dir,
			boolean[][] visited, List<Integer> res) {
		if (isok(i, j, rows, clos, visited)) {
			res.add(matrix[i][j]);
			visited[i][j] = true;
		}else{
			return;
		}	

		if (dir == 0) {
			if (isok(i, j + 1, rows, clos, visited)) {
				helper(matrix, i, j + 1, rows, clos, dir, visited, res);
			} else {
				helper(matrix, i + 1, j, rows, clos, (dir + 1) % 4, visited,
						res);
			}
		}

		if (dir == 1) {
			if (isok(i + 1, j, rows, clos, visited)) {
				helper(matrix, i + 1, j, rows, clos, dir, visited, res);
			} else {
				helper(matrix, i, j - 1, rows, clos, (dir + 1) % 4, visited,
						res);
			}
		}

		if (dir == 2) {
			if (isok(i, j - 1, rows, clos, visited)) {
				helper(matrix, i, j - 1, rows, clos, dir, visited, res);
			} else {
				helper(matrix, i - 1, j, rows, clos, (dir + 1) % 4, visited,
						res);
			}
		}
		if (dir == 3) {
			if (isok(i - 1, j, rows, clos, visited)) {
				helper(matrix, i - 1, j, rows, clos, dir, visited, res);
			} else {
				helper(matrix, i, j + 1, rows, clos, (dir + 1) % 4, visited,
						res);
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
		int matrix[][]={{1}};
		new L54SpiralMatrix2().spiralOrder(matrix);
	}
}
