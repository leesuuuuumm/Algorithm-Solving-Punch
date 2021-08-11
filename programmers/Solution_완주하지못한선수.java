package com.programmers;

import java.util.Arrays;

// 링크드 리스트로 풀다가 효율성 테스트 3개 틀림
// hashMap으로도 풀어보기!!!!

public class Solution_완주하지못한선수 {
	public static void main(String[] args) {
		String[] participant = { "mislav", "stanko", "mislav", "ana" };
		String[] completion = { "stanko", "ana", "mislav" };
		solution(participant, completion);
	}

	public static String solution(String[] participant, String[] completion) {
		
		Arrays.sort(participant);
		Arrays.sort(completion);

		for (int i = 0; i < completion.length; i++) {
			if (!participant[i].equals(completion[i])) {
				return participant[i];
			}
		}
		return participant[participant.length - 1];

	}
}
