package com.boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_2178_미로탐색 {

	static int R, C;
	static int map[][];
	static int dr[] = { 0, 1, 0, -1 };
	static int dc[] = { 1, 0, -1, 0 };
	static boolean v[][];

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
		Queue<int[]> que = new LinkedList<>();
		v[r][c]=true;
		que.offer(new int[] {r,c,cnt+1});
		while(!que.isEmpty()) {
			int [] cur = que.poll();
			for (int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				
				if(!check(nr,nc)) continue;
			
				if(!v[nr][nc]&&map[nr][nc]==1) {
					if(nr==R-1&&nc==C-1) {
						return cur[2]+1; //마지막 값까지 포함을 시켜야 함
					}
					v[nr][nc] = true;
					que.offer(new int[] {nr,nc,cur[2]+1}); //cur[2]는 d가 다 돌때까지 변하지 x
				}
				
			}
			
		}
		return -1;
		
	}

	private static boolean check(int nr, int nc) {
		return nr >= 0 && nr < R && nc >= 0 && nc < C;
	}

	private static void print() {
		for (int i = 0; i < R; i++) {
			for (int c = 0; c < C; c++) {
				System.out.print(v[i][c] ? "O" : "X");
			}
			System.out.println();
		}

	}

}
