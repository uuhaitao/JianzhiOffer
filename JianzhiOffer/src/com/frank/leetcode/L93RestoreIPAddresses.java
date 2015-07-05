package com.frank.leetcode;

import java.util.ArrayList;
import java.util.List;

public class L93RestoreIPAddresses {
	public List<String> restoreIpAddresses(String s) {
		List<String> res = new ArrayList<String>();
		if(s.length()<4 || s.length()>12)
			return res;
		
		helper(s, res, 0, 0, "");
		return res;
	}

	void helper(String s, List<String> res, int start, int num, String pre) {
		int len = s.length();
		if (num == 3) {
			if (start < len) {
				String last = s.substring(start);
				if (isOk(last))
					res.add(pre + last);
			}
			return;
		}
		for (int i = 0; i < 3; i++) {
			if (start + i < len) {
				String curr = s.substring(start, start + i + 1);
				if (isOk(curr)) {
					helper(s, res, start + i + 1, num + 1, pre + curr + ".");
				}
			}
		}
	}

	boolean isOk(String s) {
		int val = Integer.valueOf(s);
		if (s.length() == 1)
			return val<=9 &&val>=0;
		if(s.length()==2)
			return val>=10 && val<=99;
		if(s.length()==3)
			return val>=100 && val<=255;
		return false;
	}

}
