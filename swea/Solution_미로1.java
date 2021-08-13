package com.swexpertacademy;

import java.util.Scanner;

public class Solution_미로1 {

	static int map[][];
	static int sr, sc;
	static int dr[] = { 0, 0, -1, 1 };
	static int dc[] = { 1, -1, 0, 0 };
	static int answer;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			int N = scan.nextInt();
			map = new int[16][16];
			answer = 0;
			for (int r = 0; r < 16; r++) {
				String st = scan.next();
				for (int c = 0; c < 16; c++) {
					map[r][c] = st.charAt(c) - '0';
				}
			}

			for (int r = 0; r < 16; r++) {
				for (int c = 0; c < 16; c++) {
					if (map[r][c] == 2) {
						sr = r;
						sc = c;
					}
				}
			}
			dfs(sr, sc);
			System.out.println("#" + t + " " + answer);

		}
	}

	// 하상우좌
	private static void dfs(int r, int c) {
		map[r][c] = -1;
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (!check(nr, nc)) {
				continue;
			}
			if (map[nr][nc] == 3) {
				answer = 1;
				return;
			} else if (map[nr][nc] == 0) {
				dfs(nr, nc);
			}
		}

	}

	private static boolean check(int nr, int nc) {
		return nr >= 0 && nr <= 16 && nc >= 0 && nc <= 16;
	}

}