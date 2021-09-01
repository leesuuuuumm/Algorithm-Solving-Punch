package com.programmers;

public class Solution_2016 {
	public static void main(String[] args) {
		solution(2, 1);
	}

	public static String solution(int a, int b) {
		String answer = "";
		int lastDay[] = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		String weekDay[] = { "FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU" };
		int monthDay = 0;
		for (int i = 0; i < a - 1; i++) {
			monthDay += lastDay[i];
		}
		// System.out.println(monthDay);
		monthDay += (b - 1);
		// System.out.println(monthDay);
		answer = weekDay[monthDay % 7];
		// System.out.println(answer);
		return answer;
	}
}
