package net.acmicpc;

import java.util.Scanner;

public class Solution_15651_N과M {

//nPr 중복

	static int N, R;
	static int arr[];
	static StringBuilder b = new StringBuilder();

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		N = scan.nextInt();
		R = scan.nextInt();
		arr = new int[R]; // 1

		nPr(0);
		System.out.print(b);

	}

	private static void nPr(int cnt) {
		if (cnt == R) {
			for (int i = 0; i < arr.length; i++) {
				b.append(arr[i]).append(" ");

			}
			b.append("\n");
			return;
		}
		for (int i = 0; i < N; i++) {
			arr[cnt] = i + 1;
			nPr(cnt + 1);

		}

	}

}
