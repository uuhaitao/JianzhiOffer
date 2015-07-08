package com.frank.leetcode;

public class L168ExcelSheetColumnTitle {
	public String convertToTitle(int n) {
		StringBuilder sb = new StringBuilder();
		while (n > 0) {
			sb.insert(0, (char) ('A' + (n - 1) % 26));
			n = (n - 1) / 26;
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(Character.valueOf('s'));

	}
}
