package com.programmers2;

import java.util.*;

public class Solution_위장 {
	// HashMap
	public int solution(String[][] clothes) {
		int answer = 1;
		HashMap<String, Integer> clothoesHm = new HashMap<String, Integer>();
		for (int i = 0; i < clothes.length; i++) {
			clothoesHm.put(clothes[i][1], clothoesHm.getOrDefault(clothes[i][1], 0) + 1);
		}
		// System.out.println(clothoesHm);

		for (String key : clothoesHm.keySet()) {
			answer *= clothoesHm.get(key) + 1;
			// System.out.println(val);
		}
		return answer - 1;
	}
}
