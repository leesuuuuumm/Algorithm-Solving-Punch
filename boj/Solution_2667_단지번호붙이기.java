package com.boj;

import java.util.Arrays;
import java.util.Scanner;
 
public class Solution_2667_단지번호붙이기 {
	
	static int dr[] = { -1, 1, 0, 0 }, dc[] = { 0, 0, -1, 1 };
	static int map[][], N;
	static boolean v[][];

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		map = new int[N][N];
		v=new boolean[N][N];
		for (int r = 0; r < N; r++) {
			String k = scan.next();
			for (int c = 0; c < N; c++) {
				map[r][c] = k.charAt(c) - '0';
			}
		}

		// number 설정 -> 구간을 새로 찾을 때 마다 해줘야함
		// number++ 해줘서 구간 숫자 정하기 (2,3,4...) => 단지번호
		// 2부터 해주는 이유는 default값이 1이라서
		int number = 1;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (map[r][c] == 1) {
					++number; 
					//처음 들어갈 때 방문처리 하기!!!
					v[r][c]=true;
					map[r][c]=number;
					dfs(r, c, number);
				}
			}
		}  
//		for (int r = 0; r < N; r++) {
//			for (int c = 0; c < N; c++) {
//				System.out.print(map[r][c]);
//				}
//			System.out.println();
//			}
		int arr[] = new int[number-1]; 
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				for (int i = 2; i <= number; i++) { //2,3,4
					if (map[r][c] == i) {
						arr[i-2]++;
					}
				}

			}
		}
		
		System.out.println(number-1);
		Arrays.sort(arr);
		for (int i = 0; i <=number-2; i++) {
			System.out.println(arr[i]);
		}
	}

	private static void dfs(int r, int c, int number) {
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (!check(nr, nc))
				continue;

			if (v[nr][nc])
				continue;

			if (map[nr][nc] == 1 && !v[nr][nc]) {
				v[nr][nc] = true;
				map[nr][nc] = number;
				dfs(nr, nc, number);
			}
		}
	}

	// 벽부분 처리
	private static boolean check(int nr, int nc) {
		if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
			return true;
		}
		return false;
	}
}
