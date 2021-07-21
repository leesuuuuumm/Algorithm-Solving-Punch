package com.programmers;

import java.util.Stack;

public class Solution_크레인인형뽑기게임 {

	public static void main(String[] args) {

		int board[][] = { { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 3 }, { 0, 2, 5, 0, 1 }, { 4, 2, 4, 4, 2 },
				{ 3, 5, 1, 3, 1 } };
		int moves[] = { 1, 5, 3, 5, 1, 2, 1, 4 };
		solution(board, moves);
	}

	public static int solution(int[][] board, int[] moves) {
		int answer = 0;
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < moves.length; i++) {
			a: for (int j = 0; j < board.length; j++) {
				if(board[j][moves[i] - 1] != 0) {
					if (!stack.isEmpty()) {
						if (stack.peek() == board[j][moves[i] - 1]) {
							stack.pop();
							board[j][moves[i] - 1] = 0;
							answer += 2;
							break a;
						} else {
							stack.push(board[j][moves[i] - 1]);
							board[j][moves[i] - 1] = 0;

							break a;
						}
					} else {
						stack.push(board[j][moves[i] - 1]);
						board[j][moves[i] - 1] = 0;
						break a;
					}
				}

			}
		}
		System.out.println(answer);
		return answer;
	}
}
