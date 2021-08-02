package com.programmers;

public class Solution_부족한금액계산하기_1주차 {

	public static void main(String[] args) {
		solution(3, 20, 4);
	}
	public static long solution(int price, long money, int count) {
		long change = 0;
		for (int i = 1; i <= count; i++) {
			change += (price * i);
		}
		if (change <= money)
			return 0;
		else
			return change - money;
	}
}
