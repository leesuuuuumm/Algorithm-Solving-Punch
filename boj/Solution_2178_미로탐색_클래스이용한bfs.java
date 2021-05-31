package com.boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_2178_미로탐색_클래스이용한bfs {

	static int R, C;
	static int map[][];
	static int dr[] = { 0, 1, 0, -1 };
	static int dc[] = { 1, 0, -1, 0 };
	static boolean v[][];
	static class Point {
		int r;
		int c;
		int cnt;
		public Point(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		R = scan.nextInt();
		C = scan.nextInt();
		map = new int[R][C];
		v = new boolean[R][C];
		for (int r = 0; r < R; r++) {
			String mapS = scan.next();
			for (int c = 0; c < C; c++) {
				map[r][c] = mapS.charAt(c) - '0';
			}
		}
		System.out.println(bfs(0, 0, 0));
		//print();

	}

	private static int bfs(int r,int c,int cnt) {
		Queue<Point> que = new LinkedList<>();
		v[r][c]=true;
		que.offer(new Point(r,c,cnt+1));
		while(!que.isEmpty()) {
			Point cur = que.poll();
			for (int d = 0; d < 4; d++) {
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];
				
				if(!check(nr,nc)) continue;
			
				if(!v[nr][nc]&&map[nr][nc]==1) {
					if(nr==R-1&&nc==C-1) {
						return cur.cnt+1; //마지막 값까지 포함을 시켜야 함
					}
					v[nr][nc] = true;
					que.offer(new Point(nr,nc,cur.cnt+1)); //cur[2]는 d가 다 돌때까지 변하지 x
				}
				
			}
			
		}
		return -1;
		
	}

	private static boolean check(int nr, int nc) {
		return nr >= 0 && nr < R && nc >= 0 && nc < C;
	}

}
