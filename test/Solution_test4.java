package com.codingtest;

import java.util.*;

public class Solution_test4 {
	static class InterestRate implements Comparable<InterestRate> {
		String goodsName;
		int rate;

		public InterestRate(String goodsName, int rate) {
			this.goodsName = goodsName;
			this.rate = rate;

		}

		public int compareTo(InterestRate o) {
			// rate 순이 더 큰게 앞으로 가기
			// rate가 같을 경우 goodsName이 사전순으로 빠른거가 앞으로 가기
			if (this.rate == o.rate) {
				return this.goodsName.compareTo(o.goodsName);
			}

			return Integer.compare(o.rate, this.rate);

		}

	}

	public static void main(String[] args) {
//		String[] savings = { "a 7 3 3 500000 500000", "b 8 2 1 300000 300000" };
//		String[] transactions = { "2022 1 -500000", "2022 1 500000", "2022 2 -100000", "2022 2 -400000",
//				"2022 2 100000", "2022 2 200000", "2022 2 200000" };
//		
//		String[] savings = { "a 7 3 1 500000 500000", "b 8 2 1 300000 300000" };
//		String[] transactions = { "2022 1 -500000", "2022 1 500000", "2022 2 -100000", "2022 2 -400000",
//				"2022 2 100000", "2022 2 200000", "2022 2 200000" };
		
		String[] savings = { "a 7 3 1 500000 500000", "b 8 2 1 300000 300000", "sumin 10 2 3 500000 300000" };
		String[] transactions = { "2020 4 500000","2020 4 300000","2020 3 500000","2020 3 300000","2020 5 500000","2020 5 300000","2022 1 -500000", "2022 1 500000", "2022 2 -100000", "2022 2 -400000",
				"2022 2 100000", "2022 2 200000", "2022 2 200000" };
		solution(savings, transactions);
	}

	private static void solution(String[] saving, String[] transaction) {

		// 2020월 1부터 2022년 2월까지 입금 출금 배열에 넣어주기
		long[] depositArr = new long[27]; // 입금
		long[] withdrawArr = new long[27]; // 출금

		for (int i = 0; i < transaction.length; i++) {
			String[] str = transaction[i].split(" ");
			if (str[0].equals("2020")) {
				if (Integer.parseInt(str[2]) > 0) { // 입금
					depositArr[Integer.parseInt(str[1])] += Integer.parseInt(str[2]);
				} else {
					withdrawArr[Integer.parseInt(str[1])] += Math.abs(Integer.parseInt(str[2]));
				}
			} else if (str[0].equals("2021")) {
				if (Integer.parseInt(str[2]) > 0) { // 입금
					depositArr[Integer.parseInt(str[1]) + 12] += Integer.parseInt(str[2]);
				} else {
					withdrawArr[Integer.parseInt(str[1]) + 12] += Math.abs(Integer.parseInt(str[2]));
				}
			} else if (str[0].equals("2022")) {
				if (Integer.parseInt(str[2]) > 0) { // 입금

					depositArr[Integer.parseInt(str[1]) + 24] += Integer.parseInt(str[2]);
				} else {

					withdrawArr[Integer.parseInt(str[1]) + 24] += Math.abs(Integer.parseInt(str[2]));
				}
			}
		}

//		System.out.println(Arrays.toString(depositArr));
//		System.out.println(Arrays.toString(withdrawArr));

		// saving 돌면서 값이 우대금리 조건에 부합하면 pq에 우대 금리+ 일반금리 넣어주고 그렇지 않을 경우에는 일반금리 넣어주기!

		PriorityQueue<InterestRate> pq = new PriorityQueue<>();

		for (int i = 0; i < saving.length; i++) {
			String[] str = saving[i].split(" "); // 0 적금이름 1기본금리 2 우대금리 3 달수 4 입금 5 출금
			boolean flag = false;
			e: for (int j = 1; j < 27 - Integer.parseInt(str[3]); j++) {
				int cnt = 0;

				for (int k = j; k < j + Integer.parseInt(str[3]); k++) {
					if (depositArr[k] < Integer.parseInt(str[4]) && withdrawArr[k] < Integer.parseInt(str[5])) {
						break;
					}
					cnt++;
				}
				if (cnt == Integer.parseInt(str[3])) {
					pq.offer(new InterestRate(str[0], Integer.parseInt(str[1]) + Integer.parseInt(str[2]))); // 우대금리+기본금리
					flag = true;
					break e;
				}
			}
			if (!flag) {
				pq.offer(new InterestRate(str[0], Integer.parseInt(str[1]))); // 기본 금리만 넣어주기 (이경우는 기본 금리가 더 높을 수가 있으니깐)
			}
		}
		System.out.println(pq.poll().goodsName);

	}

}
