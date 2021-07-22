package com.programmers;

import java.util.Scanner;

// a:97 A:65 space:32 
// %26...으로 간단하게 풀 수 있었다... 이런 바보...
// isLowerCase / isUpperCase 로 대소문자 판별 가능
// stringBuilder로도 가능 ....
public class Solution_시저암호 {
	public static void main(String[] args) {

		String s = "a B z";
		int n = 25;
		solution(s, n);
	}

	public static String solution(String s, int n) {
		String answer = "";
		char charArray[] = s.toCharArray();
		for (int i = 0; i < charArray.length; i++) {

			if (charArray[i] == ' ') {
				charArray[i] = ' ';
			} else {
				if (charArray[i] >= 'A' && charArray[i] <= 'Z') {
					charArray[i] += n;
					if (charArray[i] < 'A' || charArray[i] > 'Z') {
						charArray[i] -= 26;
					}
				} else if (charArray[i] >= 'a' && charArray[i] <= 'z') {
					charArray[i] += n;
					if (charArray[i] < 'a' || charArray[i] > 'z') {
						charArray[i] -= 26;
					}
				}
			}
		}
		answer = String.valueOf(charArray);
		System.out.println(answer);
		return answer;
	}
}
