package com.programmers;

public class Solution_문자열다루기기본 {
	//matches로 풀어도 가능!!
	public static void main(String[] args) {

		String s = "123443453";
		solution(s);
	}

	public static boolean solution(String s) {
		boolean answer = true;
		System.out.println(s.length());
		if (s.length() == 4 || s.length() == 6) {
			for (int i = 0; i < s.length(); i++) {
				if (!(s.charAt(i) >= '0' && s.charAt(i) <= '9')) {
					answer = false;
					break;
				}
			}
		} else {
			answer = false;
		}
		System.out.println(answer);
		return answer;
	}
}
