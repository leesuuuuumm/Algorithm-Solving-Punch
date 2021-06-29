package com.ssafy;

import java.util.Scanner;

public class Solution_2231_분해합 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		
		a:for (int i = 0; i < num; i++) {
			int N=i;
			int sum=0;
			
			while(N!=0) {
				sum+=N%10;
				N/=10;
			}
			
			if((sum+i)==num) {
				System.out.println(i);
				break a;
			}
			else if(i==num-1) {
				if((sum+i)!=num) {
					System.out.println(0);
				}
			}
		}
		
	}
}
 
