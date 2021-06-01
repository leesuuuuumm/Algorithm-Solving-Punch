package com.swea;

import java.util.Scanner;

public class Solution_2072_홀수만더하기 {

	static int arr[],sum;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		for (int t = 1; t <= T; t++) {
			arr = new int[10]; 
			sum = 0;
			for (int i = 0; i < 10; i++) {
				arr[i] = scan.nextInt();
				if(arr[i]%2==1) {
					sum+=arr[i];
				}
			}
		System.out.println("#"+t+" "+sum);
		}
	}
}
