package com.programmers2;

import java.util.*;

public class Solution_가장큰수_comparator {

	public static void main(String[] args) {
		int numbers[] = { 3, 30, 34, 5, 9 };
		solution(numbers);
	}

	public static String solution(int[] numbers) {
		String[] str = new String[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			str[i] = String.valueOf(numbers[i]);

		}
		Arrays.sort(str, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// System.out.println((o2 + o1)+" "+(o1 + o2)+" "+((o2 + o1).compareTo(o1 +
				// o2)));

				return (o2 + o1).compareTo(o1 + o2); // 더 큰 수로 조합을 만들게 하는 것!(compareTo_test참고)
			}
		});
		if (str[0].equals("0")) { // 정수형으로 변환한 이유가 000처리 때문이였지만, str[0]값 자체 확인하고 비교하면 에러 안나고 잘 돌아간다!
			return "0";
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length; i++) {
			sb.append(str[i]);
		}
		// long num = Long.parseLong(sb.toString()); //다시 정수형으로 변환시키니깐 런타임 에러났다..

		return sb.toString();

	}
}
