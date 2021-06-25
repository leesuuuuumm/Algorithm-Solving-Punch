package net.acmicpc;

import java.util.Scanner;

public class Solution_7568_덩치 {
 
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

				// 자신의 경우는 그냥 pass
				if (i == j)
					continue;

				// D[i]가 D[j]보다 작을때 rank는 하나 키워준다! N만큼 등수가 있기때문이다!
				if (D[i][0] < D[j][0] && D[i][1] < D[j][1]) {
					Rank++;
				}
			}
			// 하나 다 비교했으면 Rank 출력
			System.out.print(Rank + " ");
		}
	}
}
