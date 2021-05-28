package com.ssafy;

import java.util.Scanner;

public class Solution_boj_1316_그룹단어체커 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int k = scan.nextInt();
		int cnt = 0;
		for (int i = 0; i < k; i++) {
			String st = scan.next();
			char ch[] = st.toCharArray();
			boolean check[] = new boolean[26];
			if (ch.length == 1) {
				continue;
			} else {
				a:for (int j = 1; j <= ch.length; j++) {
					if (check[ch[j-1] - 97]) {
						cnt++;
						break;
					}
					if(j==ch.length) {
						break a;
					}
					if (ch[j-1] != ch[j]) {
						check[ch[j-1] - 97] = true;
					}
					
				}
			}
		}
		System.out.println(k - cnt);

	}
}
