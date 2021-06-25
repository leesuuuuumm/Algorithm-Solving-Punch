package net.acmicpc;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_7567_토마토 {

	static int R, C;
	static int map[][];
	static int dr[] = { 0, 1, -1, 0 };
	static int dc[] = { -1, 0, 0, 1 };
	static Queue<Point> que;

	static class Point {
		int r;
		int c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;

		}

	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		C = scan.nextInt();
		R = scan.nextInt();
		que = new LinkedList<>();
		map = new int[R][C];
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				map[r][c] = scan.nextInt();
			}
		}
		System.out.println(bfs());
	}

	private static int bfs() {
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (map[r][c] == 1) {
					que.offer(new Point(r, c));
				}
			}
			
		}
		while (!que.isEmpty()) {
			Point cur = que.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];
				

				if (!check(nr, nc))
					continue;

				if (map[nr][nc] == 0) {
					map[nr][nc] = map[cur.r][cur.c]+1;
					que.offer(new Point(nr, nc));
				}
			}
		}
		//print();
		int max = Integer.MIN_VALUE;
		for (int r = 0; r <R; r++) {
			for (int c = 0; c < C; c++) {
				if(map[r][c]==0) {
					return -1;
				}
				max = Math.max(max, map[r][c]);
			}
		}
	
		return max==1?0:(max-1);
	}

	private static void print() {
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				System.out.print(map[r][c]+" ");
			}
			System.out.println();
		}
		
	}

	private static boolean check(int nr, int nc) {
		return nr >= 0 && nr < R && nc >= 0 && nc < C;
	}
}
