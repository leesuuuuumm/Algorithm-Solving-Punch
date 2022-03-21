package com.programmers2;

public class Solution_카펫 {
	public int[] solution(int brown, int yellow) {
		int[] answer = new int[2];
		int sum = brown + yellow;

		for (int i = 2; i <= sum / 2; i++) {
			int r = 0;
			int c = 0;
			if (sum % i == 0) {
				if (sum / i > i) {
					r = sum / i;
					c = i;
				} else {
					r = i;
					c = sum / i;
				}
				// yellow가 rc - brown, (r-2) * (c-2) 둘 다 해당할 경우
				if (yellow == (r * c) - brown && yellow == (r - 2) * (c - 2)) {
					answer[0] = r;
					answer[1] = c;
				}

			}
		}

		return answer;
	}
}
