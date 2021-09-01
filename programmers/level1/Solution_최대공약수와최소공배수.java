package com.programmers;

import java.util.Scanner;

public class Solution_최대공약수와최소공배수 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int M = scan.nextInt();
		int min = 0;
		int max = 0;
		if (M > N) {
			// 최대 공약수
			for (int i = 1; i <= N; i++) {
				if (N % i == 0 && M % i == 0) {
					max = i;
				}
			}
			// 최소 공배수
			for (int j = M; j <= (M * N); j++) {
				if (j % N == 0 && j % M == 0) {
					min = j;
					break;
				}

			}
		} else if (M < N) {
			for (int i = 1; i <= M; i++) {
				if (N % i == 0 && M % i == 0) {
					max = i;
				}
			}
			for (int j = N; j <= (M * N); j++) {
				if (j % N == 0 && j % M  == 0) {
					min = j;
					break;
				}

			}
		}
		System.out.println(max + " " + min);

	}
}
