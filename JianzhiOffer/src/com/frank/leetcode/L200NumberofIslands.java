package com.frank.leetcode;

/**
 * Created by haitao on 7/21/15.
 */
public class L200NumberofIslands {
    int rows;
    int colums;
    public int numIslands(char[][] grid) {

        if (grid.length==0 || grid[0].length==0)
            return 0;
        rows=grid.length;
        colums=grid[0].length;

        int num=0;

        for (int i=0;i<rows;i++)
        {
            for (int j=0;j<colums;j++)
            {
                if (grid[i][j]=='0')
                    continue;
                else
                    num++;
                dfs(grid,i,j);
            }
        }

        return num;


    }

    void dfs(char [][]grid,int i,int j)
    {
        if (i<0||i>=rows||j<0||j>=colums)
            return;
        if(grid[i][j]=='1')
        {
            grid[i][j]='0';
            dfs(grid,i-1,j);
            dfs(grid,i+1,j);
            dfs(grid,i,j+1);
            dfs(grid,i,j-1);
        }
    }
}
