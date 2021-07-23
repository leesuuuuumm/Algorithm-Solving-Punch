package com.programmers;

public class Solution_키패드누르기 {
	//switch 문이랑 키패드 좌표값 만들어서도 풀어보기 !!
	// 초기값 정해주는것 잊지말기 
	public static void main(String[] args) {
		int number[] = { 2, 5, 8, 0 };
		String hand = "right";
		solution(number, hand);
	}

	public static String solution(int[] numbers, String hand) {
		int nowR = 11;
		int nowL = 10;
		int nR = 0, nC = 0, rR = 0, rC = 0, lR = 0, lC = 0;
		StringBuilder sb = new StringBuilder();
		int keypad[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 10, 0, 11 } };
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7 || numbers[i] == 10) {
				nowL = numbers[i];
				sb.append("L");
			} else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
				nowR = numbers[i];
				sb.append("R");
			} else if (numbers[i] == 2 || numbers[i] == 5 || numbers[i] == 8 || numbers[i] == 0 || numbers[i] == 11) {
				for (int r = 0; r < 4; r++) {
					for (int c = 0; c < 3; c++) {
						if (keypad[r][c] == numbers[i]) {
							nR = r;
							nC = c;
						}
						if (keypad[r][c] == nowR) {
							rR = r;
							rC = c;
						}
						if (keypad[r][c] == nowL) {
							lR = r;
							lC = c;
						}
					}
				}

				if ((Math.abs(nR - rR) + Math.abs(nC - rC)) > (Math.abs(nR - lR) + Math.abs(nC - lC))) {
					sb.append("L");
					nowL = numbers[i];
				} else if ((Math.abs(nR - rR) + Math.abs(nC - rC)) < (Math.abs(nR - lR) + Math.abs(nC - lC))) {
					sb.append("R");
					nowR = numbers[i];
				} else if ((Math.abs(nR - rR) + Math.abs(nC - rC)) == (Math.abs(nR - lR) + Math.abs(nC - lC))) {
					if (hand.equals("right")) {
						sb.append("R");
						nowR = numbers[i];
					} else if (hand.equals("left")) {
						sb.append("L");
						nowL = numbers[i];
					}
				}
			}
			System.out.println("nowL" + " " + nowL);
			System.out.println("nowR" + " " + nowR);
			System.out.println("눌러야할 숫자" + " " + numbers[i]);
			System.out.println("사용한 손" + " " + sb);

			System.out.println();

		}
		System.out.println(sb);

		return sb.toString();
	}

}
