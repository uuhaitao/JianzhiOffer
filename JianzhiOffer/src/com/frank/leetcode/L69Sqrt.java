package com.frank.leetcode;

public class L69Sqrt {
	public int mySqrt(int x) {
		 if (x < 0)
	            return -1;
	            
	        if (x == 0)
	            return 0; 

	        int low = 1; // the low should be set to 1. it's different from the search in array.
	        int high = x / 2 + 1; // the high should be set to x / 2 + 1
	        int mid;
	        
	        while (low <= high) {
	            
	            mid = (high + low)/ 2;
	            
	            if ((x / mid >= mid) && ((mid + 1) > x / (mid + 1))) { //to avoid overflow
	                return mid; 
	            } else if ( x / mid < mid ) {
	                high = mid - 1;
	            } else {
	                low = mid + 1;
	            }
	            
	        }
	        
	        return -1;
	}
	public static void main(String[] args) {
		int i=new L69Sqrt().mySqrt(2147395599);
		System.out.println(i);
	}
	
}
