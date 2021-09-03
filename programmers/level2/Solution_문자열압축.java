package com.programmers2;

//substring 계산과 자리수 계산해주기!!
public class Solution_문자열압축 {
	public static void main(String[] args) {
		solution("aaaaaaaaaakbbbbbbbbbb");
	}

	static int min;

	public static int solution(String s) {
		// 1부터 ~ s반절만큼 계속 짤라준다.
		min = Integer.MAX_VALUE;
		if (s.length() == 1) {
			return 1;
		}
		for (int k = 1; k <= s.length() / 2; k++) {
			int temp = s.length() / k;
			StringBuilder lsb = new StringBuilder();
			String[] sr = new String[temp];
			for (int i = 0; i < temp; i++) {
				sr[i] = s.substring(i * k, i * k + k);
			}
			if ((s.length() % k != 0)) {
				for (int i = k * (s.length() / k); i < s.length(); i++) {
					lsb.append(s.charAt(i));
				}

			}
			int cnt = 1;
			int cntResult = 0;

			StringBuilder sb = new StringBuilder();

			sb.append(sr[0]);
			for (int i = 1; i < sr.length; i++) {
				if (sr[i - 1].equals(sr[i])) {
					cnt++;

					if (i == sr.length - 1 && cnt >= 2) {
						cntResult += (int) (Math.log10(cnt) + 1);
					} else if (cnt == sr.length) {
						cntResult += (int) (Math.log10(cnt) + 1); // ex)100 -> (int)log100 + 1 = 3자리
					}

				} else {
					sb.append(sr[i]);
					if (cnt >= 2) {
						cntResult += (int) (Math.log10(cnt) + 1);
						cnt = 1;
					}
				}
			}
			min = Math.min(min, cntResult + sb.length() + lsb.length());
		}
		System.out.println(min);
		return min;
	}
}
