package com.binarysearch;

public class NoOfIterations {
	public static void main(String[] args) {
		System.out.println(solve(3, 14));
	}

	private static int solve(int start, int end) {
		// TODO Auto-generated method stub
		int ops = 0;
		while (end / 2 >= start) {
			ops += 1 + (end % 2);
			end /= 2;
		}
		return ops + end - start;
	}
}
