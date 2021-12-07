package com.programmers2;

import java.util.*;

public class Solution_기능개발 {

	public static void main(String[] args) {
		int[] progresses = { 95, 90, 99, 99, 80, 99 };
		int[] speeds = { 1, 1, 1, 1, 1, 1 };
		solution(progresses, speeds);
	}

	public static int[] solution(int[] progresses, int[] speeds) {
		Queue<Integer> que = new LinkedList<Integer>();
		ArrayList<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i < speeds.length; i++) {
			int k = 100 - progresses[i];
			if (k % speeds[i] == 0)
				que.offer(k / speeds[i]);
			else {
				que.offer((k / speeds[i]) + 1);
			}
		}
		int queNum = que.poll();
		int dayCount = 1;
		while (!que.isEmpty()) {
			if (queNum >= que.peek()) {
				que.poll();
				dayCount++;
				if (que.size() == 0)
					list.add(dayCount);
			} else {
				list.add(dayCount);
				dayCount = 1;
				queNum = que.poll();
				if (que.size() == 0)
					list.add(dayCount);
			}
		}
		int[] answer = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
			System.out.print(answer[i] + " ");
		}
		return answer;
	}
}
