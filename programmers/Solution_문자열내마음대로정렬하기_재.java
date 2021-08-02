package com.programmers;

import java.util.Arrays;

public class Solution_문자열내마음대로정렬하기_재 {

	static int number; //전역변수 조심

	public static void main(String[] args) {
		String str[] = { "abce", "abcd", "cdx" };
		number = 2;	
		solution(str,number);
	}

	public static String[] solution(String[] str, int n) {
		String answer[] = new String[str.length];
		Word word[] = new Word[str.length];
		for (int i = 0; i < word.length; i++) {
			word[i] = new Word(str[i]);
		}
		Arrays.sort(word);
		for (int i = 0; i < word.length; i++) {
			answer[i] = word[i].munja;
			System.out.println(answer[i]);
		}
		
		return answer;
	}
	public static class Word implements Comparable<Word>{ //comparable 조심 (양수를 리턴하면 자리 바뀜)
		String munja;
		public Word(String munja) {
			this.munja = munja;
		}
		@Override
		public int compareTo(Word otherMunja) {
			if(this.munja.charAt(number)!=otherMunja.munja.charAt(number)) {
				return this.munja.charAt(number)-otherMunja.munja.charAt(number);
			}else 
				return this.munja.compareTo(otherMunja.munja);
		}
		
	}


}
