package com.frank.leetcode;

public class L63UniquePaths2 {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m=obstacleGrid.length;
		int n=obstacleGrid[0].length;
		int res[][]=new int [m][n];
		if(obstacleGrid[0][0]==1)
			return 0;
		res[0][0]=1;
		for(int i=1;i<m;i++){
			if(obstacleGrid[i][0]==0)
				res[i][0]=res[i-1][0];
			else
				res[i][0]=0;
		}
		for(int j=1;j<n;j++){
			if(obstacleGrid[0][j]==0)
				res[0][j]=res[0][j-1];
			else
				res[0][j]=0;
		}
		
		for(int i=1;i<m;i++)
		{
			for(int j=1;j<n;j++)
			{
				res[i][j]=obstacleGrid[i][j]==0?(res[i-1][j]+res[i][j-1]):0;
			}
		}
		return res[m-1][n-1];
	}
}
