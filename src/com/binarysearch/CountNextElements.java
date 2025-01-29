package com.binarysearch;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CountNextElements {
	public static void main(String[] args) {
		int numList[] = new int[] { 4, 2, 1, 3, 2 };
		System.out.println(solve(numList));
	}

	private static int solve(int[] nums) {
		// TODO Auto-generated method stub
		Set<Integer> numSet = new HashSet<>();
		for (Integer num : nums) {
			numSet.add(num);
		}
		int count = 0;
		for (int num : nums) {
			if(numSet.contains(num+1))
				count++;
		}
		return count;
	}
}
