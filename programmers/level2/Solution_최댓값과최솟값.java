package com.programmers2;

public class Solution_최댓값과최솟값 {
	public String solution(String s) {
		// String 배열에 " " 공백을 잘라 숫자만 넣어준다.
		String[] str = s.split(" ");
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		StringBuilder sb = new StringBuilder();
		// 숫자 비교해서 큰 수와 작은 수 뽑아낸다.
		for (int i = 0; i < str.length; i++) {
			max = Math.max(Integer.parseInt(str[i]), max);
			min = Math.min(Integer.parseInt(str[i]), min);
		}

		sb.append(min + " " + max);
		return sb.toString();
	}
}
