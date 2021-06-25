package net.acmicpc;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_2606_바이러스 {

	static int map[][], computerCnt, cnt, computerNum;
	static boolean v[];
	static Queue<Integer> que;

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
		computerCnt = scan.nextInt();
		computerNum = scan.nextInt();
		map = new int[computerCnt + 1][computerCnt + 1];
		v = new boolean[computerCnt + 1];
		que = new LinkedList<>();
		for (int i = 0; i < computerNum; i++) {
			int r = scan.nextInt();
			int c = scan.nextInt();
			map[r][c] = 1;
			map[c][r] = 1;
		}
		// print();
		que.offer(1); // 시작값만 큐 넣을 꺼니깐
		v[1] = true;
		while (!que.isEmpty()) {
			int cur = que.poll();
			for (int c = 1; c <= computerCnt; c++) {
				if (map[cur][c] == 1&&!v[c]) {
					System.out.println("cur"+" "+cur);
					System.out.println("cnt"+" "+cnt);
					cnt++;					
					que.offer(c);
					v[c] = true;
				}
				
			}
		}
		System.out.println(cnt);

	}

	private static void print() {
		for (int i = 1; i <= computerCnt; i++) {
			for (int j = 1; j <= computerCnt; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}