package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_21610_마법사상어와비바라기 {

	static int N, M, D, S;
	static int sum = 0;
	static int map[][];
	static boolean v[][];
	static Queue<Point> que = new LinkedList<Point>();
	static int dr[] = { 0, -1, -1, -1, 0, 1, 1, 1 };
	static int dc[] = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int croR[] = { -1, 1, 1, -1 };
	static int croC[] = { -1, -1, 1, 1 };

	static class Point {
		int r;
		int c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine()); // 매 줄마다 r씩 끊어주기
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
//		for (int r = 0; r < N; r++) {
//			for (int c = 0; c < N; c++) {
//				System.out.print(map[r][c]+"\t");
//			}
//			System.out.println();
//		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			S = Integer.parseInt(st.nextToken());
			moveClouds(i);
		}
		System.out.println(result());
	}

	private static int result() {
		for (int r = 0; r < map.length; r++) {
			for (int c = 0; c < map.length; c++) {
				sum += map[r][c];
			}
		}
		return sum;
	}

	// 구름 움직일 때 que while문이 다 끝나고 대각선 구름 증가해줘야함 
	 // 방문체크 이용
	// mod로 경계값 왔다갔다하기 !!
	private static void moveClouds(int i) {
		if (i == 0) {
			que.offer(new Point(N - 2, 0));
			que.offer(new Point(N - 2, 1));
			que.offer(new Point(N - 1, 0));
			que.offer(new Point(N - 1, 1));
		}
		v = new boolean[N][N];
		int nr = 0;
		int nc = 0;
		while (!que.isEmpty()) {

			Point cur = que.poll();
			nr = cur.r + (dr[D - 1] * S);
			nc = cur.c + (dc[D - 1] * S);

			if (nr < 0 || nr >= N) {
				nr = nr % N;
				if (nr < 0) {
					nr += N;
				}
			}
			if (nc < 0 || nc >= N) {
				nc = nc % N;
				if (nc < 0) {
					nc += N;
				}
			}
			map[nr][nc] += 1;
			v[nr][nc] = true;		
		}


		IncreaseWater();
		DecreaseWater();
//		System.out.println();
//		for (int r = 0; r < N; r++) {
//			for (int c = 0; c < N; c++) {
//				System.out.print(map[r][c] + "\t");
//			}
//			System.out.println();
//		}
//		System.out.println();

	}
	// check 참 거짓 잘보고 
	private static void IncreaseWater() {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				int cnt = 0;
				if (v[r][c]) {
					for (int d = 0; d < 4; d++) {
						if (check(r, c, d) && map[r + croR[d]][c + croC[d]] >= 1) {
							cnt++;
						}
					}
					map[r][c] += cnt;
				}
			}
		}
	}

	private static boolean check(int nr, int nc, int d) {
		return nr + croR[d] >= 0 && nc + croC[d] >= 0 && nr + croR[d] < N && nc + croC[d] < N;
	}

	private static void DecreaseWater() {
		for (int r = 0; r < map.length; r++) {
			for (int c = 0; c < map.length; c++) {
				if (map[r][c] >= 2 && !v[r][c]) {
					map[r][c] -= 2;
					que.offer(new Point(r, c));

				}
			}
		}

	}
}
