package com.frank.leetcode;

public class L79WordSearch {
	public boolean exist(char[][] board, String word) {
		int len = word.length();
		if (len == 0)
			return true;
		int rows = board.length;
		int cols = board[0].length;
		boolean[][] visited=new boolean[rows][cols];
		char c0 = word.charAt(0);
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (board[i][j] == c0) {
					visited[i][j]=true;
					boolean find = getvalidate(board, rows, cols, i, j, word, 1,visited);
					if (find)
						return true;
					visited[i][j]=false;
				}

			}
		}
		return false;
	}

	boolean getvalidate(char[][] board, int rows, int cols, int i, int j,
			String word, int ind,boolean visited[][]) {
		if(ind>=word.length())
			return true;
		char c=word.charAt(ind);
		boolean res=false;
		if(isok(i, j-1, rows, cols) && !visited[i][j-1]&&board[i][j-1]==c){
			visited[i][j-1]=true;
			res=getvalidate(board, rows, cols, i, j-1, word, ind+1,visited);
			if(res)
				return true;
			visited[i][j-1]=false;
		}
		if(isok(i, j+1, rows, cols)&&!visited[i][j+1] && board[i][j+1]==c){
			visited[i][j+1]=true;
			res=getvalidate(board, rows, cols, i, j+1, word, ind+1,visited);
			if(res)
				return true;
			visited[i][j+1]=false;
		}
		if(isok(i-1, j, rows, cols) && !visited[i-1][j]&&board[i-1][j]==c){
			visited[i-1][j]=true;
			res=getvalidate(board, rows, cols, i-1, j, word, ind+1,visited);
			if(res)
				return true;
			visited[i-1][j]=false;
		}
		if( isok(i+1, j, rows, cols) && !visited[i+1][j]&&board[i+1][j]==c){
			visited[i+1][j]=true;
			res=getvalidate(board, rows, cols, i+1, j, word, ind+1,visited);
			if(res)
				return true;
			visited[i+1][j]=false;
		}
		
		return false;
	}
	
	boolean isok(int i,int j,int rows, int cols){
		return (i>=0 && j>=0 && i<rows && j<cols);
	}
	public static void main(String[] args) {
		char b[][]={{'a','a'},{'a','a'}};
		String test="aaaaa";
		boolean res=new L79WordSearch().exist(b, test);
		System.out.println(res);
		
	}

}
