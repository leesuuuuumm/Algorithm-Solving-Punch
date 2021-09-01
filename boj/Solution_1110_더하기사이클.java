package net.acmicpc;

import java.util.Scanner;

public class Solution_1110_더하기사이클 {

	static int N, fd, sd, cnt, newSd;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		N = scan.nextInt();
		fd = N / 10;
		sd = N % 10;
		if (N < 10) {
			fd = N;
			sd = 0;
			N = (fd * 10) + sd;
		}
		while (true) {
			newSd = fd + sd;
			cnt++;
			if (newSd > 9) {
				newSd = newSd % 10;
			}
			if ((sd * 10) + newSd == N) {
				break;
			}
			fd = sd;
			sd = newSd;

		}
		System.out.println(cnt);
	}
}
