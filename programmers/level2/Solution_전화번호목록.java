package com.programmers2;

import java.util.*;

public class Solution_전화번호목록 {

	public static void main(String[] args) {
		String p[] = { "12","123", "1235","567", "88"};
		solution(p);
	}

	public static boolean solution(String[] phone_book) {
		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < phone_book.length; i++) {
			map.put(phone_book[i],i);
		}
		for(int i=0;i<phone_book.length;i++) {
			for(int j=1;j<phone_book[i].length();j++) {
				if(map.containsKey(phone_book[i].substring(0,j))) {
					System.out.println("false");	
					return false;
				}
			}
		}
		return true;
	}
}
