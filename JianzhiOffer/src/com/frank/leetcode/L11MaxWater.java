package com.frank.leetcode;

/*
 * Given n non-negative integers a1, a2, ..., an, 
 * where each represents a point at coordinate (i, ai). 
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
 * Find two lines, which together with x-axis forms a container, 
 * such that the container contains the most water.
 * 
 */

public class L11MaxWater {
	public int maxArea(int[] height) {
        int res=0;
        int left=0;
        int right=height.length-1;
        while(left<right){
        	int cur=Math.min(height[left], height[right])*(right-left);
        	if(cur>res)
        		res=cur;
        	if(height[left]>=height[right])
        		right--;
        	else
        		left++;
        	
        	
        }
        return res;
    }
}
