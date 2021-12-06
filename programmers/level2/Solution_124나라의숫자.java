package com.programmers2;

public class Solution_124나라의숫자 {

	public static void main(String args[]) {
		System.out.println(solution(500000000));

	}

	public static String solution(int n) {
		String answer  = " ";
		String num[] = {"4","1","2"};
		int namoge = 0;
		while(n>0) {
			namoge = n%3;
			n /=3; 
			
			if(namoge == 0) n-=1;
			
			answer = num[namoge]+answer;
		}
		return answer;
		

	}

}
