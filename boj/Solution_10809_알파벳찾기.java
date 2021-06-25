package com.ssafy;

import java.util.Scanner;
 
public class Solution_10809_알파벳찾기 {

	public static void main(String[] args) {
	
		Scanner scan=new Scanner(System.in);
		
		String s=scan.next();
		char crr[]=new char[s.length()];
		int arr[]=new int[26];
		crr=s.toCharArray();
		for (int i = 0; i <26; i++) {
			
			b:for (int j = 0; j <crr.length; j++) {
				if(crr[j]==('a'+i)) {
					arr[i]=j;
					break b;
				}
				else {
					arr[i]=-1;
				}
			}
			
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
	}
}
