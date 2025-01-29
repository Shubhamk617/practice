package com.binarysearch;

import java.util.HashSet;
import java.util.Set;

public class OnlyDuplicateInList {
	public static void main(String[] args) {
		int numList[] = new int[] { 4, 2, 1, 3, 2 };
		System.out.println(solve(numList));
	}

	private static int solve(int[] numList) {
		// TODO Auto-generated method stub
		Set<Integer> numSet = new HashSet<>();
		for (int num : numList) {
			if (numSet.contains(num))
				return num;
			else
				numSet.add(num);
		}
		return 0;
	}
}
