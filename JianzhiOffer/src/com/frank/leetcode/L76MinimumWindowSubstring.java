package com.frank.leetcode;

public class L76MinimumWindowSubstring {
	public String minWindow(String s, String t) {
		if (t.equals("") || s.length() < t.length())
			return "";
		String res = "";

		int num = 0;
		int left=0;
		int right=0;
		int minlen = s.length() + 1;
		int required[] = new int[256];
		int has[] = new int[256];
		for (int i = 0; i < t.length(); i++) {
			required[t.charAt(i)]++;
		}
		for (int i = 0, j = 0; i < s.length(); i++) {
			int val = s.charAt(i);
				if(num<t.length())
				{
					if(has[val]<required[val])
						num++;
					has[val]++;
				}
				
				if(num==t.length())
				{
					while(j<=i && has[s.charAt(j)]-1>=required[s.charAt(j)])
					{
						has[s.charAt(j)]--;
						j++;
					}
					int tmplen=i-j+1;
					if(minlen>tmplen)
					{
						minlen=tmplen;
						left=j;
						right=i;
					}
					while(j<=i&&num==t.length())
					{
						has[s.charAt(j)]--;
						if(has[s.charAt(j)]<required[s.charAt(j)])
							num--;
						j++;
					}
				}
			}
		res=s.substring(left, right+1);
		
		return minlen==s.length()+1?"":res;
	}

	public static void main(String[] args) {
		String s = new L76MinimumWindowSubstring().minWindow("abbbadc","bd");
		System.out.println(s);
	}
}
