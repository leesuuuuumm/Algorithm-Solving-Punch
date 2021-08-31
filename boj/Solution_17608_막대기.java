package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_17608_막대기 {

	static int N, arr[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine()); // 엔터로 구분
		}
		int max = arr[N - 1];
		int cnt = 1;
		for (int i = N - 2; i >= 0; i--) {
			if (max < arr[i]) {
				cnt++;
				max = arr[i];
			}
		}
		System.out.println(cnt);

	}
}
