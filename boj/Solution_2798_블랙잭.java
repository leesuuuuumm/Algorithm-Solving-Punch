package com.ssafy;

import java.util.Scanner;

public class Solution_2798_블랙잭{
 
	static int arr[], num[], N, M, min = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		M = scan.nextInt(); // 총 합
		num = new int[N];
		int count = 0;
		for (int i = 0; i < N; i++) {
			num[i] = scan.nextInt();
		}
		arr = new int[3];
		nCr(0, 0);
		System.out.println(M - min);
	}

	private static void nCr(int cnt, int start) {
		if (cnt == 3) {
			int sum = 0;
			for (int i = 0; i < 3; i++) {
				sum += arr[i];
//				System.out.print("i는 "+ i);
//				System.out.println(" arr : "+arr[i]);
//				System.out.println("sum : "+sum);	
			}
			if (sum <= M) {
				int abs = Math.abs(M - sum);
				min = Math.min(abs, min);
			}
//			System.out.println("abs : "+abs);
//			System.out.println("min : "+min);
//
//			System.out.println("===============");
			return;
		}
		for (int i = start; i < N; i++) {
			arr[cnt] = num[(i - 1) + 1];
			nCr(cnt + 1, i + 1);
		}

	}
}
