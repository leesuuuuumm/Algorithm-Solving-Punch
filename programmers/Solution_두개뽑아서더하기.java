package com.programmers;

import java.util.TreeSet;

public class Solution_두개뽑아서더하기 {
	public static void main(String[] args) {
		int array[] = {5,0,2,7};
		solution(array);
	}
	public static TreeSet<Integer> solution(int[] numbers) {
		TreeSet<Integer> set = new TreeSet<Integer>();
		for (int i = 0; i < numbers.length; i++) {
			for (int j = i+1; j <numbers.length ; j++) {
				set.add(numbers[i]+numbers[j]);
			}
		}
		//System.out.println(set);
		return set;
	}
}
