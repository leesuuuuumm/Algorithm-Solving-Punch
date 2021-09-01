package com.programmers;

public class Solution_3진법뒤집기 {
	public static void main(String[] args) {
		solution(45);
	}

	public static int solution(int n) {
		int answer = 0;
		StringBuilder sb = new StringBuilder();
		while (true) {
			if (n < 3) {
				sb.append(n);
				break;
			}
			sb.append(n % 3);
			n = n / 3;
		}

		answer = Integer.parseInt(sb.toString(), 3);
		System.out.println(answer);
		return answer;
	}
}
