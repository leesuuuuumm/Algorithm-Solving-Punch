package com.programmers;

public class Solution_정수제곱근판별 {
	public static void main(String[] args) {
		solution(900);
	}

	public static long solution(long n) {
		double answer = 0;
		double result = Math.sqrt(n);
		System.out.println(result);
		if (n == 1)
			return 4;
		if (result % 1 == 0) {
			answer = (result + 1) * (result + 1);

			return (long) answer;
		}
		return -1;
	}
}
