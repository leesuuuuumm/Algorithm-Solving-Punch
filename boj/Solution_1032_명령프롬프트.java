package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1032_명령프롬프트 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		String[] srr = new String[N];
		for (int i = 0; i < N; i++) {
			srr[i] = br.readLine();
		}
		if(srr.length==1) {
			System.out.println(srr[0]);
			return;
		}
		int len = srr[0].length();
		for (int i = 0; i <len ; i++) {
			boolean isAllSame = true; // flag
			for (int j = 1; j < srr.length; j++) {
				if (srr[j - 1].charAt(i) != srr[j].charAt(i)) {
					isAllSame=false;
					break;
				}
			}
			if(isAllSame) {
				sb.append(srr[0].charAt(i));
			}else {
				sb.append("?");
			}
		}
		System.out.println(sb);

	}
}
