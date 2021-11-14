package net.acmicpc;

import java.util.*;
import java.io.*;
// Select와 unSelect부분 나눠서 풀기 -> 처음에 문제 잘못이해함..2가지경우만 판단함 
public class Solution_14889_스타트와링크 {

	static int N, min, minus;
	static int[][] team;
	static int[] select, unSelect;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		team = new int[N][N];
		select = new int[N / 2];
		unSelect = new int[N / 2];
		visited = new boolean[N];
		min = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				team[i][j] = Integer.parseInt(st.nextToken());
			}
		}

//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				System.out.print(team[i][j]);
//			}
//			System.out.println();
//		}
		combination(0, 0);
		System.out.println(min);
	}

	private static void combination(int cnt, int start) {
		if (cnt == N / 2) {
			int selec = 0;
			int unSelec = 0;
			int count = 0;
			for (int i = 0; i < N; i++) {
				if (!visited[i]) {
					unSelect[count++] = i;

				}
			}
			for (int i = 0; i < cnt; i++) {
				for (int j = 0; j < cnt; j++) {
					selec += team[select[i]][select[j]];
					unSelec += team[unSelect[i]][unSelect[j]];
				}
			}
			minus = Math.abs(selec - unSelec);
			min = Math.min(minus, min);
			return;
		}
		for (int i = start; i < N; i++) {
			select[cnt] = i;
			visited[i] = true;
			combination(cnt + 1, i + 1);
			visited[i] = false;

		}

	}

}
