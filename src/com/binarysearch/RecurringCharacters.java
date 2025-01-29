package com.binarysearch;

import java.util.HashMap;
import java.util.HashSet;

public class RecurringCharacters {
	public static void main(String[] args) {
		System.out.println(new RecurringCharacters().solveUsingMap("abcbcda"));
	}

	public int solveUsingSet(String s) {
		HashSet<String> setOfChar = new HashSet<>();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (setOfChar.contains(String.valueOf(ch)))
				return i + 1;
			else
				setOfChar.add(String.valueOf(ch));
		}
		return -1;
	}

	public int solveUsingMap(String s) {
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			if (map.get(s.charAt(i)) != null)
				return i;
			map.put(s.charAt(i), 0);
		}
		return -1;
	}

}
	