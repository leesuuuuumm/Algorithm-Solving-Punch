package com.programmers2;

import java.util.Queue;
import java.util.LinkedList;

public class Solution_컬러링북 {

	static boolean v[][];
	static int dr[] = { 0, 1, -1, 0 };
	static int dc[] = { -1, 0, 0, 1 };
	

	static class Point {
		int r;
		int c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] agrs) {
		int[][] picture = { { 1, 1, 1, 0 }, { 1, 2, 2, 0 }, { 1, 0, 0, 1 }, { 0, 0, 0, 1 }, { 0, 0, 0, 3 },
				{ 0, 0, 0, 3 } };
		solution(6, 4, picture);

	}

	public static int[] solution(int m, int n, int[][] picture) {
		return bfs(picture, m, n);
	}

	private static int[] bfs(int picture[][], int m, int n) {
		v = new boolean[m][n];
		Queue<Point> que = new LinkedList<Point>();
        //프로그래머스에서 이문제 컴파일은 여기서 선언해야 제출이 됩니다..흑흑
        int cnt=0;
        int numberOfArea=0;
        int maxSizeOfOneArea = Integer.MIN_VALUE;
        
		for (int r = 0; r < m; r++) {
			for (int c = 0; c < n; c++) {
				if (picture[r][c] != 0 && !v[r][c]) {
					cnt = 1;
					v[r][c] = true;
					numberOfArea++;
					que.offer(new Point(r, c));
					while (!que.isEmpty()) {
						Point cur = que.poll();
						for (int d = 0; d < 4; d++) {
							int nr = dr[d] + cur.r;
							int nc = dc[d] + cur.c;
							if (!check(nr, nc, m, n)) {
								continue;
							}
							if (picture[cur.r][cur.c] == picture[nr][nc] &&!v[nr][nc]) {
								cnt++;
								v[nr][nc] = true;
								que.offer(new Point(nr, nc));
							}
						}
					}
					maxSizeOfOneArea = Math.max(maxSizeOfOneArea, cnt);
				}
			}
		}
		
		int[] answer = new int[2];
		answer[0] = numberOfArea;
		answer[1] = maxSizeOfOneArea;
		System.out.println(answer[0] + " " + answer[1]);
		return answer;

	}

	private static boolean check(int nr, int nc, int m, int n) {
		return nr >= 0 && nr < m && nc >= 0 && nc < n;
	}

}
