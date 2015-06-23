package com.frank.leetcode;

public class L64MinimumPathSum {
	public int minPathSum(int[][] grid) {
		int rows = grid.length;
		int colums = grid[0].length;
		int[][] dp = new int[rows][colums];
		
		for (int i = 0; i < rows ; i++) {
			for (int j = 0; j < colums ; j++) {
				if (i == 0 && j == 0) {
					dp[i][j] = grid[i][j];
				}else if(i==0 && j!=0){
					dp[i][j]=dp[i][j-1]+grid[i][j];
				} 
				else if(j==0 && i!=0){
					dp[i][j]=dp[i-1][j]+grid[i][j];
				}
				
				else {
					dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1])
							+ grid[i][j];
				}
			}
		}
		return dp[rows - 1][colums - 1];

	}
}
