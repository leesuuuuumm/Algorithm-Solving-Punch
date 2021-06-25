package net.acmicpc;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_7562_나이트의이동 {

	static boolean v[][];
	static int L,sr,sc,er,ec;
	static int dr[] = {-2,-1,1,2,2,1,-1,-2};
	static int dc[] = {-1,-2,-2,-1,1,2,2,1};
	static Queue<Point> que;
	static class Point {
		int r ;
		int c;
		int cnt;
		public Point(int r, int c, int cnt ) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner (System.in);
		int T = scan.nextInt();
		for (int t= 1;  t<= T; t++) {
			L = scan.nextInt();
			sr = scan.nextInt();
			sc = scan.nextInt();
			er = scan.nextInt();
			ec = scan.nextInt();
			v = new boolean[L][L];
			que = new LinkedList<>();
			System.out.println(bfs(0));
		}
	}
	private static int bfs(int cnt) {
		que.offer(new Point(sr,sc,cnt));
		v[sr][sc] = true;
		while(!que.isEmpty()) {
			Point cur = que.poll();
			for (int d = 0; d < 8; d++) {
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];
				
				if(cur.r==er&&cur.c==ec) {
					return cur.cnt;
				}
				
				if(!check(nr,nc)) continue;
				
				if(!v[nr][nc]) {
					v[nr][nc] = true;
					que.offer(new Point(nr,nc,cur.cnt+1));
				}
			}
		}
		return -1;
	}
	
	private static boolean check(int nr, int nc) {
		return nr>=0&&nr<L&&nc>=0&&nc<L;
	}
}
