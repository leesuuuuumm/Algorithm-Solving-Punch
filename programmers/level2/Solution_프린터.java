package com.programmers2;

import java.util.*;

public class Solution_프린터 {
	public static void main(String[] args) {
		int[] priorities = { 1, 1, 9, 1, 1, 1 };
		int location = 0;
		solution(priorities, location);
	}

	private static int solution(int[] priorities, int location) {
		ArrayList<Integer> aList = new ArrayList<Integer>(); // 움직여야 할 priorities의 값들
		int[] priLast = new int[priorities.length]; // 최종적으로 priorities의 위치값이 담길 값들
		Queue<int[]> que = new LinkedList<int[]>();
		for (int i = 0; i < priorities.length; i++) {
			aList.add(priorities[i]);
			que.offer(new int[] { i, aList.get(i) });
		}
		int tmp = 0;
		while (!que.isEmpty()) {
			boolean flag = false;
			a: for (int i = 1; i < aList.size(); i++) {
				if (aList.get(0) < aList.get(i)) { // 자신보다 큰 값이 있으면
					int[] curr = que.poll();
					que.offer(new int[] { curr[0], curr[1] });
					int k = aList.get(0);
					aList.remove(0);
					aList.add(k);
//					for (int j = 0; j < aList.size(); j++) {
//						System.out.print(aList.get(j));
//					}
//					System.out.println();
					flag = true;
					break a;
				}
			}
			if (!flag) {
				int[] curL = que.poll();
				priLast[tmp++] = curL[0];
				aList.remove(0);
			}
		}
		int answer = 0;
		for (int i = 0; i < priLast.length; i++) {
			if (location == priLast[i]) {
				System.out.println(i + 1);
				answer = i + 1;
			}

		}

		return answer;
	}

}
