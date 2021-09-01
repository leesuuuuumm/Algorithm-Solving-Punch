package com.programmers;

import java.util.Arrays;

import java.util.Scanner;

public class Solution_문자열내림차순으로배치하기 {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String s = scan.next();
		solution(s);
	}

	public static String solution(String s) {

		char ch[] = s.toCharArray();
		StringBuilder sb = new StringBuilder();

		int arr[] = new int[ch.length];

		for (int i = 0; i < ch.length; i++) {
			arr[i] = ch[i] - '0';
		}
		Arrays.sort(arr);
		for (int i = arr.length-1; i >=0 ; i--) {
			ch[i] = (char) ((char)arr[i]+'0');
			sb.append(ch[i]);
		}
		System.out.println(sb);

		return sb.toString();

	}
}
