package com.programmers2;
//제한사항에 주어지는 숫자의 개수가 20개니까 최악의 경우 2^20  
// 1억이 1초 (1억을 기준으로)
public class Solution_타켓넘버 {
	static int answer;
	public static void main(String[] args) {
		int numbers[] = { 2, 3, 7, 8, 5 };
		solution(numbers, 5);
	}
	public static int solution(int[] numbers, int target) {
		dfs(0, 0, numbers, target);
		return answer;
	}

	private static void dfs(int depth, int sum, int[] numbers, int target) {
		if (depth == numbers.length) {
			if (sum == target) {
				answer++;
			}
			return;
		}
		dfs(depth + 1, sum + numbers[depth], numbers, target);
		dfs(depth + 1, sum - numbers[depth], numbers, target);
	}

}
