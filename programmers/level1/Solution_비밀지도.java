package com.programmers;
//| 연산자 사용해보기
public class Solution_비밀지도 {
	public static void main(String[] args) {
		int arr1[] = { 9, 20, 28, 18, 11 };
		int arr2[] = { 30, 1, 21, 17, 28 };
		solution(5, arr1, arr2);
	}
	public static String[] solution(int n, int[] arr1, int[] arr2) {
		StringBuilder app = new StringBuilder();
		String[] answer = new String[n];
		String[][] map = new String[n][n];
		for (int i = 0; i < arr1.length; i++) {
			String s = Integer.toBinaryString(arr1[i]);
			StringBuilder sb = new StringBuilder();
			if (s.length() != n) {
				while (sb.length() != n - s.length()) {
					sb.append(0);
				}
				sb.append(s);
			} else
				sb.append(s);
			s = sb.toString();
			for (int j = 0; j < s.length(); j++) {
				map[i][j] = s.charAt(j) == '1' ? "#" : " ";
			}
		}
		for (int i = 0; i < arr2.length; i++) {
			String s = Integer.toBinaryString(arr2[i]);
			StringBuilder sb = new StringBuilder();
			if (s.length() != n) {
				while (sb.length() != n - s.length()) {
					sb.append(0);
				}
				sb.append(s);
			} else
				sb.append(s);
			s = sb.toString();
			for (int j = 0; j < s.length(); j++) {
				if (s.charAt(j) == '1') {
					map[i][j] = "#";
				}
			}
		}
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				answer[i] = app.append(map[i][j]).toString().trim();
			}
			app.setLength(0);
		}
		return answer;
	}
}
