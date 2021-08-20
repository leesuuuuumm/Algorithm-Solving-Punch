package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_1213_팰린드롬만들기{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1 = br.readLine();
		char crr[] = s1.toCharArray();
		char answer[] = new char[s1.length()];
		char copy[] = new char[answer.length];
		int j = 0;
		Arrays.sort(crr);
		if (s1.length() == 1 || crr[0] == crr[crr.length - 1]) {
			System.out.println(s1);
			return;
		}
		for (int i = 0; i < crr.length - 1; i++) {
			if (crr[i] == crr[i + 1]) {
				answer[j] = crr[i];
				answer[crr.length - 1 - j] = crr[i];
				j++;
				i = i + 1;
				if (i == crr.length - 2) {
					answer[crr.length / 2] = crr[i + 1];
				}
			} else {
				answer[crr.length / 2] = crr[i];
			}
		}
		System.out.println(answer);

		for (int i = 0; i < answer.length; i++) {
			copy[i] = answer[i];
		}
		Arrays.sort(copy);
		int count = 0;
		for (int i = 0; i < copy.length; i++) {
			if (crr[i] == copy[i]) {
				count++;
			}
		}

		System.out.println(count);
		if (count == answer.length) {
			for (int i = 0; i < answer.length; i++) {
				System.out.print(answer[i]);
			}
		} else {
			System.out.print("I'm Sorry Hansoo");
		}

	}
}
