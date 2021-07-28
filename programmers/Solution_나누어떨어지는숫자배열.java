package com.programmers;

import java.util.Arrays;

public class Solution_나누어떨어지는숫자배열 {
	public static void main(String[] args) {
		int arr[] = { 5, 9, 7, 10 };
		solution(arr, 5);
	}

	public static int[] solution(int[] arr, int divisor) {
		int[] store = new int[arr.length];

		int k = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % divisor == 0) {
				store[k] = arr[i];
				k++;
			} else
				continue;
		}
		int[] answer = new int[k];
		if (k == 0) {
			answer = new int[] { -1 };
			return answer;
		}
		for (int i = 0; i < k; i++) {
			answer[i] = store[i];
		}
		Arrays.sort(answer);
		return answer;
	}
}
