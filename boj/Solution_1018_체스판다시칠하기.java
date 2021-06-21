package net.acmicpc;

import java.util.Scanner;

public class Solution_1018_ü���Ǵٽ�ĥ�ϱ� {

	static int R, C, wCnt, bCnt;
	static char map[][];
	static final char[][] chess1 = new char[][] { { 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' },
			{ 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' }, { 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' },
			{ 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' }, { 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' },
			{ 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' }, { 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' },
			{ 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' } };
	static final char[][] chess2 = new char[][] { { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' },
			{ 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' }, { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' },
			{ 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' }, { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' },
			{ 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' }, { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' },
			{ 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' } };

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		R = scan.nextInt();
		C = scan.nextInt();

		map = new char[R][C];
		for (int r = 0; r < R; r++) {
			String k = scan.next();
			for (int c = 0; c < C; c++) {
				map[r][c] = k.charAt(c);
			}
		}
		int min = Integer.MAX_VALUE;
		int result = 64;
		for (int kr = 0; kr <= R - 8; kr++) {
			for (int kc = 0; kc <= C - 8; kc++) {
				wCnt=0; // wü������ �� map�̶� chess1 ����ġ�ϴ� Ÿ���� ���� 
				bCnt=0; // bü������ �� map�̶� chess2 ����ġ�ϴ� Ÿ���� ���� 
				for (int r = kr; r < kr + 8; r++) {
					for (int c = kc; c < kc + 8; c++) {
						if (map[r][c] != chess1[r - kr][c - kc]) {
							wCnt++;
						}
						if(map[r][c] != chess2[r - kr][c - kc]) {
							bCnt++;
						}
					}
				}
				min = Math.min(wCnt, bCnt);
				result = Math.min(min, result);
			}
		}
		System.out.println(result);
	}
}
