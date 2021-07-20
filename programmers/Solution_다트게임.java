package com.programmers;

import java.util.Scanner;

public class Solution_다트게임 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String dartResult = scan.next();
		char dart[] = dartResult.toCharArray();
		int num[] = new int[dart.length];
		int k = 0;
		for (int i = 0; i < dart.length; i++) {
			if (dart[i] >= '0' && dart[i] <= '9') {
				if (dart[i] == '1' && dart[i + 1] == '0') {
					num[k++] = 10;
					i++;
					
				}else {
					num[k++] = dart[i] - '0';// 0~9까지의 캐릭터가 필터링 돼서 들어옴
				}
			} else if (dart[i] == 'S') {
				num[k - 1] = num[k - 1];

			} else if (dart[i] == 'D') {
				num[k - 1] = (num[k - 1] * num[k - 1]);
				System.out.println(num[k - 1] );

			} else if (dart[i] == 'T') {
				num[k - 1] = (num[k - 1] * num[k - 1] * num[k - 1]);

			} else if (dart[i] == '*') {
				if ((k - 1) == 0) {
					num[0] *= 2;
				} else {
					for (int j = k - 2; j < k; j++) {
						num[j] *= 2;
					}
				}
			} else if (dart[i] == '#') {
				num[k - 1] *= -1;

			}
		}
		int answer = 0;
		for (int i = 0; i < num.length; i++) {
			answer += num[i];
		}
		System.out.println(answer);
	}
}
