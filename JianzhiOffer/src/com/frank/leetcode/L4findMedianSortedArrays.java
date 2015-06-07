package com.frank.leetcode;

import java.util.Arrays;

/*
 * There are two sorted arrays nums1 and nums2 of size m and n respectively. 
 * Find the median of the two sorted arrays. 
 * The overall run time complexity should be O(log (m+n)).
 */

public class L4findMedianSortedArrays {
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int len1=nums1.length;
		int len2=nums2.length;
		int[] num3=new int[len1+len2];
		for (int i=0;i<len1;i++){
			num3[i]=nums1[i];
		}
		for(int j=0;j<len2;j++){
			num3[len1+j]=nums2[j];
		}
		
		Arrays.sort(num3);
		int length=len1+len2;
		if(length%2==0){
			return (double)((num3[length/2]+num3[length/2-1])/2.0);
		}
		else
			return  (double)(num3[length/2]);
		
	}

	public static void main(String[] args) {

	}
	
	public double findKth(int a[],int a_start,int a_len,int []b,int b_start,int b_len,int k){
		if(a_len>b_len)
			return findKth( b,b_start,b_len,a,a_start,a_len, k);
		if (a_len==0)
			return b[b_start+k-1];
		if(k<=1)
			return Math.min(a[a_start], b[b_start]);
		
		int pa=Math.min(a_len, k/2);
		int pb=k-pa;
		
		if(a[a_start+pa-1]<b[b_start+pb-1])
			return findKth(a, a_start+pa, a_len-pa, b, b_start, b_len, k-pa);
		else
			return findKth(a, a_start, a_len, b, b_start+pb, b_len-pb, k-pb);
		
			} 
	
	public  double _findMedianSortedArrays(int[] nums1, int[] nums2) {
		int lena=nums1.length;
		int lenb=nums2.length;
		int len_sum=lena+lenb;
		if((len_sum& 1) ==1){
			return findKth(nums1, 0, lena, nums2, 0, lenb,len_sum/2+1);
		}
		else
			return (findKth(nums1, 0, lena, nums2, 0, lenb,len_sum/2)+
			findKth(nums1, 0, lena, nums2, 0, lenb,len_sum/2+1))/2.0;
		
	}

}
