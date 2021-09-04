package com.codingtest;

import java.util.Arrays;
import java.util.Comparator;

public class Solution_test1 {

	public static void main(String[] args) {
		String[] words = { "qwe", "q", "qwep", "qwzp", "qaz", "pz", "z" };
		solution("qwertyuiopasdfghjklzxcvbnm", words);
	}

	public static String[] solution(String order, String[] words) {
		// order 기준으로 해야잖아
		Arrays.sort(words, new Comparator<String>() { // 0번째 인자에 있는 배열이 첫번째 인자에 있는 comparator 조건에 의해서 정렬 

			@Override
			public int compare(String o1, String o2) { // o1이 기존에 있던 것
				int len = 0;
				if (o1.length() < o2.length()) {
					len = o1.length();
				} else
					len = o2.length();
				
				for (int i = 0; i < len; i++) {

					// o1이 order에 몇번째 들어있는지 o2가 order에 몇번째 들어있는지 비교
					int s1 = order.indexOf(o1.charAt(i));
					int s2 = order.indexOf(o2.charAt(i));

					if (s1 != s2) { // 기존에 있던거에서 새로들어온걸 빼면 오름차순 else 내림차순
						return s1 - s2;
					}
				}
				//4가지 경우 : aa a   a aa  1 -1 리턴하는게 양수면 바뀌고 아니면 안바뀜  
				return o1.length() - o2.length();
			}
		});
		for (int i = 0; i < words.length; i++) {
			System.out.print(words[i]+" ");
		}

		return words;
	}

}
