package com.programmers;

public class Solution_소수만들기 {
	static int arr[];
	static int resultCnt;
	static int answer;

	public static void main(String[] args) {
		int nums[] = {1,2,3,4};
		solution(nums);
	}
	
	public static int solution(int[] nums) {
		arr = new int[3];
		answer = 0;
		nCr(0, 0,nums);

		//System.out.println(answer);
		return answer;
	}

	private static void nCr(int cnt, int start,int[] nums) {
		if (cnt == 3) {
			int sum = 0;
			int resultCnt=0;
			for (int i = 0; i < arr.length; i++) {
				sum += arr[i];
			}
			for (int i = 2; i <= sum / 2; i++) {
				if (sum % i == 0) {
					resultCnt++;
					break;
				}
			}
			if (resultCnt == 0)
				answer++;
			return;
		}
		for (int i = start; i < nums.length; i++) {
			arr[cnt] = nums[i];
			nCr(cnt + 1, i + 1,nums);
		}

	}

}
