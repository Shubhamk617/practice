package com.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class RotationGroups {

	public static void main(String[] args) {
		String words[] = new String[] { "abc", "xy", "yx", "z", "bca" };
		System.out.println(new RotationGroups().solve(words));
	}

	public int solve(String[] words) {
		ArrayList<String> set = new ArrayList<>();
		for (String word : words) {
			boolean exist = false;
			for (String rotation : set) {
				if (rotation.length() == word.length() * 2 && rotation.contains(word)) {
					exist = true;
					break;
				}
			}
			if (!exist) {
				set.add(word + word);
			}
			System.out.println(set.toString());
		}
		return set.size();
	}
}
