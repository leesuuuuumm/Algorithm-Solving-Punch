package net.acmicpc.samsung;

import java.io.*;
import java.util.*;

public class Solution_14501_퇴사 {
	static int schedule[][];
	static int max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		max = Integer.MIN_VALUE;
		schedule = new int[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 2; j++) {
				schedule[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0, 0, schedule);
		System.out.println(max);
	}

	private static void dfs(int depth, int sum, int[][] schedule) {
		if (depth >= schedule.length) {
			max = Math.max(max, sum);
			return;
		}
		if (depth + schedule[depth][0] > schedule.length) {
			dfs(depth + schedule[depth][0], sum, schedule);
		} else {
			dfs(depth + schedule[depth][0], sum + schedule[depth][1], schedule);

		}
		dfs(depth + 1, sum, schedule);
	}
}
