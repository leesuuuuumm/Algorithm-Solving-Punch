package com.programmers;

import java.util.LinkedList;

public class Solution_제일작은수제거하기 {
	public static void main(String[] args) {
		int arr[] = { 10 };
		solution(arr);
	}
 
	public static LinkedList<Integer> solution(int[] arr) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		int min = Integer.MAX_VALUE;

		if (arr.length >= 1) {
			for (int i = 0; i < arr.length; i++) {
				min = Math.min(min, arr[i]);
			}
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] == min)
					continue;
				else {
					list.add(arr[i]);
				}
			}
			if (list.isEmpty()) {
				list.add(-1);
			}
 
		}
		return list;

	}

}
