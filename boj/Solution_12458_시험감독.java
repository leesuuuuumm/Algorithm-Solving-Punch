package net.acmicpc;

import java.io.*;
import java.util.*;

public class Solution_12458_시험감독 {

	public static void main(String[] arg) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(br.readLine());
		long[] people = new long[(int) N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {	
			people[i] = Long.parseLong(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		// 1명일 경우
		long cnt = 0;
		for (int i = 0; i < people.length; i++) {
			if (people[i] > B) {
				people[i] = people[i] - B;
			}else {
				people[i] =0L;
			}
		}
		if (N == 1) {
			if (people[0] == 0) {
				System.out.println(1);
				return;
			} else {
				cnt += people[0] / C;
				if (people[0] % C != 0) {
					cnt += 1;
				}
				System.out.println(cnt + 1);
				return;
			}
		}

		for (int i = 0; i < N; i++) {
			if (people[i] > C) {
				cnt += people[i] / C;
				if (people[i] % C != 0) {
					cnt += 1;
				}

			} else if (people[i] == 0) {
				continue;
			} else {
				cnt++;
			}
		}
		cnt = cnt + N;
		System.out.println(cnt);
	}
}
