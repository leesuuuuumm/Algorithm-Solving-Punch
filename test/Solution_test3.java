package com.codingtest;

public class Solution_test3 {
	static boolean[] v;
	static int min ;

	public static void main(String[] args) {

		int[] numbers = { -1, -2, 3,- 4, 5 }; // 배열의 길이가 17개가 될 수 있고 배열의 값들이 1000000000 가능해
		v = new boolean[numbers.length];
		min = Integer.MAX_VALUE;
		subset(numbers, 0);
		System.out.println(min);
		
	}

	public static void subset(int[] numbers, int depth) {
		// 기저조건
		int cntT = 0;
		int cntF = 0;
		if (depth == numbers.length) {
			int groupT = 0;
			int groupF = 0;
			for (int i = 0; i < v.length; i++) {
				if (v[i] == true) {
					cntT++;
					groupT += numbers[i];
				} else {
					cntF++;
					groupF += numbers[i];
				}
			}
			if (cntF == v.length || cntT == v.length) {
				return;
			}
			int sub = Math.abs(groupT) > Math.abs(groupF) ?  Math.abs(groupT) -  Math.abs(groupF) :  Math.abs(groupF) -  Math.abs(groupT);
			min = Math.min(min, sub);
			return;
		}
		
		v[depth] = true;
		subset(numbers, depth + 1);
		v[depth] = false;
		subset(numbers, depth + 1);

	}
}
