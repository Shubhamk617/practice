package com.binarysearch;

import java.util.ArrayList;

public class CollatzSequence {

	public static void main(String[] args) {
		System.out.println(new CollatzSequence().solve(11));
	}

	public int solve(int n) {
		ArrayList<Integer> collatzSeqArrayList = new ArrayList<>();
		while (n != 1) {
			collatzSeqArrayList.add(n);
			if (n % 2 == 0) {
				n=n/2;
			}else if (n % 2 != 0) {
				n = 3 * n + 1;
			}else if (n == 1) {
				collatzSeqArrayList.add(n);
			}
		}
		System.out.println(collatzSeqArrayList);
		return collatzSeqArrayList.size()+1;
	}
	
	public int solveUsingRecurssion(int n) {
        if (n == 1)
            return 1;
        if (n % 2 == 0)
            return 1 + solve(n / 2);
        else
            return 1 + solve(3 * n + 1);
    }

}
