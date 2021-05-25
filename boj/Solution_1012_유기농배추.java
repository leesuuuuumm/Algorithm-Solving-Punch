package com.boj;

import java.util.Scanner;

public class Solution_1012_유기농배추 {

	static int map[][],m,n;
	static boolean v[][];
	static int dr[] = {0, -1, 1, 0};
	static int dc[] = {1, 0, 0, -1};
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		for (int t = 0; t < T; t++) {
			 m = scan.nextInt();
			 n = scan.nextInt();
			int k = scan.nextInt();
			int cnt = 0;
			map = new int[m][n];
			v = new boolean[m][n];
			for (int i = 0; i < k; i++) {
				int r = scan.nextInt();
				int c = scan.nextInt();
				map[r][c] = 1;
			}
			for (int r = 0; r < m; r++) {
				for (int c = 0; c < n; c++) {
					if(map[r][c] == 1&&!v[r][c]) {
						v[r][c] = true;
						dfs(r,c,cnt);
						cnt++;
					}
					
				}
			}
			System.out.println(cnt);
		}
	}
	
	private static void dfs(int r, int c, int cnt) {
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(!check(nr,nc)) {
				continue;
			}
			if(v[nr][nc]) {
				continue;
			}
			if(map[nr][nc]==1&&!v[nr][nc]) {
				v[nr][nc]=true;
				dfs(nr,nc,cnt);
			}
		}
		
	}

	private static boolean check(int nr, int nc) {
		return nr>=0&&nr<m&&nc>=0&&nc<n;
	}
}
