package com.binarysearch;

import java.util.Iterator;
import java.util.Scanner;

public class RemoveLetterAndFormWord {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter first Word:");
		String firstWord = sc.next();
		System.out.print("Enter first Word:");
		String secondWord = sc.next();
		System.out.println(solve(firstWord, secondWord));
	}

	public static boolean solve(String s, String t) {
		if (s.length() - 1 != t.length())
			return false;

		int j = 0;
		for (int i = 0; i < s.length(); i++) {
			if (j == t.length())
				break;
			if (t.charAt(j) == s.charAt(i))
				j++;
		}
		return j == t.length();
	}
}
