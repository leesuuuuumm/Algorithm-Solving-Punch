package com.programmers2;

public class Solution_다음큰숫자 {

	public int solution(int n) {
		int nCnt = Integer.bitCount(n); // num 숫자를 binary로 변환후, 1의 수를 반환
		int k = n;
		while (true) {
			if (Integer.bitCount(++k) == nCnt)
				break;
		}

		// System.out.println(k);
		return k;
	}
}
