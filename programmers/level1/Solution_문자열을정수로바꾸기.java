package com.programmers;

public class Solution_문자열을정수로바꾸기 {

	public static void main(String[] args) {
		String s = "-1234";
		solution(s);
	}

	public static int solution(String s) {
		if (s.charAt(0) == '-') return Integer.parseInt(s);

		return Integer.parseInt(s);
	}
}
