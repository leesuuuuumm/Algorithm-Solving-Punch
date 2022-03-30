package net.acmicpc;

import java.util.*;
import java.io.*;

public class Solution_3184_양 {

	static class Point {
		int r;
		int c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}

	}

	static char[][] farm;
	static boolean[][] v;
	static int R, C;
	static Queue<Point> que;
	static int wolfCnt, sheepCnt, wolfAns, sheepAns;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		farm = new char[R][C];
		v = new boolean[R][C];
		for (int r = 0; r < R; r++) {
			farm[r] = br.readLine().toCharArray();
		}
		wolfAns = 0;
		sheepAns = 0;
		que = new LinkedList<Point>();
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (!v[r][c] && farm[r][c] != '#') {
					que.offer(new Point(r, c));
					v[r][c] = true;
					wolfCnt = 0;
					sheepCnt = 0;
					if (farm[r][c] == 'o')
						sheepCnt++;
					else if (farm[r][c] == 'v')
						wolfCnt++;

					bfs(r, c);

				}
			}
		}
		System.out.println(sheepAns + " " + wolfAns);
	}

	static int[] dr = { 0, 1, -1, 0 };
	static int[] dc = { 1, 0, 0, -1 };

	private static void bfs(int r, int c) {
		while (!que.isEmpty()) {
			Point cur = que.poll();// 현재위치 빼주고

			for (int d = 0; d < dr.length; d++) {
				int nr = dr[d] + cur.r;
				int nc = dc[d] + cur.c;
				if (!check(nr, nc))
					continue;
				if (!v[nr][nc] && farm[nr][nc] != '#') {

					// 늑대랑 양 새주기
					if (farm[nr][nc] == 'o')
						++sheepCnt;
					else if (farm[nr][nc] == 'v')
						++wolfCnt;
					v[nr][nc] = true;
					que.offer(new Point(nr, nc));
				}
			}
		}

		// 양이 많을 경우 전체 양에서 그만큼 양 더해주기
		// 늑대가 많거나 같을 경우 전체 늑대에서 그만큼 늑대 더해주기
		if (sheepCnt > wolfCnt)
			sheepAns += sheepCnt;
		if (wolfCnt >= sheepCnt)
			wolfAns += wolfCnt;

	}

	private static boolean check(int nr, int nc) {

		return nr >= 0 && nc >= 0 && nr < R && nc < C;
	}

}
