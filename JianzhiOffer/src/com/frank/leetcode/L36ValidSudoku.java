package com.frank.leetcode;

import java.util.HashMap;
import java.util.Map;

public class L36ValidSudoku {
	public boolean isValidSudoku(char[][] board) {
		if (board.length == 0 || board[0].length == 0)
			return true;
		int rows = board.length;
		int cols = board[0].length;
		Map<Character, Boolean> map = new HashMap<Character, Boolean>();
		for (int i = 0; i < rows; i++) {
			map.clear();
			for (int j = 0; j < cols; j++) {
				char val = board[i][j];
				if (val == '.')
					continue;
				if (map.containsKey(val))
					return false;
				map.put(val, true);
			}
		}
		for (int j = 0; j < cols; j++) {
			map.clear();
			for (int i = 0; i < rows; i++) {

				char val = board[i][j];
				if (val == '.')
					continue;
				if (map.containsKey(val))
					return false;
				map.put(val, true);
			}
		}

		for (int i = 0; i < rows; i+=3) {
			for (int j = 0; j < cols; j+=3) {
				map.clear();
				for (int a = i; a < rows && a < i + 3; a++) {
					for (int b = j; b < cols && b < j + 3; b++) {
						char val = board[a][b];
						if (val == '.')
							continue;
						if (map.containsKey(val))
							return false;
						map.put(val, true);
					}
				}
			}
		}

		return true;
	}

	public static void main(String[] args) {
		String test[] = new String[] { "..5.....6", "....14...", ".........",
				".....92..", "5....2...", ".......3.", "...54....",
				"3.....42.", "...27.6.." };
		for (String a : test) {
			for (char c : a.toCharArray()) {
				System.out.print("\'" + c + "\'" + ",");
			}
			System.out.println();
		}

		char[][] board = new char[][] {
				{ '.', '.', '5', '.', '.', '.', '.', '.', '6' },
				{ '.', '.', '.', '.', '1', '4', '.', '.', '.' },
				{ '.', '.', '.', '.', '.', '.', '.', '.', '.' },
				{ '.', '.', '.', '.', '.', '9', '2', '.', '.', },
				{ '5', '.', '.', '.', '.', '2', '.', '.', '.', },
				{ '.', '.', '.', '.', '.', '.', '.', '3', '.', },
				{ '.', '.', '.', '5', '4', '.', '.', '.', '.', },
				{ '3', '.', '.', '.', '.', '.', '4', '2', '.', },
				{ '.', '.', '.', '2', '7', '.', '6', '.', '.', }
				};
		boolean res = new L36ValidSudoku().isValidSudoku(board);
		System.out.println(res);
	}
}
