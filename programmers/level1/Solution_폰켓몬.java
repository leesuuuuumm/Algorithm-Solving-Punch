package com.programmers;

import java.util.HashSet;

public class Solution_폰켓몬 {

	public static void main(String[] args) {
		int nums[] = { 3, 3, 3, 2, 2, 2 };
		solution(nums);
	}

	public static int solution(int[] nums) {

		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			set.add(nums[i]);
		}
		if (nums.length / 2 < set.size()) {
			// System.out.println(nums.length / 2);
			return nums.length / 2;
		}
		return set.size();
	}
}
