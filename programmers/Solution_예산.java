package com.programmers;

import java.util.Arrays;

public class Solution_예산 {
	public static void main(String[] args) {
		int num[] = { 2, 2, 3, 3 };
		solution(num, 10);
	}

	public static int solution(int[] d, int budget) {
		int answer = 0;
		int sum = 0;
		Arrays.sort(d);
		for (int i = 0; i < d.length; i++) {
			if ((sum += d[i]) <= budget) {
				System.out.print(sum + " ");
				answer++;
			} else break;
		}
		return answer;
	}
}
