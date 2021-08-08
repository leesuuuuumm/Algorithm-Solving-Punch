package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 프린트문 시간 오래걸림 (출력할게 많으면 StringBuilder로 출력해야함)
public class Solution_2751_수정렬하기2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		Integer max[] = new Integer[N];
		for (int i = 0; i < N; i++) {
			max[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(max);
		
		for (int i = 0; i < max.length; i++) {
			sb.append(max[i]).append("\n");
		}
		System.out.println(sb);

	}
}
