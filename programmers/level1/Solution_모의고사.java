package com.programmers;

import java.util.LinkedList;

public class Solution_모의고사 {
	public static void main(String[] args) {
		int answers[] = {1,3,2,4,2 };
		solution(answers);
	}

	public static LinkedList<Integer> solution(int[] answers) {
		int num1[] = { 1, 2, 3, 4, 5 };
		int num2[] = { 2, 1, 2, 3, 2, 4, 2, 5 };
		int num3[] = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };
		int cnt[] = new int[3];
		int max = Integer.MIN_VALUE;
		LinkedList<Integer> list = new LinkedList<Integer>();
		for (int i = 0; i < answers.length; i++) {
			if(answers[i]==num1[i%5]) cnt[0]++;
			if(answers[i]==num2[i%8]) cnt[1]++;
			if(answers[i]==num3[i%10]) cnt[2]++;
		}
		
		for (int i = 0; i < cnt.length; i++) {
			max = Math.max(max, cnt[i]);
		}
		
		for (int i = 0; i < cnt.length; i++) {
			if(cnt[i]==max) {
				list.add(i+1);
			}
		}
		System.out.println(list);
		return list;
	}
}