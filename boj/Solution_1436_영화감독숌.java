package net.acmicpc;

import java.util.Scanner;

public class Solution_1436_영화감독숌 {

	public static void main(String[] args) {
		Scanner scan = new Scanner (System.in);
		int N = scan.nextInt();
		int k = 0;
		a:for (int i = 666; ; i++) {
			String str = Integer.toString(i);
			if(str.contains("666")) {				
				k+=1;
				if(k==N) {
					System.out.println(i);
					break a;
				}
			}
			
		}
	}
}
