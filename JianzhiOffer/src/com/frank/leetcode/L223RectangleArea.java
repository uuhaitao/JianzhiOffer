package com.frank.leetcode;

public class L223RectangleArea {
	public int computeArea(int A, int B, int C, int D, int E, int F, int G,int H) {
		int res=(C-A)*(D-B)+(G-E)*(H-F);
		int up=Math.min(D, H);
		int bottom=Math.max(B, F);
		int left=Math.max(A, E);
		int right=Math.min(C, G);
		if(up<=bottom || right<=left){
			return res;
		}
		res-=(up-bottom)*(right-left);
		return res;
	}
}
