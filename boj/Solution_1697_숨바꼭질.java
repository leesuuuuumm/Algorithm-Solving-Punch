package net.acmicpc;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_1697_¼û¹Ù²ÀÁú {

	static int N,K;
	static boolean v[];
	static int dc[] = {-1,1,2};
	static Queue<Point> que ;
	static class Point{
		int c;
		int cnt;
		public Point(int c,int cnt) {
			this.c = c;
			this.cnt = cnt;
		}
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner (System.in);
		N = scan.nextInt();
		K = scan.nextInt();
		que = new LinkedList<>();
		v = new boolean[100001];
		System.out.println(bfs(0));
	}
	
	private static int bfs(int cnt) {
	
		que.offer(new Point(N,cnt));
		v[N] = true;

		while(!que.isEmpty()) {
			Point cur = que.poll();
			int nc = 0;
			
			if(cur.c==K) {
				return cur.cnt;
			}
			
			for (int d = 0; d < 3; d++) {
				
				if(d==2) {
					 nc = cur.c*dc[d];
				}
				else {
					 nc = cur.c+dc[d];
				}
				
				if(!check(nc)) continue;
				if(!v[nc]) {
					v[nc] = true;
					que.offer(new Point(nc,cur.cnt+1));
				}
			}
		}
		return -1;
	}


	private static boolean check(int nc) {
		return nc>=0&&nc<=100000;
	}
}
