package com.programmers;

import java.util.Arrays;

public class Solution_정수내림차순으로배치하기 {
	public static void main(String[] args) {
		solution(118372);
	}

	public static long solution(long n) {
		long answer = 0;
		String s = String.valueOf(n);
		char c[] = s.toCharArray();
		StringBuilder sb = new StringBuilder();
		Arrays.sort(c);
		for (int i = c.length - 1; i >= 0; i--) {
			sb.append(c[i]);
		}
		System.out.println(sb);
		answer = Long.parseLong(sb.toString());

		return answer;
	}
}
