package com.binarysearch;

import java.util.StringTokenizer;

public class ReverseWords {
	public static void main(String[] args) {
		String sentence = "hello there my friend";
		System.out.println(solve(sentence));
	}

	private static String solve(String sentence) {
		// TODO Auto-generated method
		StringTokenizer tokenizer = new StringTokenizer(sentence);
		String strReversedLine = "";
		while (tokenizer.hasMoreTokens()) {
			strReversedLine = tokenizer.nextToken() + " " + strReversedLine;
		}
		return strReversedLine.trim();
	}

}
