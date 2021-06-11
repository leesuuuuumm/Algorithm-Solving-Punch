package com.swexpertacademy;

import java.util.Scanner;

public class Solution_2071_평균값구하기 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int T =scan.nextInt();
		for (int t = 1; t <=T; t++) {
			int arr[] = new int[10];
			int sum = 0;
			for (int i = 0; i < 10; i++) {
				arr[i] = scan.nextInt();
				sum+=arr[i];
			}
			//System.out.println(sum);
			if(sum%10>=5) {
				System.out.println("#"+t+" "+ ((sum/10)+1));
			}else {
			System.out.println("#"+t+" "+ sum/10);
		}
		}
	}
}
