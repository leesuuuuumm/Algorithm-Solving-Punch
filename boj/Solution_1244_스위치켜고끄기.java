package net.acmicpc;

import java.util.*;
import java.io.*;

public class Solution_1244_스위치켜고끄기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int switchNum = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] switchState = new int[switchNum + 1]; // 스위치상태 배열
		switchState[0] = 0; // 0번째껀 신경 안쓸꺼임
		for (int i = 1; i <= switchNum; i++) {
			switchState[i] = Integer.parseInt(st.nextToken());
		}
		int studentNum = Integer.parseInt(br.readLine()); // 학생수
		for (int i = 0; i < studentNum; i++) { // 학생 배열 안만들고 값 들어올 때 마다 스위치 상태 바꾸기
			st = new StringTokenizer(br.readLine());
			int gen = Integer.parseInt(st.nextToken());
			int sRecive = Integer.parseInt(st.nextToken());

			if (gen == 1) { // 남학생일 때

				for (int M = 1; M * sRecive < switchState.length; M++) {
					switchState[M * sRecive] = (switchState[M * sRecive] == 1) ? 0 : 1; // 0->1 1->0 스위치 위치 바꿔주기
				}
//				System.out.println();
//				for (int k = 1; k < switchState.length; k++) {
//					System.out.print(switchState[k] + " ");
//				}
//				
			} else { // 여학생일 때
				if (sRecive == 1 || sRecive == switchState.length - 1) { // 학생이 가진 스위치가 1번일때와 마지막번일땐 자기 숫자만 변경
					switchState[sRecive] = (switchState[sRecive] == 1) ? 0 : 1; // 0->1 1->0 스위치 위치 바꿔주기
				} else {
					int N = 0;
					while (true) {
						N++;

						if (check(sRecive - N, sRecive + N, switchState.length)
								&& ((switchState[sRecive - N]) == (switchState[sRecive + N]))) {// 경계체크 해주고 좌우 대칭에 있는
																								// 값들이 같을 경우
							if (N == 1) {
								switchState[sRecive] = (switchState[sRecive] == 1) ? 0 : 1;
							}

							switchState[sRecive - N] = (switchState[sRecive - N] == 1) ? 0 : 1;
							switchState[sRecive + N] = (switchState[sRecive + N] == 1) ? 0 : 1;
						} else {
							if (N == 1) { // 현 스위치 위치에서 바로 옆에 좌우 대칭이 다른 경우
								switchState[sRecive] = (switchState[sRecive] == 1) ? 0 : 1; // 0->1 1->0 스위치 위치 바꿔주기
							}
							break;
						}
					}

				}

			}

		} // 출력... 하... 한 줄에 20개씩 출력...ㅋㅋ
		for (int p = 1; p < switchState.length; p++) {
			System.out.print(switchState[p] + " ");
			if (p % 20 == 0) {
				System.out.println();
			}
		}

	}

	private static boolean check(int m, int p, int len) {

		return m >= 1 && p < len;

	}
}
