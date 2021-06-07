package ssafyAlgo;

import java.util.Scanner;

public class Solution_boj_2477_참외밭 {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int korean_melon_cnt = scan.nextInt();
		int arr[][] = new int[6][2];
		int min_12 = Integer.MAX_VALUE;
		int max_12 = Integer.MIN_VALUE;
		int min_34 = Integer.MAX_VALUE;
		int max_34 = Integer.MIN_VALUE;
		int max = Integer.MIN_VALUE;
		int max2 = Integer.MAX_VALUE;
		int area = 0;
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 2; j++) {
				arr[i][j] = scan.nextInt();

			}
		}
//		for (int i = 0; i < 6; i++) {
//			for (int j = 0; j < 2; j++) {
//				System.out.println(arr[i][j]);
//
//			}
//		}
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 2; j++) {

				if (arr[i][0] == 1 || arr[i][0] == 2) {
					min_12 = Math.min(min_12, arr[i][1]);
					max_12 = Math.max(max_12, arr[i][1]);
					if (arr[i][1] == max_12) {
						max2 = arr[i][0];
					}
				} else if (arr[i][0] == 3 || arr[i][0] == 4) {
					min_34 = Math.min(min_34, arr[i][1]);
					max_34 = Math.max(max_34, arr[i][1]);
					if (arr[i][1] == max_34) {
						max = arr[i][0];
					}

				}
			}
		}
		if ((max == 4 && max2 == 2) || (max == 3 && max2 == 1)) {
			area = (max_12 * max_34) - (min_12 * min_34);
		} else if ((max == 3 && max2 == 2) || (max == 4 && max2 == 1)) {
			area = (max_12 * max_34) - ((max_34 - min_34) * (max_12 - min_12));
		}
		System.out.println(area * korean_melon_cnt);
	}
}
