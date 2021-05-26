package com.swea;

import java.util.Scanner;

public class Solution_9317_석찬이의받아쓰기 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = scan.nextInt();
			String s = scan.next();
			String s2 = scan.next();
			char sc[] = s.toCharArray(); 
			char sc2[] = s2.toCharArray();
			int count = 0;
			for (int i = 0; i < N; i++) {
				if(sc[i]==sc2[i]) {
					count++;
				}
			}
			
			System.out.println("#"+t+" "+count);
		}
	}
}
