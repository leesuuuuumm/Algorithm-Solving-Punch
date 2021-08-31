package com.programmers;

public class Solution_신규아이디추천 {
	//substring 사용해보기 , 정규식도 사용해보기
	public static void main(String[] args) {
		System.out.println(solution("b"));
	}

	public static String solution(String new_id) {
		String answer = "";
		String result = "";
		StringBuilder sb = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		int cnt = 0;
		// 1단계 - 모든 대문자를 소문자 치환
		new_id = new_id.toLowerCase();
		// 2단계 - 특정 특수문자 제외 제거하기
		answer = new_id.replaceAll("[~$%^&*\\(\\)\\=\\+\\[\\{\\]\\}\\:\\?\\,\\<\\>\\/\\!@#]", "");
		// 3단계 - .이 2번 이상 연속된 부분을 하나의 마침표로 치환
		if (answer.length() == 1)
			sb.append(answer);
		else {
			for (int i = 0; i < answer.length() - 1; i++) {
				if (answer.charAt(i) == '.') {
					cnt++;
				}
				if (answer.charAt(i) == '.' && cnt == 1) {
					sb.append(answer.charAt(i));
				}
				if (answer.charAt(i) != '.') {
					sb.append(answer.charAt(i));
					cnt = 0;
				}
				if (i == answer.length() - 2 && answer.charAt(answer.length() - 1) != '.') {
					sb.append(answer.charAt(answer.length() - 1));
				}
			}
		}

		System.out.println(answer);
		// 4단계 .이 처음이나 끝에 위치한다면 제거
		if (sb.length() > 0 && sb.charAt(0) == '.') {
			sb.deleteCharAt(0);
		}

		if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '.') {
			sb.deleteCharAt(sb.length() - 1);
		}
		// 5단계 빈 문자열이라면 a 대임
		if (sb.length() == 0) {
			sb.append("a");
		}
		// 6단계 길이가 16자 이상이면, 15문자 제외하고 나머지 문자 제고
		if (sb.length() >= 16) {
			for (int i = 0; i < 15; i++) {
				sb2.append(sb.charAt(i));
			}
			if (sb2.charAt(sb2.length() - 1) == '.') {
				sb2.deleteCharAt(sb2.length() - 1);
			}
			result = sb2.toString();
			return result;
		}

		System.out.println(sb2);
		// 7단계 길이가 2자 이하라면 길이가 3이 될 때까지 마지막 반복해서 붙임
		if (sb.length() <= 2) {
			while (sb.length() < 3) {
				sb.append(sb.charAt(sb.length() - 1));
			}
			result = sb.toString();
			return result;
		}
		result = sb.toString();
		return result;
	}
}
