package com.programmers;

import java.util.Scanner;

public class 하샤드수_12947 {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int input = scan.nextInt();
		int sum = 0;
		int num = input;
		boolean answer = true;
		
		while(num>0) {
			sum+=num%10;
			num/=10;
		}
		answer = (input%sum==0) ? true:false;
		System.out.println(answer);
	}
}
