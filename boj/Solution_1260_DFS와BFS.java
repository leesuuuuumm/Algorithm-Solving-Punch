package net.acmicpc;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_1260_DFS와BFS {

	static int N, M, V, map[][]; // 정점의 개수, 간선의 개수, 시작할 정점의 번호, 그래프 맵
	static boolean visited[]; // 방문 체크
	static Queue<Integer> que;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		M = scan.nextInt();
		V = scan.nextInt();
		map = new int[N + 1][N + 1];
		visited = new boolean[N + 1];
		que = new LinkedList<>();
		for (int i = 0; i < M; i++) {
			int r = scan.nextInt();
			int c = scan.nextInt();
			map[r][c] = 1;
			map[c][r] = 1;
		}
		dfs(V);
		visited = new boolean[N + 1];
		System.out.println();
		bfs();
	}

	private static void dfs(int cur) {
		System.out.print(cur + " ");
		visited[cur] = true;
		for (int c = 1; c < N + 1; c++) {
			if(map[cur][c] == 1 && !visited[c]) {
				dfs(c);
			}
		}

	}

	private static void bfs() {
		que.offer(V);
		visited[V] = true;
		System.out.print(V + " ");
		while (!que.isEmpty()) {
			int cur = que.poll();
			for (int c = 1; c < N + 1; c++) {
				if (map[cur][c] == 1 && !visited[c]) {
					System.out.print(c + " ");
					que.offer(c);
					visited[c] = true;
				}
			}
		}
	}
}
