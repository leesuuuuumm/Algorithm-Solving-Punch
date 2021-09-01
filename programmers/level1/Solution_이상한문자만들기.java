package com.programmers;

public class Solution_이상한문자만들기 {
	public static void main(String[] args) {
		solution("try hello world");
	}

	public static String solution(String s) {
		char ch[] = s.toCharArray();
		StringBuilder sb = new StringBuilder();
		int k = 0;
		for (int i = 0; i < s.length(); i++) {

			if (ch[i] == ' ') {
				k = 0;
				sb.append(" ");
				continue;
			}
			if (k % 2 == 0) {
				sb.append(s.valueOf(ch[i]).toUpperCase());
			}
			if (k % 2 == 1) {
				sb.append(s.valueOf(ch[i]).toLowerCase());
			}
			k++;
		}
		System.out.println(sb);
		return sb.toString();
	}
}
