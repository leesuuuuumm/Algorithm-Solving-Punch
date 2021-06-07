package net.acmicpc;

import java.util.Scanner;

public class Solution_7568_��ġ {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int D[][] = new int[N][2];
		for (int i = 0; i < N; i++) {
			D[i][0] = scan.nextInt();
			D[i][1] = scan.nextInt();
		}

		for (int i = 0; i < N; i++) {

			int Rank = 1;
			for (int j = 0; j < N; j++) {

				// �ڽ��� ���� �׳� pass
				if (i == j)
					continue;

				// D[i]�� D[j]���� ������ rank�� �ϳ� Ű���ش�! N��ŭ ����� �ֱ⶧���̴�!
				if (D[i][0] < D[j][0] && D[i][1] < D[j][1]) {
					Rank++;
				}
			}
			// �ϳ� �� �������� Rank ���
			System.out.print(Rank + " ");
		}
	}
}
