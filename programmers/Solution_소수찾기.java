package com.programmers;

// 효율성 조심!!!!
public class Solution_소수찾기 {
	public static void main(String[] args) {
		solution(100000);
	}

	public static int solution(int n) {
		int answer = 0;
		boolean sosu[] = new boolean[n + 1];
		for (int i = 2; i <= n; i++) {
			sosu[i] = true;
		}
		int root = (int) Math.sqrt(n);

		for (int i = 2; i <= root; i++) {
			if (sosu[i]) {
				for (int j = i; j * i <= n; j++) {
					sosu[j*i] = false;
				}
			}
		}
		
		for (int i = 2; i <=n; i++) {
			if(sosu[i]) {
				answer++;
			}
		}
		return answer;

	}

}
