package com.programmers;

public class Solution_신규아이디추천_ref {

	public static void main(String[] args) {
		System.out.println(solution("...!@BaT#*..y.abcdefghijklm"));
	}

	public static String solution(String new_id) {
		StringBuilder sb = new StringBuilder();

		// 1,2단계
		new_id = new_id.toLowerCase().replaceAll("[~\\%\\^\\&\\*\\(\\)\\=\\+\\[\\{\\]\\}\\:\\?\\,\\<\\>\\/\\!\\@\\#\\$]", "");

		// 3단계
		sb.append(new_id.replaceAll("[.]{2,}", ".")); // .이 두개이상 {}들어가는 건 범위 .의 개수 범위

		// 4단계
		if (sb.length() > 0 && sb.charAt(0) == '.')
			sb.deleteCharAt(0);
		if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '.')
			sb.deleteCharAt(sb.length() - 1);

		// 5단계
		if (sb.length() == 0)
			sb.append("a");

		// 6단계
		if (sb.length() > 15) {
			sb.delete(15, sb.length());
			if (sb.charAt(sb.length() - 1) == '.')
				sb.deleteCharAt(sb.length() - 1);
		}

		// 7단계
		while (sb.length() <= 2) {
			sb.append(sb.charAt(sb.length() - 1));
		}
		return sb.toString();
	}
}
