package com.programmers;

import java.util.Arrays;

public class Solution_실패율 {
	public static void main(String[] args) {
		int stages[] = { 2, 1, 2, 4, 2, 4, 3, 3 };
		solution(5, stages);
	}

	public static int[] solution(int N, int[] stages) {
		int[] answer = new int[N];
		float[] failureRate = new float[N];
		float[] sorts = new float[N];
		float fail = 0f;
		float user = 0f;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < stages.length; j++) {
				if (stages[j] == i + 1) {
					fail++;
				}
				if (stages[j] >= i + 1) {
					user++;
				}

			}
			//나눠줄 때 분모가 0일 경우는 NaN이 뜸 그래서 체크해줘야함 !!!
			failureRate[i] = user==0?0:(fail / user);
			sorts[i] = user==0?0:(fail / user);

			fail = 0;
			user = 0;
		}

		Arrays.sort(sorts);
		boolean visited[] = new boolean[N];
		for (int i = 0; i < sorts.length; i++) {
			System.out.println(sorts[i]);
		}
		for (int i = 0; i < failureRate.length; i++) {
			System.out.println(failureRate[i]);
		}

		for (int i = sorts.length - 1; i >= 0; i--) {
			a: for (int j = 0; j < failureRate.length; j++) {
				if (sorts[i] == failureRate[j] && !visited[j]) {
					visited[j] = true;
					answer[Math.abs(i - (N - 1))] = j + 1;
					// System.out.println(Math.abs(i-4)+" "+(j+1));
					// System.out.println();
					break a;
				}
			}
		}
//		for (int i = 0; i < answer.length; i++) {
//			System.out.print(answer[i]);
//		}

		return answer;
	}
}
