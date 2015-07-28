package com.frank.leetcode;

public class L130SurroundedRegions {
	public void solve(char[][] board) {
		if (board == null || board.length <= 2 || board[0].length <= 2)
			return;
		int rows = board.length;
		int cols = board[0].length;

		// up
		for (int j = 0; j < cols; j++) {
			if (board[0][j] == 'O')
				dfs(board, 0, j);
		}

		// down
		for (int j = 0; j < cols; j++) {
			if (board[rows - 1][j] == 'O')
				dfs(board, rows - 1, j);
		}

		// left
		for (int i = 0; i < rows; i++) {
			if (board[i][0] == 'O')
				dfs(board, i, 0);
		}
		// right
		for (int i = 0; i < rows; i++) {
			if (board[i][cols - 1] == 'O')
				dfs(board, i, cols - 1);
		}
		for(int i=0;i<rows;i++){
			for(int j=0;j<cols;j++)
			{
				if(board[i][j]!='X')
					board[i][j]=board[i][j]=='1'?'O':'X';
			}
		}
	}

	void dfs(char[][] board, int i, int j) {
		if (i < 0 || j < 0 || i >= board.length || j >= board[0].length)
			return;
		if (board[i][j] == 'O') {
			board[i][j] = '1';
			dfs(board, i + 1, j);
			dfs(board, i - 1, j);
			dfs(board, i, j + 1);
			dfs(board, i, j - 1);
		}
	}

}
