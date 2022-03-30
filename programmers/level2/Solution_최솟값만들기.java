package com.programmers2;

import java.util.*;

public class Solution_최솟값만들기 {
	public int solution(int[] A, int[] B) {
		int answer = 0;
		Arrays.sort(A); // A 정렬
		Integer[] b = new Integer[B.length]; // Collections.reversOrder()은 int가 안받아져서
		for (int i = 0; i < A.length; i++) {
			b[i] = B[i];
		}
		Arrays.sort(b, Collections.reverseOrder());

		for (int i = 0; i < A.length; i++) {
			answer += A[i] * b[i];
		}

		return answer;
	}
}
