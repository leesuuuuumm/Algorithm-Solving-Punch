package com.programmers;

import java.util.Arrays;

//HashSet으로 풀어보기
public class Solution_체육복 {
	public static void main(String[] args) {
		int n = 4;
		int[] lost = {3,1};
		int[] reserve = {2,4};
		solution(n, lost, reserve);
	}
	public static int solution(int n, int[] lost, int[] reserve) {
		int answer = 0;
		Arrays.sort(lost);
		Arrays.sort(reserve);
		answer = n - lost.length;
		int cnt = 0;
		// 자기 자신꺼 있으면 가져가기
		for (int i = 0; i < lost.length; i++) {
			for (int j = 0; j < reserve.length; j++) {
				
				if (lost[i] == reserve[j]) {
					cnt++;
					reserve[j] = -1;
					lost[i] =-1;
					break;
				}
			}
		}
		for (int i = 0; i < lost.length; i++) {
			a: for (int j = 0; j < reserve.length; j++) {
				if ((lost[i] == reserve[j] - 1 || lost[i] == reserve[j] + 1)) {
					cnt++;
					reserve[j] = -1;
					break a;
				}
			}
		}
		return answer += cnt;
	}

}
