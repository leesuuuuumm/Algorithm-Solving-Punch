package com.programmers;

import java.util.Arrays;

public class Solution_K번째수 {

	public static void main(String[] args) {
		int array[] = { 1, 5, 2, 6, 3, 7, 4 };
		int commands[][] = { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } };
		solution(array, commands);
	}

	public static int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];
		for (int i = 0; i < commands.length; i++) {
			int cut[] = new int[(commands[i][1]-commands[i][0])+1];
			int k = 0;
			for (int j = commands[i][0] - 1; j < commands[i][1] ; j++) {
				cut[k] = array[j];
				k++;

			}
			Arrays.sort(cut);
			//System.out.println(cut[commands[i][2] - 1]);
			answer[i] = cut[commands[i][2] - 1];
			
		}
		for (int i = 0; i < answer.length; i++) {
			System.out.print(answer[i]+" ");
		}
		return answer;
	}
}
