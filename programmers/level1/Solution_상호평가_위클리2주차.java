package com.programmers;

public class Solution_상호평가_위클리2주차 {
	public static void main(String[] args) {
		int scores[][] = { { 75, 50, 100 }, { 75, 100, 20 }, { 100, 100, 20 } };
		solution(scores);
	}

	public static String solution(int[][] scores) {
		StringBuilder sb = new StringBuilder();
		int myScore[] = new int[scores.length];
		for (int i = 0; i < scores.length; i++) {
			for (int j = 0; j < scores.length; j++) {
				if (i == j) {
					myScore[i] = scores[j][i];
				}
			}
		}
		for (int i = 0; i < scores.length; i++) {
			int sum = 0;
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			int cnt = 0;
			int avg = 0;
			int len = scores.length;
			for (int j = 0; j < scores.length; j++) {
				if (scores[j][i] == myScore[i]) {
					cnt++;
				}
				max = Math.max(scores[j][i], max);
				min = Math.min(scores[j][i], min);
				sum += scores[j][i];
			}
			if (cnt == 1) {
				if (myScore[i] == max || myScore[i] == min) {
					sum -= myScore[i];
					len -= 1;
				}
			}
			avg = sum / len;
			sb.append(avg >= 90 ? "A" : avg >= 80 ? "B" : avg >= 70 ? "C" : avg >= 50 ? "D" : "F");
		}
		System.out.println(sb);
		return sb.toString();
	}
}
