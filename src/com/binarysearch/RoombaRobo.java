package com.binarysearch;

public class RoombaRobo {

	public static void main(String[] args) {
		System.out.println(new RoombaRobo().solve(new String[] { "NORTH", "EAST", "NORTH" }, 1, 2));
	}

	private boolean solve(String[] moves, int x, int y) {
		for (int i = 0; i < moves.length; i++) {
			if (moves[i].equals("NORTH")) {
				--y;
			}

			if (moves[i].equals("SOUTH")) {
				++y;
			}

			if (moves[i].equals("EAST")) {
				--x;
			}

			if (moves[i].equals("WEST")) {
				++x;
			}
		}
		if (x == 0 && y == 0)
			return true;
		return false;
	}

	public int solve(int[] nums, int k) {
		int sum = 0;
		int max = -1;
		for (int i = 0; i < nums.length; i++) {
			sum = sum + nums[i];
			nums[i] = sum;
			if (nums[i] <= k)
				max = i;
		}
		return max;
	}

}
