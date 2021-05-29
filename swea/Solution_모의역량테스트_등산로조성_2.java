package com.swea;

import java.util.Scanner;

public class Solution_모의역량테스트_등산로조성_2 {

	static int N, K, depth, max;
	static int map[][];
	static boolean v[][];
	static int dr[] = {0,1,0,-1};
	static int dc[] = {1,0,-1,0};
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		for (int t = 1; t <= T; t++) {
			N = scan.nextInt();
			K = scan.nextInt();
			map = new int[N][N];
			v = new boolean[N][N];
			depth = 0;
			max = Integer.MIN_VALUE;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					map[r][c] = scan.nextInt();
					max = Math.max(max, map[r][c]);
				}
			}
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if(map[r][c]==max) {
						v[r][c] = true;
						dfs(r,c,1,false);
						v[r][c] = false;
					}
				}
			}
			System.out.println("#"+t+" "+depth);
		}
	}

	private static void dfs(int r, int c, int cnt, boolean vk) {
		// 뎁스 크기 비교
		depth = Math.max(depth, cnt);
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(!check(nr,nc)) continue;
			
			// 방문체크
			if(v[nr][nc]) continue;
			
			// 현 위치가 다음 위치보다 클 경우 
			if(map[r][c]>map[nr][nc]&&!v[nr][nc]) {
				v[nr][nc] = true;
				dfs(nr,nc,cnt+1,vk);
				v[nr][nc] = false;
			}
			
			// 현 위치가 다음 위치보다 같거나 작고 깎을수 있는 경우
			if(map[r][c]<=map[nr][nc]&&!vk) {
				// 깎을 수 있는 조건
				if((map[nr][nc]-map[r][c]<K)) {
					int temp = map[nr][nc];
					map[nr][nc] = map[r][c] - 1;
					v[nr][nc] = true;
					dfs(nr,nc,cnt+1,!vk);
					v[nr][nc] = false;
					//다시 깎은 상태 원래 상태로 되돌리기
					map[nr][nc] = temp;
				}
			}
			
			
		}
		
	}

	//경계체크
	private static boolean check(int nr, int nc) {
		return nr>=0&&nr<N&&nc>=0&&nc<N;
	}
}
