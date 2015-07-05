package com.frank.leetcode;

public class L165CompareVersionNumbers {
	public int compareVersion(String version1, String version2) {
		
		

		String v1s[] = version1.split("\\.");
		String v2s[] = version2.split("\\.");
		
		for(int i=0;i<Math.max(v1s.length, v2s.length);i++){
			int right1 = v1s.length > i ? Integer.valueOf(v1s[i]) : 0;
			int right2 = v2s.length > i ? Integer.valueOf(v2s[i]) : 0;
			if(right1>right2)
				return 1;
			else if(right1<right2)
				return -1;
		}
		return 0;
	}
	
	public static void main(String[] args) {
//		new L165CompareVersionNumbers().compareVersion("0", "1");
		String test="1.2,2";
		System.out.println(test.split("\\.|,").length);
	}
}
