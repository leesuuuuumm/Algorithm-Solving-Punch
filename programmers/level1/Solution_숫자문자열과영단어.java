package com.programmers;

public class Solution_숫자문자열과영단어 {

	public static void main(String[] args) {
		String s = "one1threefour";
		solution(s);
	}

	public static int solution(String s) {
		int answer = 0;
		String[] num = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", };
		String[] str = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
		for (int i = 0; i < str.length; i++) {
			s = s.replace(str[i], num[i]);
		}
		System.out.println(s);
		return answer;
	}
}
