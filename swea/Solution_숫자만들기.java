package com.swexpertacademy;

import java.util.Scanner;

public class Solution_숫자만들기 {

	static int ops[], opsCnt[], num[], max, min, N;// 연산자순열, 연산자 개수, 숫자배열(피연산자),최대값,최소값 ,숫자의 개수

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		opsCnt = new int[4];
		for (int t = 1; t <= T; t++) {
			N = scan.nextInt();
			num = new int[N]; // 숫자배열
			ops = new int[N - 1];// 연산자

			for (int i = 0; i < 4; i++) {
				opsCnt[i] = scan.nextInt();
			} // 연산자 개수 저장

			for (int i = 0; i < N; i++) {
				num[i] = scan.nextInt();
			} // 숫자 저장
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			permutation(0);

			System.out.println("#" + t + " " + (max - min));
		}
	}

	// +:0 -: 1 *: 2 /: 3
	private static void permutation(int cnt) { // 연산자의 순열 생성
		if (cnt == N - 1) // 연산자 순열 완성//cnt:연산자의 개수
		{
			calc();
			return;
		}
		// 중복순열 뽑았던거 또 뽑기
		// 모든 연산자를 다 시도해봄
		// i: 연산자
		for (int i = 0; i < 4; i++) {// +:0 -: 1 *: 2 /: 3 i의 숫자가 반복의 횟수이자 선택한 연산자
			if (opsCnt[i] == 0)
				continue;

			ops[cnt] = i;
			opsCnt[i]--;
			permutation(cnt + 1); // 다음으로 넘어가기
			opsCnt[i]++; // 안쓴것처럼 하고
		}

	}

	private static void calc() { // 연산자의 순열의 상태를 이용하여 수식계산

		int result = num[0];
		for (int i = 1; i < N; i++) {
			int currNum = num[i]; // 현재 숫자
			switch (ops[i - 1]) {
			case 0:
				result += currNum;
				break;
			case 1:
				result -= currNum;
				break;
			case 2:
				result *= currNum;
				break;
			case 3:
				result /= currNum;
				break;
			}
		}
		max = Math.max(max, result);
		min = Math.min(min, result);

	}

}