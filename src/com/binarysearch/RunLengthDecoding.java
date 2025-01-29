package com.binarysearch;

public class RunLengthDecoding {
	public static void main(String[] args) {
		System.out.println(new RunLengthDecoding().solve("4a3b2c1d"));
	}

	public String solve(String s) {
		StringBuilder sb = new StringBuilder();
		int v = 0;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isDigit(c)) {
				v = (v * 10) + Integer.parseInt("" + c);
			} else {
				for (int k = 0; k < v; k++) {
					sb.append(c);
				}
				v = 0;
			}
		}

		return sb.toString();
	}

}
