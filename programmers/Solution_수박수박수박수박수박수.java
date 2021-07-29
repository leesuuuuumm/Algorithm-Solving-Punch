package com.programmers;

public class Solution_수박수박수박수박수박수 {
    public static void main(String[] args) {
    	solution(3);
	}
	public static String solution(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
        	if(i%2==0) sb.append("수");
        	else sb.append("박");
		}
       // System.out.println(sb);
        return sb.toString();
    }
}
