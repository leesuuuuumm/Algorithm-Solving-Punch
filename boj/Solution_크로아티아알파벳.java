package net.acmicpc;

import java.util.Scanner;

public class Solution_크로아티아알파벳 {
	static String cro[] = { "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=" };

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String st = scan.next();
		for (int i = 0; i < cro.length; i++) {
			if (st.contains(cro[i])) {
				st = st.replace(cro[i], "z");
			}
		}
		System.out.println(st.length());
	}
}
