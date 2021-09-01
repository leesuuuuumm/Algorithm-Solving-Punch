package com.programmers;

public class Solution_로또의최고순위와최저순위 {
	public static void main(String[] args) {
		int[] lottos = { 1, 2, 3, 4, 5, 6 };
		int[] win_nums = { 7, 8, 9, 10, 11, 12 };
		solution(lottos, win_nums);
	}

	public static int[] solution(int[] lottos, int[] win_nums) {
		int[] answer = new int[2];
		int zero = 0;
		int cnt = 0;
		for (int i = 0; i < lottos.length; i++) {
			if (lottos[i] == 0) {
				zero++;
				continue;
			}
			for (int j = 0; j < win_nums.length; j++) {
				if (lottos[i] == win_nums[j]) {
					cnt++;
				}
			}
		}
		answer[0] = 7 - (cnt + zero) > 5 ? 6 : 7 - (cnt + zero);
		if (cnt == 0) {
			answer[1] = 6;
		} else answer[1] = zero == 6 ? 6 : 7 - cnt;
//		for (int i = 0; i < answer.length; i++) {
//			System.out.println(answer[i]);
//		}
		return answer;
	}

}
