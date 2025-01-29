package com.binarysearch;

public class RemoveNumberOfTripplets {
	public static void main(String[] args) {
		System.out.println(new RemoveNumberOfTripplets().solve("11000111000"));
	}

	public int solve(String s) {
		int c = 0;
		for (int i = 0; i < s.length() - 2; i++) {
			if ((s.charAt(i) == '1' && s.charAt(i + 1) == '1' && s.charAt(i + 2) == '1')
					|| (s.charAt(i) == '0' && s.charAt(i + 1) == '0' && s.charAt(i + 2) == '0')) {
				c++;
				i=i+2;
			}
		}
		return c;
	}

}
